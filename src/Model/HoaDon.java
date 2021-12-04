package Model;

public class HoaDon extends AbsTable{
    
    private Integer idHoaDon;
    private Integer idNhanVien;
    private Integer idHoaDonDichVu;
    private Integer idPhieuThuePhong;
    private Double tienPhong;
    private Double tienDichVu;
    private Double tongTien;
    private Double phuThu;
    private Double tienNo ;

    public HoaDon() {
    }

    public HoaDon(Integer idHoaDon, Integer idNhanVien, Integer idHoaDonDichVu, Integer idPhieuThuePhong, Double tienPhong, Double tienDichVu, Double tongTien, Double phuThu, Double tienNo) {
        this.idHoaDon = idHoaDon;
        this.idNhanVien = idNhanVien;
        this.idHoaDonDichVu = idHoaDonDichVu;
        this.idPhieuThuePhong = idPhieuThuePhong;
        this.tienPhong = tienPhong;
        this.tienDichVu = tienDichVu;
        this.tongTien = tongTien;
        this.phuThu = phuThu;
        this.tienNo = tienNo;
    }

    public Double getTienNo() {
        return tienNo;
    }

    public void setTienNo(Double tienNo) {
        this.tienNo = tienNo;
    }

    

    public Double getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(Double phuThu) {
        this.phuThu = phuThu;
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


    @Override
    public int getId() {
        return idHoaDon;
    }
    
}
