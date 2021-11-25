package Controller;

import DAO.DichVuDAO;
import GUI_DICHVU.DichVuPnl;

public class DichVuController {
    DichVuDAO dichVuDAO =new DichVuDAO();
    DichVuPnl view ;
    
    public DichVuController(DichVuPnl view) {
        this.view = view;
        view.setController(this);
    }
}
