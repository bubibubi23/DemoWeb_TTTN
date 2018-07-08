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
public class NhomSanPham {
    private String MaNhomSP;
    private String TenNhomSP;

    public NhomSanPham(String MaNhomSP, String TenNhomSP) {
        this.MaNhomSP = MaNhomSP;
        this.TenNhomSP = TenNhomSP;
    }

    

    public NhomSanPham() {
    }

    public String getMaNhomSP() {
        return MaNhomSP;
    }

    public void setMaNhomSP(String MaNhomSP) {
        this.MaNhomSP = MaNhomSP;
    }

    public String getTenNhomSP() {
        return TenNhomSP;
    }

    public void setTenNhomSP(String TenNhomSP) {
        this.TenNhomSP = TenNhomSP;
    }
    
    
    
}
