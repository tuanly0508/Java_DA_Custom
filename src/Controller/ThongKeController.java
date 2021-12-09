package Controller;

import DAO.ThongKeDAO;
import View_ThongKe.ThongKePnl;
import View_ThongKe.bieuDoDichVuPnl;
import View_ThongKe.bieuDoPnl;
import View_ThongKe.tableDichVuPnl;
import View_ThongKe.tablePnl;
import java.util.List;

public class ThongKeController {
    ThongKePnl view;
    tablePnl viewPnl;
    tableDichVuPnl tableDichVuPnl;
    bieuDoPnl viewDoPnl;
    bieuDoDichVuPnl bieuDoDichVuPnl;
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
    
    public ThongKeController(tableDichVuPnl view) {
        this.tableDichVuPnl = view;
        tableDichVuCon();
        tableDichVuHotDf();
        view.setController(this);
    }
    
    public ThongKeController(bieuDoDichVuPnl view) {
        this.bieuDoDichVuPnl = view;
        bieuDoDichVuDefault();
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
    
    public void tableDichVuCon() {
        List<Object[]> khoangs = thongKeDAO.tableDichVuCon(); 
        tableDichVuPnl.viewTableThongKe(khoangs);
    }
    
    public List<Object[]> tableDichVuHotSearch(java.sql.Date tuNgay, java.sql.Date denNgay) {
        List<Object[]> khoangs = thongKeDAO.tableDichVuHotSearch(tuNgay, denNgay); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoDichVuHotSearch(java.sql.Date tuNgay, java.sql.Date denNgay) {
        List<Object[]> khoangs = thongKeDAO.bieuDoDichVuHotSearch(tuNgay, denNgay); 
        return khoangs;
    }
    
    public void tableDichVuHotDf() {
        List<Object[]> khoangs = thongKeDAO.tableDichVuHot(); 
        tableDichVuPnl.viewTableHot(khoangs);
    }
    
    public List<Object[]> tableDichVuHotHomNay() {
        List<Object[]> khoangs = thongKeDAO.tableDichVuHot(); 
        return khoangs;
    }
    
    public List<Object[]> tableDichVuHotTuanNay() {
        List<Object[]> khoangs = thongKeDAO.tableDichVuHotTuanNay(); 
        return khoangs;
    }
    
    public List<Object[]> tableDichVuHotThangNay() {
        List<Object[]> khoangs = thongKeDAO.tableDichVuHotThangNay(); 
        return khoangs;
    }
    
    public List<Object[]> tableDichVuHotNamNay() {
        List<Object[]> khoangs = thongKeDAO.tableDichVuHotNamNay(); 
        return khoangs;
    }
    
    public void bieuDoDichVuDefault(){
        List<Object[]> khoangs = thongKeDAO.bieuDoDichVuHot(); 
        bieuDoDichVuPnl.bieuDoDefault(khoangs);
    }
    
    public List<Object[]> bieuDoDichVuHomNay() {
        List<Object[]> khoangs = thongKeDAO.bieuDoDichVuHot(); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoDichVuTuanNay() {
        List<Object[]> khoangs = thongKeDAO.bieuDoDichVuHotTuanNay(); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoDichVuThangNay() {
        List<Object[]> khoangs = thongKeDAO.bieuDoDichVuHotThangNay(); 
        return khoangs;
    }
    
    public List<Object[]> bieuDoDichVuNamNay() {
        List<Object[]> khoangs = thongKeDAO.bieuDoDichVuHotNamNay(); 
        return khoangs;
    }
}
