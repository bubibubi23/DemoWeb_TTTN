/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Acer_Aspire
 */
public class DonHang {
    private String MaDH;
    private String MaKH;
    private String MaNV;
    private Date NgayTao;
    private Date NgayChuyenHang;
    private String PhuongThucThanhToan;
    private String DiaChi;
    private String SDT;
    private String HoTen;
    private String TrangThai;
    private int TongTien;

    public DonHang() {
    }

    public DonHang(String MaDH, String MaKH, String MaNV, Date NgayTao, Date NgayChuyenHang, String PhuongThucThanhToan, String DiaChi, String SDT, String HoTen, String TrangThai, int TongTien) {
        this.MaDH = MaDH;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
        this.NgayChuyenHang = NgayChuyenHang;
        this.PhuongThucThanhToan = PhuongThucThanhToan;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.HoTen = HoTen;
        this.TrangThai = TrangThai;
        this.TongTien = TongTien;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayChuyenHang() {
        return NgayChuyenHang;
    }

    public void setNgayChuyenHang(Date NgayChuyenHang) {
        this.NgayChuyenHang = NgayChuyenHang;
    }

    public String getPhuongThucThanhToan() {
        return PhuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String PhuongThucThanhToan) {
        this.PhuongThucThanhToan = PhuongThucThanhToan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
