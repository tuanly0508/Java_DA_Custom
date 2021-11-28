package Controller;

import DAO.KhachHangDAO;
import GUI_KhachHang.KhachHangPnl;
import java.util.List;

public class KhachHangController {
    KhachHangPnl view;

    public KhachHangController(KhachHangPnl view) {
        this.view = view;
        loadList();
        view.setController(this);
    }
    KhachHangDAO khachHangDAO = new KhachHangDAO();

    public void loadList(){
        List<Object[]> khachHangs = khachHangDAO.getDataStaff();
        view.viewTableStaff(khachHangs);      
    }
    
//    public void insert(String SDTKhachHang,String tenKhachHang, Double tienNo, Double tienSuDung, Boolean traSau, String ghiChu){
//        KhachHang khachHang = new KhachHang(0,SDTKhachHang,tenKhachHang,tienNo,tienSuDung,false,ghiChu,true);
//        khachHangDAO.insert(khachHang);
//        loadList();    
//    }
//    
//    public KhachHang getByIdKhachHang (Integer id) {
//        return khachHangDAO.getById(id);
//    }
//    
//    public void update(int idKhachHang,String SDTKhachHang,String tenKhachHang, Double tienNo, Double tienSuDung, Boolean traSau, String ghiChu){
//        KhachHang khachHang = new KhachHang(idKhachHang,SDTKhachHang,tenKhachHang,tienNo,tienSuDung,false,ghiChu,true);
//        khachHangDAO.edit(khachHang);
//        loadList();
//    }
//    
//    public void delete(List<Integer> MaNhanVien) {
//        for (Integer integer : MaNhanVien) {
//            khachHangDAO.delete(MaNhanVien);
//        }        
//        loadList();
//    }
//    
    
}
