package View_NhapHang;

import Controller.NhaCungCapController;
import Controller.PhieuNhapHangController;
import Help.ChuyenDoi;
import Help.DataValidate;
import Help.ThongBao;
import Help.XuatExcel;
import Model.ChiTietPhieuNhap;
import Model.DichVu;
import Model.DonViTinh;
import Model.PhieuNhapDichVu;
import swing.ScrollBar;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class NhapHangPnl extends javax.swing.JPanel {
    private PhieuNhapHangController phieuNhapHangController;
    private NhaCungCapController nhaCungCapController;
    private int idNhaCungCap = UNDEFINED_CONDITION; 
    private String ngayNhap ="";
    private int idNhanVien ;
    private String maPhieuNhap ;
    private int idDichVu;
    private int idDichVuXoa;
    private int giaTri;
    private Double tienNoPN ;
    
    public NhapHangPnl() {
        initComponents();
        init();
        btnThemChiTietPN.setEnabled(false);
        btnXoaChiTietPN.setEnabled(false);
        txtTenDichVu.setEnabled(false);
        txtNhaCungCapPN.setEnabled(false);
        placeholderDichVu();
    }
    
    public void init() {
        CssTable(jScrollPane1);
        CssTable(jScrollPane2);
        CssTable(jScrollPane3);
        CssTable(jScrollPane5);
    }
    
    public void placeholderDichVu() {
        txtTimDichVu.setText("Tìm dịch vụ");
        txtTimDichVu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimDichVu.getText().equals("Tìm dịch vụ") || txtTimDichVu.getText().equals(txtTimDichVu.getText())) {
                    txtTimDichVu.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimDichVu.getText().isEmpty()) {
                    txtTimDichVu.setText("Tìm dịch vụ");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing.RoundPanel();
        roundPanel2 = new swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachPhieuNhap = new swing.Table();
        txtTongTienPN = new swing.TextField();
        txtNhaCungCapPN = new swing.TextField();
        txtTienNoPN = new swing.TextField();
        txtGhiChu = new swing.TextField();
        btnThem1 = new swing.Button();
        btnSua1 = new swing.Button();
        bntXoa1 = new swing.Button();
        button10 = new swing.Button();
        txtMaPN = new swing.TextField();
        txtNgayNhapPN = new swing.TextField();
        roundPanel3 = new swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietPhieuNhap = new swing.Table();
        roundPanel6 = new swing.RoundPanel();
        txtTenDichVu = new swing.TextField();
        txtSoLuongDV = new swing.TextField();
        txtGiaNhapDV = new swing.TextField();
        btnThemChiTietPN = new swing.Button();
        btnXoaChiTietPN = new swing.Button();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDichVu = new swing.Table();
        txtTimDichVu = new swing.TextInputTT();
        txtTongGiaTri = new swing.TextField();
        cbxDonVi = new swing.ComboBoxSuggestion<>();
        button12 = new swing.Button();
        roundPanel4 = new swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhaCungCap = new swing.Table();
        txtSDT = new swing.TextField();
        txtNhaCungCap = new swing.TextField();
        txtDiaChi = new swing.TextField();
        btnThem = new swing.Button();
        bntSua = new swing.Button();
        btnXoa = new swing.Button();
        txtTienNo = new swing.TextField();
        button11 = new swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(218, 232, 232));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("DANH SÁCH PHIẾU NHẬP");

        tblDanhSachPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Nhà cung cấp", "Nhân viên", "Ngày lập", "Tổng tiền", "Tiền nợ", "Ghi chú", "Trạng thái"
            }
        ));
        tblDanhSachPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachPhieuNhap);
        if (tblDanhSachPhieuNhap.getColumnModel().getColumnCount() > 0) {
            tblDanhSachPhieuNhap.getColumnModel().getColumn(0).setMinWidth(70);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(0).setMaxWidth(70);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(4).setMinWidth(80);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(4).setMaxWidth(80);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(5).setMinWidth(60);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(5).setMaxWidth(60);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(6).setMinWidth(0);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(6).setMaxWidth(0);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(7).setMinWidth(0);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(7).setPreferredWidth(0);
            tblDanhSachPhieuNhap.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        txtTongTienPN.setLabelText("Tổng tiền");
        txtTongTienPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongTienPNKeyReleased(evt);
            }
        });

        txtNhaCungCapPN.setLabelText("Nhà cung cấp");

        txtTienNoPN.setLabelText("Tiền nợ");
        txtTienNoPN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNoPNKeyReleased(evt);
            }
        });

        txtGhiChu.setLabelText("Ghi chú");

        btnThem1.setBackground(new java.awt.Color(120, 225, 220));
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setBackground(new java.awt.Color(120, 225, 220));
        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        bntXoa1.setBackground(new java.awt.Color(120, 225, 220));
        bntXoa1.setText("Xóa");

        button10.setBorder(null);
        button10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (1).png"))); // NOI18N
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        txtMaPN.setLabelText("Mã Phiếu Nhập");

        txtNgayNhapPN.setLabelText("Ngày: **-**-****");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTienPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTienNoPN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhaCungCapPN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayNhapPN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntXoa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(bntXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhaCungCapPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayNhapPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTienPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienNoPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("CHI TIẾT PHIẾU NHẬP");

        tblChiTietPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã PN", "Tên dịch vụ", "Số lượng", "Giá nhập", "Đơn vị tính"
            }
        ));
        tblChiTietPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietPhieuNhapMouseClicked(evt);
            }
        });
        tblChiTietPhieuNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblChiTietPhieuNhapKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietPhieuNhap);
        if (tblChiTietPhieuNhap.getColumnModel().getColumnCount() > 0) {
            tblChiTietPhieuNhap.getColumnModel().getColumn(0).setMinWidth(100);
            tblChiTietPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblChiTietPhieuNhap.getColumnModel().getColumn(0).setMaxWidth(100);
            tblChiTietPhieuNhap.getColumnModel().getColumn(2).setMinWidth(70);
            tblChiTietPhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblChiTietPhieuNhap.getColumnModel().getColumn(2).setMaxWidth(70);
            tblChiTietPhieuNhap.getColumnModel().getColumn(4).setMinWidth(100);
            tblChiTietPhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblChiTietPhieuNhap.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        roundPanel6.setBackground(new java.awt.Color(255, 255, 255));

        txtTenDichVu.setLabelText("Dịch vụ");

        txtSoLuongDV.setLabelText("Số lượng");

        txtGiaNhapDV.setLabelText("Giá nhập");

        btnThemChiTietPN.setBackground(new java.awt.Color(120, 225, 220));
        btnThemChiTietPN.setText("Thêm");
        btnThemChiTietPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiTietPNActionPerformed(evt);
            }
        });

        btnXoaChiTietPN.setBackground(new java.awt.Color(120, 225, 220));
        btnXoaChiTietPN.setText("Xóa");
        btnXoaChiTietPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChiTietPNActionPerformed(evt);
            }
        });

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "idDichVu", "Tên dịch vụ"
            }
        ));
        tblDichVu.setRowHeight(25);
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDichVu);
        if (tblDichVu.getColumnModel().getColumnCount() > 0) {
            tblDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        txtTimDichVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimDichVuKeyReleased(evt);
            }
        });

        txtTongGiaTri.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTongGiaTri.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTongGiaTri.setLabelText("Tổng Giá trị Phiếu nhập");
        txtTongGiaTri.setOpaque(false);

        cbxDonVi.setEditable(false);
        cbxDonVi.setMinimumSize(new java.awt.Dimension(30, 22));
        cbxDonVi.setPreferredSize(new java.awt.Dimension(30, 22));

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtTimDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addGap(94, 94, 94)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addComponent(txtTongGiaTri, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(btnXoaChiTietPN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemChiTietPN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaNhapDV, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(cbxDonVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel6Layout.createSequentialGroup()
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDonVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuongDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhapDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemChiTietPN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaChiTietPN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel6Layout.createSequentialGroup()
                        .addComponent(txtTimDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        button12.setBorder(null);
        button12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (1).png"))); // NOI18N
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("NHÀ CUNG CẤP");

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ", "Tiền nợ"
            }
        ));
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNhaCungCap);
        if (tblNhaCungCap.getColumnModel().getColumnCount() > 0) {
            tblNhaCungCap.getColumnModel().getColumn(0).setMinWidth(0);
            tblNhaCungCap.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblNhaCungCap.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtSDT.setLabelText("Số điện thoại");

        txtNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNhaCungCap.setLabelText("Tên nhà cung cấp");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDiaChi.setLabelText("Địa chỉ");

        btnThem.setBackground(new java.awt.Color(120, 225, 220));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        bntSua.setBackground(new java.awt.Color(120, 225, 220));
        bntSua.setText("Sửa");
        bntSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(120, 225, 220));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTienNo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTienNo.setLabelText("Tiền nợ");
        txtTienNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNoKeyReleased(evt);
            }
        });

        button11.setBorder(null);
        button11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (1).png"))); // NOI18N
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTienNo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int dongXoa = tblNhaCungCap.getSelectedRow();
        if (dongXoa == -1) {
            ThongBao.ThongBaoDon("Chọn dòng cần xoá", "Thông báo");
        } else {        
            int click = ThongBao.LuaChonFix("Xác nhận xoá ?", "");
            if (click == 1) {
                nhaCungCapController.xoaNhaCungCap((Integer)tblNhaCungCap.getValueAt(dongXoa, 0));
                ThongBao.ThongBaoDon("Xoá thành công !", "Thông báo");
            }
            
        } 

    }//GEN-LAST:event_btnXoaActionPerformed

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
        int chonDong = tblNhaCungCap.getSelectedRow();
        if (chonDong == -1) {
            ThongBao.ThongBaoDon("Chọn dòng cần sửa !", "Thông báo");
        } else {
            int update = ThongBao.LuaChonFix("Xác nhận sửa ?", "");
            if(update == 1){
                StringBuilder sb = new StringBuilder();
                
                String tenNhaCungCap = txtNhaCungCap.getText();
                DataValidate.checkEmpty(tenNhaCungCap, sb, "Tên không được để trống");
                String SDTNhaCungCap = txtSDT.getText();
                DataValidate.checkEmpty(SDTNhaCungCap, sb, "Số điện thoại không được để trống! ");
                DataValidate.checkSdtForm(SDTNhaCungCap, sb);                
                String diaChi = txtDiaChi.getText();
                DataValidate.checkEmpty(diaChi, sb, "Địa chỉ không được để trống! ");

                double tienNo = 0;
                tienNo=ChuyenDoi.SoDouble(txtTienNo.getText());
        
                Integer idNhaCungCap = (Integer) tblNhaCungCap.getValueAt(chonDong, 0);
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{                
                    nhaCungCapController.update(idNhaCungCap, tenNhaCungCap, SDTNhaCungCap, diaChi, tienNo);
                    txtSDT.setText("");
                    txtNhaCungCap.setText("");
                    txtDiaChi.setText("");
                    txtTienNo.setText("");
                    ThongBao.ThongBaoDon("Cập nhật thành công", "Thông báo");       
                }
            }
        }
    }//GEN-LAST:event_bntSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        StringBuilder sb = new StringBuilder();
        
        String tenNhaCungCap = txtNhaCungCap.getText();
        DataValidate.checkEmpty(tenNhaCungCap, sb, "Tên không được để trống");
        
        String SDTNhaCungCap = txtSDT.getText();
        DataValidate.checkEmpty(SDTNhaCungCap, sb, "Số điện thoại không được để trống! ");
        DataValidate.checkSdtForm(SDTNhaCungCap, sb);
        DataValidate.checkSDTNCCExist(SDTNhaCungCap, sb);        
        
        String diaChi = txtDiaChi.getText();
        DataValidate.checkEmpty(diaChi, sb, "Địa chỉ không được để trống! ");
        
