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
public class NhaCungCap {
    private String MaNCC;
    private String TenNCC;
    private String Email;
    private String SDT;
    private String DiaChi;
    private int TrangThai;

    public NhaCungCap() {
    }

    public NhaCungCap(String MaNCC, String TenNCC, String Email, String SDT, String DiaChi, int TrangThai) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
