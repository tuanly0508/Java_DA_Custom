package Controller;

import DAO.HoaDonDAO;
import GUI_DatPhong.DatPhongPnl;
import Model.HoaDon;
import java.util.List;

public class HoaDonController {
    DatPhongPnl view;
    HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public HoaDonController(DatPhongPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    public List<Object[]> checkHoaDonPhong(int idPhong){
        List<Object[]> phongs = hoaDonDAO.checkHoaDonPhong(idPhong);
        return phongs;
    }
    
    public void taoHoaDonDichVu (int idPhong){
        hoaDonDAO.taoHoaDonDichVu(idPhong);
    }
    
    public int getIdHoaDonDichVu(int idPhong){
        List<Object[]> phongs = hoaDonDAO.getIdHoaDonDichVu(idPhong);
        return (int) phongs.get(0)[0];
    }
    
    public void themChiTietDichVu(int idHoaDon,int idDichVu,int soLan){
        hoaDonDAO.themChiTietDichVu(idHoaDon, idDichVu, soLan);
    }
    
    public void chuyenHoaDonDichVu(int idPhongMuonDoi, int idPhongCanDoi) {
        hoaDonDAO.chuyenHoaDonDichVu(idPhongMuonDoi, idPhongCanDoi);
    }
    
    public void insert(HoaDon hoadon){
        hoaDonDAO.insert(hoadon);
    }
    
    public void offHoaDonDichVu(int idHoaDonDichVu){
        hoaDonDAO.offHoaDonDichVu(idHoaDonDichVu);
    }
}