//        Double tienNo = Double.parseDouble(txtTienNo.getText());
        double tienNo = 0;
        tienNo=ChuyenDoi.SoDouble(txtTienNo.getText());
        
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{         
            nhaCungCapController.insert(tenNhaCungCap, SDTNhaCungCap, diaChi, tienNo);
            ThongBao.ThongBaoDon("Thêm mới thành công", "Thông báo");
            txtSDT.setText("");
            txtNhaCungCap.setText("");
            txtDiaChi.setText("");
            txtTienNo.setText("");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
        int click = tblNhaCungCap.getSelectedRow();
        txtSDT.setText((String) tblNhaCungCap.getValueAt(click, 2));
        txtNhaCungCap.setText((String) tblNhaCungCap.getValueAt(click, 1));
        txtDiaChi.setText((String) tblNhaCungCap.getValueAt(click, 3));
        txtTienNo.setText(tblNhaCungCap.getValueAt(click, 4).toString());
        txtNhaCungCapPN.setText((String) tblNhaCungCap.getValueAt(click, 1));
        idNhaCungCap=(Integer) tblNhaCungCap.getValueAt(click, 0);
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        XuatExcel.xuat(tblNhaCungCap);
    }//GEN-LAST:event_button11ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        StringBuilder sb = new StringBuilder();
        String maPhieuNhap = txtMaPN.getText();
        DataValidate.checkEmpty(maPhieuNhap, sb, "Mã phiếu nhập không được để trống");
