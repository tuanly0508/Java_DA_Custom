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
public class DonViTinh extends AbsTable {
    private Integer idDonViTinh ;
    private String tenDonVi ;
    private Boolean tinhTrang ;

    public DonViTinh() {
    }

    public DonViTinh(Integer idDonViTinh, String tenDonVi, Boolean tinhTrang) {
        this.idDonViTinh = idDonViTinh;
        this.tenDonVi = tenDonVi;
        this.tinhTrang = tinhTrang;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    

    public Integer getIdDonViTinh() {
        return idDonViTinh;
    }

    public void setIdDonViTinh(Integer idDonViTinh) {
        this.idDonViTinh = idDonViTinh;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }
    

    @Override
    public int getId() {
        return idDonViTinh;
    }
    
    @Override
    public String toString() {
        return tenDonVi;
    }  
}
