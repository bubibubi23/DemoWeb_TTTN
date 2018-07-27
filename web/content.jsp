<%-- 
    Document   : content
    Created on : Jun 29, 2018, 10:41:44 AM
    Author     : Acer_Aspire
--%>

<%@page import="Model.GioHang"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Model.SanPham"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>content</title>

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
            SanPhamDAO sanphamDAO = new SanPhamDAO();
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            GioHang giohang = (GioHang) session.getAttribute("giohang");
            if(giohang == null){
                giohang = new GioHang();
                session.setAttribute("giohang", giohang);
            }
        %>
     
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">                                                      
                            <div class="brands_products"><!--brands_products-->
                                <h2>Thương Hiệu</h2>
                                <div class="brands-name">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP001&pages=1"> <span class="pull-right">(50)</span>Epiphone</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP002&pages=1"> <span class="pull-right">(56)</span>Ibanez</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP003&pages=1"> <span class="pull-right">(27)</span>Cort</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP004&pages=1"> <span class="pull-right">(32)</span>Yamaha</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP005&pages=1"> <span class="pull-right">(5)</span>Takamine</a></li>
                                    </ul>
                                </div>
                            </div><!--/brands_products-->

                            
                            <div class="shipping text-center"><!--shipping-->
                                <img src="images/home/shipping.jpg" alt="" />
                            </div><!--/shipping-->

                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Sản Phẩm Mới Cập Nhật</h2>
                            <%
                                for(SanPham sanpham : sanphamDAO.listGuitarMoi()){
                            %>
                            <div class="col-sm-4">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <a href="product details.jsp?MaSP=<%=sanpham.getMaSP() %>"><img src="<%=sanpham.getHinhAnh()%>" alt="" /></a>
                                            <h2><%=currencyVN.format(sanpham.getGia())%></h2>
                                            <a href="product details.jsp?MaSP=<%=sanpham.getMaSP() %>" ><p><%=sanpham.getTenSP()%></p></a>
                                            <a href="GioHangServlet?command=themIDX&MaSP=<%=sanpham.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                        </div>  
                                    </div>
                                    
                                </div>
                            </div>
                            <%}%>
                        </div><!--features_items-->

                        <div class="category-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#epiphone" data-toggle="tab">Epiphone</a></li>
                                    <li><a href="#ibanez" data-toggle="tab">Ibanez</a></li>
                                    <li><a href="#takamine" data-toggle="tab">Takamine</a></li>
                                    <li><a href="#cort" data-toggle="tab">Cort</a></li>
                                    <li><a href="#yamaha" data-toggle="tab">Yamaha</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="epiphone" >
                                    <%for(SanPham sanphamE : sanphamDAO.list4GuitarByMaNhomSP("GNSP001")){%>
                                    <div class="col-sm-3">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <a href="product details.jsp?MaSP=<%=sanphamE.getMaSP() %>"><img src="<%=sanphamE.getHinhAnh()%>" alt="" /></a>
                                                    <h2><%=currencyVN.format(sanphamE.getGia())%></h2>
                                                    <a href="product details.jsp?MaSP=<%=sanphamE.getMaSP() %>"><p><%=sanphamE.getTenSP()%></p></a>
                                                    <a href="GioHangServlet?command=themIDX&MaSP=<%=sanphamE.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>
                                </div>
                                <div class="tab-pane fade" id="ibanez" >
                                    <%for(SanPham sanphamI : sanphamDAO.list4GuitarByMaNhomSP("GNSP002")){%>
                                    <div class="col-sm-3">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <a href="product details.jsp?MaSP=<%=sanphamI.getMaSP() %>"><img src="<%=sanphamI.getHinhAnh()%>" alt="" /></a>
                                                    <h2><%=currencyVN.format(sanphamI.getGia())%></h2>
                                                    <a href="product details.jsp?MaSP=<%=sanphamI.getMaSP() %>"><p><%=sanphamI.getTenSP() %></p></a>
                                                    <a href="GioHangServlet?command=themIDX&MaSP=<%=sanphamI.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>                                   
                                </div>
                                <div class="tab-pane fade" id="takamine" >
                                    <%for(SanPham sanphamT : sanphamDAO.list4GuitarByMaNhomSP("GNSP003")){%>
                                    <div class="col-sm-3">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <a href="product details.jsp?MaSP=<%=sanphamT.getMaSP() %>"><img src="<%=sanphamT.getHinhAnh() %>" alt="" /></a>
                                                    <h2><%=currencyVN.format(sanphamT.getGia()) %></h2>
                                                    <a href="product details.jsp?MaSP=<%=sanphamT.getMaSP() %>"><p><%=sanphamT.getTenSP() %></p></a>
                                                    <a href="GioHangServlet?command=themIDX&MaSP=<%=sanphamT.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>
                                </div>
                                <div class="tab-pane fade" id="cort" >
                                    <%for(SanPham sanphamC : sanphamDAO.list4GuitarByMaNhomSP("GNSP004")){%>
                                    <div class="col-sm-3">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <a href="product details.jsp?MaSP=<%=sanphamC.getMaSP() %>"><img src="<%=sanphamC.getHinhAnh() %>" alt="" /></a>
                                                    <h2><%=currencyVN.format(sanphamC.getGia())%></h2>
                                                    <a href="product details.jsp?MaSP=<%=sanphamC.getMaSP() %>"><p><%=sanphamC.getTenSP() %></p></a>
                                                    <a href="GioHangServlet?command=themIDX&MaSP=<%=sanphamC.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>
                                </div>

                                <div class="tab-pane fade" id="yamaha" >
                                    <%for(SanPham sanphamY : sanphamDAO.list4GuitarByMaNhomSP("GNSP005")){%>
                                    <div class="col-sm-3">
                                        <div class="product-image-wrapper">
                                            <div class="single-products">
                                                <div class="productinfo text-center">
                                                    <a href="product details.jsp?MaSP=<%=sanphamY.getMaSP() %>"><img src="<%=sanphamY.getHinhAnh() %>" alt="" /></a>
                                                    <h2><%=currencyVN.format(sanphamY.getGia())%></h2>
                                                    <a href="product details.jsp?MaSP=<%=sanphamY.getMaSP() %>"><p><%=sanphamY.getTenSP() %></p></a>
                                                    <a href="GioHangServlet?command=themIDX&MaSP=<%=sanphamY.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>
                                </div>
                            </div>
                        </div><!--/category-tab-->

                        <div class="recommended_items"><!--recommended_items-->
                            <h2 class="title text-center">Sản Phẩm Ngẫu Nhiên</h2>

                            <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <%for(SanPham sanphamRand : sanphamDAO.listSanPhamRand()){%>
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP() %>"><img src="<%=sanphamRand.getHinhAnh() %>" alt="" /></a>
                                                        <h2><%=currencyVN.format(sanphamRand.getGia())%></h2>
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP() %>"><p><%=sanphamRand.getTenSP() %></p></a>
                                                        <a href="GioHangServlet?command=themIDX&MaSP=<%=sanphamRand.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%}%>
                                    </div>
                                    <div class="item">	
                                        <%for(SanPham sanphamRand : sanphamDAO.listSanPhamRand()){%>
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP() %>"><img src="<%=sanphamRand.getHinhAnh() %>" alt="" /></a>
                                                        <h2><%=currencyVN.format(sanphamRand.getGia())%></h2>                                                    
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP() %>"><p><%=sanphamRand.getTenSP() %></p></a>
                                                        <a href="GioHangServlet?command=themIDX&MaSP=<%=sanphamRand.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%}%>
                                    </div>
                                </div>
                                <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                                <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                                    <i class="fa fa-angle-right"></i>
                                </a>			
                            </div>
                        </div><!--/recommended_items-->

                    </div>
                </div>
            </div>
        </section>

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
