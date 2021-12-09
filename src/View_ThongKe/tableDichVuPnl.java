package View_ThongKe;

import Controller.ThongKeController;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import swing.ScrollBar;

public class tableDichVuPnl extends javax.swing.JPanel {
    private ThongKeController thongKeController;
    
    public tableDichVuPnl() {
        initComponents();
        init();
    }
    
    public void init() {
        cssTable(jScrollPane2);
        cssTable(jScrollPane3);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel3 = new swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVuCon = new swing.Table();
        button11 = new swing.Button();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDichVuHot = new swing.Table();
        jLabel2 = new javax.swing.JLabel();

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblDichVuCon.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "Tên dịch vụ", "Tên danh mục", "Tên đơn vị", "Giá", "SL còn"
            }
        ));
        jScrollPane2.setViewportView(tblDichVuCon);

        button11.setBorder(null);
        button11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SỐ LƯỢNG DỊCH VỤ CÒN");

        tblDichVuHot.setModel(new javax.swing.table.DefaultTableModel(
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
                "Tên dịch vụ", "Số lượng", "Tên đơn vị", "Thành tiền"
            }
        ));
        jScrollPane3.setViewportView(tblDichVuHot);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DỊCH VỤ BÁN CHẠY");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void cssTable(JScrollPane jScrollPane) {
        jScrollPane.setVerticalScrollBar(new ScrollBar());
        jScrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
    
    public void viewTableThongKe(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDichVuCon.getModel();   
        if(data == null) {
            for (int i = tblDichVuCon.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = tblDichVuCon.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }            
        }       
    }
    
    public void viewTableHot(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDichVuHot.getModel();   
        if(data == null) {
            for (int i = tblDichVuHot.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = tblDichVuHot.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }            
        }       
    }
    
    public void setController (ThongKeController thongKeController) {
        this.thongKeController = thongKeController;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private swing.RoundPanel roundPanel3;
    private swing.Table tblDichVuCon;
    private swing.Table tblDichVuHot;
    // End of variables declaration//GEN-END:variables
}
