<%-- 
    Document   : update_products
    Created on : Jul 24, 2018, 11:05:16 AM
    Author     : Acer_Aspire
--%>
<%@page import="Model.ThongSoSanPham"%>
<%@page import="DAO.ThongSoSanPhamDAO"%>
<%@page import="Model.SanPham"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="Model.NhomSanPham"%>
<%@page import="DAO.NhomSanPhamDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Products</title>
        
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
            String MaSP = request.getParameter("MaSP");
            NhomSanPhamDAO nhomsanphamDAO = new NhomSanPhamDAO();
            
            SanPhamDAO sanphamDAO = new SanPhamDAO();
            SanPham sanpham = sanphamDAO.getSanPhamByMaSP(MaSP);
            ThongSoSanPhamDAO thongsoDAO = new ThongSoSanPhamDAO();
            ThongSoSanPham thongso = thongsoDAO.getThongSoSanPham(MaSP);
            NhomSanPham nhomsanpham = nhomsanphamDAO.getNhomSanPham(sanpham.getMaNhomSP());
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
                                            <strong>CẬP NHẬT SẢN PHẨM</strong>
                                        </div>
                                        <form action="${root}/QuanLySanPhamServlet" method="post" class="form-horizontal">
                                            <div class="card-body card-block">
                                                
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label for="text-input" class=" form-control-label">Tên sản phẩm</label>
                                                    </div>
                                                    <div class="col-12 col-md-6">
                                                        <input type="text" value="<%=sanpham.getTenSP() %>"id="text-input" name="TenSP" placeholder="Tên sản phẩm..." class="form-control">

                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label for="text-input" class=" form-control-label">Giá</label>
                                                    </div>
                                                    <div class="col-12 col-md-6">
                                                        <input type="number" value="<%=sanpham.getGia() %>"id="hf-email" name="Gia" placeholder="Giá tiền..." class="form-control">

                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3">
                                                        <label for="text-input" class=" form-control-label">Hình ảnh</label>
                                                    </div>
                                                    <div class="col-12 col-md-6">
                                                        <input type="file" id="hf-email" name="HinhAnh" accept="images/*" >

                                                </div>
                                            </div>

                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Mô tả</label>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <input type="text" value="<%=sanpham.getMoTa() %>"id="text-input" name="MoTa" placeholder="Mô tả..." class="form-control">

                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="textarea-input" class=" form-control-label">Thông số sản phẩm</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <textarea name="ThongSoSP"  id="textarea-input" rows="9" placeholder="Nội dung..." class="form-control"><%=thongso.getThongSoSP() %></textarea>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="select" class=" form-control-label">Chọn nhóm sản phẩm</label>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <select name="MaNhomSP" id="select" class="form-control">
                                                        <option value="<%=sanpham.getMaNhomSP()%>"><%=nhomsanpham.getTenNhomSP() %></option>
                                                        <%for (NhomSanPham nhomsp : nhomsanphamDAO.getListGuitar()) {%>
                                                        <option value="<%=nhomsp.getMaNhomSP()%>"><%=nhomsp.getTenNhomSP()%></option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="select" class=" form-control-label">Chọn loại sản phẩm</label>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <select name="LoaiSP" id="select" class="form-control">
                                                        <option value="<%=sanpham.getLoaiSP() %>"><%=sanpham.getLoaiSP() %></option>
                                                        <option value="Acoustic">Acoustic</option>
                                                        <option value="Classic">Classic</option>
                                                       
                                                    </select>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="card-footer">
                                            <input type="hidden" name="command" value="update"/>
                                            <input type="hidden" name="MaSP" value="<%=request.getParameter("MaSP") %>"/>
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
