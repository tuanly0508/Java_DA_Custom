package DAO;

import Help.DBConnection;
import Model.GiaNgayLe;
import java.util.List;

public class GiaNgayLeDAO extends AbsDAO<GiaNgayLe>{
    public List<Object[]> getGiaNgayLe() {
        return getRawValues("select * from giaNgayLe");
    }
    
    public List<Object[]> getGiaNgayLeTrue() {
        return getRawValues("select * from giaNgayLe where tinhTrang = 1");
    }
    
    public void updateTTGiaNgayLe(int tinhTrang, int idGiaNgayLe) {
        String query = "update giaNgayLe set tinhTrang = ? where idGiaNgayLe = ?";
        DBConnection.executeUpdate(query,tinhTrang,idGiaNgayLe);
    }
    
    public void updateTTAllGiaNgayLe(int tinhTrang) {
        String query = "update giaNgayLe set tinhTrang = ? ";
        DBConnection.executeUpdate(query,tinhTrang);
    }
}
