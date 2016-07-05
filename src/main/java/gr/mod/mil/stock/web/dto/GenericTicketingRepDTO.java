package gr.mod.mil.stock.web.dto;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GenericTicketingRepDTO {

    private String from;
    private String to;
    private String officetxt;
    private String phonetxt;

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

    public String getOfficetxt() {
        return officetxt;
    }

    public void setOfficetxt(String officetxt) {
        this.officetxt = officetxt;
    }

    public String getPhonetxt() {
        return phonetxt;
    }

    public void setPhonetxt(String phonetxt) {
        this.phonetxt = phonetxt;
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
}
