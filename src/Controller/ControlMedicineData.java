
package Controller;

public class ControlMedicineData {
    private final String supid;
    private final String medid;
    private final String medname;
    private final int quantity;
    private final double ppu;
    
    public ControlMedicineData(String supid, String medid, String medname, int quantity, double ppu) {
        this.supid = supid;
        this.medid = medid;
        this.medname = medname;
        this.quantity = quantity;
        this.ppu = ppu;
    }
    
    public String getsupid() {
        return supid;
    }

    public String getmedid() {
        return medid;
    }

    public String getmedname() {
        return medname;
    }
    public int getquantity() {
        return quantity;
    }
    public double getppu() {
        return ppu;
    }
}
