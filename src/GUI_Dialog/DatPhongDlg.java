package GUI_Dialog;

import GUI.ScrollBar;
import Model.GioDatTruoc;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DatPhongDlg extends javax.swing.JDialog {

    public DatPhongDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JPanel p = new JPanel();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);       
        jScrollPane1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new GUI.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatPhong = new GUI.Table();
        button1 = new GUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHÁCH ĐẶT TRƯỚC");

        tblDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idPhieu", "idPhong", "Họ và tên", "Số điện thoại", "Thời gian đặt"
            }
        ));
        jScrollPane1.setViewportView(tblDatPhong);
        if (tblDatPhong.getColumnModel().getColumnCount() > 0) {
            tblDatPhong.getColumnModel().getColumn(0).setMinWidth(0);
            tblDatPhong.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDatPhong.getColumnModel().getColumn(0).setMaxWidth(0);
            tblDatPhong.getColumnModel().getColumn(1).setMinWidth(0);
            tblDatPhong.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblDatPhong.getColumnModel().getColumn(1).setMaxWidth(0);
            tblDatPhong.getColumnModel().getColumn(2).setMinWidth(90);
            tblDatPhong.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblDatPhong.getColumnModel().getColumn(2).setMaxWidth(90);
            tblDatPhong.getColumnModel().getColumn(3).setMinWidth(90);
            tblDatPhong.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblDatPhong.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        button1.setBackground(new java.awt.Color(120, 225, 220));
        button1.setText("Hủy");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private GUI.RoundPanel roundPanel1;
    public GUI.Table tblDatPhong;
    // End of variables declaration//GEN-END:variables

}
