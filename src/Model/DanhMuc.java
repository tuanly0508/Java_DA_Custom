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
public class DanhMuc extends AbsTable{
    private Integer idDanhMuc ;
    private String tenDanhMuc ;
    private Boolean tinhTrang ;

    public DanhMuc() {
    }

    public DanhMuc(Integer idDanhMuc, String tenDanhMuc, Boolean tinhTrang) {
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.tinhTrang = tinhTrang;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }


    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
    

    @Override
    public int getId() {
        return idDanhMuc;
    }
    
    @Override
    public String toString() {
        return tenDanhMuc;
    }   
}
