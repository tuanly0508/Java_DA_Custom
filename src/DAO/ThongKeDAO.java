package DAO;

import java.util.List;

public class ThongKeDAO extends AbsDAO{
    
    public List<Object[]> tableDefaul() {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,#') tienPhong,format(tienDichVu,'#,#') tienDichVu,format(phuThu,'#,#') phuThu,format(tongTien,'#,#') tongTien from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianMo between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE()");
    }
    
    public List<Object[]> bieuDoDefault() {
        return getRawValues("select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu) from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianMo between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE() "
                            + "group by MONTH(thoiGianMo), YEAR(thoiGianMo)");
    }
    
    public List<Object[]> tableDoanhThu(java.sql.Date tuNgay, java.sql.Date denNgay) {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,#') tienPhong,format(tienDichVu,'#,#') tienDichVu,format(phuThu,'#,#') phuThu,format(tongTien,'#,#') tongTien from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianMo between '"+tuNgay+"' and '"+denNgay+"' ");
    }
    
    public List<Object[]> bieuDoDoanhThu(java.sql.Date tuNgay, java.sql.Date denNgay) {
        return getRawValues("select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu), sum(tongTien) from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianMo between '"+tuNgay+"' and '"+denNgay+"' group by MONTH(thoiGianMo), YEAR(thoiGianMo)");
    }
    
    public List<Object[]> bieuDoDichVu(java.sql.Date tuNgay, java.sql.Date denNgay) {
        return getRawValues("select top 5 tenDichVu,sum(soLuong),MONTH(gioSuDung), YEAR(gioSuDung) from chiTietDichVuSuDung a join dichVu b "
                            + "on a.idDichVu = b.idDichVu where gioSuDung between '"+tuNgay+"' and '"+denNgay+"' "
                            + "group by tenDichVu,MONTH(gioSuDung), YEAR(gioSuDung) order by sum(soLuong) desc");
    }
}
