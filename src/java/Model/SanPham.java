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
public class SanPham {
    private String MaSP;
    private String TenSP;
    private String MaNhomSP;
    private int Gia;
    private String HinhAnh;
    private String MoTa;
    private int MaTSSP;
    private Date NgayThem;
    private int SoLuongTon;
    private int SoLuongThem;
    private int TrangThai;
    private String LoaiSP;

    public SanPham() {
    }
    
    public SanPham(String MaSP, String TenSP, String MaNhomSP, int Gia, String HinhAnh, String MoTa, int MaTSSP, String LoaiSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaNhomSP = MaNhomSP;
        this.Gia = Gia;
        this.HinhAnh = HinhAnh;
        this.MoTa = MoTa;
        this.MaTSSP = MaTSSP;
        this.LoaiSP = LoaiSP;
    }
    
    public SanPham(String MaSP, String TenSP, String MaNhomSP, int Gia, String HinhAnh, String MoTa, String LoaiSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaNhomSP = MaNhomSP;
        this.Gia = Gia;
        this.HinhAnh = HinhAnh;
        this.MoTa = MoTa;
        this.LoaiSP = LoaiSP;
    }

    public SanPham(String MaSP, String TenSP, String MaNhomSP, int Gia, String HinhAnh, String MoTa, int MaTSSP, Date NgayThem, int SoLuongTon, int SoLuongThem, int TrangThai, String LoaiSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaNhomSP = MaNhomSP;
        this.Gia = Gia;
        this.HinhAnh = HinhAnh;
        this.MoTa = MoTa;
        this.MaTSSP = MaTSSP;
        this.NgayThem = NgayThem;
        this.SoLuongTon = SoLuongTon;
        this.SoLuongThem = SoLuongThem;
        this.TrangThai = TrangThai;
        this.LoaiSP = LoaiSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMaNhomSP() {
        return MaNhomSP;
    }

    public void setMaNhomSP(String MaNhomSP) {
        this.MaNhomSP = MaNhomSP;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getMaTSSP() {
        return MaTSSP;
    }

    public void setMaTSSP(int MaTSSP) {
        this.MaTSSP = MaTSSP;
    }

    public Date getNgayThem() {
        return NgayThem;
    }

    public void setNgayThem(Date NgayThem) {
        this.NgayThem = NgayThem;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public int getSoLuongThem() {
        return SoLuongThem;
    }

    public void setSoLuongThem(int SoLuongThem) {
        this.SoLuongThem = SoLuongThem;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }           
}
