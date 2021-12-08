package View_ThongKe;

import Controller.ThongKeController;

public class bieuDoPnl extends javax.swing.JPanel {
    private ThongKeController thongKeController;

    public bieuDoPnl() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel3 = new swing.RoundPanel();

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
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

    //    public void bieuDoDefault(List<Object[]> data) {
//        chart.addLegend("Tiền giờ", new Color(12, 84, 175), new Color(0, 108, 247));
//        chart.addLegend("Dịch vụ", new Color(54, 4, 143), new Color(104, 49, 200));
//        chart.addLegend("Phụ thu", new Color(5, 125, 0), new Color(95, 209, 69));
//        chart.clear();
//        for (int i = 0; i <= data.size()-1; i++) {
//            Double tienGio = Double.parseDouble(data.get(i)[2].toString());
//            Double dichVu = Double.parseDouble(data.get(i)[3].toString());
//            Double phuThu = Double.parseDouble(data.get(i)[4].toString());  
//            chart.addData(new ModelChart(data.get(i)[0].toString()+"/"+data.get(i)[1].toString(),new double[]{tienGio,dichVu,phuThu}));
//        }
//        chart.start();
//    }
    
    public void setController (ThongKeController thongKeController) {
        this.thongKeController = thongKeController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
