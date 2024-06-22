
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import Model.ModelBill;
import Controller.NumericTextFieldKeyListener;
import java.sql.*;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Billingprocess extends javax.swing.JFrame {

private final ControlBill controller;
    public Billingprocess() {
        initComponents();
        addDocumentListener(txt_qout);
        addDocumentListener(txt_price);
        
        addDocumentListeners(txt_tota);
        addDocumentListeners(txt_payment);
        invbilldate.setDate(Calendar.getInstance().getTime());
        ModelBill model = new ModelBill();
        controller = new ControlBill(this, model);
        txt_cusname.requestFocus();
        txt_price.addKeyListener(new NumericTextFieldKeyListener());
        txt_qout.addKeyListener(new NumericTextFieldKeyListener());
        txt_payment.addKeyListener(new NumericTextFieldKeyListener());
        loadItemsFromDatabase();
        displayExistingProductData();
        String productId = generateOrderID();
        txt_invid.setText(productId);
        
        cmb_medid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductInfo();
            }
        });
    }


    private void updateProductInfo() {
        // Implement updating product info based on selected product ID
        String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";
        
        String selectedProductId = (String) cmb_medid.getSelectedItem();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT medname, ppu, quantity FROM Medicine WHERE medid = '" + selectedProductId + "'");
            if (resultSet.next()) {
                txt_medname.setText(resultSet.getString("medname"));
                txt_price.setText(String.valueOf(resultSet.getInt("ppu")));
                txt_aq.setText(String.valueOf(resultSet.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        catch (SQLException e) {
            e.printStackTrace();
    }
    }
    public void updateProductRow(int selectedRow, String invid, String medid, String medname, String cusname, double price, int quantityout, double totalamount, double payment, Date invdate) {
        DefaultTableModel tableModel = (DefaultTableModel) Billtable.getModel();
        tableModel.setValueAt(invid, selectedRow, 0);
        tableModel.setValueAt(medid, selectedRow, 1);
        tableModel.setValueAt(medname, selectedRow, 2);
        tableModel.setValueAt(cusname, selectedRow, 3);
        tableModel.setValueAt(price, selectedRow, 4);
        tableModel.setValueAt(quantityout, selectedRow, 5);
        tableModel.setValueAt(totalamount, selectedRow, 6);
        tableModel.setValueAt(payment, selectedRow, 7);
        tableModel.setValueAt(invdate, selectedRow, 8);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_invid = new javax.swing.JTextField();
        txt_medname = new javax.swing.JTextField();
        txt_cusname = new javax.swing.JTextField();
        txt_qout = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        txt_tota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_balance = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_payment = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Billtable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cmb_medid = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_aq = new javax.swing.JTextField();
        place = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        invbilldate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Billing");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(40, 29, 118));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Billing");

        Exit2.setBackground(new java.awt.Color(204, 0, 0));
        Exit2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Exit2.setForeground(new java.awt.Color(255, 255, 255));
        Exit2.setText("X");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(556, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(532, 532, 532)
                .addComponent(Exit2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Exit2)
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Invoice id");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Customer Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Available Quantity");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantity Out");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Total cost Rs.");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Date");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 37, -1));

        txt_invid.setEditable(false);
        txt_invid.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_invid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 150, -1));

        txt_medname.setEditable(false);
        txt_medname.setBackground(new java.awt.Color(255, 255, 255));
        txt_medname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mednameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_medname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 150, 80));
        jPanel2.add(txt_cusname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 150, -1));

        txt_qout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qoutActionPerformed(evt);
            }
        });
        txt_qout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qoutKeyPressed(evt);
            }
        });
        jPanel2.add(txt_qout, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 150, -1));

        txt_price.setEditable(false);
        txt_price.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, -1));

        txt_tota.setEditable(false);
        txt_tota.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_tota, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Payment Rs.");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        txt_balance.setEditable(false);
        txt_balance.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 150, -1));

        delete.setBackground(new java.awt.Color(102, 102, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Cancel");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Balance Rs.");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));
        jPanel2.add(txt_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 150, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(899, 0, 150, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Medicine Name");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        Billtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice id", "Medicine id", "Medicine Name", "Customer Name", "Price", "Quantity Out", "Total Amount", "Payment", "Date"
            }
        ));
        Billtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BilltableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Billtable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 910, 570));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Medicine id");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jPanel2.add(cmb_medid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Price RS.");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        txt_aq.setEditable(false);
        txt_aq.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_aq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 150, -1));

        place.setBackground(new java.awt.Color(102, 102, 255));
        place.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        place.setForeground(new java.awt.Color(255, 255, 255));
        place.setText("Place");
        place.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                placeMouseClicked(evt);
            }
        });
        place.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeActionPerformed(evt);
            }
        });
        jPanel2.add(place, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));

        clear.setBackground(new java.awt.Color(102, 102, 255));
        clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 90, -1));
        jPanel2.add(invbilldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 150, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 660));

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

    private void txt_mednameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mednameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mednameActionPerformed

    private void txt_qoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qoutActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseClicked

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        dispose();
        dashboard L1  = new dashboard();

    
        L1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   
        L1.pack();
        L1.setVisible(true);
    }//GEN-LAST:event_Exit2ActionPerformed

    private void placeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_placeMouseClicked

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

    private void placeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeActionPerformed
        
                        String invid = txt_invid.getText().trim();
                        String medid = (String) cmb_medid.getSelectedItem();
                        String medname = txt_medname.getText().trim();
                        String cusname = txt_cusname.getText().trim();
                        String price = txt_price.getText().trim();
                        String quantityout = txt_qout.getText().trim();
                        String totalamount = txt_tota.getText().trim();
                        String payment = txt_payment.getText().trim();
                        Date invdate = invbilldate.getDate();

                        
                        if (cusname.isEmpty()) {
                
                         displayMessage("Please enter Customer Name! ");
                         return;
                        }
                        
                        if (medid == null) {
        
      
                          displayMessage("Please Select MedicineID! ");
                          return;
                        }
                        
                        if (medname.isEmpty()) {
                
                         displayMessage("Please Select Medicine ID to retreive Medicine name! ");
                         return;
                        }
                        
                        if (quantityout.isEmpty()) {
                
                         displayMessage("Please enter Quantity Out! ");
                         return;
                        }
                        if (payment.isEmpty()) {
                
                         displayMessage("Payment Cannot be Empty! ");
                         return;
                        }
                        
                        
                        String quantityo = txt_aq.getText();
                        String quantityoo = txt_qout.getText();
                        String he = txt_payment.getText();
                        String hehe = txt_tota.getText();
                        double quantityoValue = Double.parseDouble(quantityo);
                        double quantityooValue = Integer.parseInt(quantityoo);
                        double huhu = Double.parseDouble(he);
                        double huhuhu = Double.parseDouble(hehe);
                       
                       if( quantityoValue < quantityooValue)
                        {
                          displayMessage("Sorry, Not Enough Quantity Available!");
                          return;
                        }
                       if( huhu < huhuhu)
                        {
                          displayMessage("Sorry, Payment Should be Higher or Equal to the Total Cost!");
                          return;
                        }
                       else
                        {
                            ProductCountUpdate();
                        }
                        
        java.sql.Date sqlODate = new java.sql.Date(invdate.getTime());
        int quantityouts = Integer.parseInt(quantityout);
        double prices = Double.parseDouble(price);
        double totalamounts = Double.parseDouble(totalamount);
        double payments = Double.parseDouble(payment);
        controller.saveBillToDatabase(invid,medid,medname,cusname,prices,quantityouts,totalamounts,payments,sqlODate);
        generateOrderID();
    }//GEN-LAST:event_placeActionPerformed

    private void BilltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BilltableMouseClicked
        int selectedRow = Billtable.getSelectedRow();
