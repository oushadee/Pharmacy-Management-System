
package View;

import Controller.NumericTextFieldKeyListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;

public class MoreQuantityadd extends javax.swing.JFrame {

  
    public MoreQuantityadd() {
        initComponents();
        txt_nq.addKeyListener(new NumericTextFieldKeyListener());
        
        cmb_prodid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductInfo();
            }
        });
        
        
        cmb_prodid.setModel(new DefaultComboBoxModel<>());

        // Add a PopupMenuListener to the JComboBox
        cmb_prodid.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                // Load items from the database when the popup menu is about to become visible
                loadItemsFromDatabase();
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // Do nothing when the popup menu becomes invisible
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                // Do nothing when the popup menu is canceled
            }
        });
    }
    private void loadItemsFromDatabase()
    {
        loadSupplierID();
    }
    
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    private void updateProductInfo() {
        // Implement updating product info based on selected product ID
        String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";
        
        String selectedProductId = (String) cmb_prodid.getSelectedItem();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT medname, quantity FROM Medicine WHERE medid = '" + selectedProductId + "'");
            if (resultSet.next()) {
                txt_proname.setText(resultSet.getString("medname"));
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
    public void ProductCountUpdate()
    {
        Connection con = null;
        try {
            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
            
            String supid = (String) cmb_prodid.getSelectedItem();
            String enteredQuantity = txt_nq.getText();

    
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
                selectStmt.setString(1, cmb_prodid.getSelectedItem().toString());
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    if (resultSet.next()) {

                        String updateQqinQuery = "UPDATE Medicine SET quantity=quantity+? WHERE medid=?";
                        try (PreparedStatement updateStmt = con.prepareStatement(updateQqinQuery)) {
                            updateStmt.setString(1, txt_nq.getText());
                            updateStmt.setString(2, cmb_prodid.getSelectedItem().toString());
                            int rowsAffected = updateStmt.executeUpdate();
                            if (rowsAffected > 0) {
        
                              displayMessage("Medicine Quantity Added Successfully");
                            } else {
        
                              displayMessage("Failed to update Medicine quantity");
    }   
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        cmb_prodid = new javax.swing.JComboBox<>();
        txt_nq = new javax.swing.JTextField();
        txt_proname = new javax.swing.JTextField();
        txt_aq = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Quantity");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(40, 29, 118));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Adding Quantity");

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
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(Exit2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Exit2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 70));

        jPanel1.add(cmb_prodid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 190, -1));

        txt_nq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txt_nq, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 190, -1));

        txt_proname.setEditable(false);
        txt_proname.setBackground(new java.awt.Color(255, 255, 255));
        txt_proname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txt_proname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 190, -1));

        txt_aq.setEditable(false);
        txt_aq.setBackground(new java.awt.Color(255, 255, 255));
        txt_aq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txt_aq, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Medicine Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Medicine Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Available Quantity");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("New Quantity");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        btn_add.setBackground(new java.awt.Color(102, 102, 255));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add Quantity");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        dispose();
        dashboard L1  = new dashboard();

        // Set the behavior of the new form (e.g., default close operation)
        L1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display the new form
        L1.pack();
        L1.setVisible(true);
    }//GEN-LAST:event_Exit2ActionPerformed

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
         
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String supid = (String) cmb_prodid.getSelectedItem();
        String quantity = txt_nq.getText().trim();
        if (supid == null) {

            displayMessage("Please Select Medicine ID! ");
            return;
        }
        if (quantity.isEmpty()) {
                
            displayMessage("Please enter New Quantity! ");
        }
        else
        {
           ProductCountUpdate();
           clearInputFields();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    public void clearInputFields() {
   
    txt_aq.setText("");
    txt_nq.setText("");
    txt_proname.setText("");
    cmb_prodid.setSelectedIndex(-1); // Reset to the first status option
    
}
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
               cmb_prodid.setModel(comboBoxMode2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
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
            java.util.logging.Logger.getLogger(MoreQuantityadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoreQuantityadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoreQuantityadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoreQuantityadd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoreQuantityadd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit2;
    private javax.swing.JButton btn_add;
    private javax.swing.JComboBox<String> cmb_prodid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_aq;
    private javax.swing.JTextField txt_nq;
    private javax.swing.JTextField txt_proname;
    // End of variables declaration//GEN-END:variables
}
