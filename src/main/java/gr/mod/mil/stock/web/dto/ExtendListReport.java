package gr.mod.mil.stock.web.dto;

import java.util.List;

/**
 * Created by Ilias on 14/7/2016.
 */
public class ExtendListReport {

    private String depname;
    private List<ExtendedReport> list;

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public List<ExtendedReport> getList() {
        return list;
    }

    public void setList(List<ExtendedReport> list) {
        this.list = list;
    }
}
