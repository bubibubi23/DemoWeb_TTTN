/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Acer_Aspire
 */
public class PhieuNhap {
    private String MaPN;
    private String MaNCC;
    private String MaNV;
    private Date NgayTao;
    private String NoiDung;
    private String TrangThai;

    public PhieuNhap() {
    }

    public PhieuNhap(String MaPN, String MaNCC, String MaNV, Date NgayTao, String NoiDung, String TrangThai) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
        this.NoiDung = NoiDung;
        this.TrangThai = TrangThai;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
