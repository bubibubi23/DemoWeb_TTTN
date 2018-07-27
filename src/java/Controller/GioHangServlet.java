/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SanPhamDAO;
import Model.GioHang;
import Model.SanPham;
import Model.SanPhamGioHang;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "GioHangServlet", urlPatterns = {"/GioHangServlet"})
public class GioHangServlet extends HttpServlet {

    private SanPhamDAO sanphamDAO = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        String MaSP = request.getParameter("MaSP");
        int SoLuong = 0;
        if(request.getParameter("SoLuong") != null)
            SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
        String url = "";
        GioHang giohang = (GioHang) session.getAttribute("giohang");
        
        try {
            SanPham sanpham = sanphamDAO.getSanPhamByMaSP(MaSP);
            switch(command){
                case "tang":
                    if(giohang.getGiohang().containsKey(MaSP)){
                        giohang.tangSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, giohang.getGiohang().get(MaSP).getSoLuong()));
                    }else{
                        giohang.tangSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, 1));
                    }
                    session.setAttribute("giohang", giohang);
                    url = "/cart.jsp";
                    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    break;
                case "giam":
                    if(giohang.getGiohang().containsKey(MaSP))
                        giohang.giamSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, giohang.getGiohang().get(MaSP).getSoLuong()));
                    session.setAttribute("giohang", giohang);
                    url = "/cart.jsp";
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    break;
                case "themDT":
                    if(giohang.getGiohang().containsKey(MaSP)){
                        giohang.themSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, giohang.getGiohang().get(MaSP).getSoLuong() + SoLuong));
                    }else{
                        giohang.themSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, SoLuong));
                    }
                    session.setAttribute("giohang", giohang);
                    url = "/product details.jsp";
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    break;
                case "themIDX":
                    if(giohang.getGiohang().containsKey(MaSP)){
                        giohang.tangSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, giohang.getGiohang().get(MaSP).getSoLuong()));
                    }else{
                        giohang.tangSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, 1));
                    }
                    session.setAttribute("giohang", giohang);
                    url = "/index.jsp";
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    break;
                case "themPRD":
                    if(giohang.getGiohang().containsKey(MaSP)){
                        giohang.tangSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, giohang.getGiohang().get(MaSP).getSoLuong()));
                    }else{
                        giohang.tangSanPhamGioHang(MaSP, new SanPhamGioHang(sanpham, 1));
                    }
                    session.setAttribute("giohang", giohang);
                    url = "/cart.jsp";
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    break;
                case "xoa":
                    giohang.xoaSanPhamGioHang(MaSP);
                    session.setAttribute("giohang", giohang);
                    url = "/cart.jsp";
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception e) {
        }
    }
}
