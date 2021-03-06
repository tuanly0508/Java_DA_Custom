package View_KhachHang;

import Controller.KhachHangController;
import Help.ChuyenDoi;
import Help.DataValidate;
import Help.ThongBao;
import Help.XuatExcel;
import java.util.List;
import Model.KhachHang;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import swing.ScrollBar;

public class KhachHangPnl extends javax.swing.JPanel {
    private KhachHangController khachHangController;
    
    public KhachHangPnl() {
        initComponents();
        
        JPanel p = new JPanel();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);       
        jScrollPane1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        placeholderNhanVien();
    }
    
    public void placeholderNhanVien() {
        txtTimNhanVien.setText("Tìm khách hàng");
        txtTimNhanVien.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimNhanVien.getText().equals("Tìm khách hàng") || txtTimNhanVien.getText().equals(txtTimNhanVien.getText())) {
                    txtTimNhanVien.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimNhanVien.getText().isEmpty()) {
                    txtTimNhanVien.setText("Tìm khách hàng");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new swing.RoundPanel();
        roundPanel2 = new swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new swing.Table();
        jLabel2 = new javax.swing.JLabel();
        txtTimNhanVien = new swing.TextInputTT();
        btnXoa1 = new swing.Button();
        roundPanel3 = new swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThem = new swing.Button();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        txtSDT = new swing.TextField();
        txtTenKhach = new swing.TextField();
        txtTienNo = new swing.TextField();
        txtTienSuDung = new swing.TextField();
        txtGhiChu = new swing.TextField();
        rdbNo = new swing.BtnRadioCus();
        rdbKhongNo = new swing.BtnRadioCus();

        roundPanel1.setBackground(new java.awt.Color(218, 232, 232));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Số điện thoại", "Tên khách", "Tiền nợ", "Tiền sử dụng", "Trả sau", "Ghi chú", "tinhTrang"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(6).setMinWidth(0);
            tblKhachHang.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblKhachHang.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("DANH SÁCH KHÁCH HÀNG");

        btnXoa1.setBackground(new java.awt.Color(120, 225, 220));
        btnXoa1.setText("Xuất Excel");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");

        btnThem.setBackground(new java.awt.Color(120, 225, 220));
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(120, 225, 220));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(120, 225, 220));
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtSDT.setLabelText("Số điện thoại");

        txtTenKhach.setLabelText("Tên khách hàng");

        txtTienNo.setLabelText("Tiền nợ");
        txtTienNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNoKeyReleased(evt);
            }
        });

        txtTienSuDung.setLabelText("Tiền sử dụng");
        txtTienSuDung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienSuDungKeyReleased(evt);
            }
        });

        txtGhiChu.setLabelText("Ghi chú");

        buttonGroup1.add(rdbNo);
        rdbNo.setSelected(true);
        rdbNo.setText("Nợ");

        buttonGroup1.add(rdbKhongNo);
        rdbKhongNo.setText("Không nợ");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienSuDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(rdbNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                                .addComponent(rdbKhongNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtTienNo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtTienSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbKhongNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int chonDong = tblKhachHang.getSelectedRow();
        if (chonDong == -1) {
            ThongBao.ThongBaoDon("Vui lòng chọn dòng cần sửa", "Thông báo");
        } else {
            int update = JOptionPane.showConfirmDialog(new Frame(), "Bạn có muốn sửa không?","Thông báo", JOptionPane.YES_NO_OPTION);
            if(update == JOptionPane.YES_OPTION){
                StringBuilder sb = new StringBuilder();
                
                String SDTKhachHang = txtSDT.getText();
                DataValidate.checkEmpty(SDTKhachHang, sb, "Số điện thoại không được để trống! ");
                DataValidate.checkSdtForm(SDTKhachHang, sb);                
                
                String tenKhachHang = txtTenKhach.getText();
                DataValidate.checkEmpty(tenKhachHang, sb, "Tên không được để trống");
                
                double tienNo = 0;
                tienNo = ChuyenDoi.SoDouble(txtTienNo.getText()) ;

                double tienSuDung = 0;
                tienSuDung = ChuyenDoi.SoDouble(txtTienSuDung.getText()) ;        

                Boolean no = true;
                if(rdbNo.isSelected()){
                    no = true;
                }else if(rdbKhongNo.isSelected()){
                    no = false;
                }
                String ghiChu = txtGhiChu.getText();
                if(ghiChu.equals("")){
                    ghiChu="không";
                }
                
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    KhachHang kh= new KhachHang(SDTKhachHang,tenKhachHang,tienNo,tienSuDung,no,ghiChu,true);
                    khachHangController.update(kh);
                    ThongBao.ThongBaoDon("Cập nhật thông tin khách thành công !", "Thông báo");
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        StringBuilder sb = new StringBuilder();
        
        String sdtKhachHang = txtSDT.getText();
        DataValidate.checkEmpty(sdtKhachHang, sb, "Số điện thoại không được để trống! ");
        DataValidate.checkSdtForm(sdtKhachHang, sb);
        DataValidate.checkSDTKhachHangExist(sdtKhachHang, sb);
        
        String tenKhachHang = txtTenKhach.getText();
        DataValidate.checkEmpty(tenKhachHang, sb, "Tên không được để trống");
        
        double tienNo = 0;
        tienNo = ChuyenDoi.SoDouble(txtTienNo.getText()) ;

        
        double tienSuDung = 0;
        tienSuDung = ChuyenDoi.SoDouble(txtTienSuDung.getText()) ;

        boolean no = true;
        if(rdbNo.isSelected()){
            no = true;
        }else if(rdbKhongNo.isSelected()){
            no = false;
        }
        
        String ghiChu = txtGhiChu.getText();
        if(ghiChu.equals("")){
            ghiChu="không";
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{        
            KhachHang kh = new KhachHang(sdtKhachHang,tenKhachHang,tienNo, tienSuDung, no, ghiChu, true);
            khachHangController.insert(kh);
            ThongBao.ThongBaoDon("Thêm mới Khách hàng thành công", "Thông báo");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked

        int click = tblKhachHang.getSelectedRow();
        txtSDT.setText((String) tblKhachHang.getValueAt(click, 0));
        txtTenKhach.setText((String) tblKhachHang.getValueAt(click, 1));
        txtTienNo.setText(tblKhachHang.getValueAt(click, 2).toString());
        txtTienSuDung.setText(tblKhachHang.getValueAt(click, 3).toString());
        
        if(tblKhachHang.getValueAt(click, 4).toString().equals("Không")){                        
            rdbKhongNo.setSelected(true);
        }else{
            rdbNo.setSelected(true);
        }
        txtGhiChu.setText((String) tblKhachHang.getValueAt(click, 5));        
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int dongXoa = tblKhachHang.getSelectedRow();
        if (dongXoa == -1) {
            ThongBao.ThongBaoDon("Chọn dòng cần xoá", "Thông báo");
        } else {
            int click = ThongBao.LuaChonFix("Xác nhận xoá ?", "");
            if (click == 1) {
                khachHangController.delete((String) tblKhachHang.getValueAt(dongXoa, 0));
                ThongBao.ThongBaoDon("Xoá thành công !", "Thông báo");
                khachHangController.loadList();
            }
        }  
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        XuatExcel.xuat(tblKhachHang);
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void txtTienNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNoKeyReleased
        double khachDua = ChuyenDoi.SoDouble(txtTienNo.getText());
        txtTienNo.setText(ChuyenDoi.SoString(khachDua));
    }//GEN-LAST:event_txtTienNoKeyReleased

    private void txtTienSuDungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienSuDungKeyReleased
        double khachDua = ChuyenDoi.SoDouble(txtTienSuDung.getText());
        txtTienSuDung.setText(ChuyenDoi.SoString(khachDua));
    }//GEN-LAST:event_txtTienSuDungKeyReleased

    
    public void viewTableStaff(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        for(int i = tblKhachHang.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }
        for(Object[] objects : data){
            model.addRow(objects);
        }
    }
    
    public void setController (KhachHangController khachHangController) {
        this.khachHangController = khachHangController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnXoa;
    private swing.Button btnXoa1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private swing.BtnRadioCus rdbKhongNo;
    private swing.BtnRadioCus rdbNo;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel2;
    private swing.RoundPanel roundPanel3;
    private swing.Table tblKhachHang;
    private swing.TextField txtGhiChu;
    private swing.TextField txtSDT;
    private swing.TextField txtTenKhach;
    private swing.TextField txtTienNo;
    private swing.TextField txtTienSuDung;
    private swing.TextInputTT txtTimNhanVien;
    // End of variables declaration//GEN-END:variables
}
