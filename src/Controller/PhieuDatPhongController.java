package Controller;

import DAO.PhieuDatPhongDAO;
import GUI_DatPhong.DatPhongPnl;
import Model.PhieuDatPhong;
import java.util.List;

public class PhieuDatPhongController {
    DatPhongPnl view;
    PhieuDatPhongDAO pdpdao = new PhieuDatPhongDAO();

    public PhieuDatPhongController(DatPhongPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    public void insert(PhieuDatPhong phieuDatPhong) {
        pdpdao.insert(phieuDatPhong);
    }
    
    public void updateTinhTrangPhieuDatPhong(int trangThai,int idPhong) {
        pdpdao.updateTinhTrangPhieuDatPhong(trangThai,idPhong);
    }
    
    public List<Object[]> getPhieuDatPhong(int idPhong){
        List<Object[]> phongs = pdpdao.getPhieuDatPhong(idPhong);
        return phongs;
    }
    
    public PhieuDatPhong getIdGioDatTruoc (Integer id) {
        return pdpdao.getById(id);
    }
}