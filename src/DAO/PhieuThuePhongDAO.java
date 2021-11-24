package DAO;

import Help.DBConnection;
import Model.PhieuThuePhong;

public class PhieuThuePhongDAO extends AbsDAO<PhieuThuePhong>{
    public void chuyenPhieuThuePhong(int idPhongMuonDoi, int idPhongCanDoi) {
        String query = "update phieuThuePhong set idPhong = ? where idPhong = ? and tinhTrang = 1";
        DBConnection.executeUpdate(query, idPhongMuonDoi, idPhongCanDoi);
    }
}
