package DAO;

import Help.DBConnection;
import Model.PhieuDatPhong;
import java.util.List;

public class PhieuDatPhongDAO extends AbsDAO<PhieuDatPhong>{
    public void updateTinhTrangPhieuDatPhong(int trangThai,int idPhong) {
        String query = "update phieuDatPhong set tinhTrang = ? where idPhong = ?";
        DBConnection.executeUpdate(query,trangThai, idPhong);
    }
    
    public void updateNullPhieuDatPhong(int trangThai,int idPhong, int gioDatTruoc, String ngayDat) {
        String query = "update phieuDatPhong set tinhTrang = ? where idPhong = ? and thoiGianDat = ? and ngayDat='"+ngayDat+"'";
        DBConnection.executeUpdate(query,trangThai, idPhong, gioDatTruoc);
    }
    
    public List<Object[]> getPhieuDatPhong(int idPhong) {
        return getRawValues("select idPhieuDatPhong,idPhong,tenKhach,SDTKhachHang,b.tenHinhThuc,ngayDat from phieuDatPhong a join GioDatTruoc b "
                            + "on a.thoiGianDat = b.idGioDatTruoc where idPhong = "+idPhong+" and tinhTrang = 1 order by ngayDat");
    }
    
    public List<Object[]> getAllPhieuDatPhong() {
        return getRawValues("select idPhieuDatPhong,a.idPhong,tenPhong,tenKhach,SDTKhachHang,b.tenHinhThuc from phieuDatPhong a \n" +
                            "join GioDatTruoc b on a.thoiGianDat = b.idGioDatTruoc \n" +
                            "join phong p on p.idPhong=a.idPhong\n" +
                            "where tinhTrang = 1");
    }
}
