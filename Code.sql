create database DuAn1

use DuAn1
go

create table giaNgayLe(
	idGiaNgayLe int identity primary key,
	tenGia varchar(5) not null,
	tinhTrang bit not null
)

create table GioDatTruoc(
	idGioDatTruoc int identity primary key,
	tenHinhThuc nvarchar(50) not null
)

create table donViTinh(
	idDonViTinh int identity primary key,
	tenDonVi nvarchar(50) not null
)

create table danhMuc(
	idDanhMuc int identity primary key,
	tenDanhMuc nvarchar(50) not null
)

create table dichVu(
	idDichVu int identity primary key,
	idDanhMuc int not null foreign key references danhMuc,
	idDonViTinh int not null foreign key references donViTinh,
	tenDichVu nvarchar(50) not null,
	soLuongCon int not null,
	gia float not null
)

create table nhaCungCap(
	idNhaCungCap int identity primary key,
	tenNhaCungCap nvarchar(100) not null,
	SDTNhaCungCap nvarchar(11) not null check (len (SDTNhaCungCap) between 10 and 11) unique,
	diaChi nvarchar(100)
)

create table phieuNhapDichVu(
	idPhieuNhap int identity primary key,
	idNhaCungCap int not null foreign key references nhaCungCap,
	thoiGianNhap datetime not null,
	tongTien float not null,
	ghiChu nvarchar(250) null
)

create table chiTietPhieuNhap(
	idPhieuNhap int not null foreign key references phieuNhapDichVu,
	idDichVu int not null foreign key references dichVu,
	idDonViTinh int not null foreign key references donViTinh,
	soLuong int not null,
	giaNhap float not null,
	ghiChu nvarchar(250) null
)

create table loaiPhong(
	idLoaiPhong int identity primary key,
	tenLoaiPhong nvarchar(30) not null,
	soKhachMax int not null,
	giaGio float not null
)

create table phong(
	idPhong int identity primary key,
	idLoaiPhong int not null foreign key references loaiPhong,
	tenPhong nvarchar(50) not null,
	tinhTrangPhong nvarchar(20) not null
)

create table nhanVien(
	idNhanVien int identity primary key,
	hoTenNhanVien nvarchar(50) not null,
	CMND int not null check (len (CMND) = 9) unique,
	soDienThoai nvarchar(11) not null check (len (soDienThoai) between 10 and 11) unique,
	diaChi nvarchar(100) not null,
	gioiTinh nvarchar(5) not null,
	email varchar(100) not null,
	vertifyCode varchar(50) null,
	matKhau varchar(100) not null,
	quyenHan varchar(20) not null,
	trangThai varchar(50) not null,
	ngaySinh date not null,
	ngayVaoLam date not null
)

create table khachHang(
	idKhachHang int identity primary key,
	SDTKhachHang varchar(11)  check (len (SDTKhachHang) between 10 and 11),
	tenKhachHang nvarchar(50) not null,
	tienNo float null,
	tienSuDung float null,
	loaiKhachHang nvarchar(20) not null,
	traSau bit null,
	ghiChu nvarchar(250) null
)

create table phieuDatPhong(
	idPhieuDatPhong int identity primary key,
	SDTKhachHang varchar(11) check (len (SDTKhachHang) between 10 and 11) not null,
	idPhong int not null foreign key references phong,
	thoiGianDat int not null foreign key references GioDatTruoc,
	ghiChu nvarchar(250) null,
	tinhTrang bit not null,
	tenKhach nvarchar(50) null
)


create table hoaDonDichVu(
	idHoaDonDichVu int identity primary key,
	idPhong int not null foreign key references phong,
	tongTienDV float not null,
	trangThai nvarchar(50),
	thoiGianDat datetime not null
)

create table chiTietDichVuSuDung(
	idDichVu int not null foreign key references dichVu,
	idHoaDonDichVu int not null foreign key references hoaDonDichVu,
	soLuong int not null,
	gioSuDung datetime not null,
	gia float not null
)

