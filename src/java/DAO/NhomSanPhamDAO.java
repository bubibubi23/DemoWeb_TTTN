/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.NhomSanPham;
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
public class NhomSanPhamDAO {
    
    //Lay danh sach nhom guitar
    public ArrayList<NhomSanPham> getListGuitar(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhomsanpham WHERE MaNhomSP LIKE 'G%'";
        ArrayList<NhomSanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhomSanPham nhomsanpham = new NhomSanPham();
                nhomsanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                nhomsanpham.setTenNhomSP(rs.getString("TenNhomSP"));
                list.add(nhomsanpham);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhomSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //lay danh sach nhom phu kien
    public ArrayList<NhomSanPham> getListPhuKien(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhomsanpham WHERE MaNhomSP LIKE 'N%'";
        ArrayList<NhomSanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhomSanPham nhomsanpham = new NhomSanPham();
                nhomsanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                nhomsanpham.setTenNhomSP(rs.getString("TenNhomSP"));
                list.add(nhomsanpham);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhomSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Lay thong tin nhom san pham
    public NhomSanPham getNhomSanPham(String MaNhomSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhomsanpham WHERE MaNhomSP = '"+MaNhomSP+"'";
        NhomSanPham nhomsanpham = new NhomSanPham();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                nhomsanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                nhomsanpham.setTenNhomSP(rs.getString("TenNhomSP"));
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhomSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhomsanpham;
    }
    
}
