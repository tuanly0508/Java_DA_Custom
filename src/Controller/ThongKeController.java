package Controller;

import DAO.ThongKeDAO;
import GUI_ThongKe.ThongKePnl;

public class ThongKeController {
    ThongKePnl view;
    ThongKeDAO thongKeDAO = new ThongKeDAO();

    public ThongKeController(ThongKePnl view) {
        this.view = view;
        view.setController(this);
    }
    
    
}
