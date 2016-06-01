package gr.mod.mil.stock.web.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GenericDateRangeDTO {

    private String from;
    private String to;
    private String quantity1;
    private String quantity2;
    private String quantity3;

    public String getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(String quantity1) {
        this.quantity1 = quantity1;
    }

    public String getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(String quantity2) {
        this.quantity2 = quantity2;
    }

    public String getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(String quantity3) {
        this.quantity3 = quantity3;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getFromDate(){ return parse(from); }
    public Date getToDate() { return parse(to); }

    private Date parse(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);
        Date out = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return out;
    }

    public static GenericDateRangeDTO createDateRange(String from, String to) {
        GenericDateRangeDTO dto = new GenericDateRangeDTO();
        dto.setFrom(from);
        dto.setTo(to);
        return dto;
    }

    public boolean isValid() { return from != null && to != null; }

}
