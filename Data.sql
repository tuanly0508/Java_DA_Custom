USE [master]
GO
/****** Object:  Database [DuAn1]    Script Date: 11/26/2021 9:46:11 AM ******/
CREATE DATABASE [DuAn1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DuAn1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DuAn1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DuAn1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DuAn1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
EXEC sys.sp_db_vardecimal_storage_format N'DuAn1', N'ON'
GO
ALTER DATABASE [DuAn1] SET QUERY_STORE = OFF
GO
USE [DuAn1]
GO
/****** Object:  Table [dbo].[chiTietDichVuSuDung]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[chiTietPhieuNhap]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[danhMuc]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[dichVu]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[donViTinh]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[giaNgayLe]    Script Date: 11/26/2021 9:46:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[giaNgayLe](
	[idGiaNgayLe] [int] IDENTITY(1,1) NOT NULL,
	[tenGia] [varchar](5) NOT NULL,
	[tinhTrang] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idGiaNgayLe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioDatTruoc]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[hoaDon]    Script Date: 11/26/2021 9:46:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDon](
	[idHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idNhanVien] [int] NOT NULL,
	[idHoaDonDichVu] [int] NULL,
	[idPhieuThuePhong] [int] NOT NULL,
	[tienPhong] [float] NOT NULL,
	[tienDichVu] [float] NULL,
	[tongTien] [float] NOT NULL,
	[phuThu] [float] NULL,
 CONSTRAINT [PK__hoaDon__B060C52C17013CF8] PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoaDonDichVu]    Script Date: 11/26/2021 9:46:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDonDichVu](
	[idHoaDonDichVu] [int] IDENTITY(1,1) NOT NULL,
	[idPhong] [int] NOT NULL,
	[tongTienDV] [float] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[thoiGianDat] [datetime] NOT NULL,
 CONSTRAINT [PK__hoaDonDi__6D154CC5BB934820] PRIMARY KEY CLUSTERED 
(
	[idHoaDonDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khachHang]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[loaiPhong]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[nhaCungCap]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[nhanVien]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[phieuDatPhong]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[phieuNhapDichVu]    Script Date: 11/26/2021 9:46:11 AM ******/
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
/****** Object:  Table [dbo].[phieuThuePhong]    Script Date: 11/26/2021 9:46:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuThuePhong](
	[idPhieuThuePhong] [int] IDENTITY(1,1) NOT NULL,
	[SDTKhachHang] [varchar](11) NULL,
	[idNhanVien] [int] NULL,
	[idPhong] [int] NULL,
	[thoiGianMo] [datetime] NOT NULL,
	[thoiGianDong] [datetime] NULL,
	[tenKhachHang] [nvarchar](50) NULL,
	[tinhTrang] [bit] NOT NULL,
	[giaNgayLe] [bit] NOT NULL,
 CONSTRAINT [PK__phieuThu__F6F0B1F0C32206FF] PRIMARY KEY CLUSTERED 
(
	[idPhieuThuePhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phong]    Script Date: 11/26/2021 9:46:11 AM ******/
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
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 1, 5, CAST(N'2021-11-25T14:22:52.963' AS DateTime), 50000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 2, 0, CAST(N'2021-11-25T21:35:28.893' AS DateTime), 0)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 2, 0, CAST(N'2021-11-25T21:35:31.200' AS DateTime), 0)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 2, 2, CAST(N'2021-11-25T21:35:42.937' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 2, 2, CAST(N'2021-11-25T21:35:47.087' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 3, 1, CAST(N'2021-11-25T21:38:37.033' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 3, 0, CAST(N'2021-11-25T21:38:43.910' AS DateTime), 0)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 4, 2, CAST(N'2021-11-25T21:46:02.157' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 5, 2, CAST(N'2021-11-25T22:31:38.060' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 6, 2, CAST(N'2021-11-25T23:15:16.903' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 6, 2, CAST(N'2021-11-25T23:15:19.227' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 7, 2, CAST(N'2021-11-25T23:17:05.170' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 10, 4, CAST(N'2021-11-26T00:26:49.573' AS DateTime), 60000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 11, 2, CAST(N'2021-11-26T00:28:47.820' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 11, 2, CAST(N'2021-11-26T00:28:52.317' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 12, 2, CAST(N'2021-11-26T09:24:07.877' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 12, 2, CAST(N'2021-11-26T09:24:10.123' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 8, 2, CAST(N'2021-11-25T23:37:03.340' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 9, 2, CAST(N'2021-11-26T00:15:19.377' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 9, 2, CAST(N'2021-11-26T00:15:22.853' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 10, 3, CAST(N'2021-11-26T00:26:45.293' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 10, 3, CAST(N'2021-11-26T00:26:47.177' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 10, 3, CAST(N'2021-11-26T00:26:52.067' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 11, 2, CAST(N'2021-11-26T00:28:50.710' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 11, 2, CAST(N'2021-11-26T00:28:53.297' AS DateTime), 20000)
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
SET IDENTITY_INSERT [dbo].[giaNgayLe] ON 

INSERT [dbo].[giaNgayLe] ([idGiaNgayLe], [tenGia], [tinhTrang]) VALUES (1, N'5', 0)
INSERT [dbo].[giaNgayLe] ([idGiaNgayLe], [tenGia], [tinhTrang]) VALUES (2, N'10', 1)
SET IDENTITY_INSERT [dbo].[giaNgayLe] OFF
GO
SET IDENTITY_INSERT [dbo].[GioDatTruoc] ON 

INSERT [dbo].[GioDatTruoc] ([idGioDatTruoc], [tenHinhThuc]) VALUES (1, N'Chọn')
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
SET IDENTITY_INSERT [dbo].[hoaDon] ON 

INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (1, 2, 1, 1, 120000, 50000, 170000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (2, 2, NULL, 2, 2666.6666666666665, 0, 2666.6666666666665, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (5, 2, 1, 1, 200000, 50000, 250000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (6, 2, 1, 1, 201333.33333333331, 50000, 251333.33333333331, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (8, 2, NULL, 3, 40000, 0, 40000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (9, 2, NULL, 2, 462666.66666666663, 0, 462666.66666666663, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (10, 2, 2, 4, 0, 40000, 40000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (11, 2, 3, 5, 0, 10000, 10000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (12, 2, 4, 6, 0, 20000, 20000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (13, 2, 5, 7, 56000, 20000, 76000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (14, 2, 6, 8, 0, 40000, 40000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (15, 2, 7, 9, 0, 20000, 20000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (16, 2, 8, 10, 0, 20000, 20000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (20, 2, 9, 11, 0, 40000, 40000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (21, 2, 10, 12, 0, 150000, 150000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (22, 2, 11, 13, 0, 90000, 90000, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu]) VALUES (23, 2, 12, 14, 0, 50000, 50000, 0)
SET IDENTITY_INSERT [dbo].[hoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[hoaDonDichVu] ON 

INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (1, 2, 0, 0, CAST(N'2021-11-25T14:22:52.887' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (2, 1, 0, 0, CAST(N'2021-11-25T21:35:28.837' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (3, 2, 0, 0, CAST(N'2021-11-25T21:38:36.977' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (4, 2, 0, 0, CAST(N'2021-11-25T21:46:02.097' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (5, 2, 0, 0, CAST(N'2021-11-25T22:31:37.997' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (6, 2, 0, 0, CAST(N'2021-11-25T23:15:16.847' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (7, 2, 0, 0, CAST(N'2021-11-25T23:17:05.097' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (8, 2, 0, 0, CAST(N'2021-11-25T23:37:03.293' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (9, 6, 0, 0, CAST(N'2021-11-26T00:15:19.327' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (10, 3, 0, 0, CAST(N'2021-11-26T00:26:45.233' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (11, 3, 0, 0, CAST(N'2021-11-26T00:28:47.743' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (12, 4, 0, 0, CAST(N'2021-11-26T09:24:07.820' AS DateTime))
SET IDENTITY_INSERT [dbo].[hoaDonDichVu] OFF
GO
SET IDENTITY_INSERT [dbo].[khachHang] ON 

INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (1, N'0941790508', N'Trần Tuấn Anh', 0, 999999, N'Vip', 1, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (2, N'0946761636', N'Đông', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (3, N'0946764758', N'Anh', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (4, N'0845454545`', N'áddd', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (5, N'0946898989', N'Anh', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (6, N'0985474584', N'Trần Văn Mạnh', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (7, N'0987458745', N'Tuấn', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (8, N'0987888888', N'ĐÔng', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (9, N'0658111111', N'Hoa', 0, 0, N'Thường', 0, NULL)
INSERT [dbo].[khachHang] ([idKhachHang], [SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [loaiKhachHang], [traSau], [ghiChu]) VALUES (10, N'01258454545', N'Anh Anh', 0, 0, N'Thường', 0, NULL)
SET IDENTITY_INSERT [dbo].[khachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[loaiPhong] ON 

INSERT [dbo].[loaiPhong] ([idLoaiPhong], [tenLoaiPhong], [soKhachMax], [giaGio]) VALUES (1, N'Phòng thường', 10, 80000)
INSERT [dbo].[loaiPhong] ([idLoaiPhong], [tenLoaiPhong], [soKhachMax], [giaGio]) VALUES (2, N'Phòng vip', 20, 150000)
SET IDENTITY_INSERT [dbo].[loaiPhong] OFF
GO
SET IDENTITY_INSERT [dbo].[nhanVien] ON 

INSERT [dbo].[nhanVien] ([idNhanVien], [hoTenNhanVien], [CMND], [soDienThoai], [diaChi], [gioiTinh], [email], [vertifyCode], [matKhau], [quyenHan], [trangThai], [ngaySinh], [ngayVaoLam]) VALUES (2, N'Trần Tuấn Anh', 241111111, N'0987999999', N'Ea', N'Nam', N'anh@gmail.com', NULL, N'123123', N'admin', N'1', CAST(N'1997-11-11' AS Date), CAST(N'2011-10-10' AS Date))
SET IDENTITY_INSERT [dbo].[nhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuDatPhong] ON 

INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (1, N'0941790508', 2, 3, NULL, 0, N'Trần Tuấn Anh')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (2, N'0941790508', 2, 25, NULL, 0, N'Trần Tuấn Anh')
SET IDENTITY_INSERT [dbo].[phieuDatPhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuThuePhong] ON 

INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (1, N'0941790508', 2, 2, CAST(N'2021-11-25T14:15:26.190' AS DateTime), CAST(N'2021-11-25T17:13:59.377' AS DateTime), N'Trần Tuấn Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (2, N'0946761636', 2, 1, CAST(N'2021-11-25T15:46:30.790' AS DateTime), CAST(N'2021-11-25T21:34:09.707' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (3, N'0946764758', 2, 2, CAST(N'2021-11-25T21:02:57.203' AS DateTime), CAST(N'2021-11-25T21:33:07.857' AS DateTime), N'Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (4, N'0946761636', 2, 1, CAST(N'2021-11-25T21:35:23.197' AS DateTime), CAST(N'2021-11-25T21:36:12.020' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (5, N'0845454545`', 2, 2, CAST(N'2021-11-25T21:38:20.983' AS DateTime), CAST(N'2021-11-25T21:38:58.143' AS DateTime), N'áddd', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (6, N'0946761636', 2, 2, CAST(N'2021-11-25T21:45:56.020' AS DateTime), CAST(N'2021-11-25T21:46:14.423' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (7, N'0946761636', 2, 2, CAST(N'2021-11-25T22:31:05.227' AS DateTime), CAST(N'2021-11-25T23:13:51.820' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (8, N'0946761636', 2, 2, CAST(N'2021-11-25T23:15:11.307' AS DateTime), CAST(N'2021-11-25T23:15:34.383' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (9, N'0946898989', 2, 2, CAST(N'2021-11-25T23:16:57.747' AS DateTime), CAST(N'2021-11-25T23:17:28.133' AS DateTime), N'Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (10, N'0985474584', 2, 2, CAST(N'2021-11-25T23:36:56.997' AS DateTime), CAST(N'2021-11-25T23:37:07.337' AS DateTime), N'Trần Văn Mạnh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (11, N'0987458745', 2, 6, CAST(N'2021-11-26T00:15:11.763' AS DateTime), CAST(N'2021-11-26T00:15:29.167' AS DateTime), N'Tuấn', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (12, N'0987888888', 2, 3, CAST(N'2021-11-26T00:26:37.770' AS DateTime), CAST(N'2021-11-26T00:27:05.717' AS DateTime), N'ĐÔng', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (13, N'0658111111', 2, 3, CAST(N'2021-11-26T00:28:41.363' AS DateTime), CAST(N'2021-11-26T00:29:00.087' AS DateTime), N'Hoa', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (14, N'01258454545', 2, 4, CAST(N'2021-11-26T09:23:53.057' AS DateTime), CAST(N'2021-11-26T09:24:52.500' AS DateTime), N'Anh Anh', 0, 0)
SET IDENTITY_INSERT [dbo].[phieuThuePhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phong] ON 

INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (1, 1, N'Phòng 1', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (2, 1, N'Phòng 2', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (3, 1, N'Phòng 3', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (4, 1, N'Phòng 4', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (5, 2, N'Phòng 5', N'Đang bảo trì')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (6, 1, N'Phòng 6', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (7, 1, N'Phòng 7', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (8, 1, N'Phòng 8', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (9, 1, N'Phòng 9', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (10, 2, N'Phòng 10', N'Phòng còn trống')
SET IDENTITY_INSERT [dbo].[phong] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nhaCungC__08C777FA74E34B98]    Script Date: 11/26/2021 9:46:12 AM ******/
ALTER TABLE [dbo].[nhaCungCap] ADD UNIQUE NONCLUSTERED 
(
	[SDTNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nhanVien__06ACB9A2060F9D37]    Script Date: 11/26/2021 9:46:12 AM ******/
ALTER TABLE [dbo].[nhanVien] ADD UNIQUE NONCLUSTERED 
(
	[soDienThoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__nhanVien__F67C8D0B0595312A]    Script Date: 11/26/2021 9:46:12 AM ******/
ALTER TABLE [dbo].[nhanVien] ADD UNIQUE NONCLUSTERED 
(
	[CMND] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[chiTietDichVuSuDung]  WITH CHECK ADD FOREIGN KEY([idDichVu])
REFERENCES [dbo].[dichVu] ([idDichVu])
GO
ALTER TABLE [dbo].[chiTietDichVuSuDung]  WITH CHECK ADD  CONSTRAINT [FK__chiTietDi__idHoa__44FF419A] FOREIGN KEY([idHoaDonDichVu])
REFERENCES [dbo].[hoaDonDichVu] ([idHoaDonDichVu])
GO
ALTER TABLE [dbo].[chiTietDichVuSuDung] CHECK CONSTRAINT [FK__chiTietDi__idHoa__44FF419A]
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
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK__hoaDon__idHoaDon__4AB81AF0] FOREIGN KEY([idHoaDonDichVu])
REFERENCES [dbo].[hoaDonDichVu] ([idHoaDonDichVu])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK__hoaDon__idHoaDon__4AB81AF0]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK__hoaDon__idNhanVi__4BAC3F29] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[nhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK__hoaDon__idNhanVi__4BAC3F29]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK__hoaDon__idPhieuT__4CA06362] FOREIGN KEY([idPhieuThuePhong])
REFERENCES [dbo].[phieuThuePhong] ([idPhieuThuePhong])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK__hoaDon__idPhieuT__4CA06362]
GO
ALTER TABLE [dbo].[hoaDonDichVu]  WITH CHECK ADD  CONSTRAINT [FK__hoaDonDic__idPho__4D94879B] FOREIGN KEY([idPhong])
REFERENCES [dbo].[phong] ([idPhong])
GO
ALTER TABLE [dbo].[hoaDonDichVu] CHECK CONSTRAINT [FK__hoaDonDic__idPho__4D94879B]
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
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[nhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD  CONSTRAINT [FK__phieuThue__idPho__5165187F] FOREIGN KEY([idPhong])
REFERENCES [dbo].[phong] ([idPhong])
GO
ALTER TABLE [dbo].[phieuThuePhong] CHECK CONSTRAINT [FK__phieuThue__idPho__5165187F]
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
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD  CONSTRAINT [CK__phieuThue__SDTKh__5812160E] CHECK  ((len([SDTKhachHang])>=(10) AND len([SDTKhachHang])<=(11)))
GO
ALTER TABLE [dbo].[phieuThuePhong] CHECK CONSTRAINT [CK__phieuThue__SDTKh__5812160E]
GO
USE [master]
GO
ALTER DATABASE [DuAn1] SET  READ_WRITE 
GO
