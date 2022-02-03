/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.view.forms;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.mb.controller.CustomerDAO;
import org.mb.controller.PaymentDAO;
import org.mb.controller.SalesDAO;
import org.mb.controller.SalesItemDAO;
import org.mb.model.Payment;
import org.mb.model.Sales;
import org.mb.model.SalesItem;
import org.mb.view.panels.SalesPanel;

/**
 *
 * @author QWERTY
 */
public class SalesForm extends javax.swing.JDialog {

    DefaultTableModel sales_model;
    HashMap<String, Integer> csmap;
    NumberFormat nf = NumberFormat.getInstance();
    JFrame hf;
    SalesPanel sp;

    public void setHomeFrame(JFrame hf) {
        this.hf = hf;
    }

    public void setSalesPanel(SalesPanel sp) {
        this.sp = sp;
    }

    /**
     * Creates new form SalesForm
     */
    public SalesForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jDateChooser_SalesDate.setDate(new java.util.Date());
        nf.setMaximumFractionDigits(2);
        sales_model = new DefaultTableModel(null, new String[]{"ID", "Product", "Quantity", "Price", "Total"});
        jTable_Sales.setModel(sales_model);
        loadCustomer();
    }

    public void loadCustomer() {
        CustomerDAO cDAO = new CustomerDAO();
        csmap = cDAO.fetchCustomer();
        for (Map.Entry<String, Integer> m : csmap.entrySet()) {
            jComboBox_Customer.addItem(m.getKey());
        }
    }

    public int checkProduct(int productID) {
        for (int i = 0; i < jTable_Sales.getRowCount(); i++) {
            if (jTable_Sales.getValueAt(i, 0).toString().equalsIgnoreCase(productID + "")) {
                return i;
            }
        }
        return -1;
    }

    public void totalPrice() {
        int c = sales_model.getRowCount();
        double total = 0;
        for (int i = 0; i < c; i++) {
            total += Double.parseDouble(sales_model.getValueAt(i, 4).toString().replaceAll(",", ""));
        }
        jLabel_Total.setText(total + "");
        jTextField_Payment.setText("0.00");
        jLabel_PaymentError.setText(" ");
        jLabel_Due.setText((total + "").replaceAll(",", ""));
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
        jComboBox_Customer = new javax.swing.JComboBox<>();
        jButton_AddProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Sales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Total = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Due = new javax.swing.JLabel();
        jTextField_Payment = new javax.swing.JTextField();
        jButton_SaveSales = new javax.swing.JButton();
        jLabel_PaymentError = new javax.swing.JLabel();
        jDateChooser_SalesDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales Form");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Customer :");

        jComboBox_Customer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_Customer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jButton_AddProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_AddProduct.setText("Add Product");
        jButton_AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddProductActionPerformed(evt);
            }
        });

        jTable_Sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Sales.getTableHeader().setReorderingAllowed(false);
        jTable_Sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SalesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Sales);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Total :");

        jLabel_Total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Total.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Payment :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Due :");

        jLabel_Due.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Due.setText("0.00");

        jTextField_Payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_PaymentKeyReleased(evt);
            }
        });

        jButton_SaveSales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_SaveSales.setText("Save Sales");
        jButton_SaveSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveSalesActionPerformed(evt);
            }
        });

        jLabel_PaymentError.setForeground(java.awt.Color.red);
        jLabel_PaymentError.setText(" ");

        jDateChooser_SalesDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser_SalesDate, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_AddProduct))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_PaymentError, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_SaveSales)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel_Total, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_Due, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(jTextField_Payment)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser_SalesDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_AddProduct)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel_Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel_PaymentError))
                    .addComponent(jTextField_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_Due))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_SaveSales)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddProductActionPerformed
        SalesItemForm p = new SalesItemForm(hf, true);
        p.setSalesForm(this);
        p.setVisible(true);
    }//GEN-LAST:event_jButton_AddProductActionPerformed

    private void jTextField_PaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PaymentKeyReleased
        if (jTextField_Payment.getText().equals("")) {
            jLabel_PaymentError.setText(" ");
            jLabel_Due.setText(jLabel_Total.getText());
            return;
        }

        try {
            double pmt = Double.parseDouble(jTextField_Payment.getText());
            double total = Double.parseDouble(jLabel_Total.getText());
            if (pmt > total) {
                jLabel_PaymentError.setText("Invalid Payment");
            } else {
                jLabel_Due.setText((nf.format(total - pmt) + "").replaceAll(",", ""));
                jLabel_PaymentError.setText(" ");
            }
        } catch (Exception ex) {
            jLabel_PaymentError.setText("Invalid Payment");
        }
    }//GEN-LAST:event_jTextField_PaymentKeyReleased

    private void jTable_SalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SalesMouseClicked
        int row = jTable_Sales.getSelectedRow();
        String[] options = {"Edit", "Delete", "Cancel"};
        int x = JOptionPane.showOptionDialog(null, "Choose an option.", "Sales Option",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (x == 0) {
            SalesItem sob = new SalesItem();
            sob.setProduct_id(Integer.parseInt(jTable_Sales.getValueAt(row, 0).toString()));
            sob.setProduct(jTable_Sales.getValueAt(row, 1).toString());
            sob.setQuantity(Integer.parseInt(jTable_Sales.getValueAt(row, 2).toString()));
            sob.setSales_price(Double.parseDouble(jTable_Sales.getValueAt(row, 3).toString()));

            SalesItemForm s = new SalesItemForm(hf, true);
            s.setSalesForm(this);
            s.setSalesItem(sob);
            s.setVisible(true);
        } else if (x == 1) {
            sales_model.removeRow(row);
            totalPrice();
        }
    }//GEN-LAST:event_jTable_SalesMouseClicked

    private void jButton_SaveSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveSalesActionPerformed
        if (!jLabel_PaymentError.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Sorry there are errors in the form");
            return;
        }
        if (jComboBox_Customer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, " Please select a customer first ");
            return;
        }

        if (jTable_Sales.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, " Please Add products to sales first ");
            return;
        }
        
        //Add new sales
        Sales sob = new Sales();
        sob.setCustomer_id(csmap.get(jComboBox_Customer.getSelectedItem().toString()));
        sob.setSales_date(new java.sql.Date(jDateChooser_SalesDate.getDate().getTime()));
        sob.setPayment_status(Double.parseDouble(jLabel_Due.getText()) == 0);

        SalesDAO sDAO = new SalesDAO();
        int sales_id = sDAO.addSales(sob);
        
        if (sales_id != -1) {
            //add Sales item and stock
            ArrayList<SalesItem> sList = new ArrayList<>();
            int c = sales_model.getRowCount();
            
            for (int row = 0; row < c; row++) {
                SalesItem ob = new SalesItem();
                ob.setProduct_id(Integer.parseInt(jTable_Sales.getValueAt(row, 0).toString()));
                ob.setSales_id(sales_id);
                ob.setQuantity(Integer.parseInt(jTable_Sales.getValueAt(row, 2).toString()));
                ob.setSales_price(Double.parseDouble(jTable_Sales.getValueAt(row, 3).toString()));              

                sList.add(ob);
            }
            
            SalesItemDAO siDAO = new SalesItemDAO();
            siDAO.addSalesItem(sList);
            
            //add payment
            Payment pmob = new Payment();
            PaymentDAO pmDAO = new PaymentDAO();
            pmob.setSales_id(sales_id);
            pmob.setAmount(Double.parseDouble(jTextField_Payment.getText()));
            pmDAO.addPayment(pmob);
            
            JOptionPane.showMessageDialog(null, " Purchase record success full");
            sp.loadSalesData();
            dispose();
        }

    }//GEN-LAST:event_jButton_SaveSalesActionPerformed

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
            java.util.logging.Logger.getLogger(SalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalesForm dialog = new SalesForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_AddProduct;
    private javax.swing.JButton jButton_SaveSales;
    private javax.swing.JComboBox<String> jComboBox_Customer;
    private com.toedter.calendar.JDateChooser jDateChooser_SalesDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Due;
    private javax.swing.JLabel jLabel_PaymentError;
    private javax.swing.JLabel jLabel_Total;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Sales;
    private javax.swing.JTextField jTextField_Payment;
    // End of variables declaration//GEN-END:variables
}
