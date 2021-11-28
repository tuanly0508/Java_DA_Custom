/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Help.DBConnection;
import Model.NhaCungCap;
import java.util.List;

/**
 *
 * @author Dongnguyen
 */
public class NhaCungCapDAO extends AbsDAO<NhaCungCap>{
    public List<Object[]> getDataStaff(){
        return getRawValues("select * from nhaCungCap where tinhTrang = 1");
    }
    
    public void deleteNhaCungCapTam(int idNhaCungCap){
        String query = "update nhaCungCap set tinhTrang = '0' where idNhaCungCap = ?";
        DBConnection.executeUpdate(query, idNhaCungCap);
    }    
}
