package Controller;

import DAO.DatPhongDAO;
import DAO.DichVuDAO;
import DAO.GioDatTruocDAO;
import DAO.KhachHangDAO;
import View_DatPhong.DatPhongPnl;
import Model.GioDatTruoc;
import java.util.List;

public class DatPhongController {
    DatPhongPnl view;
    DatPhongDAO datPhongDAO = new DatPhongDAO();
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    DichVuDAO dichVuDAO = new DichVuDAO();
    GioDatTruocDAO gioDatTruocDAO = new GioDatTruocDAO();

    public DatPhongController(DatPhongPnl view) {
        this.view = view;
        loadListPhong();
        view.setController(this);
    }
     
    public void loadListPhong() {
        List<Object[]> fullInfoPhong = datPhongDAO.getInfoPhong();
        List<Object[]> infoOpen = datPhongDAO.getTimeOpen();
        List<Object[]> getTinhTrangPDP = datPhongDAO.getTinhTrangPDP();
        view.loadPhong(fullInfoPhong,infoOpen,getTinhTrangPDP);
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
    
    public List<Object[]> getThongTinKH(String SDT) {
        List<Object[]> lists = khachHangDAO.getThongTinKH(SDT);
        return lists;
    }
    
    public void insertKhachHang(String SDT, String tenKhach, Double tienNo, Double tienSuDung, Integer traSau, String ghiChu, Integer tinhTrang){
        khachHangDAO.insertKhachHang(SDT, tenKhach, tienNo, tienSuDung, traSau, ghiChu, tinhTrang);
    }  
        
    public List<Object[]> getTTPhieuDatPhong() {   
        List<Object[]> getTinhTrangPDP = datPhongDAO.getTinhTrangPDP();
        return getTinhTrangPDP;
    }
    
    public List<Object[]> fullInfoLoaiPhong(int idLoaiPhong) {
        List<Object[]> fullInfoPhong = datPhongDAO.getFullInfoLoaiPhong(idLoaiPhong);
        return fullInfoPhong;
    }
    
    public List<Object[]> infoOpen() {
        List<Object[]> infoOpen = datPhongDAO.getTimeOpen();
        return infoOpen;
    }
    
    public List<Object[]> getIdHoaDonDichVu(int idPhong) {
        List<Object[]> phongs = datPhongDAO.getIdHoaDonDichVu(idPhong);
        return phongs;
    }
    
    //Cập nhật sl dịch vụ trong bảng chi tiết dịch vụ sử dụng
    public void updateSoLuongSuDungDichVu(int soLuong ,int idDichVu, String gioMo) {
        datPhongDAO.updateSoLuongSuDungDichVu(soLuong,idDichVu, gioMo);
    }
    
    public Boolean layTinhTrangNo(String sdt){
        return khachHangDAO.layTinhTrangNo(sdt);
    }
    
    public int laySoLuongDichVu(int idDichVu){
        return dichVuDAO.laySoLuongDichVuCon(idDichVu);
    }
    
    //Cập nhật tổng số lượng dịch vụ
    public void capNhatSoLuongDichVu(int idDichVu,int soLuong){
        dichVuDAO.capNhatSoLuongDichVu(idDichVu, soLuong);
    }
}
