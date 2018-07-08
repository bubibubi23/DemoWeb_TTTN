/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.PhieuNhap;
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
public class PhieuNhapDAO {
    //Lay danh sach phieu nhap
    public ArrayList<PhieuNhap> listPhieuNhap(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM phieunhap";
        
        ArrayList<PhieuNhap> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuNhap phieunhap = new PhieuNhap();
                
                phieunhap.setMaPN(rs.getString("MaPN"));
                phieunhap.setMaNCC(rs.getString("MaNCC"));
                phieunhap.setMaNV(rs.getString("MaNV"));
                phieunhap.setNgayTao(rs.getDate("NgayTao"));
                phieunhap.setNoiDung(rs.getString("NoiDung"));
                phieunhap.setTrangThai(rs.getString("TrangThai"));
                
                list.add(phieunhap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Them phieu nhap
    public boolean themPhieuNhap(PhieuNhap phieunhap){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO phieunhap(MaPN, MaNCC, MaNV, NoiDung, TrangThai) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, phieunhap.getMaPN());
            ps.setString(2, phieunhap.getMaNCC());
            ps.setString(3, phieunhap.getMaNV());
            ps.setString(4, phieunhap.getNoiDung());
            ps.setString(5, phieunhap.getTrangThai());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Cap nhat phieu nhap
    public boolean capNhatPhieuNhap(PhieuNhap phieunhap){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE phieunhap SET TrangThai = ? WHERE MaPN = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, phieunhap.getTrangThai());
            ps.setString(2, phieunhap.getMaPN());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Xoa phieu nhap
    public boolean xoaPhieuNhap(String MaPN){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE phieunhap SET TrangThai = 'Da huy' WHERE MaPN = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, MaPN);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
