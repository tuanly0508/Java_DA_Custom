package Controller;

import DAO.NhanVienDAO;
import View_NhanVien.NhanVienPnl;
import Model.NhanVien;
import java.util.List;

public class NhanVienController {
    NhanVienPnl view; 
    public NhanVienController(NhanVienPnl view) {
        this.view = view;
        loadList();
        view.setController(this);
    }
    
    NhanVienDAO nhanVienDao = new NhanVienDAO();
    
    public void loadList(){
        List<Object[]> nhanViens = nhanVienDao.getDataStaff();
        view.viewTableStaff(nhanViens);      
    }
    
    public void insert(String hoTenNhanVien,String CMND, String soDienThoai, String diaChi, String gioiTinh, String email,String trangThai, java.sql.Date ngaySinh, java.sql.Date ngayVao){
        NhanVien nhanVien = new NhanVien(0,hoTenNhanVien,CMND,soDienThoai,diaChi,gioiTinh,email,"khong","123123","User",trangThai,ngaySinh,ngayVao);
        nhanVienDao.insert(nhanVien);
        loadList();
    }
    
    public NhanVien getByIdNyhanVien (Integer id) {
        return nhanVienDao.getById(id);
    }
    
    public void delete(List<Integer> MaNhanVien) {
        for (Integer integer : MaNhanVien) {
            nhanVienDao.delete(MaNhanVien);
        }        
        loadList();
    }

    public void update(int idNhanVien,String hoTenNhanVien,String CMND, String soDienThoai, String diaChi, String gioiTinh, String email, String trangThai, java.sql.Date ngaySinh, java.sql.Date ngayVao){
        NhanVien nhanVien = new NhanVien(idNhanVien,hoTenNhanVien,CMND,soDienThoai,diaChi,gioiTinh,email,"khong","123123","User",trangThai,ngaySinh,ngayVao);
        nhanVienDao.edit(nhanVien);
        loadList();
    }
}
