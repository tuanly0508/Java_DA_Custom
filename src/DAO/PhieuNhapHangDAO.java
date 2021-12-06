package DAO;

import Help.DBConnection;
import Model.ChiTietPhieuNhap;
import Model.PhieuNhapDichVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PhieuNhapHangDAO extends AbsDAO<PhieuNhapDichVu>{
    public List<Object[]> getDataPhieuNhapHang(){
        return getRawValues("select pn.maPhieuNhap, ncc.tenNhaCungCap, nv.hoTenNhanVien, pn.thoiGianNhap,format(pn.tongTien,'#,#')tongTien,pn.tienNo,pn.ghiChu,pn.trangThai from phieuNhapDichVu as pn \n" +
                            "join nhanVien as nv on pn.idNhanVien = nv.idNhanVien \n" +
                            "join nhaCungCap as ncc on pn.idNhaCungCap = ncc.idNhaCungCap \n" +
                            "where pn.trangThai = 1");
    } 
    
    public List<Object[]> getDataChiTietPN(String maPhieuNhap){
        return getRawValues("select maPhieuNhap,tenDichVu,soLuong,format(giaNhap,'#,#')giaNhap,tenDonVi from ChiTietPhieuNhap ctpn \n" +
                            "join donViTinh dvt on dvt.idDonViTinh=ctpn.idDonViTinh\n" +
                            "join dichVu dv on dv.idDichVu=ctpn.idDichVu where maPhieuNhap=?",maPhieuNhap);
    }

    public List<Object[]> getDichVu(){
        return getRawValues("select idDichVu,tenDichVu from DichVu");
    }
    
    public void deleteNhaCungCapTam(int idPhieuNhap){
        String query = "update phieuNhapDichVu set tinhTrang = '0' where idPhieuNhap = ?";
        DBConnection.executeUpdate(query, idPhieuNhap);
    }
    
    public void themPhieuNhap (PhieuNhapDichVu pn){
        String query ="insert into PhieuNhapDichVu values (?,?,?,?,?,?,?,?)";
        DBConnection.executeUpdate(query,pn.getMaPhieuNhap(),pn.getIdNhaCungCap(),pn.getIdNhanVien(),pn.getThoiGianNhap(),
                                        pn.getTongTien(),pn.getTienNo(),pn.getGhiChu(),pn.getTrangThai());
    }
    
    public void suaPhieuNhap (PhieuNhapDichVu pn){
        String query ="update PhieuNhapDichVu set idNhaCungCap=?,idNhanVien=?,thoiGianNhap=?,tongTien=?,tienNo=?,ghiChu=?,trangThai=? where maPhieuNhap =?";
        DBConnection.executeUpdate(query,pn.getIdNhaCungCap(),pn.getIdNhanVien(),pn.getThoiGianNhap(),
                                        pn.getTongTien(),pn.getTienNo(),pn.getGhiChu(),pn.getTrangThai(),pn.getMaPhieuNhap());
    }
    
    public void xoaPhieuNhap (String maPhieuNhap){
        DBConnection.executeUpdate("update PhieuNhapDichVu set trangThai =0 where maPhieuNhap = ?", maPhieuNhap);
    }
    
    
    
}
