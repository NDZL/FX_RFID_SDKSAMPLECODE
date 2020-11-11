/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReadAccessDlg.java
 *
 * Created on May 3, 2011, 11:25:55 AM
 */
package rfidsample;

import com.mot.rfid.api3.InvalidUsageException;
import com.mot.rfid.api3.MEMORY_BANK;
import com.mot.rfid.api3.OperationFailureException;
import com.mot.rfid.api3.TagAccess;
import com.mot.rfid.api3.TagData;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author CFRN78
 */
public class ReadAccessDlg extends javax.swing.JDialog
                           implements DocumentListener {

    String tagID;

    /** Creates new form ReadAccessDlg */
    public ReadAccessDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jTextFieldTagID.getDocument().addDocumentListener(this);

        tagID = RFIDMainDlg.rfidBase.getSelectedTagID();

        if (tagID == null) {
            jTextFieldTagID.setText("");
            jButtonAccessFilter.setEnabled(true);
        } else {
            jTextFieldTagID.setText(tagID);
            jButtonAccessFilter.setEnabled(false);

        }

        // select the EPC as default
        jComboBoxMemBank.setSelectedIndex(3);

        // initialize the password, offset and length to 0
        jTextFieldPwd.setText("0");
        jTextFieldOffset.setText("0");
        jTextFieldLength.setText("0");

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonRead = new javax.swing.JButton();
        jButtonAccessFilter = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldOffset = new javax.swing.JTextField();
        jComboBoxMemBank = new javax.swing.JComboBox();
        jTextFieldPwd = new javax.swing.JTextField();
        jTextFieldTagID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLength = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Read Tag");
        setResizable(false);

        jLabel3.setText("Memory Bank");

        jLabel2.setText("Password (Hex)");

        jLabel1.setText("Tag ID (Hex)");

        jButtonRead.setMnemonic('R');
        jButtonRead.setText("Read");
        jButtonRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadActionPerformed(evt);
            }
        });

        jButtonAccessFilter.setText("Access Filter");
        jButtonAccessFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccessFilterActionPerformed(evt);
            }
        });

        jLabel6.setText("Length (Bytes)");

        jTextFieldOffset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOffsetActionPerformed(evt);
            }
        });

        jComboBoxMemBank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Reserved", "EPC", "TID", "USER" }));

        jTextFieldTagID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldTagIDInputMethodTextChanged(evt);
            }
        });
        jTextFieldTagID.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldTagIDPropertyChange(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("Data Read");

        jLabel4.setText("Offset (Bytes)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButtonAccessFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRead, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTagID, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldOffset, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldLength, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                            .addComponent(jComboBoxMemBank, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPwd, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTagID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMemBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldOffset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRead)
                    .addComponent(jButtonAccessFilter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadActionPerformed
        try {
            TagAccess tagAccess = new TagAccess();
            TagAccess.ReadAccessParams readAccessParams = tagAccess.new ReadAccessParams();
            MEMORY_BANK memBank = MEMORY_BANK.MEMORY_BANK_EPC;
            switch (jComboBoxMemBank.getSelectedIndex()) {
                case 0:
                    memBank = MEMORY_BANK.MEMORY_BANK_RESERVED;
                    break;
                case 1:
                    memBank = MEMORY_BANK.MEMORY_BANK_EPC;
                    break;
                case 2:
                    memBank = MEMORY_BANK.MEMORY_BANK_TID;
                    break;
                case 3:
                    memBank = MEMORY_BANK.MEMORY_BANK_USER;
                    break;
            }
            readAccessParams.setMemoryBank(memBank);
            readAccessParams.setByteCount(Integer.parseInt(jTextFieldLength.getText()));
            readAccessParams.setByteOffset(Integer.parseInt(jTextFieldOffset.getText()));
            readAccessParams.setAccessPassword(Long.parseLong(jTextFieldPwd.getText(), 16));

            if (jTextFieldTagID.getText().length() > 0) {
                TagData readTagData = RFIDMainDlg.rfidBase.getMyReader().Actions.TagAccess.readWait(tagID, readAccessParams,
                                            RFIDMainDlg.rfidBase.antennaInfo.getAntennaID() != null ? RFIDMainDlg.rfidBase.antennaInfo : null);
                jTextArea1.setText(readTagData.getMemoryBankData());
            } else {
                
                RFIDMainDlg.rfidBase.getMyReader().Actions.TagAccess.readEvent(readAccessParams, RFIDMainDlg.rfidBase.isAccessFilterSet ? RFIDMainDlg.rfidBase.accessFilter : null,
                        RFIDMainDlg.rfidBase.antennaInfo.getAntennaID() != null ? RFIDMainDlg.rfidBase.antennaInfo : null);
                

            }

            RFIDMainDlg.rfidBase.postStatusNotification(RFIDBase.API_SUCCESS, null);

        } catch (InvalidUsageException ex) {
            RFIDMainDlg.rfidBase.postStatusNotification(RFIDBase.PARAM_ERROR, ex.getVendorMessage());
        } catch (OperationFailureException ex) {
            RFIDMainDlg.rfidBase.postStatusNotification(ex.getStatusDescription(), ex.getVendorMessage());
        }
}//GEN-LAST:event_jButtonReadActionPerformed

    private void jTextFieldOffsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOffsetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOffsetActionPerformed

    private void jTextFieldTagIDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldTagIDPropertyChange
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldTagIDPropertyChange

    private void jTextFieldTagIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldTagIDInputMethodTextChanged

}//GEN-LAST:event_jTextFieldTagIDInputMethodTextChanged

    private void jButtonAccessFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccessFilterActionPerformed
        AccessFilterDlg accessFilterDlg = new AccessFilterDlg(null, rootPaneCheckingEnabled);
        accessFilterDlg.setLocationRelativeTo(null);
        accessFilterDlg.show();
    }//GEN-LAST:event_jButtonAccessFilterActionPerformed


    // DocumentListener methods
    public void insertUpdate(DocumentEvent ev) {
        if (jTextFieldTagID.getText().length() == 0)
            jButtonAccessFilter.setEnabled(true);
        else
            jButtonAccessFilter.setEnabled(false);
    }

    public void removeUpdate(DocumentEvent ev) {
        if (jTextFieldTagID.getText().length() == 0)
            jButtonAccessFilter.setEnabled(true);
        else
            jButtonAccessFilter.setEnabled(false);
    }

    public void changedUpdate(DocumentEvent ev) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ReadAccessDlg dialog = new ReadAccessDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccessFilter;
    private javax.swing.JButton jButtonRead;
    private javax.swing.JComboBox jComboBoxMemBank;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldLength;
    private javax.swing.JTextField jTextFieldOffset;
    private javax.swing.JTextField jTextFieldPwd;
    private javax.swing.JTextField jTextFieldTagID;
    // End of variables declaration//GEN-END:variables
}
