package DAO;

import Help.DBConnection;
import Model.DichVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DichVuDAO extends AbsDAO<DichVu>{
    
    public List<Object[]> getAllDichVu() {
        return getRawValues("select idDichVu,tenDichVu, tenDonVi, format(gia,'#,0') gia,soluongcon "
                          + "from dichVu a join donViTinh b on a.idDonViTinh = b.idDonViTinh "
                          + "where a.tinhTrang=1");
    }
    
    public List<Object[]> layDanhSachDichVu() {
        return getRawValues("select idDichVu,tenDichVu,tenDanhMuc, tenDonVi,soluongcon, format(gia,'#,0') gia from dichVu a \n" +
                            "join donViTinh b on a.idDonViTinh = b.idDonViTinh\n" +
                            "join danhMuc dm on dm.idDanhMuc=a.idDanhMuc where a.tinhTrang=1");
    }
    
    
    
    public List<Object[]> timDichVu(String tenDichVu) {
        return getRawValues("select idDichVu,tenDichVu,tenDanhMuc, tenDonVi,soluongcon, format(gia,'#,0') gia from dichVu a \n" +
                            "join donViTinh b on a.idDonViTinh = b.idDonViTinh\n" +
                            "join danhMuc dm on dm.idDanhMuc=a.idDanhMuc where  tenDichVu like N'%"+tenDichVu+"%'");
    }
    
    public List<Object[]> getDichVuId(int idDanhMuc) {
        return getRawValues("select idDichVu,tenDichVu, tenDonVi, format(gia,'#,0') gia,soluongcon from dichVu a join donViTinh b on a.idDonViTinh = b.idDonViTinh where idDanhMuc = '"+idDanhMuc+"' ");
    }
    
    public List<Object[]> layChiTietDichVu(int idPhong) {
        return getRawValues("select hd.idHoaDonDichVu,dv.tenDichVu,dvt.tenDonVi,format(ctdv.gioSuDung,'HH:mm:ss dd-MM-yyyy') ngaySuDung,"
                + "ctdv.soLuong,format(ctdv.gia*ctdv.soLuong,'#,0')thanhTien, ctdv.idDichVu from HoaDonDichVu hd join chiTietDichVuSuDung ctdv on "
                + "hd.idHoaDonDichVu=ctdv.idHoaDonDichVu join DichVu dv on ctdv.idDichVu=dv.idDichVu join donViTinh dvt on "
                + "dvt.idDonViTinh=dv.idDonViTinh where idphong= '"+idPhong+"' and trangThai=1 order by ngaySuDung");
    }   
    
    public void xoaTamThoiDichVu(int idDichVu){
        String query = "update DichVu set tinhTrang=0 where idDichVu =?";
        DBConnection.executeUpdate(query, idDichVu);
    }
    
    public int laySoLuongDichVuCon(int idDichVu){
        String query = "select soLuongCon from DichVu where idDichVu="+idDichVu+"";
        ResultSet rs = DBConnection.executeQuery(query);
        int slCon =0;
        try {
            while (rs.next()) {
                slCon=rs.getInt("soLuongCon");
            }
        } catch (SQLException ex) {
        }
        return slCon;
    }
    
    public void capNhatSoLuongDichVu(int idDichVu, int soLuong){
        String query ="update dichVu set soluongCon =? where idDichVu =?";
        DBConnection.executeUpdate(query, soLuong,idDichVu);
    }
    
    //Hu??? chi ti???t d???ch v???
    public void huyDichVu(int idDichVu,String gio){
        String query= "delete from ChiTietDichVuSuDung where idDichVu = ? and gioSuDung=?";
        DBConnection.executeUpdate(query, idDichVu,gio);
    }
    
    //l???y id d???ch v???
    public int layIdDichVu(String ten){
        String query = "select idDichvu from DichVu where tenDichVu like ?";
        ResultSet rs = DBConnection.executeQuery(query,ten);
        int slCon =0;
        try {
            while (rs.next()) {
                slCon=rs.getInt("idDichvu");
            }
        } catch (SQLException ex) {
        }
        return slCon;
    }
    
}
