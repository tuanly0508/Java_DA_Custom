package DAO;

import Help.DBConnection;
import Model.NhanVien;
import java.util.List;

public class NhanVienDAO extends AbsDAO<NhanVien>{
    public List<Object[]> getDataStaff(){
        return getRawValues("select idNhanVien, hoTenNhanVien, CMND, soDienThoai, diaChi, gioiTinh, email, vertifyCode, matKhau, quyenHan, trangThai, ngaySinh, ngayVaoLam from nhanVien");
    }
    
    public List<Object[]> searchNhanVien(String hoTenNhanVien){
        return getRawValues("select * from nhanVien where hoTenNhanVien like N'%"+hoTenNhanVien+"%'");
    }
}
