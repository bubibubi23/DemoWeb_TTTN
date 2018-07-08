/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.PhieuXuat;
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
public class PhieuXuatDAO {
    //Lay danh sach phieu xuat
    public ArrayList<PhieuXuat> listPhieuXuat(){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM phieuxuat";
        
        ArrayList<PhieuXuat> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuXuat phieuxuat = new PhieuXuat();
                
                phieuxuat.setMaPX(rs.getString("MaPX"));
                phieuxuat.setMaDH(rs.getString("MaDH"));
                phieuxuat.setMaNV(rs.getString("MaNV"));
                phieuxuat.setNgayTao(rs.getDate("NgayTao"));
                phieuxuat.setMaNVGiao(rs.getString("MaNVGiao"));
                phieuxuat.setTrangThai(rs.getString("TrangThai"));
                
                list.add(phieuxuat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Them phieu xuat
    public boolean themPhieuXuat(PhieuXuat phieuxuat){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO phieuxuat(MaPX, MaDH, MaNV, MaNVGiao, TrangThai) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, phieuxuat.getMaPX());
            ps.setString(2, phieuxuat.getMaDH());
            ps.setString(3, phieuxuat.getMaNV());
            ps.setString(4, phieuxuat.getMaNVGiao());
            ps.setString(5, phieuxuat.getTrangThai());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    //Cap nhat trang thai phieu xuat
    public boolean capNhatTrangThaiPhieuXuat(String TrangThai, String MaPX){
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE phieuxuat SET TrangThai = ? WHERE MaPX = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, TrangThai);
            ps.setString(2, MaPX);
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
