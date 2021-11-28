package DAO;

import Model.KhachHang;
import java.util.List;

public class KhachHangDAO extends AbsDAO<KhachHang>{
    public List<Object[]> getThongTinKH(String SDT) {
        return getRawValues("select idKhachHang, SDTKhachHang, tenKhachHang,tienNo,tienSuDung, traSau, ghiChu from khachHang "
                            + "where SDTKhachHang like '"+SDT+"' ");
    }
    
    public List<Object[]> getDataStaff(){
        return getRawValues("select * from khachHang where tinhTrang = 'true'");
    }
    
    public List<Object[]> deleteTam(){
        return getRawValues("Update khachHang set tinhTrang = 'true' where idKhachHang = ?");
    }
    
}
