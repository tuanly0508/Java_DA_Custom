package Model;

import java.sql.Timestamp;

public class PhieuNhapDichVu extends AbsTable{
    private String maPhieuNhap;
    private Integer idNhaCungCap;
    private Integer idNhanVien;
    private java.sql.Timestamp thoiGianNhap;
    private Double tongTien;
    private Double tienNo;
    private String ghiChu;
    private Boolean trangThai;

    public PhieuNhapDichVu() {
    }

    public PhieuNhapDichVu(String maPhieuNhap, Integer idNhaCungCap, Integer idNhanVien, Timestamp thoiGianNhap, Double tongTien, Double tienNo, String ghiChu, Boolean trangThai) {
        this.maPhieuNhap = maPhieuNhap;
        this.idNhaCungCap = idNhaCungCap;
        this.idNhanVien = idNhanVien;
        this.thoiGianNhap = thoiGianNhap;
        this.tongTien = tongTien;
        this.tienNo = tienNo;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }



    public Integer getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(Integer idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
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

    public Double getTienNo() {
        return tienNo;
    }

    public void setTienNo(Double tienNo) {
        this.tienNo = tienNo;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
