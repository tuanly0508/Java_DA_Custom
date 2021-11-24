package Controller;

import DAO.PhieuThuePhongDAO;
import GUI_DatPhong.DatPhongPnl;
import Model.PhieuThuePhong;

public class PhieuThuePhongController {
    DatPhongPnl view;
    PhieuThuePhongDAO phieuThuePhongDAO = new PhieuThuePhongDAO();

    public PhieuThuePhongController(DatPhongPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    public void insert(PhieuThuePhong phieuThuePhong) {
        phieuThuePhongDAO.insert(phieuThuePhong);
    }
    
    public void chuyenPhieuThuePhong(int idPhongMuonDoi, int idPhongCanDoi) {
        phieuThuePhongDAO.chuyenPhieuThuePhong(idPhongMuonDoi, idPhongCanDoi);
    }
}
