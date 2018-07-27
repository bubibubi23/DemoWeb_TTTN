/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.SanPham;
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
public class SanPhamDAO {
    //Lay tat ca danh sach san pham theo LoaiSP
    public ArrayList<SanPham> listSanPhamByLoaiSP(String LoaiSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE LoaiSP = '"+LoaiSP+"' AND TrangThai = '0'";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Tinh tong san pham theo LoaiSP
    public int tongSanPhamByLoaiSP(String LoaiSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT COUNT(MaSP) FROM sanpham WHERE LoaiSP = '"+LoaiSP+"' AND TrangThai = '0'";
        int count = 0;
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                count = rs.getInt(1);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    //Lay danh sach san pham phan dinh theo trang bang LoaiSP
    public ArrayList<SanPham> listSanPhamLoaiSPByPages(String LoaiSP, int firstResult, int maxResult){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE LoaiSP = '"+LoaiSP+"' AND TrangThai = '0' LIMIT ?, ?";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, firstResult);
            ps.setInt(2, maxResult);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Lay danh sach tat ca san pham bang MaNhomSP
    public ArrayList<SanPham> listSanPhamByMaNhomSP(String MaNhomSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP = '"+MaNhomSP+"' AND TrangThai = '0'";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Tinh tong san pham theo MaNhomSP
    public int tongSanPhamByMaNhomSP(String MaNhomSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT COUNT(MaSP) FROM sanpham WHERE MaNhomSP = '"+MaNhomSP+"' AND TrangThai = '0'";
        int count = 0; 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    //Lay danh sach san pham phan dinh theo trang bang MaNhomSP
    public ArrayList<SanPham> listSanPhamMaNhomSPByPages(String MaNhomSP, int firstResult, int maxResult){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP = '"+MaNhomSP+"' AND TrangThai = '0' LIMIT ?, ?";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, firstResult);
            ps.setInt(2, maxResult);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Lay thong tin san pham bang MaSP
    public SanPham getSanPhamByMaSP(String MaSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaSP = '" +MaSP+ "' AND TrangThai = '0'"; 
        SanPham sanpham = new SanPham();
        PreparedStatement ps;
        try {
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanpham;
    }
    
    //Lay danh sach san pham theo MaNhomSP va LoaiSP
    public ArrayList<SanPham> listSanPhamChiTiet(String MaNhomSP, String LoaiSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP = '"+MaNhomSP+"' AND LoaiSP = '"+LoaiSP+"' AND TrangThai = '0'";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Tinh tong san pham theo MaNhomSP va LoaiSP
    public int tongSanPhamChiTiet(String MaNhomSP, String LoaiSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT COUNT(MaSP) FROM sanpham WHERE MaNhomSP = '"+MaNhomSP+"' AND LoaiSP = '"+LoaiSP+"' AND TrangThai = '0'";
        int count = 0;
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    //Lay danh sach san pham phan dinh theo trang dua vao MaNhomSP va LoaiSP
    public ArrayList<SanPham> listSanPhamChiTietByPages(String MaNhomSP, String LoaiSP, int firstResult, int maxResult){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP = '"+MaNhomSP+"' AND LoaiSP = '"+LoaiSP+"' AND TrangThai = '0' LIMIT ?, ?";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, firstResult);
            ps.setInt(2, maxResult);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
    
    //Them san pham
    public boolean themSanPham(SanPham sanpham) {
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO sanpham(MaSP, TenSP, MaNhomSP, Gia, HinhAnh, MoTa, MaTSSP, LoaiSP) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, sanpham.getMaSP());
            ps.setString(2, sanpham.getTenSP());
            ps.setString(3, sanpham.getMaNhomSP());
            ps.setInt(4, sanpham.getGia());
            ps.setString(5, sanpham.getHinhAnh());
            ps.setString(6, sanpham.getMoTa());
            ps.setInt(7, sanpham.getMaTSSP());
            ps.setString(8, sanpham.getLoaiSP());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Cap nhat san pham
    public boolean capNhatSanPham(SanPham sanpham) {
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE sanpham SET TenSP = ?, MaNhomSP = ?, Gia = ?, HinhAnh = ?, MoTa = ?, LoaiSP = ? WHERE MaSP = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, sanpham.getTenSP());
            ps.setString(2, sanpham.getMaNhomSP());
            ps.setInt(3, sanpham.getGia());
            ps.setString(4, sanpham.getHinhAnh());
            ps.setString(5, sanpham.getMoTa());           
            ps.setString(6, sanpham.getLoaiSP());
            ps.setString(7, sanpham.getMaSP());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Xoa san pham
    public boolean xoaSanPham(String MaSP){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE sanpham SET TrangThai = '1' WHERE MaSP = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, MaSP);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Lay danh sach guitar moi
    public ArrayList<SanPham> listGuitarMoi(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP LIKE 'G%' AND TrangThai = '0' ORDER BY NgayThem DESC LIMIT 6";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Lay danh sach 4 san pham dau tien theo ma nhom SP
    public ArrayList<SanPham> list4GuitarByMaNhomSP(String MaNhomSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP = '"+MaNhomSP+"' AND TrangThai = '0' LIMIT 4";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Lay danh sach tat ca dan guitar theo trang thai
    public ArrayList<SanPham> listSanPhamByTrangThai(String TrangThai){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP LIKE 'G%' AND TrangThai = '"+TrangThai+"'";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Lay tat ca san pham
    public ArrayList<SanPham> listSanPham(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP LIKE 'G%'";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //lay ngau nhien 3 san pham
    public ArrayList<SanPham> listSanPhamRand(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaNhomSP LIKE 'G%' AND TrangThai = '0' ORDER BY RAND() LIMIT 3";
        ArrayList<SanPham> list = new ArrayList<>(); 
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sanpham = new SanPham();
                
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaNhomSP(rs.getString("MaNhomSP"));
                sanpham.setGia(rs.getInt("Gia"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setMoTa(rs.getString("MoTa"));
                sanpham.setMaTSSP(rs.getInt("MaTSSP"));
                sanpham.setNgayThem(rs.getDate("NgayThem"));
                sanpham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanpham.setSoLuongThem(rs.getInt("SoLuongNhap"));
                sanpham.setTrangThai(rs.getInt("TrangThai"));
                sanpham.setLoaiSP(rs.getString("LoaiSP"));
                
                list.add(sanpham);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Kiem tra MaSP 
    public boolean kiemTraMaSP(String MaSP){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM sanpham WHERE MaSP = '"+MaSP+"'";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                conn.close();
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
       
}
