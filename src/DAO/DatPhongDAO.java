package DAO;

import Help.DBConnection;
import Model.Phong;
import java.util.List;

public class DatPhongDAO extends AbsDAO<Phong>{
    
    public List<Object[]> getAllLoaiPhong() {
        return getRawValues("select * from Phong a join loaiPhong b on a.idLoaiPhong = b.idLoaiPhong");
    }
    
    public List<Object[]> getLoaiPhongId(int idLoaiPhong) {
        return getRawValues("select a.idPhong,tenPhong,tinhTrangPhong,a.idLoaiPhong,convert(varchar, thoiGianMo, 8) thoiGianMo \n" +
                            "from Phong a join loaiPhong lp on a.idLoaiPhong = lp.idLoaiPhong\n" +
                            "left join phieuThuePhong ptp on a.idPhong=ptp.idPhong \n" +
                            "where lp.idLoaiPhong=1 and ptp.tinhTrang="+idLoaiPhong+" or ptp.tinhTrang is null ");
    }
    
    public List<Object[]> getLoaiPhongTT(String tinhTrang) {
        return getRawValues("select * from Phong a join loaiPhong b on a.idLoaiPhong = b.idLoaiPhong where a.tinhTrangPhong = N'"+tinhTrang+"' ");
    }
    
    public void updateTinhTrangPhong(String trangThai,int idPhong) {
        String query = "update phong set tinhTrangPhong = ? where idPhong = ?";
        DBConnection.executeUpdate(query,trangThai, idPhong);
    }
    
    public List<Object[]> getThongTinPhong(int idPhong) {
        return getRawValues("select idPhieuThuePhong,SDTKhachHang,idPhong, convert(varchar, thoiGianMo, 8) thoiGianMo,thoiGianDong,tenKhachHang from phieuThuePhong "
                + "where idPhong = '"+idPhong+"' and tinhTrang = 1");
    }
    
    
    public List<Object[]> getPhongDatTruoc(int idPhong) {
        return getRawValues("select idPhieuDatPhong,SDTKhachHang,idPhong,thoiGianDat,ghiChu,tinhTrang,tenKhach from phieuDatPhong "
                            + "where idPhong = '"+idPhong+"' and tinhTrang = 1 ");
    }
    
    public List<Object[]> getPhongTrong(int idLoaiPhong) {
        return getRawValues("select idPhong,tenPhong,tenLoaiPhong from phong a join loaiPhong b on a.idLoaiPhong = b.idLoaiPhong "
                            + "where tinhTrangPhong = N'Phòng còn trống' and a.idLoaiPhong = '"+idLoaiPhong+"' ");
    }
    
    public List<Object[]> getGiaPhong(int idLoaiPhong, int idPhong) {
        return getRawValues("select a.idPhong,a.idLoaiPhong,tenPhong,tinhTrangPhong,tenLoaiPhong,soKhachMax,giaGio,thoiGianMo from Phong a "
                            + "join loaiPhong b on a.idLoaiPhong = b.idLoaiPhong join phieuThuePhong c on c.idPhong = a.idPhong "
                            + "where a.idLoaiPhong = '"+idLoaiPhong+"' and a.idPhong = "+idPhong+" ");
    }
    
    public List<Object[]> getInfoPhong() {
        return getRawValues("select idPhong,tenPhong,tinhTrangPhong,idLoaiPhong from phong");
    }
    
    public List<Object[]> getTimeOpen(){
        return getRawValues("select idPhong,convert(varchar, thoiGianMo, 8) thoiGianMo from phieuThuePhong where tinhTrang=1");
    }
    
    public List<Object[]> getTinhTrangPDP(){
        return getRawValues("select distinct b.idPhong,tinhTrang,tenPhong from phieuDatPhong a right join phong b on a.idPhong = b.idPhong");
    }
}