package Controller;

import DAO.NhanVienDAO;
import GUI_NhanVien.NhanVienPnl;

public class NhanVienController {
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    NhanVienPnl view;

    public NhanVienController(NhanVienPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    
}