//        Double tongTien = Double.parseDouble(txtTongTienPN.getText());
//        Double tienNo = Double.parseDouble(txtTienNoPN.getText());
//        String tenNhaCungCap = txtNhaCungCapPN.getText();
//        DataValidate.checkEmpty(tenNhaCungCap, sb, "Tên không được để trống");

        if (idNhaCungCap==UNDEFINED_CONDITION) {
            sb.append("Vui lòng chọn nhà cung cấp ở bảng Nhà cung cấp \n");
        }
        
        double tongTien = 0;
        tongTien=ChuyenDoi.SoDouble(txtTongTienPN.getText());
        if(tongTien <= 0){
            sb.append("Tổng tiền phải lớn hơn 0 \n");
        }

        
        double tienNo = 0;
        tienNo=ChuyenDoi.SoDouble(txtTienNoPN.getText());
        
        
        String ghiChu = txtGhiChu.getText();
        if(ghiChu.length()==0){
            ghiChu="Không";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Timestamp timeNow = null;
        String ngayNhap = txtNgayNhapPN.getText();
        
//        if(ngayNhap.length()==0 || ngayNhap.length()==10){
//        }else{
//            sb.append("Vui lòng nhập đúng định dạng ngày tháng ! \n");
//        }
        
        Date date = new Date();
        if(ngayNhap.equals("")){
            timeNow = new java.sql.Timestamp(new Date().getTime());
        }else{
            try {
                date = sdf.parse(txtNgayNhapPN.getText());
                timeNow = new java.sql.Timestamp(date.getTime());
            } catch (Exception e) {
                sb.append("Sai thông tin ngày tháng ! \n");
            }
        }
        
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            PhieuNhapDichVu pn = new PhieuNhapDichVu(maPhieuNhap,idNhaCungCap,1,timeNow,tongTien,tienNo,ghiChu,true);
            if(tienNo>0){
                phieuNhapHangController.updateTienNoNCC(idNhaCungCap, tienNo);
                ThongBao.ThongBaoDon("Cập nhật phiếu nhập thành công !", "Thông báo");
                nhaCungCapController.loadList();
            }
            phieuNhapHangController.insert(pn);
            idNhaCungCap=UNDEFINED_CONDITION;
            txtNhaCungCapPN.setText("");
            txtNgayNhapPN.setText("");
            txtTongTienPN.setText("");
            txtTienNoPN.setText("");
            txtGhiChu.setText("");
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        int chonDong = tblDanhSachPhieuNhap.getSelectedRow();
        if (chonDong == -1) {
            ThongBao.ThongBaoDon("Chọn dòng cần sửa", "Thông báo");
        } else {
            int update = ThongBao.LuaChonFix("Xác nhận sửa ?", "");
            if(update == 1){
                StringBuilder sb = new StringBuilder();
                String nhaCungCap = txtNhaCungCapPN.getText();
                DataValidate.checkEmpty(nhaCungCap, sb, "Nhà cung cấp không được để trống");
                
                double tongTien = 0;
                tongTien=ChuyenDoi.SoDouble(txtTongTienPN.getText());
                if(tongTien <= 0){
                    sb.append("Tổng tiền phải lớn hơn 0 \n");
                }

                double tienNo = 0;
                tienNo=ChuyenDoi.SoDouble(txtTienNoPN.getText());
                
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                java.sql.Timestamp timeNow = null;
                String ngayNhap = txtNgayNhapPN.getText();
                Date date = new Date();
                if(ngayNhap.equals("")){
                    timeNow = new java.sql.Timestamp(new Date().getTime());
                }else{
                    try {
                        date = sdf.parse(txtNgayNhapPN.getText());
                        timeNow = new java.sql.Timestamp(date.getTime());
                    } catch (Exception e) {
                        sb.append("Sai thông tin ngày tháng ! \n");
                    }
                }
                
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }else{          
                    PhieuNhapDichVu pn = new PhieuNhapDichVu(maPhieuNhap,idNhaCungCap,idNhanVien,timeNow,tongTien,tienNo,txtGhiChu.getText(),true);
                    //Cập nhật tiền nợ
                    Double tongTienNo = phieuNhapHangController.getTienNoNCC(idNhaCungCap);
                    if(tienNo<tienNoPN){
                        phieuNhapHangController.updateTienNoNCC(idNhaCungCap, tongTienNo-(tienNoPN-tienNo));
                        nhaCungCapController.loadList();
                    }else if (tienNo>tienNoPN){
                        phieuNhapHangController.updateTienNoNCC(idNhaCungCap, tienNo+(tienNo-tienNoPN));
                        nhaCungCapController.loadList();
                    }
                    phieuNhapHangController.update(pn);
                    ThongBao.ThongBaoDon("Sửa thông tin phiếu nhập thành công !", "Thông báo");
                    idNhaCungCap=UNDEFINED_CONDITION;
                    txtNhaCungCapPN.setText("");
                    txtNgayNhapPN.setText("");
                    txtTongTienPN.setText("");
                    txtTienNoPN.setText("");
                    txtGhiChu.setText("");
                }            
            }
        }      
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void tblDanhSachPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhieuNhapMouseClicked
        btnThemChiTietPN.setEnabled(true);
        btnXoaChiTietPN.setEnabled(true);
        int click = tblDanhSachPhieuNhap.getSelectedRow();
        
        txtNhaCungCapPN.setText(tblDanhSachPhieuNhap.getValueAt(click, 1).toString());
        List<Object[]> phieuNhap = phieuNhapHangController.getPhieuNhap(tblDanhSachPhieuNhap.getValueAt(click, 0).toString());
        maPhieuNhap=tblDanhSachPhieuNhap.getValueAt(click, 0).toString();
        idNhaCungCap =(int) phieuNhap.get(0)[1];
        idNhanVien =(int) phieuNhap.get(0)[2];
        txtTongTienPN.setText(tblDanhSachPhieuNhap.getValueAt(click, 4).toString());
        txtTienNoPN.setText(tblDanhSachPhieuNhap.getValueAt(click, 5).toString());
        txtGhiChu.setText(tblDanhSachPhieuNhap.getValueAt(click, 6).toString());
        txtNgayNhapPN.setText(tblDanhSachPhieuNhap.getValueAt(click, 3).toString());
        tienNoPN=ChuyenDoi.SoDouble(tblDanhSachPhieuNhap.getValueAt(click, 5).toString());
        
        phieuNhapHangController.loadChiTietPhieuNhap(maPhieuNhap);
        
        //tính tổng tiền phiếu nhập
            Double tongGiaNhap =0.0;
            for (int i = 0; i < tblChiTietPhieuNhap.getRowCount(); i++) {
                tongGiaNhap += ChuyenDoi.SoDouble(tblChiTietPhieuNhap.getValueAt(i, 3).toString())*(int)tblChiTietPhieuNhap.getValueAt(i, 2);
            }
            txtTongGiaTri.setText(ChuyenDoi.SoString(tongGiaNhap));
    }//GEN-LAST:event_tblDanhSachPhieuNhapMouseClicked

    private void txtTimDichVuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimDichVuKeyReleased
        phieuNhapHangController.timDichVu(txtTimDichVu.getText());
    }//GEN-LAST:event_txtTimDichVuKeyReleased

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        int click = tblDichVu.getSelectedRow();
        txtTenDichVu.setText(tblDichVu.getValueAt(click,1).toString());
        idDichVu =(int) tblDichVu.getValueAt(click,0);
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void btnThemChiTietPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTietPNActionPerformed
        StringBuilder sb = new StringBuilder();
        String dichVu = txtTenDichVu.getText();
        DataValidate.checkEmpty(dichVu, sb, "Dịch vụ không được để trống");
 
        DonViTinh donViTinh =(DonViTinh) cbxDonVi.getSelectedItem();
        Integer idDonViTinh = donViTinh.getIdDonViTinh();
        String tenDonVi = donViTinh.getTenDonVi();
        Integer giaTri =donViTinh.getGiaTri();
