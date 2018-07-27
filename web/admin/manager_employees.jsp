<%-- 
    Document   : manager_employees
    Created on : Jul 19, 2018, 8:11:20 PM
    Author     : Acer_Aspire
--%>
<%@page import="DAO.NhanVienDAO"%>
<%@page import="DAO.KhachHangDAO"%>
<%@page import="Model.NhanVien"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>

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
            NhanVienDAO nhanvienDAO = new NhanVienDAO();
        %>
        <div class="page-wrapper">
            <jsp:include page="menu_sidebar.jsp"></jsp:include>
                <div class="page-container">
                <jsp:include page="header.jsp"></jsp:include>
                    <div class="main-content">
                        <div class="section__content section__content--p5">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <!-- USER DATA-->
                                        <div class="user-data m-b-30">
                                            <h3 class="title-3 m-b-30">
                                                <i class="zmdi zmdi-account-calendar"></i>Thông tin nhân viên</h3>
                                            <div class="filters m-b-45">
                                                <div class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
                                                    <select class="js-select2" name="loc">
                                                        <option selected="selected">Nhân viên đang hoạt động</option>
                                                        <option value="">Tất cả nhân viên</option>
                                                        <option value="">Nhân viên không hoạt động</option>
                                                    </select>
                                                    <div class="dropDownSelect2"></div>
                                                </div>
                                                
                                                <div class="rs-select2--dark rs-select2--sm rs-select2--border">
                                                    <button class="au-btn au-btn--blue au-btn--small">lọc</button>
                                                </div>
                                                <a href="${root}/admin/add_employees.jsp"><button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                                    <i class="zmdi zmdi-plus"></i>thêm nhân viên</button></a>
                                            </div>
                                            <div class="table-responsive table-data">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <td>Mã Nhân Viên</td>
                                                            <td>Họ Tên</td>
                                                            <td>Tên Đăng Nhập</td>                                                           
                                                            <td>Số Điện Thoại</td>
                                                            <td>QUyền</td>                                                   
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%for(NhanVien nhanvien : nhanvienDAO.listNhanVienHoatDong()) {%>
                                                        <tr>                                                   
                                                            <td>
                                                                <div class="table-data__info">                                                           
                                                                    <h6><%=nhanvien.getMaNV() %></h6>                                                                                          
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <div class="table-data__info">
                                                                    <h6><%=nhanvien.getHoTen() %></h6>                                               
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <div class="table-data__info">                                                           
                                                                    <h6><%=nhanvien.getUsername() %></h6>                                                                                          
                                                                </div>
                                                            </td>
                               
                                                            <td>
                                                                <div class="table-data__info">
                                                                    <h6><%=nhanvien.getSDT() %></h6>                                               
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <span class="role member"><%=nhanvien.getQuyen() %></span>
                                                            </td>                                                   
                                                            <td>
                                                                <a href="${root}/admin/update_employees.jsp?command=update&MaNV=<%=nhanvien.getMaNV() %>"> <button class="item" data-toggle="tooltip" data-placement="top" title="Sửa">
                                                                    <i class="zmdi zmdi-edit"></i>
                                                                    </button></a>
                                                            </td>
                                                            <td>
                                                                <a href="${root}/QuanLyNhanVienServlet?command=delete&MaNV=<%=nhanvien.getMaNV() %>"><button class="item" data-toggle="tooltip" data-placement="top" title="Xóa">
                                                                    <i class="zmdi zmdi-delete"></i>
                                                                    </button></a>
                                                            </td>
                                                        </tr>
                                                        <%}%>
                                                    </tbody>
                                                </table>
                                            </div>

                                        </div>
                                        <!-- END USER DATA-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
