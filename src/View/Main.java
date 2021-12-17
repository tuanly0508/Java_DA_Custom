package View;

import View_Menu.EventMenu;
import Controller.DatPhongController;
import Controller.DichVuController;
import Controller.GiaNgayLeController;
import Controller.HoaDonController;
import Controller.KhachHangController;
import Controller.NhaCungCapController;
import Controller.NhanVienController;
import Controller.PhieuDatPhongController;
import Controller.PhieuNhapHangController;
import Controller.PhieuThuePhongController;
import Controller.ThongKeController;
import Help.ThongBao;
import View_DichVu.DichVuPnl;
import View_DatPhong.DatPhongPnl;
import View_KhachHang.KhachHangPnl;
import View_Login.Login;
import View_NhanVien.NhanVienPnl;
import View_NhapHang.NhapHangPnl;
import View_ThongKe.ThongKePnl;
import java.awt.Component;

public class Main extends javax.swing.JFrame {    
    private DatPhongPnl datPhongPnl;
    private DichVuPnl dichVuPnl;
    private NhanVienPnl nhanVienPnl;
    private NhapHangPnl nhapHangPnl;
    private KhachHangPnl khachHangPnl;
    private ThongKePnl thongKePnl;
    
    public Main() {
        initComponents();    
        init();
        setLocationRelativeTo(null);       
    }
    
    public void init() {
        
        EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    datPhongPnl=new DatPhongPnl();
                    PhieuThuePhongController phieuThuePhongController = new PhieuThuePhongController(datPhongPnl);
                    PhieuDatPhongController phieuDatPhongController = new PhieuDatPhongController(datPhongPnl);
                    GiaNgayLeController giaNgayLeController = new GiaNgayLeController(datPhongPnl);
                    DatPhongController datPhongController = new DatPhongController(datPhongPnl);
                    HoaDonController hoaDonController = new HoaDonController(datPhongPnl);
                    showForm(datPhongPnl);
                }else if (index == 4) {
                    thongKePnl = new ThongKePnl();
                    ThongKeController thongKeController = new ThongKeController(thongKePnl);
                    showForm(thongKePnl);
                }else if (index == 5) {
                    nhanVienPnl = new NhanVienPnl();
                    NhanVienController nhanVienController = new NhanVienController(nhanVienPnl);
                    showForm(nhanVienPnl);
                }else if (index == 3) {
                    dichVuPnl =  new DichVuPnl();
                    DichVuController dichVuController = new DichVuController(dichVuPnl);
                    showForm(dichVuPnl);
                }else if (index == 1) {
                    nhapHangPnl = new NhapHangPnl();
                    PhieuNhapHangController phieuNhapHangController = new PhieuNhapHangController(nhapHangPnl);
                    NhaCungCapController nhaCungCapController = new NhaCungCapController(nhapHangPnl);
                    showForm(nhapHangPnl);
                }else if (index == 2) {
                    khachHangPnl = new KhachHangPnl();
                    KhachHangController khachHangController = new KhachHangController(khachHangPnl);
                    showForm(khachHangPnl);
                }else {
                    int i =ThongBao.LuaChonFix("Bạn có muốn đăng xuất không ?","");
                    if (i == 1) {
                        Login lg = new Login();
                        lg.setVisible(true);
                        dispose();
                    } 
                }
            }
        };
        menu.initMenu(event);
        if(Login.per.equals("ADMIN")){
            ThongBao.ThongBaoDon("Bạn đã đăng nhập thành công với quyền Admin", "Đăng nhập");
            thongKePnl = new ThongKePnl();
            ThongKeController thongKeController = new ThongKeController(thongKePnl);
            showForm(thongKePnl);
        }else{
            ThongBao.ThongBaoDon("Bạn đã đăng nhập thành công với quyền User", "Đăng nhập");
            datPhongPnl=new DatPhongPnl();
            PhieuThuePhongController phieuThuePhongController = new PhieuThuePhongController(datPhongPnl);
            PhieuDatPhongController phieuDatPhongController = new PhieuDatPhongController(datPhongPnl);
            GiaNgayLeController giaNgayLeController = new GiaNgayLeController(datPhongPnl);
            DatPhongController datPhongController = new DatPhongController(datPhongPnl);
            HoaDonController hoaDonController = new HoaDonController(datPhongPnl);
            showForm(datPhongPnl);
        }
    }
    
    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu = new View_Menu.Menu();
        body = new swing.RoundPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Version v0.1");
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1164, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(body, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.RoundPanel body;
    private javax.swing.JPanel jPanel1;
    private View_Menu.Menu menu;
    // End of variables declaration//GEN-END:variables
}
