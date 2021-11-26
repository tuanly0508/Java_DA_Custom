package Model;

import java.sql.Timestamp;

public class PhieuNhapHang extends AbsTable{
    private Integer idPhieuNhap;
    private Integer idNhaCungCap;
    private java.sql.Timestamp thoiGianNhap;
    private Double tongTien;
    private String ghiChu;
    private String maPhieuNhap;

    public PhieuNhapHang() {
    }

    public PhieuNhapHang(Integer idPhieuNhap, Integer idNhaCungCap, Timestamp thoiGianNhap, Double tongTien, String ghiChu, String maPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
        this.idNhaCungCap = idNhaCungCap;
        this.thoiGianNhap = thoiGianNhap;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.maPhieuNhap = maPhieuNhap;
    }

    public Integer getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(Integer idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public Integer getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(Integer idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public Timestamp getThoiGianNhap() {
        return thoiGianNhap;
    }

    public void setThoiGianNhap(Timestamp thoiGianNhap) {
        this.thoiGianNhap = thoiGianNhap;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
    
    @Override
    public int getId() {
        return idPhieuNhap;
    }
    
}
