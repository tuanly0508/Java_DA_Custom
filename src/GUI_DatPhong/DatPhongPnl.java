package GUI_DatPhong;

import GUI.Table;
import GUI.ScrollBar;
import Controller.DatPhongController;
import Controller.HoaDonController;
import Controller.KhachHangController;
import Controller.PhieuDatPhongController;
import Controller.PhieuThuePhongController;
import GUI_DoiPhong.DoiPhongDlg;
import Help.ChuyenDoi;
import Model.GioDatTruoc;
import Model.KhachHang;
import Model.PhieuDatPhong;
import Model.PhieuThuePhong;
import Model.Phong;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class DatPhongPnl extends javax.swing.JPanel {
    private PhieuThuePhongController phieuThuePhongController;
    private PhieuDatPhongController phieuDatPhongController;
    private KhachHangController khachHangController;
    private DatPhongController datPhongController;
    private HoaDonController hoaDonController;
    private boolean isSDT = false;
    private Button button;
    private PhongRender phongRender;
    private DoiPhongDlg doiPhongDialog;
    PhieuThuePhong phieuThuePhong = new PhieuThuePhong();
    PhieuDatPhong phieuDatPhong = new PhieuDatPhong();
    KhachHang khachHang = new KhachHang();
    int phongHienTai = UNDEFINED_CONDITION;
    int loaiPhongHienTai = UNDEFINED_CONDITION;
    int phongCanDoi = UNDEFINED_CONDITION;
    int click1 = UNDEFINED_CONDITION;
    String tenPhongHienTai = TOOL_TIP_TEXT_KEY;
    Double tienDichVu = 0.0;
    Double tienGio = 0.0;
    Double tienPhuThu = 0.0;
    Double tongTien = 0.0;

    public DatPhongPnl() {
        initComponents();
        init();
        setDisable();   
        setCombobox();
    }

    public void init() {
        CssTable(jScrollPane1);
        CssTable(jScrollPane2);
        CssTable(jScrollPane5);
        CssTable(jScrollPane6);
        GridLayout layout = new GridLayout(8,2);
        layout.setHgap(5);
        layout.setVgap(5);
        panelPhong.setLayout(layout);
        panelPhong.revalidate();
        panelPhong.repaint();
        btnDoiPhong.setVisible(false);        
        btnHuyDatTruoc.setVisible(false);
        txtThoiGianMo.setVisible(false);
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }   
    
    public void loadPhong(List<Object[]> fullInfo) {
        for(int i=0;i<fullInfo.size();i++){
            String thoiGianMo ="....................";
            if(!String.valueOf(fullInfo.get(i)[4]).equals("null")){
                thoiGianMo=String.valueOf(fullInfo.get(i)[4]);
            }
            loadPhongBtn(Integer.parseInt(fullInfo.get(i)[0].toString()), String.valueOf(fullInfo.get(i)[1]), 
                    String.valueOf(fullInfo.get(i)[2]), Integer.parseInt(fullInfo.get(i)[0].toString()),thoiGianMo);
        }

    }
    
    public void loadPhongBtn(Integer idPhong, String tenPhong, String ttPhong, Integer idLoaiPhong,String thoiGianMo) {

//        Button btnphong = new Button(tenPhong);
//        btnphong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        btnphong.setPreferredSize(new Dimension(80,10));
//        btnphong.setFont(new java.awt.Font("Segoe UI Light", 1, 12));
//        btnphong.setForeground(new java.awt.Color(255,255,255));
//        List<Object[]> data = datPhongController.getThongTinPhong(idPhong);
        
        PhongRender p = new PhongRender();
        p.lblTenPhong.setText(tenPhong);
        p.txtGioMo.setText(thoiGianMo);
        p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        p.setPreferredSize(new Dimension(80,30));
        p.setFont(new java.awt.Font("Segoe UI Light", 1, 12));
        p.setForeground(new java.awt.Color(255,255,255));
        
        
        if (ttPhong.equals("Phòng còn trống")) {
            p.setBackground(new Color(0,204,204));
        }else if (ttPhong.equals("Đang hoạt động")) {
//            
            p.setBackground(new Color(255,92,92));
            
        }else if (ttPhong.equals("Phòng đặt trước")) {
            p.setBackground(new Color(255,195,137));
        }else {
            p.setBackground(new Color(153,153,153));
        }        
        p.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
                phongRender = p;
                phongHienTai = idPhong;
                loaiPhongHienTai = idLoaiPhong;
                tenPhongHienTai = tenPhong;
                lblTenPhong.setText(tenPhong);                
                if (ttPhong.equals("Phòng còn trống")) {
                    setNull();
                    setNullTamTinh();
                    setPhongTrong();
                }else if (ttPhong.equals("Đang hoạt động")) {
                    phongCanDoi = idPhong;
                    setNullTamTinh();
                    setPhongHoatDong();
                    setThongTinPhong(phongHienTai);
                    btnTamTinh.setEnabled(true);
                    btnThanhToan.setEnabled(true);
                }else if (ttPhong.equals("Phòng đặt trước")) {
                    loadTableSuDungDV(null);
                    setNullTamTinh();
                    setPhongDatTruoc();
                }else {                    
                    setNull();
                    setNullTamTinh();
                    loadTableSuDungDV(null);     
                    setPhongBaoTri();
                }
            }                    
        });        
        panelPhong.add(p); 
        panelPhong.revalidate();
        panelPhong.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        body = new GUI.RoundPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jtpDichVuAll = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllDichVu = new GUI.Table();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDoUong = new GUI.Table();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblBimbim = new GUI.Table();
        panelP = new GUI.RoundPanel();
        panelPhong = new GUI.RoundPanel();
        roundPanel2 = new GUI.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rdbPhongVip = new GUI.BtnRadioCus();
        rdbPhongThuong = new GUI.BtnRadioCus();
        rdbAllPhong = new GUI.BtnRadioCus();
        rdbPhongTrong = new GUI.BtnRadioCus();
        rdbPhongAct = new GUI.BtnRadioCus();
        rdbPhongBook = new GUI.BtnRadioCus();
        roundPanel3 = new GUI.RoundPanel();
        lblTenPhong = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtThoiGianMo = new GUI.TextField();
        txtTenKhach = new GUI.TextField();
        btnDatTruoc = new GUI.Button();
        btnMoPhong = new GUI.Button();
        rdbGiaNgayLe = new GUI.BtnRadioCus();
        btnDoiPhong = new GUI.Button();
        btnHuyDatTruoc = new GUI.Button();
        txtSDT = new GUI.TextField();
        cbxDatTruoc = new javax.swing.JComboBox<>();
        btnBaoTri = new GUI.Button();
        btnHuyBaoTri = new GUI.Button();
        roundPanel4 = new GUI.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnThanhToan = new GUI.Button();
        btnTamTinh = new GUI.Button();
        txtTienGio = new GUI.TextField();
        txtTienDichVu = new GUI.TextField();
        txtTienPhuThu = new GUI.TextField();
        txtTongTien = new GUI.TextField();
        roundPanel5 = new GUI.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuDungDichVu = new GUI.Table();
        jLabel4 = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        btnThemDichVu = new GUI.Button();
        roundPanel6 = new GUI.RoundPanel();
        button4 = new GUI.Button();
        jLabel5 = new javax.swing.JLabel();
        button5 = new GUI.Button();
        jLabel6 = new javax.swing.JLabel();
        button6 = new GUI.Button();
        jLabel7 = new javax.swing.JLabel();
        button7 = new GUI.Button();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        body.setBackground(new java.awt.Color(218, 232, 232));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DỊCH VỤ");

        jtpDichVuAll.setBackground(new java.awt.Color(255, 255, 255));
        jtpDichVuAll.setForeground(new java.awt.Color(51, 51, 51));
        jtpDichVuAll.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jtpDichVuAll.setOpaque(true);
        jtpDichVuAll.setBackground(Color.WHITE);
        jtpDichVuAll.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtpDichVuAllStateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        tblAllDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Dịch vụ", "ĐVT", "Giá"
            }
        ));
        jScrollPane2.setViewportView(tblAllDichVu);
        if (tblAllDichVu.getColumnModel().getColumnCount() > 0) {
            tblAllDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblAllDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblAllDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
            tblAllDichVu.getColumnModel().getColumn(2).setMinWidth(45);
            tblAllDichVu.getColumnModel().getColumn(2).setPreferredWidth(45);
            tblAllDichVu.getColumnModel().getColumn(2).setMaxWidth(45);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("Tất cả", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblDoUong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Dịch vụ", "ĐVT", "Giá"
            }
        ));
        jScrollPane5.setViewportView(tblDoUong);
        if (tblDoUong.getColumnModel().getColumnCount() > 0) {
            tblDoUong.getColumnModel().getColumn(0).setMinWidth(0);
            tblDoUong.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDoUong.getColumnModel().getColumn(0).setMaxWidth(0);
            tblDoUong.getColumnModel().getColumn(2).setMinWidth(45);
            tblDoUong.getColumnModel().getColumn(2).setPreferredWidth(45);
            tblDoUong.getColumnModel().getColumn(2).setMaxWidth(45);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("Đồ uống", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblBimbim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Dịch vụ", "ĐVT", "Giá"
            }
        ));
        jScrollPane6.setViewportView(tblBimbim);
        if (tblBimbim.getColumnModel().getColumnCount() > 0) {
            tblBimbim.getColumnModel().getColumn(0).setMinWidth(0);
            tblBimbim.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblBimbim.getColumnModel().getColumn(0).setMaxWidth(0);
            tblBimbim.getColumnModel().getColumn(2).setMinWidth(45);
            tblBimbim.getColumnModel().getColumn(2).setPreferredWidth(45);
            tblBimbim.getColumnModel().getColumn(2).setMaxWidth(45);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("Bim bim", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))
                        .addContainerGap())
                    .addComponent(jtpDichVuAll, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpDichVuAll)
                .addContainerGap())
        );

        panelP.setBackground(new java.awt.Color(255, 255, 255));

        panelPhong.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelPhongLayout = new javax.swing.GroupLayout(panelPhong);
        panelPhong.setLayout(panelPhongLayout);
        panelPhongLayout.setHorizontalGroup(
            panelPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        panelPhongLayout.setVerticalGroup(
            panelPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPLayout = new javax.swing.GroupLayout(panelP);
        panelP.setLayout(panelPLayout);
        panelPLayout.setHorizontalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPLayout.setVerticalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách phòng");

        rdbPhongVip.setBackground(new java.awt.Color(0, 102, 204));
        buttonGroup1.add(rdbPhongVip);
        rdbPhongVip.setText("Phòng vip");
        rdbPhongVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongVipActionPerformed(evt);
            }
        });

        rdbPhongThuong.setBackground(new java.awt.Color(153, 153, 0));
        buttonGroup1.add(rdbPhongThuong);
        rdbPhongThuong.setText("Phòng thường");
        rdbPhongThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongThuongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbAllPhong);
        rdbAllPhong.setSelected(true);
        rdbAllPhong.setText("Tất cả");
        rdbAllPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAllPhongActionPerformed(evt);
            }
        });

        rdbPhongTrong.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(rdbPhongTrong);
        rdbPhongTrong.setText("Phòng trống");
        rdbPhongTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongTrongActionPerformed(evt);
            }
        });

        rdbPhongAct.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup1.add(rdbPhongAct);
        rdbPhongAct.setText("Đang hoạt động");
        rdbPhongAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongActActionPerformed(evt);
            }
        });

        rdbPhongBook.setBackground(new java.awt.Color(204, 0, 204));
        buttonGroup1.add(rdbPhongBook);
        rdbPhongBook.setText("Đặt trước");
        rdbPhongBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbAllPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(rdbPhongAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbPhongBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(rdbPhongThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(rdbPhongVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbAllPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbPhongThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbPhongVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbPhongAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbPhongBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTenPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong.setText("PHÒNG ...");
        roundPanel3.add(lblTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 11, 270, 30));
        roundPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, 406, 10));

        txtThoiGianMo.setLabelText("Thời gian mở");
        roundPanel3.add(txtThoiGianMo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, -1));

        txtTenKhach.setLabelText("Tên khách hàng");
        roundPanel3.add(txtTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 190, 50));

        btnDatTruoc.setBackground(new java.awt.Color(120, 225, 220));
        btnDatTruoc.setText("Đặt trước");
        btnDatTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatTruocActionPerformed(evt);
            }
        });
        roundPanel3.add(btnDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 82, 44));

        btnMoPhong.setBackground(new java.awt.Color(120, 225, 220));
        btnMoPhong.setText("Mở phòng");
        btnMoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoPhongActionPerformed(evt);
            }
        });
        roundPanel3.add(btnMoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 82, 44));

        rdbGiaNgayLe.setBackground(new java.awt.Color(255, 0, 0));
        rdbGiaNgayLe.setText("Giá ngày lễ");
        roundPanel3.add(rdbGiaNgayLe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 30));

        btnDoiPhong.setBackground(new java.awt.Color(120, 225, 220));
        btnDoiPhong.setText("Đổi phòng");
        btnDoiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiPhongActionPerformed(evt);
            }
        });
        roundPanel3.add(btnDoiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 82, 44));

        btnHuyDatTruoc.setBackground(new java.awt.Color(120, 225, 220));
        btnHuyDatTruoc.setText("Hủy");
        btnHuyDatTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDatTruocActionPerformed(evt);
            }
        });
        roundPanel3.add(btnHuyDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 82, 44));

        txtSDT.setLabelText("Số điện thoại");
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });
        roundPanel3.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 50));

        cbxDatTruoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDatTruoc.setOpaque(false);
        roundPanel3.add(cbxDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 80, 30));
        cbxDatTruoc.setBackground(Color.WHITE);

        btnBaoTri.setBackground(new java.awt.Color(120, 225, 220));
        btnBaoTri.setText("Bảo trì");
        btnBaoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoTriActionPerformed(evt);
            }
        });
        roundPanel3.add(btnBaoTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 30));

        btnHuyBaoTri.setBackground(new java.awt.Color(120, 225, 220));
        btnHuyBaoTri.setText("Hủy");
        btnHuyBaoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBaoTriActionPerformed(evt);
            }
        });
        roundPanel3.add(btnHuyBaoTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 30));

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("THANH TOÁN");

        btnThanhToan.setBackground(new java.awt.Color(120, 225, 220));
        btnThanhToan.setText("Thanh toán");

        btnTamTinh.setBackground(new java.awt.Color(120, 225, 220));
        btnTamTinh.setText("Tạm tính");
        btnTamTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamTinhActionPerformed(evt);
            }
        });

        txtTienGio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienGio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtTienGio.setLabelText("Tiền giờ");

        txtTienDichVu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienDichVu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtTienDichVu.setLabelText("Tiền dịch vụ");

        txtTienPhuThu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienPhuThu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtTienPhuThu.setLabelText("Tiền phụ thu");

        txtTongTien.setForeground(new java.awt.Color(255, 0, 0));
        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTongTien.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtTongTien.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtTongTien.setLabelText("Thành tiền");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(btnTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienGio, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtTienPhuThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienGio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTienDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblSuDungDichVu.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Dịch vụ", "ĐVT", "Ngày sử dụng", "SL", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblSuDungDichVu);
        if (tblSuDungDichVu.getColumnModel().getColumnCount() > 0) {
            tblSuDungDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(2).setMinWidth(45);
            tblSuDungDichVu.getColumnModel().getColumn(2).setPreferredWidth(45);
            tblSuDungDichVu.getColumnModel().getColumn(2).setMaxWidth(45);
            tblSuDungDichVu.getColumnModel().getColumn(4).setMinWidth(25);
            tblSuDungDichVu.getColumnModel().getColumn(4).setPreferredWidth(25);
            tblSuDungDichVu.getColumnModel().getColumn(4).setMaxWidth(25);
            tblSuDungDichVu.getColumnModel().getColumn(5).setMinWidth(100);
            tblSuDungDichVu.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblSuDungDichVu.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DỊCH VỤ SỬ DỤNG");

        spnSoLuong.setOpaque(false);

        btnThemDichVu.setBackground(new java.awt.Color(255, 252, 252));
        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus_1.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );

        spnSoLuong.setBackground(Color.WHITE);

        roundPanel6.setBackground(new java.awt.Color(255, 255, 255));

        button4.setBackground(new java.awt.Color(255, 92, 92));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Đang hoạt động");

        button5.setBackground(new java.awt.Color(0, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Phòng còn trống");

        button6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Đang bảo trì");

        button7.setBackground(new java.awt.Color(255, 195, 137));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Phòng đặt trước");

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtpDichVuAllStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtpDichVuAllStateChanged
        int i = jtpDichVuAll.getSelectedIndex();       
        if (i == 0) {
            if (datPhongController == null) {                
                datPhongController = new DatPhongController(this);
                panelPhong.removeAll();
                panelPhong.revalidate();
                panelPhong.repaint();
                List<Object[]> data = datPhongController.getAllDichVu();
                loadTable(tblAllDichVu,data);
                themDichVu(tblAllDichVu);
            }            
        }else if (i == 1) {
            List<Object[]> data = datPhongController.getDichVuId(1);
            loadTable(tblDoUong,data);
            themDichVu(tblDoUong);
        }else if (i == 2) {
            List<Object[]> data = datPhongController.getDichVuId(2);
            loadTable(tblBimbim,data);
            themDichVu(tblBimbim);
        }
    }//GEN-LAST:event_jtpDichVuAllStateChanged

    private void rdbAllPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAllPhongActionPerformed
        if (rdbAllPhong.isSelected()) {
            panelPhong.removeAll();
            datPhongController.loadListPhong();
//            List<Object[]> data = datPhongController.getAllLoaiPhong();
//            for (int i = 0; i <= data.size()-1; i++) {
//                Integer idPhong = Integer.parseInt(data.get(i) [0].toString()) ;
//                Integer idLoaiPhong = Integer.parseInt(data.get(i)[1].toString());
//                String tenPhong = data.get(i) [2].toString();
//                String ttPhong = data.get(i) [3].toString();
//                
//                loadPhongBtn(idPhong,tenPhong,ttPhong,idLoaiPhong);                                 
//            }           
        }
    }//GEN-LAST:event_rdbAllPhongActionPerformed

    private void rdbPhongThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongThuongActionPerformed
        if (rdbPhongThuong.isSelected()) {
            panelPhong.removeAll();
            List<Object[]> data = datPhongController.getLoaiPhongId(1);
            for(int i=0;i<data.size();i++){
                String thoiGianMo ="....................";
                if(!String.valueOf(data.get(i)[4]).equals("null")){
                    thoiGianMo=String.valueOf(data.get(i)[4]);
                }
                loadPhongBtn(Integer.parseInt(data.get(i)[0].toString()), String.valueOf(data.get(i)[1]), 
                        String.valueOf(data.get(i)[2]), Integer.parseInt(data.get(i)[0].toString()),thoiGianMo);
            } 
        }
    }//GEN-LAST:event_rdbPhongThuongActionPerformed

    private void rdbPhongVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongVipActionPerformed
        if (rdbPhongVip.isSelected()) {
            panelPhong.removeAll();
            List<Object[]> data = datPhongController.getLoaiPhongId(2);
            for(int i=0;i<data.size();i++){
                String thoiGianMo ="....................";
                if(!String.valueOf(data.get(i)[4]).equals("null")){
                    thoiGianMo=String.valueOf(data.get(i)[4]);
                }
                loadPhongBtn(Integer.parseInt(data.get(i)[0].toString()), String.valueOf(data.get(i)[1]), 
                        String.valueOf(data.get(i)[2]), Integer.parseInt(data.get(i)[0].toString()),thoiGianMo);
            }            
        }
    }//GEN-LAST:event_rdbPhongVipActionPerformed

    private void rdbPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongTrongActionPerformed
        if (rdbPhongTrong.isSelected()) {
            panelPhong.removeAll();
            List<Object[]> data = datPhongController.getLoaiPhongTT("Phòng còn trống");
            for(int i=0;i<data.size();i++){
                String thoiGianMo ="....................";
                if(!String.valueOf(data.get(i)[4]).equals("null")){
                    thoiGianMo=String.valueOf(data.get(i)[4]);
                }
                loadPhongBtn(Integer.parseInt(data.get(i)[0].toString()), String.valueOf(data.get(i)[1]), String.valueOf(data.get(i)[2]), Integer.getInteger(data.get(i)[3].toString()),thoiGianMo);
            }          
        }
    }//GEN-LAST:event_rdbPhongTrongActionPerformed

    private void rdbPhongActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongActActionPerformed
        if (rdbPhongAct.isSelected()) {
            panelPhong.removeAll();
            List<Object[]> data = datPhongController.getLoaiPhongTT("Đang hoạt động");
            for(int i=0;i<data.size();i++){
                String thoiGianMo ="....................";
                if(!String.valueOf(data.get(i)[4]).equals("null")){
                    thoiGianMo=String.valueOf(data.get(i)[4]);
                }
            loadPhongBtn(Integer.getInteger(data.get(i)[0].toString()), String.valueOf(data.get(i)[1]), String.valueOf(data.get(i)[2]), Integer.getInteger(data.get(i)[3].toString()),thoiGianMo);
            }        
        }
    }//GEN-LAST:event_rdbPhongActActionPerformed

    private void rdbPhongBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongBookActionPerformed
        
        if (rdbPhongBook.isSelected()) {
            panelPhong.removeAll();
            List<Object[]> data = datPhongController.getLoaiPhongTT("Phòng đặt trước");
            for(int i=0;i<data.size();i++){
                String thoiGianMo ="....................";
                if(!String.valueOf(data.get(i)[4]).equals("null")){
                    thoiGianMo=String.valueOf(data.get(i)[4]);
                }
            loadPhongBtn(Integer.getInteger(data.get(i)[0].toString()), String.valueOf(data.get(i)[1]), String.valueOf(data.get(i)[2]), Integer.getInteger(data.get(i)[3].toString()),thoiGianMo);
            }         
        }
    }//GEN-LAST:event_rdbPhongBookActionPerformed

    private void btnMoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoPhongActionPerformed
        Timestamp thoiGianMo = null;
        Date date = new Date();         
        thoiGianMo=new Timestamp(date.getTime());
        String tenKhach = txtTenKhach.getText();
        String SDT = txtSDT.getText();
                
        if (isSDT == false) {
            khachHang = new KhachHang(0,SDT,tenKhach,0.0,0.0,"Thường",0,null);
            khachHangController.insert(khachHang);
        }
        phieuThuePhong = new PhieuThuePhong(0,SDT,phongHienTai,thoiGianMo,null,tenKhach,1);
        phieuThuePhongController.insert(phieuThuePhong);
        phieuDatPhongController.updateTinhTrangPhieuDatPhong(0, phongHienTai);
        datPhongController.updateTinhTrangPhong("Đang hoạt động",phongHienTai);
        button.setBackground(new Color(255,0,0));
        setPhongHoatDong();
        reLoadPhong();
        setThongTinPhong(phongHienTai);     
        cbxDatTruoc.setVisible(false);
    }//GEN-LAST:event_btnMoPhongActionPerformed

    private void btnDatTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatTruocActionPerformed
        String tenKhach = txtTenKhach.getText();
        String SDT = txtSDT.getText();
        GioDatTruoc myCbb = (GioDatTruoc) cbxDatTruoc.getSelectedItem();
        Integer idDatTruoc = myCbb.getId();        
        if (isSDT == false) {
            khachHang = new KhachHang(0,SDT,tenKhach,0.0,0.0,"Thường",0,null);
            khachHangController.insert(khachHang);
        }
        phieuDatPhong = new PhieuDatPhong(0,SDT,phongHienTai,idDatTruoc,null,1,tenKhach);
        phieuDatPhongController.insert(phieuDatPhong);
        datPhongController.updateTinhTrangPhong("Phòng đặt trước",phongHienTai);        
        button.setBackground(new Color(255,195,137));
        reLoadPhong();
        setPhongDatTruoc();
    }//GEN-LAST:event_btnDatTruocActionPerformed

    private void btnDoiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiPhongActionPerformed
        if (doiPhongDialog == null) {
            doiPhongDialog = new DoiPhongDlg(null,true);                                 
            doiPhongDialog.tblPhongMuonDoi.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    DefaultTableModel p = (DefaultTableModel) doiPhongDialog.tblPhongMuonDoi.getModel();
                    int click = doiPhongDialog.tblPhongMuonDoi.getSelectedRow();
                    Integer idPhongMuonDoi = (Integer) doiPhongDialog.tblPhongMuonDoi.getValueAt(click, 0);
                    phongHienTai = idPhongMuonDoi;
                    doiPhongDialog.lblPhongMuonDoi.setText((String) doiPhongDialog.tblPhongMuonDoi.getValueAt(click, 1));
                }
            });            
            doiPhongDialog.btnDoiPhong.addActionListener(new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int click = doiPhongDialog.tblPhongMuonDoi.getSelectedRow();
                    if (click == -1) {
                        doiPhongDialog.lblErr.setText("Chọn phòng muốn đổi");
                    }else {
                        datPhongController.updateTinhTrangPhong("Đang hoạt động", phongHienTai);
                        datPhongController.updateTinhTrangPhong("Phòng còn trống", phongCanDoi);
                        phieuThuePhongController.chuyenPhieuThuePhong(phongHienTai, phongCanDoi);
                        hoaDonController.chuyenHoaDonDichVu(phongHienTai, phongCanDoi);
                        doiPhongDialog.dispose();
                        reLoadPhong();                        
                    }
                }
            });           
        }
        List<Object[]> data = datPhongController.getPhongTrong(loaiPhongHienTai);           
        loadTable(doiPhongDialog.tblPhongMuonDoi, data);
        doiPhongDialog.lblPhongCanDoi.setText(tenPhongHienTai);
        doiPhongDialog.lblPhongMuonDoi.setText("");
        doiPhongDialog.setVisible(true);
    }//GEN-LAST:event_btnDoiPhongActionPerformed

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        String SDT = txtSDT.getText();
        List<Object[]> data = khachHangController.getThongTinKH(SDT);
        if (data.size()<=0) {
            txtTenKhach.setText("");
        } else {
            isSDT=true;
            txtTenKhach.setText(data.get(0)[2].toString());
            txtTenKhach.setEditable(true);
        }
    }//GEN-LAST:event_txtSDTKeyReleased

    private void btnHuyDatTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDatTruocActionPerformed
        phieuDatPhongController.updateTinhTrangPhieuDatPhong(0, phongHienTai);
        datPhongController.updateTinhTrangPhong("Phòng còn trống",phongHienTai);
        reLoadPhong();
        button.setBackground(new Color(0,204,204));
        cbxDatTruoc.setSelectedIndex(0);
        txtSDT.setText("");
        txtTenKhach.setText("");
        btnHuyDatTruoc.setVisible(false);
        btnDatTruoc.setVisible(true);
        lblTenPhong.setForeground(new Color(0,204,204));
    }//GEN-LAST:event_btnHuyDatTruocActionPerformed

    private void btnHuyBaoTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBaoTriActionPerformed
        datPhongController.updateTinhTrangPhong("Phòng còn trống", phongHienTai);
        button.setBackground(new Color(0,204,204));
        reLoadPhong();
        setPhongTrong();
    }//GEN-LAST:event_btnHuyBaoTriActionPerformed

    private void btnBaoTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoTriActionPerformed
        datPhongController.updateTinhTrangPhong("Đang bảo trì", phongHienTai);
        button.setBackground(new Color(153,153,153));
        reLoadPhong();
        setPhongBaoTri();
    }//GEN-LAST:event_btnBaoTriActionPerformed

    private void btnTamTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTamTinhActionPerformed
        String PhuThuThem = txtTienPhuThu.getText();       
        if (!PhuThuThem.equals("")) {
            tienPhuThu = Double.parseDouble(PhuThuThem);
        }else {
            tienPhuThu = 0.0;          
        }        
        for(int i=0;i<=tblSuDungDichVu.getRowCount()-1;i++){
            tienDichVu += ChuyenDoi.SoDouble(tblSuDungDichVu.getValueAt(i, 5).toString()) ;
        }                        
        List<Object[]> data = datPhongController.getGiaPhong(loaiPhongHienTai);       
        Double giaThue = Double.valueOf(data.get(0)[6].toString());
        Date now = new Date();
        Timestamp thoiGian = (Timestamp) data.get(0)[7];
        Date thoiGianMo = (Date) thoiGian;
        long thoiGianSuDung = now.getTime()-thoiGianMo.getTime();        
        long gioSuDung = thoiGianSuDung / (60 * 60 * 1000);
        long phutSuDung = thoiGianSuDung / (60 * 1000) % 60;        
        tienGio = (giaThue/60) * ((gioSuDung*60)+phutSuDung);
        txtTienDichVu.setText(tienDichVu.toString());
        txtTienGio.setText(tienGio.toString());
        tongTien = tienGio+tienDichVu+tienPhuThu;
        txtTongTien.setText(tongTien.toString());
    }//GEN-LAST:event_btnTamTinhActionPerformed

    public void themDichVu(Table table) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                btnThemDichVu.addActionListener(new AbstractAction(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        click1 = table.getSelectedRow();
                        List<Object[]> list = hoaDonController.checkHoaDonPhong(phongHienTai);
                        if(!list.get(0)[0].toString().equals("1")){
                            hoaDonController.taoHoaDonDichVu(phongHienTai);
                        }
                        List<Object[]> data = hoaDonController.getIdHoaDonDichVu(phongHienTai);
                        int idHoaDon = (int) data.get(0)[0];
                        hoaDonController.themChiTietDichVu(idHoaDon,(int) table.getValueAt(click1,0), (int) spnSoLuong.getValue());
                        List<Object[]> data2 = datPhongController.layChiTietDichVu(phongHienTai);
                        loadTableSuDungDV(data2);
                        table.getSelectionModel().clearSelection();
                    }
                });
            }
        });
    }
    
    public void setThongTinPhong(int idPhong) {
        List<Object[]> data2 = datPhongController.layChiTietDichVu(phongHienTai);
        loadTableSuDungDV(data2);
        List<Object[]> data = datPhongController.getThongTinPhong(phongHienTai);
        txtTenKhach.setText(data.get(0)[5].toString());
        txtSDT.setText(data.get(0)[1].toString());
        txtThoiGianMo.setText(data.get(0)[3].toString());
    }
    
    public void setNull() {
        txtSDT.setText("");
        txtTenKhach.setText("");
        txtThoiGianMo.setText("");
    }
    
    public void setNullTamTinh() {
        txtTienDichVu.setText("");
        txtTienGio.setText("");
        txtTienPhuThu.setText("");
        txtTongTien.setText("");
        
    }
    
    public void reLoadPhong(){
        panelPhong.removeAll();
        datPhongController.loadListPhong();
        panelPhong.revalidate();
        panelPhong.repaint();  
    }
    
    public void loadTable(Table table ,List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();  
        if (data == null) {
            for (int i = table.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = table.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }
        }
    }
    
    public void loadTableSuDungDV(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblSuDungDichVu.getModel();  
        if (data == null) {
            for (int i = tblSuDungDichVu.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = tblSuDungDichVu.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }
        }
    }
    
    public void CssTable(JScrollPane table) {
        JPanel p = new JPanel();
        table.setVerticalScrollBar(new ScrollBar());
        table.getVerticalScrollBar().setBackground(Color.WHITE);
        table.getViewport().setBackground(Color.WHITE);       
        table.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
    
    public void setPhongHoatDong() {
        btnHuyDatTruoc.setVisible(false);
        lblTenPhong.setForeground(new Color(255,92,92));
        btnMoPhong.setVisible(false);
        btnDoiPhong.setVisible(true);
        btnDatTruoc.setVisible(false);
        txtThoiGianMo.setVisible(true);
        txtThoiGianMo.setEditable(false);
        cbxDatTruoc.setVisible(false);                    
        btnHuyBaoTri.setVisible(false);
        btnBaoTri.setVisible(false);
    }
    
    public void setPhongTrong() {
        rdbGiaNgayLe.setVisible(true);
        lblTenPhong.setForeground(new Color(0,204,204));
        btnDatTruoc.setVisible(true);
        btnHuyDatTruoc.setVisible(false);
        btnMoPhong.setVisible(true);
        btnDoiPhong.setVisible(false);
        txtThoiGianMo.setVisible(false);
        cbxDatTruoc.setVisible(true);
        loadTableSuDungDV(null);
        cbxDatTruoc.setSelectedIndex(0);
        btnBaoTri.setVisible(true);
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }
    
    public void setPhongBaoTri() {
        btnHuyBaoTri.setVisible(true);
        btnBaoTri.setVisible(false);
        btnMoPhong.setVisible(false);
        rdbGiaNgayLe.setVisible(false);
        lblTenPhong.setForeground(new Color(153,153,153));
        btnDatTruoc.setVisible(false);
        cbxDatTruoc.setVisible(false);
        btnHuyDatTruoc.setVisible(false);
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }
    
    public void setPhongDatTruoc() {
        lblTenPhong.setForeground(new Color(255,195,137));
        btnDatTruoc.setVisible(false);
        btnHuyDatTruoc.setVisible(true);
        cbxDatTruoc.setVisible(true);
        btnHuyBaoTri.setVisible(false);
        btnBaoTri.setVisible(false);
        btnMoPhong.setVisible(true);
        rdbGiaNgayLe.setVisible(true);
        List<Object[]> data = datPhongController.getPhongDatTruoc(phongHienTai);
        txtTenKhach.setText(data.get(0)[6].toString());
        txtSDT.setText(data.get(0)[1].toString());
        for (int i=0; i<cbxDatTruoc.getItemCount();i++){
            GioDatTruoc c= (GioDatTruoc) cbxDatTruoc.getItemAt(i);
            if(c.getIdGioDatTruoc().equals(data.get(0)[3])){
                cbxDatTruoc.setSelectedIndex(i);
            }
        }
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }
    
    public void setCombobox() {
        List<GioDatTruoc> data= datPhongController.getGioDatTruoc();
        cbxDatTruoc.removeAllItems();
        for (GioDatTruoc gioDatTruoc : data) {
            cbxDatTruoc.addItem(gioDatTruoc);
        }
    }
    
    public void setDisable() {
        txtTongTien.setEditable(false);
        txtTienDichVu.setEditable(false);
        txtTienGio.setEditable(false);
    }
    
    public void setController (DatPhongController datPhongController) {
        this.datPhongController = datPhongController;
    }
    
    public void setController (PhieuThuePhongController phieuThuePhongController) {
        this.phieuThuePhongController = phieuThuePhongController;
    }
    
    public void setController (KhachHangController khachHangController) {
        this.khachHangController = khachHangController;
    }
    
    public void setController (HoaDonController hoaDonController) {
        this.hoaDonController = hoaDonController;
    }
    
    public void setController (PhieuDatPhongController phieuDatPhongController) {
        this.phieuDatPhongController = phieuDatPhongController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.RoundPanel body;
    private GUI.Button btnBaoTri;
    private GUI.Button btnDatTruoc;
    private GUI.Button btnDoiPhong;
    private GUI.Button btnHuyBaoTri;
    private GUI.Button btnHuyDatTruoc;
    private GUI.Button btnMoPhong;
    private GUI.Button btnTamTinh;
    private GUI.Button btnThanhToan;
    private GUI.Button btnThemDichVu;
    private GUI.Button button4;
    private GUI.Button button5;
    private GUI.Button button6;
    private GUI.Button button7;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<GioDatTruoc> cbxDatTruoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jtpDichVuAll;
    private javax.swing.JLabel lblTenPhong;
    private GUI.RoundPanel panelP;
    private GUI.RoundPanel panelPhong;
    private GUI.BtnRadioCus rdbAllPhong;
    private GUI.BtnRadioCus rdbGiaNgayLe;
    private GUI.BtnRadioCus rdbPhongAct;
    private GUI.BtnRadioCus rdbPhongBook;
    private GUI.BtnRadioCus rdbPhongThuong;
    private GUI.BtnRadioCus rdbPhongTrong;
    private GUI.BtnRadioCus rdbPhongVip;
    private GUI.RoundPanel roundPanel2;
    private GUI.RoundPanel roundPanel3;
    private GUI.RoundPanel roundPanel4;
    private GUI.RoundPanel roundPanel5;
    private GUI.RoundPanel roundPanel6;
    private javax.swing.JSpinner spnSoLuong;
    private GUI.Table tblAllDichVu;
    private GUI.Table tblBimbim;
    private GUI.Table tblDoUong;
    private GUI.Table tblSuDungDichVu;
    private GUI.TextField txtSDT;
    private GUI.TextField txtTenKhach;
    private GUI.TextField txtThoiGianMo;
    private GUI.TextField txtTienDichVu;
    private GUI.TextField txtTienGio;
    private GUI.TextField txtTienPhuThu;
    private GUI.TextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
