package Controller;

import DAO.GiaNgayLeDAO;
import View_DatPhong.DatPhongPnl;
import Model.GiaNgayLe;
import java.util.List;

public class GiaNgayLeController {
    DatPhongPnl view;
    GiaNgayLeDAO giaNgayLeDAO = new GiaNgayLeDAO();

    public GiaNgayLeController(DatPhongPnl view) {
        this.view = view;
        view.setController(this);
    }
        
    public List<Object[]> getGiaNgayLe() {
        List<Object[]> phongs = giaNgayLeDAO.getGiaNgayLe();
        return phongs;
    }
    
    public List<Object[]> getGiaNgayLeTrue() {
        List<Object[]> phongs = giaNgayLeDAO.getGiaNgayLeTrue();
        return phongs;
    }
    
    public void insert(GiaNgayLe giaNgayLe) {
        giaNgayLeDAO.insert(giaNgayLe);
    }
    
    public void updateTTGiaNgayLe(int tinhTrang, int idGiaNgayLe) {
        giaNgayLeDAO.updateTTGiaNgayLe(tinhTrang,idGiaNgayLe);
    }
    
    public void updateTTAllGiaNgayLe(int tinhTrang) {
        giaNgayLeDAO.updateTTAllGiaNgayLe(tinhTrang);
    }
}
