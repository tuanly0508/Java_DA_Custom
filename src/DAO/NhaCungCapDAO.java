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
        return getRawValues("select idNhaCungCap,tenNhaCungCap,SDTNhaCungCap,diachi,format(tienNo,'#,0') tienNo from nhaCungCap where tinhTrang = 1");
    }
    
    public void deleteNhaCungCapTam(int idNhaCungCap){
        String query = "update nhaCungCap set tinhTrang = '0' where idNhaCungCap = ?";
        DBConnection.executeUpdate(query, idNhaCungCap);
    } 
    
    public boolean checkSDTNCCExist(String phone){
        List<Object[]> data=getRawValues("select COUNT(*) from nhaCungCap where SDTNhaCungCap = ?", phone);
        Integer count =(Integer) data.get(0)[0];
        return count >0;
    }
}
