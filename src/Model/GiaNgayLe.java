package Model;

public class GiaNgayLe extends AbsTable{
    private Integer idGiaNgayLe;
    private String tenGiaNgayLe;

    public GiaNgayLe() {
    }

    public GiaNgayLe(Integer idGiaNgayLe, String tenGiaNgayLe) {
        this.idGiaNgayLe = idGiaNgayLe;
        this.tenGiaNgayLe = tenGiaNgayLe;
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
    
    @Override
    public int getId() {
        return idGiaNgayLe;
    }
    
}
