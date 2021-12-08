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
    
    public boolean checkEmailExist(String email){
        List<Object[]> data=getRawValues("select count(*) from NhanVien where email = ?", email);
        Integer count =(Integer) data.get(0)[0];
        return count >0;
    }
    
    public boolean checkPhoneExist(String phone){
        List<Object[]> data=getRawValues("Select count(*) from NhanVien where soDienThoai=?", phone);
        Integer count =(Integer) data.get(0)[0];
        return count >0;
    }
    
    public boolean checkCMNDExist(String CMND){
        List<Object[]> data=getRawValues("Select count(*) from NhanVien where CMND=?", CMND);
        Integer count =(Integer) data.get(0)[0];
        return count >0;
    }
    
    
}
