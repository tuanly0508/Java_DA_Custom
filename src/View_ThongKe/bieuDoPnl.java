package View_ThongKe;

import Controller.ThongKeController;
import Model.ModelChart;
import java.awt.Color;
import java.util.List;

public class bieuDoPnl extends javax.swing.JPanel {
    private ThongKeController thongKeController;

    public bieuDoPnl() {
        initComponents();
        chart.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Dịch vụ", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Phụ thu", new Color(5, 125, 0), new Color(95, 209, 69));
        lineChart.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
        lineChart.addLegend("Dịch vụ", new Color(54, 4, 143), new Color(104, 49, 200));
        lineChart.addLegend("Phụ thu", new Color(5, 125, 0), new Color(95, 209, 69));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel3 = new swing.RoundPanel();
        chart = new View_ThongKe.Chart();
        lineChart = new View_ThongKe.LineChart();

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
            .addComponent(lineChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void bieuDo2Default(List<Object[]> data) {        
        lineChart.clear();
        for (int i = 0; i <= data.size()-1; i++) {
            Double tienGio = Double.parseDouble(data.get(i)[2].toString());
            Double dichVu = Double.parseDouble(data.get(i)[3].toString());
            Double phuThu = Double.parseDouble(data.get(i)[4].toString());  
            lineChart.addData(new ModelChart(data.get(i)[0].toString()+"/"+data.get(i)[1].toString(),new double[]{tienGio,dichVu,phuThu}));
        }
        lineChart.start();
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
    private View_ThongKe.LineChart lineChart;
    private swing.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
