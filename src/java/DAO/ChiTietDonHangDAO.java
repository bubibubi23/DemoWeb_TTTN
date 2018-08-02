/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect;
import Model.ChiTietDonHang;
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
public class ChiTietDonHangDAO {
    //Lay danh sach chi tiet don hang bang MaDH
    public ArrayList<ChiTietDonHang> listChiTietDonHangByMaDH(int MaDH){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM chitietdonhang WHERE MaDH = '"+MaDH+"'";
        ArrayList<ChiTietDonHang> list = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietDonHang chitietdonhang = new ChiTietDonHang();
                chitietdonhang.setMaDH(rs.getInt("MaDH"));
                chitietdonhang.setMaSP(rs.getString("MaSP"));
                chitietdonhang.setSoLuong(rs.getInt("SoLuong"));
                chitietdonhang.setGia(rs.getInt("Gia"));
                
                list.add(chitietdonhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Them chi tiet don hang
    public boolean themChiTietDonHang(ChiTietDonHang chitietdonhang){
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO chitietdonhang(MaDH, MaSP, SoLuong, Gia) VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement ps= conn.prepareCall(sql);
            ps.setInt(1, chitietdonhang.getMaDH());
            ps.setString(2, chitietdonhang.getMaSP());
            ps.setInt(3, chitietdonhang.getSoLuong());
            ps.setInt(4, chitietdonhang.getGia());
            
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
