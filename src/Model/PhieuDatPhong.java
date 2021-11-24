package Model;

public class PhieuDatPhong extends AbsTable{
    private Integer idPhieuDatPhong;
    private String SDT;
    private Integer idPhong;
    private int thoiGianDat;
    private String ghiChu;
    private Integer tinhTrang;
    private String tenKhach;

    public PhieuDatPhong() {
    }

    public PhieuDatPhong(Integer idPhieuDatPhong, String SDT, Integer idPhong, int thoiGianDat, String ghiChu, Integer tinhTrang, String tenKhach) {
        this.idPhieuDatPhong = idPhieuDatPhong;
        this.SDT = SDT;
        this.idPhong = idPhong;
        this.thoiGianDat = thoiGianDat;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
        this.tenKhach = tenKhach;
    }

    public Integer getIdPhieuDatPhong() {
        return idPhieuDatPhong;
    }

    public void setIdPhieuDatPhong(Integer idPhieuDatPhong) {
        this.idPhieuDatPhong = idPhieuDatPhong;
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

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }
    
    @Override
    public int getId() {
        return idPhieuDatPhong;
    }
    
}
