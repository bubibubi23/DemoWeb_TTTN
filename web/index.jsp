<%-- 
    Document   : index
    Created on : Jun 29, 2018, 1:34:42 PM
    Author     : Acer_Aspire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | G-Shop</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
        <jsp:include page="slider.jsp"></jsp:include>
        
        <jsp:include page="content.jsp"></jsp:include>
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
