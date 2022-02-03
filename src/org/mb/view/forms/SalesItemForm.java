/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.view.forms;

import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.mb.controller.ProductDAO;
import org.mb.model.Product;
import org.mb.model.SalesItem;

/**
 *
 * @author QWERTY
 */
public class SalesItemForm extends javax.swing.JDialog {

    DefaultTableModel search_model;
    NumberFormat nf = NumberFormat.getInstance();
    SalesForm sf;
    SalesItem sob;

    public void setSalesForm(SalesForm sf) {
        this.sf = sf;
    }

    public void setSalesItem(SalesItem sob) {
        this.sob = sob;
        jTextField_ProductID.setText(sob.getProduct_id() + "");
        jTextField_Name.setText(sob.getProduct());
        jTextField_Quantity.setText(sob.getQuantity() + "");
        jTextField_Price.setText(sob.getSales_price() + "");
        jButton_Search.setVisible(false);
        jButton_AddProduct.setText("Edit");
    }

    /**
     * Creates new form SalesItemForm
     */
    public SalesItemForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        nf.setMaximumFractionDigits(2);
        search_model = new DefaultTableModel(null, new String[]{"ID", "Product", "Price", "Available Qty"});
        jTable_Search.setModel(search_model);
    }

    public void clearSearchModel() {
        int c = search_model.getRowCount();
        for (int i = 0; i < c; i++) {
            search_model.removeRow(0);
        }
    }

    public void clearFields() {
        jTextField_ProductID.setText("");
        jTextField_Name.setText("");
        jTextField_Price.setText("");
        jTextField_Quantity.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_Search = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Search = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Name = new javax.swing.JTextField();
        jTextField_ProductID = new javax.swing.JTextField();
        jLabel_NameError = new javax.swing.JLabel();
        jTextField_Quantity = new javax.swing.JTextField();
        jLabel_QuantityError = new javax.swing.JLabel();
        jButton_AddProduct = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Price = new javax.swing.JTextField();
        jLabel_PriceError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Sales Item");
        setResizable(false);

        jTextField_Search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton_Search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Search.setText("Search");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        jTable_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Search.getTableHeader().setReorderingAllowed(false);
        jTable_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SearchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Search);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Product ID :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Quantity :");

        jTextField_Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField_ProductID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel_NameError.setForeground(java.awt.Color.red);
        jLabel_NameError.setText(" ");

        jTextField_Quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_QuantityKeyTyped(evt);
            }
        });

        jLabel_QuantityError.setForeground(java.awt.Color.red);
        jLabel_QuantityError.setText(" ");

        jButton_AddProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_AddProduct.setText("Add Product");
        jButton_AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddProductActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Price :");

        jTextField_Price.setEditable(false);
        jTextField_Price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel_PriceError.setForeground(java.awt.Color.red);
        jLabel_PriceError.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Search)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_NameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_ProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton_AddProduct))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_QuantityError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_Price)
                            .addComponent(jLabel_PriceError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Search)
                            .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_ProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_NameError)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel_PriceError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_QuantityError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_AddProduct)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        String search_key = jTextField_Search.getText();
        if (search_key.equals("")) {
            clearSearchModel();
            return;
        }

        ProductDAO pDAO = new ProductDAO();
        ArrayList<Product> pList = pDAO.searchProducts(search_key);
        clearSearchModel();
        for (int i = 0; i < pList.size(); i++) {
            search_model.addRow(new Object[]{pList.get(i).getProduct_id(),
                pList.get(i).getName(), pList.get(i).getSales_price(), pList.get(i).getQuantity()});
        }
    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void jTable_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SearchMouseClicked
        clearFields();

        int row = jTable_Search.getSelectedRow();
        if(Integer.parseInt(jTable_Search.getValueAt(row, 3).toString())==0){
            JOptionPane.showMessageDialog(null, "Sorry the product quantity is not available ");
            return;
        }
        jTextField_ProductID.setText(jTable_Search.getValueAt(row, 0).toString());
        jTextField_Name.setText(jTable_Search.getValueAt(row, 1).toString());
        jTextField_Price.setText(jTable_Search.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTable_SearchMouseClicked

    private void jButton_AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddProductActionPerformed
        if (jTextField_ProductID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, " Please select a product" + " first ");
            return;
        }
        if (jTextField_Quantity.getText().equals("") || Integer.parseInt(jTextField_Quantity.getText()) == 0) {
            jLabel_QuantityError.setText("Quantity cant be empty");
            return;
        }
        int product_id = Integer.parseInt(jTextField_ProductID.getText());
        String name = jTextField_Name.getText();
        int quantity = Integer.parseInt(jTextField_Quantity.getText());
        double price = Double.parseDouble(jTextField_Price.getText());

        
        int i = sf.checkProduct(product_id);
        if (i == -1) {
            sf.sales_model.addRow(new Object[]{product_id, name, quantity, price, nf.format(price * quantity)});;
        } else {
            if (sob == null) {
                int confirm = JOptionPane.showConfirmDialog(null, "The product is already added \n Do you want to update it?");
                if (confirm != 0) {
                    return;
                }
            }
            sf.sales_model.setValueAt(quantity, i, 2);
            sf.sales_model.setValueAt(nf.format(quantity * price), i, 4);
        }
        sf.totalPrice();
        dispose();
    }//GEN-LAST:event_jButton_AddProductActionPerformed

    private void jTextField_QuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_QuantityKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
        if (jTextField_Quantity.getText().equals("")) {
            jLabel_QuantityError.setText("Quantity cant be empty");
        } else {
            jLabel_QuantityError.setText(" ");
        }
    }//GEN-LAST:event_jTextField_QuantityKeyTyped

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
            java.util.logging.Logger.getLogger(SalesItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalesItemForm dialog = new SalesItemForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_NameError;
    private javax.swing.JLabel jLabel_PriceError;
    private javax.swing.JLabel jLabel_QuantityError;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Search;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextField jTextField_Price;
    private javax.swing.JTextField jTextField_ProductID;
    private javax.swing.JTextField jTextField_Quantity;
    private javax.swing.JTextField jTextField_Search;
    // End of variables declaration//GEN-END:variables
}
