package View_DatPhong;

import swing.Table;
import swing.ScrollBar;
import Controller.DatPhongController;
import Controller.GiaNgayLeController;
import Controller.HoaDonController;
import Controller.PhieuDatPhongController;
import Controller.PhieuThuePhongController;
import View_Dialog.DatPhongDlg;
import View_Dialog.DoiPhongDlg;
import View_Dialog.GiaNgayLeDlg;
import Help.ChuyenDoi;
import Help.ThongBao;
import Model.GiaNgayLe;
import Model.GioDatTruoc;
import Model.HoaDon;
import Model.KhachHang;
import Model.PhieuDatPhong;
import Model.PhieuThuePhong;
import View_Login.Login;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import static javax.swing.JComponent.UNDEFINED_CONDITION;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class DatPhongPnl extends javax.swing.JPanel {
    private PhieuThuePhongController phieuThuePhongController;
    private PhieuDatPhongController phieuDatPhongController;
    private GiaNgayLeController giaNgayLeController;
    private DatPhongController datPhongController;
    private HoaDonController hoaDonController;
    private GiaNgayLeDlg giaNgayLeDialog;
    private DoiPhongDlg doiPhongDialog;
    private DatPhongDlg datPhongDialog;
    private PhongRender phongRender;
    private boolean isSDT = false;
    private Table table;
    int loaiPhongHienTai = UNDEFINED_CONDITION;   
    int phongHienTai = UNDEFINED_CONDITION;
    int clickTamTinh = UNDEFINED_CONDITION;
    int phongCanDoi = UNDEFINED_CONDITION;
    int idGiaNgayLe = UNDEFINED_CONDITION;
    int click1 = UNDEFINED_CONDITION;    
    boolean duocNo = false ;
    int soLuongDauTien =0;
    int loadPopup = 0;
    PhieuThuePhong phieuThuePhong = new PhieuThuePhong();
    PhieuDatPhong phieuDatPhong = new PhieuDatPhong();
    String tenPhongHienTai = TOOL_TIP_TEXT_KEY;
    GiaNgayLe giaNgayLe = new GiaNgayLe();
    KhachHang khachHang = new KhachHang();   
    String sdtKhach ;
    Double tienDichVu = 0.0;
    Double tienNgayLe = 0.0; 
    Double tienPhuThu = 0.0;
    Double tongTien = 0.0;
    Double tienGio = 0.0;
    Double tienNo = 0.0;      
       
    public DatPhongPnl() {
        initComponents();
        init();
        setDisable();
    }

    public void init() {
        CssTable(jScrollPane1);
        CssTable(jScrollPane2);
        CssTable(jScrollPane5);
        CssTable(jScrollPane6);
        CssTable(jScrollPane7);
        CssTable(jScrollPane8);
        CssTable(jScrollPane9);
        CssTable(jScrollPane10);
        btnDoiPhong.setVisible(false);
        txtThoiGianMo.setVisible(false);
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
        rdbDuocNo.setEnabled(false);        
        btnBaoTri.setEnabled(false);
        btnMoPhong.setEnabled(false);
        btnThemDichVu.setEnabled(false);
        tblSuDungDichVu.setEnabled(false);
        jtpDichVuAll.setEnabled(false);
        tblAllDichVu.setEnabled(false);
        clickTamTinh = 0;
        cssTableDichVu(); 
        placeholderDichVu();
    }   
    
    public void loadPhong(List<Object[]> data,List<Object[]> data2,List<Object[]> data3) {
        loadPanelPhong(data, data2, data3);
    }
    
    public void loadAllTableDichVu(){
        //load l???i b???ng danh s??ch d???ch v??? 
        List<Object[]> dichVus = datPhongController.getAllDichVu();
        loadTable(tblAllDichVu,dichVus);

        //load l???i b???ng chi ti???t d???ch v??? s??? d???ng
        List<Object[]> data2 = datPhongController.layChiTietDichVu(phongHienTai);
        loadTableSuDungDV(data2);
    }
    
    public void loadPhongBtn(Integer idPhong, String tenPhong, String ttPhong, Integer idLoaiPhong,String thoiGianMo, List<Object[]> tt) {  
//        setLayoutRenderPhong();
        PhongRender p = new PhongRender(idPhong);
        p.lblTenPhong.setText(tenPhong);
        p.txtGioMo.setText(thoiGianMo);
        p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p.setFont(new java.awt.Font("Segoe UI Light", 1, 12));
        p.setForeground(new java.awt.Color(255,255,255));

        for (int i = 0; i < tt.size(); i++) {           
            if (tt.get(i)[0].equals(idPhong)) {
                p.btnDatTruoc.setBackground(new Color(255,195,137));  
                p.txtGioDatTruoc.setText(tt.get(i)[3].toString());
            }     
        }
                    
        if (ttPhong.equals("Ph??ng c??n tr???ng")) {
            p.setBackground(new Color(0,204,204));
        }else if (ttPhong.equals("??ang ho???t ?????ng")) {           
            p.setBackground(new Color(255,92,92));            
        }else {
            p.setBackground(new Color(153,153,153));
        }       
        
        // s??? ki???n khi click v??o panel ph??ng
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                phongRender = p;
                phongHienTai = idPhong;
                loaiPhongHienTai = idLoaiPhong;
                tenPhongHienTai = tenPhong;
                lblTenPhong.setText(tenPhong);                     
                if (ttPhong.equals("Ph??ng c??n tr???ng")) {
                    setNull();
                    setNullTamTinh();
                    setPhongTrong();
                    btnThemDichVu.setEnabled(false);
                    jtpDichVuAll.setEnabled(false);
                    tblAllDichVu.setEnabled(false);
                    btnMoPhong.setEnabled(true);
                    btnBaoTri.setEnabled(true);
                }else if (ttPhong.equals("??ang ho???t ?????ng")) {
                    phongCanDoi = idPhong;
                    setNullTamTinh();
                    setPhongHoatDong();
                    setThongTinPhong(phongHienTai);
                    btnTamTinh.setEnabled(true);
                    btnThanhToan.setEnabled(true);
                    tblSuDungDichVu.setEnabled(true);
                    jtpDichVuAll.setEnabled(true);
                    tblAllDichVu.setEnabled(true);
                }else if (ttPhong.equals("Ph??ng ?????t tr?????c")) {
                    loadTableSuDungDV(null);
                    setNullTamTinh();
                    setPhongDatTruoc();
                }else {                    
                    setNull();
                    setNullTamTinh();
                    loadTableSuDungDV(null);     
                    setPhongBaoTri();
                    btnThemDichVu.setEnabled(false);
                    jtpDichVuAll.setEnabled(false);
                    tblAllDichVu.setEnabled(false);
                }  
            }                    
        });           
        
        // s??? ki???n khi click v??o ?????t tr?????c
        p.btnDatTruoc.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                phongHienTai = idPhong;
                if (datPhongDialog == null) {                   
                    datPhongDialog = new DatPhongDlg(null,true);
                    setCombobox(datPhongDialog.cbxDatTruoc);      
                }
                if(ttPhong.equals("??ang ho???t ?????ng")) {
                    datPhongDialog.btnMoPhong.setEnabled(false);
                }else {
                    datPhongDialog.btnMoPhong.setEnabled(true);
                }
                
                datPhongDialog.tblDatPhong.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DefaultTableModel p = (DefaultTableModel) datPhongDialog.tblDatPhong.getModel();
                        int click = datPhongDialog.tblDatPhong.getSelectedRow();
                        datPhongDialog.txtTenKhach.setText((String) datPhongDialog.tblDatPhong.getValueAt(click, 2));
                        datPhongDialog.txtSDT.setText((String) datPhongDialog.tblDatPhong.getValueAt(click, 3));

                        PhieuDatPhong pdp = phieuDatPhongController.getIdGioDatTruoc((Integer) datPhongDialog.tblDatPhong.getValueAt(click, 0));                           
                        for (int i = 0; i < datPhongDialog.cbxDatTruoc.getItemCount(); i++) {
                            GioDatTruoc g = (GioDatTruoc) datPhongDialog.cbxDatTruoc.getItemAt(i);
                            if(g.getIdGioDatTruoc().equals(pdp.getThoiGianDat())){
                                datPhongDialog.cbxDatTruoc.setSelectedIndex(i);
                            }
                        }
                        
                        Date date2 = new Date();
                        String datexxx = new SimpleDateFormat("yyyy-MM-dd").format(date2);
                        Date date = new Date(pdp.getNgayDat().getTime());
                        String datexxxx = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        datPhongDialog.jdcNgayDatTruoc.setDate(date);
                        if(datexxx.equals(datexxxx)) {
                            datPhongDialog.btnMoPhong.setEnabled(true);
                        }else datPhongDialog.btnMoPhong.setEnabled(false);
                    } 
                });

                datPhongDialog.btnHuy.addActionListener(new AbstractAction(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < tt.size(); i++) {           
                            if (tt.get(i)[0].equals(phongHienTai)) {
                                GioDatTruoc g =(GioDatTruoc) datPhongDialog.cbxDatTruoc.getSelectedItem();
                                Integer idGioDatTruoc = g.getIdGioDatTruoc();
                                java.util.Date ngayDatTruoc = datPhongDialog.jdcNgayDatTruoc.getDate();
                                java.sql.Date ngayDat = new java.sql.Date(ngayDatTruoc.getTime());
                                String datexxx = new SimpleDateFormat("yyyy-MM-dd").format(ngayDat);
                                
                                phieuDatPhongController.updateNullPhieuDatPhong(0, phongHienTai,idGioDatTruoc,datexxx);
                                p.btnDatTruoc.setBackground(new Color(255,255,255));
                                reLoadPhong();
                                List<Object[]> data = phieuDatPhongController.getPhieuDatPhong(idPhong);
                                loadTable(datPhongDialog.tblDatPhong, data);
                                Date date = new Date();
                                datPhongDialog.jdcNgayDatTruoc.setDate(date);
                                setNullDatPhongDiaglog();
                                phongHienTai =0;
                                datPhongDialog.dispose();
                                ThongBao.ThongBaoDon("Hu??? ph??ng th??nh c??ng", "H???y ph??ng");
                            }
                        }                                                           
                    }                        
                });
  
                datPhongDialog.txtSDT.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyReleased(KeyEvent e) {
                        String SDT = datPhongDialog.txtSDT.getText();
                        List<Object[]> data = datPhongController.getThongTinKH(SDT);
                        if (data.size()<=0) {
                            datPhongDialog.txtTenKhach.setText("");
                        } else {
                            isSDT=true;
                            datPhongDialog.txtTenKhach.setText(data.get(0)[1].toString());
                            datPhongDialog.txtTenKhach.setEditable(true);
                        }
                    }                       
                });
                
                datPhongDialog.btnDatTruoc.addActionListener(new AbstractAction(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String tenKhach = datPhongDialog.txtTenKhach.getText();
                        String SDT = datPhongDialog.txtSDT.getText();
                        GioDatTruoc myCbb = (GioDatTruoc) datPhongDialog.cbxDatTruoc.getSelectedItem();
                        String gio = myCbb.getTenHinhThuc(); 
                        java.util.Date ngayDatTruoc = datPhongDialog.jdcNgayDatTruoc.getDate();
                        java.sql.Date ngayDat = new java.sql.Date(ngayDatTruoc.getTime());
                        Integer idDatTruoc = myCbb.getId();
                        if (idDatTruoc==1) {
                            datPhongDialog.lblErrCbx.setText("Ch???n th???i gian ?????t");
                        }else if (idDatTruoc!=1 || phongHienTai != 0 || !datPhongDialog.txtSDT.getText().equals("") || !datPhongDialog.txtTenKhach.getText().equals("")) {
                            if (isSDT == false) {
                                datPhongController.insertKhachHang(SDT,tenKhach,0.0,0.0,0,null,1);
                            }
                            phieuDatPhong = new PhieuDatPhong(0,SDT,phongHienTai,idDatTruoc,null,true,tenKhach,ngayDat);
                            phieuDatPhongController.insert(phieuDatPhong);                                    
                            List<Object[]> data = phieuDatPhongController.getPhieuDatPhong(phongHienTai);
                            loadTable(datPhongDialog.tblDatPhong, data);
                            datPhongController.HienThiThoiGian(gio,tenKhach,SDT,phongHienTai);
                            Date date = new Date();
                            datPhongDialog.jdcNgayDatTruoc.setDate(date);
                            reLoadPhong();
                            setNullDatPhongDiaglog();  
                            ThongBao.ThongBaoDon("?????t ph??ng th??nh c??ng", "?????t ph??ng");
                            datPhongDialog.dispose();
                            phongHienTai = 0;
                        }
                    }
                });
                
                datPhongDialog.btnMoPhong.addActionListener(new AbstractAction(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Timestamp thoiGianMo = null;
                        Date date = new Date();
                        thoiGianMo=new Timestamp(date.getTime());
                        String tenKhach = datPhongDialog.txtTenKhach.getText();
                        String SDT = datPhongDialog.txtSDT.getText();
                        List<Object[]> khachHang = datPhongController.getThongTinKH(SDT);
                        if (phongHienTai !=0 || !datPhongDialog.txtSDT.getText().equals("") || !datPhongDialog.txtTenKhach.getText().equals("")) {
                            if (!SDT.equals(khachHang.get(0)[0])){
                                datPhongController.insertKhachHang(SDT,tenKhach,0.0,0.0,0,null,1);
                            }
                            if (datPhongDialog.rdbGiaNgayLe.isSelected()) {
                                phieuThuePhong = new PhieuThuePhong(0,SDT,1,phongHienTai,thoiGianMo,null,tenKhach,1,1);                              
                                phieuThuePhongController.insert(phieuThuePhong);
                            }else {
                                phieuThuePhong = new PhieuThuePhong(0,SDT,1,phongHienTai,thoiGianMo,null,tenKhach,1,0);
                                phieuThuePhongController.insert(phieuThuePhong);
                            }        
                            phieuDatPhongController.updateTinhTrangPhieuDatPhong(0, phongHienTai);
                            datPhongController.updateTinhTrangPhong("??ang ho???t ?????ng",phongHienTai);
                            List<Object[]> data = phieuDatPhongController.getPhieuDatPhong(phongHienTai);
                            loadTable(datPhongDialog.tblDatPhong, data);
                            p.btnDatTruoc.setBackground(new Color(255,0,0));
                            setPhongHoatDong();
                            reLoadPhong();
                            setThongTinPhong(phongHienTai);
                            setNullDatPhongDiaglog();
                            phongHienTai = 0;
                            datPhongDialog.dispose();
                        }
                    }
                });
                
                List<Object[]> data = phieuDatPhongController.getPhieuDatPhong(idPhong);
                loadTable(datPhongDialog.tblDatPhong, data);
                datPhongDialog.txtTenKhach.setText("");
                datPhongDialog.txtSDT.setText("");
                datPhongDialog.lblErrCbx.setText("");
                datPhongDialog.cbxDatTruoc.setSelectedIndex(0);
                datPhongDialog.lblTenPhongDlg.setText(tenPhong.toUpperCase());
                datPhongDialog.setVisible(true);
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
        body = new swing.RoundPanel();
        roundPanel2 = new swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rdbPhongVip = new swing.BtnRadioCus();
        rdbPhongThuong = new swing.BtnRadioCus();
        rdbAllPhong = new swing.BtnRadioCus();
        rdbPhongTrong = new swing.BtnRadioCus();
        rdbPhongDangHoatDong = new swing.BtnRadioCus();
        rdbBaoTri = new swing.BtnRadioCus();
        roundPanel3 = new swing.RoundPanel();
        lblTenPhong = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtThoiGianMo = new swing.TextField();
        txtTenKhach = new swing.TextField();
        btnMoPhong = new swing.Button();
        rdbGiaNgayLe = new swing.BtnRadioCus();
        btnDoiPhong = new swing.Button();
        txtSDT = new swing.TextField();
        btnBaoTri = new swing.Button();
        btnHuyBaoTri = new swing.Button();
        btnGiaNgayLe = new swing.Button();
        roundPanel4 = new swing.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnThanhToan = new swing.Button();
        btnTamTinh = new swing.Button();
        txtTienGio = new swing.TextField();
        txtTienDichVu = new swing.TextField();
        txtTienPhuThu = new swing.TextField();
        txtTongTien = new swing.TextField();
        rdbDuocNo = new swing.BtnRadioCus();
        jLabel3 = new javax.swing.JLabel();
        roundPanel5 = new swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuDungDichVu = new swing.Table();
        jLabel4 = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        btnThemDichVu = new swing.Button();
        btnHuyDichVu = new swing.Button();
        roundPanel6 = new swing.RoundPanel();
        button4 = new swing.Button();
        jLabel5 = new javax.swing.JLabel();
        button5 = new swing.Button();
        jLabel6 = new javax.swing.JLabel();
        button6 = new swing.Button();
        jLabel7 = new javax.swing.JLabel();
        button7 = new swing.Button();
        jLabel8 = new javax.swing.JLabel();
        panelP = new swing.RoundPanel();
        panelPhong = new swing.RoundPanel();
        jPanel7 = new swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jtpDichVuAll = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllDichVu = new swing.Table();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDoUong = new swing.Table();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblBimbim = new swing.Table();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblThuocLa = new swing.Table();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDoKho = new swing.Table();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDoAn = new swing.Table();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblTraiCay = new swing.Table();
        txtTimDichVu = new swing.TextInputTT();

        setBackground(new java.awt.Color(255, 255, 255));

        body.setBackground(new java.awt.Color(218, 232, 232));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh s??ch ph??ng");

        rdbPhongVip.setBackground(new java.awt.Color(0, 102, 204));
        buttonGroup1.add(rdbPhongVip);
        rdbPhongVip.setText("Ph??ng vip");
        rdbPhongVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongVipActionPerformed(evt);
            }
        });

        rdbPhongThuong.setBackground(new java.awt.Color(153, 153, 0));
        buttonGroup1.add(rdbPhongThuong);
        rdbPhongThuong.setText("Ph??ng th?????ng");
        rdbPhongThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongThuongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbAllPhong);
        rdbAllPhong.setSelected(true);
        rdbAllPhong.setText("T???t c???");
        rdbAllPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAllPhongActionPerformed(evt);
            }
        });

        rdbPhongTrong.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(rdbPhongTrong);
        rdbPhongTrong.setText("Ph??ng tr???ng");
        rdbPhongTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongTrongActionPerformed(evt);
            }
        });

        rdbPhongDangHoatDong.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup1.add(rdbPhongDangHoatDong);
        rdbPhongDangHoatDong.setText("Ho???t ?????ng");
        rdbPhongDangHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPhongDangHoatDongActionPerformed(evt);
            }
        });

        rdbBaoTri.setBackground(new java.awt.Color(204, 0, 204));
        buttonGroup1.add(rdbBaoTri);
        rdbBaoTri.setText("B???o tr??");
        rdbBaoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbBaoTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbAllPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbPhongThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbPhongDangHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdbBaoTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdbPhongVip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(rdbPhongDangHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTenPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong.setText("PH??NG ...");
        roundPanel3.add(lblTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 11, 270, 30));
        roundPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, 406, 10));

        txtThoiGianMo.setLabelText("Th???i gian m???");
        roundPanel3.add(txtThoiGianMo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, -1));

        txtTenKhach.setText("Kh??ch v??ng lai");
        txtTenKhach.setLabelText("T??n kh??ch h??ng");
        roundPanel3.add(txtTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 190, 50));

        btnMoPhong.setBackground(new java.awt.Color(120, 225, 220));
        btnMoPhong.setText("M??? ph??ng");
        btnMoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoPhongActionPerformed(evt);
            }
        });
        roundPanel3.add(btnMoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 82, 44));

        rdbGiaNgayLe.setBackground(new java.awt.Color(255, 0, 0));
        rdbGiaNgayLe.setText("Gi?? ng??y l???");
        roundPanel3.add(rdbGiaNgayLe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 30));

        btnDoiPhong.setBackground(new java.awt.Color(120, 225, 220));
        btnDoiPhong.setText("?????i ph??ng");
        btnDoiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiPhongActionPerformed(evt);
            }
        });
        roundPanel3.add(btnDoiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 82, 44));

        txtSDT.setLabelText("S??? ??i???n tho???i");
        txtSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSDTMouseClicked(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });
        roundPanel3.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 50));

        btnBaoTri.setBackground(new java.awt.Color(120, 225, 220));
        btnBaoTri.setText("B???o tr??");
        btnBaoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoTriActionPerformed(evt);
            }
        });
        roundPanel3.add(btnBaoTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 30));

        btnHuyBaoTri.setBackground(new java.awt.Color(120, 225, 220));
        btnHuyBaoTri.setText("H???y");
        btnHuyBaoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBaoTriActionPerformed(evt);
            }
        });
        roundPanel3.add(btnHuyBaoTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 30));

        btnGiaNgayLe.setBackground(new java.awt.Color(120, 225, 220));
        btnGiaNgayLe.setText("Gi?? ng??y l???");
        btnGiaNgayLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaNgayLeActionPerformed(evt);
            }
        });
        roundPanel3.add(btnGiaNgayLe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 30));

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("THANH TO??N");

        btnThanhToan.setBackground(new java.awt.Color(120, 225, 220));
        btnThanhToan.setText("Thanh to??n");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTamTinh.setBackground(new java.awt.Color(120, 225, 220));
        btnTamTinh.setText("T???m t??nh");
        btnTamTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTamTinhActionPerformed(evt);
            }
        });

        txtTienGio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienGio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtTienGio.setLabelText("Ti???n gi???");

        txtTienDichVu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienDichVu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtTienDichVu.setLabelText("Ti???n d???ch v???");

        txtTienPhuThu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienPhuThu.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtTienPhuThu.setLabelText("Ti???n ph??? thu");
        txtTienPhuThu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienPhuThuKeyReleased(evt);
            }
        });

        txtTongTien.setForeground(new java.awt.Color(255, 0, 0));
        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTongTien.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtTongTien.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtTongTien.setLabelText("Th??nh ti???n");

        rdbDuocNo.setBackground(new java.awt.Color(0, 102, 204));
        rdbDuocNo.setText("Kh??ng");
        rdbDuocNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbDuocNoActionPerformed(evt);
            }
        });

        jLabel3.setText("???????c n??? ?: ");

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
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbDuocNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbDuocNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20))
        );

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblSuDungDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "D???ch v???", "??VT", "Ng??y s??? d???ng", "SL", "Th??nh ti???n", "idDichVu"
            }
        ));
        tblSuDungDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuDungDichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSuDungDichVu);
        if (tblSuDungDichVu.getColumnModel().getColumnCount() > 0) {
            tblSuDungDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(1).setMinWidth(100);
            tblSuDungDichVu.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblSuDungDichVu.getColumnModel().getColumn(1).setMaxWidth(100);
            tblSuDungDichVu.getColumnModel().getColumn(2).setMinWidth(40);
            tblSuDungDichVu.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblSuDungDichVu.getColumnModel().getColumn(2).setMaxWidth(40);
            tblSuDungDichVu.getColumnModel().getColumn(4).setMinWidth(25);
            tblSuDungDichVu.getColumnModel().getColumn(4).setPreferredWidth(25);
            tblSuDungDichVu.getColumnModel().getColumn(4).setMaxWidth(25);
            tblSuDungDichVu.getColumnModel().getColumn(5).setMinWidth(80);
            tblSuDungDichVu.getColumnModel().getColumn(5).setPreferredWidth(80);
            tblSuDungDichVu.getColumnModel().getColumn(5).setMaxWidth(80);
            tblSuDungDichVu.getColumnModel().getColumn(6).setMinWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblSuDungDichVu.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("D???CH V??? S??? D???NG");

        spnSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnSoLuong.setOpaque(false);

        btnThemDichVu.setBackground(new java.awt.Color(120, 225, 220));
        btnThemDichVu.setText("C???p Nh???t");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnHuyDichVu.setBackground(new java.awt.Color(120, 225, 220));
        btnHuyDichVu.setText("Hu???");
        btnHuyDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHuyDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        spnSoLuong.setBackground(Color.WHITE);

        roundPanel6.setBackground(new java.awt.Color(255, 255, 255));

        button4.setBackground(new java.awt.Color(255, 92, 92));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("??ang ho???t ?????ng");

        button5.setBackground(new java.awt.Color(0, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Ph??ng c??n tr???ng");

        button6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("??ang b???o tr??");

        button7.setBackground(new java.awt.Color(255, 195, 137));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Ph??ng ?????t tr?????c");

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

        panelP.setBackground(new java.awt.Color(255, 255, 255));

        panelPhong.setBackground(new java.awt.Color(255, 255, 255));
        panelPhong.setLayout(new java.awt.GridLayout(4, 2, 5, 5));

        javax.swing.GroupLayout panelPLayout = new javax.swing.GroupLayout(panelP);
        panelP.setLayout(panelPLayout);
        panelPLayout.setHorizontalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPLayout.setVerticalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("D???CH V???");

        jtpDichVuAll.setBackground(new java.awt.Color(255, 255, 255));
        jtpDichVuAll.setForeground(new java.awt.Color(51, 51, 51));
        jtpDichVuAll.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
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

            },
            new String [] {
                "id", "D???ch v???", "??VT", "Gi??", "SL C??n"
            }
        ));
        jScrollPane2.setViewportView(tblAllDichVu);
        if (tblAllDichVu.getColumnModel().getColumnCount() > 0) {
            tblAllDichVu.getColumnModel().getColumn(0).setMinWidth(0);
            tblAllDichVu.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblAllDichVu.getColumnModel().getColumn(0).setMaxWidth(0);
            tblAllDichVu.getColumnModel().getColumn(1).setMinWidth(100);
            tblAllDichVu.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblAllDichVu.getColumnModel().getColumn(1).setMaxWidth(100);
            tblAllDichVu.getColumnModel().getColumn(2).setMinWidth(95);
            tblAllDichVu.getColumnModel().getColumn(2).setPreferredWidth(95);
            tblAllDichVu.getColumnModel().getColumn(2).setMaxWidth(95);
            tblAllDichVu.getColumnModel().getColumn(4).setMinWidth(60);
            tblAllDichVu.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblAllDichVu.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("T???t c???", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblDoUong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "D???ch v???", "??VT", "Gi??", "SL C??n"
            }
        ));
        jScrollPane5.setViewportView(tblDoUong);
        if (tblDoUong.getColumnModel().getColumnCount() > 0) {
            tblDoUong.getColumnModel().getColumn(0).setMinWidth(0);
            tblDoUong.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDoUong.getColumnModel().getColumn(0).setMaxWidth(0);
            tblDoUong.getColumnModel().getColumn(1).setMinWidth(100);
            tblDoUong.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblDoUong.getColumnModel().getColumn(1).setMaxWidth(100);
            tblDoUong.getColumnModel().getColumn(2).setMinWidth(95);
            tblDoUong.getColumnModel().getColumn(2).setPreferredWidth(95);
            tblDoUong.getColumnModel().getColumn(2).setMaxWidth(95);
            tblDoUong.getColumnModel().getColumn(4).setMinWidth(60);
            tblDoUong.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblDoUong.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("????? u???ng", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblBimbim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "D???ch v???", "??VT", "Gi??", "SL C??n"
            }
        ));
        jScrollPane6.setViewportView(tblBimbim);
        if (tblBimbim.getColumnModel().getColumnCount() > 0) {
            tblBimbim.getColumnModel().getColumn(0).setMinWidth(0);
            tblBimbim.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblBimbim.getColumnModel().getColumn(0).setMaxWidth(0);
            tblBimbim.getColumnModel().getColumn(1).setMinWidth(100);
            tblBimbim.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBimbim.getColumnModel().getColumn(1).setMaxWidth(100);
            tblBimbim.getColumnModel().getColumn(2).setMinWidth(95);
            tblBimbim.getColumnModel().getColumn(2).setPreferredWidth(95);
            tblBimbim.getColumnModel().getColumn(2).setMaxWidth(95);
            tblBimbim.getColumnModel().getColumn(4).setMinWidth(60);
            tblBimbim.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblBimbim.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("Bim bim", jPanel5);

        tblThuocLa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "D???ch v???", "??VT", "Gi??", "SL C??n"
            }
        ));
        jScrollPane7.setViewportView(tblThuocLa);
        if (tblThuocLa.getColumnModel().getColumnCount() > 0) {
            tblThuocLa.getColumnModel().getColumn(0).setMinWidth(0);
            tblThuocLa.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblThuocLa.getColumnModel().getColumn(0).setMaxWidth(0);
            tblThuocLa.getColumnModel().getColumn(1).setMinWidth(100);
            tblThuocLa.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblThuocLa.getColumnModel().getColumn(1).setMaxWidth(100);
            tblThuocLa.getColumnModel().getColumn(2).setMinWidth(95);
            tblThuocLa.getColumnModel().getColumn(2).setPreferredWidth(95);
            tblThuocLa.getColumnModel().getColumn(2).setMaxWidth(95);
            tblThuocLa.getColumnModel().getColumn(4).setMinWidth(60);
            tblThuocLa.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblThuocLa.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("Thu???c l??", jPanel1);

        tblDoKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "D???ch v???", "??VT", "Gi??", "SL C??n"
            }
        ));
        jScrollPane8.setViewportView(tblDoKho);
        if (tblDoKho.getColumnModel().getColumnCount() > 0) {
            tblDoKho.getColumnModel().getColumn(0).setMinWidth(0);
            tblDoKho.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDoKho.getColumnModel().getColumn(0).setMaxWidth(0);
            tblDoKho.getColumnModel().getColumn(1).setMinWidth(100);
            tblDoKho.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblDoKho.getColumnModel().getColumn(1).setMaxWidth(100);
            tblDoKho.getColumnModel().getColumn(2).setMinWidth(95);
            tblDoKho.getColumnModel().getColumn(2).setPreferredWidth(95);
            tblDoKho.getColumnModel().getColumn(2).setMaxWidth(95);
            tblDoKho.getColumnModel().getColumn(4).setMinWidth(60);
            tblDoKho.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblDoKho.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("????? kh??", jPanel2);

        tblDoAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "D???ch v???", "??VT", "Gi??", "SL C??n"
            }
        ));
        jScrollPane9.setViewportView(tblDoAn);
        if (tblDoAn.getColumnModel().getColumnCount() > 0) {
            tblDoAn.getColumnModel().getColumn(0).setMinWidth(0);
            tblDoAn.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDoAn.getColumnModel().getColumn(0).setMaxWidth(0);
            tblDoAn.getColumnModel().getColumn(1).setMinWidth(100);
            tblDoAn.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblDoAn.getColumnModel().getColumn(1).setMaxWidth(100);
            tblDoAn.getColumnModel().getColumn(2).setMinWidth(95);
            tblDoAn.getColumnModel().getColumn(2).setPreferredWidth(95);
            tblDoAn.getColumnModel().getColumn(2).setMaxWidth(95);
            tblDoAn.getColumnModel().getColumn(4).setMinWidth(60);
            tblDoAn.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblDoAn.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("????? ??n", jPanel6);

        tblTraiCay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "D???ch v???", "??VT", "Gi??", "SL C??n"
            }
        ));
        jScrollPane10.setViewportView(tblTraiCay);
        if (tblTraiCay.getColumnModel().getColumnCount() > 0) {
            tblTraiCay.getColumnModel().getColumn(0).setMinWidth(0);
            tblTraiCay.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblTraiCay.getColumnModel().getColumn(0).setMaxWidth(0);
            tblTraiCay.getColumnModel().getColumn(1).setMinWidth(100);
            tblTraiCay.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblTraiCay.getColumnModel().getColumn(1).setMaxWidth(100);
            tblTraiCay.getColumnModel().getColumn(2).setMinWidth(95);
            tblTraiCay.getColumnModel().getColumn(2).setPreferredWidth(95);
            tblTraiCay.getColumnModel().getColumn(2).setMaxWidth(95);
            tblTraiCay.getColumnModel().getColumn(4).setMinWidth(60);
            tblTraiCay.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblTraiCay.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
        );

        jtpDichVuAll.addTab("Tr??i c??y", jPanel8);

        txtTimDichVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimDichVuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpDichVuAll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(txtTimDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpDichVuAll)
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        }else if (i == 3) {
            List<Object[]> data = datPhongController.getDichVuId(3);
            loadTable(tblThuocLa,data);
            themDichVu(tblThuocLa);
        }else if (i == 4) {
            List<Object[]> data = datPhongController.getDichVuId(4);
            loadTable(tblDoKho,data);
            themDichVu(tblDoKho);
        }else if (i == 5) {
            List<Object[]> data = datPhongController.getDichVuId(5);
            loadTable(tblDoAn,data);
            themDichVu(tblDoAn);
        }else if (i == 6) {
            List<Object[]> data = datPhongController.getDichVuId(6);
            loadTable(tblTraiCay,data);
            themDichVu(tblTraiCay);
        }
    }//GEN-LAST:event_jtpDichVuAllStateChanged

    //Hi???n th??? t???t c??? ph??ng
    private void rdbAllPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAllPhongActionPerformed
        if (rdbAllPhong.isSelected()) {
            panelPhong.removeAll();
            datPhongController.loadListPhong();          
        }
    }//GEN-LAST:event_rdbAllPhongActionPerformed
   
    //Hi???n th??? ph??ng th?????ng
    private void rdbPhongThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongThuongActionPerformed
        
        if (rdbPhongThuong.isSelected()) {
            panelPhong.removeAll();
            List<Object[]> data = datPhongController.fullInfoLoaiPhong(1);
            List<Object[]> data2 = datPhongController.infoOpen();
            List<Object[]> data3 = datPhongController.getTTPhieuDatPhong();
            loadPanelPhong(data, data2, data3);
        }
    }//GEN-LAST:event_rdbPhongThuongActionPerformed

    //Hi???n th??? ph??ng vip
    private void rdbPhongVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongVipActionPerformed
        if (rdbPhongVip.isSelected()) {
            panelPhong.removeAll();
            List<Object[]> data = datPhongController.fullInfoLoaiPhong(2);
            List<Object[]> data2 = datPhongController.infoOpen();
            List<Object[]> data3 = datPhongController.getTTPhieuDatPhong();
            loadPanelPhong(data, data2, data3);
        }
    }//GEN-LAST:event_rdbPhongVipActionPerformed

    //Hi???n th??? ph??ng tr???ng
    private void rdbPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongTrongActionPerformed
        if (rdbPhongTrong.isSelected()) {
            panelPhong.removeAll();
            String tinhTrangPhong = "Ph??ng c??n tr???ng";
            List<Object[]> data = datPhongController.getLoaiPhongTT(tinhTrangPhong);
            List<Object[]> data2 = datPhongController.infoOpen();
            List<Object[]> data3 = datPhongController.getTTPhieuDatPhong();
            if(data.isEmpty()){
                PhongRenderNull pNull = new PhongRenderNull();
                panelPhong.add(pNull);
                panelPhong.revalidate();
                panelPhong.repaint();
            }else{
                loadPanelPhong(data, data2, data3);
            }    
        }
    }//GEN-LAST:event_rdbPhongTrongActionPerformed

    //HI???n th??? ph??ng ??ang ho???t ?????ng
    private void rdbPhongDangHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPhongDangHoatDongActionPerformed
        if (rdbPhongDangHoatDong.isSelected()) {
            System.out.println("Ho???t ?????ng");
            panelPhong.removeAll();
            String tinhTrangPhong = "??ang ho???t ?????ng";
            List<Object[]> data = datPhongController.getLoaiPhongTT(tinhTrangPhong);
            List<Object[]> data2 = datPhongController.infoOpen();
            List<Object[]> data3 = datPhongController.getTTPhieuDatPhong();
            
            if(data.isEmpty()){
                PhongRenderNull pNull = new PhongRenderNull();
                panelPhong.add(pNull);
                panelPhong.revalidate();
                panelPhong.repaint();
            }else{
                loadPanelPhong(data, data2, data3);
            }
        }
    }//GEN-LAST:event_rdbPhongDangHoatDongActionPerformed

    //Set tr???ng th??i b???o tr??
    private void rdbBaoTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbBaoTriActionPerformed
        if (rdbBaoTri.isSelected()) {
            panelPhong.removeAll();
            String tinhTrangPhong = "??ang b???o tr??";
            List<Object[]> data = datPhongController.getLoaiPhongTT(tinhTrangPhong);
            List<Object[]> data2 = datPhongController.infoOpen();
            List<Object[]> data3 = datPhongController.getTTPhieuDatPhong();
            if(data.isEmpty()){
                PhongRenderNull pNull = new PhongRenderNull();
                panelPhong.add(pNull);
                panelPhong.revalidate();
                panelPhong.repaint();
            }else{
                loadPanelPhong(data, data2, data3);
            }
        }
    }//GEN-LAST:event_rdbBaoTriActionPerformed

    //M??? ph??ng
    private void btnMoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoPhongActionPerformed
        Timestamp thoiGianMo = null;
        Date date = new Date();         
        thoiGianMo=new Timestamp(date.getTime());
        String tenKhach = txtTenKhach.getText();
        String SDT = txtSDT.getText();
        if(txtSDT.getText().equals("")){
            SDT="0000000000";
            txtSDT.setText(SDT);
            isSDT=true;
        }
        

        if (isSDT == false ) {
            if (!SDT.equals("")) {
                //Th??m kh??ch n???u l?? kh??ch l???n ?????u
                datPhongController.insertKhachHang(SDT,tenKhach,0.0,0.0,0,null,1);
            }
        }

        if (rdbGiaNgayLe.isSelected()) {
            //Ch???nh gi?? ng??y l???
            phieuThuePhong = new PhieuThuePhong(0,SDT,Login.idNV,phongHienTai,thoiGianMo,null,tenKhach,1,1);
            phieuThuePhongController.insert(phieuThuePhong);
        }else {
            //Th??m phi???u thu?? ph??ng
            phieuThuePhong = new PhieuThuePhong(0,SDT,Login.idNV,phongHienTai,thoiGianMo,null,tenKhach,1,0);
            phieuThuePhongController.insert(phieuThuePhong);
        }
       
        sdtKhach=SDT;
        //C???p nh???t t??nh tr???ng ph??ng
        phieuDatPhongController.updateTinhTrangPhieuDatPhong(0, phongHienTai);
        datPhongController.updateTinhTrangPhong("??ang ho???t ?????ng",phongHienTai);
        
        phongRender.setBackground(new Color(255,0,0));
        setPhongHoatDong();
        reLoadPhong();
        tblAllDichVu.setEnabled(true);
        jtpDichVuAll.setEnabled(true);
        setThongTinPhong(phongHienTai);                     
                          
    }//GEN-LAST:event_btnMoPhongActionPerformed

    //?????i ph??ng
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
                        doiPhongDialog.lblErr.setText("Ch???n ph??ng mu???n ?????i");
                    }else {
                        datPhongController.updateTinhTrangPhong("??ang ho???t ?????ng", phongHienTai);
                        datPhongController.updateTinhTrangPhong("Ph??ng c??n tr???ng", phongCanDoi);
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

    //Search sdt trong DB
    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        String SDT = txtSDT.getText();
        if(txtSDT.getText().equals("")){
            SDT="0000000000";
            isSDT=true;
            
        }
        List<Object[]> data = datPhongController.getThongTinKH(SDT);
        if (data.size()<=0) {
            txtTenKhach.setText("");
        } else {
            isSDT=true;
            txtTenKhach.setText(data.get(0)[1].toString());
            duocNo=(boolean) data.get(0)[4];
            if(duocNo){
                rdbDuocNo.setSelected(true);
                rdbDuocNo.setText("C??");
            }else{
                rdbDuocNo.setSelected(false);
                rdbDuocNo.setText("Kh??ng");
            }
            txtTenKhach.setEditable(true);
        }
    }//GEN-LAST:event_txtSDTKeyReleased

    //Hu??? b???o tr??
    private void btnHuyBaoTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBaoTriActionPerformed
        datPhongController.updateTinhTrangPhong("Ph??ng c??n tr???ng", phongHienTai);
        phongRender.setBackground(new Color(0,204,204));
        reLoadPhong();
        setPhongTrong();
    }//GEN-LAST:event_btnHuyBaoTriActionPerformed

    //B???o tr??
    private void btnBaoTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoTriActionPerformed
        datPhongController.updateTinhTrangPhong("??ang b???o tr??", phongHienTai);
        phongRender.setBackground(new Color(153,153,153));
        reLoadPhong();
        setPhongBaoTri();
    }//GEN-LAST:event_btnBaoTriActionPerformed

    //T???m t??nh
    private void btnTamTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTamTinhActionPerformed
        tienDichVu = 0.0;
        String PhuThuThem = txtTienPhuThu.getText();       
        if (!PhuThuThem.equals("")) {
            tienPhuThu = Double.parseDouble(PhuThuThem);
        }else {
            tienPhuThu = 0.0;          
        }
        
        for(int i=0;i<=tblSuDungDichVu.getRowCount()-1;i++){
            tienDichVu += ChuyenDoi.SoDouble(tblSuDungDichVu.getValueAt(i, 5).toString());
        }
        
        List<Object[]> gia = giaNgayLeController.getGiaNgayLeTrue();
        
        tienNgayLe = Double.parseDouble(gia.get(0)[1].toString());
        List<Object[]> data = datPhongController.getGiaPhong(loaiPhongHienTai, phongHienTai);
        
        for (int i = 0; i < data.size(); i++) {
            Double giaThue = Double.valueOf(data.get(i)[5].toString());
            Date now = new Date();
            Timestamp thoiGian = (Timestamp) data.get(i)[6];
            Date thoiGianMo = (Date) thoiGian;
            long thoiGianSuDung = now.getTime()-thoiGianMo.getTime();  
            long gioSuDung = thoiGianSuDung / (60 * 1000 * 60);
            long phutSuDung = thoiGianSuDung / (60 * 1000) % 60;           
            List<Object[]> phieuThuePhong = phieuThuePhongController.getThongTinGiaNgayLe(phongHienTai);
            if (phieuThuePhong.get(0)[0].toString().equals("1")) {
                tienGio = ChuyenDoi.lamTronSoDouble((((giaThue/60)+((giaThue/60)*tienNgayLe/100)) * ((gioSuDung*60)+phutSuDung)),100);
                txtTienDichVu.setText(ChuyenDoi.SoString(tienDichVu));
                txtTienGio.setText(ChuyenDoi.SoString(tienGio));
                tongTien = tienGio+tienDichVu+tienPhuThu;
                txtTongTien.setText(ChuyenDoi.SoString(tongTien));
            }else {
                tienGio = ChuyenDoi.lamTronSoDouble((giaThue/60) * ((gioSuDung*60)+phutSuDung),100);
                txtTienDichVu.setText(ChuyenDoi.SoString(tienDichVu));
                txtTienGio.setText(ChuyenDoi.SoString(tienGio));
                tongTien = tienGio+tienDichVu+tienPhuThu;
                txtTongTien.setText(ChuyenDoi.SoString(tongTien));
            }
        }
        //update l???i ti???n d???ch v???
        List <Object[]> data2 = hoaDonController.layIdHoaDonDichVu(phongHienTai);
        if(data2.size()==0){
        }else{
            hoaDonController.updateTienHoaDonDV(tienDichVu,(Integer.valueOf(data2.get(0)[0].toString())));
        }
        clickTamTinh = 1;
    }//GEN-LAST:event_btnTamTinhActionPerformed

    private void btnGiaNgayLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaNgayLeActionPerformed
        List<Object[]> data = giaNgayLeController.getGiaNgayLe();
        if (giaNgayLeDialog == null) {
            giaNgayLeDialog = new GiaNgayLeDlg(null,true);        
                       
            giaNgayLeDialog.tblGiaNgayLe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    DefaultTableModel p = (DefaultTableModel) giaNgayLeDialog.tblGiaNgayLe.getModel();
                    int click = giaNgayLeDialog.tblGiaNgayLe.getSelectedRow();
                    String id = giaNgayLeDialog.tblGiaNgayLe.getValueAt(click, 0).toString();
                    idGiaNgayLe = Integer.parseInt(id);
                    giaNgayLeDialog.txtGiaNgayLe.setText(giaNgayLeDialog.tblGiaNgayLe.getValueAt(click, 1).toString()+" %");
                }
            });
            giaNgayLeDialog.btnThemGia.addActionListener(new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    String txt = giaNgayLeDialog.txtGia.getText();
                    loadTable(giaNgayLeDialog.tblGiaNgayLe, data);
                    if(txt.equals(data.get(0)[1].toString())) {
                        giaNgayLeDialog.lblErr.setText("Gi?? ???? t???n t???i");
                    }else{
                        giaNgayLe = new GiaNgayLe(0,txt,0);
                        giaNgayLeController.insert(giaNgayLe);
                    }    
                    List<Object[]> data = giaNgayLeController.getGiaNgayLe();
                    loadTable(giaNgayLeDialog.tblGiaNgayLe, data);
                }
            });
            giaNgayLeDialog.txtGia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    giaNgayLeDialog.lblErr.setText("");
                }
            });
            giaNgayLeDialog.txtGiaNgayLe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    giaNgayLeDialog.lblErr2.setText("Ch???n gi?? t??? b???ng");
                }
            });
            giaNgayLeDialog.btnDatGia.addActionListener(new AbstractAction(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (giaNgayLeDialog.txtGiaNgayLe.getText().equals("")) {
                        giaNgayLeDialog.lblErr2.setText("Ch???n gi?? t??? b???ng");
                    }else {
                        giaNgayLeController.updateTTAllGiaNgayLe(0);
                        giaNgayLeController.updateTTGiaNgayLe(1, idGiaNgayLe);
                        giaNgayLeDialog.lblErr2.setText("?????t gi?? th??nh c??ng");
                        giaNgayLeDialog.lblErr2.setForeground(Color.MAGENTA);
                    }
                }
            });           
        }       
        loadTable(giaNgayLeDialog.tblGiaNgayLe, data);
        giaNgayLeDialog.setVisible(true);
    }//GEN-LAST:event_btnGiaNgayLeActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if(clickTamTinh==0) {
            this.btnTamTinhActionPerformed(evt);
        }else {
            tongTien=tongTien+tienPhuThu;
            TinhTienFrm tinhTienFrm= new TinhTienFrm(null,true,tongTien);
            //N???u kh??ch kh??ng ???????c n??? th?? ko nh???p ???????c
            if(duocNo==false){
                tinhTienFrm.txtTienNo.setEnabled(false);
            }

            tinhTienFrm.txtTongTien.setText(ChuyenDoi.SoString(tongTien));
            tinhTienFrm.txtKhachDua.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    double khachDua = ChuyenDoi.SoDouble(tinhTienFrm.txtKhachDua.getText());
                    tinhTienFrm.txtKhachDua.setText(ChuyenDoi.SoString(khachDua));
                    double traLai = khachDua-tongTien;
                    if(traLai>0){
                        tinhTienFrm.txtTraLai.setText(ChuyenDoi.SoString(traLai));  
                    }else{
                        tinhTienFrm.txtTraLai.setText("0");
                    }
                    
                    tongTien=0.0;
                    tienGio = 0.0;
                    tienDichVu = 0.0;
                    tienPhuThu=0.0;
                    tienNo=0.0;
                    reLoadPhong();
                    setNull();
                    setNullTamTinh();
                    phongHienTai=UNDEFINED_CONDITION;
                    tinhTienFrm.setVisible(false);
                                           
                }});
            

            //Button t??nh ti???n in ho?? ????n
            tinhTienFrm.btnThanhToanIn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        int idPhieuThuePhong = phieuThuePhongController.layIdPhieuThuePhong(phongHienTai);
                        int idHoaDonDichVu=0;
                        HoaDon hd = new HoaDon();
                        if(tienDichVu==0){
                            hd = new HoaDon(0,1,null,idPhieuThuePhong,tienGio,tienDichVu,tongTien,tienPhuThu,tienNo);
                        }else{
                            idHoaDonDichVu = hoaDonController.getIdHoaDonDichVu(phongHienTai);
                            hd = new HoaDon(0,1,idHoaDonDichVu,idPhieuThuePhong,tienGio,tienDichVu,tongTien,tienPhuThu,tienNo);
                        }
                        //C???p nh???t ti???n n??? c???a kh??ch
                        datPhongController.capNhatTienNo(sdtKhach, tienNo,tongTien);
                        hoaDonController.insert(hd);

                        //????ng phi???u thu?? ph??ng
                        phieuThuePhongController.dongPhieuThuePhong(idPhieuThuePhong);
                        //C???p nh???t l???i t??nh tr???ng ph??ng
                        datPhongController.updateTinhTrangPhong("Ph??ng c??n tr???ng", phongHienTai);
                        //????ng ho?? ????n d???ch v??? n???u c??
                        if(tienDichVu!=0) hoaDonController.offHoaDonDichVu(idHoaDonDichVu);
                        //reloadTable d???ch v???
                        clearTable(tblSuDungDichVu);

                        //In ho?? ????n
                        int idHoaDon = hoaDonController.layIdHoaDon(idPhieuThuePhong);

                        if(tienDichVu!=0){
                            XuatHoaDon(idHoaDon,"/View_DatPhong/HoaDonDayDu.jrxml");
                        }else{
                            XuatHoaDon(idHoaDon,"/View_DatPhong/HoaDonKhongDichVu.jrxml");
                        }
                        ThongBao.ThongBaoDon("Thanh to??n th??nh c??ng", "Thanh to??n");
                        tongTien=0.0;
                        tienGio = 0.0;
                        tienDichVu = 0.0;
                        tienPhuThu=0.0;
                        tienNo=0.0;
                        reLoadPhong();
                        setNull();
                        setNullTamTinh();
                        phongHienTai=UNDEFINED_CONDITION;
                        tinhTienFrm.setVisible(false);

                    }});

                //Button t??nh ti???n kh??ng in ho?? ????n
                tinhTienFrm.btnThanhToan.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        int idPhieuThuePhong = phieuThuePhongController.layIdPhieuThuePhong(phongHienTai);
                        int idHoaDonDichVu=0;
                        HoaDon hd = new HoaDon();
                        if(tienDichVu==0){
                            hd = new HoaDon(0,1,null,idPhieuThuePhong,tienGio,tienDichVu,tongTien,tienPhuThu,tienNo);
                        }else{
                            idHoaDonDichVu = hoaDonController.getIdHoaDonDichVu(phongHienTai);
                            hd = new HoaDon(0,1,idHoaDonDichVu,idPhieuThuePhong,tienGio,tienDichVu,tongTien,tienPhuThu,tienNo);
                        }
                        //C???p nh???t ti???n n??? c???a kh??ch
                        datPhongController.capNhatTienNo(sdtKhach, tienNo,tongTien);
                        hoaDonController.insert(hd);

                        //????ng phi???u thu?? ph??ng
                        phieuThuePhongController.dongPhieuThuePhong(idPhieuThuePhong);
                        //C???p nh???t l???i t??nh tr???ng ph??ng
                        datPhongController.updateTinhTrangPhong("Ph??ng c??n tr???ng", phongHienTai);
                        //????ng ho?? ????n d???ch v??? n???u c??
                        if(tienDichVu!=0) hoaDonController.offHoaDonDichVu(idHoaDonDichVu);
                        //reloadTable d???ch v???
                        clearTable(tblSuDungDichVu);
                        ThongBao.ThongBaoDon("Thanh to??n th??nh c??ng", "Thanh to??n");
                        tongTien=0.0;
                        tienGio = 0.0;
                        tienDichVu = 0.0;
                        tienPhuThu=0.0;
                        tienNo=0.0;
                        reLoadPhong();
                        setNull();
                        setNullTamTinh();
                        phongHienTai=UNDEFINED_CONDITION;
                        tinhTienFrm.setVisible(false);

                    }});

            tinhTienFrm.setVisible(true);
            clickTamTinh = 0;
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblSuDungDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuDungDichVuMouseClicked
        int click = tblSuDungDichVu.getSelectedRow();
        spnSoLuong.setValue(tblSuDungDichVu.getValueAt(click, 4));
        soLuongDauTien=(int)tblSuDungDichVu.getValueAt(click, 4);
        btnThemDichVu.setEnabled(true);
    }//GEN-LAST:event_tblSuDungDichVuMouseClicked

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        int click = tblSuDungDichVu.getSelectedRow();
        List<Object[]> data = datPhongController.getIdHoaDonDichVu(phongHienTai);
        Integer soLuong = Integer.parseInt(spnSoLuong.getValue().toString());
        
        //ki???m tra s??? l?????ng
        int idDichVu =(int) tblSuDungDichVu.getValueAt(click, 6);
        int soLuongCon = datPhongController.laySoLuongDichVu(idDichVu);
        
        if(soLuong>soLuongCon){
            ThongBao.ThongBaoDon("S??? l?????ng kh??ng h???p l???", "Th??ng B??o");
        }else{
            if(data.get(0)[1].equals(phongHienTai)) {
                SimpleDateFormat fromUser = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
                SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String reformattedStr;
                try {
                    reformattedStr = myFormat.format(fromUser.parse(tblSuDungDichVu.getValueAt(click, 3).toString()));
                    datPhongController.updateSoLuongSuDungDichVu(soLuong, (int) tblSuDungDichVu.getValueAt(click, 6), reformattedStr+".000"); 
                    //n???u s??? l?????ng m???i > sl c?? th?? tr??? th??m ch??nh l???ch
                    if(soLuong>soLuongDauTien){
                        datPhongController.capNhatSoLuongDichVu(idDichVu, soLuongCon-(soLuong-soLuongDauTien));
                    //n???u s??? l?????ng m???i < sl c?? th?? + th??m v??o sl d???ch v???
                    }else if(soLuong<soLuongDauTien){
                        datPhongController.capNhatSoLuongDichVu(idDichVu, soLuongCon+(soLuongDauTien-soLuong));
                    }
                    //load l???i b???ng danh s??ch d???ch v??? 
                    loadAllTableDichVu();
                } catch (ParseException ex) {
                    Logger.getLogger(DatPhongPnl.class.getName()).log(Level.SEVERE, null, ex);
                }                               
            }   
        }
    
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void rdbDuocNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbDuocNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbDuocNoActionPerformed

    private void txtTimDichVuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimDichVuKeyReleased
        List<Object[]> dichVus = datPhongController.timDichVu(txtTimDichVu.getText());
        loadTable(tblAllDichVu,dichVus);
    }//GEN-LAST:event_txtTimDichVuKeyReleased

    private void btnHuyDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDichVuActionPerformed
        int click = tblSuDungDichVu.getSelectedRow();
        if(click==-1){
            ThongBao.ThongBaoDon("Vui l??ng ch???n d???ch v??? c???n hu??? !", "C???nh b??o");
        }else{
            int choice = ThongBao.LuaChonFix("X??c nh???n hu??? d???ch v????", "");
            if(choice==1){
                
                SimpleDateFormat fromUser = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
                SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String reformattedStr;
                try {
                    reformattedStr = myFormat.format(fromUser.parse(tblSuDungDichVu.getValueAt(click, 3).toString()));
                    int idDichVu =(int) tblSuDungDichVu.getValueAt(click, 6);
                    //hu??? d???ch v???
                    datPhongController.huyDichVu(idDichVu,reformattedStr+".000");
                    //c???p nh???t l???i s??? l?????ng
                    int soLuongCon = datPhongController.laySoLuongDichVu(idDichVu);
                    datPhongController.capNhatSoLuongDichVu(idDichVu, soLuongCon+soLuongDauTien);

                    //load l???i b???ng danh s??ch d???ch v??? 
                    loadAllTableDichVu();
                } catch (ParseException ex) {
                    Logger.getLogger(DatPhongPnl.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
        }
    }//GEN-LAST:event_btnHuyDichVuActionPerformed

    private void txtTienPhuThuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienPhuThuKeyReleased
        tienPhuThu = ChuyenDoi.SoDouble(txtTienPhuThu.getText());
        txtTienPhuThu.setText(ChuyenDoi.SoString(tienPhuThu));
        
        Double tien=tongTien+tienPhuThu;
        txtTongTien.setText(ChuyenDoi.SoString(tien));
                
    }//GEN-LAST:event_txtTienPhuThuKeyReleased

    private void txtSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDTMouseClicked
        txtTenKhach.setText("");
    }//GEN-LAST:event_txtSDTMouseClicked

    public void placeholderDichVu() {
        txtTimDichVu.setText("T??m d???ch v???");
        txtTimDichVu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimDichVu.getText().equals("T??m d???ch v???") || txtTimDichVu.getText().equals(txtTimDichVu.getText())) {
                    txtTimDichVu.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimDichVu.getText().isEmpty()) {
                    txtTimDichVu.setText("T??m d???ch v???");
                }
            }
        });
    }
    
    public void themDichVu(JTable table) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2 ) {
                    click1 = table.getSelectedRow(); 
                    List<Object[]> list = hoaDonController.checkHoaDonPhong(phongHienTai);
                    if(!list.get(0)[0].toString().equals("1")){
                        hoaDonController.taoHoaDonDichVu(phongHienTai);
                    }
                    int idHoaDon = hoaDonController.getIdHoaDonDichVu(phongHienTai);
                    hoaDonController.themChiTietDichVu(idHoaDon,(int) table.getValueAt(click1,0), 1);
                    
                    //C???p nh???t l???i s??? l?????ng
                    int soLuongCon = datPhongController.laySoLuongDichVu((int) table.getValueAt(click1,0));
                    datPhongController.capNhatSoLuongDichVu((int) table.getValueAt(click1,0), soLuongCon-1);
                    
                    //load l???i danh s??ch d???ch v???
                    List<Object[]> data = datPhongController.getAllDichVu();
                    loadTable(tblAllDichVu,data);
                    
                    List<Object[]> data2 = datPhongController.layChiTietDichVu(phongHienTai);
                    loadTableSuDungDV(data2);
                }
            }
        });
    }    
    
    public void loadPanelPhong(List<Object[]> data, List<Object[]> data2, List<Object[]> data3) {
        for(int i=0;i<=data.size()-1;i++){
            String thoiGianMo ="....................";      
            for(int y=0;y<=data2.size()-1;y++){
                if(String.valueOf(data.get(i)[0]).equals(String.valueOf(data2.get(y)[0]))){
                    thoiGianMo=String.valueOf(data2.get(y)[1]);
                }
            }           
            loadPhongBtn(Integer.parseInt(data.get(i)[0].toString()), String.valueOf(data.get(i)[1]), 
            String.valueOf(data.get(i)[2]), Integer.parseInt(data.get(i)[3].toString()),thoiGianMo, data3);
        }
        if(data.size()<5){
            for(int i=0;i<5-data.size();i++){
                PhongRenderNull pnNull= new PhongRenderNull();
                panelPhong.add(pnNull);
                
            }
        }
    }

    public void setThongTinPhong(int idPhong) {
        List<Object[]> data2 = datPhongController.layChiTietDichVu(idPhong);
        loadTableSuDungDV(data2);
        List<Object[]> data = datPhongController.getThongTinPhong(idPhong);
        txtTenKhach.setText(data.get(0)[5].toString());
        //set T??nh tr???ng n???
        if(datPhongController.layTinhTrangNo(data.get(0)[1].toString())){
            rdbDuocNo.setSelected(true);
            rdbDuocNo.setText("C??");
            duocNo=true;
        }else{
            rdbDuocNo.setSelected(false);
            rdbDuocNo.setText("Kh??ng");
            duocNo=false;
        }
        
        txtSDT.setText(data.get(0)[1].toString());
        //set SDT kh??ch h??ng 
        sdtKhach=data.get(0)[1].toString();
        txtThoiGianMo.setText(data.get(0)[3].toString());
    }
    
    public void setNullDatPhongDiaglog() {
        datPhongDialog.txtSDT.setText("");
        datPhongDialog.txtTenKhach.setText("");
        datPhongDialog.cbxDatTruoc.setSelectedIndex(0);
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
            data.forEach(objects -> {
                model.addRow(objects);
            });
        }
    }
    
    public void clearTable(Table table){
        DefaultTableModel model = (DefaultTableModel) table.getModel(); 
        model.setRowCount(0);
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
            data.forEach(objects -> {
                model.addRow(objects);
            });
        }
    }

    public void XuatHoaDon(int idHoaDon,String duongDanFile){
        try {
            Hashtable map = new Hashtable();
            InputStream file = getClass().getResourceAsStream(duongDanFile);
            JasperDesign jasperdesign = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(jasperdesign);
            
            map.put("idHoaDon", idHoaDon);
            
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=DuAn1;", "sa", "123456");
            
            JasperPrint p = JasperFillManager.fillReport(report,  map, connection );
            
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "test.pdf");
            
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
        lblTenPhong.setForeground(new Color(255,92,92));
        btnMoPhong.setVisible(false);
        btnDoiPhong.setVisible(true);
        txtThoiGianMo.setVisible(true);
        txtThoiGianMo.setEditable(false);             
        btnHuyBaoTri.setVisible(false);
        btnBaoTri.setVisible(false);
        rdbGiaNgayLe.setVisible(false);
    }
    
    public void setPhongTrong() {
        rdbGiaNgayLe.setVisible(true);
        lblTenPhong.setForeground(new Color(0,204,204));
        btnMoPhong.setVisible(true);
        btnDoiPhong.setVisible(false);
        txtThoiGianMo.setVisible(false);
        loadTableSuDungDV(null);
        btnBaoTri.setVisible(true);
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
        txtTenKhach.setText("Kh??ch v??ng lai");
    }
    
    public void setPhongBaoTri() {
        btnHuyBaoTri.setVisible(true);
        btnBaoTri.setVisible(false);
        btnMoPhong.setVisible(false);
        rdbGiaNgayLe.setVisible(false);
        lblTenPhong.setForeground(new Color(153,153,153));
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }
    
    public void setPhongDatTruoc() {
        lblTenPhong.setForeground(new Color(255,195,137));
        btnHuyBaoTri.setVisible(false);
        btnBaoTri.setVisible(false);
        btnMoPhong.setVisible(true);
        rdbGiaNgayLe.setVisible(true);
        List<Object[]> data = datPhongController.getPhongDatTruoc(phongHienTai);
        txtTenKhach.setText(data.get(0)[6].toString());
        txtSDT.setText(data.get(0)[1].toString());
        btnTamTinh.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }
    
    public void setCombobox(JComboBox cbx) {
        List<GioDatTruoc> data= datPhongController.getGioDatTruoc();
        cbx.removeAllItems();
        data.forEach(gioDatTruoc -> {
            cbx.addItem(gioDatTruoc);
        });
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
    
    public void setController (HoaDonController hoaDonController) {
        this.hoaDonController = hoaDonController;
    }
    
    public void setController (PhieuDatPhongController phieuDatPhongController) {
        this.phieuDatPhongController = phieuDatPhongController;
    }
    
    public void setController (GiaNgayLeController giaNgayLeController) {
        this.giaNgayLeController = giaNgayLeController;
    }

    public void cssTableDichVu(){
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        //B???ng d???ch v???
        TableColumn col = tblAllDichVu.getColumnModel().getColumn(4);
        col.setCellRenderer(dtcr);
        TableColumn col1 = tblDoUong.getColumnModel().getColumn(4);
        col1.setCellRenderer(dtcr);
        TableColumn col2 = tblBimbim.getColumnModel().getColumn(4);
        col2.setCellRenderer(dtcr);
    }
    
    public void setLayoutRenderPhong(){
//        GridLayout layout = new GridLayout(4,2);
//        layout.setHgap(5);
//        layout.setVgap(5);
//        panelPhong.setLayout(layout);
        panelPhong.revalidate();
        panelPhong.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.RoundPanel body;
    private swing.Button btnBaoTri;
    private swing.Button btnDoiPhong;
    private swing.Button btnGiaNgayLe;
    private swing.Button btnHuyBaoTri;
    private swing.Button btnHuyDichVu;
    private swing.Button btnMoPhong;
    private swing.Button btnTamTinh;
    private swing.Button btnThanhToan;
    private swing.Button btnThemDichVu;
    private swing.Button button4;
    private swing.Button button5;
    private swing.Button button6;
    private swing.Button button7;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private swing.RoundPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jtpDichVuAll;
    private javax.swing.JLabel lblTenPhong;
    private swing.RoundPanel panelP;
    private swing.RoundPanel panelPhong;
    private swing.BtnRadioCus rdbAllPhong;
    private swing.BtnRadioCus rdbBaoTri;
    private swing.BtnRadioCus rdbDuocNo;
    private swing.BtnRadioCus rdbGiaNgayLe;
    private swing.BtnRadioCus rdbPhongDangHoatDong;
    private swing.BtnRadioCus rdbPhongThuong;
    private swing.BtnRadioCus rdbPhongTrong;
    private swing.BtnRadioCus rdbPhongVip;
    private swing.RoundPanel roundPanel2;
    private swing.RoundPanel roundPanel3;
    private swing.RoundPanel roundPanel4;
    private swing.RoundPanel roundPanel5;
    private swing.RoundPanel roundPanel6;
    private javax.swing.JSpinner spnSoLuong;
    private swing.Table tblAllDichVu;
    private swing.Table tblBimbim;
    private swing.Table tblDoAn;
    private swing.Table tblDoKho;
    private swing.Table tblDoUong;
    private swing.Table tblSuDungDichVu;
    private swing.Table tblThuocLa;
    private swing.Table tblTraiCay;
    private swing.TextField txtSDT;
    private swing.TextField txtTenKhach;
    private swing.TextField txtThoiGianMo;
    private swing.TextField txtTienDichVu;
    private swing.TextField txtTienGio;
    private swing.TextField txtTienPhuThu;
    private swing.TextInputTT txtTimDichVu;
    private swing.TextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
