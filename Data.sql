USE [master]
GO
/****** Object:  Database [DuAn1]    Script Date: 12/4/2021 11:04:09 PM ******/
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
/****** Object:  Table [dbo].[chiTietDichVuSuDung]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietDichVuSuDung](
	[idDichVu] [int] NULL,
	[idHoaDonDichVu] [int] NULL,
	[soLuong] [int] NOT NULL,
	[gioSuDung] [datetime] NOT NULL,
	[gia] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chiTietPhieuNhap]    Script Date: 12/4/2021 11:04:10 PM ******/
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
/****** Object:  Table [dbo].[danhMuc]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danhMuc](
	[idDanhMuc] [int] IDENTITY(1,1) NOT NULL,
	[tenDanhMuc] [nvarchar](50) NOT NULL,
	[tinhTrang] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dichVu]    Script Date: 12/4/2021 11:04:10 PM ******/
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
	[tinhTrang] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[donViTinh]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[donViTinh](
	[idDonViTinh] [int] IDENTITY(1,1) NOT NULL,
	[tenDonVi] [nvarchar](50) NOT NULL,
	[giaTri] [int] NULL,
	[tinhTrang] [bit] NULL,
 CONSTRAINT [PK__donViTin__EE16FF677498C8C7] PRIMARY KEY CLUSTERED 
(
	[idDonViTinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[giaNgayLe]    Script Date: 12/4/2021 11:04:10 PM ******/
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
/****** Object:  Table [dbo].[GioDatTruoc]    Script Date: 12/4/2021 11:04:10 PM ******/
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
/****** Object:  Table [dbo].[hoaDon]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDon](
	[idHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idNhanVien] [int] NULL,
	[idHoaDonDichVu] [int] NULL,
	[idPhieuThuePhong] [int] NULL,
	[tienPhong] [float] NOT NULL,
	[tienDichVu] [float] NULL,
	[tongTien] [float] NOT NULL,
	[phuThu] [float] NULL,
	[tienNo] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoaDonDichVu]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDonDichVu](
	[idHoaDonDichVu] [int] IDENTITY(1,1) NOT NULL,
	[idPhong] [int] NULL,
	[tongTienDV] [float] NOT NULL,
	[trangThai] [bit] NULL,
	[thoiGianDat] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idHoaDonDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khachHang]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khachHang](
	[SDTKhachHang] [nvarchar](11) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[tienNo] [float] NULL,
	[tienSuDung] [float] NULL,
	[traSau] [bit] NULL,
	[ghiChu] [nvarchar](250) NULL,
	[tinhTrang] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SDTKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[loaiPhong]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loaiPhong](
	[idLoaiPhong] [int] IDENTITY(1,1) NOT NULL,
	[tenLoaiPhong] [nvarchar](30) NOT NULL,
	[giaGio] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhaCungCap]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhaCungCap](
	[idNhaCungCap] [int] IDENTITY(1,1) NOT NULL,
	[tenNhaCungCap] [nvarchar](100) NOT NULL,
	[SDTNhaCungCap] [nvarchar](11) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[tienNo] [float] NULL,
	[tinhTrang] [bit] NOT NULL,
 CONSTRAINT [PK__nhaCungC__178CA8074F932E16] PRIMARY KEY CLUSTERED 
(
	[idNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhanVien]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhanVien](
	[idNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[hoTenNhanVien] [nvarchar](50) NOT NULL,
	[CMND] [varchar](12) NOT NULL,
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
/****** Object:  Table [dbo].[phieuDatPhong]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuDatPhong](
	[idPhieuDatPhong] [int] IDENTITY(1,1) NOT NULL,
	[SDTKhachHang] [nvarchar](10) NOT NULL,
	[idPhong] [int] NOT NULL,
	[thoiGianDat] [int] NOT NULL,
	[ghiChu] [nvarchar](250) NULL,
	[tinhTrang] [bit] NOT NULL,
	[tenKhach] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhieuDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuNhapDichVu]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuNhapDichVu](
	[idPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[idNhaCungCap] [int] NOT NULL,
	[idNhanVien] [int] NULL,
	[thoiGianNhap] [datetime] NOT NULL,
	[tongTien] [float] NOT NULL,
	[tienNo] [float] NULL,
	[ghiChu] [nvarchar](250) NULL,
 CONSTRAINT [PK__phieuNha__11606EC6F3011038] PRIMARY KEY CLUSTERED 
(
	[idPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuThuePhong]    Script Date: 12/4/2021 11:04:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuThuePhong](
	[idPhieuThuePhong] [int] IDENTITY(1,1) NOT NULL,
	[SDTKhachHang] [nvarchar](10) NOT NULL,
	[idNhanVien] [int] NULL,
	[idPhong] [int] NULL,
	[thoiGianMo] [datetime] NOT NULL,
	[thoiGianDong] [datetime] NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[tinhTrang] [bit] NOT NULL,
	[giaNgayLe] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhieuThuePhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phong]    Script Date: 12/4/2021 11:04:10 PM ******/
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
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 1, 2, CAST(N'2021-11-28T15:50:26.130' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 1, 2, CAST(N'2021-11-28T15:50:28.460' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 1, 2, CAST(N'2021-11-28T15:50:30.027' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 2, 2, CAST(N'2021-11-28T16:00:04.150' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 2, 2, CAST(N'2021-11-28T16:00:05.953' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 5, 2, CAST(N'2021-11-28T21:49:59.773' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 5, 1, CAST(N'2021-11-28T21:50:10.970' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 6, 1, CAST(N'2021-11-29T00:05:48.763' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 6, 1, CAST(N'2021-11-29T00:05:50.123' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 7, 1, CAST(N'2021-11-29T00:10:26.107' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 7, 1, CAST(N'2021-11-29T00:10:26.863' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 7, 1, CAST(N'2021-11-29T00:10:28.723' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 6, 1, CAST(N'2021-11-29T01:03:41.953' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 6, 1, CAST(N'2021-11-29T09:35:39.003' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 8, 4, CAST(N'2021-11-29T09:43:11.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 8, 1, CAST(N'2021-11-29T09:43:21.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 8, 1, CAST(N'2021-11-29T09:43:39.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 9, 4, CAST(N'2021-11-29T09:51:10.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 9, 1, CAST(N'2021-11-29T09:51:11.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 9, 1, CAST(N'2021-11-29T09:51:11.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 9, 4, CAST(N'2021-11-29T09:51:12.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 10, 5, CAST(N'2021-11-29T09:59:36.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 11, 1, CAST(N'2021-12-04T10:41:16.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 10, 4, CAST(N'2021-12-04T16:07:27.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 10, 2, CAST(N'2021-12-04T16:11:49.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 2, 1, CAST(N'2021-11-28T16:00:08.010' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 3, 2, CAST(N'2021-11-28T16:02:49.217' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 3, 3, CAST(N'2021-11-28T16:02:51.130' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 4, 2, CAST(N'2021-11-28T16:08:57.823' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 4, 1, CAST(N'2021-11-28T16:26:07.057' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 4, 2, CAST(N'2021-11-28T16:27:16.957' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (2, 4, 1, CAST(N'2021-11-28T16:30:01.860' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 4, 2, CAST(N'2021-11-28T16:30:17.903' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 9, 1, CAST(N'2021-11-29T09:51:12.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 10, 4, CAST(N'2021-12-04T21:59:18.000' AS DateTime), 10000)
GO
SET IDENTITY_INSERT [dbo].[danhMuc] ON 

INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (1, N'Đồ uống', 1)
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (2, N'Bim bim', 1)
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (3, N'Thuốc lá', 1)
SET IDENTITY_INSERT [dbo].[danhMuc] OFF
GO
SET IDENTITY_INSERT [dbo].[dichVu] ON 

INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (1, 1, 1, N'Sting', 45, 10000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (2, 1, 1, N'Redbull', 48, 15000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (3, 2, 2, N'Oshi cay', 50, 10000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (4, 2, 2, N'Ostart cay', 46, 10000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (5, 3, 2, N'Thuốc ngựa', 50, 10000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (6, 3, 2, N'555', 52, 10000, 1)
SET IDENTITY_INSERT [dbo].[dichVu] OFF
GO
SET IDENTITY_INSERT [dbo].[donViTinh] ON 

INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (1, N'Chai', 1, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (2, N'Gói', 1, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (3, N'Thùng', 24, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (4, N'Lốc', 6, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (5, N'Lon', 1, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (6, N'Đĩa nhỏ', 1, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (7, N'Đĩa lớn', 2, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (8, N'Kg', 1, 1)
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (9, N'Lọ', 1, 1)
SET IDENTITY_INSERT [dbo].[donViTinh] OFF
GO
SET IDENTITY_INSERT [dbo].[giaNgayLe] ON 

INSERT [dbo].[giaNgayLe] ([idGiaNgayLe], [tenGia], [tinhTrang]) VALUES (1, N'5', 1)
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

INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (1, 1, 1, 3, 5333.333333333333, 60000, 65333.333333333336, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (2, 1, 2, 4, 0, 50000, 50000, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (3, 1, 3, 5, 0, 60000, 60000, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (4, 1, 5, 7, 184000, 40000, 224000, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (5, 1, 4, 6, 640000, 85000, 725000, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (6, 1, 7, 9, 0, 30000, 30000, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (7, 1, 6, 8, 777333.33333333326, 40000, 817333.33333333326, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (8, 1, 8, 10, 13333.333333333332, 60000, 73333.333333333328, 0, NULL)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (9, 1, 9, 11, 9653333.3333333321, 115000, 9768333.3333333321, 0, 500000)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (10, 1, 11, 14, 0, 10000, 10000, 0, 5000)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (11, 1, NULL, 15, 0, 0, 0, 0, 0)
SET IDENTITY_INSERT [dbo].[hoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[hoaDonDichVu] ON 

INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (1, 3, 60000, 0, CAST(N'2021-11-28T15:50:26.063' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (2, 1, 50000, 0, CAST(N'2021-11-28T16:00:04.103' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (3, 3, 60000, 0, CAST(N'2021-11-28T16:02:49.160' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (4, 3, 85000, 0, CAST(N'2021-11-28T16:08:57.777' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (5, 2, 40000, 0, CAST(N'2021-11-28T21:49:59.700' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (6, 1, 40000, 0, CAST(N'2021-11-29T00:05:48.707' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (7, 2, 30000, 0, CAST(N'2021-11-29T00:10:26.060' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (8, 2, 60000, 0, CAST(N'2021-11-29T09:43:11.287' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (9, 1, 115000, 0, CAST(N'2021-11-29T09:51:10.363' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (10, 2, 570000, 1, CAST(N'2021-11-29T09:59:36.750' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (11, 1, 10000, 0, CAST(N'2021-12-04T10:41:16.713' AS DateTime))
SET IDENTITY_INSERT [dbo].[hoaDonDichVu] OFF
GO
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'', N'', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0548666666', N'Kiên', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0941790508', N'Trần Tuấn Anh', 0, 999999, 1, N'không', 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0945454545', N'Đông', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0945852457', N'Nguyễn Văn Đạt', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0945858654', N'Anh hải', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0945878787', N'Trần Tuấn Đông', 100000, 1000000, 1, N'có', 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0946761636', N'Đông', 0, 0, 1, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0946857154', N'Kiên', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0958787878', N'Anhhhh', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0968574858', N'ANh', 0, 2000000, 0, N'không có', 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0968574859', N'Son', 0, 199999, 1, N'co', 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0984515847', N'Đông', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0985358541', N'Anh', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0985458745', N'Bác 3', 0, 0, 0, NULL, 1)
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0989568548', N'ĐÔng', 0, 0, 0, NULL, 1)
GO
SET IDENTITY_INSERT [dbo].[loaiPhong] ON 

INSERT [dbo].[loaiPhong] ([idLoaiPhong], [tenLoaiPhong], [giaGio]) VALUES (1, N'Phòng thường', 80000)
INSERT [dbo].[loaiPhong] ([idLoaiPhong], [tenLoaiPhong], [giaGio]) VALUES (2, N'Phòng vip', 150000)
SET IDENTITY_INSERT [dbo].[loaiPhong] OFF
GO
SET IDENTITY_INSERT [dbo].[nhanVien] ON 

INSERT [dbo].[nhanVien] ([idNhanVien], [hoTenNhanVien], [CMND], [soDienThoai], [diaChi], [gioiTinh], [email], [vertifyCode], [matKhau], [quyenHan], [trangThai], [ngaySinh], [ngayVaoLam]) VALUES (1, N'Nguyễn Sơn Núi', N'241546895', N'0946758585', N'bmt', N'Nam', N'dong123@gmail.com', N'123', N'123', N'ADMIN', N'on', CAST(N'1998-01-01' AS Date), CAST(N'2021-10-10' AS Date))
INSERT [dbo].[nhanVien] ([idNhanVien], [hoTenNhanVien], [CMND], [soDienThoai], [diaChi], [gioiTinh], [email], [vertifyCode], [matKhau], [quyenHan], [trangThai], [ngaySinh], [ngayVaoLam]) VALUES (2, N'Nguyễn Sơn Đổng', N'241541254', N'0965856525', N'Bmt', N'Nam', N'dong123@gmail.com', N'khong', N'123123', N'User', N'On', CAST(N'1997-11-12' AS Date), CAST(N'2021-11-09' AS Date))
SET IDENTITY_INSERT [dbo].[nhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuDatPhong] ON 

INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (1, N'0985458745', 1, 2, NULL, 0, N'Bác 3')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (2, N'0984515847', 2, 9, NULL, 0, N'Đông')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (3, N'0946761636', 2, 3, NULL, 0, N'Đông')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (4, N'0946761636', 2, 12, NULL, 1, N'Đông')
SET IDENTITY_INSERT [dbo].[phieuDatPhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuThuePhong] ON 

INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (3, N'0989568548', 1, 3, CAST(N'2021-11-28T15:50:09.937' AS DateTime), CAST(N'2021-11-28T15:54:57.990' AS DateTime), N'ĐÔng', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (4, N'0946857154', 1, 1, CAST(N'2021-11-28T15:59:58.087' AS DateTime), CAST(N'2021-11-28T16:00:20.190' AS DateTime), N'Kiên', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (5, N'0945858654', 1, 3, CAST(N'2021-11-28T16:02:44.567' AS DateTime), CAST(N'2021-11-28T16:02:57.483' AS DateTime), N'Anh hải', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (6, N'0985458745', 1, 3, CAST(N'2021-11-28T16:08:54.637' AS DateTime), CAST(N'2021-11-29T00:10:00.607' AS DateTime), N'Bác 3', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (7, N'0945454545', 1, 2, CAST(N'2021-11-28T21:48:46.713' AS DateTime), CAST(N'2021-11-29T00:07:54.517' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (8, N'0985458745', 1, 1, CAST(N'2021-11-29T00:03:31.147' AS DateTime), CAST(N'2021-11-29T09:46:33.333' AS DateTime), N'Bác 3', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (9, N'0985358541', 1, 2, CAST(N'2021-11-29T00:10:22.487' AS DateTime), CAST(N'2021-11-29T00:10:37.873' AS DateTime), N'Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (10, N'0945852457', 1, 2, CAST(N'2021-11-29T09:43:02.203' AS DateTime), CAST(N'2021-11-29T09:53:44.780' AS DateTime), N'Nguyễn Văn Đạt', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (11, N'0946761636', 1, 1, CAST(N'2021-11-29T09:51:02.930' AS DateTime), CAST(N'2021-12-04T10:31:58.497' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (12, N'0984515847', 1, 2, CAST(N'2021-11-29T09:55:29.037' AS DateTime), NULL, N'Đông', 1, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (13, N'0946761636', 1, 2, CAST(N'2021-11-29T10:00:16.450' AS DateTime), NULL, N'Đông', 1, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (14, N'0946761636', 1, 1, CAST(N'2021-12-04T10:41:12.570' AS DateTime), CAST(N'2021-12-04T10:41:36.540' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (15, N'0946761636', 1, 3, CAST(N'2021-12-04T11:41:24.160' AS DateTime), CAST(N'2021-12-04T11:41:35.413' AS DateTime), N'Đông', 0, 0)
SET IDENTITY_INSERT [dbo].[phieuThuePhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phong] ON 

INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (1, 1, N'Phòng 1', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (2, 1, N'Phòng 2', N'Đang hoạt động')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (3, 1, N'Phòng 3', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (4, 1, N'Phòng 4', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (5, 2, N'Phòng 5', N'Đang bảo trì')
SET IDENTITY_INSERT [dbo].[phong] OFF
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
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK__chiTietPh__idDon__440B1D61] FOREIGN KEY([idDonViTinh])
REFERENCES [dbo].[donViTinh] ([idDonViTinh])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap] CHECK CONSTRAINT [FK__chiTietPh__idDon__440B1D61]
GO
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK__chiTietPh__idPhi__44FF419A] FOREIGN KEY([idPhieuNhap])
REFERENCES [dbo].[phieuNhapDichVu] ([idPhieuNhap])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap] CHECK CONSTRAINT [FK__chiTietPh__idPhi__44FF419A]
GO
ALTER TABLE [dbo].[dichVu]  WITH CHECK ADD FOREIGN KEY([idDanhMuc])
REFERENCES [dbo].[danhMuc] ([idDanhMuc])
GO
ALTER TABLE [dbo].[dichVu]  WITH CHECK ADD  CONSTRAINT [FK__dichVu__idDonViT__46E78A0C] FOREIGN KEY([idDonViTinh])
REFERENCES [dbo].[donViTinh] ([idDonViTinh])
GO
ALTER TABLE [dbo].[dichVu] CHECK CONSTRAINT [FK__dichVu__idDonViT__46E78A0C]
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
ALTER TABLE [dbo].[phieuNhapDichVu]  WITH CHECK ADD  CONSTRAINT [FK__phieuNhap__idNha__4D94879B] FOREIGN KEY([idNhaCungCap])
REFERENCES [dbo].[nhaCungCap] ([idNhaCungCap])
GO
ALTER TABLE [dbo].[phieuNhapDichVu] CHECK CONSTRAINT [FK__phieuNhap__idNha__4D94879B]
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[nhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD FOREIGN KEY([idPhong])
REFERENCES [dbo].[phong] ([idPhong])
GO
ALTER TABLE [dbo].[phong]  WITH CHECK ADD FOREIGN KEY([idLoaiPhong])
REFERENCES [dbo].[loaiPhong] ([idLoaiPhong])
GO
USE [master]
GO
ALTER DATABASE [DuAn1] SET  READ_WRITE 
GO