create table phieuThuePhong(
	idPhieuThuePhong int identity primary key,
	SDTKhachHang varchar(11) check (len (SDTKhachHang) between 10 and 11) null,
	idPhong int foreign key references phong,
	thoiGianMo datetime not null,
	thoiGianDong datetime null,
	tenKhachHang nvarchar(50) null,
	tinhTrang bit not null,
	giaNgayLe bit not null
)

create table hoaDon(
	idHoaDon int identity primary key,
	idNhanVien int not null foreign key references nhanVien,
	idHoaDonDichVu int not null foreign key references hoaDonDichVu,
	idPhieuThuePhong int not null foreign key references phieuThuePhong,
	tienPhong float not null,
	tongTien float not null,
	ghiChu nvarchar(150) null,
	trangThai bit not null
)



insert into loaiPhong values (N'Phòng thường',10,80000)
insert into loaiPhong values (N'Phòng vip',20,150000)

insert into phong values (1,N'Phòng 1',N'Phòng còn trống')
insert into phong values (1,N'Phòng 2',N'Phòng còn trống')
insert into phong values (1,N'Phòng 3',N'Phòng còn trống')
insert into phong values (1,N'Phòng 4',N'Phòng còn trống')
insert into phong values (2,N'Phòng 5',N'Đang bảo trì')
insert into phong values (1,N'Phòng 6',N'Phòng còn trống')
insert into phong values (1,N'Phòng 7',N'Phòng còn trống')
insert into phong values (1,N'Phòng 8',N'Phòng còn trống')
insert into phong values (1,N'Phòng 9',N'Phòng còn trống')
insert into phong values (2,N'Phòng 10',N'Phòng còn trống')

insert into danhMuc values (N'Đồ uống')
insert into danhMuc values (N'Bim bim')
insert into danhMuc values (N'Thuốc lá')

insert into donViTinh values (N'chai')
insert into donViTinh values (N'gói')

insert into dichVu values (1,1,N'Sting',50,10000)
insert into dichVu values (1,1,N'Redbull',50,15000)
insert into dichVu values (2,2,N'Oshi cay',50,10000)
insert into dichVu values (2,2,N'Ostart cay',50,10000)
insert into dichVu values (3,2,N'Thuốc ngựa',50,10000)
insert into dichVu values (3,2,N'555',50,10000)

insert into khachHang values ('0941790508',N'Trần Tuấn Anh',0,999999,N'Vip',1,null)


select tenDichVu, tenDonVi, gia from dichVu a join donViTinh b on a.idDonViTinh = b.idDonViTinh where idDanhMuc = 2

select * from Phong a join loaiPhong b on a.idLoaiPhong = b.idLoaiPhong where a.tinhTrangPhong = N'Phòng còn trống' 

select * from phong
select idPhieuThuePhong,SDTKhachHang,idPhong,thoiGianMo,thoiGianDong,tenKhachHang from phieuThuePhong where idPhong = 1

select * from khachHang where SDTKhachHang like '0941790508'

select idPhieuThuePhong,SDTKhachHang,idPhong,thoiGianMo,thoiGianDong,tenKhachHang from phieuThuePhong where idPhong = 6 and tinhTrang = 1

select idHoaDonDichVu from hoaDonDichVu where idPhong = 5 and trangthai=1

select * from hoaDonDichVu

select hd.idHoaDonDichVu,dv.tenDichVu,dvt.tenDonVi,FORMAT(ctdv.gioSuDung ,'dd/MM/yyyy HH:mm:ss') ngaySuDung,ctdv.soLuong,
format(ctdv.gia,'#,#')thanhTien from HoaDonDichVu hd join chiTietDichVuSuDung ctdv on hd.idHoaDonDichVu=ctdv.idHoaDonDichVu  
join DichVu dv on ctdv.idDichVu=dv.idDichVu join donViTinh dvt on dvt.idDonViTinh=dv.idDonViTinh where idphong= 2 and trangThai=1
order by ngaySuDung

select idPhieuDatPhong,SDTKhachHang,idPhong,thoiGianDat,ghiChu,tinhTrang from phieuDatPhong where idPhong = 2 and tinhTrang = 0

select idPhong,tenLoaiPhong,tenPhong from phong a join loaiPhong b on a.idLoaiPhong = b.idLoaiPhong where tinhTrangPhong = N'Phòng còn trống' and a.idLoaiPhong = 1

