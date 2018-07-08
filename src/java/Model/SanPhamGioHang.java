/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Acer_Aspire
 */
public class SanPhamGioHang {
    private SanPham sanpham;
    private int SoLuong;
    private int DonGia;

    public SanPhamGioHang() {
    }

    public SanPhamGioHang(SanPham sanpham, int SoLuong, int DonGia) {
        this.sanpham = sanpham;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    
    
    
}
