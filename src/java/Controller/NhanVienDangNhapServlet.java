/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NhanVienDAO;
import Model.NhanVien;
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
@WebServlet(name = "NhanVienDangNhapServlet", urlPatterns = {"/NhanVienDangNhapServlet"})
public class NhanVienDangNhapServlet extends HttpServlet {

    NhanVienDAO nhanvienDAO = new NhanVienDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("command").equals("logout")){
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("admin/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("Username");
        String pass = request.getParameter("Pass");
        String err = "";
        
        
        NhanVien nhanvien = nhanvienDAO.KiemTraDangNhapNhanVien(username, pass);
        if(nhanvien == null){
            err = "Sai tên đang nhập hoặc mật khẩu";
        }
        if(err.length() > 0){
            request.setAttribute("err", err);
        }
        
        String url = "";
        try {
            if(err.length() == 0){
                HttpSession session = request.getSession();
                session.setAttribute("nhanvien", nhanvien);
                
                url = "/admin/index.jsp";
            }else{
                url = "/admin/login.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
        }
        
    }
  

}
