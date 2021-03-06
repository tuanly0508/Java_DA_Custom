/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_DichVu;

import Controller.DichVuController;
import Help.DataValidate;
import Help.ThongBao;
import Model.DanhMuc;
import Model.DonViTinh;
import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class DanhmucVaDonViPnl extends javax.swing.JPanel {

    
    DichVuController dichVuController ;
    
    public DanhmucVaDonViPnl() {
        initComponents();
    }

    public void setController (DichVuController dichVuController) {
        this.dichVuController = dichVuController;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing.RoundPanel();
        roundPanel2 = new swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonViTinh = new swing.Table();
        btnThem1 = new swing.Button();
        btnSua1 = new swing.Button();
        btnXoa1 = new swing.Button();
        txtTenDanhMuc1 = new swing.TextField();
        txtGiaTri = new swing.TextField();
        roundPanel3 = new swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhMuc = new swing.Table();
        btnThem = new swing.Button();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        txtTenDanhMuc = new swing.TextField();

        setBackground(new java.awt.Color(218, 232, 232));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        roundPanel1.setBackground(new java.awt.Color(218, 232, 232));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DANH S??CH ????N V??? T??NH");

        tblDonViTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID ????n v??? t??nh", "T??n ????n v???", "Gi?? tr???"
            }
        ));
        tblDonViTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonViTinhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDonViTinh);

        btnThem1.setBackground(new java.awt.Color(120, 225, 220));
        btnThem1.setText("Th??m");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setBackground(new java.awt.Color(120, 225, 220));
        btnSua1.setText("S???a");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setBackground(new java.awt.Color(120, 225, 220));
        btnXoa1.setText("X??a");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        txtTenDanhMuc1.setLabelText("T??n Danh M???c");

        txtGiaTri.setLabelText("Gi?? tr???");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)))
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(txtTenDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(173, 173, 173)))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH S??CH DANH M???C D???CH V???");

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Danh M???c", "T??n Danh M???c"
            }
        ));
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhMuc);

        btnThem.setBackground(new java.awt.Color(120, 225, 220));
        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(120, 225, 220));
        btnSua.setText("S???a");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(120, 225, 220));
        btnXoa.setText("X??a");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTenDanhMuc.setLabelText("T??n Danh M???c");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 313, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 509, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(174, 174, 174)))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        StringBuilder sb = new StringBuilder();
        
        String tenDichVu = txtTenDanhMuc.getText();
        DataValidate.checkEmpty(tenDichVu, sb, "T??n danh m???c kh??ng ???????c ????? tr???ng! ");
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            DanhMuc dm = new DanhMuc(0,tenDichVu,true);
            dichVuController.themDanhMuc(dm);  
            ThongBao.ThongBaoDon("Th??m m???i danh m???c th??nh c??ng", "Th??ng b??o");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int chonDong = tblDanhMuc.getSelectedRow();
        if (chonDong == -1) {
            ThongBao.ThongBaoDon("Ch???n d??ng c???n s???a", "Th??ng b??o");
        } else {
            int clickLuu = JOptionPane.showConfirmDialog(new Frame(),"B???n c?? mu???n s???a kh??ng ?", "Th??ng b??o",JOptionPane.YES_NO_OPTION);
            if (clickLuu == JOptionPane.YES_OPTION) {
                StringBuilder sb = new StringBuilder();
                String tenDichVu = txtTenDanhMuc.getText();
                DataValidate.checkEmpty(tenDichVu, sb, "T??n danh m???c kh??ng ???????c ????? tr???ng! ");
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    DanhMuc dm = new DanhMuc((Integer)tblDanhMuc.getValueAt(chonDong, 0),tenDichVu,true);
                    dichVuController.suaDanhMuc(dm);     
                    ThongBao.ThongBaoDon("C???p nh???t danh m???c th??nh c??ng", "Th??ng b??o");
                }   
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int dongXoa = tblDanhMuc.getSelectedRow();
        if (dongXoa == -1) {
            ThongBao.ThongBaoDon("Vui l??ng ch???n danh m???c c???n xo??", "Th??ng b??o");
        }else{
            int click = ThongBao.LuaChonFix("X??c nh???n xo?? ?", "");
            if (click == 1){
                dichVuController.xoaDichVu((Integer)tblDanhMuc.getValueAt(dongXoa, 0));
                ThongBao.ThongBaoDon("Xo?? th??nh c??ng", "Th??ng b??o");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        StringBuilder sb = new StringBuilder();
        String tenDonVi = txtTenDanhMuc1.getText();
        DataValidate.checkEmpty(tenDonVi, sb, "T??n danh m???c kh??ng ???????c ????? tr???ng! ");
        Integer giaTri = 0;
        try {
            giaTri = Integer.parseInt(txtGiaTri.getText()) ;
            if(giaTri < 0){
                sb.append("Gi?? tr??? ph???i l???n h???n 0 \n");
            }
        } catch (Exception e) {
            sb.append("Gi?? tr??? ph???i l?? s??? \n");
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{    
            DonViTinh dvt = new DonViTinh(0,tenDonVi,giaTri,true);
            dichVuController.themDonViTinh(dvt); 
            ThongBao.ThongBaoDon("Th??m m???i th??nh c??ng", "Th??ng b??o");
        }          
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        int chonDong = tblDonViTinh.getSelectedRow();
        if (chonDong == -1) {
            ThongBao.ThongBaoDon("Ch???n d??ng c???n c???p nh???t", "Th??ng b??o");
        } else {
            int update = JOptionPane.showConfirmDialog(new Frame(), "B???n c?? mu???n s???a kh??ng?","Th??ng b??o", JOptionPane.YES_NO_OPTION);
            if(update == JOptionPane.YES_OPTION){
                StringBuilder sb = new StringBuilder();
                
                String tenDonVi = txtTenDanhMuc1.getText();
                DataValidate.checkEmpty(tenDonVi, sb, "T??n danh m???c kh??ng ???????c ????? tr???ng! ");
                Integer giaTri = 0;
                try {
                    giaTri = Integer.parseInt(txtGiaTri.getText()) ;
                    if(giaTri < 0){
                        sb.append("Gi?? tr??? ph???i l???n h???n 0 \n");
                    }
                } catch (Exception e) {
                    sb.append("Gi?? tr??? ph???i l?? s??? \n");
                }
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    DonViTinh dvt = new DonViTinh(Integer.parseInt(tblDonViTinh.getValueAt(chonDong, 0).toString()),tenDonVi,giaTri,true);
                    dichVuController.suaDonViTinh(dvt);        
                    ThongBao.ThongBaoDon("C???p nh???t ????n v??? th??nh c??ng", "Th??ng b??o");
                }                            
            }
        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        int dongXoa = tblDonViTinh.getSelectedRow();
        if (dongXoa == -1) {
            ThongBao.ThongBaoDon("Vui l??ng ch???n ????n v??? c???n xo??", "Th??ng b??o");
        }else{
            int click = ThongBao.LuaChonFix("X??c nh???n xo?? ?", "");
            if (click == 1){
                dichVuController.xoaDonViTinh((Integer)tblDonViTinh.getValueAt(dongXoa, 0));
                ThongBao.ThongBaoDon("Xo?? d???ch v??? th??nh c??ng", "Th??ng b??o");
            }
        }
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked

        int click = tblDanhMuc.getSelectedRow();
        txtTenDanhMuc.setText(tblDanhMuc.getValueAt(click, 1).toString());
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void tblDonViTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonViTinhMouseClicked

        int click = tblDonViTinh.getSelectedRow();
        txtTenDanhMuc1.setText(tblDonViTinh.getValueAt(click, 1).toString());
        txtGiaTri.setText(tblDonViTinh.getValueAt(click, 2).toString());
    }//GEN-LAST:event_tblDonViTinhMouseClicked

    
    public void viewTableDanhMuc(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();      
        for (int i = tblDanhMuc.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Object[] objects : data) {
            model.addRow(objects);
        }
    }
    
    public void viewTableDonViTinh(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDonViTinh.getModel();      
        for (int i = tblDonViTinh.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Object[] objects : data) {
            model.addRow(objects);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public swing.Button btnSua;
    public swing.Button btnSua1;
    public swing.Button btnThem;
    public swing.Button btnThem1;
    public swing.Button btnXoa;
    public swing.Button btnXoa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel2;
    private swing.RoundPanel roundPanel3;
    private swing.Table tblDanhMuc;
    private swing.Table tblDonViTinh;
    public swing.TextField txtGiaTri;
    public swing.TextField txtTenDanhMuc;
    public swing.TextField txtTenDanhMuc1;
    // End of variables declaration//GEN-END:variables
}
