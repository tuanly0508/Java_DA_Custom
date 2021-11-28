/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Help.DBConnection;
import Model.DanhMuc;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DanhMucDAO extends AbsDAO<DanhMuc>{
    public List<Object[]> layDanhSachDanhMuc() {
        return getRawValues("select * from DanhMuc where tinhTrang =1");
    }
    
    public void xoaTamThoiDanhMuc (int idDanhMuc){
        String query = "update DanhMuc set tinhTrang=0 where idDanhMuc =?";
        DBConnection.executeUpdate(query, idDanhMuc);
    }
}
