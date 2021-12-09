package View_ThongKe;

import Controller.ThongKeController;
import Model.ModelChart;
import java.awt.Color;
import java.util.List;
import swing.ScrollBar;

public class bieuDoPnl extends javax.swing.JPanel {
    private ThongKeController thongKeController;

    public bieuDoPnl() {
        initComponents();
        chart.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Dịch vụ", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Phụ thu", new Color(5, 125, 0), new Color(95, 209, 69));
        curveChart.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
        curveChart.addLegend("Dịch vụ", new Color(54, 4, 143), new Color(104, 49, 200));
        curveChart.addLegend("Phụ thu", new Color(5, 125, 0), new Color(95, 209, 69));
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        roundPanel3 = new swing.RoundPanel();
        chart = new View_ThongKe.Chart();
        curveChart = new View_ThongKe.CurveChart();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTimeThongKe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(218, 232, 232));

        scroll.setBackground(new java.awt.Color(218, 232, 232));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DOANH THU THEO NĂM");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DOANH THU");

        lblTimeThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTimeThongKe.setText("HÔM NAY");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(curveChart, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
                    .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 37, Short.MAX_VALUE))
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimeThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(870, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(curveChart, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimeThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        scroll.setViewportView(roundPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void bieuDo2Default(List<Object[]> data) {        
        curveChart.clear();
        for (int i = 0; i <= data.size()-1; i++) {
            Double tienGio = Double.parseDouble(data.get(i)[2].toString());
            Double dichVu = Double.parseDouble(data.get(i)[3].toString());
            Double phuThu = Double.parseDouble(data.get(i)[4].toString());  
            curveChart.addData(new ModelChart(data.get(i)[0].toString()+"/"+data.get(i)[1].toString(),new double[]{tienGio,dichVu,phuThu}));
        }
        curveChart.start();
    }
    
    public void bieuDoDefault(List<Object[]> data) {        
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
    private View_ThongKe.Chart chart;
    private View_ThongKe.CurveChart curveChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel lblTimeThongKe;
    private swing.RoundPanel roundPanel3;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
