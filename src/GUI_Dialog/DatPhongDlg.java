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
        btnHuy = new GUI.Button();
        lblTenPhongDlg = new javax.swing.JLabel();
        txtSDT = new GUI.TextField();
        txtTenKhach = new GUI.TextField();
        btnMoPhong = new GUI.Button();
        cbxDatTruoc = new javax.swing.JComboBox<>();
        btnDatTruoc = new GUI.Button();
        rdbGiaNgayLe = new GUI.BtnRadioCus();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ĐẶT TRƯỚC - ");

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
            tblDatPhong.getColumnModel().getColumn(2).setMinWidth(100);
            tblDatPhong.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDatPhong.getColumnModel().getColumn(2).setMaxWidth(100);
            tblDatPhong.getColumnModel().getColumn(3).setMinWidth(100);
            tblDatPhong.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblDatPhong.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        btnHuy.setBackground(new java.awt.Color(120, 225, 220));
        btnHuy.setText("Hủy");

        lblTenPhongDlg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhongDlg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        txtSDT.setLabelText("Số điện thoại");

        txtTenKhach.setLabelText("Tên khách hàng");

        btnMoPhong.setBackground(new java.awt.Color(120, 225, 220));
        btnMoPhong.setText("Mở phòng");

        cbxDatTruoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDatTruoc.setOpaque(false);

        btnDatTruoc.setBackground(new java.awt.Color(120, 225, 220));
        btnDatTruoc.setText("Đặt trước");

        rdbGiaNgayLe.setBackground(new java.awt.Color(255, 0, 0));
        rdbGiaNgayLe.setText("Giá ngày lễ");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTenPhongDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDatTruoc, 0, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(btnDatTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMoPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbGiaNgayLe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenPhongDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbGiaNgayLe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDatTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxDatTruoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbxDatTruoc.setBackground(Color.WHITE);

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
    public GUI.Button btnDatTruoc;
    public GUI.Button btnHuy;
    public GUI.Button btnMoPhong;
    public javax.swing.JComboBox<GioDatTruoc> cbxDatTruoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblTenPhongDlg;
    public GUI.BtnRadioCus rdbGiaNgayLe;
    private GUI.RoundPanel roundPanel1;
    public GUI.Table tblDatPhong;
    public GUI.TextField txtSDT;
    public GUI.TextField txtTenKhach;
    // End of variables declaration//GEN-END:variables

}
