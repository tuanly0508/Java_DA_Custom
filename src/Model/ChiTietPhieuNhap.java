/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class ChiTietPhieuNhap extends AbsTable{

    private String maPhieuNhap;
    private Integer idDichVu ;
    private Integer idDonViTinh;
    private Integer soLuong ;
    private Double giaNhap ;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(String maPhieuNhap, Integer idDichVu, Integer idDonViTinh, Integer soLuong, Double giaNhap) {
        this.maPhieuNhap = maPhieuNhap;
        this.idDichVu = idDichVu;
        this.idDonViTinh = idDonViTinh;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Integer getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Integer idDichVu) {
        this.idDichVu = idDichVu;
    }

    public Integer getIdDonViTinh() {
        return idDonViTinh;
    }

    public void setIdDonViTinh(Integer idDonViTinh) {
        this.idDonViTinh = idDonViTinh;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }
    
    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
