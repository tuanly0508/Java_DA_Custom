package View_ThongKe;

import Controller.ThongKeController;
import swing.ScrollBar;
import Help.ChuyenDoi;
import Help.XuatExcel;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ThongKePnl extends javax.swing.JPanel {
    private ThongKeController thongKeController;

    public ThongKePnl() {
        initComponents();
        init();
    }
    
    public void init() {
        jScrollPane2.setVerticalScrollBar(new ScrollBar());
        jScrollPane2.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        jdcTuNgay.setDateFormatString("dd-MM-yyyy");
        jdcDenNgay.setDateFormatString("dd-MM-yyyy");
        
        chart1.setVisible(false);
        lblDichVu.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing.RoundPanel();
        roundPanel2 = new swing.RoundPanel();
        jLabel4 = new javax.swing.JLabel();
        btnThongKe = new swing.Button();
        jdcTuNgay = new com.toedter.calendar.JDateChooser();
        jdcDenNgay = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxLoaiHinh = new swing.ComboBoxSuggestion();
        roundPanel3 = new swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongKe = new swing.Table();
        button11 = new swing.Button();
        roundPanel4 = new swing.RoundPanel();
        chart = new View_ThongKe.Chart();
        chart1 = new View_ThongKe.Chart();
        lblDoanhThu = new javax.swing.JLabel();
        lblDichVu = new javax.swing.JLabel();
        roundPanel5 = new swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTienGio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTienPhuThu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel1.setBackground(new java.awt.Color(218, 232, 232));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("THỐNG KÊ & BIỂU ĐỒ");

        btnThongKe.setBackground(new java.awt.Color(120, 225, 220));
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jdcTuNgay.setBackground(new java.awt.Color(255, 255, 255));

        jdcDenNgay.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Từ ngày");

        jLabel3.setText("Đến ngày");

        jLabel6.setText("Loại hình");

        cbxLoaiHinh.setEditable(false);
        cbxLoaiHinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Doanh thu", "Dịch vụ" }));

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxLoaiHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxLoaiHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jdcTuNgay.setBackground(Color.WHITE);
        jdcDenNgay.setBackground(Color.WHITE);

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
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
                "Tên phòng", "Thời gian mở", "Tiền phòng", "Tiền dịch vụ", "Phụ thu", "Tông tiền"
            }
        ));
        jScrollPane2.setViewportView(tblThongKe);

        button11.setBorder(null);
        button11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (1).png"))); // NOI18N
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundPanel4.add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 538, 570));
        roundPanel4.add(chart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 538, 570));

        lblDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThu.setText("BIỂU ĐỒ DOANH THU");
        roundPanel4.add(lblDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 520, 30));

        lblDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDichVu.setText("TOP 5 DỊCH VỤ BÁN CHẠY TRONG THÁNG");
        roundPanel4.add(lblDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 520, 30));

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("TIỀN GIỜ :");

        lblTienGio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienGio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("TIỀN PHỤ THU :");

        lblTienPhuThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienPhuThu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("TIỀN DỊCH VỤ :");

        lblTienDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("TỔNG TIỀN:");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTienGio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblTienDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lblTienPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTienPhuThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(lblTienGio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTienDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        java.util.Date DateOfBirth1 = jdcTuNgay.getDate();
        java.sql.Date tuNgay= new java.sql.Date(DateOfBirth1.getTime());
        java.util.Date StartingDate1 = jdcDenNgay.getDate();
        java.sql.Date denNgay = new java.sql.Date(StartingDate1.getTime());
        if (cbxLoaiHinh.getSelectedIndex() == 0) {
            chart1.setVisible(false);
            lblDichVu.setVisible(false);
            chart.setVisible(true);
            lblDoanhThu.setVisible(true);
            List<Object[]> data = thongKeController.tableDoanhThu(tuNgay,denNgay);
            viewTableThongKe(data);
            List<Object[]> data2 = thongKeController.bieuDoDoanhThu(tuNgay,denNgay);
            Double tienPhong1 = 0.0,tienDichVu1=0.0 ,phuThu1=0.0 ,Tong1=0.0;
            chart.clear();                
            for (int i = 0; i <= data2.size()-1; i++) {                
                tienPhong1+=ChuyenDoi.SoDouble(data2.get(i)[2].toString());
                tienDichVu1+=ChuyenDoi.SoDouble(data2.get(i)[3].toString());
                phuThu1+=ChuyenDoi.SoDouble(data2.get(i)[4].toString());
                Tong1+=ChuyenDoi.SoDouble(data2.get(i)[5].toString());

                Double tienGio = Double.parseDouble(data2.get(i)[2].toString());
                Double dichVu = Double.parseDouble(data2.get(i)[3].toString());
                Double phuThu = Double.parseDouble(data2.get(i)[4].toString()); 
                
                setValueSum(tienPhong1, tienDichVu1, phuThu1, Tong1);
                chart.addData(new ModelChart(data2.get(i)[0].toString()+"/"+data2.get(i)[1].toString(),new double[]{tienGio,dichVu,phuThu}));
            }
            chart.start();
        }else if (cbxLoaiHinh.getSelectedIndex() == 1) {
            chart1.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
            lblDoanhThu.setVisible(false);
            chart.setVisible(false);
            chart1.setVisible(true);
            lblDichVu.setVisible(true);
            chart1.clear();
            List<Object[]> dichVus = thongKeController.bieuDoDichVu(tuNgay,denNgay);
            for (int i = 0; i <= dichVus.size()-1; i++) {
                Double SoLuong = Double.parseDouble(dichVus.get(i)[1].toString()); 
                chart1.addData(new ModelChart(dichVus.get(i)[0].toString(),new double[]{SoLuong}));
            }
            chart1.start();
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        XuatExcel.xuat(tblThongKe);
    }//GEN-LAST:event_button11ActionPerformed
   
    public void setValueSum(Double phong , Double dichVu ,Double phuThu, Double tong){
        lblTienGio.setText(ChuyenDoi.SoString(phong)+" đ");
        lblTienDichVu.setText(ChuyenDoi.SoString(dichVu)+" đ");
        lblTienPhuThu.setText(ChuyenDoi.SoString(phuThu)+" đ");
        lblTongTien.setText(ChuyenDoi.SoString(tong)+" đ");
    }   
    
    public void viewTableThongKe(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();   
        if(data == null) {
            for (int i = tblThongKe.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = tblThongKe.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }            
        }       
    }
    
    public void setGiaDefault(List<Object[]> data) {
        Double tienPhong = 0.0,tienDichVu=0.0 ,phuThu=0.0 ,Tong=0.0;        
        for(int i=0 ;i<=data.size()-1;i++){
            tienPhong+=ChuyenDoi.SoDouble(data.get(i)[2].toString());
            tienDichVu+=ChuyenDoi.SoDouble(data.get(i)[3].toString());
            phuThu+=ChuyenDoi.SoDouble(data.get(i)[4].toString());
            Tong+=ChuyenDoi.SoDouble(data.get(i)[5].toString());
        }
        setValueSum(tienPhong, tienDichVu, phuThu, Tong);
    }
    
    public void bieuDoDefault(List<Object[]> data) {
        chart.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Dịch vụ", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Phụ thu", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.clear();
        for (int i = 0; i <= data.size()-1; i++) {
            Double tienGio = Double.parseDouble(data.get(i)[2].toString());
            Double dichVu = Double.parseDouble(data.get(i)[3].toString());
            Double phuThu = Double.parseDouble(data.get(i)[4].toString());  
            chart.addData(new ModelChart(data.get(i)[0].toString()+"/"+data.get(i)[1].toString(),new double[]{tienGio,dichVu,phuThu}));
        }
        chart.start();
    }
    
    public void setController (ThongKeController thongKeController) {
        this.thongKeController = thongKeController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnThongKe;
    private swing.Button button11;
    private swing.ComboBoxSuggestion cbxLoaiHinh;
    private View_ThongKe.Chart chart;
    private View_ThongKe.Chart chart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcDenNgay;
    private com.toedter.calendar.JDateChooser jdcTuNgay;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienGio;
    private javax.swing.JLabel lblTienPhuThu;
    private javax.swing.JLabel lblTongTien;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel2;
    private swing.RoundPanel roundPanel3;
    private swing.RoundPanel roundPanel4;
    private swing.RoundPanel roundPanel5;
    private swing.Table tblThongKe;
    // End of variables declaration//GEN-END:variables
}
