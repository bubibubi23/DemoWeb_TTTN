/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.ChiTietPhieuNhap;
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
public class ChiTietPhieuNhapDAO {
    //Lay danh sach chi tiet phieu nhap dua vao MaPN
    public ArrayList<ChiTietPhieuNhap> listChiTietPhieuNhap(String MaPN){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM chitietphieunhap WHERE MaPN = '"+MaPN+"'";
        ArrayList<ChiTietPhieuNhap> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietPhieuNhap chitietphieunhap = new ChiTietPhieuNhap();
                
                chitietphieunhap.setMaPN(rs.getString("MaPN"));
                chitietphieunhap.setMaSP(rs.getString("MaSP"));
                chitietphieunhap.setSoLuong(rs.getInt("SoLuong"));
                chitietphieunhap.setDonGia(rs.getInt("DonGia"));
                
                list.add(chitietphieunhap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Them chi tiet phieu nhap
    public boolean themChiTietPhieuNhap(ChiTietPhieuNhap chitietphieunhap){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO chitietphieunhap(MaPN, MaSP, SoLuong, DonGia) VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, chitietphieunhap.getMaPN());
            ps.setString(2, chitietphieunhap.getMaSP());
            ps.setInt(3, chitietphieunhap.getSoLuong());
            ps.setInt(4, chitietphieunhap.getDonGia());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Xoa chi tiet phieu nhap
    public boolean xoaChiTietPhieuNhap(String MaPN){
        Connection conn = DBConnect.getConnection();
        String sql = "DELETE FROM chitietphieunhap WHERE MaPN = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, MaPN);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