if (selectedRow != -1) {
    // A row is selected, so you can retrieve the data from the selected row
    DefaultTableModel tableModel = (DefaultTableModel) Billtable.getModel();
    String invids = (String) tableModel.getValueAt(selectedRow, 0);
    String medids = (String) tableModel.getValueAt(selectedRow, 1);
    String mednames = (String) tableModel.getValueAt(selectedRow, 2);
    String cusnames = (String) tableModel.getValueAt(selectedRow, 3);
    double prices = (double) tableModel.getValueAt(selectedRow, 4);
    
    

    // Handle the quantity column appropriately
    Object quantityObj = tableModel.getValueAt(selectedRow, 5);
    String quantitys = (quantityObj != null) ? String.valueOf(quantityObj) : "";
    
    double totalamounts = (double) tableModel.getValueAt(selectedRow, 6);
    double payments = (double) tableModel.getValueAt(selectedRow, 7);
    
    Date ODates = (Date) tableModel.getValueAt(selectedRow, 8);

    // Populate the text fields and combo box with the selected data
    
    txt_invid.setText(invids);
    cmb_medid.setSelectedItem(medids);
    txt_medname.setText(mednames);
    txt_cusname.setText(cusnames);
    txt_price.setText(String.valueOf(prices));
    txt_qout.setText(String.valueOf(quantitys));
    txt_tota.setText(String.valueOf(totalamounts));
    txt_payment.setText(String.valueOf(payments));
    invbilldate.setDate(ODates);

    // You can also enable the "Update" and "Delete" buttons here if needed
    delete.setEnabled(true);
    clear.setEnabled(true);
    }//GEN-LAST:event_BilltableMouseClicked
    }
    private void txt_qoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qoutKeyPressed
        updateTotalAmount();
    }//GEN-LAST:event_txt_qoutKeyPressed

    
    public void Productu()
    {
        Connection con = null;
        try {
            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
            
            String supid = (String) cmb_medid.getSelectedItem();
            String enteredQuantity = txt_qout.getText();

    
           if (supid.isEmpty()) {
           displayMessage("Please select Medicine ID to add quantity.");
           return;
           }

          if (enteredQuantity.isEmpty()) {
          displayMessage("Please enter new quantity.");
          return;
          }

            String selectQqinQuery = "SELECT * FROM Medicine WHERE medid=?";
            try (PreparedStatement selectStmt = con.prepareStatement(selectQqinQuery)) {
                selectStmt.setString(1, cmb_medid.getSelectedItem().toString());
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    if (resultSet.next()) {

                        String updateQqinQuery = "UPDATE Medicine SET quantity=quantity+? WHERE medid=?";
                        try (PreparedStatement updateStmt = con.prepareStatement(updateQqinQuery)) {
                            updateStmt.setString(1, txt_qout.getText());
                            updateStmt.setString(2, cmb_medid.getSelectedItem().toString());
                            int rowsAffected = updateStmt.executeUpdate();
                            if (rowsAffected > 0) {
        
                              displayMessage("Medicine Quantity Restored Successfully");
                            } else {
        
                              displayMessage("Failed to Restore Medicine quantity");
    }   
                            }
                            
                    } 
                    else 
                    {
                        
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection in a finally block
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow = Billtable.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) Billtable.getModel();
            String invids = (String) tableModel.getValueAt(selectedRow, 0); // Assuming carRegistration is in the first column

            // Call the controller to delete the car
            controller.deleteBill(invids);
            
            // Remove the selected row from the table (optional)
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Bill to delete.");
        }        // TODO
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearInputFields();
       takeOrderID();
    }//GEN-LAST:event_clearActionPerformed

    
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    private void loadItemsFromDatabase()
    {
        loadSupplierID();
    }
    public void addToOrderList(String invid, String medid, String medname, String cusname, double price, int quantityout, double totalamount, double payment, Date invdate) {
        DefaultTableModel tableModel = (DefaultTableModel) Billtable.getModel();
        tableModel.addRow(new Object[]{invid,medid,medname,cusname,price,quantityout,totalamount,payment,invdate});
    }
    public void clearInputFields() {
    takeOrderID();
    txt_tota.setText("");
    txt_payment.setText("");
    txt_balance.setText("");
    txt_aq.setText("");
    txt_price.setText("");
    invbilldate.setDate(Calendar.getInstance().getTime());
    cmb_medid.setSelectedIndex(-1);
    txt_qout.setText("");// Reset to the first status option
    txt_medname.setText("");
    txt_cusname.setText("");
    }
    
    private void displayExistingProductData() {
    ModelBill mpro = new ModelBill();
    List<ControlBillData> ProductDataList = mpro.getAllBillData();

    DefaultTableModel tableModel = (DefaultTableModel) Billtable.getModel();
    tableModel.setRowCount(0); // Clear existing rows

    for (ControlBillData carData : ProductDataList) {
        tableModel.addRow(new Object[]{carData.getinvid(), carData.getmedid(), carData.getmedname(), carData.getcusname(), carData.getprice(),carData.getquantityout(),carData.gettotalamount(),carData.getpayment(),carData.getinvdate()});
    }
    }
    
    public void takeOrderID()
    {
        String newId = generateOrderID();
        txt_invid.setText(newId);
    }
    
    
    
    private void addDocumentListener(JTextField textField) {
        
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotalAmount();
            }
        });
    }
    
    private void addDocumentListeners(JTextField textField) {
        
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               updateBalanceAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBalanceAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBalanceAmount();
            }
        });
    }
    
    private void updateTotalAmount() {
        try {
            double quantity = Double.parseDouble(txt_qout.getText());
            double priceq = Double.parseDouble(txt_price.getText());
            double totalAmount = quantity * priceq;

            // Format the total amount without decimal points
            DecimalFormat decimalFormat = new DecimalFormat("#");
            String formattedTotalAmount = decimalFormat.format(totalAmount);

            txt_tota.setText(formattedTotalAmount);
        } catch (NumberFormatException ex) {
            // Handle the case where the input is not a valid number
            txt_tota.setText("No input");
        }
    }
    
    private void updateBalanceAmount() {
        try {
            double tot = Double.parseDouble(txt_payment.getText());
            double balanced = Double.parseDouble(txt_tota.getText());
            double totalAmount = tot - balanced;

            // Format the total amount without decimal points
            DecimalFormat decimalFormat = new DecimalFormat("#");
            String formattedTotalAmount = decimalFormat.format(totalAmount);

            txt_balance.setText(formattedTotalAmount);
        } catch (NumberFormatException ex) {
            // Handle the case where the input is not a valid number
            txt_balance.setText("No input");
        }
    }
    public void ProductCountUpdate()
    {
        Connection con = null;
        try {
            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
            
            String supid = (String) cmb_medid.getSelectedItem();
            String enteredQuantity = txt_qout.getText();

    
           if (supid == null || supid.isEmpty()) {
           displayMessage("Please select Medicine ID to add quantity.");
           return;
           }

          if (enteredQuantity.isEmpty()) {
          displayMessage("Please enter quantity.");
          return;
          }

            String selectQqinQuery = "SELECT * FROM Medicine WHERE medid=?";
            try (PreparedStatement selectStmt = con.prepareStatement(selectQqinQuery)) {
                selectStmt.setString(1, supid);
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    if (resultSet.next()) {

                        String updateQqinQuery = "UPDATE Medicine SET quantity = quantity - ? WHERE medid = ?";
                        try (PreparedStatement updateStmt = con.prepareStatement(updateQqinQuery)) {
                            updateStmt.setString(1, txt_qout.getText());
                            updateStmt.setString(2, supid);
                            updateStmt.executeUpdate();
                        }
                            
                    } 
                    else 
                    {
                        displayMessage("Please Select a Medicine to add Quantity! ");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection in a finally block
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   
    private void loadSupplierID() {
        try {
            // Establish a database connection
           try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "")) {
                String sql = "SELECT medid FROM Medicine";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();


                // Create a DefaultComboBoxModel to store the car registration data
                DefaultComboBoxModel<String> comboBoxMode2 = new DefaultComboBoxModel<>();

                // Iterate through the result set and add car registration values to the model
                while (resultSet.next()) {
                    String Did = resultSet.getString("medid");
                    comboBoxMode2.addElement(Did);
                }

                // Set the model with car registration data to the carCom JComboBox
               cmb_medid.setModel(comboBoxMode2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    public static String generateOrderID()
    {
        String prefix = "#INV";

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
                String lastIdQuery = "SELECT invid FROM Invoice ORDER BY invid DESC LIMIT 1";
                ResultSet resultSet = statement.executeQuery(lastIdQuery);

                // Retrieve the last ID
                String lastId = null;
                if (resultSet.next()) {
                    lastId = resultSet.getString("invid");
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
            java.util.logging.Logger.getLogger(Billingprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billingprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billingprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billingprocess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billingprocess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Billtable;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> cmb_medid;
    private javax.swing.JButton delete;
    private com.toedter.calendar.JDateChooser invbilldate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton place;
    private javax.swing.JTextField txt_aq;
    private javax.swing.JTextField txt_balance;
    private javax.swing.JTextField txt_cusname;
    private javax.swing.JTextField txt_invid;
    private javax.swing.JTextField txt_medname;
    private javax.swing.JTextField txt_payment;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_qout;
    private javax.swing.JTextField txt_tota;
    // End of variables declaration//GEN-END:variables
}
