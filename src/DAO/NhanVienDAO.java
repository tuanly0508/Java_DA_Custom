package DAO;

import Help.DBConnection;
import Model.NhanVien;
import java.util.List;

public class NhanVienDAO extends AbsDAO<NhanVien>{
    public List<Object[]> timEmail(String email) {
        return getRawValues("select email from NhanVien where email = '"+email+"' ");
    }
    
    public void updateCode(String email,String code){
        String query = "update NhanVien set vertifyCode=? where email =?";
        DBConnection.executeUpdate(query,code,email);
    }
    
    public List<Object[]> getCode(String email){
        return getRawValues("select vertifyCode from NhanVien where email = '"+email+"'");
    }
    
    public void updatePass(String email,String pass){
        String query = "update Nhanvien set matKhau=? where email =?";
        DBConnection.executeUpdate(query, pass,email);
    }
}
