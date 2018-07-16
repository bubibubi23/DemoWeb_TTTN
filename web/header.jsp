<%-- 
    Document   : header
    Created on : Jun 29, 2018, 10:30:23 AM
    Author     : Acer_Aspire
--%>

<%@page import="Model.NhomSanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.NhomSanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>

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
            NhomSanPhamDAO nhomSPDAO = new NhomSanPhamDAO();
        %>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> +84 1227 409 275</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i> vietthanh1608@gmail.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="index.jsp"><img src="images/home/logo_1.png" alt="" /></a>
                            </div>
                            
                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <%if(session.getAttribute("username")!=null){%>
                                    <li><a href="account.jsp"><i class="fa fa-user"></i> <%=session.getAttribute("username")%></a></li>
                                    <%}%>
                                    <li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                    <li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                                    <li><a href="login.jsp"><i class="fa fa-lock"></i> Login</a></li>
                                    <li><a href="KhachHangDangNhap?command=logout"><i class="fa fa-lock"></i> Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="index.jsp" class="active">Trang Chủ</a></li>
                                    <li class="dropdown"><a href="HienThiSanPham?command=Loai&LoaiSP=Acoustic">Đàn Guitar Acoustic<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <%
                                                for(NhomSanPham nhomsp : nhomSPDAO.getListGuitar()){
                                            %>

                                            <li><a href="HienThiSanPham?command=LoaiMaNhom&MaNhomSP=<%=nhomsp.getMaNhomSP()%>&LoaiSP=Acoustic"><%=nhomsp.getTenNhomSP()%></a></li>
                                            <%}%>
                                            
                                        </ul>
                                    </li> 
                                    <li class="dropdown"><a href="HienThiSanPham?command=Loai&LoaiSP=Classic">Đàn Guitar Classic<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <%
                                                for(NhomSanPham nhomsp1 : nhomSPDAO.getListGuitar()){
                                            %>
                                            <li><a href="HienThiSanPham?command=LoaiMaNhom&MaNhomSP=<%=nhomsp1.getMaNhomSP()%>&LoaiSP=Classic"><%=nhomsp1.getTenNhomSP()%></a></li>
                                            <%}%>
                                        </ul>
                                    </li> 
                                    <li class="dropdown"><a href="#">Phụ Kiện Guitar<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <%
                                                for(NhomSanPham nhomsp2 : nhomSPDAO.getListPhuKien()){
                                            %>
                                            <li><a href="blog.html"><%=nhomsp2.getTenNhomSP()%></a></li>
                                            <%}%>
                                        </ul>
                                    </li> 
                                    <li><a href="404.html">Tin Tức</a></li>
                                    <li><a href="contact-us.html">Liên Hệ</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="search_box pull-right">
                                <input type="text" placeholder="Search"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->

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
