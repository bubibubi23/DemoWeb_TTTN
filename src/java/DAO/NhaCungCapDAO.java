/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.NhaCungCap;
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
public class NhaCungCapDAO {
    //Lay danh sach tat ca nha cung cap
    public ArrayList<NhaCungCap> listNhaCungCap(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhacungcap";
        ArrayList<NhaCungCap> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCap nhacungcap = new NhaCungCap();
                nhacungcap.setMaNCC(rs.getString("MaNCC"));
                nhacungcap.setTenNCC(rs.getString("TenNCC"));
                nhacungcap.setEmail(rs.getString("Email"));
                nhacungcap.setSDT(rs.getString("SDT"));
                nhacungcap.setDiaChi(rs.getString("DiaChi"));
                nhacungcap.setTrangThai(rs.getInt("TrangThai"));
                
                list.add(nhacungcap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Danh sach nha cung cap hien hanh
    public ArrayList<NhaCungCap> listNhaCungCapHienHanh(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhacungcap WHERE TrangThai = '0'";
        ArrayList<NhaCungCap> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCap nhacungcap = new NhaCungCap();
                nhacungcap.setMaNCC(rs.getString("MaNCC"));
                nhacungcap.setTenNCC(rs.getString("TenNCC"));
                nhacungcap.setEmail(rs.getString("Email"));
                nhacungcap.setSDT(rs.getString("SDT"));
                nhacungcap.setDiaChi(rs.getString("DiaChi"));
                nhacungcap.setTrangThai(rs.getInt("TrangThai"));
                
                list.add(nhacungcap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Thong tin nha cung cap
    public NhaCungCap getNhaCungCap(String MaNCC){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhacungcap WHERE MaNCC = '"+MaNCC+"'";
        
        NhaCungCap nhacungcap = new NhaCungCap();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nhacungcap.setMaNCC(rs.getString("MaNCC"));
                nhacungcap.setTenNCC(rs.getString("TenNCC"));
                nhacungcap.setEmail(rs.getString("Email"));
                nhacungcap.setSDT(rs.getString("SDT"));
                nhacungcap.setDiaChi(rs.getString("DiaChi"));
                nhacungcap.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhacungcap;
    }
    //Them nha cung cap
    public boolean themNhaCungCap(NhaCungCap nhacungcap){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO nhacungcap(MaNCC, TenNCC, Email, SDT, DiaChi) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nhacungcap.getMaNCC());
            ps.setString(2, nhacungcap.getTenNCC());
            ps.setString(3, nhacungcap.getEmail());
            ps.setString(4, nhacungcap.getSDT());
            ps.setString(5, nhacungcap.getDiaChi());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Cap nhat nha cung cap
    public boolean capNhatNhaCungCap(NhaCungCap nhacungcap){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE nhacungcap SET TenNCC = ?, Email = ?, SDT = ?, DiaChi = ? WHERE MaNCC = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nhacungcap.getTenNCC());
            ps.setString(2, nhacungcap.getEmail());
            ps.setString(3, nhacungcap.getSDT());
            ps.setString(4, nhacungcap.getDiaChi());
            ps.setString(5, nhacungcap.getMaNCC());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Xoa nha cung cap
    public boolean xoaNhaCungCap(String MaNCC){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE nhacungcap SET TrangThai = '1' WHERE MaNCC = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, MaNCC);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
