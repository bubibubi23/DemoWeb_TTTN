/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.DonHang;
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
public class DonHangDAO {
    //Lay danh sach don hang
    public ArrayList<DonHang> listDonHang(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM donhang";
        ArrayList<DonHang> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DonHang donhang = new DonHang();
                
                donhang.setMaDH(rs.getInt("MaDH"));
                donhang.setMaKH(rs.getInt("MaKH"));
                donhang.setMaNV(rs.getString("MaNV"));
                donhang.setNgayTao(rs.getDate("NgayTao"));
                donhang.setNgayChuyenHang(rs.getDate("NgayChuyenHang"));
                donhang.setPhuongThucThanhToan(rs.getString("PhuongThucThanhToan"));
                donhang.setDiaChi(rs.getString("DiaChi"));
                donhang.setSDT(rs.getString("SDT"));
                donhang.setTrangThai(rs.getString("TrangThai"));
                donhang.setHoTen(rs.getString("HoTen"));
                donhang.setTongTien(rs.getInt("TongTien"));
                
                list.add(donhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    //Lay danh sach don hang bang MaKH
    public ArrayList<DonHang> listDonHangByMaKH(int MaKH){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM donhang WHERE MaKH = '"+MaKH+"'";
        ArrayList<DonHang> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DonHang donhang = new DonHang();
                
                donhang.setMaDH(rs.getInt("MaDH"));
                donhang.setMaKH(rs.getInt("MaKH"));
                donhang.setMaNV(rs.getString("MaNV"));
                donhang.setNgayTao(rs.getDate("NgayTao"));
                donhang.setNgayChuyenHang(rs.getDate("NgayChuyenHang"));
                donhang.setPhuongThucThanhToan(rs.getString("PhuongThucThanhToan"));
                donhang.setDiaChi(rs.getString("DiaChi"));
                donhang.setSDT(rs.getString("SDT"));
                donhang.setTrangThai(rs.getString("TrangThai"));
                donhang.setHoTen(rs.getString("HoTen"));
                donhang.setTongTien(rs.getInt("TongTien"));
                
                list.add(donhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    //Danh sach don hang theo MaNV
    public ArrayList<DonHang> listDonHangByMaNV(String MaNV){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM donhang WHERE MaNV = '"+MaNV+"'";
        ArrayList<DonHang> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DonHang donhang = new DonHang();
                
                donhang.setMaDH(rs.getInt("MaDH"));
                donhang.setMaKH(rs.getInt("MaKH"));
                donhang.setMaNV(rs.getString("MaNV"));
                donhang.setNgayTao(rs.getDate("NgayTao"));
                donhang.setNgayChuyenHang(rs.getDate("NgayChuyenHang"));
                donhang.setPhuongThucThanhToan(rs.getString("PhuongThucThanhToan"));
                donhang.setDiaChi(rs.getString("DiaChi"));
                donhang.setSDT(rs.getString("SDT"));
                donhang.setTrangThai(rs.getString("TrangThai"));
                donhang.setHoTen(rs.getString("HoTen"));
                donhang.setTongTien(rs.getInt("TongTien"));
                
                list.add(donhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    //Lay thong tin don hang
    public DonHang getDonHang(int maDH){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM donhang WHERE MaDH = '"+maDH+"'";
        DonHang donhang = new DonHang();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                donhang.setMaDH(rs.getInt("MaDH"));
                donhang.setMaKH(rs.getInt("MaKH"));
                donhang.setMaNV(rs.getString("MaNV"));
                donhang.setNgayTao(rs.getDate("NgayTao"));
                donhang.setNgayChuyenHang(rs.getDate("NgayChuyenHang"));
                donhang.setPhuongThucThanhToan(rs.getString("PhuongThucThanhToan"));
                donhang.setDiaChi(rs.getString("DiaChi"));
                donhang.setSDT(rs.getString("SDT"));
                donhang.setTrangThai(rs.getString("TrangThai"));
                donhang.setHoTen(rs.getString("HoTen"));
                donhang.setTongTien(rs.getInt("TongTien"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donhang;  
    }
    //Lay danh sach don hang dua vao trang thai
    public ArrayList<DonHang> listDonHangByTrangThai(String trangthai){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM donhang WHERE TrangThai = '"+trangthai+"'";
        ArrayList<DonHang> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DonHang donhang = new DonHang();
                
                donhang.setMaDH(rs.getInt("MaDH"));
                donhang.setMaKH(rs.getInt("MaKH"));
                donhang.setMaNV(rs.getString("MaNV"));
                donhang.setNgayTao(rs.getDate("NgayTao"));
                donhang.setNgayChuyenHang(rs.getDate("NgayChuyenHang"));
                donhang.setPhuongThucThanhToan(rs.getString("PhuongThucThanhToan"));
                donhang.setDiaChi(rs.getString("DiaChi"));
                donhang.setSDT(rs.getString("SDT"));
                donhang.setTrangThai(rs.getString("TrangThai"));
                donhang.setHoTen(rs.getString("HoTen"));
                donhang.setTongTien(rs.getInt("TongTien"));
                
                list.add(donhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    //Them don hang
    public boolean themDonHang(DonHang donhang){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO donhang(MaDH, MaKH, PhuongThucThanhToan, DiaChi, SDT, HoTen, TrangThai, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, donhang.getMaDH());
            ps.setInt(2, donhang.getMaKH());
            ps.setString(3, donhang.getPhuongThucThanhToan());
            ps.setString(4, donhang.getDiaChi());
            ps.setString(5, donhang.getSDT());
            ps.setString(6, donhang.getHoTen());
            ps.setString(7, donhang.getTrangThai());
            ps.setInt(8, donhang.getTongTien());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }
    //Cap nhat don hang
    public boolean capNhatDonHang(DonHang donhang){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE donhang SET TrangThai = ?, MaNV = ? WHERE MaDH = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, donhang.getTrangThai());
            ps.setString(2, donhang.getMaNV());
            ps.setInt(3, donhang.getMaDH());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }
    //Cap nhat trang thai don hang
    public boolean capNhatTrangThaiDonHang(String maDH, String trangthai){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE donhang SET TrangThai = ? WHERE MaDH = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, trangthai);
            ps.setString(2, maDH);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }
    
    public int tongDonHang(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT COUNT(MaDH) FROM donhang";
        int count = 0;
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                count = rs.getInt(1);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    } 
    
}
