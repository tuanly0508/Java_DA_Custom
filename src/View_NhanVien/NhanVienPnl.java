package View_NhanVien;

import Controller.NhanVienController;
import Help.DataValidate;
import Help.ThongBao;
import Help.XuatExcel;
import java.util.List;
import java.util.Date;
import Model.NhanVien;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import swing.ScrollBar;

public class NhanVienPnl extends javax.swing.JPanel {
    private NhanVienController nhanVienController;
    
    public NhanVienPnl() {
        initComponents();
        jdcNgaySinh.setDateFormatString("dd-MM-yyyy");
        jdcNgayVao.setDateFormatString("dd-MM-yyyy");
        
        JPanel p = new JPanel();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);       
        jScrollPane1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        placeholderNhanVien();
    }
    
    public void placeholderNhanVien() {
        txtTimNhanVien.setText("Tìm nhân viên");
        txtTimNhanVien.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimNhanVien.getText().equals("Tìm nhân viên") || txtTimNhanVien.getText().equals(txtTimNhanVien.getText())) {
                    txtTimNhanVien.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimNhanVien.getText().isEmpty()) {
                    txtTimNhanVien.setText("Tìm nhân viên");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        roundPanel1 = new swing.RoundPanel();
        roundPanel2 = new swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtHoTen = new swing.TextField();
        txtCMND = new swing.TextField();
        txtSDT = new swing.TextField();
        txtDiaChi = new swing.TextField();
        txtEmail = new swing.TextField();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jdcNgayVao = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new swing.Button();
        btnSua = new swing.Button();
        bntXoa = new swing.Button();
        rdbOff = new swing.BtnRadioCus();
        rdbOn = new swing.BtnRadioCus();
        rdbNam = new swing.BtnRadioCus();
        rdbNu = new swing.BtnRadioCus();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roundPanel3 = new swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new swing.Table();
        jLabel4 = new javax.swing.JLabel();
        button4 = new swing.Button();
        button5 = new swing.Button();
        txtTimNhanVien = new swing.TextInputTT();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(218, 232, 232));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN NHÂN VIÊN");

        txtHoTen.setLabelText("Họ và tên");

        txtCMND.setLabelText("CMND");

        txtSDT.setLabelText("Số điện thoại");

        txtDiaChi.setLabelText("Địa chỉ");

        txtEmail.setLabelText("Email");

        jdcNgaySinh.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Ngày Sinh");

        jdcNgayVao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Ngày vào làm");

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

        bntXoa.setBackground(new java.awt.Color(120, 225, 220));
        bntXoa.setText("XÓA");
        bntXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntXoaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdbOff);
        rdbOff.setText("Off");

        buttonGroup2.add(rdbOn);
        rdbOn.setSelected(true);
        rdbOn.setText("On");
        rdbOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOnActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbNam);
        rdbNam.setSelected(true);
        rdbNam.setText("Nam");
        rdbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");

        jLabel5.setText("Giới Tính:");

        jLabel6.setText("Trạng thái:");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(bntXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcNgayVao, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(22, 22, 22)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcNgayVao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "CMND", "SĐT", "Địa chỉ", "Giới tính", "Email", "VerifyCode", "Mật khẩu", "Quyền hạn", "Trạng thái", "Ngày sinh", "Ngày vào làm"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(0).setMaxWidth(0);
            tblNhanVien.getColumnModel().getColumn(1).setMinWidth(110);
            tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(110);
            tblNhanVien.getColumnModel().getColumn(1).setMaxWidth(110);
            tblNhanVien.getColumnModel().getColumn(6).setMinWidth(150);
            tblNhanVien.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblNhanVien.getColumnModel().getColumn(6).setMaxWidth(150);
            tblNhanVien.getColumnModel().getColumn(7).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(7).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(7).setMaxWidth(0);
            tblNhanVien.getColumnModel().getColumn(8).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(8).setMaxWidth(0);
            tblNhanVien.getColumnModel().getColumn(10).setMinWidth(70);
            tblNhanVien.getColumnModel().getColumn(10).setPreferredWidth(70);
            tblNhanVien.getColumnModel().getColumn(10).setMaxWidth(70);
            tblNhanVien.getColumnModel().getColumn(11).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(11).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(11).setMaxWidth(0);
            tblNhanVien.getColumnModel().getColumn(12).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(12).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(12).setMaxWidth(0);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("DANH SÁCH NHÂN VIÊN");

        button4.setBackground(new java.awt.Color(120, 225, 220));
        button4.setText("Xuất file");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(120, 225, 220));
        button5.setText("Gửi mail");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //validate hoTen
        StringBuilder sb = new StringBuilder();
        String hoTenNhanVien = txtHoTen.getText();
        DataValidate.checkEmpty(hoTenNhanVien, sb, "Tên không được để trống \n");
        
        String CMND = txtCMND.getText();       
        if(CMND.length() <= 9){
            DataValidate.checkCMND(CMND, sb);
        }else{
            DataValidate.checkSoHoChieu(CMND, sb);
        }
        DataValidate.checkCMNDExist(CMND, sb);
        
        String soDienThoai = txtSDT.getText();
        DataValidate.checkEmpty(soDienThoai, sb, "Số điện thoại không được để trống! \n");
        DataValidate.checkSdtForm(soDienThoai, sb);
        DataValidate.checkPhoneExist(soDienThoai, sb);
        
        String diaChi = txtDiaChi.getText();
        DataValidate.checkEmpty(diaChi, sb, "Địa chỉ không được để trống! \n");
        
        String email = txtEmail.getText();
        DataValidate.checkEmpty(email, sb, "Email không được để trống! \n");
        DataValidate.checkEmailForm(email, sb);
        DataValidate.checkEmailExist(email, sb);
        
        String gioiTinh = null;
        if(rdbNam.isSelected()){
            gioiTinh = "Nam";
        }else if(rdbNu.isSelected()){
            gioiTinh = "Nữ";
        }else{
            sb.append("Vui lòng chọn giới tính! \n");
        }
        
        
        String trangThai = null;
        if(rdbOn.isSelected()){
            trangThai = "On";
        }else if(rdbOff.isSelected()){
            trangThai = "Off";
        }else{
            sb.append("Vui lòng chọn trạng thái! \n");
        }
        
