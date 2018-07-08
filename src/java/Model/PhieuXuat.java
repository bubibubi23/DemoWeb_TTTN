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
public class PhieuXuat {
    private String MaPX;
    private String MaDH;
    private String MaNV;
    private Date NgayTao;
    private String MaNVGiao;
    private String TrangThai;

    public PhieuXuat() {
    }

    public PhieuXuat(String MaPX, String MaDH, String MaNV, Date NgayTao, String MaNVGiao, String TrangThai) {
        this.MaPX = MaPX;
        this.MaDH = MaDH;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
        this.MaNVGiao = MaNVGiao;
        this.TrangThai = TrangThai;
    }

    public String getMaPX() {
        return MaPX;
    }

    public void setMaPX(String MaPX) {
        this.MaPX = MaPX;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
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

    public String getMaNVGiao() {
        return MaNVGiao;
    }

    public void setMaNVGiao(String MaNVGiao) {
        this.MaNVGiao = MaNVGiao;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
