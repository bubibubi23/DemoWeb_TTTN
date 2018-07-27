/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DonHangDAO;
import Model.DonHang;
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
@WebServlet(name = "QuanLyDonHangServlet", urlPatterns = {"/QuanLyDonHangServlet"})
public class QuanLyDonHangServlet extends HttpServlet {

    DonHangDAO donhangDAO = new DonHangDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String command = request.getParameter("command");
        int MaNV = 0;
        if(request.getParameter("MaNV") != null){
            MaNV = (int) Integer.parseInt(request.getParameter("MaNV"));
        }
        ArrayList<DonHang> list = new ArrayList<>();
                
        switch(command){
            case "showAll":
                list = donhangDAO.listDonHang();
                request.setAttribute("list", list);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_orders.jsp");
                rd.forward(request, response);
                break;
            case "showbyMaNV":    
                list = donhangDAO.listDonHangByMaKH(MaNV);
                request.setAttribute("list", list);
                rd = getServletContext().getRequestDispatcher("/admin/manager_orders.jsp");
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
        int MaDH = 0;
        if(request.getParameter("MaDH") != null){
            MaDH = (int) Integer.parseInt(request.getParameter("MaDH"));
        }
        
        DonHang donhang = donhangDAO.getDonHang(MaDH);
        
        switch(command){
            case "update":
                
        }
    }

    

}