//        Integer soLuong = Integer.parseInt(txtSoLuongDV.getText());
        Integer soLuong = 0;
        try {
            soLuong = Integer.parseInt(txtSoLuongDV.getText()) ;
            if(soLuong < 0){
                sb.append("Số lượng phải lớn hớn 0 \n");
            }
        } catch (Exception e) {
            sb.append("Số lượng phải là số \n");
        }        
        
        int soLuongDV = phieuNhapHangController.laySoLuongDV(idDichVu);
        double giaNhap = 0;
        try {
            giaNhap = Double.parseDouble(txtGiaNhapDV.getText()) ;
            if(giaNhap < 0){
                sb.append("Giá nhập phải lớn hớn 0 \n");
            }
        } catch (Exception e) {
            sb.append("Giá nhập phải là số \n");
        }        

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }else{ 
            //Thêm chi tiết phiếu nhập mới
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(maPhieuNhap,idDichVu,idDonViTinh,soLuong,giaNhap);

            if(!tenDonVi.equals("Kg")){
                //Cập nhật lại số lượng
                phieuNhapHangController.capNhatSoLuongDV(idDichVu, soLuongDV+(soLuong*giaTri));
            }
            
            phieuNhapHangController.themChiTietPN(ctpn);
            phieuNhapHangController.loadChiTietPhieuNhap(maPhieuNhap);    
            ThongBao.ThongBaoDon("Thêm mới thành công", "Thông báo");
            //tính tổng tiền phiếu nhập
            Double tongGiaNhap =0.0;
            for (int i = 0; i < tblChiTietPhieuNhap.getRowCount(); i++) {
                tongGiaNhap += ChuyenDoi.SoDouble(tblChiTietPhieuNhap.getValueAt(i, 3).toString())*(int)tblChiTietPhieuNhap.getValueAt(i, 2);
            }
            txtTongGiaTri.setText(ChuyenDoi.SoString(tongGiaNhap));
            txtTenDichVu.setText("");
            txtGiaNhapDV.setText("");
            txtSoLuongDV.setText("");
        }   
    }//GEN-LAST:event_btnThemChiTietPNActionPerformed

    private void btnXoaChiTietPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChiTietPNActionPerformed
        int chonDong = tblChiTietPhieuNhap.getSelectedRow();
        if (chonDong == -1) {
            ThongBao.ThongBaoDon("Chọn dòng cần Xoá", "Thông báo");
        } else {
            //Xoá chi tiết phiếu nhập
            phieuNhapHangController.xoaChiTietPN(maPhieuNhap,idDichVuXoa);
            System.out.println("mã: "+maPhieuNhap+"  "+idDichVuXoa);
            //cập nhật lại sl dịch vụ
            int soLuongDV = phieuNhapHangController.laySoLuongDV(idDichVuXoa);
            phieuNhapHangController.capNhatSoLuongDV(idDichVuXoa,soLuongDV-giaTri);
            ThongBao.ThongBaoDon("Xoá thành công", "Thông báo");
            //tính tổng tiền phiếu nhập
                Double tongGiaNhap =0.0;
                for (int i = 0; i < tblChiTietPhieuNhap.getRowCount(); i++) {
                    tongGiaNhap += ChuyenDoi.SoDouble(tblChiTietPhieuNhap.getValueAt(i, 3).toString())*(int)tblChiTietPhieuNhap.getValueAt(i, 2);
                }
                txtTongGiaTri.setText(ChuyenDoi.SoString(tongGiaNhap));
            txtTongGiaTri.setText(ChuyenDoi.SoString(tongGiaNhap));
            phieuNhapHangController.loadChiTietPhieuNhap(maPhieuNhap);
        }

        
    }//GEN-LAST:event_btnXoaChiTietPNActionPerformed

    private void tblChiTietPhieuNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblChiTietPhieuNhapKeyPressed
        
    }//GEN-LAST:event_tblChiTietPhieuNhapKeyPressed

    private void tblChiTietPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietPhieuNhapMouseClicked
        int click = tblChiTietPhieuNhap.getSelectedRow();
        idDichVuXoa =phieuNhapHangController.layIdDichVu(tblChiTietPhieuNhap.getValueAt(click,1).toString());
        String tenDonVi = tblChiTietPhieuNhap.getValueAt(click,4).toString();
        ArrayList<Integer> donVi = phieuNhapHangController.layIdDonVi(tenDonVi);
        giaTri=donVi.get(1);
    }//GEN-LAST:event_tblChiTietPhieuNhapMouseClicked

    private void txtTienNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNoKeyReleased
        double khachDua = ChuyenDoi.SoDouble(txtTienNo.getText());
        txtTienNo.setText(ChuyenDoi.SoString(khachDua));
    }//GEN-LAST:event_txtTienNoKeyReleased

    private void txtTienNoPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNoPNKeyReleased
        double khachDua = ChuyenDoi.SoDouble(txtTienNoPN.getText());
        txtTienNoPN.setText(ChuyenDoi.SoString(khachDua));
    }//GEN-LAST:event_txtTienNoPNKeyReleased

    private void txtTongTienPNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongTienPNKeyReleased
        double khachDua = ChuyenDoi.SoDouble(txtTongTienPN.getText());
        txtTongTienPN.setText(ChuyenDoi.SoString(khachDua));
    }//GEN-LAST:event_txtTongTienPNKeyReleased

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        XuatExcel.xuat(tblDanhSachPhieuNhap);
    }//GEN-LAST:event_button10ActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        XuatExcel.xuat(tblChiTietPhieuNhap);
    }//GEN-LAST:event_button12ActionPerformed

    
    public void CssTable(JScrollPane table) {
        JPanel p = new JPanel();
        table.setVerticalScrollBar(new ScrollBar());
        table.getVerticalScrollBar().setBackground(Color.WHITE);
        table.getViewport().setBackground(Color.WHITE);       
        table.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
   
    public void viewTableStaff(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblNhaCungCap.getModel();
        for(int i = tblNhaCungCap.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }
        for(Object[] objects : data){
            model.addRow(objects);
        }
    }
    
    public void viewTablePhieuNhapHang(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachPhieuNhap.getModel();
        for(int i = tblDanhSachPhieuNhap.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }
        for(Object[] objects : data){
            model.addRow(objects);
        }
    }
    
    public void viewTableChiTietPhieuNhap(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblChiTietPhieuNhap.getModel();
        for(int i = tblChiTietPhieuNhap.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }
        for(Object[] objects : data){
            model.addRow(objects);
        }
    }
    
    public void viewTableDichVu(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        for(int i = tblDichVu.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }
        for(Object[] objects : data){
            model.addRow(objects);
        }
    }
    
    
    public void FillDataComboBoxDonViTinh(List<DonViTinh> donviTinhs) {
        cbxDonVi.removeAllItems();
        for (DonViTinh donViTinh : donviTinhs) {
            cbxDonVi.addItem(donViTinh);
        }
    }
    
    public void setController (PhieuNhapHangController phieuNhapHangController) {
        this.phieuNhapHangController = phieuNhapHangController;
    }
    public void setControllerNhaCungCap (NhaCungCapController nhaCungCapController) {
        this.nhaCungCapController = nhaCungCapController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button bntSua;
    private swing.Button bntXoa1;
    private swing.Button btnSua1;
    private swing.Button btnThem;
    private swing.Button btnThem1;
    private swing.Button btnThemChiTietPN;
    private swing.Button btnXoa;
    private swing.Button btnXoaChiTietPN;
    private swing.Button button10;
    private swing.Button button11;
    private swing.Button button12;
    public swing.ComboBoxSuggestion<DonViTinh> cbxDonVi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel2;
    private swing.RoundPanel roundPanel3;
    private swing.RoundPanel roundPanel4;
    private swing.RoundPanel roundPanel6;
    private swing.Table tblChiTietPhieuNhap;
    private swing.Table tblDanhSachPhieuNhap;
    private swing.Table tblDichVu;
    private swing.Table tblNhaCungCap;
    private swing.TextField txtDiaChi;
    private swing.TextField txtGhiChu;
    private swing.TextField txtGiaNhapDV;
    private swing.TextField txtMaPN;
    private swing.TextField txtNgayNhapPN;
    private swing.TextField txtNhaCungCap;
    private swing.TextField txtNhaCungCapPN;
    private swing.TextField txtSDT;
    private swing.TextField txtSoLuongDV;
    private swing.TextField txtTenDichVu;
    private swing.TextField txtTienNo;
    private swing.TextField txtTienNoPN;
    private swing.TextInputTT txtTimDichVu;
    private swing.TextField txtTongGiaTri;
    private swing.TextField txtTongTienPN;
    // End of variables declaration//GEN-END:variables
}
