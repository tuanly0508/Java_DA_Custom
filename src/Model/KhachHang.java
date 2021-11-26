package Model;

public class KhachHang extends AbsTable{
    
    private Integer idKhachHang;
    private String SDT;
    private String tenKhach;
    private Double tienNo;
    private Double tienSuDung;
    private Integer traSau;
    private String ghiChu;

    public KhachHang() {
    }

    public KhachHang(Integer idKhachHang, String SDT, String tenKhach, Double tienNo, Double tienSuDung, Integer traSau, String ghiChu) {
        this.idKhachHang = idKhachHang;
        this.SDT = SDT;
        this.tenKhach = tenKhach;
        this.tienNo = tienNo;
        this.tienSuDung = tienSuDung;
        this.traSau = traSau;
        this.ghiChu = ghiChu;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public Double getTienNo() {
        return tienNo;
    }

    public void setTienNo(Double tienNo) {
        this.tienNo = tienNo;
    }

    public Double getTienSuDung() {
        return tienSuDung;
    }

    public void setTienSuDung(Double tienSuDung) {
        this.tienSuDung = tienSuDung;
    }

    public Integer getTraSau() {
        return traSau;
    }

    public void setTraSau(Integer traSau) {
        this.traSau = traSau;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    @Override
    public int getId() {
        return idKhachHang;
    }
}
