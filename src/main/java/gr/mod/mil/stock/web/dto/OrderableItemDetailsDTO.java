package gr.mod.mil.stock.web.dto;

public class OrderableItemDetailsDTO {

    private String title;
    private String category;
    private String currentSupply;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrentSupply() {
        return currentSupply;
    }

    public void setCurrentSupply(String currentSupply) {
        this.currentSupply = currentSupply;
    }

    public static OrderableItemDetailsDTO getDetailsFor(String title, String category, String currentSupply){
        OrderableItemDetailsDTO dto = new OrderableItemDetailsDTO();
        dto.setTitle(title);
        dto.setCategory(category);
        dto.setCurrentSupply(currentSupply);
        return dto;
    }
}
