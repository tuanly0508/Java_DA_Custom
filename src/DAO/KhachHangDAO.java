package DAO;

import Model.KhachHang;
import java.util.List;

public class KhachHangDAO extends AbsDAO<KhachHang>{
    public List<Object[]> getThongTinKH(String SDT) {
        return getRawValues("select idKhachHang, SDTKhachHang, tenKhachHang,tienNo,tienSuDung,loaiKhachHang, traSau, ghiChu from khachHang "
                            + "where SDTKhachHang like '"+SDT+"' ");
    }
}
