/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AntennaModeDlg.java
 *
 * Created on Jun 2, 2011, 5:52:07 PM
 */

package rfidsample;

import com.mot.rfid.api3.ANTENNA_MODE;
import com.mot.rfid.api3.InvalidUsageException;
import com.mot.rfid.api3.OperationFailureException;

/**
 *
 * @author CFRN78
 */
public class AntennaModeDlg extends javax.swing.JDialog {

    /** Creates new form AntennaModeDlg */
    public AntennaModeDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        if (RFIDMainDlg.rfidBase.rm.isLoggedIn())
        {
            try {
                if (RFIDMainDlg.rfidBase.rm.getAntennaMode() == ANTENNA_MODE.ANTENNA_MODE_MONOSTATIC)
                    jComboBoxAntennaMode.setSelectedIndex(0);
                else
                    jComboBoxAntennaMode.setSelectedIndex(1);

            } catch (InvalidUsageException ex) {
               // ex.printStackTrace();
            } catch (OperationFailureException ex) {
               // ex.printStackTrace();
            }

        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxAntennaMode = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Antenna Mode");
        setResizable(false);

        jLabel1.setText("Antenna Mode");

        jComboBoxAntennaMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MonoStatic", "BiStatic" }));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxAntennaMode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxAntennaMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (RFIDMainDlg.rfidBase.rm.isLoggedIn())
        {
            try {
                if (jComboBoxAntennaMode.getSelectedIndex() == 0)
                    RFIDMainDlg.rfidBase.rm.setAntennaMode(ANTENNA_MODE.ANTENNA_MODE_MONOSTATIC);
                else
                    RFIDMainDlg.rfidBase.rm.setAntennaMode(ANTENNA_MODE.ANTENNA_MODE_BISTATIC);

                RFIDMainDlg.rfidBase.postStatusNotification(RFIDBase.API_SUCCESS, null);
                
            } catch (InvalidUsageException ex) {
                RFIDMainDlg.rfidBase.postStatusNotification(RFIDBase.PARAM_ERROR, ex.getVendorMessage());
            } catch (OperationFailureException ex) {
                RFIDMainDlg.rfidBase.postStatusNotification(ex.getStatusDescription(), ex.getVendorMessage());
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AntennaModeDlg dialog = new AntennaModeDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxAntennaMode;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
