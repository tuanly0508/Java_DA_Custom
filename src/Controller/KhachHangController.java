package Controller;

import DAO.KhachHangDAO;
import GUI_KhachHang.KhachHangPnl;
import Model.KhachHang;
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
    
    public void insert(KhachHang kh){
        khachHangDAO.themKhachHang(kh);
        loadList();    
    }
    
    public void update(KhachHang kh){
        khachHangDAO.suaKhachHang(kh);
        loadList();
    }
    
    public void delete(String sdtKhach) {
        
        loadList();
    }
    
    
}
