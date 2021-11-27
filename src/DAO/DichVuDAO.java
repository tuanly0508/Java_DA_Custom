package DAO;

import Help.DBConnection;
import Model.DichVu;
import java.util.List;

public class DichVuDAO extends AbsDAO<DichVu>{
    public List<Object[]> getAllDichVu() {
        return getRawValues("select idDichVu,tenDichVu, tenDonVi, gia,soluongcon from dichVu a join donViTinh b on a.idDonViTinh = b.idDonViTinh where a.tinhTrang=1");
    }
    
    public List<Object[]> layDanhSachDichVu() {
        return getRawValues("select idDichVu,tenDichVu,tenDanhMuc, tenDonVi,soluongcon, format(gia,'#,#') gia from dichVu a \n" +
                            "join donViTinh b on a.idDonViTinh = b.idDonViTinh\n" +
                            "join danhMuc dm on dm.idDanhMuc=a.idDanhMuc where a.tinhTrang=1");
    }
    
    
    public List<Object[]> getDichVuId(int idDanhMuc) {
        return getRawValues("select idDichVu,tenDichVu, tenDonVi, gia from dichVu a join donViTinh b on a.idDonViTinh = b.idDonViTinh where idDanhMuc = '"+idDanhMuc+"' ");
    }
    
    
    public List<Object[]> layChiTietDichVu(int idPhong) {
        return getRawValues("select hd.idHoaDonDichVu,dv.tenDichVu,dvt.tenDonVi,FORMAT(ctdv.gioSuDung ,'dd/MM/yyyy HH:mm:ss') ngaySuDung,"
                + "ctdv.soLuong,format(ctdv.gia,'#,#')thanhTien from HoaDonDichVu hd join chiTietDichVuSuDung ctdv on "
                + "hd.idHoaDonDichVu=ctdv.idHoaDonDichVu join DichVu dv on ctdv.idDichVu=dv.idDichVu join donViTinh dvt on "
                + "dvt.idDonViTinh=dv.idDonViTinh where idphong= '"+idPhong+"' and trangThai=1 order by ngaySuDung");
    }
    
    public void xoaTamThoiDichVu(int idDichVu){
        String query = "update DichVu set tinhTrang=0 where idDichVu =?";
        DBConnection.executeUpdate(query, idDichVu);
    }
}
