package moneycollector.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RIYAD
 */
public class JDialogOption extends javax.swing.JDialog {
    
    private final JFrameHome home;
    
    /**
     * Creates new form JDialogOption
     * ShowTheFrame is the only method which should be called.Remember its static.
     * @param parent Parent Frame of this dialog
     * @param modal
     */
    public JDialogOption(JFrameHome parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setOnPerfectLocation();
        home = parent;
    }

    
    /**
     * Setting the frame into a perfect location
     */
    private void setOnPerfectLocation(){
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((scrSize.width-this.getWidth())/2,(scrSize.height-this.getHeight())/4);
    }
    
    
    /**
     * Deleting all data from the database
     */
    private void deleteData() {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.prepareStatement("DELETE FROM USERS");
            stmt.executeUpdate();
            stmt = c.prepareStatement("DELETE FROM TRANSECTIONS");
            stmt.executeUpdate();
            stmt = c.prepareStatement("DELETE FROM OTHER");
            stmt.executeUpdate();
            stmt = c.prepareStatement("DELETE FROM BANK");
            stmt.executeUpdate();
            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(null, "All Records successfully deleted", "Database Status", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
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

        jButtonDeleteAllData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Options For Renaissanse App");
        setResizable(false);

        jButtonDeleteAllData.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jButtonDeleteAllData.setText("Delete All Data");
        jButtonDeleteAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAllDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButtonDeleteAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButtonDeleteAllData, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAllDataActionPerformed
        int ret =  JOptionPane.showConfirmDialog(rootPane, "Are you sure to delete all data from database??\n\nYou cannot undo later.", "Yah just conferming",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ret == 0){
            deleteData();
            home.loadData();
            home.updateUsersPanel();
        }
    }//GEN-LAST:event_jButtonDeleteAllDataActionPerformed

    /**
     * @param home HomeFrame of this application
     */
    public static void showTheFrame(JFrameHome home) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDialogOption dialog = new JDialogOption(home, true);
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteAllData;
    // End of variables declaration//GEN-END:variables
}