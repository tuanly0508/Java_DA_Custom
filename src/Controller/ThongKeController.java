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
        tableDefaulHomNay();
        tableDefaulThang();
        view.setController(this);
    }
    
    public ThongKeController(bieuDoPnl view) {
        this.viewDoPnl = view;
        bieuDoDefault();
        bieuDoDefaultNam();
        view.setController(this);
    }
    
    public void tableDefaulHomNay() {
        List<Object[]> khoangs = thongKeDAO.tableDefaulHomNay(); 
        viewPnl.viewTableThongKe(khoangs);
    }   
    
    public List<Object[]> tableDefaulToday() {
        List<Object[]> khoangs = thongKeDAO.tableDefaulHomNay(); 
        return khoangs;
    } 
    
    public List<Object[]> tableDefaulTuan() {
        List<Object[]> khoangs = thongKeDAO.tableDefaulTuan(); 
        return khoangs;
    }
    
    public List<Object[]> tableDefaulThang() {
        List<Object[]> khoangs = thongKeDAO.tableDefaulThang(); 
        return khoangs;
    }
    
    public List<Object[]> tableDefaulNam() {
        List<Object[]> khoangs = thongKeDAO.tableDefaulNam(); 
        return khoangs;
    }
    
    public void giaDefault() {
        List<Object[]> defaults = thongKeDAO.tableDefaulHomNay();
        view.setGiaDefault(defaults);
    }
    
    public void bieuDoDefault(){
        List<Object[]> khoangs = thongKeDAO.bieuDoDefault(); 
        viewDoPnl.bieuDoDefault(khoangs);
    }
    
    public void bieuDoDefaultNam(){
        List<Object[]> khoangs = thongKeDAO.bieuDoNam(); 
        viewDoPnl.bieuDo2Default(khoangs);
    }
    
    public List<Object[]> bieuDoHomNay() {
        List<Object[]> khoangs = thongKeDAO.bieuDoDefault(); 
        return khoangs;
    } 
    
    public List<Object[]> bieuDoTuan() {
        List<Object[]> khoangs = thongKeDAO.bieuDoTuan(); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoThang() {
        List<Object[]> khoangs = thongKeDAO.bieuDoThang(); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoNam() {
        List<Object[]> khoangs = thongKeDAO.bieuDoNam(); 
        return khoangs;
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
