/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.NhanVienGiaoHang;
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
public class NhanVienGiaoHangDAO {
    //Lay danh sach nhan vien giao hang
    public ArrayList<NhanVienGiaoHang> listNhanVienGiaoHang(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanviengiaohang";
        
        ArrayList<NhanVienGiaoHang> list = new ArrayList<>();
        
            PreparedStatement ps;
        try {
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienGiaoHang nhanviengiaohang = new NhanVienGiaoHang();
                
                nhanviengiaohang.setMaNVGiaoHang(rs.getString("MaNVGiaoHang"));
                nhanviengiaohang.setHoTen(rs.getString("HoTen"));
                nhanviengiaohang.setSDT(rs.getString("SDT"));
                nhanviengiaohang.setEmail(rs.getString("Email"));
                nhanviengiaohang.setDiaChi(rs.getString("DiaChi"));
                nhanviengiaohang.setTrangThai(rs.getString("TrangThai"));
                
                list.add(nhanviengiaohang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGiaoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return list;
    }
    //Lay danh sach nhan vien giao hang dua vao trang thai
    public ArrayList<NhanVienGiaoHang> listNhanVienGiaoHangTrangThai(String TrangThai){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanviengiaohang WHERE TrangThai = '"+TrangThai+"'";
        
        ArrayList<NhanVienGiaoHang> list = new ArrayList<>();
        
            PreparedStatement ps;
        try {
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienGiaoHang nhanviengiaohang = new NhanVienGiaoHang();
                
                nhanviengiaohang.setMaNVGiaoHang(rs.getString("MaNVGiaoHang"));
                nhanviengiaohang.setHoTen(rs.getString("HoTen"));
                nhanviengiaohang.setSDT(rs.getString("SDT"));
                nhanviengiaohang.setEmail(rs.getString("Email"));
                nhanviengiaohang.setDiaChi(rs.getString("DiaChi"));
                nhanviengiaohang.setTrangThai(rs.getString("TrangThai"));
                
                list.add(nhanviengiaohang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGiaoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return list;
    }
    //Lay thong tin nhan vien giao hang dua vao ID
    public NhanVienGiaoHang getNhanVienGiaoHang(String MaNVGiaoHang){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanviengiaohang WHERE MaNVGiaoHang = '"+MaNVGiaoHang+"'";
        
        NhanVienGiaoHang nhanviengiaohang = new NhanVienGiaoHang();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            nhanviengiaohang.setMaNVGiaoHang(rs.getString("MaNVGiaoHang"));
            nhanviengiaohang.setHoTen(rs.getString("HoTen"));
            nhanviengiaohang.setSDT(rs.getString("SDT"));
            nhanviengiaohang.setEmail(rs.getString("Email"));
            nhanviengiaohang.setDiaChi(rs.getString("DiaChi"));
            nhanviengiaohang.setTrangThai(rs.getString("TrangThai"));
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGiaoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhanviengiaohang;
    }
    //Them nhan vien giao hang
    public boolean themNhanVienGiaoHang(NhanVienGiaoHang nhanviengiaohang){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO nhanviengiaohang(MaNVGiaoHang, HoTen, SDT, Email, DiaChi) VALUES(?, ? , ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nhanviengiaohang.getMaNVGiaoHang());
            ps.setString(2, nhanviengiaohang.getHoTen());
            ps.setString(3, nhanviengiaohang.getSDT());
            ps.setString(4, nhanviengiaohang.getEmail());
            ps.setString(5, nhanviengiaohang.getDiaChi());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGiaoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Cap nhat nhan vien giao hang
    public boolean capNhatNhanVienGiaoHang(NhanVienGiaoHang nhanviengiaohang){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE nhanviengiaohang SET HoTen = ?, SDT = ?, Email = ?, DiaChi = ?, TrangThai = ? WHERE MaNVGiaoHang = ?";
        
        try {
            PreparedStatement ps =conn.prepareCall(sql);
            ps.setString(1, nhanviengiaohang.getHoTen());
            ps.setString(2, nhanviengiaohang.getSDT());
            ps.setString(3, nhanviengiaohang.getEmail());
            ps.setString(4, nhanviengiaohang.getDiaChi());
            ps.setString(5, nhanviengiaohang.getTrangThai());
            ps.setString(6, nhanviengiaohang.getMaNVGiaoHang());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGiaoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Xoa nhan vien giao hang
    public boolean xoaNhanVienGiaoHang(String MaNVGiaoHang){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE nhanviengiaohang SET TrangThai = '1' WHERE MaNVGiaoHang = ?";
        
        try {
            PreparedStatement ps =conn.prepareCall(sql);
           
            ps.setString(1, MaNVGiaoHang);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGiaoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
