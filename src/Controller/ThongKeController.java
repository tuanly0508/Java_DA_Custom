package Controller;

import DAO.ThongKeDAO;
import GUI_ThongKe.ThongKePnl;
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
    
}
