<%-- 
    Document   : cart
    Created on : Jun 29, 2018, 2:34:15 PM
    Author     : Acer_Aspire
--%>

<%@page import="java.util.Map"%>
<%@page import="Model.SanPhamGioHang"%>
<%@page import="Model.GioHang"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart | G-Shop</title>

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
                            <li><a href="index.jsp">Home</a></li>
                            <li>Giỏ hàng</li>
                        </ol>
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
                                        <a class="cart_quantity_up" href="GioHangServlet?command=tang&MaSP=<%=list.getValue().getSanpham().getMaSP()%>"> + </a>
                                        <input class="cart_quantity_input" type="text" name="quantity" value="<%=list.getValue().getSoLuong()%>" autocomplete="off" size="2">
                                        <a class="cart_quantity_down" href="GioHangServlet?command=giam&MaSP=<%=list.getValue().getSanpham().getMaSP()%>"> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"><%=currencyVN.format(list.getValue().getSanpham().getGia() * list.getValue().getSoLuong())%></p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="GioHangServlet?command=xoa&MaSP=<%=list.getValue().getSanpham().getMaSP()%>"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%}%>

                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <div class="heading">
                    <h3>Bạn muốn làm gì tiếp theo?</h3>

                </div>
                <a class="btn btn-default update" href="index.jsp">Tiếp tục mua hàng</a>                                        
                <a class="btn btn-default check_out" href="checkout.jsp">Thanh toán</a>                                            
            </div>                                   
        </section><!--/#do_action-->

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
        <script src="js/gmaps.js"></script>
        <script src="js/contact.js"></script>
        <script src="js/html5shiv.js"></script>
    </body>
</html>
