
package View;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.ModelMedicine;
import Controller.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


public class medicine extends javax.swing.JFrame {

private final ControlMedicine controller;
    public medicine() {
        initComponents();
        loadSupplierID();
        loadItemsFromDatabase();
        Quantity.addKeyListener(new NumericTextFieldKeyListener());
        PricePerUnit.addKeyListener(new NumericTextFieldKeyListener());
        String productId = takemedID();
        MedicineId.setText(productId);
        displayExistingMedicineData();
        SupplierId.requestFocus();
        ModelMedicine model = new ModelMedicine();
        controller = new ControlMedicine(this, model);
       
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Exit3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Quantity = new javax.swing.JTextField();
        PricePerUnit = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        MedicineId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicinetable = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        SupplierId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicine");
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
        jLabel1.setText("Medicines");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        Exit3.setBackground(new java.awt.Color(204, 0, 0));
        Exit3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Exit3.setForeground(new java.awt.Color(255, 255, 255));
        Exit3.setText("X");
        Exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit3ActionPerformed(evt);
            }
        });
        jPanel2.add(Exit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 239, -1));

        PricePerUnit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(PricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 239, -1));

        clear.setBackground(new java.awt.Color(102, 102, 255));
        clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear data");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel3.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 340, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        insert.setBackground(new java.awt.Color(102, 102, 255));
        insert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        insert.setForeground(new java.awt.Color(255, 255, 255));
        insert.setText("Insert");
        insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertMouseClicked(evt);
            }
        });
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel3.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 140, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Price Per Unit");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 239, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Medicine Id");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        MedicineId.setEditable(false);
        MedicineId.setBackground(new java.awt.Color(255, 255, 255));
        MedicineId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(MedicineId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 239, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Supplier Id");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        update.setBackground(new java.awt.Color(102, 102, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Medicine Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        medicinetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "supplier id", "medicine id", "name", "quantity", "cost per unit"
            }
        ));
        medicinetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicinetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicinetable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 850, 310));

        delete.setBackground(new java.awt.Color(102, 102, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 140, -1));

        jPanel3.add(SupplierId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 240, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 850, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadItemsFromDatabase()
    {
        loadSupplierID();
    }
    public void clearInputFields() {
    takemedID();
    SupplierId.setSelectedIndex(-1);
    Name.setText("");
    Quantity.setText("");
    PricePerUnit.setText("");
    }
    public static String takemedID()
    {
        String prefix = "MED";

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
                String lastIdQuery = "SELECT medid FROM Medicine ORDER BY medid DESC LIMIT 1";
                ResultSet resultSet = statement.executeQuery(lastIdQuery);

                // Retrieve the last ID
                String lastId = null;
                if (resultSet.next()) {
                    lastId = resultSet.getString("medid");
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
    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        

    }//GEN-LAST:event_insertMouseClicked

    private void loadSupplierID() {
        try {
            // Establish a database connection
           try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "")) {
                String sql = "SELECT supid FROM Supplier";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();


                // Create a DefaultComboBoxModel to store the car registration data
                DefaultComboBoxModel<String> comboBoxMode2 = new DefaultComboBoxModel<>();

                // Iterate through the result set and add car registration values to the model
                while (resultSet.next()) {
                    String Did = resultSet.getString("supid");
                    comboBoxMode2.addElement(Did);
                }

                // Set the model with car registration data to the carCom JComboBox
               SupplierId.setModel(comboBoxMode2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    public void updateSupplierRow(int selectedRow, String supid,String medid,String medname,double ppu) {
        DefaultTableModel tableModel = (DefaultTableModel) medicinetable.getModel();
        tableModel.setValueAt(supid, selectedRow, 0);
        tableModel.setValueAt(medid, selectedRow, 1);
        tableModel.setValueAt(medname, selectedRow, 2);
        tableModel.setValueAt(ppu, selectedRow, 3);
       
    }
    
    private void Exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit3ActionPerformed
        dispose(); 
                    dashboard newForm = new dashboard();

                    // Set the behavior of the new form (e.g., default close operation)
                    newForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    // Display the new form
                    newForm.pack();
                    newForm.setVisible(true);
    }//GEN-LAST:event_Exit3ActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String supid = (String) SupplierId.getSelectedItem();
        String medid = MedicineId.getText().trim();
        String medname = Name.getText().trim();
        String quantity = Quantity.getText().trim();
        String ppu = PricePerUnit.getText().trim();
        
        

    if (supid == null) {
        
        displayMessage("Please Select Supplier ID! ");
        return;
        
    }
  
    if (medname.isEmpty()) {
        
       
        displayMessage("Please enter Product Name! ");
        return;
        
    }

    
    if (quantity.isEmpty()) {
        
      
        displayMessage("Please Enter Quantity! ");
        return;
    }
    if (ppu.isEmpty()) {
        
      
        displayMessage("Please Enter Product per unit! ");
        return;
    }

  
        int quantitys = Integer.parseInt(quantity);
        double ppus = Double.parseDouble(ppu);
        controller.saveMedicineToDatabase(supid,medid,medname,quantitys,ppus);
    }//GEN-LAST:event_insertActionPerformed

    private void medicinetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicinetableMouseClicked
        
        int selectedRow = medicinetable.getSelectedRow();
    if (selectedRow != -1) {
        // A row is selected, so you can retrieve the data from the selected row
        DefaultTableModel tableModel = (DefaultTableModel) medicinetable.getModel();
        String supid = (String) tableModel.getValueAt(selectedRow, 0);
        String medid = (String) tableModel.getValueAt(selectedRow, 1);
        String medname = (String) tableModel.getValueAt(selectedRow, 2);
        Object quantityObj = tableModel.getValueAt(selectedRow, 3);
    String quantity = (quantityObj != null) ? String.valueOf(quantityObj) : "";

    // Assuming the "price" column is a double
    double ppu = (double) tableModel.getValueAt(selectedRow, 4);

        // Populate the text fields and combo box with the selected car's data
        SupplierId.setSelectedItem(supid);
        MedicineId.setText(medid);
        Name.setText(String.valueOf(medname));
        Quantity.setText(String.valueOf(quantity));
        PricePerUnit.setText(String.valueOf(ppu));
        
        // You can also enable the "Update" and "Delete" buttons here if needed
        delete.setEnabled(true);
        clear.setEnabled(true);
    }//GEN-LAST:event_medicinetableMouseClicked
    }
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearInputFields();
        takeID();
    }//GEN-LAST:event_clearActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow = medicinetable.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) medicinetable.getModel();
            String medid = (String) tableModel.getValueAt(selectedRow, 1); // Assuming carRegistration is in the first column

            // Call the controller to delete the car
            controller.deleteSupplier(medid);
            
            // Remove the selected row from the table (optional)
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Medicine to delete.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int selectedRow = medicinetable.getSelectedRow();
        if (selectedRow != -1) {
            String supid = SupplierId.getSelectedItem().toString();
            String medid = MedicineId.getText();
            String medname = Name.getText();
            double ppu = Double.parseDouble(PricePerUnit.getText());
            
            
            controller.updateSupplier(selectedRow,supid,medid,medname,ppu);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Medicine to update.");
        }       
    }//GEN-LAST:event_updateActionPerformed

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
    ModelMedicine mpro = new ModelMedicine();
    List<ControlMedicineData> SupplierDataList = mpro.getAllMedicineData();

    DefaultTableModel tableModel = (DefaultTableModel) medicinetable.getModel();
    tableModel.setRowCount(0); // Clear existing rows

    for (ControlMedicineData Data : SupplierDataList) {
        tableModel.addRow(new Object[]{Data.getsupid(), Data.getmedid(), Data.getmedname(), Data.getquantity(), Data.getppu()});
    }
   }
    public void addToMedicineList(String supid, String medid, String medname, int quantity, double ppu) {
        DefaultTableModel tableModel = (DefaultTableModel) medicinetable.getModel();
        tableModel.addRow(new Object[]{supid,medid,medname,quantity,ppu});
    }
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void takeID()
    {
        String newId = takemedID();
        MedicineId.setText(newId);
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
            java.util.logging.Logger.getLogger(medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new medicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit3;
    private javax.swing.JTextField MedicineId;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField PricePerUnit;
    private javax.swing.JTextField Quantity;
    private javax.swing.JComboBox<String> SupplierId;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicinetable;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
