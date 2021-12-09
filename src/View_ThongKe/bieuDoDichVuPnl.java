package View_ThongKe;

import Controller.ThongKeController;
import Model.ModelChart;
import java.awt.Color;
import java.util.List;
import swing.ScrollBar;

public class bieuDoDichVuPnl extends javax.swing.JPanel {
    private ThongKeController thongKeController;
    
    public bieuDoDichVuPnl() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        chart.addLegend("Dịch vụ", new Color(12, 84, 175), new Color(0, 108, 247));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        roundPanel3 = new swing.RoundPanel();
        chart = new View_ThongKe.Chart();
        jLabel1 = new javax.swing.JLabel();
        lblTimeDv = new javax.swing.JLabel();

        scroll.setBackground(new java.awt.Color(218, 232, 232));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("10 DỊCH VỤ BÁN CHẠY");

        lblTimeDv.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTimeDv.setText("HÔM NAY");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimeDv)))
                .addGap(37, 37, 37))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimeDv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
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
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void bieuDoDefault(List<Object[]> data) {        
        chart.clear();
        for (int i = 0; i <= data.size()-1; i++) {
            Double tienGio = Double.parseDouble(data.get(i)[1].toString()); 
            chart.addData(new ModelChart(data.get(i)[0].toString(),new double[]{tienGio}));
        }
        chart.start();
    }
    
    public void setController (ThongKeController thongKeController) {
        this.thongKeController = thongKeController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View_ThongKe.Chart chart;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblTimeDv;
    private swing.RoundPanel roundPanel3;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
