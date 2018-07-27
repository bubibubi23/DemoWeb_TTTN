<%-- 
    Document   : product
    Created on : Jun 29, 2018, 1:40:22 PM
    Author     : Acer_Aspire
--%>

<%@page import="Model.GioHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.SanPham"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.SanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product | G-Shop</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head>
    <body>
        <%  int total = 0, pages = 0;
            String LoaiSP = request.getParameter("LoaiSP");
            String MaNhomSP = request.getParameter("MaNhomSP");
            
            SanPhamDAO sanphamDAO = new SanPhamDAO();
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            ArrayList<SanPham> list = (ArrayList<SanPham>) request.getAttribute("list");
            String command = request.getAttribute("command").toString();
            if(request.getAttribute("pages") != null && request.getAttribute("total") != null){
                pages =  Integer.parseInt(request.getAttribute("pages").toString());
                total =  Integer.parseInt(request.getAttribute("total").toString());
            }
            GioHang giohang = (GioHang) session.getAttribute("giohang");
            if(giohang == null){
                giohang = new GioHang();
                session.setAttribute("giohang", giohang);
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            
                            <div class="brands_products"><!--brands_products-->
                                <h2>Brands</h2>
                                <div class="brands-name">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP001&pages=1"> <span class="pull-right">(50)</span>EPIPHONE</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP002&pages=1"> <span class="pull-right">(56)</span>IBANEZ</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP003&pages=1"> <span class="pull-right">(27)</span>TAKAMINE</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP004&pages=1"> <span class="pull-right">(32)</span>CORT</a></li>
                                        <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=GNSP005&pages=1"> <span class="pull-right">(5)</span>YAMAHA</a></li>                                       
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
                            <h2 class="title text-center">SẢN PHẨM</h2>
                            <%
                                for(SanPham sanpham : list){
                            %>
                            <div class="col-sm-4">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <a href="product details.jsp?MaSP=<%=sanpham.getMaSP() %>"><img src="<%=sanpham.getHinhAnh()%>" alt="" /></a>
                                            <h2><%=currencyVN.format(sanpham.getGia())%></h2>
                                            <a href="product details.jsp?MaSP=<%=sanpham.getMaSP() %>" ><p><%=sanpham.getTenSP()%></p></a>
                                            <a href="GioHangServlet?command=themPRD&MaSP=<%=sanpham.getMaSP() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                        </div>                            
                                    </div>                                  
                                </div>
                            </div>
                            <%}%>
                            
                        </div><!--features_items-->
                        <ul class="pagination">
                            <%  int next = 1;%>
                            <%if(command.equals("Loai")){
                                %>
                            
                            <%      for(int i = 1; i <= (total/6) + 1; i++){ 
                                    if(i == pages){
                            %>
                            <li class="active"><a href="HienThiSanPham?command=Loai&LoaiSP=<%=LoaiSP%>&pages=<%=i %>"><%=i %></a></li>
                                    <%}else{%>
                                <li ><a href="HienThiSanPham?command=Loai&LoaiSP=<%=LoaiSP%>&pages=<%=i %>"><%=i %></a></li>
                            <%          }
                                    }
                            %>                               
                                <li><a href="HienThiSanPham?command=Loai&LoaiSP=<%=LoaiSP%>&pages=<%=++next %>">&raquo;</a></li>
                            <%}%>    
                            <%if(command.equals("MaNhomSP")){%>
                            <%      for(int i = 1; i <= (total/6) + 1; i++){ 
                                    if(i == pages){
                            %>
                            <li class="active"><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=<%=MaNhomSP%>&pages=<%=i %>"><%=i %></a></li>
                                    <%}else{%>
                                <li ><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=<%=MaNhomSP%>&pages=<%=i %>"><%=i %></a></li>
                            <%          }
                                    }
                            %>                               
                                <li><a href="HienThiSanPham?command=MaNhomSP&MaNhomSP=<%=MaNhomSP%>&pages=<%=++next %>">&raquo;</a></li>
                            <%}%>
                            <%if(command.equals("LoaiMaNhom")){ %>
                            <%      for(int i = 1; i <= (total/6) + 1; i++){ 
                                    if(i == pages){
                            %>
                            <li class="active"><a href="HienThiSanPham?command=LoaiMaNhom&MaNhomSP=<%=MaNhomSP%>&LoaiSP=<%=LoaiSP%>&pages=<%=i %>"><%=i %></a></li>
                                    <%}else{%>
                                <li ><a href="HienThiSanPham?command=LoaiMaNhom&MaNhomSP=<%=MaNhomSP%>&LoaiSP=<%=LoaiSP%>&pages=<%=i %>"><%=i %></a></li>
                            <%          }
                                    }
                            %>                               
                                <li><a href="HienThiSanPham?command=LoaiMaNhom&MaNhomSP=<%=MaNhomSP%>&LoaiSP=<%=LoaiSP%>&pages=<%=++next%>">&raquo;</a></li>
                            <%}%>                            
                        </ul>
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
