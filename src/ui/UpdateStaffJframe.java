/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import da.UpdateStaffDA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class UpdateStaffJframe extends javax.swing.JFrame {
UpdateStaffDA da=new UpdateStaffDA();
 String SelectedID=null;
 Boolean Updated=false;
 Boolean FunctionOff=false;
    /**
     * Creates new form UpdateStaffJframe
     */
    public UpdateStaffJframe() {
        initComponents();
        if(Updated==false){
             table();
        }
       if(FunctionOff==false){
            SelectTable();
       }
       
       // jTable1.setCellSelectionEnabled(true);
       
        jbtSave.addActionListener(new SaveListener());
    }
    private class SaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int returnVal = JOptionPane.showConfirmDialog(null,"Confirm save?(Update)","Confirmation",JOptionPane.YES_NO_OPTION);
            if(returnVal == JOptionPane.YES_OPTION){
                if(jtfID.getText().equals("")||jtfName.getText().equals("")||jtfPassword.getText().equals("")||jtfPhone.getText().equals("")||jtfEmail.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All Field should not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
            try{
                    da.UpdateStaff(jtfID.getText(), jtfPassword.getText(), jtfName.getText(), jtfPhone.getText(), jtfEmail.getText(), ddlPosition.getSelectedItem().toString(),ddlStatus.getSelectedItem().toString());
                    
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            } 
            
                FunctionOff=true;  
                table();
                FunctionOff=false;
            }}
        }
    }
    private void SelectTable(){
        
       
         ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
         cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
         cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        SelectedID=null;
        SelectedID=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        ResultSet rs2=da.getSpecificStaff(SelectedID);
        try{
            while(rs2.next()){
                jtfID.setText(rs2.getString(1));
                jtfName.setText(rs2.getString(3));
                jtfPassword.setText(rs2.getString(2));
                jtfPhone.setText(rs2.getString(4));
                jtfEmail.setText(rs2.getString(5));
                ddlPosition.setSelectedItem(rs2.getString(6));
                ddlStatus.setSelectedItem(rs2.getString(7));
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
      }});}
                 
    
    
    private void table(){
       
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ResultSet rs=da.getStaff();
        try{
             
             model.setRowCount(0);
         
         }catch(Exception ex){
           //  JOptionPane.showMessageDialog(null,ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            
         } 
         try{ String ID;
        String Name;
        String Position;
        String Status;
        
             while(rs.next()){
                
                            ID=rs.getString(1);
                            Name=rs.getString(3);
                            Position=rs.getString(6);
                            Status=rs.getString(7);
                             
                 Object[] rowdata = {ID,Name ,Position ,Status };     
       
                model.addRow(rowdata);
             }
            
         }catch(Exception ex){
         //    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
         }        Updated=true;  
    
         }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbPassword = new javax.swing.JLabel();
        jlbName = new javax.swing.JLabel();
        jlbPhone = new javax.swing.JLabel();
        jlbEmail = new javax.swing.JLabel();
        jlbPosition = new javax.swing.JLabel();
        jlbStatus = new javax.swing.JLabel();
        jlbID = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfPhone = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        ddlPosition = new javax.swing.JComboBox<>();
        ddlStatus = new javax.swing.JComboBox<>();
        jlbTitle = new javax.swing.JLabel();
        jbtSave = new javax.swing.JButton();
        jtfID = new javax.swing.JTextField();
        jtfPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbPassword.setText("Password :");
        jlbPassword.setToolTipText("");
        jlbPassword.setName(""); // NOI18N

        jlbName.setText("Name :");
        jlbName.setToolTipText("");
        jlbName.setName(""); // NOI18N

        jlbPhone.setText("Phone :");
        jlbPhone.setToolTipText("");
        jlbPhone.setName(""); // NOI18N

        jlbEmail.setText("Email :");
        jlbEmail.setToolTipText("");
        jlbEmail.setName(""); // NOI18N

        jlbPosition.setText("Position :");
        jlbPosition.setToolTipText("");
        jlbPosition.setName(""); // NOI18N

        jlbStatus.setText("Status :");
        jlbStatus.setToolTipText("");
        jlbStatus.setName(""); // NOI18N

        jlbID.setText("ID :");

        ddlPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Deliveryman", "Manager" }));
        ddlPosition.setToolTipText("");

        ddlStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Work", "Vacation", "Retired", "Resigned" }));

        jlbTitle.setText("Staff Details");

        jbtSave.setText("Save");

        jtfID.setEditable(false);

        jtfPassword.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbID))
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ddlStatus, 0, 180, Short.MAX_VALUE)
                    .addComponent(ddlPosition, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPhone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfID)
                    .addComponent(jtfPassword))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jlbTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jbtSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTitle)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddlPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Staff ID", "Name", "Position", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(UpdateStaffJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStaffJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStaffJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStaffJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStaffJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ddlPosition;
    private javax.swing.JComboBox<String> ddlStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtSave;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbID;
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel jlbPassword;
    private javax.swing.JLabel jlbPhone;
    private javax.swing.JLabel jlbPosition;
    private javax.swing.JLabel jlbStatus;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfName;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfPhone;
    // End of variables declaration//GEN-END:variables
}
