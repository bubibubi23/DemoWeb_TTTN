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
public class ThongSoSanPham {
    private int MaTSSP;
    private String MaSP;
    private String ThongSoSP;

    public ThongSoSanPham() {
    }
    
    public ThongSoSanPham( String MaSP, String ThongSoSP) {
        
        this.MaSP = MaSP;
        this.ThongSoSP = ThongSoSP;
    }

    public ThongSoSanPham(int MaTSSP, String MaSP, String ThongSoSP) {
        this.MaTSSP = MaTSSP;
        this.MaSP = MaSP;
        this.ThongSoSP = ThongSoSP;
    }

    public int getMaTSSP() {
        return MaTSSP;
    }

    public void setMaTSSP(int MaTSSP) {
        this.MaTSSP = MaTSSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getThongSoSP() {
        return ThongSoSP;
    }

    public void setThongSoSP(String ThongSoSP) {
        this.ThongSoSP = ThongSoSP;
    }
    
    
}
