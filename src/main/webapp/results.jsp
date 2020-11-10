<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/5/20
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>

</head>
<body>
<div class="container-fluid">
    <h2>Search Results: </h2>


    <table border=1 width=30% height=40% text-align="center">

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>


        </tr>




        <c:forEach items="${allUsers}" var="allUser">
            <tr>
                <td>${allUser.id}</td>
                <td>${allUser.firstName} ${allUser.lastName}</td>
                <td>${allUser.userName}</td>
            </tr>
        </c:forEach>

    </table>

    <a href="index.jsp">Back to homepage</a>

</div>


</body>
</html>
