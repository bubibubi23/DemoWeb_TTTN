<%-- 
    Document   : product details
    Created on : Jun 29, 2018, 1:48:58 PM
    Author     : Acer_Aspire
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="Model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details | G-Shop</title>

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
            SanPham sanpham = sanphamDAO.getSanPhamByMaSP(request.getParameter("MaSP"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <section>
                <div class="container">
                    <div class="row">


                        <div class="col-sm-12 padding-right">
                            <div class="product-details"><!--product-details-->
                                <div class="col-sm-5">
                                    <div class="view-product">
                                        <img src="<%=sanpham.getHinhAnh()%>" alt="" />
                                </div>

                            </div>


                            <div class="col-sm-6">
                                <div class="product-information"><!--/product-information-->
                                    <img src="images/product-details/new.jpg" class="newarrival" alt="" />
                                    <h2><%=sanpham.getTenSP()%></h2>

                                    <img src="images/product-details/rating.png" alt="" />
                                    <span>
                                        <span><%=currencyVN.format(sanpham.getGia())%></span>
                                        <label>Số Lượng:</label>
                                        <input type="text" value="1" />
                                        <button type="button" class="btn btn-fefault cart">
                                            <i class="fa fa-shopping-cart"></i>
                                            Add to cart
                                        </button>
                                    </span>
                                    <p><b>Tình Trạng:</b> Còn Hàng</p>
                                    <p><b>Loại Sản Phẩm:</b> Hàng Mới</p>

                                    <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->

                        <div class="category-tab shop-details-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li><a href="#details" data-toggle="tab">Details</a></li>
                                    <li><a href="#companyprofile" data-toggle="tab">Company Profile</a></li>
                                    <li><a href="#tag" data-toggle="tab">Tag</a></li>
                                    <li class="active"><a href="#reviews" data-toggle="tab">Reviews (5)</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade" id="details" >
                                    <p>Thông số kỹ thuật Đàn guitar Yamaha FS100C<br>
                                        - Mặt đàn: Gỗ Vân Sam.

                                        - Cần đàn: Gỗ Nato.

                                        - Phím đàn và ngựa đàn: Gỗ Rosewood.

                                        - Lưng ngựa và Lược đàn: Urea

                                        - Độ dài dây đàn: 634mm.

                                        - Chiều dài thân đàn: 497mm.

                                        - Tổng chiều dài: 1021mm.

                                        - Chiều rộng thân đàn: 380mm

                                        - Độ sâu thân đàn: 96-116mm.

                                        - Độ rộng lượng đàn: 43mm.

                                        - Lỗ thoát âm: Tròn.

                                        - Sơn bề mặt thân đàn: Sơn bóng.

                                        - Xuất xứ: Indonesia.</p>
                                </div>

                                <div class="tab-pane fade" id="companyprofile" >
                                </div>    

                                <div class="tab-pane fade" id="tag" >

                                </div>

                                <div class="tab-pane fade active in" id="reviews" >
                                    <div class="col-sm-12">
                                        <ul>
                                            <li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
                                            <li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
                                            <li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
                                        </ul>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                        <p><b>Write Your Review</b></p>

                                        <form action="#">
                                            <span>
                                                <input type="text" placeholder="Your Name"/>
                                                <input type="email" placeholder="Email Address"/>
                                            </span>
                                            <textarea name="" ></textarea>
                                            <b>Rating: </b> <img src="images/product-details/rating.png" alt="" />
                                            <button type="button" class="btn btn-default pull-right">
                                                Submit
                                            </button>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div><!--/category-tab-->

                        <div class="recommended_items"><!--recommended_items-->
                            <h2 class="title text-center">sản phẩm ngẫu nhiên</h2>

                            <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="item active">	
                                        <%for (SanPham sanphamRand : sanphamDAO.listSanPhamRand()) {%>
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP()%>"><img src="<%=sanphamRand.getHinhAnh()%>" alt="" /></a>
                                                        <h2><%=currencyVN.format(sanphamRand.getGia())%></h2>
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP()%>"><p><%=sanphamRand.getTenSP()%></p></a>
                                                        <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%}%>                                       
                                    </div>
                                    <div class="item">	
                                        <%for (SanPham sanphamRand : sanphamDAO.listSanPhamRand()) {%>
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP()%>"><img src="<%=sanphamRand.getHinhAnh()%>" alt="" /></a>
                                                        <h2><%=currencyVN.format(sanphamRand.getGia())%></h2>
                                                        <a href="product details.jsp?MaSP=<%=sanphamRand.getMaSP()%>"><p><%=sanphamRand.getTenSP()%></p></a>
                                                        <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
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
