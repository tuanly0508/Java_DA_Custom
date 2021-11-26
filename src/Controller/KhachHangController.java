package Controller;

import DAO.KhachHangDAO;
import GUI_KhachHang.KhachHangPnl;
import Model.KhachHang;
import java.util.List;

public class KhachHangController {
    KhachHangPnl view;
    KhachHangDAO khachHangDAO = new KhachHangDAO();

    public KhachHangController(KhachHangPnl view) {
        this.view = view;
        view.setController(this);
    }
}
