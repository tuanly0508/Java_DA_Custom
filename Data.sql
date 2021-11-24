USE [master]
GO
/****** Object:  Database [DuAn1]    Script Date: 11/24/2021 10:15:38 AM ******/
CREATE DATABASE [DuAn1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DuAn1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DuAn1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DuAn1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DuAn1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DuAn1] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DuAn1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DuAn1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DuAn1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DuAn1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DuAn1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DuAn1] SET ARITHABORT OFF 
GO
ALTER DATABASE [DuAn1] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DuAn1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DuAn1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DuAn1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DuAn1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DuAn1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DuAn1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DuAn1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DuAn1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DuAn1] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DuAn1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DuAn1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DuAn1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DuAn1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DuAn1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DuAn1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DuAn1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DuAn1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DuAn1] SET  MULTI_USER 
GO
ALTER DATABASE [DuAn1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DuAn1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DuAn1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DuAn1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DuAn1] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DuAn1] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DuAn1] SET QUERY_STORE = OFF
GO
USE [DuAn1]
GO
/****** Object:  Table [dbo].[chiTietDichVuSuDung]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietDichVuSuDung](
	[idDichVu] [int] NOT NULL,
	[idHoaDonDichVu] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[gioSuDung] [datetime] NOT NULL,
	[gia] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chiTietPhieuNhap]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietPhieuNhap](
	[idPhieuNhap] [int] NOT NULL,
	[idDichVu] [int] NOT NULL,
	[idDonViTinh] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaNhap] [float] NOT NULL,
	[ghiChu] [nvarchar](250) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danhMuc]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danhMuc](
	[idDanhMuc] [int] IDENTITY(1,1) NOT NULL,
	[tenDanhMuc] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dichVu]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dichVu](
	[idDichVu] [int] IDENTITY(1,1) NOT NULL,
	[idDanhMuc] [int] NOT NULL,
	[idDonViTinh] [int] NOT NULL,
	[tenDichVu] [nvarchar](50) NOT NULL,
	[soLuongCon] [int] NOT NULL,
	[gia] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[donViTinh]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[donViTinh](
	[idDonViTinh] [int] IDENTITY(1,1) NOT NULL,
	[tenDonVi] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonViTinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioDatTruoc]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioDatTruoc](
	[idGioDatTruoc] [int] IDENTITY(1,1) NOT NULL,
	[tenHinhThuc] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idGioDatTruoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoaDon]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDon](
	[idHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idNhanVien] [int] NOT NULL,
	[idHoaDonDichVu] [int] NOT NULL,
	[idPhieuThuePhong] [int] NOT NULL,
	[tienPhong] [float] NOT NULL,
	[tongTien] [float] NOT NULL,
	[ghiChu] [nvarchar](150) NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoaDonDichVu]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDonDichVu](
	[idHoaDonDichVu] [int] IDENTITY(1,1) NOT NULL,
	[idPhong] [int] NOT NULL,
	[tongTienDV] [float] NOT NULL,
	[trangThai] [nvarchar](50) NULL,
	[thoiGianDat] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idHoaDonDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khachHang]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khachHang](
	[idKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[SDTKhachHang] [varchar](11) NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[tienNo] [float] NULL,
	[tienSuDung] [float] NULL,
	[loaiKhachHang] [nvarchar](20) NOT NULL,
	[traSau] [bit] NULL,
	[ghiChu] [nvarchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[idKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[loaiPhong]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loaiPhong](
	[idLoaiPhong] [int] IDENTITY(1,1) NOT NULL,
	[tenLoaiPhong] [nvarchar](30) NOT NULL,
	[soKhachMax] [int] NOT NULL,
	[giaGio] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhaCungCap]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhaCungCap](
	[idNhaCungCap] [int] IDENTITY(1,1) NOT NULL,
	[tenNhaCungCap] [nvarchar](100) NOT NULL,
	[SDTNhaCungCap] [nvarchar](11) NOT NULL,
	[diaChi] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[idNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhanVien]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhanVien](
	[idNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[hoTenNhanVien] [nvarchar](50) NOT NULL,
	[CMND] [int] NOT NULL,
	[soDienThoai] [nvarchar](11) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[gioiTinh] [nvarchar](5) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[vertifyCode] [varchar](50) NULL,
	[matKhau] [varchar](100) NOT NULL,
	[quyenHan] [varchar](20) NOT NULL,
	[trangThai] [varchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuDatPhong]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuDatPhong](
	[idPhieuDatPhong] [int] IDENTITY(1,1) NOT NULL,
	[SDTKhachHang] [varchar](11) NOT NULL,
	[idPhong] [int] NOT NULL,
	[thoiGianDat] [int] NOT NULL,
	[ghiChu] [nvarchar](250) NULL,
	[tinhTrang] [bit] NOT NULL,
	[tenKhach] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhieuDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuNhapDichVu]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuNhapDichVu](
	[idPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[idNhaCungCap] [int] NOT NULL,
	[thoiGianNhap] [datetime] NOT NULL,
	[tongTien] [float] NOT NULL,
	[ghiChu] [nvarchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuThuePhong]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuThuePhong](
	[idPhieuThuePhong] [int] IDENTITY(1,1) NOT NULL,
	[SDTKhachHang] [varchar](11) NULL,
	[idPhong] [int] NULL,
	[thoiGianMo] [datetime] NOT NULL,
	[thoiGianDong] [datetime] NULL,
	[tenKhachHang] [nvarchar](50) NULL,
	[tinhTrang] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhieuThuePhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phong]    Script Date: 11/24/2021 10:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phong](
	[idPhong] [int] IDENTITY(1,1) NOT NULL,
	[idLoaiPhong] [int] NOT NULL,
	[tenPhong] [nvarchar](50) NOT NULL,
	[tinhTrangPhong] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 1, 5, CAST(N'2021-11-23T14:40:49.027' AS DateTime), 50000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 1, 3, CAST(N'2021-11-23T14:40:53.690' AS DateTime), 45000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 2, 0, CAST(N'2021-11-23T15:00:01.637' AS DateTime), 0)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 2, 1, CAST(N'2021-11-23T15:00:07.307' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 3, 5, CAST(N'2021-11-23T16:43:44.113' AS DateTime), 50000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 4, 3, CAST(N'2021-11-24T10:10:47.457' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 4, 5, CAST(N'2021-11-24T10:10:56.247' AS DateTime), 50000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 4, 1, CAST(N'2021-11-24T10:11:27.983' AS DateTime), 15000)
GO
SET IDENTITY_INSERT [dbo].[danhMuc] ON 

INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc]) VALUES (1, N'Đồ uống')
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc]) VALUES (2, N'Bim bim')
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc]) VALUES (3, N'Thuốc lá')
SET IDENTITY_INSERT [dbo].[danhMuc] OFF
GO
SET IDENTITY_INSERT [dbo].[dichVu] ON 

INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia]) VALUES (1, 1, 1, N'Sting', 50, 10000)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia]) VALUES (2, 1, 1, N'Redbull', 50, 15000)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia]) VALUES (3, 2, 2, N'Oshi cay', 50, 10000)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia]) VALUES (4, 2, 2, N'Ostart cay', 50, 10000)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia]) VALUES (5, 3, 2, N'Thuốc ngựa', 50, 10000)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia]) VALUES (6, 3, 2, N'555', 50, 10000)
SET IDENTITY_INSERT [dbo].[dichVu] OFF
GO
SET IDENTITY_INSERT [dbo].[donViTinh] ON 

INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi]) VALUES (1, N'chai')
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi]) VALUES (2, N'gói')
SET IDENTITY_INSERT [dbo].[donViTinh] OFF
GO
SET IDENTITY_INSERT [dbo].[GioDatTruoc] ON 

INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (1, N'Chọn...')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (2, N'10h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (3, N'10h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (4, N'11h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (5, N'11h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (6, N'12h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (7, N'12h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (8, N'13h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (9, N'13h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (10, N'14h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (11, N'14h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (12, N'15h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (13, N'15h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (14, N'16h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (15, N'16h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (16, N'17h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (17, N'17h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (18, N'18h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (19, N'18h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (20, N'19h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (21, N'19h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (22, N'20h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (23, N'20h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (24, N'21h')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (25, N'21h30')
INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (26, N'22h')
SET IDENTITY_INSERT [dbo].[GioDatTruoc] OFF
GO
SET IDENTITY_INSERT [dbo].[hoaDonDichVu] ON 

INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (1, 7, 0, N'1', CAST(N'2021-11-23T14:40:48.930' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (2, 10, 0, N'1', CAST(N'2021-11-23T15:00:01.597' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (3, 3, 0, N'1', CAST(N'2021-11-23T16:43:44.067' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (4, 5, 0, N'1', CAST(N'2021-11-24T10:10:47.310' AS DateTime))
SET IDENTITY_INSERT [dbo].[hoaDonDichVu] OFF
GO
SET IDENTITY_INSERT [dbo].[khachHang] ON 

INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (1, N'0941790508', N'Trần Tuấn Anh', 0, 999999, N'Vip', 1, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (2, N'0941790508', N'Trần Tuấn Anh', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (3, N'0941790508', N'Trần Tuấn Anh', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (4, N'0941790508', N'Trần Tuấn Anh', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (6, N'0941790508', N'Trần Tuấn Anh', 0, 0, N'Thường', 0, NULL)
SET IDENTITY_INSERT [dbo].[khachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[loaiPhong] ON 

INSERT [dbo].[loaiPhong] ([idLoaiPhong], [tenLoaiPhong], [soKhachMax], [giaGio]) VALUES (1, N'Phòng thường', 10, 90000)
INSERT [dbo].[loaiPhong] ([idLoaiPhong], [tenLoaiPhong], [soKhachMax], [giaGio]) VALUES (2, N'Phòng vip', 20, 150000)
SET IDENTITY_INSERT [dbo].[loaiPhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuDatPhong] ON 

INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (1, N'0941790508', 2, 5, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (2, N'0941790508', 2, 8, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (3, N'0941790508', 2, 6, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (4, N'0941790508', 10, 6, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (5, N'0941790508', 1, 6, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (6, N'0941790508', 5, 23, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (7, N'0941790508', 1, 7, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (8, N'0941790508', 2, 25, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (9, N'0941790508', 1, 7, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (10, N'0941790508', 1, 7, NULL, 1, N'Trần Tuấn Anh')
SET IDENTITY_INSERT [dbo].[phieuDatPhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuThuePhong] ON 

INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang]) VALUES (1, N'0941790508', 7, CAST(N'2021-11-23T11:45:48.537' AS DateTime), NULL, N'Trần Tuấn Anh', 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang]) VALUES (2, N'0941790508', 10, CAST(N'2021-11-23T14:59:47.907' AS DateTime), NULL, N'Trần Tuấn Anh', 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang]) VALUES (3, N'0941790508', 3, CAST(N'2021-11-23T16:43:32.387' AS DateTime), NULL, N'Trần Tuấn Anh', 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang]) VALUES (4, N'0941790508', 5, CAST(N'2021-11-23T17:01:38.020' AS DateTime), NULL, N'Trần Tuấn Anh', 1)
SET IDENTITY_INSERT [dbo].[phieuThuePhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phong] ON 

INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (1, 1, N'Phòng 1', N'Phòng đặt trước')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (2, 1, N'Phòng 2', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (3, 1, N'Phòng 3', N'Đang hoạt động')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (4, 1, N'Phòng 4', N'Đang bảo trì')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (5, 2, N'Phòng 5', N'Đang hoạt động')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (6, 1, N'Phòng 6', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (7, 1, N'Phòng 7', N'Đang hoạt động')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (8, 1, N'Phòng 8', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (9, 1, N'Phòng 9', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (10, 2, N'Phòng 10', N'Đang hoạt động')
SET IDENTITY_INSERT [dbo].[phong] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nhaCungC__08C777FA7FC45147]    Script Date: 11/24/2021 10:15:39 AM ******/
ALTER TABLE [dbo].[nhaCungCap] ADD UNIQUE NONCLUSTERED 
(
	[SDTNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nhanVien__06ACB9A21FC032A0]    Script Date: 11/24/2021 10:15:39 AM ******/
ALTER TABLE [dbo].[nhanVien] ADD UNIQUE NONCLUSTERED 
(
	[soDienThoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__nhanVien__F67C8D0B1653A3AD]    Script Date: 11/24/2021 10:15:39 AM ******/
ALTER TABLE [dbo].[nhanVien] ADD UNIQUE NONCLUSTERED 
(
	[CMND] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[chiTietDichVuSuDung]  WITH CHECK ADD FOREIGN KEY([idDichVu])
REFERENCES [dbo].[dichVu] ([idDichVu])
GO
ALTER TABLE [dbo].[chiTietDichVuSuDung]  WITH CHECK ADD FOREIGN KEY([idHoaDonDichVu])
REFERENCES [dbo].[hoaDonDichVu] ([idHoaDonDichVu])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD FOREIGN KEY([idDichVu])
REFERENCES [dbo].[dichVu] ([idDichVu])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD FOREIGN KEY([idDonViTinh])
REFERENCES [dbo].[donViTinh] ([idDonViTinh])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD FOREIGN KEY([idPhieuNhap])
REFERENCES [dbo].[phieuNhapDichVu] ([idPhieuNhap])
GO
ALTER TABLE [dbo].[dichVu]  WITH CHECK ADD FOREIGN KEY([idDanhMuc])
REFERENCES [dbo].[danhMuc] ([idDanhMuc])
GO
ALTER TABLE [dbo].[dichVu]  WITH CHECK ADD FOREIGN KEY([idDonViTinh])
REFERENCES [dbo].[donViTinh] ([idDonViTinh])
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([idHoaDonDichVu])
REFERENCES [dbo].[hoaDonDichVu] ([idHoaDonDichVu])
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[nhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([idPhieuThuePhong])
REFERENCES [dbo].[phieuThuePhong] ([idPhieuThuePhong])
GO
ALTER TABLE [dbo].[hoaDonDichVu]  WITH CHECK ADD FOREIGN KEY([idPhong])
REFERENCES [dbo].[phong] ([idPhong])
GO
ALTER TABLE [dbo].[phieuDatPhong]  WITH CHECK ADD FOREIGN KEY([idPhong])
REFERENCES [dbo].[phong] ([idPhong])
GO
ALTER TABLE [dbo].[phieuDatPhong]  WITH CHECK ADD FOREIGN KEY([thoiGianDat])
REFERENCES [dbo].[GioDatTruoc] ([idGioDatTruoc])
GO
ALTER TABLE [dbo].[phieuNhapDichVu]  WITH CHECK ADD FOREIGN KEY([idNhaCungCap])
REFERENCES [dbo].[nhaCungCap] ([idNhaCungCap])
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD FOREIGN KEY([idPhong])
REFERENCES [dbo].[phong] ([idPhong])
GO
ALTER TABLE [dbo].[phong]  WITH CHECK ADD FOREIGN KEY([idLoaiPhong])
REFERENCES [dbo].[loaiPhong] ([idLoaiPhong])
GO
ALTER TABLE [dbo].[khachHang]  WITH CHECK ADD CHECK  ((len([SDTKhachHang])>=(10) AND len([SDTKhachHang])<=(11)))
GO
ALTER TABLE [dbo].[nhaCungCap]  WITH CHECK ADD CHECK  ((len([SDTNhaCungCap])>=(10) AND len([SDTNhaCungCap])<=(11)))
GO
ALTER TABLE [dbo].[nhanVien]  WITH CHECK ADD CHECK  ((len([CMND])=(9)))
GO
ALTER TABLE [dbo].[nhanVien]  WITH CHECK ADD CHECK  ((len([soDienThoai])>=(10) AND len([soDienThoai])<=(11)))
GO
ALTER TABLE [dbo].[phieuDatPhong]  WITH CHECK ADD CHECK  ((len([SDTKhachHang])>=(10) AND len([SDTKhachHang])<=(11)))
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD CHECK  ((len([SDTKhachHang])>=(10) AND len([SDTKhachHang])<=(11)))
GO
USE [master]
GO
ALTER DATABASE [DuAn1] SET  READ_WRITE 
GO
