package DAO;

import Help.DBConnection;
import Model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class KhachHangDAO extends AbsDAO{
    
    public void insertKhachHang(String SDT, String tenKhach, Double tienNo, Double tienSuDung, Integer traSau, String ghiChu, Integer tinhTrang){
        String query = "insert into khachHang values (?,?,?,?,?,?,?)";
        DBConnection.executeUpdate(query,SDT, tenKhach,tienNo,tienSuDung,traSau,ghiChu,tinhTrang);
    }
    
    public List<Object[]> getThongTinKH(String SDT) {
        return getRawValues("select SDTKhachHang, tenKhachHang,tienNo,tienSuDung, traSau, ghiChu from khachHang "
                            + "where SDTKhachHang like '"+SDT+"' ");
    }
    
    public List<Object[]> getDataStaff(){
        return getRawValues("select * from khachHang where tinhTrang = 'true'");
    }
    
    public List<Object[]> deleteTam(){
        return getRawValues("Update khachHang set tinhTrang = 'true' where idKhachHang = ?");
    }
    
    public void themKhachHang(KhachHang kh){
        String query ="insert into khachHang values (?,?,?,?,?,?,?)";
        DBConnection.executeUpdate(query, kh.getSDTKhachHang(),kh.getTenKhachHang(),kh.getTienNo(),
                                        kh.getTienSuDung(),kh.getTraSau(),kh.getGhiChu(),kh.getTinhTrang());
    }
    
    public void suaKhachHang(KhachHang kh){
        String query ="update khachHang set tenKhachHang=?,tienNo=?,tienSuDung=?,traSau=?,ghiChu=?,tinhTrang=?\n" +
                        "where SDTKhachHang=?";
        DBConnection.executeUpdate(query,kh.getTenKhachHang(),kh.getTienNo(),kh.getTienSuDung(),kh.getTraSau(),kh.getGhiChu()
                                        ,kh.getTinhTrang(), kh.getSDTKhachHang());
    }
    
    public Boolean layTinhTrangNo(String sdtKhach){
        String query = "select traSau from Khachhang where sdtKhachHang="+sdtKhach+"";
        ResultSet rs = DBConnection.executeQuery(query);
        Boolean duocNo =false;
        try {
            while (rs.next()) {
                duocNo=rs.getBoolean("traSau");
            }
        } catch (SQLException ex) {
        }
        return duocNo;
    }
}
