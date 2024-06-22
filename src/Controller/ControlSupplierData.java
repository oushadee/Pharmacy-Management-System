
package Controller;


public class ControlSupplierData {
    private final String supid;
    private final String supname;
    private final String supaddress;
    private final int suptp;
    
   public ControlSupplierData(String supid, String supname, String supaddress, int suptp) {
        this.supid = supid;
        this.supname = supname;
        this.supaddress = supaddress;
        this.suptp = suptp;
         
    }
   public String getsupid() {
        return supid;
    }

    public String getsupname() {
        return supname;
    }

    public String getsupaddress() {
        return supaddress;
    }
    public int getsuptp() {
        return suptp;
    }
}
