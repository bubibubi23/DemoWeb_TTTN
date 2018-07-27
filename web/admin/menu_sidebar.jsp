<%-- 
    Document   : menu_sidebar
    Created on : Jul 17, 2018, 3:46:02 PM
    Author     : Acer_Aspire
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu_sidebar</title>
        
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
    <body>
        
        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="${root}/admin/index.jsp">
                    <img src="${root}/images/icon/logo.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">                        
                        <li>
                            <a href="${root}/admin/manager_users.jsp">
                                <i class="fas fa-star"></i>Quản lý khách hàng
                            </a>                                                          
                        </li>
                        <li>
                            <a href="${root}/admin/manager_employees.jsp">
                                <i class="fas fa-star"></i>Quản lý nhân viên
                            </a>
                        </li>
                        <li>
                            <a href="${root}/admin/manager_shippers.jsp">
                                <i class="fas fa-star"></i>Quản lý nhân viên giao hàng
                            </a>
                        </li>
                        <li>
                            <a href="${root}/admin/manager_products.jsp">
                                <i class="fas fa-star"></i>Quản lý sản phẩm
                            </a>
                        </li>
                        <li>
                            <a href="${root}/QuanLyDonHangServlet?command=showAll">
                                <i class="fas fa-star"></i>Quản lý đơn hàng
                            </a>
                        </li>
                        <li>
                            <a href="${root}/admin/manager_suppliers.jsp">
                                <i class="fas fa-star"></i>Quản lý nhà cung cấp
                            </a>
                        </li>
                        <li>
                            <a href="${root}/admin/manager_input.jsp">
                                <i class="fas fa-star"></i>Nhập kho
                            </a>
                        </li>
                        <li>
                            <a href="${root}/admin/manager_output.jsp">
                                <i class="fas fa-star"></i>Xuất kho
                            </a>
                        </li>
                        
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->
        
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
