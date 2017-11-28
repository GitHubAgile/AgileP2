/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import da.GetCustOrderForOneRest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class OrderDetail extends javax.swing.JFrame {

    GetCustOrderForOneRest getCustOrderForOneRest = new GetCustOrderForOneRest();
    
    public OrderDetail(String orderID) {
        initComponents();
        jtfOrderID.setText(orderID);
        String[] tableColumnsName = {"Food Name", "Quantity"};
        DefaultTableModel mode = (DefaultTableModel) jtfOrderDetail.getModel();
        mode.setColumnIdentifiers(tableColumnsName);
        mode.setRowCount(0);
        ResultSet rs = null;
        rs = getCustOrderForOneRest.getOrderMenu(orderID);
        
        try {                   
                ResultSetMetaData rsmd = rs.getMetaData();
                int colNo = rsmd.getColumnCount();
                    while(rs.next()){
                        Object[] objects = new Object[colNo];
                        for(int i = 0; i < colNo; i++){
                            objects[i] = rs.getObject(i+1);
                        }
                        mode.addRow(objects);
                    }
                    jtfOrderDetail.setModel(mode);

            } catch (SQLException ex) {
                System.out.println(ex);
            }
    }
    
        public OrderDetail() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtfOrderDetail = new javax.swing.JTable();
        jbtBack = new javax.swing.JButton();
        jbtComplete = new javax.swing.JButton();
        jlblOrderID = new javax.swing.JLabel();
        jtfOrderID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtfOrderDetail.setEnabled(false);
        jtfOrderDetail.setRowHeight(100);
        jScrollPane1.setViewportView(jtfOrderDetail);

        jbtBack.setText("Back To Order Page");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jbtComplete.setText("Complete");
        jbtComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCompleteActionPerformed(evt);
            }
        });

        jlblOrderID.setText("Order ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtBack, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(395, Short.MAX_VALUE)
                    .addComponent(jbtComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jlblOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtBack, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(jbtComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(203, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCompleteActionPerformed
        ResultSet rs3 = null;
        int initialID = 1001;
        rs3 = getCustOrderForOneRest.generateDeliveryID();
        try {
            while(rs3.next()){
                ++initialID;
            }
            String DeliveryID = "D" + (initialID+"");
            getCustOrderForOneRest.addDeliveryRecord(DeliveryID);
            getCustOrderForOneRest.UpdateDoneOrder(jtfOrderID.getText(), DeliveryID);
            JOptionPane.showMessageDialog(null, "Order Done.FastestDeliveryMan will assign deliveryman to deliver the order.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            new CheckCustOrder().setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtCompleteActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        try {
            new CheckCustOrder().setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtBackActionPerformed

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
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtComplete;
    private javax.swing.JLabel jlblOrderID;
    private javax.swing.JTable jtfOrderDetail;
    private javax.swing.JTextField jtfOrderID;
    // End of variables declaration//GEN-END:variables
}
