/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.NhanVien;
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
public class NhanVienDAO {
    //Lay danh sach tat ca nhan vien
    public ArrayList<NhanVien> listNhanVien(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien";
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nhanvien = new NhanVien();
                
                nhanvien.setMaNV(rs.getString("MaNV"));
                nhanvien.setUsername(rs.getString("Username"));
                nhanvien.setPassword(rs.getString("Password"));
                nhanvien.setHoTen(rs.getString("HoTen"));
                nhanvien.setSDT(rs.getString("SDT"));
                nhanvien.setQuyen(rs.getString("Quyen"));
                nhanvien.setTrangThai(rs.getInt("TrangThai"));
                
                list.add(nhanvien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Lay danh sach nhan vien bang trang thai
    public ArrayList<NhanVien> listNhanVienByTrangThai(int trangthai){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE TrangThai = '"+trangthai+"'";
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nhanvien = new NhanVien();
                
                nhanvien.setMaNV(rs.getString("MaNV"));
                nhanvien.setUsername(rs.getString("Username"));
                nhanvien.setPassword(rs.getString("Password"));
                nhanvien.setHoTen(rs.getString("HoTen"));
                nhanvien.setSDT(rs.getString("SDT"));
                nhanvien.setQuyen(rs.getString("Quyen"));
                nhanvien.setTrangThai(rs.getInt("TrangThai"));
                
                list.add(nhanvien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Lay danh sach nhan vien dang hoat dong
    public ArrayList<NhanVien> listNhanVienHoatDong(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE TrangThai = '0'";
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nhanvien = new NhanVien();
                
                nhanvien.setMaNV(rs.getString("MaNV"));
                nhanvien.setUsername(rs.getString("Username"));
                nhanvien.setPassword(rs.getString("Password"));
                nhanvien.setHoTen(rs.getString("HoTen"));
                nhanvien.setSDT(rs.getString("SDT"));
                nhanvien.setQuyen(rs.getString("Quyen"));
                nhanvien.setTrangThai(rs.getInt("TrangThai"));
                
                list.add(nhanvien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Lay danh sach nhan vien dua vao quyen
    public ArrayList<NhanVien> listNhanVienByQuyen(String quyen){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE Quyen = '"+quyen+"'";
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nhanvien = new NhanVien();
                
                nhanvien.setMaNV(rs.getString("MaNV"));
                nhanvien.setUsername(rs.getString("Username"));
                nhanvien.setPassword(rs.getString("Password"));
                nhanvien.setHoTen(rs.getString("HoTen"));
                nhanvien.setSDT(rs.getString("SDT"));
                nhanvien.setQuyen(rs.getString("Quyen"));
                nhanvien.setTrangThai(rs.getInt("TrangThai"));
                
                list.add(nhanvien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Lay thong tin nhan vien dua vao MaNV
    public NhanVien getNhanVienByMaNV(String manv){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE MaNV = '"+manv+"'";
        NhanVien nhanvien = new NhanVien();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                               
                nhanvien.setMaNV(rs.getString("MaNV"));
                nhanvien.setUsername(rs.getString("Username"));
                nhanvien.setPassword(rs.getString("Password"));
                nhanvien.setHoTen(rs.getString("HoTen"));
                nhanvien.setSDT(rs.getString("SDT"));
                nhanvien.setQuyen(rs.getString("Quyen"));
                nhanvien.setTrangThai(rs.getInt("TrangThai"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhanvien;
    }
    //kiem tra ten dang nhap cua nhan vien
    public boolean KiemTraNhanVien(String Username){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE Username = '"+Username+"'";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                conn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //kiem tra ma NV
    public boolean KiemTraMaNV(String MaNV){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE MaNV = '"+MaNV+"'";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                conn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Them nhan vien
    public boolean themNhanVien(NhanVien nhanvien){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO nhanvien(MaNV, Username, Password, HoTen, SDT, Quyen) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nhanvien.getMaNV());
            ps.setString(2, nhanvien.getUsername());
            ps.setString(3, nhanvien.getPassword());
            ps.setString(4, nhanvien.getHoTen());
            ps.setString(5, nhanvien.getSDT());
            ps.setString(6, nhanvien.getQuyen());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Cap nhat nhan vien
    public boolean capNhatNhanVien(NhanVien nhanvien){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE nhanvien SET Password = ?, HoTen = ?, SDT = ?, Quyen = ? WHERE MaNV = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nhanvien.getPassword());
            ps.setString(2, nhanvien.getHoTen());
            ps.setString(3, nhanvien.getSDT());
            ps.setString(4, nhanvien.getQuyen());
            ps.setString(5, nhanvien.getMaNV());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Xoa nhan vien
    public boolean xoaNhanVien(String maNV){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE nhanvien SET TrangThai = '1' WHERE MaNV = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, maNV);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Kiem tra dang nhap
    public NhanVien KiemTraDangNhapNhanVien(String username, String password){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE Uswename = '"+username+"' AND Password = '"+password+"' And TrangThai = '0'";
        NhanVien nhanvien = new NhanVien();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                nhanvien.setMaNV(rs.getString("MaNV"));
                nhanvien.setUsername(rs.getString("Username"));
                nhanvien.setPassword(rs.getString("Password"));
                nhanvien.setHoTen(rs.getString("HoTen"));
                nhanvien.setSDT(rs.getString("SDT"));
                nhanvien.setQuyen(rs.getString("Quyen"));
                nhanvien.setTrangThai(rs.getInt("TranThai"));
                
                return nhanvien;
            }
        } catch (SQLException ex) {
            System.out.print("that bai");
            
        }
        return null;
    }
}
