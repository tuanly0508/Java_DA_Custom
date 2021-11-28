package Model;

public class KhachHang extends AbsTable{
    
    private Integer idKhachHang;
    private String SDTKhachHang;
    private String tenKhachHang;
    private Double tienNo;
    private Double tienSuDung;
    private Boolean traSau;
    private String ghiChu;
    private Boolean tinhTrang;

    public KhachHang() {
    }

    public KhachHang(Integer idKhachHang, String SDTKhachHang, String tenKhachHang, Double tienNo, Double tienSuDung, Boolean traSau, String ghiChu, Boolean tinhTrang) {
        this.idKhachHang = idKhachHang;
        this.SDTKhachHang = SDTKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.tienNo = tienNo;
        this.tienSuDung = tienSuDung;
        this.traSau = traSau;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getSDTKhachHang() {
        return SDTKhachHang;
    }

    public void setSDTKhachHang(String SDTKhachHang) {
        this.SDTKhachHang = SDTKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
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

    public Boolean getTraSau() {
        return traSau;
    }

    public void setTraSau(Boolean traSau) {
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
