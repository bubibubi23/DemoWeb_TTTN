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
public class KhachHang {
    private String MaKH;
    private String HoTen;
    private String DiaChi;
    private String SDT;
    private String GioiTinh;
    private String Email;
    private String Username;
    private String Password;
    private int TrangThai;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String HoTen, String DiaChi, String SDT, String GioiTinh, String Email, String Username, String Password, int TrangThai) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.TrangThai = TrangThai;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
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

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    

    
}
