package DAO;

import Help.DBConnection;
import Model.DichVu;
import java.util.List;

public class DichVuDAO extends AbsDAO<DichVu>{
    public List<Object[]> getAllDichVu() {
        return getRawValues("select idDichVu,tenDichVu, tenDonVi, gia from dichVu a join donViTinh b on a.idDonViTinh = b.idDonViTinh");
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
}
