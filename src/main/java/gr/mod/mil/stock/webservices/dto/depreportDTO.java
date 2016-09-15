package gr.mod.mil.stock.webservices.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Ilias on 13/7/2016.
 */
public class DepreportDTO {

    private String from;
    private String to;
    private String dept_desc;

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

    public String getDept_desc() {
        return dept_desc;
    }

    public void setDept_desc(String dept_desc) {
        this.dept_desc = dept_desc;
    }

    public Date getFromDate(){ return parse(from); }
    public Date getToDate() { return parse(to); }

    private Date parse(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);
        Date out = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return out;
    }


}
