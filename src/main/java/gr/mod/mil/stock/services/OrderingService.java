package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.OrderHistory;
import gr.mod.mil.stock.dal.model.OrderedItem;
import gr.mod.mil.stock.dal.repos.OrderHistoryRepository;
import gr.mod.mil.stock.dal.repos.OrderedItemRepository;
import gr.mod.mil.stock.ordering.Order;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.printing.PDFPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderingService {

    @Autowired
    Order order;

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Autowired
    OrderedItemRepository orderedItemRepository;

    private OrderHistory getOrderHistory(Order order){
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setPublicid(UUID.randomUUID().toString());
        orderHistory.setWhen(new Date());
        order.getItems().forEach((key, amount) -> {
            OrderedItem item = OrderedItem.getItemFrom(key.getOrderableTitle(), key.getCategory().toString());
            item.setFinalAmount(amount);
            orderHistory.getItems().add(item);
        });
        return orderHistory;
    }

    public byte[] printOrderHistory(OrderHistory history) throws OrderPrintingException{
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDFont font = PDType1Font.COURIER;

        try {
            PDPageContentStream stream = new PDPageContentStream(document, page);
            stream.beginText();
            stream.moveTextPositionByAmount(50,750);
            stream.setFont(font, 18);
            stream.setLeading(20);
            stream.showText("Order " + history.getWhen().toString());
            stream.newLine();
            stream.newLine();
            stream.showText("Items:");
            stream.newLine();
            stream.showText("------------------------------------");
            stream.newLine();
            stream.newLine();
            int index = 1;
            for(OrderedItem item : history.getItems()){
                stream.showText(index++ + "  " +item.getOrderableTitle() + " " + item.getCategory() + " x" + item.getFinalAmount());
                stream.newLine();
            }
            stream.endText();
            stream.close();


            OutputStream out = new ByteArrayOutputStream();
            document.save(out);
            document.close();
            return ((ByteArrayOutputStream)out).toByteArray();

        } catch(IOException e) {
            throw new OrderPrintingException();
        }

    }

    public OrderHistory saveCurrentOrder(){
        OrderHistory history = getOrderHistory(order);
        for(OrderedItem item: history.getItems()){
            orderedItemRepository.save(item);
        }

        OrderHistory saved = orderHistoryRepository.save(history);
        order.clear();
        return saved;
    }

    public class OrderPrintingException extends RuntimeException {
        public OrderPrintingException() {
            super("Could not print order.");
        }
    }

}
