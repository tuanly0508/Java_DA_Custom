package Controller;

import DAO.ThongKeDAO;
import View_ThongKe.ThongKePnl;
import java.util.List;

public class ThongKeController {
    ThongKePnl view;
    ThongKeDAO thongKeDAO = new ThongKeDAO();

    public ThongKeController(ThongKePnl view) {
        this.view = view;
        tableDefault();
        bieuDoDefault();
        view.setController(this);
    }
    
    public void tableDefault() {
        List<Object[]> defaults = thongKeDAO.tableDefaul();
        view.viewTableThongKe(defaults);
        view.setGiaDefault(defaults);
    }
    
    public void bieuDoDefault(){
        List<Object[]> khoangs = thongKeDAO.bieuDoDefault(); 
        view.bieuDoDefault(khoangs);
    }
    
    public List<Object[]> tableDoanhThu(java.sql.Date tuNgay, java.sql.Date denNgay) {
        List<Object[]> khoangs = thongKeDAO.tableDoanhThu(tuNgay, denNgay); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoDoanhThu(java.sql.Date tuNgay, java.sql.Date denNgay) {
        List<Object[]> khoangs = thongKeDAO.bieuDoDoanhThu(tuNgay, denNgay); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoDichVu(java.sql.Date tuNgay, java.sql.Date denNgay) {
        List<Object[]> khoangs = thongKeDAO.bieuDoDichVu(tuNgay, denNgay); 
        return khoangs;
    }
}
