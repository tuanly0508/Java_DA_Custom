package Controller;

import DAO.ThongKeDAO;
import View_ThongKe.ThongKePnl;
import View_ThongKe.bieuDoPnl;
import View_ThongKe.tablePnl;
import java.util.List;

public class ThongKeController {
    ThongKePnl view;
    tablePnl viewPnl;
    bieuDoPnl viewDoPnl;
    ThongKeDAO thongKeDAO = new ThongKeDAO();

    public ThongKeController(ThongKePnl view) {
        this.view = view;
        giaDefault();
        view.setController(this);
    }
    
    public ThongKeController(tablePnl view) {
        this.viewPnl = view;
        tableDefault();
        view.setController(this);
    }
    
    public ThongKeController(bieuDoPnl view) {
        this.viewDoPnl = view;
        view.setController(this);
    }
    
    public void tableDefault() {
        List<Object[]> khoangs = thongKeDAO.tableDefaul(); 
        viewPnl.viewTableThongKe(khoangs);
    }
    
    public void giaDefault() {
        List<Object[]> defaults = thongKeDAO.tableDefaul();
        view.setGiaDefault(defaults);
    }
    
    public void bieuDoDefault(){
        List<Object[]> khoangs = thongKeDAO.bieuDoDefault(); 
        //view.bieuDoDefault(khoangs);
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
