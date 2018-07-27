/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.GioHang;
import Model.KhachHang;
import Model.SanPhamGioHang;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer_Aspire
 */
@WebServlet(name = "ThanhToanServlet", urlPatterns = {"/ThanhToanServlet"})
public class ThanhToanServlet extends HttpServlet {

    DonHangDAO donhangDAO = new DonHangDAO();
    ChiTietDonHangDAO chitietdonhangDAO = new ChiTietDonHangDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String PTThanhToan = request.getParameter("phuongthucthanhtoan");

        HttpSession session = request.getSession();
        GioHang giohang = (GioHang) session.getAttribute("giohang");
        KhachHang khachhang = (KhachHang) session.getAttribute("khachhang");

        int MaDH = (int) new Date().getTime();
        
        if(PTThanhToan.equals("COD")){
            String trangthai = "Đợi xác nhận";
            donhangDAO.themDonHang(new DonHang(MaDH, khachhang.getMaKH(), PTThanhToan, khachhang.getDiaChi(), khachhang.getSDT(), khachhang.getHoTen(), trangthai, giohang.tongTienGioHang()));
            for (Map.Entry<String, SanPhamGioHang> list : giohang.getGiohang().entrySet()) {
                chitietdonhangDAO.themChiTietDonHang(new ChiTietDonHang(MaDH, list.getValue().getSanpham().getMaSP(),
                        list.getValue().getSoLuong(), list.getValue().getSanpham().getGia()));
                              
            }
            giohang.getGiohang().clear();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/complete_checkout.jsp");
            rd.forward(request, response);    
        }else{
            String trangthai = "Đợi thanh toán";
            donhangDAO.themDonHang(new DonHang(MaDH, khachhang.getMaKH(), PTThanhToan, khachhang.getDiaChi(), khachhang.getSDT(), khachhang.getHoTen(), trangthai, giohang.tongTienGioHang()));
            for (Map.Entry<String, SanPhamGioHang> list : giohang.getGiohang().entrySet()) {
                chitietdonhangDAO.themChiTietDonHang(new ChiTietDonHang(MaDH, list.getValue().getSanpham().getMaSP(),
                        list.getValue().getSoLuong(), list.getValue().getSanpham().getGia()));
                
            }
            giohang.getGiohang().clear();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/complete_checkout.jsp");
            rd.forward(request, response);    
        }
              
    }

}
