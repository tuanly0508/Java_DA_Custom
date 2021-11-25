package DAO;

import Help.DBConnection;
import Model.PhieuThuePhong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
        String query = "select idPhieuThuePhong from phieuThuePhong where idPhong = "+idPhong+" and thoigiandong is null";
        ResultSet rs = DBConnection.executeQuery(query);
        int idPhieuThue =0;
        try {
            idPhieuThue=rs.getInt("idPhieuThuePhong");
            System.out.println(idPhieuThue);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(),ex.getMessage());
        }
        return idPhieuThue;
    }
}
