/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.ThongSoSanPham;
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
public class ThongSoSanPhamDAO {
    //Lay danh sach Thong so san pham
    public ArrayList<ThongSoSanPham> listThongSoSanPham(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM thongsosanpham";
        
        ArrayList<ThongSoSanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongSoSanPham thongsosanpham = new ThongSoSanPham();
                
                thongsosanpham.setMaTSSP(rs.getString("MaTSSP"));
                thongsosanpham.setMaSP(rs.getString("MaSP"));
                thongsosanpham.setThongSoSP(rs.getString("ThongSoSanPham"));
                
                list.add(thongsosanpham);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongSoSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Lay thong so san pham
    public ThongSoSanPham getThongSoSanPham(String MaTSSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM thongsosanpham WHERE MaTSSP = '"+MaTSSP+"'";
        
        ThongSoSanPham thongsosanpham = new ThongSoSanPham();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            thongsosanpham.setMaTSSP(rs.getString("MaTSSP"));
            thongsosanpham.setMaSP(rs.getString("MaSP"));
            thongsosanpham.setThongSoSP(rs.getString("ThongSoSanPham"));
        } catch (SQLException ex) {
            Logger.getLogger(ThongSoSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thongsosanpham;
    }
    //Them thong so san pham
    public boolean themThongSoSanPham(ThongSoSanPham thongsosanpham){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO thongsosanpham(MaTSSP, MaSP, ThongSoSanPham) VALUES(?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, thongsosanpham.getMaTSSP());
            ps.setString(2, thongsosanpham.getMaSP());
            ps.setString(3, thongsosanpham.getThongSoSP());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ThongSoSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Cap nhat thong so san pham
    public boolean capNhatThongSoSanPham(ThongSoSanPham thongsosanpham){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE thongsosanpham SET thongsosanpham = ? WHERE MaTSSP = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, thongsosanpham.getThongSoSP());
            ps.setString(2, thongsosanpham.getMaTSSP());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ThongSoSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
