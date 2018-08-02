<%-- 
    Document   : account
    Created on : Jul 9, 2018, 9:33:10 PM
    Author     : Acer_Aspire
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Model.DonHang"%>
<%@page import="DAO.DonHangDAO"%>
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
        <% 
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            KhachHang khachhang = (KhachHang) session.getAttribute("khachhang");
            if(khachhang == null){
                khachhang = new KhachHang();
                session.setAttribute("khachhang", khachhang);
            }
            DonHangDAO donhangDAO = new DonHangDAO();
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <section>
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12">
                            <div class="row">

                                <div class="col-xs-12 col-sm-12 col-lg-9">
                                    <h3 > THÔNG TIN TÀI KHOẢN</h3>                                    
                                    <p><strong>Xin chào, <%=khachhang.getUsername() %></strong></p>
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
                                                                <th>Ngày tạo</th>
                                                                <th>Chuyển đến</th>
                                                                <th>Địa chỉ</th>
                                                                <th>Giá trị đơn hàng</th>
                                                                <th>Tình trạng</th>
                                                                <th>&nbsp;</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%for(DonHang donhang : donhangDAO.listDonHangByMaKH(khachhang.getMaKH())) {%>
                                                            <tr class="first odd">
                                                                <td><a><%=donhang.getMaDH() %></a></td>
                                                                <td><%=donhang.getNgayTao() %></td>
                                                                <td><%=donhang.getHoTen() %></td>
                                                                <! --  -->
                                                                <td>
                                                                    <%=donhang.getDiaChi() %> <!-- TP Hồ Chí Minh -->
                                                                </td>
                                                                <td><span class="price"><%=currencyVN.format(donhang.getTongTien())%></span></td>
                                                                <td>
                                                                    <em>

                                                                        <%=donhang.getTrangThai() %>

                                                                    </em>
                                                                </td>
                                                                <td class="a-center last"><span class="nobr"> <a href="order_details.jsp?MaDH=<%=donhang.getMaDH() %>">Xem chi tiết</a></span></td>
                                                            </tr>
                                                            <%}%>
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
