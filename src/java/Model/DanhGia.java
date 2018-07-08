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
public class DanhGia {
    private String MaDG;
    private String MaSP;
    private String danhgia;

    public DanhGia() {
    }

    public DanhGia(String MaDG, String MaSP, String danhgia) {
        this.MaDG = MaDG;
        this.MaSP = MaSP;
        this.danhgia = danhgia;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(String danhgia) {
        this.danhgia = danhgia;
    }
    
    
}
