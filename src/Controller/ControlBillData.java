
package Controller;

import java.util.Date;

public class ControlBillData {
    
    private final String invid;
    private final String medid;
    private final String medname;
    private final String cusname;
    private final double price;
    private final int quantityout;
    private final double totalamount;
    private final double payment;
    private final Date invdate;
    
    public ControlBillData(String invid, String medid, String medname, String cusname, double price, int quantityout, double totalamount, double payment, Date invdate) {
        
        this.invid = invid;
        this.medid = medid;
        this.medname = medname;
        this.cusname = cusname;
        this.price = price;
        this.quantityout = quantityout;
        this.totalamount = totalamount;
        this.payment = payment;
        this.invdate = invdate;
        
    }
    
     public String getinvid() {
        return invid;
    }

    public String getmedid() {
        return medid;
    }

    public String getmedname() {
        return medname;
    }

    public String getcusname() {
        return cusname;
    }

    public double getprice() {
        return price;
    }
    public int getquantityout() {
        return quantityout;
    }
    public double gettotalamount() {
        return totalamount;
    }
    public double getpayment() {
        return payment;
    }
    public Date getinvdate() {
        return invdate;
    }
}

