<%--
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<%@include file="header.jsp"%>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session.invalidate();
    response.sendRedirect("http://13.58.132.122:8080/DoForFund/");
%>
<%@include file="footer.jsp"%>
</body>
</html>
