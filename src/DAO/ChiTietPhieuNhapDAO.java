/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Help.DBConnection;
import Model.ChiTietPhieuNhap;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ChiTietPhieuNhapDAO extends AbsDAO<ChiTietPhieuNhap>{
    
    public List<Object[]> getChiTietPhieuNhap(String maPhieuNhap){
        return getRawValues("Select * from PhieuNhapDichVu where maPhieuNhap =?",maPhieuNhap);
    }
    
    public void themCTPN(ChiTietPhieuNhap ctpn){
        String query = "insert into ChiTietPhieuNhap values(?,?,?,?,?)";
        DBConnection.executeUpdate(query, ctpn.getMaPhieuNhap(),ctpn.getIdDichVu(),ctpn.getIdDonViTinh(),ctpn.getSoLuong(),ctpn.getGiaNhap());
    }
    
    public void xoaCTPN(String maPN,int idDichVu){
        DBConnection.executeUpdate("delete from ChiTietPhieuNhap where maPhieuNhap =? and idDichVu=?", maPN,idDichVu);
    }
}
