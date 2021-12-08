USE [master]
GO
/****** Object:  Database [DuAn1]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[chiTietDichVuSuDung]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[chiTietPhieuNhap]    Script Date: 12/5/2021 6:17:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietPhieuNhap](
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[idDichVu] [int] NOT NULL,
	[idDonViTinh] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaNhap] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danhMuc]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[dichVu]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[donViTinh]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[giaNgayLe]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[GioDatTruoc]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[hoaDon]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[hoaDonDichVu]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[khachHang]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[loaiPhong]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[nhaCungCap]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[nhanVien]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[phieuDatPhong]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[phieuNhapDichVu]    Script Date: 12/5/2021 6:17:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuNhapDichVu](
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[idNhaCungCap] [int] NOT NULL,
	[idNhanVien] [int] NULL,
	[thoiGianNhap] [datetime] NOT NULL,
	[tongTien] [float] NOT NULL,
	[tienNo] [float] NULL,
	[ghiChu] [nvarchar](250) NULL,
	[trangThai] [bit] NULL,
 CONSTRAINT [PK__phieuNha__11606EC6F3011038] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuThuePhong]    Script Date: 12/5/2021 6:17:49 PM ******/
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
/****** Object:  Table [dbo].[phong]    Script Date: 12/5/2021 6:17:49 PM ******/
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
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 12, 1, CAST(N'2021-12-05T14:30:26.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 12, 1, CAST(N'2021-12-05T14:30:27.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 12, 1, CAST(N'2021-12-05T14:30:30.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 12, 1, CAST(N'2021-12-05T14:30:31.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 15, 4, CAST(N'2021-12-05T15:11:57.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (40, 15, 1, CAST(N'2021-12-05T15:10:38.000' AS DateTime), 45000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 15, 2, CAST(N'2021-12-05T15:12:00.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 15, 1, CAST(N'2021-12-05T15:12:05.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 15, 20, CAST(N'2021-12-05T15:12:11.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 15, 1, CAST(N'2021-12-05T15:12:19.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 16, 24, CAST(N'2021-12-05T15:15:43.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 16, 2, CAST(N'2021-12-05T15:15:50.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 16, 2, CAST(N'2021-12-05T15:15:52.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 16, 2, CAST(N'2021-12-05T15:15:54.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 17, 1, CAST(N'2021-12-05T15:17:12.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 17, 1, CAST(N'2021-12-05T15:17:21.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (38, 17, 1, CAST(N'2021-12-05T15:17:40.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 18, 1, CAST(N'2021-12-05T15:25:57.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (10, 18, 4, CAST(N'2021-12-05T15:26:06.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 18, 12, CAST(N'2021-12-05T15:26:10.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (21, 21, 1, CAST(N'2021-12-05T15:26:45.000' AS DateTime), 110000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 21, 1, CAST(N'2021-12-05T15:27:06.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 22, 3, CAST(N'2021-12-05T15:28:56.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 22, 1, CAST(N'2021-12-05T15:28:58.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 23, 1, CAST(N'2021-12-05T15:29:44.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 23, 1, CAST(N'2021-12-05T15:29:47.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 24, 1, CAST(N'2021-12-05T15:37:15.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 24, 1, CAST(N'2021-12-05T15:37:17.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (21, 24, 1, CAST(N'2021-12-05T15:37:22.000' AS DateTime), 110000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 25, 1, CAST(N'2021-12-05T15:37:38.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 25, 1, CAST(N'2021-12-05T15:37:45.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 26, 1, CAST(N'2021-12-05T15:38:11.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (7, 26, 1, CAST(N'2021-12-05T15:38:13.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 26, 1, CAST(N'2021-12-05T15:38:15.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 27, 1, CAST(N'2021-12-05T15:38:41.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 27, 1, CAST(N'2021-12-05T15:38:45.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 28, 24, CAST(N'2021-12-05T15:43:24.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (22, 28, 1, CAST(N'2021-12-05T15:43:27.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 28, 1, CAST(N'2021-12-05T15:43:32.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 31, 1, CAST(N'2021-12-05T15:43:46.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 31, 1, CAST(N'2021-12-05T15:43:48.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 31, 10, CAST(N'2021-12-05T15:43:49.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 34, 1, CAST(N'2021-12-05T15:44:50.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 34, 1, CAST(N'2021-12-05T15:44:52.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (10, 34, 5, CAST(N'2021-12-05T15:44:53.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 34, 11, CAST(N'2021-12-05T15:44:55.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 36, 1, CAST(N'2021-12-05T16:54:46.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 36, 9, CAST(N'2021-12-05T16:54:49.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 36, 1, CAST(N'2021-12-05T16:54:57.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 37, 1, CAST(N'2021-12-05T16:55:11.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 35, 1, CAST(N'2021-12-05T16:56:21.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (33, 42, 1, CAST(N'2021-12-05T16:59:35.000' AS DateTime), 40000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 42, 1, CAST(N'2021-12-05T16:59:38.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 43, 1, CAST(N'2021-12-05T17:00:00.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 43, 1, CAST(N'2021-12-05T17:00:02.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 44, 15, CAST(N'2021-12-05T17:00:19.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 44, 1, CAST(N'2021-12-05T17:00:21.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 45, 1, CAST(N'2021-12-05T17:02:47.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 45, 1, CAST(N'2021-12-05T17:02:56.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 46, 20, CAST(N'2021-12-05T17:03:13.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (7, 47, 1, CAST(N'2021-12-05T17:03:29.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 47, 1, CAST(N'2021-12-05T17:03:30.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 47, 1, CAST(N'2021-12-05T17:03:32.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 48, 1, CAST(N'2021-12-05T17:04:07.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 49, 1, CAST(N'2021-12-05T17:12:03.000' AS DateTime), 80000)
GO
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 49, 1, CAST(N'2021-12-05T17:12:03.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (37, 49, 1, CAST(N'2021-12-05T17:12:07.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 50, 3, CAST(N'2021-12-05T17:12:21.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 51, 1, CAST(N'2021-12-05T17:12:52.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (37, 51, 1, CAST(N'2021-12-05T17:13:01.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (35, 51, 1, CAST(N'2021-12-05T17:13:03.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (37, 52, 1, CAST(N'2021-12-05T17:13:58.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 52, 1, CAST(N'2021-12-05T17:13:58.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (30, 52, 1, CAST(N'2021-12-05T17:14:00.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (13, 53, 2, CAST(N'2021-12-05T17:15:10.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 53, 12, CAST(N'2021-12-05T17:15:12.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 53, 1, CAST(N'2021-12-05T17:15:13.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 53, 1, CAST(N'2021-12-05T17:15:14.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 53, 1, CAST(N'2021-12-05T17:15:19.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 54, 1, CAST(N'2021-12-05T17:15:47.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 54, 1, CAST(N'2021-12-05T17:15:48.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 54, 1, CAST(N'2021-12-05T17:15:50.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 56, 12, CAST(N'2021-12-05T17:16:21.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (22, 56, 1, CAST(N'2021-12-05T17:16:23.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 56, 1, CAST(N'2021-12-05T17:16:24.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (21, 57, 1, CAST(N'2021-12-05T17:16:44.000' AS DateTime), 110000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 57, 12, CAST(N'2021-12-05T17:16:45.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 59, 1, CAST(N'2021-12-05T17:18:25.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 59, 15, CAST(N'2021-12-05T17:18:28.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 59, 1, CAST(N'2021-12-05T17:18:31.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (33, 60, 1, CAST(N'2021-12-05T17:18:49.000' AS DateTime), 40000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 60, 15, CAST(N'2021-12-05T17:18:52.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 61, 1, CAST(N'2021-12-05T17:19:09.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 61, 1, CAST(N'2021-12-05T17:19:11.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (35, 61, 1, CAST(N'2021-12-05T17:19:31.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 58, 1, CAST(N'2021-12-05T17:19:41.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (30, 58, 1, CAST(N'2021-12-05T17:19:42.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 58, 1, CAST(N'2021-12-05T17:19:45.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (30, 62, 1, CAST(N'2021-12-05T17:21:09.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (33, 62, 1, CAST(N'2021-12-05T17:21:11.000' AS DateTime), 40000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 64, 24, CAST(N'2021-12-05T17:22:18.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 64, 1, CAST(N'2021-12-05T17:22:19.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 64, 1, CAST(N'2021-12-05T17:22:22.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (39, 64, 1, CAST(N'2021-12-05T17:22:25.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 67, 1, CAST(N'2021-12-05T17:22:52.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (12, 67, 2, CAST(N'2021-12-05T17:22:56.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 68, 1, CAST(N'2021-12-05T17:28:48.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (7, 68, 1, CAST(N'2021-12-05T17:28:49.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 68, 3, CAST(N'2021-12-05T17:28:51.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 68, 1, CAST(N'2021-12-05T17:28:57.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 69, 1, CAST(N'2021-12-05T17:29:23.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 69, 1, CAST(N'2021-12-05T17:29:25.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 69, 15, CAST(N'2021-12-05T17:29:28.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 69, 1, CAST(N'2021-12-05T17:29:32.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 70, 1, CAST(N'2021-12-05T17:29:50.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 70, 10, CAST(N'2021-12-05T17:29:55.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 70, 1, CAST(N'2021-12-05T17:29:57.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 70, 1, CAST(N'2021-12-05T17:29:59.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 71, 1, CAST(N'2021-12-05T17:30:27.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 71, 18, CAST(N'2021-12-05T17:30:34.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 72, 1, CAST(N'2021-12-05T17:32:03.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (35, 72, 1, CAST(N'2021-12-05T17:32:05.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (39, 72, 1, CAST(N'2021-12-05T17:32:06.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 73, 15, CAST(N'2021-12-05T17:32:35.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 73, 1, CAST(N'2021-12-05T17:32:37.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 73, 1, CAST(N'2021-12-05T17:32:41.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 74, 1, CAST(N'2021-12-05T17:33:04.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 74, 1, CAST(N'2021-12-05T17:33:04.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 74, 1, CAST(N'2021-12-05T17:33:10.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 75, 1, CAST(N'2021-12-05T17:33:21.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (17, 75, 24, CAST(N'2021-12-05T17:33:32.000' AS DateTime), 11000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 76, 1, CAST(N'2021-12-05T17:35:03.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 76, 1, CAST(N'2021-12-05T17:35:06.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 76, 1, CAST(N'2021-12-05T17:35:07.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 77, 1, CAST(N'2021-12-05T17:35:48.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 77, 1, CAST(N'2021-12-05T17:35:50.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (39, 77, 1, CAST(N'2021-12-05T17:35:53.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 77, 1, CAST(N'2021-12-05T17:36:00.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (13, 78, 3, CAST(N'2021-12-05T17:36:20.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 78, 1, CAST(N'2021-12-05T17:36:21.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (22, 78, 1, CAST(N'2021-12-05T17:36:22.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 78, 1, CAST(N'2021-12-05T17:36:23.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 78, 1, CAST(N'2021-12-05T17:36:25.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 78, 1, CAST(N'2021-12-05T17:36:27.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 79, 1, CAST(N'2021-12-05T17:36:40.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 79, 1, CAST(N'2021-12-05T17:36:42.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 79, 1, CAST(N'2021-12-05T17:36:43.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 79, 3, CAST(N'2021-12-05T17:36:50.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 80, 1, CAST(N'2021-12-05T17:40:07.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 80, 10, CAST(N'2021-12-05T17:40:11.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 80, 2, CAST(N'2021-12-05T17:40:16.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (33, 81, 1, CAST(N'2021-12-05T17:40:33.000' AS DateTime), 40000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 81, 1, CAST(N'2021-12-05T17:40:35.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 82, 1, CAST(N'2021-12-05T17:41:48.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 83, 1, CAST(N'2021-12-05T17:42:01.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 83, 1, CAST(N'2021-12-05T17:42:04.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (17, 83, 13, CAST(N'2021-12-05T17:42:07.000' AS DateTime), 11000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 84, 1, CAST(N'2021-12-05T18:05:02.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 84, 1, CAST(N'2021-12-05T18:05:03.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 84, 1, CAST(N'2021-12-05T18:05:09.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 84, 1, CAST(N'2021-12-05T18:05:10.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 84, 4, CAST(N'2021-12-05T18:05:11.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 85, 1, CAST(N'2021-12-05T18:05:24.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 85, 1, CAST(N'2021-12-05T18:05:26.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 85, 1, CAST(N'2021-12-05T18:05:29.000' AS DateTime), 120000)
GO
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 85, 1, CAST(N'2021-12-05T18:05:30.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 89, 1, CAST(N'2021-12-05T18:05:48.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 89, 1, CAST(N'2021-12-05T18:05:51.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 89, 15, CAST(N'2021-12-05T18:05:53.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 89, 1, CAST(N'2021-12-05T18:05:55.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 90, 1, CAST(N'2021-12-05T18:06:13.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 90, 18, CAST(N'2021-12-05T18:06:15.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 90, 1, CAST(N'2021-12-05T18:06:17.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (10, 15, 4, CAST(N'2021-12-05T15:12:06.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 18, 1, CAST(N'2021-12-05T15:26:08.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 26, 10, CAST(N'2021-12-05T15:38:18.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 31, 1, CAST(N'2021-12-05T15:43:54.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 37, 1, CAST(N'2021-12-05T16:55:14.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (30, 40, 1, CAST(N'2021-12-05T16:55:45.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 35, 10, CAST(N'2021-12-05T16:56:06.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 44, 1, CAST(N'2021-12-05T17:00:14.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (7, 45, 1, CAST(N'2021-12-05T17:02:50.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 46, 1, CAST(N'2021-12-05T17:03:12.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (12, 53, 2, CAST(N'2021-12-05T17:15:11.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 56, 1, CAST(N'2021-12-05T17:16:25.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 60, 2, CAST(N'2021-12-05T17:18:56.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (38, 62, 1, CAST(N'2021-12-05T17:21:14.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 68, 1, CAST(N'2021-12-05T17:28:59.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (30, 69, 1, CAST(N'2021-12-05T17:29:24.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 70, 1, CAST(N'2021-12-05T17:29:53.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (30, 71, 1, CAST(N'2021-12-05T17:30:28.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 71, 1, CAST(N'2021-12-05T17:30:29.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 72, 1, CAST(N'2021-12-05T17:31:59.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 72, 1, CAST(N'2021-12-05T17:32:18.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (12, 73, 1, CAST(N'2021-12-05T17:32:33.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 75, 1, CAST(N'2021-12-05T17:33:26.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 79, 1, CAST(N'2021-12-05T17:36:48.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 81, 1, CAST(N'2021-12-05T17:40:34.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 84, 1, CAST(N'2021-12-05T18:05:06.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 85, 1, CAST(N'2021-12-05T18:05:33.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 90, 1, CAST(N'2021-12-05T18:06:18.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (36, 90, 1, CAST(N'2021-12-05T18:06:19.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 15, 1, CAST(N'2021-12-05T15:12:13.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (33, 17, 1, CAST(N'2021-12-05T15:17:14.000' AS DateTime), 40000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 41, 20, CAST(N'2021-12-05T16:59:01.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 46, 1, CAST(N'2021-12-05T17:03:16.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 54, 1, CAST(N'2021-12-05T17:15:49.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 57, 1, CAST(N'2021-12-05T17:16:39.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (13, 57, 5, CAST(N'2021-12-05T17:16:46.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (37, 63, 1, CAST(N'2021-12-05T17:21:47.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 73, 1, CAST(N'2021-12-05T17:32:31.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 84, 20, CAST(N'2021-12-05T18:05:00.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 84, 1, CAST(N'2021-12-05T18:05:07.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 15, 1, CAST(N'2021-12-05T15:12:15.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 15, 1, CAST(N'2021-12-05T15:12:17.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 16, 2, CAST(N'2021-12-05T15:15:46.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (7, 18, 1, CAST(N'2021-12-05T15:26:02.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 21, 10, CAST(N'2021-12-05T15:26:43.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 22, 1, CAST(N'2021-12-05T15:29:11.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 26, 1, CAST(N'2021-12-05T15:38:09.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 27, 10, CAST(N'2021-12-05T15:39:04.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 28, 1, CAST(N'2021-12-05T15:43:26.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (12, 31, 3, CAST(N'2021-12-05T15:43:51.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 36, 1, CAST(N'2021-12-05T16:54:32.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 35, 1, CAST(N'2021-12-05T16:56:04.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 43, 20, CAST(N'2021-12-05T16:59:52.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 44, 1, CAST(N'2021-12-05T17:00:16.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 49, 1, CAST(N'2021-12-05T17:12:05.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 52, 1, CAST(N'2021-12-05T17:14:01.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 57, 1, CAST(N'2021-12-05T17:16:48.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 59, 1, CAST(N'2021-12-05T17:18:25.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 60, 1, CAST(N'2021-12-05T17:18:48.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 58, 12, CAST(N'2021-12-05T17:19:46.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 62, 1, CAST(N'2021-12-05T17:21:06.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 64, 1, CAST(N'2021-12-05T17:22:21.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (12, 69, 3, CAST(N'2021-12-05T17:29:29.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 70, 1, CAST(N'2021-12-05T17:30:00.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 74, 20, CAST(N'2021-12-05T17:33:08.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 76, 1, CAST(N'2021-12-05T17:35:02.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 77, 1, CAST(N'2021-12-05T17:35:47.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 80, 1, CAST(N'2021-12-05T17:40:10.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 80, 1, CAST(N'2021-12-05T17:40:13.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 84, 1, CAST(N'2021-12-05T18:05:04.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 85, 1, CAST(N'2021-12-05T18:05:32.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 17, 1, CAST(N'2021-12-05T15:17:13.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 17, 3, CAST(N'2021-12-05T15:18:39.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 22, 10, CAST(N'2021-12-05T15:29:07.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 22, 1, CAST(N'2021-12-05T15:29:09.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 25, 1, CAST(N'2021-12-05T15:37:41.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (13, 27, 4, CAST(N'2021-12-05T15:38:44.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 27, 1, CAST(N'2021-12-05T15:38:51.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 33, 1, CAST(N'2021-12-05T15:44:26.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (17, 40, 6, CAST(N'2021-12-05T16:55:30.000' AS DateTime), 11000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 40, 1, CAST(N'2021-12-05T16:55:43.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 35, 1, CAST(N'2021-12-05T16:56:08.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 44, 1, CAST(N'2021-12-05T17:00:13.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 45, 4, CAST(N'2021-12-05T17:02:52.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 48, 1, CAST(N'2021-12-05T17:03:54.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (22, 60, 1, CAST(N'2021-12-05T17:18:51.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 60, 1, CAST(N'2021-12-05T17:18:54.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 61, 12, CAST(N'2021-12-05T17:19:12.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 62, 1, CAST(N'2021-12-05T17:21:10.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (39, 62, 1, CAST(N'2021-12-05T17:21:13.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 63, 20, CAST(N'2021-12-05T17:21:52.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 67, 11, CAST(N'2021-12-05T17:22:54.000' AS DateTime), 8000)
GO
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (21, 68, 1, CAST(N'2021-12-05T17:28:56.000' AS DateTime), 110000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (25, 69, 1, CAST(N'2021-12-05T17:29:26.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (7, 72, 1, CAST(N'2021-12-05T17:32:17.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 73, 1, CAST(N'2021-12-05T17:32:36.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 75, 1, CAST(N'2021-12-05T17:33:24.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 79, 12, CAST(N'2021-12-05T17:36:45.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (12, 79, 3, CAST(N'2021-12-05T17:36:47.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (10, 17, 3, CAST(N'2021-12-05T15:17:27.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (22, 18, 1, CAST(N'2021-12-05T15:26:14.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 25, 1, CAST(N'2021-12-05T15:37:40.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 25, 15, CAST(N'2021-12-05T15:37:43.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 26, 1, CAST(N'2021-12-05T15:38:11.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 27, 1, CAST(N'2021-12-05T15:38:55.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 33, 1, CAST(N'2021-12-05T15:44:27.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 37, 20, CAST(N'2021-12-05T16:55:16.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 41, 1, CAST(N'2021-12-05T16:58:49.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (22, 42, 1, CAST(N'2021-12-05T16:59:31.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 43, 1, CAST(N'2021-12-05T16:59:53.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 46, 1, CAST(N'2021-12-05T17:03:11.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 50, 1, CAST(N'2021-12-05T17:12:25.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 51, 1, CAST(N'2021-12-05T17:12:58.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 53, 1, CAST(N'2021-12-05T17:15:17.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 56, 1, CAST(N'2021-12-05T17:16:26.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (21, 59, 1, CAST(N'2021-12-05T17:18:30.000' AS DateTime), 110000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 59, 1, CAST(N'2021-12-05T17:18:33.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (36, 63, 1, CAST(N'2021-12-05T17:21:46.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 64, 1, CAST(N'2021-12-05T17:22:28.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 73, 1, CAST(N'2021-12-05T17:32:38.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (21, 74, 1, CAST(N'2021-12-05T17:33:07.000' AS DateTime), 110000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 75, 1, CAST(N'2021-12-05T17:33:20.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 75, 1, CAST(N'2021-12-05T17:33:22.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 75, 1, CAST(N'2021-12-05T17:33:28.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 76, 15, CAST(N'2021-12-05T17:35:01.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 80, 1, CAST(N'2021-12-05T17:40:08.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 81, 1, CAST(N'2021-12-05T17:40:36.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 82, 1, CAST(N'2021-12-05T17:41:50.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 83, 1, CAST(N'2021-12-05T17:42:03.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 85, 1, CAST(N'2021-12-05T18:05:25.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 17, 1, CAST(N'2021-12-05T15:17:45.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 18, 1, CAST(N'2021-12-05T15:26:03.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 21, 1, CAST(N'2021-12-05T15:26:47.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 23, 1, CAST(N'2021-12-05T15:29:49.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 24, 1, CAST(N'2021-12-05T15:37:20.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 35, 1, CAST(N'2021-12-05T16:56:03.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (6, 41, 1, CAST(N'2021-12-05T16:58:51.000' AS DateTime), 27000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 41, 1, CAST(N'2021-12-05T16:59:04.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 42, 1, CAST(N'2021-12-05T16:59:32.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 43, 1, CAST(N'2021-12-05T16:59:55.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 47, 12, CAST(N'2021-12-05T17:03:43.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 48, 10, CAST(N'2021-12-05T17:03:52.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (39, 48, 1, CAST(N'2021-12-05T17:04:00.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (35, 48, 1, CAST(N'2021-12-05T17:04:03.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 49, 6, CAST(N'2021-12-05T17:12:10.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (21, 50, 1, CAST(N'2021-12-05T17:12:24.000' AS DateTime), 110000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 51, 17, CAST(N'2021-12-05T17:12:54.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (36, 52, 1, CAST(N'2021-12-05T17:13:57.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 52, 10, CAST(N'2021-12-05T17:14:03.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 54, 12, CAST(N'2021-12-05T17:15:52.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 59, 1, CAST(N'2021-12-05T17:18:34.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (33, 58, 1, CAST(N'2021-12-05T17:19:41.000' AS DateTime), 40000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 64, 1, CAST(N'2021-12-05T17:22:23.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 67, 1, CAST(N'2021-12-05T17:22:51.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 68, 10, CAST(N'2021-12-05T17:28:54.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 71, 1, CAST(N'2021-12-05T17:30:31.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (22, 83, 1, CAST(N'2021-12-05T17:42:05.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 85, 1, CAST(N'2021-12-05T18:05:27.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 89, 1, CAST(N'2021-12-05T18:05:49.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (3, 90, 1, CAST(N'2021-12-05T18:06:12.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (1, 21, 1, CAST(N'2021-12-05T15:26:49.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (9, 22, 1, CAST(N'2021-12-05T15:29:03.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 23, -2, CAST(N'2021-12-05T15:29:51.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (8, 23, 1, CAST(N'2021-12-05T15:29:54.000' AS DateTime), 20000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 24, 1, CAST(N'2021-12-05T15:37:24.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 28, 1, CAST(N'2021-12-05T15:43:30.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 31, 1, CAST(N'2021-12-05T15:43:56.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (30, 33, 1, CAST(N'2021-12-05T15:44:29.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (18, 33, 20, CAST(N'2021-12-05T15:44:33.000' AS DateTime), 8000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (31, 36, 1, CAST(N'2021-12-05T16:55:04.000' AS DateTime), 30000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 37, 1, CAST(N'2021-12-05T16:55:12.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 42, 12, CAST(N'2021-12-05T16:59:41.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 45, 1, CAST(N'2021-12-05T17:02:54.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (36, 48, 1, CAST(N'2021-12-05T17:03:59.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 50, 10, CAST(N'2021-12-05T17:12:23.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 60, 1, CAST(N'2021-12-05T17:18:47.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 62, 10, CAST(N'2021-12-05T17:21:04.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 63, 1, CAST(N'2021-12-05T17:21:50.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (20, 69, 1, CAST(N'2021-12-05T17:29:27.000' AS DateTime), 160000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 70, 1, CAST(N'2021-12-05T17:29:56.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (23, 71, 1, CAST(N'2021-12-05T17:30:32.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 78, 12, CAST(N'2021-12-05T17:36:19.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (36, 80, 1, CAST(N'2021-12-05T17:40:17.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 89, 1, CAST(N'2021-12-05T18:05:48.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (13, 90, 1, CAST(N'2021-12-05T18:06:14.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (19, 40, 1, CAST(N'2021-12-05T16:55:31.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 40, 1, CAST(N'2021-12-05T16:55:44.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 48, 1, CAST(N'2021-12-05T17:03:54.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (24, 51, 1, CAST(N'2021-12-05T17:12:51.000' AS DateTime), 150000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (36, 51, 1, CAST(N'2021-12-05T17:13:02.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 53, 1, CAST(N'2021-12-05T17:15:16.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 57, 1, CAST(N'2021-12-05T17:16:47.000' AS DateTime), 10000)
GO
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 61, 1, CAST(N'2021-12-05T17:19:28.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (26, 58, 1, CAST(N'2021-12-05T17:19:44.000' AS DateTime), 80000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (39, 63, 1, CAST(N'2021-12-05T17:21:47.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (29, 63, 1, CAST(N'2021-12-05T17:21:49.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 67, 1, CAST(N'2021-12-05T17:22:51.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 67, 1, CAST(N'2021-12-05T17:22:58.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (28, 68, 1, CAST(N'2021-12-05T17:28:57.000' AS DateTime), 35000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (4, 70, 1, CAST(N'2021-12-05T17:29:49.000' AS DateTime), 10000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (11, 70, 3, CAST(N'2021-12-05T17:29:54.000' AS DateTime), 15000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (17, 72, 18, CAST(N'2021-12-05T17:31:54.000' AS DateTime), 11000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (5, 73, 1, CAST(N'2021-12-05T17:32:32.000' AS DateTime), 18000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (27, 76, 1, CAST(N'2021-12-05T17:35:05.000' AS DateTime), 120000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 77, 16, CAST(N'2021-12-05T17:36:08.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (34, 79, 1, CAST(N'2021-12-05T17:36:41.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (16, 81, 10, CAST(N'2021-12-05T17:40:37.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (15, 82, 12, CAST(N'2021-12-05T17:41:47.000' AS DateTime), 9000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (32, 82, 1, CAST(N'2021-12-05T17:41:51.000' AS DateTime), 25000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (35, 82, 1, CAST(N'2021-12-05T17:41:52.000' AS DateTime), 55000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (14, 85, 23, CAST(N'2021-12-05T18:05:28.000' AS DateTime), 12000)
INSERT [dbo].[chiTietDichVuSuDung] ([idDichVu], [idHoaDonDichVu], [soLuong], [gioSuDung], [gia]) VALUES (40, 90, 1, CAST(N'2021-12-05T18:06:20.000' AS DateTime), 35000)
GO
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 1, 1, 1, 180000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 2, 1, 1, 180000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 5, 10, 1, 360000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 1, 3, 3, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 2, 3, 3, 10000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 3, 2, 30, 3000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 14, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 18, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 11, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 12, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 13, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 13, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 15, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 11, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 15, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 16, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 17, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 23, 8, 15, 80000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 21, 8, 15, 80000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 12, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 17, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 18, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 14, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 16, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 17, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 10, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 16, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 10, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 18, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 22, 8, 15, 80000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 10, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 11, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 21, 8, 15, 80000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN123', 14, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 10, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 12, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 13, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 14, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 13, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 16, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 14, 8, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN003', 11, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN002', 12, 3, 15, 8000)
INSERT [dbo].[chiTietPhieuNhap] ([maPhieuNhap], [idDichVu], [idDonViTinh], [soLuong], [giaNhap]) VALUES (N'PN001', 15, 3, 15, 8000)
GO
SET IDENTITY_INSERT [dbo].[danhMuc] ON 

INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (1, N'Đồ uống', 1)
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (2, N'Bim bim', 1)
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (3, N'Thuốc lá', 1)
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (4, N'Đồ khô', 1)
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (5, N'Đồ ăn', 1)
INSERT [dbo].[danhMuc] ([idDanhMuc], [tenDanhMuc], [tinhTrang]) VALUES (6, N'Trái cây', 1)
SET IDENTITY_INSERT [dbo].[danhMuc] OFF
GO
SET IDENTITY_INSERT [dbo].[dichVu] ON 

INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (1, 1, 1, N'Sting', 150, 15000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (2, 1, 1, N'Redbull', 120, 15000, 0)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (3, 2, 2, N'Oshi cay', 124, 10000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (4, 2, 2, N'Ostart cay', 38, 10000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (5, 3, 2, N'Thuốc ngựa', 50, 18000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (6, 3, 2, N'Thuốc 555', 41, 27000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (7, 1, 5, N'Redbull', 34, 18000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (8, 3, 2, N'Thuốc Jet', 48, 20000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (9, 3, 2, N'Thuốc Craven', 39, 20000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (10, 1, 5, N'Pepsi', 2091, 15000, 0)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (11, 1, 5, N'Pepsi', 2076, 15000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (12, 1, 5, N'Cocacola', 1726, 15000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (13, 1, 5, N'Milinda', 1725, 12000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (14, 1, 5, N'Bia Heineken', 2184, 12000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (15, 1, 5, N'Bia SaiGon', 1356, 9000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (16, 1, 5, N'Bia Hà Nội', 2078, 9000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (17, 1, 5, N'Bia Tiger', 1519, 11000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (18, 1, 5, N'Bia Larue', 1415, 8000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (19, 4, 6, N'Mực khô', 35, 120000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (20, 4, 7, N'Mực khô', 41, 160000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (21, 4, 6, N'Bò khô', 73, 110000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (22, 4, 6, N'Gà khô', 58, 120000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (23, 4, 7, N'Gà khô', 57, 150000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (24, 4, 7, N'Nai khô', 9, 150000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (25, 4, 6, N'Nai khô', 8, 120000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (26, 6, 6, N'Trái cây dĩa', 35, 80000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (27, 6, 7, N'Trái cây dĩa', 19, 120000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (28, 4, 2, N'Hạt dẽ', 31, 35000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (29, 6, 6, N'Cóc ngâm', 39, 25000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (30, 6, 7, N'Cóc ngâm', 43, 30000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (31, 6, 7, N'Xoài ngâm', 40, 30000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (32, 6, 6, N'Xoài ngâm', 42, 25000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (33, 5, 6, N'Mỳ xào', 45, 40000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (34, 5, 7, N'Mỳ xào', 43, 55000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (35, 5, 7, N'Mỳ xào', 45, 55000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (36, 2, 2, N'Oxi Bí đỏ', 44, 10000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (37, 4, 2, N'Hạt dưa', 46, 15000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (38, 4, 2, N'Hạt dưa', 49, 15000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (39, 5, 6, N'Cơm chiên', 44, 35000, 1)
INSERT [dbo].[dichVu] ([idDichVu], [idDanhMuc], [idDonViTinh], [tenDichVu], [soLuongCon], [gia], [tinhTrang]) VALUES (40, 5, 6, N'Cơm chiên', 49, 35000, 1)
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
INSERT [dbo].[donViTinh] ([idDonViTinh], [tenDonVi], [giaTri], [tinhTrang]) VALUES (10, N'Cây Thuốc', 10, 1)
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
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (12, 1, 12, 17, 1208000, 40000, 1248000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (13, 1, 10, 13, 11880000, 160000, 12040000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (14, 1, 15, 18, 12000, 769000, 781000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (15, 1, 16, 19, 1400, 938000, 939400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (16, 1, 17, 20, 4200, 336000, 340200, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (17, 1, 18, 24, 0, 346000, 346000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (18, 1, 21, 23, 1400, 355000, 356400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (19, 1, 22, 22, 5600, 405000, 410600, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (20, 1, 23, 21, 8000, 242000, 250000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (21, 1, 24, 25, 4000, 232000, 236000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (22, 1, 25, 26, 5600, 472000, 477600, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (23, 1, 26, 27, 5600, 163000, 168600, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (24, 1, 27, 28, 5600, 411000, 416600, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (25, 1, 28, 29, 4000, 571000, 575000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (26, 1, 31, 30, 4200, 560000, 564200, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (27, 1, 33, 31, 4200, 420000, 424200, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (28, 1, 34, 34, 4200, 347000, 351200, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (29, 1, 36, 38, 0, 318000, 318000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (30, 1, 37, 36, 2800, 300000, 302800, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (31, 1, 40, 37, 2800, 371000, 373800, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (32, 1, 35, 35, 4000, 395000, 399000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (33, 1, 41, 43, 0, 402000, 402000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (34, 1, 42, 42, 1400, 448000, 449400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (35, 1, 43, 41, 2800, 400000, 402800, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (36, 1, 44, 40, 4000, 335000, 339000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (37, 1, 45, 47, 0, 328000, 328000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (38, 1, 46, 46, 0, 430000, 430000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (39, 1, 47, 44, 1400, 261000, 262400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (40, 1, 48, 45, 2800, 345000, 347800, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (41, 1, 49, 51, 0, 235000, 235000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (42, 1, 50, 50, 1400, 395000, 396400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (43, 1, 51, 49, 2800, 536000, 538800, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (44, 1, 52, 48, 4000, 320000, 324000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (45, 1, 53, 55, 0, 627000, 627000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (46, 1, 54, 54, 1400, 408000, 409400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (47, 1, 56, 52, 2700, 493000, 495700, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (48, 1, 57, 53, 2800, 383000, 385800, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (49, 1, 59, 59, 0, 603000, 603000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (50, 1, 60, 58, 0, 545000, 545000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (51, 1, 61, 57, 1400, 273000, 274400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (52, 1, 58, 56, 2700, 433000, 435700, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (53, 1, 62, 63, 0, 450000, 450000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (54, 1, 63, 62, 1400, 415000, 416400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (55, 1, 64, 61, 2800, 656000, 658800, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (56, 1, 67, 60, 2700, 441000, 443700, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (57, 1, 68, 64, 1400, 460000, 461400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (58, 1, 69, 65, 1400, 573000, 574400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (59, 1, 70, 66, 1400, 513000, 514400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (60, 1, 71, 67, 1400, 469000, 470400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (61, 1, 72, 71, 0, 506000, 506000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (62, 1, 73, 69, 1400, 633000, 634400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (63, 1, 74, 70, 1400, 510000, 511400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (64, 1, 75, 68, 2700, 604000, 606700, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (65, 1, 76, 75, 0, 570000, 570000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (66, 1, 77, 74, 1400, 564000, 565400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (67, 1, 78, 72, 2700, 625000, 627700, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (68, 1, 79, 73, 2700, 528000, 530700, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (69, 1, 80, 79, 0, 578000, 578000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (70, 1, 81, 78, 1400, 340000, 341400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (71, 1, 82, 77, 2700, 468000, 470700, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (72, 1, 83, 76, 4000, 428000, 432000, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (73, 1, 84, 80, 1400, 687000, 688400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (74, 1, 85, 81, 1400, 724000, 725400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (75, 1, 89, 82, 1400, 505000, 506400, 0, 0)
INSERT [dbo].[hoaDon] ([idHoaDon], [idNhanVien], [idHoaDonDichVu], [idPhieuThuePhong], [tienPhong], [tienDichVu], [tongTien], [phuThu], [tienNo]) VALUES (76, 1, 90, 83, 1400, 406000, 407400, 0, 0)
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
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (10, 2, 160000, 0, CAST(N'2021-11-29T09:59:36.750' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (11, 1, 10000, 0, CAST(N'2021-12-04T10:41:16.713' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (12, 1, 40000, 0, CAST(N'2021-12-05T14:30:26.343' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (15, 1, 769000, 0, CAST(N'2021-12-05T15:03:22.917' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (16, 3, 938000, 0, CAST(N'2021-12-05T15:13:53.543' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (17, 1, 336000, 0, CAST(N'2021-12-05T15:17:04.840' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (18, 4, 346000, 0, CAST(N'2021-12-05T15:25:54.443' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (21, 3, 355000, 0, CAST(N'2021-12-05T15:26:43.883' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (22, 2, 405000, 0, CAST(N'2021-12-05T15:28:55.983' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (23, 1, 242000, 0, CAST(N'2021-12-05T15:29:44.693' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (24, 1, 232000, 0, CAST(N'2021-12-05T15:37:14.987' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (25, 2, 472000, 0, CAST(N'2021-12-05T15:37:38.783' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (26, 3, 163000, 0, CAST(N'2021-12-05T15:38:09.547' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (27, 4, 411000, 0, CAST(N'2021-12-05T15:38:41.900' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (28, 1, 571000, 0, CAST(N'2021-12-05T15:43:24.703' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (31, 2, 560000, 0, CAST(N'2021-12-05T15:43:46.747' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (33, 3, 420000, 0, CAST(N'2021-12-05T15:44:26.547' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (34, 4, 347000, 0, CAST(N'2021-12-05T15:44:50.490' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (35, 1, 395000, 0, CAST(N'2021-12-05T15:46:04.960' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (36, 4, 318000, 0, CAST(N'2021-12-05T16:54:32.413' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (37, 2, 300000, 0, CAST(N'2021-12-05T16:55:11.350' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (40, 3, 371000, 0, CAST(N'2021-12-05T16:55:30.830' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (41, 4, 402000, 0, CAST(N'2021-12-05T16:58:49.350' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (42, 3, 448000, 0, CAST(N'2021-12-05T16:59:31.850' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (43, 2, 400000, 0, CAST(N'2021-12-05T16:59:52.153' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (44, 1, 335000, 0, CAST(N'2021-12-05T17:00:13.223' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (45, 4, 328000, 0, CAST(N'2021-12-05T17:02:47.067' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (46, 3, 430000, 0, CAST(N'2021-12-05T17:03:11.027' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (47, 1, 261000, 0, CAST(N'2021-12-05T17:03:29.237' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (48, 2, 345000, 0, CAST(N'2021-12-05T17:03:52.910' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (49, 4, 235000, 0, CAST(N'2021-12-05T17:12:03.007' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (50, 3, 395000, 0, CAST(N'2021-12-05T17:12:21.357' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (51, 2, 536000, 0, CAST(N'2021-12-05T17:12:51.877' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (52, 1, 320000, 0, CAST(N'2021-12-05T17:13:57.203' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (53, 4, 627000, 0, CAST(N'2021-12-05T17:15:10.790' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (54, 3, 408000, 0, CAST(N'2021-12-05T17:15:47.813' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (56, 1, 493000, 0, CAST(N'2021-12-05T17:16:02.420' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (57, 2, 383000, 0, CAST(N'2021-12-05T17:16:39.397' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (58, 1, 433000, 0, CAST(N'2021-12-05T17:17:14.710' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (59, 4, 603000, 0, CAST(N'2021-12-05T17:18:24.987' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (60, 3, 545000, 0, CAST(N'2021-12-05T17:18:47.523' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (61, 2, 273000, 0, CAST(N'2021-12-05T17:19:09.917' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (62, 4, 450000, 0, CAST(N'2021-12-05T17:21:04.953' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (63, 3, 415000, 0, CAST(N'2021-12-05T17:21:46.250' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (64, 2, 656000, 0, CAST(N'2021-12-05T17:22:18.223' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (67, 1, 441000, 0, CAST(N'2021-12-05T17:22:51.087' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (68, 1, 460000, 0, CAST(N'2021-12-05T17:28:48.530' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (69, 2, 573000, 0, CAST(N'2021-12-05T17:29:23.410' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (70, 3, 513000, 0, CAST(N'2021-12-05T17:29:49.957' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (71, 4, 469000, 0, CAST(N'2021-12-05T17:30:27.913' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (72, 4, 506000, 0, CAST(N'2021-12-05T17:31:54.167' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (73, 2, 633000, 0, CAST(N'2021-12-05T17:32:31.817' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (74, 3, 510000, 0, CAST(N'2021-12-05T17:33:04.053' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (75, 1, 604000, 0, CAST(N'2021-12-05T17:33:20.127' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (76, 4, 570000, 0, CAST(N'2021-12-05T17:35:01.957' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (77, 3, 564000, 0, CAST(N'2021-12-05T17:35:47.853' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (78, 1, 625000, 0, CAST(N'2021-12-05T17:36:19.407' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (79, 2, 528000, 0, CAST(N'2021-12-05T17:36:40.397' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (80, 4, 578000, 0, CAST(N'2021-12-05T17:40:07.670' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (81, 3, 340000, 0, CAST(N'2021-12-05T17:40:33.557' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (82, 2, 468000, 0, CAST(N'2021-12-05T17:41:47.237' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (83, 1, 428000, 0, CAST(N'2021-12-05T17:42:01.913' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (84, 1, 687000, 0, CAST(N'2021-12-05T18:05:00.423' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (85, 2, 724000, 0, CAST(N'2021-12-05T18:05:24.687' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (89, 3, 505000, 0, CAST(N'2021-12-05T18:05:48.337' AS DateTime))
INSERT [dbo].[hoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTienDV], [trangThai], [thoiGianDat]) VALUES (90, 4, 406000, 0, CAST(N'2021-12-05T18:06:12.883' AS DateTime))
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
INSERT [dbo].[khachHang] ([SDTKhachHang], [tenKhachHang], [tienNo], [tienSuDung], [traSau], [ghiChu], [tinhTrang]) VALUES (N'0963258741', N'Nguyễn Tuyết Nhi', 0, 0, 0, NULL, 1)
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
SET IDENTITY_INSERT [dbo].[nhaCungCap] ON 

INSERT [dbo].[nhaCungCap] ([idNhaCungCap], [tenNhaCungCap], [SDTNhaCungCap], [diaChi], [tienNo], [tinhTrang]) VALUES (1, N'Ban Mai', N'0945858548', N'Bmt', 0, 1)
INSERT [dbo].[nhaCungCap] ([idNhaCungCap], [tenNhaCungCap], [SDTNhaCungCap], [diaChi], [tienNo], [tinhTrang]) VALUES (2, N'Phương Khanh', N'0971975988', N'Bmt', 0, 1)
INSERT [dbo].[nhaCungCap] ([idNhaCungCap], [tenNhaCungCap], [SDTNhaCungCap], [diaChi], [tienNo], [tinhTrang]) VALUES (3, N'Tuấn Khanh', N'0963258147', N'Bmt', 0, 1)
INSERT [dbo].[nhaCungCap] ([idNhaCungCap], [tenNhaCungCap], [SDTNhaCungCap], [diaChi], [tienNo], [tinhTrang]) VALUES (4, N'Thanh Thanh', N'0963258155', N'Bmt', 0, 1)
SET IDENTITY_INSERT [dbo].[nhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[nhanVien] ON 

INSERT [dbo].[nhanVien] ([idNhanVien], [hoTenNhanVien], [CMND], [soDienThoai], [diaChi], [gioiTinh], [email], [vertifyCode], [matKhau], [quyenHan], [trangThai], [ngaySinh], [ngayVaoLam]) VALUES (1, N'Nguyễn Sơn Núi', N'241546895', N'0946758585', N'bmt', N'Nam', N'dong123@gmail.com', N'khong', N'123123', N'User', N'On', CAST(N'1998-01-01' AS Date), CAST(N'2021-10-10' AS Date))
INSERT [dbo].[nhanVien] ([idNhanVien], [hoTenNhanVien], [CMND], [soDienThoai], [diaChi], [gioiTinh], [email], [vertifyCode], [matKhau], [quyenHan], [trangThai], [ngaySinh], [ngayVaoLam]) VALUES (2, N'Nguyễn Sơn Đổng', N'241541254', N'0965856525', N'Bmt', N'Nam', N'dong123@gmail.com', N'khong', N'123123', N'User', N'On', CAST(N'1997-11-12' AS Date), CAST(N'2021-11-09' AS Date))
SET IDENTITY_INSERT [dbo].[nhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuDatPhong] ON 

INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (1, N'0985458745', 1, 2, NULL, 0, N'Bác 3')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (2, N'0984515847', 2, 9, NULL, 0, N'Đông')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (3, N'0946761636', 2, 3, NULL, 0, N'Đông')
INSERT [dbo].[phieuDatPhong] ([idPhieuDatPhong], [SDTKhachHang], [idPhong], [thoiGianDat], [ghiChu], [tinhTrang], [tenKhach]) VALUES (4, N'0946761636', 2, 12, NULL, 0, N'Đông')
SET IDENTITY_INSERT [dbo].[phieuDatPhong] OFF
GO
INSERT [dbo].[phieuNhapDichVu] ([maPhieuNhap], [idNhaCungCap], [idNhanVien], [thoiGianNhap], [tongTien], [tienNo], [ghiChu], [trangThai]) VALUES (N'PN001', 2, 1, CAST(N'2021-12-05T17:09:39.770' AS DateTime), 12000000, 0, N'', 1)
INSERT [dbo].[phieuNhapDichVu] ([maPhieuNhap], [idNhaCungCap], [idNhanVien], [thoiGianNhap], [tongTien], [tienNo], [ghiChu], [trangThai]) VALUES (N'PN002', 3, 1, CAST(N'2021-12-05T17:10:03.123' AS DateTime), 5000000, 0, N'', 1)
INSERT [dbo].[phieuNhapDichVu] ([maPhieuNhap], [idNhaCungCap], [idNhanVien], [thoiGianNhap], [tongTien], [tienNo], [ghiChu], [trangThai]) VALUES (N'PN003', 4, 1, CAST(N'2021-12-05T17:10:18.500' AS DateTime), 4500000, 0, N'', 1)
INSERT [dbo].[phieuNhapDichVu] ([maPhieuNhap], [idNhaCungCap], [idNhanVien], [thoiGianNhap], [tongTien], [tienNo], [ghiChu], [trangThai]) VALUES (N'PN123', 1, 1, CAST(N'2021-12-05T09:23:44.337' AS DateTime), 1000000, 0, N'co', 1)
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
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (11, N'0946761636', 1, 1, CAST(N'2021-12-29T09:51:02.930' AS DateTime), CAST(N'2021-12-29T09:51:02.930' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (12, N'0984515847', 1, 2, CAST(N'2021-12-29T09:55:29.037' AS DateTime), CAST(N'2021-12-29T09:55:29.037' AS DateTime), N'Đông', 1, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (13, N'0946761636', 1, 2, CAST(N'2021-12-29T10:00:16.450' AS DateTime), CAST(N'2021-12-05T14:31:04.903' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (14, N'0946761636', 1, 1, CAST(N'2021-12-04T10:41:12.570' AS DateTime), CAST(N'2021-12-04T10:41:36.540' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (15, N'0946761636', 1, 3, CAST(N'2021-12-04T11:41:24.160' AS DateTime), CAST(N'2021-12-04T11:41:35.413' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (17, N'0946761636', 1, 1, CAST(N'2021-12-04T23:23:45.917' AS DateTime), CAST(N'2021-12-05T14:30:39.760' AS DateTime), N'Đông', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (18, N'0963258741', 1, 1, CAST(N'2021-01-05T15:03:21.247' AS DateTime), CAST(N'2021-01-05T15:03:21.247' AS DateTime), N'Nguyễn Tuyết Nhi', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (19, N'0971829515', 1, 3, CAST(N'2021-01-08T15:03:21.247' AS DateTime), CAST(N'2021-01-08T15:03:21.247' AS DateTime), N'Trần Anh Hùng', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (20, N'0996663336', 1, 1, CAST(N'2021-01-11T15:17:09.393' AS DateTime), CAST(N'2021-01-11T15:17:09.393' AS DateTime), N'Nguyễn Sỹ Kiên', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (21, N'0971982977', 1, 1, CAST(N'2021-01-12T15:24:43.587' AS DateTime), CAST(N'2021-01-12T15:24:43.587' AS DateTime), N'Hồng Nhung', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (22, N'0987485796', 1, 2, CAST(N'2021-01-15T15:25:00.473' AS DateTime), CAST(N'2021-01-15T15:25:00.473' AS DateTime), N'Lê Đực Anh', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (23, N'0987998587', 1, 3, CAST(N'2021-02-05T15:25:32.367' AS DateTime), CAST(N'2021-02-05T15:25:32.367' AS DateTime), N'Lê tuyết Nhung', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (24, N'0987584448', 1, 4, CAST(N'2021-02-05T15:25:52.147' AS DateTime), CAST(N'2021-02-05T15:25:52.147' AS DateTime), N'Trần Thanh Tiền', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (25, N'0963369859', 1, 1, CAST(N'2021-02-07T15:33:33.633' AS DateTime), CAST(N'2021-02-07T15:33:33.633' AS DateTime), N'Nguyễn Hồng Sơn', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (26, N'0978585999', 1, 2, CAST(N'2021-02-09T15:33:55.343' AS DateTime), CAST(N'2021-02-09T15:33:55.343' AS DateTime), N'Tuấn Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (27, N'0215478585', 1, 3, CAST(N'2021-02-15T15:34:26.327' AS DateTime), CAST(N'2021-02-15T15:34:26.327' AS DateTime), N'Lê Thi Hoa', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (28, N'0963258147', 1, 4, CAST(N'2021-02-16T15:34:44.003' AS DateTime), CAST(N'2021-02-16T15:34:44.003' AS DateTime), N'Nguyễn Yến Nhi', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (29, N'035369588', 1, 1, CAST(N'2021-03-05T15:40:19.773' AS DateTime), CAST(N'2021-03-05T15:40:19.773' AS DateTime), N'Lê Thị Hoa', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (30, N'0235256398', 1, 2, CAST(N'2021-03-03T15:40:37.753' AS DateTime), CAST(N'2021-03-03T15:40:37.753' AS DateTime), N'Nguyễn Trần Thanh Vy', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (31, N'0987578888', 1, 3, CAST(N'2021-03-06T15:41:05.227' AS DateTime), CAST(N'2021-03-06T15:41:05.227' AS DateTime), N'Nguyễn Lâm Sơn', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (34, N'0215478596', 1, 4, CAST(N'2021-03-08T15:41:43.657' AS DateTime), CAST(N'2021-03-08T15:41:43.657' AS DateTime), N'Nguyễn Thị Hà', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (35, N'0698757487', 1, 1, CAST(N'2021-03-15T16:52:44.080' AS DateTime), CAST(N'2021-03-15T16:52:44.080' AS DateTime), N'Trần Thanh Tuấn', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (36, N'0987586669', 1, 2, CAST(N'2021-03-16T16:53:10.207' AS DateTime), CAST(N'2021-03-16T16:53:10.207' AS DateTime), N'Nguyễn Phương Lịnh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (37, N'0356985785', 1, 3, CAST(N'2021-03-17T16:53:47.483' AS DateTime), CAST(N'2021-03-17T16:53:47.483' AS DateTime), N'Bụi Thị Cẩm', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (38, N'0369858785', 1, 4, CAST(N'2021-03-19T16:54:30.107' AS DateTime), CAST(N'2021-03-19T16:54:30.107' AS DateTime), N'Bùi Bích Ly', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (40, N'0326586987', 1, 1, CAST(N'2021-04-01T16:57:23.867' AS DateTime), CAST(N'2021-04-01T16:57:23.867' AS DateTime), N'Nguyễn Hương Ly', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (41, N'0369858748', 1, 2, CAST(N'2021-04-02T16:57:52.033' AS DateTime), CAST(N'2021-04-02T16:57:52.033' AS DateTime), N'Nguyễn Thị Hoa', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (42, N'0971526836', 1, 3, CAST(N'2021-04-05T16:58:26.993' AS DateTime), CAST(N'2021-04-05T16:58:26.993' AS DateTime), N'Bùi Thanh Tuấn', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (43, N'0963693579', 1, 4, CAST(N'2021-04-15T16:58:47.360' AS DateTime), CAST(N'2021-04-15T16:58:47.360' AS DateTime), N'Lê Hồng Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (44, N'0963698579', 1, 1, CAST(N'2021-04-25T17:01:52.267' AS DateTime), CAST(N'2021-04-25T17:01:52.267' AS DateTime), N'Lê Thanh Tâm', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (45, N'0963258714', 1, 2, CAST(N'2021-05-05T17:02:07.383' AS DateTime), CAST(N'2021-05-05T17:02:07.383' AS DateTime), N'Nguyễn Trọng Phương', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (46, N'0369648745', 1, 3, CAST(N'2021-05-05T17:02:24.670' AS DateTime), CAST(N'2021-05-05T17:02:24.670' AS DateTime), N'Nguyễn Phương Uyên', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (47, N'0359548786', 1, 4, CAST(N'2021-05-05T17:02:40.373' AS DateTime), CAST(N'2021-05-05T17:02:40.373' AS DateTime), N'Thanh Thảo', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (48, N'0396584487', 1, 1, CAST(N'2021-05-05T17:11:02.970' AS DateTime), CAST(N'2021-05-05T17:11:02.970' AS DateTime), N'Nguyễn Phương Phụng', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (49, N'0254875848', 1, 2, CAST(N'2021-05-05T17:11:18.577' AS DateTime), CAST(N'2021-05-05T17:11:18.577' AS DateTime), N'Lê Hồng Khanh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (50, N'0398945896', 1, 3, CAST(N'2021-05-05T17:11:44.593' AS DateTime), CAST(N'2021-05-05T17:11:44.593' AS DateTime), N'Trần Thanh Tuấn', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (51, N'0584651984', 1, 4, CAST(N'2021-05-05T17:12:01.013' AS DateTime), CAST(N'2021-05-05T17:12:01.013' AS DateTime), N'Nguyễn Đực Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (52, N'0984651985', 1, 1, CAST(N'2021-05-05T17:14:29.420' AS DateTime), CAST(N'2021-05-05T17:14:29.420' AS DateTime), N'Nguyễn Thanh Thu', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (53, N'0894684358', 1, 2, CAST(N'2021-05-05T17:14:43.533' AS DateTime), CAST(N'2021-05-05T17:14:43.533' AS DateTime), N'Trần Thu Thủy', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (54, N'0845386156', 1, 3, CAST(N'2021-06-05T17:14:55.690' AS DateTime), CAST(N'2021-06-05T17:14:55.690' AS DateTime), N'Nguyễn Trần Tuấn', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (55, N'0984651388', 1, 4, CAST(N'2021-06-05T17:15:08.970' AS DateTime), CAST(N'2021-06-05T17:15:08.970' AS DateTime), N'Tô Thị Chiểu', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (56, N'0984651895', 1, 1, CAST(N'2021-06-05T17:17:40.677' AS DateTime), CAST(N'2021-06-05T17:17:40.677' AS DateTime), N'Lê Thanh Khoa', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (57, N'0864519855', 1, 2, CAST(N'2021-06-05T17:17:53.573' AS DateTime), CAST(N'2021-06-05T17:17:53.573' AS DateTime), N'Nguyễn Đình Lê', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (58, N'0984651856', 1, 3, CAST(N'2021-06-05T17:18:12.263' AS DateTime), CAST(N'2021-06-05T17:18:12.263' AS DateTime), N'Nguyễn Thư Sinh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (59, N'0948658515', 1, 4, CAST(N'2021-07-05T17:18:22.777' AS DateTime), CAST(N'2021-12-05T17:18:46.050' AS DateTime), N'Nguyễn Sỹ Hồ', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (60, N'0948615851', 1, 1, CAST(N'2021-07-05T17:20:16.717' AS DateTime), CAST(N'2021-07-05T17:20:16.717' AS DateTime), N'Lê Đình Khoa', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (61, N'0846513855', 1, 2, CAST(N'2021-07-05T17:20:27.360' AS DateTime), CAST(N'2021-07-05T17:20:27.360' AS DateTime), N'Lê Đình Kiệt', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (62, N'0948651841', 1, 3, CAST(N'2021-07-05T17:20:40.103' AS DateTime), CAST(N'2021-07-05T17:20:40.103' AS DateTime), N'Nguyễn Trung Kiên', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (63, N'0984586451', 1, 4, CAST(N'2021-07-05T17:21:00.090' AS DateTime), CAST(N'2021-07-05T17:21:00.090' AS DateTime), N'Trần Phuong Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (64, N'0948651385', 1, 1, CAST(N'2021-07-05T17:27:53.827' AS DateTime), CAST(N'2021-07-05T17:27:53.827' AS DateTime), N'Lê Tuấn Khanh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (65, N'0846518551', 1, 2, CAST(N'2021-07-05T17:28:18.713' AS DateTime), CAST(N'2021-07-05T17:28:18.713' AS DateTime), N'Nguyễn Thanh Vy', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (66, N'0894615355', 1, 3, CAST(N'2021-07-05T17:28:36.027' AS DateTime), CAST(N'2021-07-05T17:28:36.027' AS DateTime), N'Phương Vy', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (67, N'0984651851', 1, 4, CAST(N'2021-08-05T17:28:45.843' AS DateTime), CAST(N'2021-08-05T17:28:45.843' AS DateTime), N'Phương Phùng', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (68, N'0984615385', 1, 1, CAST(N'2021-08-05T17:30:59.797' AS DateTime), CAST(N'2021-08-05T17:30:59.797' AS DateTime), N'Bùi Thị Thanh Uyên', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (69, N'0985138515', 1, 2, CAST(N'2021-08-05T17:31:18.847' AS DateTime), CAST(N'2021-08-05T17:31:18.847' AS DateTime), N'Trần Tuấn Anh', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (70, N'0865184685', 1, 3, CAST(N'2021-08-05T17:31:33.830' AS DateTime), CAST(N'2021-08-05T17:31:33.830' AS DateTime), N'Lê Đức Phúc', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (71, N'0645312165', 1, 4, CAST(N'2021-08-05T17:31:50.080' AS DateTime), CAST(N'2021-08-05T17:31:50.080' AS DateTime), N'Nguyễn Thị Hà', 0, 0)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (72, N'0894651384', 1, 1, CAST(N'2021-09-05T17:34:01.897' AS DateTime), CAST(N'2021-09-05T17:34:01.897' AS DateTime), N'Thanh Thanh', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (73, N'0987987451', 1, 2, CAST(N'2021-09-05T17:34:15.567' AS DateTime), CAST(N'2021-09-05T17:34:15.567' AS DateTime), N'Nguyễn Phùng', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (74, N'0998451384', 1, 3, CAST(N'2021-09-05T17:34:37.327' AS DateTime), CAST(N'2021-09-05T17:34:37.327' AS DateTime), N'Thanh Phụng', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (75, N'0132184655', 1, 4, CAST(N'2021-09-05T17:34:59.177' AS DateTime), CAST(N'2021-09-05T17:34:59.177' AS DateTime), N'Nguyễn Phai Phôi', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (76, N'0984651845', 1, 1, CAST(N'2021-09-05T17:38:55.247' AS DateTime), CAST(N'2021-09-05T17:38:55.247' AS DateTime), N'Trần Thanh Tuấn', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (77, N'0948651961', 1, 2, CAST(N'2021-09-05T17:39:10.850' AS DateTime), CAST(N'2021-09-05T17:39:10.850' AS DateTime), N'Lê Bảo Vy', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (78, N'0984651894', 1, 3, CAST(N'2021-09-05T17:39:23.117' AS DateTime), CAST(N'2021-09-05T17:39:23.117' AS DateTime), N'Lể Bảo Vy', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (79, N'0948651581', 1, 4, CAST(N'2021-10-05T17:40:05.457' AS DateTime), CAST(N'2021-10-05T17:40:05.457' AS DateTime), N'Nguyễn Hắc', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (80, N'0984651894', 1, 1, CAST(N'2021-10-05T18:04:15.423' AS DateTime), CAST(N'2021-10-05T18:04:15.423' AS DateTime), N'Nguyên Tuyết Nhung', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (81, N'0987465188', 1, 2, CAST(N'2021-10-05T18:04:27.893' AS DateTime), CAST(N'2021-10-05T18:04:27.893' AS DateTime), N'Diễm Kiều', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (82, N'0894658555', 1, 3, CAST(N'2021-10-05T18:04:39.740' AS DateTime), CAST(N'2021-10-05T18:04:39.740' AS DateTime), N'Anh Khiêm', 0, 1)
INSERT [dbo].[phieuThuePhong] ([idPhieuThuePhong], [SDTKhachHang], [idNhanVien], [idPhong], [thoiGianMo], [thoiGianDong], [tenKhachHang], [tinhTrang], [giaNgayLe]) VALUES (83, N'0984651815', 1, 4, CAST(N'2021-10-05T18:04:55.623' AS DateTime), CAST(N'2021-10-05T18:04:55.623' AS DateTime), N'Lê Thanh Nhàn', 0, 1)
SET IDENTITY_INSERT [dbo].[phieuThuePhong] OFF
GO
SET IDENTITY_INSERT [dbo].[phong] ON 

INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (1, 1, N'Phòng 1', N'Phòng còn trống')
INSERT [dbo].[phong] ([idPhong], [idLoaiPhong], [tenPhong], [tinhTrangPhong]) VALUES (2, 1, N'Phòng 2', N'Phòng còn trống')
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
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK__chiTietPh__idDic__4316F928] FOREIGN KEY([idDichVu])
REFERENCES [dbo].[dichVu] ([idDichVu])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap] CHECK CONSTRAINT [FK__chiTietPh__idDic__4316F928]
GO
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK__chiTietPh__idDon__440B1D61] FOREIGN KEY([idDonViTinh])
REFERENCES [dbo].[donViTinh] ([idDonViTinh])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap] CHECK CONSTRAINT [FK__chiTietPh__idDon__440B1D61]
GO
ALTER TABLE [dbo].[chiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_chiTietPhieuNhap_phieuNhapDichVu] FOREIGN KEY([maPhieuNhap])
REFERENCES [dbo].[phieuNhapDichVu] ([maPhieuNhap])
GO
ALTER TABLE [dbo].[chiTietPhieuNhap] CHECK CONSTRAINT [FK_chiTietPhieuNhap_phieuNhapDichVu]
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
