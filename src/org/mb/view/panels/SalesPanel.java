/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mb.view.panels;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.mb.controller.SalesDAO;
import org.mb.model.Sales;
import org.mb.view.forms.SalesForm;
import org.mb.view.forms.SalesReport;

/**
 *
 * @author QWERTY
 */
public class SalesPanel extends javax.swing.JPanel {
    DefaultTableModel sales_model;
    JFrame hf = (JFrame) SwingUtilities.getWindowAncestor(this);
    /**
     * Creates new form SalesPanel
     */
    public SalesPanel() {
        initComponents();
        sales_model = new DefaultTableModel(null, new String[]{"ID", "Payment Status", "Sales Date", "Customer"});
        jTable_Sales.setModel(sales_model);
        loadSalesData();
    }
    
    public void loadSalesData() {
        clearSalesModel();
        SalesDAO sDAO = new SalesDAO();
        ArrayList<Sales> sList = sDAO.fetchData();
        for (int i = 0; i < sList.size(); i++) {
            sales_model.addRow(new Object[]{sList.get(i).getSales_id(),
                sList.get(i).isPayment_status(),
                sList.get(i).getSales_date(), sList.get(i).getCustomer()});
        }
    }

    public void clearSalesModel() {
        int c = sales_model.getRowCount();
        for (int i = 0; i < c; i++) {
            sales_model.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Sales = new javax.swing.JTable();
        jButton_Refresh = new javax.swing.JButton();
        jButton_ViewSalesReport = new javax.swing.JButton();
        jButton_NewSales = new javax.swing.JButton();

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

        jButton_Refresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Refresh.setText("Refresh");
        jButton_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefreshActionPerformed(evt);
            }
        });

        jButton_ViewSalesReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_ViewSalesReport.setText("View Report");
        jButton_ViewSalesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ViewSalesReportActionPerformed(evt);
            }
        });

        jButton_NewSales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_NewSales.setText("New Sales");
        jButton_NewSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NewSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ViewSalesReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_NewSales)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ViewSalesReport)
                    .addComponent(jButton_NewSales)
                    .addComponent(jButton_Refresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshActionPerformed
        loadSalesData();
    }//GEN-LAST:event_jButton_RefreshActionPerformed

    private void jButton_ViewSalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ViewSalesReportActionPerformed
        SalesReport s = new SalesReport();
        s.setVisible(true);
    }//GEN-LAST:event_jButton_ViewSalesReportActionPerformed

    private void jButton_NewSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NewSalesActionPerformed
        SalesForm s =new SalesForm(hf, true);
        s.setHomeFrame(hf);
        s.setSalesPanel(this);
        s.setVisible(true);
    }//GEN-LAST:event_jButton_NewSalesActionPerformed

    private void jTable_SalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SalesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_SalesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_NewSales;
    private javax.swing.JButton jButton_Refresh;
    private javax.swing.JButton jButton_ViewSalesReport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Sales;
    // End of variables declaration//GEN-END:variables
}
