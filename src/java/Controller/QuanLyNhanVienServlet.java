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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer_Aspire
 */
@WebServlet(name = "QuanLyNhanVienServlet", urlPatterns = {"/QuanLyNhanVienServlet"})
public class QuanLyNhanVienServlet extends HttpServlet {

    NhanVienDAO nhanvienDAO = new NhanVienDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String command = request.getParameter("command");
        String MaNV = request.getParameter("MaNV");
        
        switch(command){
            case "delete":
                nhanvienDAO.xoaNhanVien(MaNV);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_employees.jsp");
                rd.forward(request, response);
                break;
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String command = request.getParameter("command");
        String MaNV = request.getParameter("MaNV");
        String username = request.getParameter("username");
        
        String pass = request.getParameter("pass");
        String HoTen = request.getParameter("HoTen");
        String SDT = request.getParameter("SDT");
        String quyen = request.getParameter("Quyen");
        
        String err = "";
        
        try {
            switch(command){
            case "add":
                if(nhanvienDAO.KiemTraNhanVien(username)){
                    err = "Tên dăng nhập đã được sử dụng";
                    request.setAttribute("err", err);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/add_employees.jsp");
                    rd.forward(request, response);
                } else if(nhanvienDAO.KiemTraMaNV(MaNV)){
                    err = "Mã nhân viên bị trùng";
                    request.setAttribute("err", err);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/add_employees.jsp");
                    rd.forward(request, response);
                }else{
                    nhanvienDAO.themNhanVien(new NhanVien(MaNV, username, pass, HoTen, SDT, quyen));
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_employees.jsp");
                    rd.forward(request, response);
                }
                break;
            case "update":
                
                nhanvienDAO.capNhatNhanVien(new NhanVien(MaNV, pass, HoTen, SDT, quyen));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_employees.jsp");
                rd.forward(request, response);
                break;
            }
        } catch (Exception e) {
        }
        
        
        
    }

   
}
