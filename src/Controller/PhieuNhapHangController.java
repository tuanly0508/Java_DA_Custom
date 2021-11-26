package Controller;

import DAO.PhieuNhapHangDAO;
import GUI_NhapHang.NhapHangPnl;

public class PhieuNhapHangController {
    PhieuNhapHangDAO phieuNhapHangDAO = new PhieuNhapHangDAO();
    NhapHangPnl view;

    public PhieuNhapHangController(NhapHangPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    
}
