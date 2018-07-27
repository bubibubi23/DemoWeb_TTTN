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
@WebServlet(name = "KhachHangDangKy", urlPatterns = {"/KhachHangDangKy"})
public class KhachHangDangKy extends HttpServlet {

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
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        String userName_err = "", pass_err = "";
        String url = "";
        if(khachhangDAO.KiemTraDangKyKhachHang(username)){
            userName_err = "Tên đăng ký đã có người sử dụng!";
            request.setAttribute("userName_err", userName_err);
            url = "/login.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }else{
        
        KhachHang khachhang = new KhachHang();
        khachhang.setEmail(email);
        khachhang.setUsername(username);
        khachhang.setPassword(pass);
        khachhangDAO.themKhacHang(khachhang);
        
        khachhang = khachhangDAO.timKhachHang(username);
        
        HttpSession session = request.getSession();
        session.setAttribute("khachhang", khachhang);
        url = "/update_customer.jsp";
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
        }
    }

    

}
