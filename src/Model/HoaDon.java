package Model;

public class HoaDon extends AbsTable{
    
    private Integer idHoaDon;
    private Integer idNhanVien;
    private Integer idHoaDonDichVu;
    private Integer idPhieuThuePhong;
    private Double tienPhong;
    private Double tienDichVu;
    private Double tongTien;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(Integer idHoaDon, Integer idNhanVien, Integer idHoaDonDichVu, Integer idPhieuThuePhong, Double tienPhong, Double tienDichVu, Double tongTien, String ghiChu) {
        this.idHoaDon = idHoaDon;
        this.idNhanVien = idNhanVien;
        this.idHoaDonDichVu = idHoaDonDichVu;
        this.idPhieuThuePhong = idPhieuThuePhong;
        this.tienPhong = tienPhong;
        this.tienDichVu = tienDichVu;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
    }

    public Double getTienDichVu() {
        return tienDichVu;
    }

    public void setTienDichVu(Double tienDichVu) {
        this.tienDichVu = tienDichVu;
    }

    
    
    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Integer getIdHoaDonDichVu() {
        return idHoaDonDichVu;
    }

    public void setIdHoaDonDichVu(Integer idHoaDonDichVu) {
        this.idHoaDonDichVu = idHoaDonDichVu;
    }

    public Integer getIdPhieuThuePhong() {
        return idPhieuThuePhong;
    }

    public void setIdPhieuThuePhong(Integer idPhieuThuePhong) {
        this.idPhieuThuePhong = idPhieuThuePhong;
    }

    public Double getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(Double tienPhong) {
        this.tienPhong = tienPhong;
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

    @Override
    public int getId() {
        return idHoaDon;
    }
    
}
