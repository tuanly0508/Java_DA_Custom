/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_DichVu;

import Controller.DichVuController;
import Help.ChuyenDoi;
import Model.DanhMuc;
import Model.DichVu;
import Model.DonViTinh;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JComponent.UNDEFINED_CONDITION;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class QlDichVuPnl extends javax.swing.JPanel {

    DichVuController dichVuController ;
    /**
     * Creates new form QlDichVuPnl
     */
    public QlDichVuPnl() {
        initComponents();
    }

    
    public void setController (DichVuController dichVuController) {
        this.dichVuController = dichVuController;
    }
    
    
    public void viewTableDichVu(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();      
        for (int i = tblDichVu.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Object[] objects : data) {
            model.addRow(objects);
        }
    }
    
    public void FillDataComboBoxDanhMuc() {
        List<DanhMuc> danhMucs = dichVuController.getDanhMuc();
        cbxDanhMuc.removeAllItems();
        for (DanhMuc danhMuc : danhMucs) {
            cbxDanhMuc.addItem(danhMuc);
        }
    }
    
    public void FillDataComboBoxDonViTinh() {
        List<DonViTinh> donViTinhs = dichVuController.getDonViTinh();
        cbxDonViTinh.removeAllItems();
        for (DonViTinh donViTinh : donViTinhs) {
            cbxDonViTinh.addItem(donViTinh);
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

        roundPanel4 = new GUI.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTenDichVu = new GUI.TextField();
        cbxDanhMuc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxDonViTinh = new javax.swing.JComboBox<>();
        txtSoLuongCon = new GUI.TextField();
        txtGiaBan = new GUI.TextField();
        btnThem = new GUI.Button();
        btnSua = new GUI.Button();
        btnXoa = new GUI.Button();
        roundPanel3 = new GUI.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVu = new GUI.Table();
        jLabel4 = new javax.swing.JLabel();
        txtTimNhanVien = new swing.TextInput();
        button3 = new GUI.Button();

        setBackground(new java.awt.Color(218, 232, 232));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CHI TIẾT DỊCH VỤ");

        txtTenDichVu.setLabelText("Tên dịch vụ");

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Tên danh mục");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Đơn vị tính");

        txtSoLuongCon.setLabelText("Số lượng còn");

        txtGiaBan.setLabelText("Giá bán");

        btnThem.setBackground(new java.awt.Color(120, 225, 220));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(120, 225, 220));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(120, 225, 220));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDonViTinh, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuongCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtSoLuongCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idDichVu", "Tên Dịch Vụ", "Danh Mục", "Đơn vị Tính", "Số Lượng còn", "Giá bán"
            }
        ));
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDichVu);
        if (tblDichVu.getColumnModel().getColumnCount() > 0) {
            tblDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("DANH SÁCH DỊCH VỤ");

        button3.setBackground(new java.awt.Color(120, 225, 220));
        button3.setText("File");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String tenDichVu = txtTenDichVu.getText();
        String soLuongCon = txtSoLuongCon.getText();
        String giaBan = txtGiaBan.getText();
        
        DanhMuc danhMuc =(DanhMuc) cbxDanhMuc.getSelectedItem();
        Integer idDanhMuc = danhMuc.getIdDanhMuc();
        
        DonViTinh donViTinh =(DonViTinh) cbxDonViTinh.getSelectedItem();
        Integer idDonViTinh = donViTinh.getIdDonViTinh();
        
        DichVu dv = new DichVu(0,idDanhMuc,idDonViTinh,tenDichVu,Integer.parseInt(soLuongCon),Double.parseDouble(giaBan));
        dichVuController.themDichVu(dv);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int dongXoa = tblDichVu.getSelectedRow();
        if (dongXoa == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xoá !");
        }else{
            int click = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
            if (click == JOptionPane.YES_OPTION) {
                dichVuController.xoaDichVu((Integer)tblDichVu.getValueAt(dongXoa, 0));
            }
            JOptionPane.showMessageDialog(new Frame(),"Xóa thành công !");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        DefaultTableModel ml = (DefaultTableModel) tblDichVu.getModel();
        int click = tblDichVu.getSelectedRow();
        DichVu dv = dichVuController.getByIdDichVu((Integer) tblDichVu.getValueAt(click, 0));
        
        txtTenDichVu.setText(tblDichVu.getValueAt(click, 1).toString());
        txtSoLuongCon.setText(tblDichVu.getValueAt(click, 4).toString());
        txtGiaBan.setText(tblDichVu.getValueAt(click, 5).toString());
        
        for (int i = 0; i < cbxDanhMuc.getItemCount(); i++) {
            DanhMuc c = (DanhMuc) cbxDanhMuc.getItemAt(i);
            if (c.getIdDanhMuc().equals(dv.getIdDanhMuc())) {
                cbxDanhMuc.setSelectedIndex(i);
            }
        }
        
        for (int i = 0; i < cbxDonViTinh.getItemCount(); i++) {
            DonViTinh c = (DonViTinh) cbxDonViTinh.getItemAt(i);
            if (c.getIdDonViTinh().equals(dv.getIdDonViTinh())) {
                cbxDonViTinh.setSelectedIndex(i);
            }
        }
        
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int chonDong = tblDichVu.getSelectedRow();
        if (chonDong == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa !!!","Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            int clickLuu = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn sửa không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
            if (clickLuu == JOptionPane.YES_OPTION) {
                String tenDichVu = txtTenDichVu.getText();
                String soLuongCon = txtSoLuongCon.getText();
                String giaBan = txtGiaBan.getText();

                DanhMuc danhMuc =(DanhMuc) cbxDanhMuc.getSelectedItem();
                Integer idDanhMuc = danhMuc.getIdDanhMuc();

                DonViTinh donViTinh =(DonViTinh) cbxDonViTinh.getSelectedItem();
                Integer idDonViTinh = donViTinh.getIdDonViTinh();
                int idDichVu = (Integer)tblDichVu.getValueAt(chonDong, 0);
                DichVu dv = new DichVu(idDichVu,idDanhMuc,idDonViTinh,tenDichVu,Integer.parseInt(soLuongCon),ChuyenDoi.SoDouble(giaBan));
                dichVuController.suaDichVu(dv);
            }
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public GUI.Button btnSua;
    public GUI.Button btnThem;
    public GUI.Button btnXoa;
    private GUI.Button button3;
    public javax.swing.JComboBox<DanhMuc> cbxDanhMuc;
    public javax.swing.JComboBox<DonViTinh> cbxDonViTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private GUI.RoundPanel roundPanel3;
    private GUI.RoundPanel roundPanel4;
    public GUI.Table tblDichVu;
    public GUI.TextField txtGiaBan;
    public GUI.TextField txtSoLuongCon;
    public GUI.TextField txtTenDichVu;
    public swing.TextInput txtTimNhanVien;
    // End of variables declaration//GEN-END:variables
}
