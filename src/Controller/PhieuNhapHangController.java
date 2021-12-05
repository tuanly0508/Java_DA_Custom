package Controller;

import DAO.ChiTietPhieuNhapDAO;
import DAO.DanhMucDAO;
import DAO.DichVuDAO;
import DAO.DonViTinhDAO;
import DAO.PhieuNhapHangDAO;
import Model.ChiTietPhieuNhap;
import Model.DanhMuc;
import Model.DonViTinh;
import Model.PhieuNhapDichVu;
import View_NhapHang.NhapHangPnl;
import java.util.List;

public class PhieuNhapHangController {

    NhapHangPnl view;
    PhieuNhapHangDAO phieuNhapHangDAO = new PhieuNhapHangDAO() ;
    DichVuDAO dichVuDAO =new DichVuDAO();
    DonViTinhDAO donViTinhDAO = new DonViTinhDAO();
    ChiTietPhieuNhapDAO chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    
    public PhieuNhapHangController(NhapHangPnl view) {
        this.view = view;
        view.setController(this);
        loadList();
        loadDichVu();
        loadDonViTinh();
        
    } 
    
    public void loadList(){
        List<Object[]> phieuNhapHangs = phieuNhapHangDAO.getDataPhieuNhapHang();
        view.viewTablePhieuNhapHang(phieuNhapHangs);      
    }
    
    public void loadChiTietPhieuNhap(String maPhieuNhap){
        List<Object[]> chiTiets = phieuNhapHangDAO.getDataChiTietPN(maPhieuNhap);
        view.viewTableChiTietPhieuNhap(chiTiets);
    }
    
    public void loadDichVu(){
        List<Object[]> dichVus = phieuNhapHangDAO.getDichVu();
        view.viewTableDichVu(dichVus);
    } 
    
    public void timDichVu(String dichVu) {
        List<Object[]> dichVus = dichVuDAO.timDichVu(dichVu);
        view.viewTableDichVu(dichVus);
    }
    
    public void loadDonViTinh() {
        List<DonViTinh> donViTinhs = donViTinhDAO.getAll();
        view.FillDataComboBoxDonViTinh(donViTinhs);
    }
    
    public void insert(PhieuNhapDichVu pn){
        phieuNhapHangDAO.themPhieuNhap(pn);
        loadList();
    }
    
    public void update(PhieuNhapDichVu pn){
        phieuNhapHangDAO.suaPhieuNhap(pn);
        loadList();
    }
    
    public void delete(String pn){
        phieuNhapHangDAO.xoaPhieuNhap(pn);
        loadList();
    }
    
    public List<Object[]> getPhieuNhap(String maPhieuNhap){
        return chiTietPhieuNhapDAO.getChiTietPhieuNhap(maPhieuNhap);
    }
    
    public void themChiTietPN(ChiTietPhieuNhap ctpn){
        chiTietPhieuNhapDAO.themCTPN(ctpn);
    }
    
    public int laySoLuongDV(int idDichVu){
        return dichVuDAO.laySoLuongDichVuCon(idDichVu);
    }
    
    public void capNhatSoLuongDV(int idDichVu, int soLuong){
        dichVuDAO.capNhatSoLuongDichVu(idDichVu, soLuong);
    }
}
