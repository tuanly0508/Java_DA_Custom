package DAO;

import Help.DBConnection;
import java.util.List;

public class KhachHangDAO extends AbsDAO{
    
    public void insertKhachHang(String SDT, String tenKhach, Double tienNo, Double tienSuDung, Integer traSau, String ghiChu, Integer tinhTrang){
        String query = "insert into khachHang values (?,?,?,?,?,?,?)";
        DBConnection.executeUpdate(query,SDT, tenKhach,tienNo,tienSuDung,traSau,ghiChu,tinhTrang);
    }
    
    public List<Object[]> getThongTinKH(String SDT) {
        return getRawValues("select SDTKhachHang, tenKhachHang,tienNo,tienSuDung, traSau, ghiChu from khachHang "
                            + "where SDTKhachHang like '"+SDT+"' ");
    }
    
    public List<Object[]> getDataStaff(){
        return getRawValues("select * from khachHang where tinhTrang = 'true'");
    }
    
    public List<Object[]> deleteTam(){
        return getRawValues("Update khachHang set tinhTrang = 'true' where idKhachHang = ?");
    }  
}
