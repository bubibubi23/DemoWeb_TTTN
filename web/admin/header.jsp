<%-- 
    Document   : header
    Created on : Jul 16, 2018, 7:06:42 PM
    Author     : Acer_Aspire
--%>
<%@page import="Model.NhanVien"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <!-- Fontfaces CSS-->
        <link href="${root}/css/font-face.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

        <!-- Bootstrap CSS-->
        <link href="${root}/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

        <!-- Vendor CSS-->
        <link href="${root}/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/wow/animate.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/slick/slick.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="${root}/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="${root}/css/theme.css" rel="stylesheet" media="all">
    </head>
    <body class="animsition">
        <%
            NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvien");
            if(nhanvien == null){
                nhanvien = new NhanVien();
                session.setAttribute("nhanvien", nhanvien);
            }
        %>
        <div class="page-wrapper">
                      
            <!-- PAGE CONTAINER-->
            <div class="page-container">
                <!-- HEADER DESKTOP-->
                <header class="header-desktop">
                    <div class="section__content section__content--p30">
                        <div class="container-fluid">
                            <div class="header-wrap">
                                <form class="form-header" action="" method="POST">
                                    <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
                                    <button class="au-btn--submit" type="submit">
                                        <i class="zmdi zmdi-search"></i>
                                    </button>
                                </form>
                                <div class="header-button">
                                    
                                    
                                            <%if(nhanvien.getUsername() != null) {%>
                                            
                                                <a href="${root}/NhanVienDangNhapServlet?command=logout" > <%=nhanvien.getUsername() %></a>
                                            
                                            <%}%>
                                       
                                </div>
                            </div>
                        </div>
                    </div>
                </header>
                <!-- HEADER DESKTOP-->
                
        </div>

        <!-- Jquery JS-->
        <script src="${root}/vendor/jquery-3.2.1.min.js"></script>
        <!-- Bootstrap JS-->
        <script src="${root}/vendor/bootstrap-4.1/popper.min.js"></script>
        <script src="${root}/vendor/bootstrap-4.1/bootstrap.min.js"></script>
        <!-- Vendor JS       -->
        <script src="${root}/vendor/slick/slick.min.js">
        </script>
        <script src="${root}/vendor/wow/wow.min.js"></script>
        <script src="${root}/vendor/animsition/animsition.min.js"></script>
        <script src="${root}/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
        </script>
        <script src="${root}/vendor/counter-up/jquery.waypoints.min.js"></script>
        <script src="${root}/vendor/counter-up/jquery.counterup.min.js">
        </script>
        <script src="${root}/vendor/circle-progress/circle-progress.min.js"></script>
        <script src="${root}/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="${root}/vendor/chartjs/Chart.bundle.min.js"></script>
        <script src="${root}/vendor/select2/select2.min.js">
        </script>

        <!-- Main JS-->
        <script src="${root}/js/main_1.js"></script>

    </body>
</html>
