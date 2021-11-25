package Model;

public class GiaNgayLe extends AbsTable{
    private Integer idGiaNgayLe;
    private String tenGiaNgayLe;
    private Integer trangThai;

    public GiaNgayLe() {
    }

    public GiaNgayLe(Integer idGiaNgayLe, String tenGiaNgayLe, Integer trangThai) {
        this.idGiaNgayLe = idGiaNgayLe;
        this.tenGiaNgayLe = tenGiaNgayLe;
        this.trangThai = trangThai;
    }

    public Integer getIdGiaNgayLe() {
        return idGiaNgayLe;
    }

    public void setIdGiaNgayLe(Integer idGiaNgayLe) {
        this.idGiaNgayLe = idGiaNgayLe;
    }

    public String getTenGiaNgayLe() {
        return tenGiaNgayLe;
    }

    public void setTenGiaNgayLe(String tenGiaNgayLe) {
        this.tenGiaNgayLe = tenGiaNgayLe;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    @Override
    public int getId() {
        return idGiaNgayLe;
    }
    
}
