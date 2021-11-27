package Controller;

import DAO.DanhMucDAO;
import DAO.DichVuDAO;
import DAO.DonViTinhDAO;
import GUI_DichVu.DichVuPnl;
import GUI_DichVu.QlDichVuPnl;
import Model.DanhMuc;
import Model.DichVu;
import Model.DonViTinh;
import java.util.List;

public class DichVuController {
    DichVuDAO dichVuDAO =new DichVuDAO();
    DichVuPnl view ;
    QlDichVuPnl qlDichVuView ;
    DanhMucDAO danhMucDAO = new DanhMucDAO();
    DonViTinhDAO donViTinhDAO = new DonViTinhDAO();
    
    
    public DichVuController(DichVuPnl view) {
        this.view = view;
        view.setController(this);
    }
    
    public DichVuController(QlDichVuPnl view){
        this.qlDichVuView = view;
        view.setController(this);
        loadListDichVu();
        view.FillDataComboBoxDanhMuc();
        view.FillDataComboBoxDonViTinh();
    }
    
    public void Test(){
        System.out.println("123");
    }
    
    
    public void loadListDichVu() {     
        List<Object[]> dichVus = dichVuDAO.layDanhSachDichVu();
        qlDichVuView.viewTableDichVu(dichVus);
    }
    
    public List<DanhMuc> getDanhMuc() {
        List<DanhMuc> danhMucs = danhMucDAO.getAll();
        return danhMucs;
    }
    
    public List<DonViTinh> getDonViTinh() {
        List<DonViTinh> donViTinhs = donViTinhDAO.getAll();
        return donViTinhs;
    }
    
    
    public DichVu getByIdDichVu (Integer id) {
        return dichVuDAO.getById(id);
    }
    
    public void themDichVu(DichVu dichVu){
        dichVuDAO.insert(dichVu);
        loadListDichVu();
    }
    
    public void xoaDichVu(int idDichVu){
        dichVuDAO.deleteOne(idDichVu);
        loadListDichVu();
    }
    
    public void suaDichVu(DichVu dichVu){
        dichVuDAO.edit(dichVu);
        loadListDichVu();
    }

}