//        java.util.Date DateOfBirth1 = jdcNgaySinh.getDate();
//        java.sql.Date ngaySinh= new java.sql.Date(DateOfBirth1.getTime());
//        java.util.Date StartingDate1 = jdcNgayVao.getDate();
//        java.sql.Date ngayVao = new java.sql.Date(StartingDate1.getTime());  

        java.sql.Date ngaySinh = null,ngayVao = null;
        if(jdcNgaySinh.getDate() == null || jdcNgayVao.getDate() == null){
            sb.append("Vui lòng điền đủ ngày tháng ! \n");
        }else{
            java.util.Date nSinhRaw = jdcNgaySinh.getDate();
            ngaySinh = new java.sql.Date(nSinhRaw.getTime());
            
            java.util.Date nVaoRaw = jdcNgayVao.getDate();
            ngayVao = new java.sql.Date(nVaoRaw.getTime());
            DataValidate.checkNgayThang(nSinhRaw, nVaoRaw, sb);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            nhanVienController.insert(hoTenNhanVien,CMND,soDienThoai,diaChi,gioiTinh,email,trangThai,ngaySinh,ngayVao);
            ThongBao.ThongBaoDon("Thêm mới Nhân viên thành công", "Thông báo");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void rdbOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbOnActionPerformed

    private void rdbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbNamActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        DefaultTableModel ml = (DefaultTableModel) tblNhanVien.getModel();
        int click = tblNhanVien.getSelectedRow();
        NhanVien nv = nhanVienController.getByIdNyhanVien((Integer) tblNhanVien.getValueAt(click, 0));      
        
        txtHoTen.setText((String) tblNhanVien.getValueAt(click, 1));
        txtCMND.setText((String) tblNhanVien.getValueAt(click, 2));
        txtSDT.setText((String) tblNhanVien.getValueAt(click, 3));
        txtDiaChi.setText((String) tblNhanVien.getValueAt(click, 4));
        if(tblNhanVien.getValueAt(click, 5).toString().equals("Nam")){
            rdbNam.setSelected(true);
        }else{
            rdbNu.setSelected(true);
        }
        txtEmail.setText((String) tblNhanVien.getValueAt(click, 6));
        if(tblNhanVien.getValueAt(click, 10).toString().equals("On")){
            rdbOn.setSelected(true);
        }else{
            rdbOff.setSelected(true);
        }
        Date date = new Date(nv.getNgaySinh().getTime());
        jdcNgaySinh.setDate(date);
        date = new Date(nv.getNgayVaoLam().getTime());
        jdcNgayVao.setDate(date);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void bntXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntXoaActionPerformed
        int dongXoa = tblNhanVien.getSelectedRow();
        if (dongXoa == -1) {
            ThongBao.ThongBaoDon("Chọn dòng cần xoá", "Thông báo");
        } else {        
            int click = ThongBao.LuaChonFix("Xác nhận xoá ?", "");
            if (click == 1) {
                nhanVienController.xoaNhanVien((Integer)tblNhanVien.getValueAt(dongXoa, 0));
            }
            ThongBao.ThongBaoDon("Xoá thành công", "Thông báo");
        }
    }//GEN-LAST:event_bntXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int chonDong = tblNhanVien.getSelectedRow();
        if (chonDong == -1) {
            ThongBao.ThongBaoDon("Chọn dòng cần sửa", "Thông báo");
        } else {
            int update = ThongBao.LuaChonFix("Xác nhận sửa ?", "");
            if(update == 1){
                StringBuilder sb = new StringBuilder();
                
                String hoTenNhanVien = txtHoTen.getText();
                DataValidate.checkEmpty(hoTenNhanVien, sb, "Tên không được để trống! ");
                
                String CMND = txtCMND.getText();
                if(CMND.length() <= 9){
                    DataValidate.checkCMND(CMND, sb);
                }else{
                    DataValidate.checkSoHoChieu(CMND, sb);
                }
                
                String soDienThoai = txtSDT.getText();
                DataValidate.checkEmpty(soDienThoai, sb, "Số điện thoại không được để trống! ");
                DataValidate.checkSdtForm(soDienThoai, sb);
                                
                String diaChi = txtDiaChi.getText();
                DataValidate.checkEmpty(diaChi, sb, "Địa chỉ không được để trống! ");
                                
                String email = txtEmail.getText();
                DataValidate.checkEmpty(email, sb, "Email không được để trống! ");
                DataValidate.checkEmailForm(email, sb);                
                
                String gioiTinh = null;
                if(rdbNam.isSelected()){
                    gioiTinh = "Nam";
                }else{
                    gioiTinh = "Nữ";
                }
                String trangThai = null;
                if(rdbOn.isSelected()){
                    trangThai = "On";
                }else{
                    trangThai = "Off";
                }
                
//                java.util.Date DateOfBirth1 = jdcNgaySinh.getDate();
//                java.sql.Date ngaySinh= new java.sql.Date(DateOfBirth1.getTime());
//                java.util.Date StartingDate1 = jdcNgayVao.getDate();
//                java.sql.Date ngayVao = new java.sql.Date(StartingDate1.getTime());

                java.sql.Date ngaySinh = null,ngayVao = null;
                if(jdcNgaySinh.getDate() == null || jdcNgayVao.getDate() == null){
                    sb.append("Vui lòng điền đủ ngày tháng ! \n");
                }else{
                    java.util.Date nSinhRaw = jdcNgaySinh.getDate();
                    ngaySinh = new java.sql.Date(nSinhRaw.getTime());

                    java.util.Date nVaoRaw = jdcNgayVao.getDate();
                    ngayVao = new java.sql.Date(nVaoRaw.getTime());
                    DataValidate.checkNgayThang(nSinhRaw, nVaoRaw, sb);
                }
                Integer idNhanVien = (Integer) tblNhanVien.getValueAt(chonDong, 0);
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                nhanVienController.update(idNhanVien,hoTenNhanVien,CMND,soDienThoai,diaChi,gioiTinh,email,trangThai,ngaySinh,ngayVao);
                ThongBao.ThongBaoDon("Cập nhật thông tin nhân viên thành công !", "Thông báo");
                }
            }                
        }        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        XuatExcel.xuat(tblNhanVien);
    }//GEN-LAST:event_button4ActionPerformed

    
    
    public void viewTableStaff(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        for(int i = tblNhanVien.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }
        for(Object[] objects : data){
            model.addRow(objects);
        }
    }
    
    public void setController (NhanVienController nhanVienController) {
        this.nhanVienController = nhanVienController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button bntXoa;
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button button4;
    private swing.Button button5;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private com.toedter.calendar.JDateChooser jdcNgayVao;
    private swing.BtnRadioCus rdbNam;
    private swing.BtnRadioCus rdbNu;
    private swing.BtnRadioCus rdbOff;
    private swing.BtnRadioCus rdbOn;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel2;
    private swing.RoundPanel roundPanel3;
    private swing.Table tblNhanVien;
    private swing.TextField txtCMND;
    private swing.TextField txtDiaChi;
    private swing.TextField txtEmail;
    private swing.TextField txtHoTen;
    private swing.TextField txtSDT;
    private swing.TextInputTT txtTimNhanVien;
    // End of variables declaration//GEN-END:variables
}
