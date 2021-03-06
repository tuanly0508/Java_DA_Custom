/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_DichVu;

import Controller.DichVuController;
import Help.ChuyenDoi;
import Help.DataValidate;
import Help.ThongBao;
import Help.XuatExcel;
import Model.DanhMuc;
import Model.DichVu;
import Model.DonViTinh;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import swing.ScrollBar;


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
        
        JPanel p = new JPanel();
        jScrollPane2.setVerticalScrollBar(new ScrollBar());
        jScrollPane2.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);       
        jScrollPane2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        placeholderNhanVien();
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
    
    public void placeholderNhanVien() {
        txtTimNhanVien.setText("T??m d???ch v???");
        txtTimNhanVien.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimNhanVien.getText().equals("T??m d???ch v???") || txtTimNhanVien.getText().equals(txtTimNhanVien.getText())) {
                    txtTimNhanVien.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimNhanVien.getText().isEmpty()) {
                    txtTimNhanVien.setText("T??m d???ch v???");
                }
            }
        });
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
        roundPanel3 = new swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVu = new swing.Table();
        jLabel4 = new javax.swing.JLabel();
        txtTimNhanVien = new swing.TextInputTT();
        btnXuatDanhSach = new swing.Button();
        roundPanel4 = new swing.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTenDichVu = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuongCon = new swing.TextField();
        txtGiaBan = new swing.TextField();
        btnThem = new swing.Button();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        cbxDanhMuc = new swing.ComboBoxSuggestion<>();
        cbxDonViTinh = new swing.ComboBoxSuggestion<>();

        setBackground(new java.awt.Color(218, 232, 232));
        setMaximumSize(null);
        setName(""); // NOI18N

        roundPanel1.setBackground(new java.awt.Color(218, 232, 232));

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
                "idDichVu", "T??n D???ch V???", "Danh M???c", "????n v??? T??nh", "S??? L?????ng c??n", "Gi?? b??n"
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
        jLabel4.setText("DANH S??CH D???CH V???");

        txtTimNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNhanVienKeyReleased(evt);
            }
        });

        btnXuatDanhSach.setBackground(new java.awt.Color(120, 225, 220));
        btnXuatDanhSach.setText("Xu???t File Excel");
        btnXuatDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDanhSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(btnXuatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnXuatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CHI TI???T D???CH V???");

        txtTenDichVu.setLabelText("T??n d???ch v???");

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("T??n danh m???c");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("????n v??? t??nh");

        txtSoLuongCon.setLabelText("S??? l?????ng c??n");

        txtGiaBan.setLabelText("Gi?? b??n");
        txtGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaBanKeyReleased(evt);
            }
        });

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

        cbxDanhMuc.setEditable(false);
        cbxDanhMuc.setMinimumSize(new java.awt.Dimension(30, 22));
        cbxDanhMuc.setPreferredSize(new java.awt.Dimension(30, 22));

        cbxDonViTinh.setEditable(false);
        cbxDonViTinh.setMinimumSize(new java.awt.Dimension(30, 22));
        cbxDonViTinh.setPreferredSize(new java.awt.Dimension(30, 22));

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
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuongCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDonViTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
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
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtSoLuongCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        StringBuilder sb = new StringBuilder();
        String tenDichVu = txtTenDichVu.getText();
        DataValidate.checkEmpty(tenDichVu, sb, "T??n d???ch v??? kh??ng ???????c ????? tr???ng.");
        
        Integer soLuongCon = 0;
        try {
            soLuongCon = Integer.parseInt(txtSoLuongCon.getText()) ;
            if(soLuongCon < 0){
                sb.append("S??? l?????ng c??n ph???i l???n h???n 0 \n");
            }
        } catch (Exception e) {
            sb.append("S??? l?????ng c??n ph???i l?? s??? \n");
        } 
        
        double giaBan = 0;
        giaBan=ChuyenDoi.SoDouble(txtGiaBan.getText());
        if(giaBan<=0){
            sb.append("Gi?? b??n ph???i l???n h??n 0 \n");
        }
        
        DanhMuc danhMuc =(DanhMuc) cbxDanhMuc.getSelectedItem();
        Integer idDanhMuc = danhMuc.getIdDanhMuc();
        
        DonViTinh donViTinh =(DonViTinh) cbxDonViTinh.getSelectedItem();
        Integer idDonViTinh = donViTinh.getIdDonViTinh();
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            DichVu dv = new DichVu(0,idDanhMuc,idDonViTinh,tenDichVu,soLuongCon,giaBan,true);
            dichVuController.themDichVu(dv);
            ThongBao.ThongBaoDon("Th??m m???i d???ch v??? th??nh c??ng", "Th??ng b??o");
        }        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int dongXoa = tblDichVu.getSelectedRow();
        if (dongXoa == -1) {
            ThongBao.ThongBaoDon("Vui l??ng ch???n d???ch v??? c???n xo??", "Th??ng b??o");
        }else{
            int click = ThongBao.LuaChonFix("X??c nh???n xo?? ?", "");
            if (click == 1) {
                int idDichVu = (Integer)tblDichVu.getValueAt(dongXoa, 0);
                dichVuController.xoaDichVu(idDichVu);
            }
            ThongBao.ThongBaoDon("Xo?? th??nh c??ng !", "Th??ng b??o");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked

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
            ThongBao.ThongBaoDon("Ch???n d??ng c???n s???a", "Th??ng b??o");
        } else {
            int clickLuu = ThongBao.LuaChonFix("X??c nh???n s???a ?", "");
            if (clickLuu == 1) {
                StringBuilder sb = new StringBuilder();
                
                String tenDichVu = txtTenDichVu.getText();
                DataValidate.checkEmpty(tenDichVu, sb, "T??n d???ch v??? kh??ng ???????c ????? tr???ng.");
                Integer soLuongCon = 0;
                try {
                    soLuongCon = Integer.parseInt(txtSoLuongCon.getText()) ;
                    if(soLuongCon < 0){
                        sb.append("S??? l?????ng c??n ph???i l???n h???n 0 \n");
                    }
                } catch (Exception e) {
                    sb.append("S??? l?????ng c??n ph???i l?? s??? \n");
                } 
                
                double giaBan = 0;
                giaBan=ChuyenDoi.SoDouble(txtGiaBan.getText());
                if(giaBan<=0){
                    sb.append("Gi?? b??n ph???i l???n h??n 0 \n");
                }
                
                
                DanhMuc danhMuc =(DanhMuc) cbxDanhMuc.getSelectedItem();
                Integer idDanhMuc = danhMuc.getIdDanhMuc();

                DonViTinh donViTinh =(DonViTinh) cbxDonViTinh.getSelectedItem();
                Integer idDonViTinh = donViTinh.getIdDonViTinh();
                int idDichVu = (Integer)tblDichVu.getValueAt(chonDong, 0);
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    DichVu dv = new DichVu(idDichVu,idDanhMuc,idDonViTinh,tenDichVu,soLuongCon,giaBan,true);
                    dichVuController.suaDichVu(dv);
                    dichVuController.loadListDichVu();
                    ThongBao.ThongBaoDon("C???p nh???t d???ch v??? th??nh c??ng", "Th??ng b??o");
                }    
            }
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTimNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNhanVienKeyReleased
        dichVuController.timDichVu(txtTimNhanVien.getText());
    }//GEN-LAST:event_txtTimNhanVienKeyReleased

    private void btnXuatDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDanhSachActionPerformed
        XuatExcel.xuat(tblDichVu);
    }//GEN-LAST:event_btnXuatDanhSachActionPerformed

    private void txtGiaBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanKeyReleased
        double khachDua = ChuyenDoi.SoDouble(txtGiaBan.getText());
        txtGiaBan.setText(ChuyenDoi.SoString(khachDua));
    }//GEN-LAST:event_txtGiaBanKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public swing.Button btnSua;
    public swing.Button btnThem;
    public swing.Button btnXoa;
    private swing.Button btnXuatDanhSach;
    public swing.ComboBoxSuggestion<DanhMuc> cbxDanhMuc;
    public swing.ComboBoxSuggestion<DonViTinh> cbxDonViTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel3;
    private swing.RoundPanel roundPanel4;
    public swing.Table tblDichVu;
    public swing.TextField txtGiaBan;
    public swing.TextField txtSoLuongCon;
    public swing.TextField txtTenDichVu;
    public swing.TextInputTT txtTimNhanVien;
    // End of variables declaration//GEN-END:variables
}
