/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Help.DBConnection;
import Model.DonViTinh;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DonViTinhDAO extends AbsDAO<DonViTinh>{
    public List<Object[]> layDanhSachDonViTinh() {
        return getRawValues("select * from DonViTinh where tinhTrang =1");
    }
    
    public void xoaTamThoiDonViTinh(int idDonVi){
        String query = "update donViTinh set tinhTrang=0 where idDonviTinh =?";
        DBConnection.executeUpdate(query, idDonVi);
    }
}
