package Controller;

import DAO.PhieuThuePhongDAO;
import GUI_DatPhong.DatPhongPnl;
import Model.PhieuThuePhong;
import java.util.List;

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
    
    public List<Object[]> getThongTinGiaNgayLe(int idPhong){
        List<Object[]> phongs = phieuThuePhongDAO.getThongTinGiaNgayLe(idPhong);
        return phongs;
    }
    
    public int layIdPhieuThuePhong(int idPhong){
        return phieuThuePhongDAO.layIdPhieuThuePhong(idPhong);
    }
}
