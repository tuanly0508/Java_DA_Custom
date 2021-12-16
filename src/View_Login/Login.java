package View_Login;

import View.Main;
import Help.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author tuanl
 */
public class Login extends javax.swing.JFrame {

    public static String per ="User";
    public static int idNV =1;
    public static String tenNV="Admin";
    
    public Login() {
        initComponents();
        init();
        setLocationRelativeTo(null);
        lblLoading.setVisible(false);
        btnAnPass.setVisible(false);
        btnHienPass.setVisible(true);
    }
    
    public void init() {
        btnRePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHienPass = new swing.Button();
        btnAnPass = new swing.Button();
        jLabel1 = new javax.swing.JLabel();
        txtSdt = new swing.TextField();
        txtPass = new View_Login.PasswordField();
        btnLogin = new swing.Button();
        lblErrSdt = new javax.swing.JLabel();
        lblErrPass = new javax.swing.JLabel();
        lblLoading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRePass = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHienPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/visibility.png"))); // NOI18N
        btnHienPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienPassActionPerformed(evt);
            }
        });
        jPanel1.add(btnHienPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 20, -1));

        btnAnPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/visibility (1).png"))); // NOI18N
        btnAnPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnPassActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 20, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 360, -1));

        txtSdt.setLabelText("Số điện thoại");
        txtSdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSdtMouseClicked(evt);
            }
        });
        jPanel1.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 102, 298, 45));

        txtPass.setLabelText("Mật khẩu");
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassMouseClicked(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 298, 45));

        btnLogin.setBackground(new java.awt.Color(25, 182, 247));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 298, 45));

        lblErrSdt.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        lblErrSdt.setForeground(new java.awt.Color(255, 0, 0));
        lblErrSdt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(lblErrSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 153, 298, 21));

        lblErrPass.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        lblErrPass.setForeground(new java.awt.Color(255, 0, 0));
        lblErrPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(lblErrPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 298, 21));

        lblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loading.gif"))); // NOI18N
        jPanel1.add(lblLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 298, 45));

        jLabel2.setText("v0.1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 30, -1));

        btnRePass.setBackground(new java.awt.Color(255, 255, 255));
        btnRePass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnRePass.setText("Quên mật khẩu ?");
        btnRePass.setBorder(null);
        btnRePass.setBorderPainted(false);
        btnRePass.setContentAreaFilled(false);
        btnRePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRePassMouseExited(evt);
            }
        });
        btnRePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRePassActionPerformed(evt);
            }
        });
        jPanel1.add(btnRePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 100, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(338, 338, 338)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(178, 178, 178)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(278, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String sdt = txtSdt.getText();
        String password = String.valueOf(txtPass.getPassword()) ;
        btnLogin.setVisible(false);
        lblErrSdt.setText("");
        lblErrPass.setText("");
        
        if (sdt.equals("") && password.equals("")) {
            lblErrSdt.setText("Số điện thoại không được để trống");
            lblErrPass.setText("Mật khẩu không được để trống");
            btnLogin.setVisible(true);
        }else if (password.equals("")) {           
            lblErrPass.setText("Mật khẩu không được để trống");
            btnLogin.setVisible(true);
        }else if (sdt.equals("")) {
            lblErrSdt.setText("Số điện thoại không được để trống");
            btnLogin.setVisible(true);
        }else {
            new Thread() {
            @Override
                public void run() {
                    try {
                        lblLoading.setVisible(true);
                        this.sleep(1500); 
                        
                        PreparedStatement pst = DBConnection.prepareStatement("select * from NhanVien where soDienThoai='" + sdt + "'");
                        ResultSet rs = pst.executeQuery();
                            if (rs.next()) {
                                String pass = rs.getString("matKhau");
                                if (password.equals(pass)) {
                                    per = rs.getString("quyenHan");
                                    idNV= rs.getInt("idNhanVien");
                                    tenNV = rs.getString("hoTenNhanVien");
                                    Main ss = new Main();
                                    ss.show();
                                    dispose();
                                } else {
                                    lblErrPass.setText("Mật khẩu không hợp lệ");
                                    lblLoading.setVisible(false);
                                    btnLogin.setVisible(true);
                                }
                            } else {
                                lblErrSdt.setText("Số điện thoại không tồn tại");
                                lblLoading.setVisible(false);
                                btnLogin.setVisible(true);
                            }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtSdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSdtMouseClicked
        lblErrSdt.setText("");
    }//GEN-LAST:event_txtSdtMouseClicked

    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        lblErrPass.setText("");
    }//GEN-LAST:event_txtPassMouseClicked

    private void btnRePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRePassMouseEntered
        btnRePass.setForeground(Color.red);
    }//GEN-LAST:event_btnRePassMouseEntered

    private void btnRePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRePassMouseExited
        btnRePass.setForeground(Color.black);
    }//GEN-LAST:event_btnRePassMouseExited

    private void btnRePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRePassActionPerformed
        QuenMatKhau qmk = new QuenMatKhau();
        qmk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRePassActionPerformed

    private void btnHienPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienPassActionPerformed
        txtPass.setEchoChar((char)0);
        btnHienPass.setVisible(false);
        btnAnPass.setVisible(true);
    }//GEN-LAST:event_btnHienPassActionPerformed

    private void btnAnPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnPassActionPerformed
        txtPass.setEchoChar('*');
        btnHienPass.setVisible(true);
        btnAnPass.setVisible(false);
    }//GEN-LAST:event_btnAnPassActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnAnPass;
    private swing.Button btnHienPass;
    private swing.Button btnLogin;
    private javax.swing.JButton btnRePass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblErrPass;
    private javax.swing.JLabel lblErrSdt;
    private javax.swing.JLabel lblLoading;
    private View_Login.PasswordField txtPass;
    private swing.TextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
