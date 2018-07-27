<%-- 
    Document   : checkout
    Created on : Jul 25, 2018, 10:56:04 AM
    Author     : Acer_Aspire
--%>
<%@page import="java.util.Map"%>
<%@page import="Model.SanPhamGioHang"%>
<%@page import="Model.GioHang"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Model.KhachHang"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout | G-Shop</title>

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
            KhachHang khachhang = (KhachHang) session.getAttribute("khachhang");
            if (khachhang.getUsername() == null) {
                response.sendRedirect("/GuitarShop/login.jsp");
            }
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            GioHang giohang = (GioHang) session.getAttribute("giohang");
            if (giohang == null) {
                giohang = new GioHang();
                session.setAttribute("giohang", giohang);
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <section id="cart_items">
                <div class="container">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li>Thanh toán</li>
                        </ol>
                    </div><!--/breadcrums-->
                    <form action="ThanhToanServlet" method="post">
                    <div class="step-one">
                        <h2 class="heading">CHỌN PHƯƠNG THỨC THANH TOÁN</h2>
                    </div>
                    <div class="checkout-options">
                        <h3>Xin chào, <%=khachhang.getUsername()%></h3>
                    <br/>
                    <br/>
                    <ul class="nav">
                        <li>
                            <label><input type="radio" name="phuongthucthanhtoan" value="COD" checked=""> Thanh toán tại nhà</label>
                        </li>
                        <li>
                            <label><input type="radio" name="phuongthucthanhtoan" value="online"> Thanh toán online</label>
                        </li>

                    </ul>
                </div><!--/checkout-options-->



                <div class="review-payment">
                    <h2>Kiểm tra giỏ hàng</h2>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Sản phẩm</td>
                                <td class="description"></td>
                                <td class="price">Giá</td>
                                <td class="quantity">Số lượng</td>
                                <td class="total">Thành tiền</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Map.Entry<String, SanPhamGioHang> list : giohang.getGiohang().entrySet()) {%>
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="<%=list.getValue().getSanpham().getHinhAnh()%>" alt="" width="110" height="110"></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href=""><%=list.getValue().getSanpham().getTenSP()%></a></h4>

                                </td>
                                <td class="cart_price">
                                    <p><%=currencyVN.format(list.getValue().getSanpham().getGia())%></p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        
                                        <input class="cart_quantity_input" type="text" disabled="" name="quantity" value="<%=list.getValue().getSoLuong()%>" autocomplete="off" size="2">
                                        
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"><%=currencyVN.format(list.getValue().getSanpham().getGia() * list.getValue().getSoLuong())%></p>
                                </td>
                                
                            </tr>
                            <%}%>
                            <tr>
                                <td colspan="4">&nbsp;</td>
                                <td colspan="2">
                                    <table class="table table-condensed total-result">
                                        <tr>
                                            <td>Tổng tiền trong giỏ hàng</td>
                                            <td><%=currencyVN.format(giohang.tongTienGioHang())%></td>
                                        </tr>
                                        
                                        <tr class="shipping-cost">
                                            <td>Phí giao hàng</td>
                                            <td>Miễn phí</td>										
                                        </tr>
                                        <tr>
                                            <td>Thành tiền</td>
                                            <td><span><%=currencyVN.format(giohang.tongTienGioHang())%></span></td>
                                        </tr>
                                    </table>
                                        <a class="btn btn-default update" href="cart.jsp">Trở về giỏ hàng</a>                                      
                                        <button class="btn btn-default check_out" type="submit">Xác nhận</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </form>                            
            </div>
        </section> <!--/#cart_items-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
