/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NhanVienGiaoHangDAO;
import Model.NhanVienGiaoHang;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "QuanLyNhanVienGiaoHangServlet", urlPatterns = {"/QuanLyNhanVienGiaoHangServlet"})
public class QuanLyNhanVienGiaoHangServlet extends HttpServlet {

    NhanVienGiaoHangDAO nhanviengiaohangDAO = new NhanVienGiaoHangDAO();
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String command = request.getParameter("command");
        String MaNVGiaoHang = request.getParameter("MaNVGiaoHang");
        
        switch(command){
            case "delete":
                nhanviengiaohangDAO.xoaNhanVienGiaoHang(MaNVGiaoHang);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_shippers.jsp");
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
        String MaNVGiaoHang = request.getParameter("MaNVGiaoHang");
        String HoTen = request.getParameter("HoTen");
        String SDT = request.getParameter("SDT");
        String email = request.getParameter("email");
        String DiaChi = request.getParameter("DiaChi");
        
        String err = "";
        
        try {
            switch(command){
                case "add":
                    if(nhanviengiaohangDAO.KiemTraMaNVGiaoHang(MaNVGiaoHang)){
                        err = "Mã nhân viên bị trùng";
                        request.setAttribute("err", err);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/add_shippers.jsp");
                        rd.forward(request, response);
                    } else{
                        nhanviengiaohangDAO.themNhanVienGiaoHang(new NhanVienGiaoHang(MaNVGiaoHang, HoTen, SDT, email, DiaChi));
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_shippers.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "update":
                    nhanviengiaohangDAO.capNhatNhanVienGiaoHang(new NhanVienGiaoHang(MaNVGiaoHang, HoTen, SDT, email, DiaChi));
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_shippers.jsp");
                    rd.forward(request, response);
            }
        } catch (Exception e) {
        }
        
    }

    
    

}
