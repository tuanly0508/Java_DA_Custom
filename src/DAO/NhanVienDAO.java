package DAO;

import Help.DBConnection;
import Model.NhanVien;
import java.util.List;

public class NhanVienDAO extends AbsDAO<NhanVien>{
    public List<Object[]> getDataStaff(){
        return getRawValues("select idNhanVien, hoTenNhanVien, CMND, soDienThoai, diaChi, gioiTinh, email, vertifyCode, matKhau, quyenHan, trangThai, ngaySinh, ngayVaoLam from nhanVien where trangThai = 'On'");
    }
    
    public List<Object[]> searchNhanVien(String hoTenNhanVien){
        return getRawValues("select * from nhanVien where hoTenNhanVien like N'%"+hoTenNhanVien+"%'");
    }
    
    public void deleteNhanVienTam(int idNhanVien){
        String query = "update nhanVien set trangThai = 'Off' where idNhanVien = ?";
        DBConnection.executeUpdate(query, idNhanVien);
    }
}
