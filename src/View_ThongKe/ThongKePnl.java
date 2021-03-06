package View_ThongKe;

import Controller.ThongKeController;
import Help.ChuyenDoi;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import swing.EventSwitchSelected;

public class ThongKePnl extends javax.swing.JPanel {
    private ThongKeController thongKeController;
    private tablePnl tablePnl;
    private tableDichVuPnl tableDichVuPnl;
    private bieuDoPnl bieuDoPnl;
    private bieuDoDichVuPnl bieuDoDichVuPnl;
    public static JPanel show ;

    public ThongKePnl() {
        initComponents();
        init();
        addTable();
    }
    
    public void init() {
        switchButton1.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                if (selected) {
                    if(cbxLoaiHinh.getSelectedIndex()==0) {
                        addBieuDo();
                    }else addBieuDoDichVu();
                } else {
                    if (cbxLoaiHinh.getSelectedIndex()==0) {
                        addTable();
                    }else addTableDichVu();                   
                }
            }
        });       

        jdcTuNgay.setDateFormatString("dd-MM-yyyy");
        jdcDenNgay.setDateFormatString("dd-MM-yyyy");   
        
        card2.lbTitle.setText("Dịch vụ");
        card2.lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fee.png")));
        card3.lbTitle.setText("Phụ thu");
        card3.lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money-back-guarantee.png")));
        card4.lbTitle.setText("Tổng tiền");
        card4.lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cash.png")));         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing.RoundPanel();
        roundPanel2 = new swing.RoundPanel();
        btnThongKe = new swing.Button();
        jdcTuNgay = new com.toedter.calendar.JDateChooser();
        jdcDenNgay = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxLoaiHinh = new swing.ComboBoxSuggestion();
        switchButton1 = new swing.SwitchButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxThoiGian = new swing.ComboBoxSuggestion();
        jLabel4 = new javax.swing.JLabel();
        roundPanel5 = new swing.RoundPanel();
        card1 = new View_ThongKe.Card();
        card2 = new View_ThongKe.Card();
        card3 = new View_ThongKe.Card();
        card4 = new View_ThongKe.Card();
        contentPnl = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(218, 232, 232));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnThongKe.setBackground(new java.awt.Color(120, 225, 220));
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jdcTuNgay.setBackground(new java.awt.Color(255, 255, 255));
        jdcTuNgay.setEnabled(false);

        jdcDenNgay.setBackground(new java.awt.Color(255, 255, 255));
        jdcDenNgay.setEnabled(false);

        jLabel2.setText("Từ ngày");

        jLabel3.setText("Đến ngày");

        jLabel6.setText("Loại hình");

        cbxLoaiHinh.setEditable(false);
        cbxLoaiHinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Doanh thu", "Dịch vụ" }));
        cbxLoaiHinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLoaiHinhItemStateChanged(evt);
            }
        });

        jLabel1.setText("Bảng");

        jLabel5.setText("Biểu đồ");

        cbxThoiGian.setEditable(false);
        cbxThoiGian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chọn", "Hôm nay", "Tuần này", "Tháng này", "Năm này" }));
        cbxThoiGian.setSelectedIndex(1);
        cbxThoiGian.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxThoiGianItemStateChanged(evt);
            }
        });

        jLabel4.setText("Thời gian");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbxThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxLoaiHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdcTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jdcDenNgay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxLoaiHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jdcTuNgay.setBackground(Color.WHITE);
        jdcDenNgay.setBackground(Color.WHITE);

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));

        card1.setForeground(new java.awt.Color(212, 116, 255));

        card2.setForeground(new java.awt.Color(63, 232, 255));

        card3.setForeground(new java.awt.Color(130, 227, 176));

        card4.setForeground(new java.awt.Color(247, 215, 86));

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        contentPnl.setBackground(new java.awt.Color(218, 232, 232));
        contentPnl.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
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
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        java.util.Date DateOfBirth1 = jdcTuNgay.getDate();        
        java.util.Date StartingDate1 = jdcDenNgay.getDate();
        
        if (cbxLoaiHinh.getSelectedIndex() == 0) {
            if (cbxThoiGian.getSelectedIndex() == 0) {   
                java.sql.Date tuNgay= new java.sql.Date(DateOfBirth1.getTime());
                java.sql.Date denNgay = new java.sql.Date(StartingDate1.getTime());    
                if(switchButton1.isSelected()) {
                    List<Object[]> data2 = thongKeController.bieuDoDoanhThu(tuNgay, denNgay);
                    fillDataChart(data2);
                    bieuDoPnl.lblTimeThongKe.setText("THEO THỜI GIAN");
                }else {
                    List<Object[]> data = thongKeController.tableDoanhThu(tuNgay, denNgay);               
                    fillDataTable(data);
                }
            }
        }else {
            if (cbxThoiGian.getSelectedIndex() == 0) {   
                java.sql.Date tuNgay= new java.sql.Date(DateOfBirth1.getTime());
                java.sql.Date denNgay = new java.sql.Date(StartingDate1.getTime());    
                if(switchButton1.isSelected()) {
                    List<Object[]> data2 = thongKeController.bieuDoDichVuHotSearch(tuNgay, denNgay);
                    fillDataChart2(data2);
                    bieuDoDichVuPnl.lblTimeDv.setText("THEO THỜI GIAN");
                }else {
                    List<Object[]> data = thongKeController.tableDichVuHotSearch(tuNgay, denNgay);               
                    fillDataTable2(data);
                }
            }
        }      
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void cbxThoiGianItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxThoiGianItemStateChanged
        if (cbxThoiGian.getSelectedIndex() == 0 ) {
            jdcTuNgay.setEnabled(true);
            jdcDenNgay.setEnabled(true);
        }else if (cbxThoiGian.getSelectedIndex() == 1 && cbxLoaiHinh.getSelectedIndex()==0) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoHomNay();
                fillDataChart(data2);
                bieuDoPnl.lblTimeThongKe.setText("HÔM NAY");
            }else {
                List<Object[]> data = thongKeController.tableDefaulToday();                
                fillDataTable(data);
            }
        }else if (cbxThoiGian.getSelectedIndex() == 2 && cbxLoaiHinh.getSelectedIndex()==0) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoTuan();
                fillDataChart(data2);
                bieuDoPnl.lblTimeThongKe.setText("TUẦN NÀY");
            }else {
                List<Object[]> data = thongKeController.tableDefaulTuan();                
                fillDataTable(data);
            }
        }else if (cbxThoiGian.getSelectedIndex() == 3 && cbxLoaiHinh.getSelectedIndex()==0) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoThang();
                fillDataChart(data2);
                bieuDoPnl.lblTimeThongKe.setText("THÁNG NÀY");
            }else {
                List<Object[]> data = thongKeController.tableDefaulThang();
                fillDataTable(data);
            }
        }else if (cbxThoiGian.getSelectedIndex() == 4 && cbxLoaiHinh.getSelectedIndex()==0) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoNam();
                fillDataChart(data2);
                bieuDoPnl.lblTimeThongKe.setText("NĂM NÀY");
            }else {
                List<Object[]> data = thongKeController.tableDefaulNam();
                fillDataTable(data);
            }
        }else if (cbxThoiGian.getSelectedIndex() == 1 && cbxLoaiHinh.getSelectedIndex()==1) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoDichVuHomNay();
                fillDataChart2(data2);
                bieuDoDichVuPnl.lblTimeDv.setText("HÔM NAY");
            }else {
                List<Object[]> data = thongKeController.tableDichVuHotHomNay();                
                fillDataTable2(data);
            } 
        }else if (cbxThoiGian.getSelectedIndex() == 2 && cbxLoaiHinh.getSelectedIndex()==1) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoDichVuTuanNay();
                fillDataChart2(data2);
                bieuDoDichVuPnl.lblTimeDv.setText("TUẦN NÀY");
            }else {
                List<Object[]> data = thongKeController.tableDichVuHotTuanNay();                
                fillDataTable2(data);
            }
        }else if (cbxThoiGian.getSelectedIndex() == 3 && cbxLoaiHinh.getSelectedIndex()==1) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoDichVuThangNay();
                fillDataChart2(data2);
                bieuDoDichVuPnl.lblTimeDv.setText("THÁNG NÀY");
            }else {
                List<Object[]> data = thongKeController.tableDichVuHotThangNay();                
                fillDataTable2(data);
            }
        }else if (cbxThoiGian.getSelectedIndex() == 4 && cbxLoaiHinh.getSelectedIndex()==1) {
            jdcTuNgay.setEnabled(false);
            jdcDenNgay.setEnabled(false);
            if(switchButton1.isSelected()) {
                List<Object[]> data2 = thongKeController.bieuDoDichVuNamNay();
                fillDataChart2(data2);
                bieuDoDichVuPnl.lblTimeDv.setText("NĂM NÀY");
            }else {
                List<Object[]> data = thongKeController.tableDichVuHotNamNay();                
                fillDataTable2(data);
            }
        }
    }//GEN-LAST:event_cbxThoiGianItemStateChanged

    private void cbxLoaiHinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLoaiHinhItemStateChanged
        if(cbxLoaiHinh.getSelectedIndex() == 0) {
            if (switchButton1.isSelected()) {
                cbxThoiGian.setSelectedIndex(1);
                addBieuDo();
            }else {
                cbxThoiGian.setSelectedIndex(1);
                addTable();
            }
        }else {
            if (switchButton1.isSelected()) {
                cbxThoiGian.setSelectedIndex(1);
                addBieuDoDichVu();
            }else {
                cbxThoiGian.setSelectedIndex(1);
                addTableDichVu();
            }
        }
    }//GEN-LAST:event_cbxLoaiHinhItemStateChanged
   
    public void fillDataTable2(List<Object[]> data) {
        if(tableDichVuPnl == null) {            
        }else tableDichVuPnl.viewTableHot(data);
    }
    
    public void fillDataTable(List<Object[]> data) {
        if(tablePnl == null){
        }else {
            tablePnl.viewTableThongKe(data);
            setGiaDefault(data);
        }
    }
    
    public void fillDataChart(List<Object[]> data) {
        if(bieuDoPnl == null){
        }else {
            bieuDoPnl.bieuDoDefault(data);  
            setGiaDefault(data);
        }
    }
    
    public void fillDataChart2(List<Object[]> data) {
        if(bieuDoDichVuPnl == null){
        }else bieuDoDichVuPnl.bieuDoDefault(data);  
    }
    
    public void addTable(){
        tablePnl = new tablePnl();
        ThongKeController thongKeController = new ThongKeController(tablePnl);
        ShowPanel(contentPnl, tablePnl);
    }
    
    public void addTableDichVu(){
        tableDichVuPnl = new tableDichVuPnl();
        ThongKeController thongKeController = new ThongKeController(tableDichVuPnl);
        ShowPanel(contentPnl, tableDichVuPnl);
    }
    
    public void addBieuDo() {
        bieuDoPnl = new bieuDoPnl();
        ThongKeController thongKeController = new ThongKeController(bieuDoPnl);
        ShowPanel(contentPnl, bieuDoPnl);
    }
    
    public void addBieuDoDichVu() {
        bieuDoDichVuPnl = new bieuDoDichVuPnl();
        ThongKeController thongKeController = new ThongKeController(bieuDoDichVuPnl);
        ShowPanel(contentPnl, bieuDoDichVuPnl);
    }
    
    public static void ShowPanel(JPanel PanelChua, JPanel panel) {
        show = panel;
        PanelChua.removeAll();
        PanelChua.add(show);
        PanelChua.validate();
    }
    
    public void setValueSum(Double phong , Double dichVu ,Double phuThu, Double tong){
        card1.lbValues.setText(ChuyenDoi.SoString(phong)+" đ");
        card2.lbValues.setText(ChuyenDoi.SoString(dichVu)+" đ");
        card3.lbValues.setText(ChuyenDoi.SoString(phuThu)+" đ");
        card4.lbValues.setText(ChuyenDoi.SoString(tong)+" đ");
    }       
    
    public void setGiaDefault(List<Object[]> data) {
        if (data == null) {
            
        }else {
            Double tienPhong = 0.0,tienDichVu=0.0 ,phuThu=0.0 ,Tong=0.0;        
            for(int i=0 ;i<=data.size()-1;i++){
                tienPhong+=ChuyenDoi.SoDouble(data.get(i)[2].toString());
                tienDichVu+=ChuyenDoi.SoDouble(data.get(i)[3].toString());
                phuThu+=ChuyenDoi.SoDouble(data.get(i)[4].toString());
                Tong+=ChuyenDoi.SoDouble(data.get(i)[5].toString());
            }
            setValueSum(tienPhong, tienDichVu, phuThu, Tong); 
        }      
    }    
    
    public void setController (ThongKeController thongKeController) {
        this.thongKeController = thongKeController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnThongKe;
    private View_ThongKe.Card card1;
    private View_ThongKe.Card card2;
    private View_ThongKe.Card card3;
    private View_ThongKe.Card card4;
    private swing.ComboBoxSuggestion cbxLoaiHinh;
    private swing.ComboBoxSuggestion cbxThoiGian;
    private javax.swing.JPanel contentPnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JDateChooser jdcDenNgay;
    private com.toedter.calendar.JDateChooser jdcTuNgay;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel2;
    private swing.RoundPanel roundPanel5;
    private swing.SwitchButton switchButton1;
    // End of variables declaration//GEN-END:variables
}
