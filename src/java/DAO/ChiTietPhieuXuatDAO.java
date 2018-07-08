/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.ChiTietPhieuXuat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer_Aspire
 */
public class ChiTietPhieuXuatDAO {
    //Lay danh sach phieu xuat dua vao MaPX
    public ArrayList<ChiTietPhieuXuat> listChiTietPhieuXuat(String MaPX){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM chitietphieuxuat WHERE MaPX = '"+MaPX+"'";
        ArrayList<ChiTietPhieuXuat> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietPhieuXuat chitietphieuxuat = new ChiTietPhieuXuat();
                chitietphieuxuat.setMaPX(rs.getString("MaPX"));
                chitietphieuxuat.setMaSP(rs.getString("MaSP"));
                chitietphieuxuat.setSoLuong(rs.getInt("SoLuong"));
                chitietphieuxuat.setGia(rs.getInt("TongTien"));
                
                list.add(chitietphieuxuat);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
                
    }
    //Them chi tiet phieu xuat
    public boolean themChiTietPhieuXuat(ChiTietPhieuXuat chitietphieuxuat){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO chitietphieuxuat(MaPX, MaSP, SoLuong, TongTien) VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, chitietphieuxuat.getMaPX());
            ps.setString(2, chitietphieuxuat.getMaSP());
            ps.setInt(3, chitietphieuxuat.getSoLuong());
            ps.setInt(4, chitietphieuxuat.getGia());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Xoa chi tiet phieu xuat
    public boolean xoaChiTietPhieuXuat(String MaPX){
        Connection conn = DBConnect.getConnection();
        String sql = "DELETE FROM chitietphieuxuat WHERE MaPX = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, MaPX);
            
            return ps.executeUpdate() == 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
