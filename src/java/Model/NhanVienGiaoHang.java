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
public class NhanVienGiaoHang {
    private String MaNVGiaoHang;
    private String HoTen;
    private String SDT;
    private String Email;
    private String TrangThai;
    private String DiaChi;

    public NhanVienGiaoHang() {
    }
    
    
    
    public NhanVienGiaoHang(String MaNVGiaoHang, String HoTen, String Sdt, String Email, String DiaChi) {
        this.MaNVGiaoHang = MaNVGiaoHang;
        this.HoTen = HoTen;
        this.SDT = Sdt;
        this.Email = Email;
        this.DiaChi = DiaChi;
    }

    public NhanVienGiaoHang(String MaNVGiaoHang, String HoTen, String Sdt, String Email, String TrangThai, String DiaChi) {
        this.MaNVGiaoHang = MaNVGiaoHang;
        this.HoTen = HoTen;
        this.SDT = Sdt;
        this.Email = Email;
        this.TrangThai = TrangThai;
        this.DiaChi = DiaChi;
    }

    public String getMaNVGiaoHang() {
        return MaNVGiaoHang;
    }

    public void setMaNVGiaoHang(String MaNVGiaoHang) {
        this.MaNVGiaoHang = MaNVGiaoHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
}