update phieuThuePhong set idPhong = 6 where idPhong = 1 and tinhTrang = 1

select a.idPhong,a.idLoaiPhong,tenPhong,tinhTrangPhong,tenLoaiPhong,soKhachMax,giaGio,thoiGianMo from Phong a join loaiPhong b on a.idLoaiPhong = b.idLoaiPhong join phieuThuePhong c on c.idPhong = a.idPhong where a.idLoaiPhong = 2

select count(*) isGiaNgayLe from phieuThuePhong where idPhong = 9 and giaNgayLe = 1 

select a.idPhong,a.idLoaiPhong,tenPhong,tinhTrangPhong,tenLoaiPhong,soKhachMax,giaGio,thoiGianMo, DATEDIFF(DD,GETDATE(),thoiGianMo) tgsd 
from Phong a join loaiPhong b 
on a.idLoaiPhong = b.idLoaiPhong join phieuThuePhong c on c.idPhong = a.idPhong where a.idLoaiPhong = 1

select idPhieuDatPhong,idPhong,SDTKhachHang,tenKhach,b.tenHinhThuc from phieuDatPhong a join GioDatTruoc b on a.thoiGianDat = b.idGioDatTruoc where idPhong = 2

select p.idPhong,tenPhong,tinhTrangPhong,idLoaiPhong,convert(varchar, thoiGianMo, 8) thoiGianMo, a.tinhTrang from phong p left join 
phieuThuePhong ptp on p.idPhong=ptp.idPhong left join phieuDatPhong a on a.idPhong=p.idPhong where ptp.tinhTrang=1 or ptp.tinhTrang is null

select * from phieuDatPhong

select a.idPhong,a.idLoaiPhong,tenPhong,tinhTrangPhong,tenLoaiPhong,soKhachMax,giaGio,thoiGianMo from Phong a join loaiPhong b 
on a.idLoaiPhong = b.idLoaiPhong join phieuThuePhong c on c.idPhong = a.idPhong where a.idLoaiPhong = 1 and a.idPhong = 2 

select p.idPhong,tenPhong,tinhTrangPhong,idLoaiPhong,convert(varchar, thoiGianMo, 8) thoiGianMo, a.tinhTrang from phong p 
left join phieuThuePhong ptp on p.idPhong=ptp.idPhong left join phieuDatPhong a on a.idPhong=p.idPhong where ptp.tinhTrang=1 or 
ptp.tinhTrang is null 

select distinct b.idPhong,tinhTrang,tenPhong from phieuDatPhong a right join phong b on a.idPhong = b.idPhong

select * from phong a left join phieuDatPhong b on a.idPhong=b.idPhong

select idPhieuDatPhong,idPhong,tenKhach,SDTKhachHang,b.tenHinhThuc from phieuDatPhong a join GioDatTruoc b 
on a.thoiGianDat = b.idGioDatTruoc where idPhong = 2 and tinhTrang = 1 



insert into GioDatTruoc values (N'Chọn')
insert into GioDatTruoc values ('10h')
insert into GioDatTruoc values ('10h30')
insert into GioDatTruoc values ('11h')
insert into GioDatTruoc values ('11h30')
insert into GioDatTruoc values ('12h')
insert into GioDatTruoc values ('12h30')
insert into GioDatTruoc values ('13h')
insert into GioDatTruoc values ('13h30')
insert into GioDatTruoc values ('14h')
insert into GioDatTruoc values ('14h30')
insert into GioDatTruoc values ('15h')
insert into GioDatTruoc values ('15h30')
insert into GioDatTruoc values ('16h')
insert into GioDatTruoc values ('16h30')
insert into GioDatTruoc values ('17h')
insert into GioDatTruoc values ('17h30')
insert into GioDatTruoc values ('18h')
insert into GioDatTruoc values ('18h30')
insert into GioDatTruoc values ('19h')
insert into GioDatTruoc values ('19h30')
insert into GioDatTruoc values ('20h')
insert into GioDatTruoc values ('20h30')
insert into GioDatTruoc values ('21h')
insert into GioDatTruoc values ('21h30')
insert into GioDatTruoc values ('22h')