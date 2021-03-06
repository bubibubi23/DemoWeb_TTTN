<%-- 
    Document   : update_employees
    Created on : Jul 23, 2018, 5:05:02 PM
    Author     : Acer_Aspire
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employees</title>

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
        <%  String err = "";
            if (request.getAttribute("err") != null) {
                err = request.getAttribute("err").toString();
            }
        %>
        <div class="page-wrapper">
            <jsp:include page="menu_sidebar.jsp"></jsp:include>
                <div class="page-container">
                <jsp:include page="header.jsp"></jsp:include>
                    <div class="main-content">
                        <div class="section__content section__content--p5">
                            <div class="container-fluid">
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <strong>CẬP NHẬT NHÂN VIÊN</strong>
                                        </div>

                                        <form action="${root}/QuanLyNhanVienServlet" method="post" class="form-horizontal">
                                        <div class="card-body card-block">
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label" style="color: red"><%=err%></label>
                                                </div>
                                            </div>
                                           
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="hf-password" class=" form-control-label">Mật khẩu</label>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <input type="password" id="hf-password" name="pass" placeholder="Mật khẩu..." class="form-control">

                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Họ và Tên</label>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <input type="text" id="text-input" name="HoTen" placeholder="Họ và tên..." class="form-control">

                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Số điện thoại</label>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <input type="text" id="text-input" name="SDT" placeholder="Số điện thoại..." class="form-control">

                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="select" class=" form-control-label">Vai trò</label>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <select name="Quyen" id="select" class="form-control">                                                     
                                                        <option value="Admin">Admin</option>
                                                        <option value="Nhân viên bán hàng">Nhân viên bán hàng</option>
                                                        <option value="Nhân viên kho">Nhân viên kho</option>
                                                    </select>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="card-footer">
                                            <input type="hidden" name="command" value="update"/>
                                            <input type="hidden" name="MaNV" value="<%=request.getParameter("MaNV") %>"/>
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> XÁC NHẬN
                                            </button>
                                            <button type="reset" class="btn btn-danger btn-sm">
                                                <i class="fa fa-ban"></i> RESET
                                            </button>
                                        </div>
                                    </form>
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
