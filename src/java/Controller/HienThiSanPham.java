/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SanPhamDAO;
import Model.SanPham;
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
@WebServlet(name = "HienThiSanPham", urlPatterns = {"/HienThiSanPham"})
public class HienThiSanPham extends HttpServlet {

    SanPhamDAO sanphamDAO = new SanPhamDAO();
    ArrayList<SanPham> list = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String url = "product.jsp";
        String command = request.getParameter("command");
        String MaNhomSP = request.getParameter("MaNhomSP");
        String LoaiSP = request.getParameter("LoaiSP");
        int pages = 0;
        if(request.getParameter("pages") != null)
            pages = Integer.parseInt(request.getParameter("pages"));
               
        int firstResult = 0, maxResult = 0, total = 0;
        
        
        switch(command){
            case "MaNhomSP":
                total = sanphamDAO.tongSanPhamByMaNhomSP(MaNhomSP);                
                firstResult= (pages - 1)*6;
                maxResult = 6;                
                list = sanphamDAO.listSanPhamMaNhomSPByPages(MaNhomSP, firstResult, maxResult);
                request.setAttribute("list", list);
                request.setAttribute("total", total);
                request.setAttribute("pages", pages);
                request.setAttribute("command", command);
                request.getRequestDispatcher(url).include(request, response);
                break;
            case "LoaiMaNhom":
                total = sanphamDAO.tongSanPhamChiTiet(MaNhomSP, LoaiSP);
                firstResult= (pages - 1)*6;
                maxResult = 6;
                
                list = sanphamDAO.listSanPhamChiTietByPages(MaNhomSP, LoaiSP, firstResult, maxResult);
                request.setAttribute("list", list);
                request.setAttribute("total", total);
                request.setAttribute("pages", pages);
                request.setAttribute("command", command);
                request.getRequestDispatcher(url).include(request, response);
                break;
            case "Loai":
                total = sanphamDAO.tongSanPhamByLoaiSP(LoaiSP);               
                firstResult= (pages - 1)*6;
                maxResult = 6;
                list = sanphamDAO.listSanPhamLoaiSPByPages(LoaiSP, firstResult, maxResult);
                request.setAttribute("list", list);
                request.setAttribute("total", total);
                request.setAttribute("pages", pages);
                request.setAttribute("command", command);
                request.getRequestDispatcher(url).include(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
