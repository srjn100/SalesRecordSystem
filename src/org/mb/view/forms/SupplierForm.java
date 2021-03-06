/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.view.forms;

import javax.swing.JOptionPane;
import org.mb.controller.SupplierDAO;
import org.mb.model.Supplier;
import org.mb.view.panels.SupplierPanel;

/**
 *
 * @author QWERTY
 */
public class SupplierForm extends javax.swing.JDialog {

    SupplierPanel sp;
    Supplier sob;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public void setSupplierPanel(SupplierPanel sp) {
        this.sp = sp;
    }

    public void setSupplier(Supplier sob) {
        this.sob = sob;

        jTextField_CustomerID.setText(sob.getSupplier_id() + "");
        jTextField_Name.setText(sob.getName());
        jTextField_Address.setText(sob.getAddress());
        jTextField_Phone.setText(sob.getPhone() + "");
        jTextField_Email.setText(sob.getEmail());
    }

    /**
     * Creates new form SupplierForm
     */
    public SupplierForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_CustomerID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Name = new javax.swing.JTextField();
        jLabel_NameError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Address = new javax.swing.JTextField();
        jLabel_AddressError = new javax.swing.JLabel();
        jTextField_Phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel_PhoneError = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jLabel_EmailError = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton_SaveSupplier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Supplier Form");

        jTextField_CustomerID.setEditable(false);
        jTextField_CustomerID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name :");

        jTextField_Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_NameKeyReleased(evt);
            }
        });

        jLabel_NameError.setForeground(java.awt.Color.red);
        jLabel_NameError.setText(" ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Address :");

        jTextField_Address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_AddressKeyReleased(evt);
            }
        });

        jLabel_AddressError.setForeground(java.awt.Color.red);
        jLabel_AddressError.setText(" ");

        jTextField_Phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_PhoneKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Phone :");

        jLabel_PhoneError.setForeground(java.awt.Color.red);
        jLabel_PhoneError.setText(" ");

        jTextField_Email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_EmailKeyReleased(evt);
            }
        });

        jLabel_EmailError.setForeground(java.awt.Color.red);
        jLabel_EmailError.setText(" ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Email :");

        jButton_SaveSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_SaveSupplier.setText("SAVE");
        jButton_SaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_CustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_NameError, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_PhoneError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_EmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_AddressError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton_SaveSupplier))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_CustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_NameError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_AddressError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_PhoneError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_EmailError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_SaveSupplier)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_NameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NameKeyReleased
        if (jTextField_Name.getText().equals("")) {
            jLabel_NameError.setText("Name cant be empty");
        } else {
            jLabel_NameError.setText(" ");
        }
    }//GEN-LAST:event_jTextField_NameKeyReleased

    private void jTextField_AddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_AddressKeyReleased
        if (jTextField_Address.getText().equals("")) {
            jLabel_AddressError.setText("Address cant be empty");
        } else {
            jLabel_AddressError.setText(" ");
        }
    }//GEN-LAST:event_jTextField_AddressKeyReleased

    private void jTextField_PhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PhoneKeyReleased

        try {
            long x = Long.parseLong(jTextField_Phone.getText());
            jLabel_PhoneError.setText(" ");
        } catch (Exception ex) {
            jLabel_PhoneError.setText("Invalid Phone number");
        }
    }//GEN-LAST:event_jTextField_PhoneKeyReleased

    private void jTextField_EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_EmailKeyReleased
        if (!jTextField_Email.getText().matches(EMAIL_PATTERN)) {
            jLabel_EmailError.setText("Invalid Email");
        } else {
            jLabel_EmailError.setText(" ");
        }
    }//GEN-LAST:event_jTextField_EmailKeyReleased

    private void jButton_SaveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveSupplierActionPerformed
        //check errors
        if (!(jLabel_NameError.getText().equals(" ")
                && jLabel_AddressError.getText().equals(" ")
                && jLabel_PhoneError.getText().equals(" ")
                && jLabel_EmailError.getText().equals(" "))) {
            JOptionPane.showMessageDialog(null, "Sorry there are errors in the form");
            return;
        }
        if (jTextField_Name.getText().equals("")
                || jTextField_Address.getText().equals("")
                || jTextField_Phone.getText().equals("")
                || jTextField_Email.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields first");
            return;
        }
        if (sob == null) {
            if (new SupplierDAO().checkPhone(jTextField_Phone.getText())) {
                JOptionPane.showMessageDialog(null, "Sorry the phone number is taken");
                return;
            }
            if (new SupplierDAO().checkEmail(jTextField_Email.getText())) {
                JOptionPane.showMessageDialog(null, "Sorry the email is taken");
                return;
            }
        }
        

        //get input values
        String name = jTextField_Name.getText();
        String address = jTextField_Address.getText();
        long phone = Long.parseLong(jTextField_Phone.getText());
        String email = jTextField_Email.getText();

        //set input values into model class "Supplier" object
        Supplier ob = new Supplier();
        ob.setName(name);
        ob.setAddress(address);
        ob.setPhone(phone);
        ob.setEmail(email);

        //handover this model object to controller class "SupplierDAO"
        SupplierDAO sDAO = new SupplierDAO();
        if (sob == null) {
            sDAO.addSupplier(ob);
        } else {
            ob.setSupplier_id(sob.getSupplier_id());
            sDAO.updateSupplier(ob);
        }

        sp.loadData();
        dispose();
    }//GEN-LAST:event_jButton_SaveSupplierActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SupplierForm dialog = new SupplierForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_SaveSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_AddressError;
    private javax.swing.JLabel jLabel_EmailError;
    private javax.swing.JLabel jLabel_NameError;
    private javax.swing.JLabel jLabel_PhoneError;
    private javax.swing.JTextField jTextField_Address;
    private javax.swing.JTextField jTextField_CustomerID;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextField jTextField_Phone;
    // End of variables declaration//GEN-END:variables
}
