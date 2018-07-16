<%-- 
    Document   : account
    Created on : Jul 9, 2018, 9:33:10 PM
    Author     : Acer_Aspire
--%>

<%@page import="DAO.KhachHangDAO"%>
<%@page import="Model.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Khách Hàng</title>
    </head>
    <body>
        <% String username =  (String) session.getAttribute("username"); 
           KhachHangDAO khachhangDAO = new KhachHangDAO();
           KhachHang khachhang = khachhangDAO.timKhachHang(username);
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <section>
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12">
                            <div class="row">

                                <div class="col-xs-12 col-sm-12 col-lg-9">
                                    <h3 > THÔNG TIN TÀI KHOẢN</h3>                                    
                                    <p><strong>Xin chào, <%=username%></strong></p>
                                </div>
                                <div class="col-xs-12 col-sm-12 col-lg-3">
                                    <div class="block block-account">
                                        <div class="block-title"><h4>Tài khoản của tôi</h4></div>
                                        <div class="block-content form-signup">
                                            <p>Họ Tên: <strong> <%=khachhang.getHoTen() %></strong></p>
                                            <p>Địa chỉ: <strong><%=khachhang.getDiaChi() %></strong></p>
                                            <p>Số điện thoại:<strong> <%=khachhang.getSDT() %></strong>  </p>   
                                            <p>Giới tính:<strong><%=khachhang.getGioiTinh() %></strong></p>
                                            <p>Email:<strong><%=khachhang.getEmail() %></strong></p>
                                            <a href="update_customer.jsp"><button type="button" class="btn btn-fefault cart">Cập nhật thông tin</button></a>                                            
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-12 col-lg-12">
                                    <div class="my-account">
                                        <div class="dashboard">
                                            <div class="recent-orders">
                                                <div class="form-signup">Đơn hàng gần nhất </div>
                                                <div class="table-responsive">
                                                    <table class="table table-cart" id="my-orders-table">
                                                        <thead class="thead-default">
                                                            <tr>
                                                                <th>Đơn hàng</th>
                                                                <th>Ngày</th>
                                                                <th>Chuyển đến</th>
                                                                <th>Địa chỉ</th>
                                                                <th>Giá trị đơn hàng</th>
                                                                <th>Tình trạng thanh toán</th>
                                                                <th>&nbsp;</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="first odd">
                                                                <td><a href='/account/orders/3558834'>#1198</a></td>
                                                                <td>20/08/2017</td>
                                                                <td>Nguyễn Công Việt Thanh</td>
                                                                <! --  -->
                                                                <td>
                                                                    46 Man Thiện, TP Hồ Chí Minh, Việt Nam <!-- TP Hồ Chí Minh -->
                                                                </td>
                                                                <td><span class="price">2.840.000₫</span></td>
                                                                <td>
                                                                    <!-- <em>
                                                                            
                                                                            Đã thanh toán
                                                                            
                                                                    </em> -->
                                                                    <em>

                                                                        Đã thanh toán

                                                                    </em>
                                                                </td>
                                                                <td class="a-center last"><span class="nobr"> <a href="/account/orders/3558834">Xem chi tiết</a></span></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>

                                                <div class="text-xs-right">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>