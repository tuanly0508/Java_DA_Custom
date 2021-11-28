package DAO;

import java.util.List;

public class ThongKeDAO extends AbsDAO{
    
    public List<Object[]> tableDefaul() {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 8) thoiGianMo,tienPhong,tienDichVu,phuThu,tongTien from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianMo between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE()");
    }
    
    public List<Object[]> bieuDoDefault() {
        return getRawValues("select MONTH(thoiGianDong), YEAR(thoiGianDong) , sum(tienPhong), sum(tienDichVu), sum(phuThu) from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianDong between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE() "
                            + "group by MONTH(thoiGianDong), YEAR(thoiGianDong)");
    }
}
