package Model;

public class DichVu extends AbsTable{
    private Integer idDichVu;
    private Integer idDanhMuc;
    private Integer idDonViTinh;
    private String tenDichVu;
    private Integer soLuongCon;
    private Double gia;
    private Boolean tinhTrang;

    public DichVu() {
    }

    public DichVu(Integer idDichVu, Integer idDanhMuc, Integer idDonViTinh, String tenDichVu, Integer soLuongCon, Double gia, Boolean tinhTrang) {
        this.idDichVu = idDichVu;
        this.idDanhMuc = idDanhMuc;
        this.idDonViTinh = idDonViTinh;
        this.tenDichVu = tenDichVu;
        this.soLuongCon = soLuongCon;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }


    public Integer getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Integer idDichVu) {
        this.idDichVu = idDichVu;
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public Integer getIdDonViTinh() {
        return idDonViTinh;
    }

    public void setIdDonViTinh(Integer idDonViTinh) {
        this.idDonViTinh = idDonViTinh;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Integer getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(Integer soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    
    @Override
    public int getId() {
        return idDichVu;
    }
    
    @Override
    public String toString() {
        return tenDichVu;
    }
}
