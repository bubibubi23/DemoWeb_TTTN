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

    public SanPhamGioHang() {
    }

    public SanPhamGioHang(SanPham sanpham, int SoLuong) {
        this.sanpham = sanpham;
        this.SoLuong = SoLuong;
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

    
    
    
}
