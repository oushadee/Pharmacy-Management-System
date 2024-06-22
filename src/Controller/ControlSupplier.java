
package Controller;

import javax.swing.*;
import Model.ModelSupplier;
import View.supplier;

public class ControlSupplier {
    private final supplier View;
    private final ModelSupplier Model;
    
    public ControlSupplier(supplier View, ModelSupplier Model) {
        this.View = View;
        this.Model = Model;
    }
        
        public void saveSupplierToDatabase(String supid, String supname, String supaddress, int suptp) {
        boolean isSuccess = Model.saveSupplier(supid,supname,supaddress,suptp);
        
        if (isSuccess) {
            View.displayMessage("Supplier Saved successfully.");
            View.addToSupplierList(supid,supname,supaddress,suptp);

            // Clear the input fields after successful insertion
            View.takeID();
            View.clearInputFields();
        } else {
            View.displayMessage("Failed to save.");
        }
    }
       
    
       public void deleteSupplier(String supid) {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean deletionSuccessful = Model.deleteSupplier(supid);

            if (deletionSuccessful) {
                // Notify the view or handle success as needed
                JOptionPane.showMessageDialog(null, "Supplier deleted successfully.");
                  View.takeID();
                  View.clearInputFields();
            } else {
                // Notify the view or handle failure as needed
                JOptionPane.showMessageDialog(null, "Failed to delete from the database.");
            }
        }
    }
       public void updateSupplier(int selectedRow, String supid, String supname, String supaddress,int suptp) {
        int confirm = JOptionPane.showConfirmDialog(View, "Are you sure you want to update this Supplier?", "Confirm Update", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = Model.updateSupplier(supid,supname,supaddress,suptp);
            if (success) {
                // Update the view or show a success message
                View.updateSupplierRow(selectedRow, supid,supname,supaddress,suptp);
                JOptionPane.showMessageDialog(View, "Supplier updated successfully.");
                  View.takeID();
                  View.clearInputFields();
            } else {
                JOptionPane.showMessageDialog(View, "Failed to update");
            }
        }
    }   
}

