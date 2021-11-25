package DAO;

import Help.DBConnection;
import Model.PhieuDatPhong;
import java.util.List;

public class PhieuDatPhongDAO extends AbsDAO<PhieuDatPhong>{
    public void updateTinhTrangPhieuDatPhong(int trangThai,int idPhong) {
        String query = "update phieuDatPhong set tinhTrang = ? where idPhong = ?";
        DBConnection.executeUpdate(query,trangThai, idPhong);
    }
    
    public List<Object[]> getPhieuDatPhong(int idPhong) {
        return getRawValues("select idPhieuDatPhong,idPhong,tenKhach,SDTKhachHang,b.tenHinhThuc from phieuDatPhong a join GioDatTruoc b "
                            + "on a.thoiGianDat = b.idGioDatTruoc where idPhong = "+idPhong+" ");
    }
}
