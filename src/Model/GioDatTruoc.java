package Model;

public class GioDatTruoc extends AbsTable{
    private Integer idGioDatTruoc;
    private String tenHinhThuc;

    public GioDatTruoc() {
    }

    public GioDatTruoc(Integer idGioDatTruoc, String tenHinhThuc) {
        this.idGioDatTruoc = idGioDatTruoc;
        this.tenHinhThuc = tenHinhThuc;
    }

    public Integer getIdGioDatTruoc() {
        return idGioDatTruoc;
    }

    public void setIdGioDatTruoc(Integer idGioDatTruoc) {
        this.idGioDatTruoc = idGioDatTruoc;
    }

    public String getTenHinhThuc() {
        return tenHinhThuc;
    }

    public void setTenHinhThuc(String tenHinhThuc) {
        this.tenHinhThuc = tenHinhThuc;
    }   
    
    @Override
    public int getId() {
        return idGioDatTruoc;
    }
    
    @Override
    public String toString() {
        return tenHinhThuc;
    }
}
