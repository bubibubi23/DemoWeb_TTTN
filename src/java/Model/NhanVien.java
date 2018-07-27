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
public class NhanVien {
    private String MaNV;
    private String Username;
    private String Password;
    private String HoTen;
    private String SDT;
    private String Quyen;
    private int TrangThai;

    public NhanVien() {
    }
    
    public NhanVien(String MaNV, String Password, String HoTen, String SDT, String Quyen) {
        this.MaNV = MaNV;
        this.Username = Username;
        this.Password = Password;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Quyen = Quyen;       
    }
    
    public NhanVien(String MaNV, String Username, String Password, String HoTen, String SDT, String Quyen) {
        this.MaNV = MaNV;
        this.Username = Username;
        this.Password = Password;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Quyen = Quyen;       
    }

    public NhanVien(String MaNV, String Username, String Password, String HoTen, String SDT, String Quyen, int TrangThai) {
        this.MaNV = MaNV;
        this.Username = Username;
        this.Password = Password;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Quyen = Quyen;
        this.TrangThai = TrangThai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
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

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    

    
}
