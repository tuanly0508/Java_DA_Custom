package Model;

import java.sql.Date;

public class PhieuDatPhong extends AbsTable{
    private Integer idPhieuDatPhong;
    private String SDTKhachHang;
    private Integer idPhong;
    private int thoiGianDat;
    private String ghiChu;
    private Boolean tinhTrang;
    private String tenKhach;
    private java.sql.Date ngayDat;

    public PhieuDatPhong() {
    }

    public PhieuDatPhong(Integer idPhieuDatPhong, String SDTKhachHang, Integer idPhong, int thoiGianDat, String ghiChu, Boolean tinhTrang, String tenKhach, Date ngayDat) {
        this.idPhieuDatPhong = idPhieuDatPhong;
        this.SDTKhachHang = SDTKhachHang;
        this.idPhong = idPhong;
        this.thoiGianDat = thoiGianDat;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
        this.tenKhach = tenKhach;
        this.ngayDat = ngayDat;
    }
    
    public Integer getIdPhieuDatPhong() {
        return idPhieuDatPhong;
    }

    public void setIdPhieuDatPhong(Integer idPhieuDatPhong) {
        this.idPhieuDatPhong = idPhieuDatPhong;
    }

    public String getSDTKhachHang() {
        return SDTKhachHang;
    }

    public void setSDTKhachHang(String SDTKhachHang) {
        this.SDTKhachHang = SDTKhachHang;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public int getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(int thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }
    
    @Override
    public int getId() {
        return idPhieuDatPhong;
    }
    
}
