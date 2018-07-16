<%-- 
    Document   : update_customer
    Created on : Jul 10, 2018, 2:20:26 PM
    Author     : Acer_Aspire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật thông tin</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
        <section id="form"><!--form-->
                <div class="container">                   
                    <div class="row">                       
                        <div class="col-sm-6">                          
                            <div class="login-form"><!--login form-->                                                             
                                <form action="CapNhatThongTinKH" method="post">
                                    <h2>Họ Tên</h2>
                                    <input type="text" placeholder="Họ tên" required="" name="hoten"/>
                                    <h2>Địa Chỉ</h2>
                                    <input type="text" placeholder="Địa chỉ" required="" name="diachi"/>
                                    <h2>Số Điện Thoại</h2>
                                    <input type="text" placeholder="Số điện thoại" required="" name="SDT"/>
                                    <h2>Email</h2>
                                    <input type="text" placeholder="Email" required="" name="email"/>
                                    <h2>Giới Tính</h2>                                   
                                    <select id="gioitinh" name="gioitinh">
                                            <option value="Nam">Nam</option>
                                            <option value="Nữ">Nữ</option>
                                        </select>                                       
                                    <button type="submit" class="btn btn-default" value="Submit">Cập nhật</button>
                                </form>    
                            </div><!--/login form-->
                        </div>                                           
                    </div>
                </div>
            </section><!--/form-->   
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
