
package Controller;


import javax.swing.*;
import Model.ModelMedicine;
import View.medicine;

public class ControlMedicine {
    private final medicine View;
    private final ModelMedicine Model;
    
    public ControlMedicine(medicine View, ModelMedicine Model) {
        this.View = View;
        this.Model = Model;
    }
        
        public void saveMedicineToDatabase(String supid, String medid, String medname, int quantity, double ppu) {
        boolean isSuccess = Model.saveMedicine(supid,medid,medname,quantity,ppu);
        
        if (isSuccess) {
            View.displayMessage("Supplier Saved successfully.");
            View.addToMedicineList(supid,medid,medname,quantity,ppu);

            // Clear the input fields after successful insertion
            View.takeID();
            View.clearInputFields();
        } else {
            View.displayMessage("Failed to save.");
        }
    }
       
    
       public void deleteSupplier(String medid) {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean deletionSuccessful = Model.deleteMedicine(medid);

            if (deletionSuccessful) {
                // Notify the view or handle success as needed
                JOptionPane.showMessageDialog(null, "Medicine deleted successfully.");
                  View.takeID();
                  View.clearInputFields();
            } else {
                // Notify the view or handle failure as needed
                JOptionPane.showMessageDialog(null, "Failed to delete from the database.");
            }
        }
    }
       public void updateSupplier(int selectedRow, String supid, String medid, String medname,double ppu) {
        int confirm = JOptionPane.showConfirmDialog(View, "Are you sure you want to update this Medicine?", "Confirm Update", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = Model.updateMedicine(supid,medid,medname,ppu);
            if (success) {
                // Update the view or show a success message
                View.updateSupplierRow(selectedRow, supid,medid,medname,ppu);
                JOptionPane.showMessageDialog(View, "Medicine updated successfully.");
                  View.takeID();
                  View.clearInputFields();
            } else {
                JOptionPane.showMessageDialog(View, "Failed to update");
            }
        }
    }   
}

