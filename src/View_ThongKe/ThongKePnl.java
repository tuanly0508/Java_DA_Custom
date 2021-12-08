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
    private bieuDoPnl bieuDoPnl;
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
                    addBieuDo();
                } else {
                    addTable();
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

        jdcDenNgay.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Từ ngày");

        jLabel3.setText("Đến ngày");

        jLabel6.setText("Loại hình");

        cbxLoaiHinh.setEditable(false);
        cbxLoaiHinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Doanh thu", "Dịch vụ" }));

        jLabel1.setText("Bảng");

        jLabel5.setText("Biểu đồ");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxLoaiHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxLoaiHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jdcTuNgay.setBackground(Color.WHITE);
        jdcDenNgay.setBackground(Color.WHITE);

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));

        card1.setForeground(new java.awt.Color(228, 166, 255));

        card2.setForeground(new java.awt.Color(161, 238, 247));

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
        java.sql.Date tuNgay= new java.sql.Date(DateOfBirth1.getTime());
        java.util.Date StartingDate1 = jdcDenNgay.getDate();
        java.sql.Date denNgay = new java.sql.Date(StartingDate1.getTime());
        if (cbxLoaiHinh.getSelectedIndex() == 0) {
            List<Object[]> data = thongKeController.tableDoanhThu(tuNgay,denNgay);
            tablePnl.viewTableThongKe(data);
            setGiaDefault(data);
//            List<Object[]> data2 = thongKeController.bieuDoDoanhThu(tuNgay,denNgay);
//            Double tienPhong1 = 0.0,tienDichVu1=0.0 ,phuThu1=0.0 ,Tong1=0.0;
//            for (int i = 0; i <= data2.size()-1; i++) {                
//                tienPhong1+=ChuyenDoi.SoDouble(data2.get(i)[2].toString());
//                tienDichVu1+=ChuyenDoi.SoDouble(data2.get(i)[3].toString());
//                phuThu1+=ChuyenDoi.SoDouble(data2.get(i)[4].toString());
//                Tong1+=ChuyenDoi.SoDouble(data2.get(i)[5].toString());
//
//                Double tienGio = Double.parseDouble(data2.get(i)[2].toString());
//                Double dichVu = Double.parseDouble(data2.get(i)[3].toString());
//                Double phuThu = Double.parseDouble(data2.get(i)[4].toString()); 
//                
//                setValueSum(tienPhong1, tienDichVu1, phuThu1, Tong1);
//                chart.addData(new ModelChart(data2.get(i)[0].toString()+"/"+data2.get(i)[1].toString(),new double[]{tienGio,dichVu,phuThu}));
//                lineChart1.addData(new ModelChart(data2.get(i)[0].toString()+"/"+data2.get(i)[1].toString(),new double[]{tienGio,dichVu,phuThu}));
//            }
//            chart.start();
//            lineChart1.start();
        }else if (cbxLoaiHinh.getSelectedIndex() == 1) {
//            chart1.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
//            lblDoanhThu.setVisible(false);
//            chart.setVisible(false);
//            chart1.setVisible(true);
//            lblDichVu.setVisible(true);
//            chart1.clear();
//            List<Object[]> dichVus = thongKeController.bieuDoDichVu(tuNgay,denNgay);
//            for (int i = 0; i <= dichVus.size()-1; i++) {
//                Double SoLuong = Double.parseDouble(dichVus.get(i)[1].toString()); 
//                chart1.addData(new ModelChart(dichVus.get(i)[0].toString(),new double[]{SoLuong}));
//            }
//            chart1.start();
        }
    }//GEN-LAST:event_btnThongKeActionPerformed
   
    public void addTable(){
        tablePnl = new tablePnl();
        ThongKeController thongKeController = new ThongKeController(tablePnl);
        ShowPanel(contentPnl, tablePnl);
    }
    
    public void addBieuDo() {
        bieuDoPnl = new bieuDoPnl();
        ThongKeController thongKeController = new ThongKeController(bieuDoPnl);
        ShowPanel(contentPnl, bieuDoPnl);
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
        Double tienPhong = 0.0,tienDichVu=0.0 ,phuThu=0.0 ,Tong=0.0;        
        for(int i=0 ;i<=data.size()-1;i++){
            tienPhong+=ChuyenDoi.SoDouble(data.get(i)[2].toString());
            tienDichVu+=ChuyenDoi.SoDouble(data.get(i)[3].toString());
            phuThu+=ChuyenDoi.SoDouble(data.get(i)[4].toString());
            Tong+=ChuyenDoi.SoDouble(data.get(i)[5].toString());
        }
        setValueSum(tienPhong, tienDichVu, phuThu, Tong);
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
    private javax.swing.JPanel contentPnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
