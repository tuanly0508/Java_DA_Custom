package DAO;

import Help.DBConnection;
import Model.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDonDAO extends AbsDAO<HoaDon>{
    public List<Object[]> checkHoaDonPhong(int idPhong){
        return getRawValues("select count(*) from HoaDonDichVu where idPhong="+idPhong+" and trangThai=1");
    }
    
    public void taoHoaDonDichVu(int idPhong){
        String query = "insert into HoaDonDichVu values (?,?,?,?)";
        Timestamp timeNow = new Timestamp(new Date().getTime());
        DBConnection.executeUpdate(query,idPhong,0,1,timeNow);
    }
    
    public List<Object[]> getIdHoaDonDichVu(int idPhong){
        String  query = "select idHoaDonDichVu from hoaDonDichVu where idPhong ="+idPhong+" and trangthai=1";
        return getRawValues(query);
    }
    
    public void themChiTietDichVu(int idHoaDonDichVu,int idDichVu,int soLan){
        String query2="insert into chiTietDichVuSuDung values (?,?,?,?,(select gia from DichVu where idDichVu=?)*?)";
        String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
        DBConnection.executeUpdate(query2,idDichVu,idHoaDonDichVu,soLan,s,idDichVu,soLan);
    }
    
    public void chuyenHoaDonDichVu(int idPhongMuonDoi, int idPhongCanDoi) {
        String query = "update hoaDonDichVu set idPhong = ? where idPhong = ? and trangThai = 1";
        DBConnection.executeUpdate(query, idPhongMuonDoi, idPhongCanDoi);
    }
    
    public void offHoaDonDichVu(int idHoaDonDichVu){
        String query = "update hoaDonDichVu set trangthai=0 where idHoaDonDichVu=?";
        DBConnection.executeUpdate(query, idHoaDonDichVu);
    }
    
    public int layIdHoaDon(int idPhieuThue){
        String query = "select idHoaDon from HoaDon where idPhieuThuePhong="+idPhieuThue+"";
        ResultSet rs = DBConnection.executeQuery(query);
        int idHoaDon =0;
        try {
            while (rs.next()) {
                idHoaDon=rs.getInt("idHoaDon");
            }
        } catch (SQLException ex) {
        }
        return idHoaDon;
    }
    
    public List<Object[]> getListHoaDonDV(int idPhong){
        String  query = "select idHoaDonDichVu from hoaDonDichVu where idPhong ="+idPhong+" and trangthai=1";
        return getRawValues(query);
    }
    
    public void updateTienDichVu(Double tongTien,int idHoaDonDichVu){
        String query = "update HoaDonDichVu set tongTienDV = ? where idHoaDonDichVu =?";
        DBConnection.executeUpdate(query,tongTien,idHoaDonDichVu);
    }
}
