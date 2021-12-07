/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Help.DBConnection;
import Model.DonViTinh;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<Integer> layIDDonvi(String tenDonVi){
        String query = "select idDonViTinh,giaTri from donViTinh where tenDonVi like ?";
        ResultSet rs = DBConnection.executeQuery(query,tenDonVi);
        ArrayList<Integer> donVi = new ArrayList<>();
        try {
            while (rs.next()) {
                donVi.add(rs.getInt("idDonViTinh"));
                System.out.println(rs.getInt("idDonViTinh"));
                donVi.add(rs.getInt("giaTri"));
                System.out.println(rs.getInt("giaTri"));
            }
        } catch (SQLException ex) {
        }
        return donVi;
    }
}
