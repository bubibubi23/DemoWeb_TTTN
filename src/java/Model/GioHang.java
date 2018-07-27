/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Acer_Aspire
 */
public class GioHang {
    private HashMap<String, SanPhamGioHang> giohang;
    
    public GioHang(){
        giohang = new HashMap<>();
    }

    public GioHang(HashMap<String, SanPhamGioHang> giohang) {
        this.giohang = giohang;
    }

    public HashMap<String, SanPhamGioHang> getGiohang() {
        return giohang;
    }

    public void setGiohang(HashMap<String, SanPhamGioHang> giohang) {
        this.giohang = giohang;
    }
    
    public void tangSanPhamGioHang(String key, SanPhamGioHang spGioHang){
        boolean check = giohang.containsKey(key);
        if(check){
            int SoLuongCu = spGioHang.getSoLuong();
            spGioHang.setSoLuong(SoLuongCu + 1);
            giohang.put(key, spGioHang);
        }else{
            giohang.put(key, spGioHang);
        }    
    }
    
    public void giamSanPhamGioHang(String key, SanPhamGioHang spGioHang){
        boolean check = giohang.containsKey(key);
        if(check){
            int SoLuongCu = spGioHang.getSoLuong();
            if(SoLuongCu <= 1){
                giohang.remove(key);
            }else{
                spGioHang.setSoLuong(SoLuongCu - 1);
                giohang.put(key, spGioHang);
            }
        }
    }
    //them so luong cu the san pham vao gio hang trong trang chi tiet san pham.
    public void themSanPhamGioHang(String key, SanPhamGioHang spGioHang){
        giohang.put(key, spGioHang);
    }
    
    public void xoaSanPhamGioHang(String key){
        boolean check = giohang.containsKey(key);
        if(check){
            giohang.remove(key);
        }
    }
    
    public int tongSanPhamTrongGiohang(){
        return giohang.size();
    }
    
    public int tongTienGioHang(){
        int tongTien = 0;
        for(Map.Entry<String, SanPhamGioHang> list : giohang.entrySet()){
            tongTien += list.getValue().getSanpham().getGia() * list.getValue().getSoLuong();
        }
        return tongTien;
    } 
}
