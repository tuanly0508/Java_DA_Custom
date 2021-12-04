package DAO;

import Help.DBConnection;
import Model.PhieuNhapHang;
import java.util.List;

public class PhieuNhapHangDAO extends AbsDAO<PhieuNhapHang>{
    public List<Object[]> getDataPhieuNhapHang(){
        return getRawValues("select pn.idPhieuNhap, ncc.tenNhaCungCap, nv.hoTenNhanVien, pn.thoiGianNhap,pn.tongTien,pn.tienNo,pn.ghiChu,pn.trangThai from phieuNhapDichVu as pn \n" +
                            "join nhanVien as nv on pn.idNhanVien = nv.idNhanVien \n" +
                            "join nhaCungCap as ncc on pn.idNhaCungCap = ncc.idNhaCungCap \n" +
                            "where pn.trangThai = 1");
    } 
    
    public void deleteNhaCungCapTam(int idPhieuNhap){
        String query = "update phieuNhapDichVu set tinhTrang = '0' where idPhieuNhap = ?";
        DBConnection.executeUpdate(query, idPhieuNhap);
    }
}
