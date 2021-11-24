package DAO;

import Help.DBConnection;
import Model.PhieuDatPhong;

public class PhieuDatPhongDAO extends AbsDAO<PhieuDatPhong>{
    public void updateTinhTrangPhieuDatPhong(int trangThai,int idPhong) {
        String query = "update phieuDatPhong set tinhTrang = ? where idPhong = ?";
        DBConnection.executeUpdate(query,trangThai, idPhong);
    }
}
