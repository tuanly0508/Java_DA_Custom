package DAO;

import Help.DBConnection;
import Model.PhieuThuePhong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PhieuThuePhongDAO extends AbsDAO<PhieuThuePhong>{
    public void chuyenPhieuThuePhong(int idPhongMuonDoi, int idPhongCanDoi) {
        String query = "update phieuThuePhong set idPhong = ? where idPhong = ? and tinhTrang = 1";
        DBConnection.executeUpdate(query, idPhongMuonDoi, idPhongCanDoi);
    }
    
    public List<Object[]> getThongTinGiaNgayLe(int idPhong) {
        return getRawValues("select count(*) isGiaNgayLe from phieuThuePhong where idPhong = "+idPhong+" and giaNgayLe = 1 ");
    }
    
    public int layIdPhieuThuePhong(int idPhong){
        String query = "select idPhieuThuePhong from phieuThuePhong where idPhong = "+idPhong+" and thoiGianDong is null";
        ResultSet rs = DBConnection.executeQuery(query);
        int idPhieuThue =0;
        try {
            while (rs.next()) {
                idPhieuThue=rs.getInt("idPhieuThuePhong");
            }
        } catch (SQLException ex) {
        }
        return idPhieuThue;
    }
    
    public void dongPhieuThuePhong(int idPhieuThue,Timestamp timeNow){
        String query = "update phieuThuePhong set thoiGianDong=?,tinhtrang=0 where idPhieuThuePhong =?";
        DBConnection.executeUpdate(query,timeNow,idPhieuThue);
    }
}
