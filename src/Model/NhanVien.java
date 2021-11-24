package Model;

import java.sql.Date;

public class NhanVien extends AbsTable{
    private Integer idNhanVien;
    private String hoTen;
    private String CMND;
    private String SDT;
    private String diaChi;
    private Double luong;
    private java.sql.Date ngayVaoLam;
    private String gioiTinh;
    private String email;
    private String verifyCode;
    private String pass;
    private String quyenHan;
    private byte[] hinhAnh;
    private String trangThai;

    public NhanVien() {
    }

    public NhanVien(Integer idNhanVien, String hoTen, String CMND, String SDT, String diaChi, Double luong, Date ngayVaoLam, String gioiTinh, String email, String verifyCode, String pass, String quyenHan, byte[] hinhAnh, String trangThai) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.CMND = CMND;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.luong = luong;
        this.ngayVaoLam = ngayVaoLam;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.verifyCode = verifyCode;
        this.pass = pass;
        this.quyenHan = quyenHan;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int getId() {
        return idNhanVien;
    }
    
    
}
