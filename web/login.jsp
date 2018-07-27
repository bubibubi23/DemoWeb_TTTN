<%-- 
    Document   : login
    Created on : Jun 29, 2018, 1:55:32 PM
    Author     : Acer_Aspire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | Register</title>

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
            String err = "", userName_err = "";
            if(request.getAttribute("err") != null){
                err = (String) request.getAttribute("err");
            }
            if(request.getAttribute("userName_err") != null){
                userName_err = (String) request.getAttribute("userName_err");
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <section id="form"><!--form-->
                <div class="container">
                    
                    <div class="row">
                        <h3 style="color: red"><%=err%></h3>
                        <div class="col-sm-4 col-sm-offset-1">                          
                            <div class="login-form"><!--login form-->                             
                                <h2>Đăng nhập tài khoản</h2>
                                <form action="KhachHangDangNhap" method="post">
                                    <input type="text" placeholder="Tên đăng nhập" required="" name="username" id="username"/>
                                    <input type="password" placeholder="Mật khẩu" required="" name="pass"/>
                                    <span>
                                        <input type="checkbox" class="checkbox"> 
                                        Lưu tài khoản
                                    </span>
                                    <button type="submit" class="btn btn-default" value="Submit">Đăng nhập </button>
                                    
                                </form>
                            </div><!--/login form-->
                        </div>
                        <div class="col-sm-1">
                            <h2 class="or">Hoặc</h2>
                        </div>
                        <h3 style="color: red"><%=userName_err%></h3>
                        <div class="col-sm-4">
                            <div class="signup-form"><!--sign up form-->
                                <h2>Đăng ký thành viên</h2>
                                <form action="KhachHangDangKy" method="post">
                                    <input type="text" placeholder="Tên tài khoản" name="username" required="" id="username"/>
                                    <input type="email" placeholder="Địa chỉ Email" name="email" required=""/>
                                    <input type="password" placeholder="Mật khẩu" name="pass" required=""/>
                                    <button type="submit" class="btn btn-default " value="Đăng ký">Đăng ký</button>
                                </form>
                            </div><!--/sign up form-->
                        </div>
                    </div>
                </div>
            </section><!--/form-->    

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
