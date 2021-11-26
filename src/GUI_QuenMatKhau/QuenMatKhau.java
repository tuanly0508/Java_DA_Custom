package GUI_QuenMatKhau;

import Controller.QuenMatKhauController;
import GUI_Login.Login;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class QuenMatKhau extends javax.swing.JFrame {
    private QuenMatKhauController quenMatKhauController;  
    private Login lg;
    
    public QuenMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
        lg = new Login();
        quenMatKhauController = new QuenMatKhauController(this);
        btnDone.setVisible(false);
        btnSearch.setVisible(true);
        btnFail.setVisible(false);
        btnDoneCode.setVisible(false);
        btnSearchCode.setVisible(false);
        btnFailCode.setVisible(false);
    }
    
    private void goWebsite(JLabel website) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/#inbox"));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDone = new GUI.Button();
        btnSearch = new GUI.Button();
        btnFail = new GUI.Button();
        btnSearchCode = new GUI.Button();
        btnDoneCode = new GUI.Button();
        btnFailCode = new GUI.Button();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new GUI.TextField();
        txtCode = new GUI.TextField();
        lblErrEmail = new javax.swing.JLabel();
        lblErrCode = new javax.swing.JLabel();
        lblErrRePass = new javax.swing.JLabel();
        btnXacNhan = new GUI.Button();
        btnBackLogin = new GUI.Button();
        txtPass = new GUI_Login.PasswordField();
        txtRePass = new GUI_Login.PasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(372, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        btnDone.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnDone.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnDone.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 77, -1, 40));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        btnFail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close (1).png"))); // NOI18N
        btnFail.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFail.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnFail.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnFail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnFail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        btnSearchCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearchCode.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSearchCode.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSearchCode.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSearchCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearchCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCodeActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearchCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 147, -1, 40));

        btnDoneCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        btnDoneCode.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnDoneCode.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnDoneCode.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDoneCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnDoneCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        btnFailCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close (1).png"))); // NOI18N
        btnFailCode.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFailCode.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnFailCode.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnFailCode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnFailCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 360, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtEmail.setLabelText("Email");
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 74, 298, 45));

        txtCode.setEditable(false);
        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCode.setLabelText("Code");
        txtCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCodeMouseClicked(evt);
            }
        });
        jPanel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 146, 298, 45));

        lblErrEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblErrEmail.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblErrEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 125, 298, 15));

        lblErrCode.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblErrCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 197, 298, 15));

        lblErrRePass.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblErrRePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 298, 15));

        btnXacNhan.setBackground(new java.awt.Color(25, 182, 247));
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        jPanel1.add(btnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 375, 298, 45));

        btnBackLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btnBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 39, -1));

        txtPass.setEditable(false);
        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtPass.setLabelText("Mật khẩu mới");
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassMouseClicked(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 298, 45));

        txtRePass.setEditable(false);
        txtRePass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtRePass.setLabelText("Nhập lại mật khẩu");
        txtRePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRePassMouseClicked(evt);
            }
        });
        jPanel1.add(txtRePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 298, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackLoginActionPerformed
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackLoginActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        List<Object[]> data = quenMatKhauController.timEmail(txtEmail.getText());
        
        if(data.size()>0 && data.get(0)[0].toString().equals(txtEmail.getText())) {
            btnDone.setVisible(true);
            btnSearch.setVisible(false);
            btnFail.setVisible(false);
            
            String abc = generateRandomString();
            quenMatKhauController.updateCode(txtEmail.getText(),abc);
            Object[] info = new Object[3];
            info[0]=txtEmail.getText();
            info[1]="ResetPass";
            info[2]=abc;
            quenMatKhauController.sendMail(info);
        
            lblErrEmail.setForeground(Color.magenta);
            lblErrEmail.setText("<html>Email hợp lệ. Kiểm tra email <a href=\\\"\\\">tại đây</a></html>");
            goWebsite(lblErrEmail);  
            txtCode.setEditable(true);
            btnSearchCode.setVisible(true);
        }else if (txtEmail.getText().equals("")) {
            lblErrEmail.setText("Email không được để trống");
        }else {
            btnDone.setVisible(false);
            btnSearch.setVisible(false);
            btnFail.setVisible(true);
            lblErrEmail.setText("Vui lòng nhập lại email");            
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        btnDone.setVisible(false);
        btnSearch.setVisible(true);
        btnFail.setVisible(false);
        lblErrEmail.setText("");
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodeMouseClicked
        List<Object[]> data = quenMatKhauController.timEmail(txtEmail.getText());
        if(data.size()<=0) {  
            lblErrEmail.setText("Vui lòng kiểm tra email"); 
        }else {
            btnSearchCode.setVisible(true);
            btnDoneCode.setVisible(false);
            btnFailCode.setVisible(false);
            lblErrCode.setText("");
        }
    }//GEN-LAST:event_txtCodeMouseClicked

    private void btnSearchCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCodeActionPerformed
        String code = txtCode.getText();
        List<Object[]> data = quenMatKhauController.getCode(txtEmail.getText());
        if(data.size()>0 && data.get(0)[0].toString().equals(code)){
            btnDoneCode.setVisible(true);
            btnSearchCode.setVisible(false);
            btnFailCode.setVisible(false);
            txtPass.setEditable(true);
            txtRePass.setEditable(true);
        }else if (code.equals("")) {
            lblErrCode.setText("Code không được để trống");
        }else {
            btnDoneCode.setVisible(false);
            btnSearchCode.setVisible(false);
            btnFailCode.setVisible(true);
            lblErrCode.setText("Vui lòng nhập lại code");
        }
    }//GEN-LAST:event_btnSearchCodeActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        String pass = new String(txtPass.getPassword());
        String rePass = new String(txtRePass.getPassword());
        List<Object[]> data = quenMatKhauController.timEmail(txtEmail.getText());
        List<Object[]> dataCode = quenMatKhauController.getCode(txtEmail.getText());
        if(data.size()<=0) {  
            lblErrEmail.setText("Vui lòng kiểm tra email");
        }else if(dataCode.size()>0 && dataCode.get(0)[0].toString().equals(txtEmail.getText())){           
        }else if(!pass.equals(rePass)){
            lblErrRePass.setText("Mật khẩu không khớp");
        }else if(pass.equals(rePass)){
            quenMatKhauController.updatePass(txtEmail.getText(),pass);
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
            this.dispose();
            lg.setVisible(true);
        }else lblErrCode.setText("Vui lòng kiểm tra code");
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        List<Object[]> data = quenMatKhauController.timEmail(txtEmail.getText());
        List<Object[]> dataCode = quenMatKhauController.getCode(txtEmail.getText());
        if(data.size()<=0) {  
            lblErrEmail.setText("Vui lòng kiểm tra email");
        }else if(dataCode.size()>0 && dataCode.get(0)[0].toString().equals(txtCode.getText())){           
        }else lblErrCode.setText("Vui lòng kiểm tra code");
    }//GEN-LAST:event_txtPassMouseClicked

    private void txtRePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRePassMouseClicked
        List<Object[]> data = quenMatKhauController.timEmail(txtEmail.getText());
        List<Object[]> dataCode = quenMatKhauController.getCode(txtEmail.getText());
        if(data.size()<=0) {  
            lblErrEmail.setText("Vui lòng kiểm tra email");
        }else if(dataCode.size()>0 && dataCode.get(0)[0].toString().equals(txtCode.getText())){           
        }else lblErrCode.setText("Vui lòng kiểm tra code");

    }//GEN-LAST:event_txtRePassMouseClicked

    String CHAR_LIST = "0123456789";
    public String generateRandomString(){
        int RANDOM_STRING_LENGTH = 6;
            StringBuffer randStr = new StringBuffer();
            for(int i=0; i<RANDOM_STRING_LENGTH; i++)
        {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    
    private int getRandomNumber(){
	int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } 
        else {
            return randomInt - 1;
        }
    }
    
    public void setController (QuenMatKhauController quenMatKhauController) {
        this.quenMatKhauController = quenMatKhauController;
    }
    
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
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button btnBackLogin;
    private GUI.Button btnDone;
    private GUI.Button btnDoneCode;
    private GUI.Button btnFail;
    private GUI.Button btnFailCode;
    private GUI.Button btnSearch;
    private GUI.Button btnSearchCode;
    private GUI.Button btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblErrCode;
    private javax.swing.JLabel lblErrEmail;
    private javax.swing.JLabel lblErrRePass;
    private GUI.TextField txtCode;
    private GUI.TextField txtEmail;
    private GUI_Login.PasswordField txtPass;
    private GUI_Login.PasswordField txtRePass;
    // End of variables declaration//GEN-END:variables
}
