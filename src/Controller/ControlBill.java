package Controller;

import javax.swing.*;
import Model.ModelBill;
import View.Billingprocess;
import java.util.Date;

public class ControlBill {
    private final Billingprocess View;
    private final ModelBill Model;
    
    public ControlBill(Billingprocess View, ModelBill Model) {
        this.View = View;
        this.Model = Model;
    }
    
    public void saveBillToDatabase(String invid, String medid, String medname, String cusname, double price, int quantityout, double totalamount, double payment, Date invdate) {
        boolean isSuccess = Model.saveBill(invid,medid,medname,cusname,price,quantityout,totalamount,payment,invdate);
        
        if (isSuccess) {
            View.displayMessage("Bill Placed successfully.");
            View.addToOrderList(invid,medid,medname,cusname,price,quantityout,totalamount,payment,invdate);
            // Clear the input fields after successful insertion
            View.takeOrderID();
           
            View.clearInputFields();
        } else {
            View.displayMessage("Failed to Place the Bill.");
        }
    }
       
    
       public void deleteBill(String invid) {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean deletionSuccessful = Model.deleteBill(invid);

            if (deletionSuccessful) {
                // Notify the view or handle success as needed
                JOptionPane.showMessageDialog(null, "Bill deleted successfully.");
                  View.Productu();
                  View.takeOrderID();
                  View.clearInputFields();
            } else {
                // Notify the view or handle failure as needed
                JOptionPane.showMessageDialog(null, "Failed to delete from the database.");
            }
        }
    }
}
