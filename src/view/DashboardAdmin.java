/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Muhammad Rizky S
 */
public class DashboardAdmin extends javax.swing.JFrame {

    /**
     * Creates new form LoginAdminView
     */
    public DashboardAdmin() {
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

        menuSetoranButton = new javax.swing.JButton();
        menuExchangeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuSetoranButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/KelolaSetoranButton.png"))); // NOI18N
        menuSetoranButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSetoranButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSetoranButtonActionPerformed(evt);
            }
        });
        getContentPane().add(menuSetoranButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 190, 170));

        menuExchangeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/KelolaPenukaranButton.png"))); // NOI18N
        menuExchangeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuExchangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExchangeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(menuExchangeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 190, 170));

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogoutButton.png"))); // NOI18N
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/DashboardAdmin.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LoginView login = new LoginView();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void menuExchangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExchangeButtonActionPerformed
        KelolaExchange menuExchange = new KelolaExchange();
        menuExchange.setVisible(true);
        menuExchange.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_menuExchangeButtonActionPerformed

    private void menuSetoranButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSetoranButtonActionPerformed
        KelolaSetoran menuSetoran = new KelolaSetoran();
        menuSetoran.setVisible(true);
        menuSetoran.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_menuSetoranButtonActionPerformed
                                        

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
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DashboardAdmin dashboard = new DashboardAdmin();
                dashboard.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton menuExchangeButton;
    private javax.swing.JButton menuSetoranButton;
    // End of variables declaration//GEN-END:variables
}