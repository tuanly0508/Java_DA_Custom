package Model;

public class Phong extends AbsTable{
    private Integer idPhong;
    private Integer idLoaiPhong;
    private String tenPhong;
    private String tinhTrangPhong;

    public Phong() {
    }

    public Phong(Integer idPhong, Integer idLoaiPhong, String tenPhong, String tinhTrangPhong) {
        this.idPhong = idPhong;
        this.idLoaiPhong = idLoaiPhong;
        this.tenPhong = tenPhong;
        this.tinhTrangPhong = tinhTrangPhong;
    }

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public Integer getIdLoaiPhong() {
        return idLoaiPhong;
    }

    public void setIdLoaiPhong(Integer idLoaiPhong) {
        this.idLoaiPhong = idLoaiPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTinhTrangPhong() {
        return tinhTrangPhong;
    }

    public void setTinhTrangPhong(String tinhTrangPhong) {
        this.tinhTrangPhong = tinhTrangPhong;
    }

    @Override
    public int getId() {
        return idPhong;
    }
    
    
}
