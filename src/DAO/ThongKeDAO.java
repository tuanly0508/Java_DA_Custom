package DAO;

import java.util.List;

public class ThongKeDAO extends AbsDAO{
    public List<Object[]> tableDefaulNam() {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,0') tienPhong,format(tienDichVu,'#,0') "
                            + "tienDichVu,format(phuThu,'#,0') phuThu,format(tongTien,'#,0') tongTien,tenKhachHang from phong a join phieuThuePhong b "
                            + "on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong where year(thoiGianMo) = YEAR(GETDATE()) order by MONTH(thoiGianMo),DAY(thoiGianMo)");
    }
    
    public List<Object[]> tableDefaulThang() {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,0') tienPhong,format(tienDichVu,'#,0') tienDichVu,format(phuThu,'#,0') phuThu,format(tongTien,'#,0') tongTien,tenKhachHang from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianMo between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE() order by MONTH(thoiGianMo),DAY(thoiGianMo)");
    }
    
    public List<Object[]> tableDefaulTuan() {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,0') tienPhong,format(tienDichVu,'#,0') "
                            + "tienDichVu,format(phuThu,'#,0') phuThu,format(tongTien,'#,0') tongTien,tenKhachHang from phong a join phieuThuePhong b "
                            + "on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong where thoiGianMo between "
                            + "CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),DAY(GETDATE()) - (DATEPART(DW,GETDATE()) - "
                            + "(DATEPART(DW,convert(date, GETDATE(), 103))-DATEPART(DW,convert(date, GETDATE(), 103)) + 2 ))), 103) "
                            + "and GETDATE() order by MONTH(thoiGianMo),DAY(thoiGianMo)");
    }
    
    public List<Object[]> tableDefaulHomNay() {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,0') tienPhong,"
                            + "format(tienDichVu,'#,0') tienDichVu,format(phuThu,'#,0') phuThu,format(tongTien,'#,0') tongTien,"
                            + "tenKhachHang from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where convert(varchar, thoiGianMo, 103)=convert(varchar, GETDATE(), 103)");
    }
    
    public List<Object[]> bieuDoDefault() {
        return getRawValues("select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu), sum(tongTien) from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where convert(varchar, thoiGianMo, 103)=convert(varchar, GETDATE(), 103) group by MONTH(thoiGianMo), YEAR(thoiGianMo)");
    }
    
    public List<Object[]> bieuDoTuan() {
        return getRawValues("select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu), sum(tongTien) from phong a join "
                            + "phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong where thoiGianMo "
                            + "between CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),DAY(GETDATE()) - (DATEPART(DW,GETDATE()) - "
                            + "(DATEPART(DW,convert(date, GETDATE(), 103))-DATEPART(DW,convert(date, GETDATE(), 103)) + 2 ))), 103) "
                            + "and GETDATE() group by MONTH(thoiGianMo), YEAR(thoiGianMo)");
    }
    
    public List<Object[]> bieuDoThang() {
        return getRawValues("select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu), sum(tongTien) from phong a join phieuThuePhong"
                            + " b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong where thoiGianMo between "
                            + "CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE() group by MONTH(thoiGianMo), YEAR(thoiGianMo)");
    }
    
    public List<Object[]> bieuDoNam() {
        return getRawValues("select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu), sum(tongTien) from phong a join phieuThuePhong"
                            + " b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where year(thoiGianMo) = YEAR(GETDATE()) group by MONTH(thoiGianMo), YEAR(thoiGianMo)");
    }
    
    public List<Object[]> tableDoanhThu(java.sql.Date tuNgay, java.sql.Date denNgay) {
        return getRawValues("select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,0') tienPhong,format(tienDichVu,'#,0') tienDichVu,format(phuThu,'#,0') phuThu,format(tongTien,'#,0') tongTien,tenKhachHang from phong a "
                            + "join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong "
                            + "where thoiGianMo between '"+tuNgay+"' and '"+denNgay+"' order by MONTH(thoiGianMo),DAY(thoiGianMo)");
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
    
    public List<Object[]> tableDichVuCon() {
        return getRawValues("select tenDichVu,tenDanhMuc,tenDonVi,format(gia,'#,0') gia,soLuongCon from dichVu a join danhMuc b on a.idDanhMuc = b.idDanhMuc "
                            + "join donViTinh c on c.idDonViTinh = a.idDonViTinh order by soLuongCon");
    }
    
    public List<Object[]> tableDichVuHotSearch(java.sql.Date tuNgay, java.sql.Date denNgay) {
        return getRawValues("select tenDichVu,sum(soLuong),tenDonVi, format(b.gia*sum(soLuong),'#,0') from chiTietDichVuSuDung a join dichVu b "
                            + "on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where "
                            + "gioSuDung between '"+tuNgay+"' and '"+denNgay+"' group by tenDichVu,b.gia, tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> bieuDoDichVuHotSearch(java.sql.Date tuNgay, java.sql.Date denNgay) {
        return getRawValues("select top 10 tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b "
                            + "on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where "
                            + "gioSuDung between '"+tuNgay+"' and '"+denNgay+"' group by tenDichVu,b.gia, tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> tableDichVuHot() {
        return getRawValues("select tenDichVu,sum(soLuong),tenDonVi, format(b.gia*sum(soLuong),'#,0') from chiTietDichVuSuDung a join dichVu b "
                            + "on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where "
                            + "convert(varchar, gioSuDung, 103)=convert(varchar, GETDATE(), 103) group by tenDichVu,b.gia, tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> tableDichVuHotTuanNay() {
        return getRawValues("select tenDichVu,sum(soLuong),tenDonVi, format(b.gia*sum(soLuong),'#,0') from chiTietDichVuSuDung a join dichVu b on "
                            + "a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where gioSuDung between "
                            + "CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),DAY(GETDATE()) - (DATEPART(DW,GETDATE()) - "
                            + "(DATEPART(DW,convert(date, GETDATE(), 103))-DATEPART(DW,convert(date, GETDATE(), 103)) + 2 ))), 103) and "
                            + "GETDATE() group by tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> tableDichVuHotThangNay() {
        return getRawValues("select tenDichVu,sum(soLuong),tenDonVi, format(b.gia*sum(soLuong),'#,0') from chiTietDichVuSuDung a join dichVu b on "
                            + "a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where gioSuDung between "
                            + "CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE() group by "
                            + "tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> tableDichVuHotNamNay() {
        return getRawValues("select tenDichVu,sum(soLuong),tenDonVi,format(b.gia*sum(soLuong),'#,0') from chiTietDichVuSuDung a join dichVu b on "
                            + "a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where year(gioSuDung) = YEAR(GETDATE()) "
                            + "group by tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> bieuDoDichVuHot() {
        return getRawValues("select top 10 tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b "
                            + "on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where "
                            + "convert(varchar, gioSuDung, 103)=convert(varchar, GETDATE(), 103) group by tenDichVu,b.gia, tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> bieuDoDichVuHotTuanNay() {
        return getRawValues("select top 10 tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b on "
                            + "a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where gioSuDung between "
                            + "CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),DAY(GETDATE()) - (DATEPART(DW,GETDATE()) - "
                            + "(DATEPART(DW,convert(date, GETDATE(), 103))-DATEPART(DW,convert(date, GETDATE(), 103)) + 2 ))), 103) and "
                            + "GETDATE() group by tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> bieuDoDichVuHotThangNay() {
        return getRawValues("select top 10 tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b on "
                            + "a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where gioSuDung between "
                            + "CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE() group by "
                            + "tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc");
    }
    
    public List<Object[]> bieuDoDichVuHotNamNay() {
        return getRawValues("select top 10 tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b on "
                            + "a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where year(gioSuDung) = YEAR(GETDATE()) "
                            + "group by tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc");
    }
}
