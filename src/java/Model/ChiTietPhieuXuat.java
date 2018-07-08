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
public class ChiTietPhieuXuat {
    private String MaPX;
    private String MaSP;
    private int SoLuong;
    private int Gia;

    public ChiTietPhieuXuat() {
    }

    public ChiTietPhieuXuat(String MaPX, String MaSP, int SoLuong, int Gia) {
        this.MaPX = MaPX;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
    }

    public String getMaPX() {
        return MaPX;
    }

    public void setMaPX(String MaPX) {
        this.MaPX = MaPX;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
    
    
}
