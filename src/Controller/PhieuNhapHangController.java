package Controller;

import DAO.PhieuNhapHangDAO;
import View_NhapHang.NhapHangPnl;
import java.util.List;

public class PhieuNhapHangController {

    NhapHangPnl view;

    public PhieuNhapHangController(NhapHangPnl view) {
        this.view = view;
        loadList();
        view.setController(this);
    }

    PhieuNhapHangDAO phieuNhapHangDAO = new PhieuNhapHangDAO();    
    
    public void loadList(){
        List<Object[]> phieuNhapHangs = phieuNhapHangDAO.getDataPhieuNhapHang();
        view.viewTablePhieuNhapHang(phieuNhapHangs);      
    } 
    
}
