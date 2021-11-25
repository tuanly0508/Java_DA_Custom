package Controller;

import DAO.DatPhongDAO;
import DAO.DichVuDAO;
import DAO.GioDatTruocDAO;
import GUI_DatPhong.DatPhongPnl;
import Model.GioDatTruoc;
import Model.Phong;
import java.util.List;

public class DatPhongController {
    DatPhongPnl view;
    DatPhongDAO datPhongDAO = new DatPhongDAO();
    DichVuDAO dichVuDAO = new DichVuDAO();
    GioDatTruocDAO gioDatTruocDAO = new GioDatTruocDAO();

    public DatPhongController(DatPhongPnl view) {
        this.view = view;
        loadListPhong();
        view.setController(this);
    }
     
    public void loadListPhong() {
//        List<Phong> phongs = datPhongDAO.getAll();
        List<Object[]> fullInfoPhong = datPhongDAO.getInfoPhong();
        view.loadPhong(fullInfoPhong);
    }    
    
    public List<Object[]> getAllDichVu(){
        List<Object[]> phongs = dichVuDAO.getAllDichVu();
        return phongs;
    }
    
    public List<Object[]> getDichVuId(int idDanhMuc){
        List<Object[]> phongs = dichVuDAO.getDichVuId(idDanhMuc);
        return phongs;
    }
    
    public List<Object[]> getAllLoaiPhong() {
        List<Object[]> phongs = datPhongDAO.getAllLoaiPhong();
        return phongs; 
    }
    
    public List<Object[]> getLoaiPhongId(int idLoaiPhong){
        List<Object[]> phongs = datPhongDAO.getLoaiPhongId(idLoaiPhong);
        return phongs;
    }
    
    public List<Object[]> getLoaiPhongTT(String tinhTrang){
        List<Object[]> phongs = datPhongDAO.getLoaiPhongTT(tinhTrang);
        return phongs;
    }
    
    public void updateTinhTrangPhong(String trangThai,int idPhong) {
        datPhongDAO.updateTinhTrangPhong(trangThai,idPhong);
    }
    
    public List<Object[]> getThongTinPhong(int idPhong){
        List<Object[]> phongs = datPhongDAO.getThongTinPhong(idPhong);
        return phongs;
    }
    
    public List<Object[]> layChiTietDichVu(int idPhong) {
        List<Object[]> phongs = dichVuDAO.layChiTietDichVu(idPhong);
        return phongs; 
    }
    
    public List<GioDatTruoc> getGioDatTruoc() {
        List<GioDatTruoc> phongs = gioDatTruocDAO.getAll();
        return phongs;
    }
    
    public List<Object[]> getPhongDatTruoc(int idPhong){
        List<Object[]> phongs = datPhongDAO.getPhongDatTruoc(idPhong);
        return phongs;
    }
    
    public List<Object[]> getPhongTrong(int idLoaiPhong){
        return datPhongDAO.getPhongTrong(idLoaiPhong);
    }
    
    public List<Object[]> getGiaPhong(int idLoaiPhong, int idPhong){
        return datPhongDAO.getGiaPhong(idLoaiPhong, idPhong);
    }
}
