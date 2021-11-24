package Controller;

import DAO.KhachHangDAO;
import GUI_DatPhong.DatPhongPnl;
import Model.KhachHang;
import java.util.List;

public class KhachHangController {
    DatPhongPnl view;
    KhachHangDAO khachHangDAO = new KhachHangDAO();

    public KhachHangController(DatPhongPnl view) {
        this.view = view;
        view.setController(this);
    }

    public List<Object[]> getThongTinKH(String SDT) {
        List<Object[]> lists = khachHangDAO.getThongTinKH(SDT);
        return lists;
    }
    
    public void insert(KhachHang kh){
        khachHangDAO.insert(kh);
    }
}
