package Model;

import java.sql.Timestamp;

public class PhieuThuePhong extends AbsTable{
    
    private Integer idPhieuThuePhong;
    private String SDT;
    private Integer idPhong;
    private java.sql.Timestamp thoiGianMo ;
    private java.sql.Timestamp thoiGianDong ;
    private String tenKhachHang;
    private int tinhTrang;

    public PhieuThuePhong() {
    }

    public PhieuThuePhong(Integer idPhieuThuePhong, String SDT, Integer idPhong, Timestamp thoiGianMo, Timestamp thoiGianDong, String tenKhachHang, int tinhTrang) {
        this.idPhieuThuePhong = idPhieuThuePhong;
        this.SDT = SDT;
        this.idPhong = idPhong;
        this.thoiGianMo = thoiGianMo;
        this.thoiGianDong = thoiGianDong;
        this.tenKhachHang = tenKhachHang;
        this.tinhTrang = tinhTrang;
    }

    public Integer getIdPhieuThuePhong() {
        return idPhieuThuePhong;
    }

    public void setIdPhieuThuePhong(Integer idPhieuThuePhong) {
        this.idPhieuThuePhong = idPhieuThuePhong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public Timestamp getThoiGianMo() {
        return thoiGianMo;
    }

    public void setThoiGianMo(Timestamp thoiGianMo) {
        this.thoiGianMo = thoiGianMo;
    }

    public Timestamp getThoiGianDong() {
        return thoiGianDong;
    }

    public void setThoiGianDong(Timestamp thoiGianDong) {
        this.thoiGianDong = thoiGianDong;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    @Override
    public int getId() {
        return idPhieuThuePhong;
    }
    
}
