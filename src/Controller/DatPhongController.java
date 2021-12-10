package Controller;

import DAO.DatPhongDAO;
import DAO.DichVuDAO;
import DAO.GioDatTruocDAO;
import DAO.KhachHangDAO;
import DAO.PhieuDatPhongDAO;
import View_DatPhong.DatPhongPnl;
import Model.GioDatTruoc;
import View_Dialog.TimesUp;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DatPhongController {
    DatPhongPnl view;
    DatPhongDAO datPhongDAO = new DatPhongDAO();
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    DichVuDAO dichVuDAO = new DichVuDAO();
    GioDatTruocDAO gioDatTruocDAO = new GioDatTruocDAO();
    PhieuDatPhongDAO phieuDatPhongDAO = new PhieuDatPhongDAO();

    public DatPhongController(DatPhongPnl view) {
        this.view = view;
        loadListPhong();
        LoadShowPopUp();
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
        
    public List<Object[]> getTTPhieuDatPhong(){
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
    
    //Tìm dịch vụ
    public List<Object[]> timDichVu(String tenDichVu){
        List<Object[]> dichVus =dichVuDAO.timDichVu(tenDichVu);
        return dichVus;
    }
    
    //Huỷ chi tiết dịch vụ sử dụng
    public void huyDichVu(int idDichVu,String gioMo){
        dichVuDAO.huyDichVu(idDichVu,gioMo);
    }
    
    
    public void HienThiThoiGian(String gio,String tenKhach,String sdt ,int idPhong) {        
        String tenPhong = datPhongDAO.layTenPhong(idPhong);      
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        int gioDat =Integer.valueOf(gio.substring(0, 2))-1;
        
                        String timess = "" ;
//                        System.out.println("1gio dat la:"+gio.substring(3));
                        if(gio.substring(3).equals("00")){
                            timess=gioDat+"h30";
                        }
                        if(gio.substring(3).equals("30")){
                            timess=Integer.valueOf(gio.substring(0, 2))+"h0";
                        }
//                        System.out.println("gioThong Bao:"+timess);
                        Calendar cal = new GregorianCalendar();
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR_OF_DAY);
                        String time =hour+"h"+minute;
//                        System.out.println(hour+"h"+minute);

                        if(timess.equals(time)){
                            System.out.println(gio.equals(time));
                            TimesUp times = new TimesUp(null, true);
                            times.lblTenPhong.setText("Thông báo đặt trước phòng: "+ tenPhong);
                            times.txtGioDat.setText("Giờ đặt : "+ gio);
                            times.txtSdt.setText("Số điện thoại : "+ sdt);
                            times.txtTenKhach.setText("Tên Khách : "+ tenKhach);
                            
                            times.setVisible(true);
                        }
                        sleep(1000*60);
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e);
                }
            }
        };
        clock.start();
    }
    
    public void LoadShowPopUp() {
        List<Object[]> allPhieuDatPhong = phieuDatPhongDAO.getAllPhieuDatPhong();
        for (int i=0;i<allPhieuDatPhong.size();i++){
            String gio =allPhieuDatPhong.get(i)[5].toString();
            String tenPhong =allPhieuDatPhong.get(i)[2].toString();
            String sdt = allPhieuDatPhong.get(i)[4].toString();
            String tenKhach = allPhieuDatPhong.get(i)[3].toString();
            
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        int gioDat =Integer.valueOf(gio.substring(0, 2))-1;
        
                        String timess = "" ;
//                        System.out.println("1gio dat la:"+gio.substring(3));
                        if(gio.substring(3).equals("00")){
                            timess=gioDat+"h30";
                        }
                        if(gio.substring(3).equals("30")){
                            timess=Integer.valueOf(gio.substring(0, 2))+"h0";
                        }
//                        System.out.println("gioThong Bao:"+timess);
                        Calendar cal = new GregorianCalendar();
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR_OF_DAY);
                        String time =hour+"h"+minute;
//                        System.out.println("giờ đặt: " + timess);
//                        System.out.println("Giờ hiện tại: "+hour+"h"+minute);
                        if(timess.equals(time)){
//                            System.out.println(gio.equals(time));
                            TimesUp times = new TimesUp(null, true);
                            times.lblTenPhong.setText("Thông báo đặt trước : "+ tenPhong);
                            times.txtGioDat.setText("Giờ đặt : "+ gio);
                            times.txtSdt.setText("Số điện thoại : "+ sdt);
                            times.txtTenKhach.setText("Tên Khách : "+ tenKhach);
                            times.setVisible(true);
                        }
                        sleep(1000*60);
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e);
                }
            }
        };
        clock.start();
    }
    }
}
