/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SanPhamDAO;
import DAO.ThongSoSanPhamDAO;
import Model.SanPham;
import Model.ThongSoSanPham;
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
@WebServlet(name = "QuanLySanPhamServlet", urlPatterns = {"/QuanLySanPhamServlet"})
public class QuanLySanPhamServlet extends HttpServlet {

    SanPhamDAO sanphamDAO = new SanPhamDAO();
    ThongSoSanPhamDAO thongsoDAO = new ThongSoSanPhamDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String command = request.getParameter("command");
        String MaSP = request.getParameter("MaSP");
        
        switch(command){
            case "delete":
                sanphamDAO.xoaSanPham(MaSP);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_products.jsp");
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
        String MaSP = request.getParameter("MaSP");
        String TenSP = request.getParameter("TenSP");
        String MaNhomSP = request.getParameter("MaNhomSP");
        int Gia = Integer.parseInt(request.getParameter("Gia"));
        String HinhAnh = "images/home/" + request.getParameter("HinhAnh");
        
        String MoTa = request.getParameter("MoTa");
        String ThongSoSP = request.getParameter("ThongSoSP");
        String LoaiSP = request.getParameter("LoaiSP");
        
        String err = "";
        
        
        try {
            switch(command){
                case "add":
                    if(sanphamDAO.kiemTraMaSP(MaSP)){
                        err = "Mã sản phẩm bị trùng";
                        request.setAttribute("err", err);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/add_products.jsp");
                        rd.forward(request, response);
                    }else{
                        
                        thongsoDAO.themThongSoSanPham(new ThongSoSanPham(MaSP, ThongSoSP));
                        ThongSoSanPham thongso = thongsoDAO.getThongSoSanPham(MaSP);
                        sanphamDAO.themSanPham(new SanPham(MaSP, TenSP, MaNhomSP, Gia, HinhAnh, MoTa, thongso.getMaTSSP(), LoaiSP));
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_products.jsp");
                        rd.forward(request, response);
                        
                    }
                    break;
                case "update":
                    
                    thongsoDAO.capNhatThongSoSanPham(new ThongSoSanPham(MaSP, ThongSoSP));               
                    sanphamDAO.capNhatSanPham(new SanPham(MaSP, TenSP, MaNhomSP, Gia, HinhAnh, MoTa, LoaiSP));
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_products.jsp");
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception e) {
        }
    }

    

}
