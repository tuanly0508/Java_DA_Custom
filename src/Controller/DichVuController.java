package Controller;

import DAO.DanhMucDAO;
import DAO.DichVuDAO;
import DAO.DonViTinhDAO;
import GUI_DichVu.DanhmucVaDonViPnl;
import GUI_DichVu.DichVuPnl;
import GUI_DichVu.QlDichVuPnl;
import Model.DanhMuc;
import Model.DichVu;
import Model.DonViTinh;
import java.util.List;

public class DichVuController {
    DichVuDAO dichVuDAO =new DichVuDAO();
    DanhMucDAO danhMucDAO = new DanhMucDAO();
    DonViTinhDAO donViTinhDAO = new DonViTinhDAO();
    DichVuPnl view ;
    QlDichVuPnl qlDichVuView ;
    DanhmucVaDonViPnl danhmucVaDonViPnl;
    
    
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
    
    public DichVuController(DanhmucVaDonViPnl view){
        this.danhmucVaDonViPnl = view;
        view.setController(this);
        loadListDanhMuc();
    }
    
    
    public void loadListDichVu() {     
        List<Object[]> dichVus = dichVuDAO.layDanhSachDichVu();
        qlDichVuView.viewTableDichVu(dichVus);
    }
    
    public void loadListDanhMuc(){
        List<Object[]> dichVus = danhMucDAO.layDanhSachDanhMuc();
        List<Object[]> donViTinhs = donViTinhDAO.layDanhSachDonViTinh();
        danhmucVaDonViPnl.viewTableDanhMuc(dichVus);
        danhmucVaDonViPnl.viewTableDonViTinh(donViTinhs);
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
        dichVuDAO.xoaTamThoiDichVu(idDichVu);
        loadListDichVu();
    }
    
    public void suaDichVu(DichVu dichVu){
        dichVuDAO.edit(dichVu);
        loadListDichVu();
    }
    
    public void themDanhMuc(DanhMuc danhMuc){
        danhMucDAO.insert(danhMuc);
        loadListDanhMuc();
    }
    
    public void xoaDanhMuc(int idDanhMuc){
        danhMucDAO.xoaTamThoiDanhMuc(idDanhMuc);
        loadListDanhMuc();
    }
    
    public void suaDanhMuc(DanhMuc danhMuc){
        danhMucDAO.edit(danhMuc);
        loadListDanhMuc();
    }
    
    public void themDonViTinh(DonViTinh donViTinh){
        donViTinhDAO.insert(donViTinh);
        loadListDanhMuc();
    }
    
    public void xoaDonViTinh(int donViTinh){
        donViTinhDAO.xoaTamThoiDonViTinh(donViTinh);
        loadListDanhMuc();
    }
    
    public void suaDonViTinh(DonViTinh donViTinh){
        donViTinhDAO.edit(donViTinh);
        loadListDanhMuc();
    }

}
