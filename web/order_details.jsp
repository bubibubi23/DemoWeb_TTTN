<%-- 
    Document   : order_details
    Created on : Jul 30, 2018, 9:20:34 AM
    Author     : Acer_Aspire
--%>
<%@page import="Model.DonHang"%>
<%@page import="DAO.DonHangDAO"%>
<%@page import="Model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="Model.ChiTietDonHang"%>
<%@page import="DAO.ChiTietDonHangDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết đơn hàng</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head>
    <body>
        <%
            int MaDH = 0;
            if (request.getParameter("MaDH") != null) {
                MaDH = (int) Integer.parseInt(request.getParameter("MaDH"));
            }
            ChiTietDonHangDAO chitietDAO = new ChiTietDonHangDAO();
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            SanPhamDAO sanphamDAO = new SanPhamDAO();
            DonHangDAO donhangDAO = new DonHangDAO();
            DonHang donhang = donhangDAO.getDonHang(MaDH);
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Home</a></li>
                        <li>Chi tiết đơn hàng</li>
                    </ol>
                    
                        <div class="review-payment">
                            <h2>Chi tiết đơn hàng - <%=donhang.getNgayTao()%></h2>
                    </div>
                    <div class="table-responsive cart_info">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">

                                    <td class="description">Tên sản phẩm</td>
                                    <td class="price">Giá</td>
                                    <td class="quantity">Số lượng</td>
                                    <td class="total">Thành tiền</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (ChiTietDonHang chitiet : chitietDAO.listChiTietDonHangByMaDH(MaDH)) {%>
                                <%
                                    SanPham sanpham = sanphamDAO.getSanPhamByMaSP(chitiet.getMaSP());
                                %>
                                <tr>

                                    <td class="cart_description">
                                        <h4><a href=""><%=sanpham.getTenSP()%></a></h4>

                                    </td>
                                    <td class="cart_price">
                                        <p><%=currencyVN.format(chitiet.getGia())%></p>
                                    </td>
                                    <td class="cart_quantity">
                                        <div class="cart_quantity_button">

                                            <p class="cart_quantity_input"  > <%=chitiet.getSoLuong()%></p>

                                        </div>
                                    </td>
                                    <td class="cart_total">
                                        <p class="cart_total_price"><%=currencyVN.format(chitiet.getGia() * chitiet.getSoLuong())%></p>
                                    </td>

                                </tr>
                                <%}%>
                                <tr>
                                    <td colspan="4">&nbsp;</td>
                                    <td colspan="2">
                                        <table class="table table-condensed total-result">
                                            <tr>
                                                <td>Tạm tính</td>
                                                <td><%=currencyVN.format(donhang.getTongTien())%></td>
                                            </tr>

                                            <tr class="shipping-cost">
                                                <td>Phí giao hàng</td>
                                                <td>Miễn phí</td>										
                                            </tr>
                                            <tr>
                                                <td>Thành tiền</td>
                                                <td><span><%=currencyVN.format(donhang.getTongTien())%></span></td>
                                            </tr>
                                        </table>
                                        <a class="btn btn-default update" href="account.jsp">Trở về tài khoản</a>                                      

                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
