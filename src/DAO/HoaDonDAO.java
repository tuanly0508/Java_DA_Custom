package DAO;

import Help.DBConnection;
import Model.HoaDon;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
        Timestamp timeNow = new Timestamp(new Date().getTime());
        DBConnection.executeUpdate(query2,idDichVu,idHoaDonDichVu,soLan,timeNow,idDichVu,soLan);
    }
    
    public void chuyenHoaDonDichVu(int idPhongMuonDoi, int idPhongCanDoi) {
        String query = "update hoaDonDichVu set idPhong = ? where idPhong = ? and trangThai = 1";
        DBConnection.executeUpdate(query, idPhongMuonDoi, idPhongCanDoi);
    }
}
