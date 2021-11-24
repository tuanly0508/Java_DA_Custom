package DAO;

import Help.DBConnection;
import Model.PhieuThuePhong;
import java.util.List;

public class PhieuThuePhongDAO extends AbsDAO<PhieuThuePhong>{
    public void chuyenPhieuThuePhong(int idPhongMuonDoi, int idPhongCanDoi) {
        String query = "update phieuThuePhong set idPhong = ? where idPhong = ? and tinhTrang = 1";
        DBConnection.executeUpdate(query, idPhongMuonDoi, idPhongCanDoi);
    }
    
    public List<Object[]> getThongTinGiaNgayLe(int idPhong) {
        return getRawValues("select count(*) isGiaNgayLe from phieuThuePhong where idPhong = "+idPhong+" and giaNgayLe = 1 ");
    }
}
