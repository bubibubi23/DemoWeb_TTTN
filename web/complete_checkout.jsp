<%-- 
    Document   : complete_checkout
    Created on : Jul 25, 2018, 12:59:22 PM
    Author     : Acer_Aspire
--%>
<%@page import="Model.KhachHang"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Complete Checkout</title>
        
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
            if (khachhang == null) {
                khachhang = new KhachHang();
                session.setAttribute("khachhang", khachhang);
            }
        %>
        
        <jsp:include page="header.jsp"></jsp:include>
        <section id="cart_items">
                <div class="container">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li>Thanh toán</li>
                            <li>Hoàn tất</li>
                        </ol>
                        
                    </div><!--/breadcrums-->
                    <h1><b>Xin chúc mừng! Bạn đã đặt hàng thành công</b></h1>
                    <br/>
                    <br/>
                    <br/>
                    <h3>Thông tin đơn hàng đã được nhận</h3>
                </div>
        </section>    
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
