use DuAn1
go

select tenPhong,convert(varchar, thoiGianMo, 8) thoiGianMo,tienPhong,tienDichVu,phuThu,tongTien from phong a 
join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong
where thoiGianMo between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE()

select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu) from phong a 
join phieuThuePhong b on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong
where thoiGianMo between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE()
group by MONTH(thoiGianMo), YEAR(thoiGianMo)

select top 3 tenDichVu,sum(soLuong),MONTH(gioSuDung), YEAR(gioSuDung) from chiTietDichVuSuDung a join dichVu b on a.idDichVu = b.idDichVu where gioSuDung between '2021-11-01' and '2021-11-29' group by tenDichVu,MONTH(gioSuDung), YEAR(gioSuDung) order by sum(soLuong) desc

select top 3 MONTH(gioSuDung) thang, YEAR(gioSuDung) nam,tenDichVu,sum(soLuong) sl from chiTietDichVuSuDung a join dichVu b on a.idDichVu = b.idDichVu where gioSuDung between '2021-11-01' and '2021-11-29' group by tenDichVu,MONTH(gioSuDung), YEAR(gioSuDung) order by sum(soLuong) desc

--table h�m nay
select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,#') tienPhong,format(tienDichVu,'#,#') tienDichVu,
format(phuThu,'#,#') phuThu,format(tongTien,'#,#') tongTien from phong a join phieuThuePhong b on a.idPhong = b.idPhong 
join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong 
where convert(varchar, thoiGianMo, 103)=convert(varchar, GETDATE(), 103)

select convert(varchar, GETDATE(), 103)

select DATEPART(DW,GETDATE())-DATEPART(DW,GETDATE()) + 2

--bang tuan nay
select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,#') tienPhong,format(tienDichVu,'#,#') tienDichVu,
format(phuThu,'#,#') phuThu,format(tongTien,'#,#') tongTien from phong a join phieuThuePhong b on a.idPhong = b.idPhong 
join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong 
where thoiGianMo between 
CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),DAY(GETDATE()) - (DATEPART(DW,GETDATE()) - (DATEPART(DW,convert(varchar, GETDATE(), 103))-
DATEPART(DW,convert(varchar, GETDATE(), 103)) + 2 ))), 103) and GETDATE()

-- bang nam
select tenPhong,convert(varchar, thoiGianMo, 103) thoiGianMo,format(tienPhong,'#,#') tienPhong,format(tienDichVu,'#,#') tienDichVu,
format(phuThu,'#,#') phuThu,format(tongTien,'#,#') tongTien from phong a join phieuThuePhong b on a.idPhong = b.idPhong 
join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong 
where year(thoiGianMo) = YEAR(GETDATE()) order by MONTH(thoiGianMo),DAY(thoiGianMo)

-- bieu do hom nay
select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu) from phong a join phieuThuePhong b 
on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong 
where convert(varchar, thoiGianMo, 103)=convert(varchar, GETDATE(), 103) group by MONTH(thoiGianMo), YEAR(thoiGianMo)

-- bieu do tuan nay
select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu) from phong a join phieuThuePhong b 
on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong 
where thoiGianMo between 
CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),DAY(GETDATE()) - (DATEPART(DW,GETDATE()) - (DATEPART(DW,convert(varchar, GETDATE(), 103))-
DATEPART(DW,convert(varchar, GETDATE(), 103)) + 2 ))), 103) and GETDATE() group by MONTH(thoiGianMo), YEAR(thoiGianMo)

--bieu do thang nay
select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong), sum(tienDichVu), sum(phuThu) from phong a join phieuThuePhong b 
on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong 
where thoiGianMo between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE()
group by MONTH(thoiGianMo), YEAR(thoiGianMo)

--bieu do nam 
select MONTH(thoiGianMo), YEAR(thoiGianMo) , sum(tienPhong) tienPhong, sum(tienDichVu), sum(phuThu), sum(tongTien) tongTien from phong a join phieuThuePhong b 
on a.idPhong = b.idPhong join hoaDon c on c.idPhieuThuePhong = b.idPhieuThuePhong 
where year(thoiGianMo) = YEAR(GETDATE()) group by MONTH(thoiGianMo), YEAR(thoiGianMo)

select tenDichVu,tenDanhMuc,tenDonVi,gia,soLuongCon from dichVu a join danhMuc b on a.idDanhMuc = b.idDanhMuc join donViTinh c on c.idDonViTinh = a.idDonViTinh order by soLuongCon

--dich vu hot hom nay
select tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh where convert(varchar, gioSuDung, 103)=convert(varchar, GETDATE(), 103) group by tenDichVu,b.gia, tenDonVi order by sum(soLuong) desc

--dich vu tuan nay
select tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh
where gioSuDung between 
CONVERT(date, replace(GETDATE(),DATEPART(dd,GETDATE()),DAY(GETDATE()) - (DATEPART(DW,GETDATE()) - (DATEPART(DW,convert(varchar, GETDATE(), 103))-
DATEPART(DW,convert(varchar, GETDATE(), 103)) + 2 ))), 103) and GETDATE() 
group by tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc

--dich vu thang nay
select tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh
where gioSuDung between CONVERT(datetime, replace(GETDATE(),DATEPART(dd,GETDATE()),01), 121) and GETDATE() 
group by tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc

--dich vu nam nay
select tenDichVu,sum(soLuong),tenDonVi, b.gia*sum(soLuong) from chiTietDichVuSuDung a join dichVu b on a.idDichVu = b.idDichVu join donViTinh c on c.idDonViTinh = b.idDonViTinh
where year(gioSuDung) = YEAR(GETDATE())
group by tenDichVu,b.gia,tenDonVi order by sum(soLuong) desc