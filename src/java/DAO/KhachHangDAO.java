/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.KhachHang;
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
public class KhachHangDAO {
    //Lay danh sach tat ca khach hang
    public ArrayList<KhachHang> listKhachHang(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM khachhang";
        ArrayList<KhachHang> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang khachhang = new KhachHang();
                
                khachhang.setMaKH(rs.getInt("MaKH"));
                khachhang.setHoTen(rs.getString("HoTen"));
                khachhang.setDiaChi(rs.getString("DiaChi"));
                khachhang.setSDT(rs.getString("SDT"));
                khachhang.setGioiTinh(rs.getString("GioiTinh"));
                khachhang.setEmail(rs.getString("Email"));
                khachhang.setUsername(rs.getString("Username"));
                khachhang.setPassword(rs.getString("Password"));
                khachhang.setTrangThai(rs.getShort("TrangThai"));
                
                list.add(khachhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Tim thong tin khach hang bang username
    public KhachHang timKhachHang(String username){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM khachhang WHERE Username = '"+username+"'";
        KhachHang khachhang = new KhachHang();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            khachhang.setMaKH(rs.getInt("MaKH"));
            khachhang.setHoTen(rs.getString("HoTen"));
            khachhang.setDiaChi(rs.getString("DiaChi"));
            khachhang.setSDT(rs.getString("SDT"));
            khachhang.setGioiTinh(rs.getString("GioiTinh"));
            khachhang.setEmail(rs.getString("Email"));
            khachhang.setUsername(rs.getString("Username"));
            khachhang.setPassword(rs.getString("Password"));
            khachhang.setTrangThai(rs.getInt("TrangThai"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachhang;
    }
    //Kiem tra dang ky khach hang
    public boolean KiemTraDangKyKhachHang(String Username){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM khachhang WHERE Username = '"+Username+"'";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                conn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //kiem tra dang nhap khach hang
    public KhachHang KiemTraDangNhapKhachHang(String Username, String Password){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM khachhang WHERE Username = '"+Username+"' AND Password = '"+Password+"'";
        
        KhachHang khachhang = new KhachHang();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            khachhang.setMaKH(rs.getInt("MaKH"));
            khachhang.setHoTen(rs.getString("HoTen"));
            khachhang.setDiaChi(rs.getString("DiaChi"));
            khachhang.setSDT(rs.getString("SDT"));
            khachhang.setGioiTinh(rs.getString("GioiTinh"));
            khachhang.setEmail(rs.getString("Email"));
            khachhang.setUsername(rs.getString("Username"));
            khachhang.setPassword(rs.getString("Password"));
            khachhang.setTrangThai(rs.getInt("TrangThai"));
            
            return khachhang;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    //Them khach hang
    public boolean themKhacHang(KhachHang khachhang){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO khachhang(Email, Username, Password) VALUES(?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);           
            
            ps.setString(1, khachhang.getEmail());
            ps.setString(2, khachhang.getUsername());
            ps.setString(3, khachhang.getPassword());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Cap nhat khach hang
    public boolean capNhatKhachHang(KhachHang khachhang){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE khachhang SET HoTen = ?, DiaChi = ?, SDT = ?, GioiTinh = ?, Email = ?, Username = ?, Password = ? WHERE MaKH = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, khachhang.getHoTen());
            ps.setString(2, khachhang.getDiaChi());
            ps.setString(3, khachhang.getSDT());
            ps.setString(4, khachhang.getGioiTinh());
            ps.setString(5, khachhang.getEmail());
            ps.setString(6, khachhang.getUsername());
            ps.setString(7, khachhang.getPassword());
            ps.setInt(8, khachhang.getMaKH());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Xoa khach hang
    public boolean xoaKhachHang(String MaKH){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE khachhang SET TrangThai = '1' WHERE MaKH = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, MaKH);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int tongKhachHang(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT COUNT(MaKH) FROM khachhang";
        int count = 0;
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    
}
