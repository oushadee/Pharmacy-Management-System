
package View;

import Controller.ControlSupplier;
import Controller.ControlSupplierData;
import Controller.PhoneNumberTextFieldKeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.ModelSupplier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;



public class supplier extends javax.swing.JFrame {

private final ControlSupplier controller;
    public supplier() {
        initComponents();
        suptp.addKeyListener(new PhoneNumberTextFieldKeyListener());
        String productId = takesupID();
        supid.setText(productId);
        displayExistingMedicineData();
        supname.requestFocus();
        ModelSupplier model = new ModelSupplier();
        controller = new ControlSupplier(this, model);
    }

   
    public void clearInputFields() {
    takesupID();
    supname.setText("");
    supaddress.setText("");
    suptp.setText("");
    }
    
    public static String takesupID()
    {
        String prefix = "SUP";

        try {
            // Load the JDBC driver (this is specific to MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // JDBC URL, username, and password of MySQL server
            String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "";

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                // Create a statement
                Statement statement = connection.createStatement();

                // Execute the query to find the last proid
                String lastIdQuery = "SELECT supid FROM Supplier ORDER BY supid DESC LIMIT 1";
                ResultSet resultSet = statement.executeQuery(lastIdQuery);

                // Retrieve the last ID
                String lastId = null;
                if (resultSet.next()) {
                    lastId = resultSet.getString("supid");
                }

                // Generate the new ID
                String newId;
                if (lastId == null) {
                    // If no existing ID, start with "001"
                    newId = prefix + "001";
                } else {
                    // Extract the numeric part and increment
                    int numericPart = Integer.parseInt(lastId.substring(prefix.length()));
                    numericPart++;
                    // Format the numeric part to have leading zeros
                    String formattedNumericPart = String.format("%03d", numericPart);
                    newId = prefix + formattedNumericPart;
                }

                return newId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Return a default ID if an error occurs
        return prefix + "001";
    }
    public void updateSupplierRow(int selectedRow, String supid,String supname,String supaddress,int suptp) {
        DefaultTableModel tableModel = (DefaultTableModel) SupplierTable.getModel();
        tableModel.setValueAt(supid, selectedRow, 0);
        tableModel.setValueAt(supname, selectedRow, 1);
        tableModel.setValueAt(supaddress, selectedRow, 2);
        tableModel.setValueAt(suptp, selectedRow, 3);
       
    }
    public void takeID()
    {
        String newId = takesupID();
        supid.setText(newId);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        supid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        supname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        suptp = new javax.swing.JTextField();
        supaddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupplierTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supplier");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(40, 29, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Suppliers");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        Exit2.setBackground(new java.awt.Color(204, 0, 0));
        Exit2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Exit2.setForeground(new java.awt.Color(255, 255, 255));
        Exit2.setText("X");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });
        jPanel2.add(Exit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 795, 91));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Supplier Id");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        supid.setEditable(false);
        supid.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(supid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 252, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Supplier Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 130, -1));
        jPanel3.add(supname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 250, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Phone Number");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        suptp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suptpActionPerformed(evt);
            }
        });
        jPanel3.add(suptp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 240, -1));
        jPanel3.add(supaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 70, 240, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Address");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 120, -1));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 120, -1));

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 120, -1));

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        SupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Supplier Id", "Name", "Address", "Phone number"
            }
        ));
        SupplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SupplierTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 337, 800, 310));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 90, 800, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void suptpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suptpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suptpActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        dispose(); 
                    dashboard newForm = new dashboard();

                    // Set the behavior of the new form (e.g., default close operation)
                    newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    // Display the new form
                    newForm.pack();
                    newForm.setVisible(true);
    }//GEN-LAST:event_Exit2ActionPerformed

    private void SupplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierTableMouseClicked
        int selectedRow = SupplierTable.getSelectedRow();
    if (selectedRow != -1) {
        // A row is selected, so you can retrieve the data from the selected row
        DefaultTableModel tableModel = (DefaultTableModel) SupplierTable.getModel();
        String supids = (String) tableModel.getValueAt(selectedRow, 0);
        String supnames = (String) tableModel.getValueAt(selectedRow, 1);
        String supaddresss = (String) tableModel.getValueAt(selectedRow, 2);
        Object quantityObj = tableModel.getValueAt(selectedRow, 3);
        String suptps = (quantityObj != null) ? String.valueOf(quantityObj) : "";
    

        // Populate the text fields and combo box with the selected car's data
        supid.setText(supids);
        supname.setText(supnames);
        supaddress.setText(String.valueOf(supaddresss));
        suptp.setText(String.valueOf(suptps));
        
        // You can also enable the "Update" and "Delete" buttons here if needed
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
    }//GEN-LAST:event_SupplierTableMouseClicked
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String supids = (String) supid.getText().trim();
        String supnames = supname.getText().trim();
        String supaddresss = supaddress.getText().trim();
        String suptps = suptp.getText().trim();
        
        

    if (supids == null) {
        
        displayMessage("Please Select Supplier ID! ");
        return;
        
    }
  
    if (supnames.isEmpty()) {
        
       
        displayMessage("Please enter Supplier Name! ");
        return;
        
    }

    
    if (supaddresss.isEmpty()) {
        
      
        displayMessage("Please Enter Supplier Address! ");
        return;
    }
    if (suptps.isEmpty()) {
        
      
        displayMessage("Please Enter Supplier Contact Number! ");
        return;
    }

  

        int suptpss = Integer.parseInt(suptps);
        controller.saveSupplierToDatabase(supids,supnames,supaddresss,suptpss);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearInputFields();
        takeID();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int selectedRow = SupplierTable.getSelectedRow();
        if (selectedRow != -1) {
            String supids = supid.getText();
            String supnames = supname.getText();
            String supaddresss = supaddress.getText();
            int suptps = Integer.parseInt(suptp.getText());
            
            
            controller.updateSupplier(selectedRow,supids,supnames,supaddresss,suptps);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Supplier to update.");
        }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = SupplierTable.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) SupplierTable.getModel();
            String supids = (String) tableModel.getValueAt(selectedRow, 0); // Assuming carRegistration is in the first column

            // Call the controller to delete the car
            controller.deleteSupplier(supids);
            
            // Remove the selected row from the table (optional)
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Supplier to delete.");
        }       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(30);
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened
    private void displayExistingMedicineData() {
    ModelSupplier mpro = new ModelSupplier();
    List<ControlSupplierData> SupplierDataList = mpro.getAllSupplierData();

    DefaultTableModel tableModel = (DefaultTableModel) SupplierTable.getModel();
    tableModel.setRowCount(0); // Clear existing rows

    for (ControlSupplierData Data : SupplierDataList) {
        tableModel.addRow(new Object[]{Data.getsupid(), Data.getsupname(), Data.getsupaddress(), Data.getsuptp()});
    }
   }
    public void addToSupplierList(String supid, String supname, String supaddress, int suptp) {
        DefaultTableModel tableModel = (DefaultTableModel) SupplierTable.getModel();
        tableModel.addRow(new Object[]{supid,supname,supaddress,suptp});
    }
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit2;
    private javax.swing.JTable SupplierTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField supaddress;
    private javax.swing.JTextField supid;
    private javax.swing.JTextField supname;
    private javax.swing.JTextField suptp;
    // End of variables declaration//GEN-END:variables
}
