package DAO;

import java.util.List;

public class KhachHangDAO extends AbsDAO{
    public List<Object[]> getThongTinKH(String SDT) {
        return getRawValues("select idKhachHang, SDTKhachHang, tenKhachHang,tienNo,tienSuDung, traSau, ghiChu from khachHang "
                            + "where SDTKhachHang like '"+SDT+"' ");
    }
}
