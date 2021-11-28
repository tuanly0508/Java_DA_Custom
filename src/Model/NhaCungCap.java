/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dongnguyen
 */
public class NhaCungCap extends AbsTable{
    private Integer idNhaCungCap;
    private String tenNhaCungCap;
    private String SDTNhaCungCap;
    private String diaChi;
    private Double tienNo;
    private Boolean tinhTrang;

    public NhaCungCap() {
    }

    public NhaCungCap(Integer idNhaCungCap, String tenNhaCungCap, String SDTNhaCungCap, String diaChi, Double tienNo, Boolean tinhTrang) {
        this.idNhaCungCap = idNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.SDTNhaCungCap = SDTNhaCungCap;
        this.diaChi = diaChi;
        this.tienNo = tienNo;
        this.tinhTrang = tinhTrang;
    }

    public Integer getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(Integer idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getSDTNhaCungCap() {
        return SDTNhaCungCap;
    }

    public void setSDTNhaCungCap(String SDTNhaCungCap) {
        this.SDTNhaCungCap = SDTNhaCungCap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Double getTienNo() {
        return tienNo;
    }

    public void setTienNo(Double tienNo) {
        this.tienNo = tienNo;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    @Override
    public int getId() {
        return idNhaCungCap;
    }    
    
}
