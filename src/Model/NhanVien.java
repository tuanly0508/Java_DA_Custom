package Model;

import java.sql.Date;

public class NhanVien extends AbsTable{
    private Integer idNhanVien;
    private String hoTenNhanVien;
    private String CMND;
    private String soDienThoai;
    private String diaChi;
    private String gioiTinh;
    private String email;
    private String vertifyCode;
    private String matKhau;
    private String quyenHan;
    private String trangThai;
    private java.sql.Date ngaySinh;
    private java.sql.Date ngayVaoLam;
   
    public NhanVien() {
    }

    public NhanVien(Integer idNhanVien, String hoTenNhanVien, String CMND, String soDienThoai, String diaChi, String gioiTinh, String email, String vertifyCode, String matKhau, String quyenHan, String trangThai, Date ngaySinh, Date ngayVaoLam) {
        this.idNhanVien = idNhanVien;
        this.hoTenNhanVien = hoTenNhanVien;
        this.CMND = CMND;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.vertifyCode = vertifyCode;
        this.matKhau = matKhau;
        this.quyenHan = quyenHan;
        this.trangThai = trangThai;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoTenNhanVien() {
        return hoTenNhanVien;
    }

    public void setHoTenNhanVien(String hoTenNhanVien) {
        this.hoTenNhanVien = hoTenNhanVien;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public String getVertifyCode() {
        return vertifyCode;
    }

    public void setVertifyCode(String verifyCode) {
        this.vertifyCode = verifyCode;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    
    @Override
    public int getId() {
        return idNhanVien;
    }
    
    
}
