/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import GUI_NhapHang.NhapHangPnl;
import DAO.NhaCungCapDAO;
import Model.NhaCungCap;
import java.util.List;

/**
 *
 * @author Dongnguyen
 */
public class NhaCungCapController {
    NhapHangPnl view;
    public NhaCungCapController(NhapHangPnl view){
        this.view = view;
        loadList();
        view.setControllerNhaCungCap(this);
    }
    
    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();

    public void loadList(){
        List<Object[]> nhaCungCaps = nhaCungCapDAO.getDataStaff();
        view.viewTableStaff(nhaCungCaps);      
    }  
    
    public void insert(String tenNhaCungCap, String SDTNhaCungCap, String diaChi, Double tienNo){
        NhaCungCap nhaCungCap = new NhaCungCap(0,tenNhaCungCap,SDTNhaCungCap,diaChi,tienNo,true);
        nhaCungCapDAO.insert(nhaCungCap);
        loadList();
    }
    
    public NhaCungCap getByIdNhaCungCap (Integer id) {
        return nhaCungCapDAO.getById(id);
    }
    
    public void xoaNhaCungCap(int idNhaCungCap){
        nhaCungCapDAO.deleteNhaCungCapTam(idNhaCungCap);
        loadList();
    }

    public void update(int idNhaCungCap,String tenNhaCungCap, String SDTNhaCungCap, String diaChi, Double tienNo){
        NhaCungCap nhaCungCap = new NhaCungCap(idNhaCungCap,tenNhaCungCap,SDTNhaCungCap,diaChi,tienNo,true);
        nhaCungCapDAO.edit(nhaCungCap);
        loadList();
    }
}
