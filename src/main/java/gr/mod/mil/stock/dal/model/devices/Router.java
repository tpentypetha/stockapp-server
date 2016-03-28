package gr.mod.mil.stock.dal.model.devices;

public class Router {

    private boolean supportsVdsl;
    public boolean getSupportsVdsl() { return supportsVdsl; }
    public void setSupportsVdsl(boolean supportsVdsl) { this.supportsVdsl = supportsVdsl; }

    private boolean wireless;
    public boolean getWireless() { return wireless; }
    public void setWireless(boolean wireless) { this.wireless = wireless; }

    private int numLans;
    public int getNumLans() { return numLans; }
    public void setNumLans(int numLans) { this.numLans = numLans; }

}
