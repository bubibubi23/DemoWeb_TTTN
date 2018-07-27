/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.KhachHangDAO;
import Model.KhachHang;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CapNhatThongTinKH", urlPatterns = {"/CapNhatThongTinKH"})
public class CapNhatThongTinKH extends HttpServlet {
    
    KhachHangDAO khachhangDAO = new KhachHangDAO();

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String Username = request.getParameter("Username");
        String HoTen = request.getParameter("hoten");
        String DiaChi = request.getParameter("diachi");
        String SDT = request.getParameter("SDT");
        String Email = request.getParameter("email");
        String GioiTinh = request.getParameter("gioitinh");
        String url = "/account.jsp";
        
        HttpSession session = request.getSession();
        
        KhachHang khachhang = (KhachHang) session.getAttribute("khachhang");
        
        
        khachhangDAO.capNhatKhachHang(new KhachHang(khachhang.getMaKH(), HoTen, DiaChi, SDT, GioiTinh, Email, khachhang.getUsername(), khachhang.getPassword(), khachhang.getTrangThai()));
        khachhang = khachhangDAO.timKhachHang(khachhang.getUsername());
        
        session.setAttribute("khachhang", khachhang);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
        
        
        
    }

   
}
