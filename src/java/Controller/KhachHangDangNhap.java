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
@WebServlet(name = "KhachHangDangNhap", urlPatterns = {"/KhachHangDangNhap"})
public class KhachHangDangNhap extends HttpServlet {

    KhachHangDAO khachhangDAO = new KhachHangDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("command").equals("logout")){
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String err = "";
        
        
        KhachHang khachhang = khachhangDAO.KiemTraDangNhapKhachHang(username, pass);
        if(khachhang == null){
            err = "Sai tài khoản hoặc mật khẩu!";
        }
        if(err.length() > 0){
            request.setAttribute("err", err);
        }
        String url = "/login.jsp";
        try {
            if(err.length() == 0){
                HttpSession session = request.getSession();
                session.setAttribute("khachhang", khachhang);
                
                url = "/index.jsp";
            }else{
                url = "/login.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
        }
        
    }

    
}
