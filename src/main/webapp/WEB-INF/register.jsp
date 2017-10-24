<%--
  Created by IntelliJ IDEA.
  User: Nicholas
  Date: 10/23/17
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register a New User" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<form action="register" method="post">
    <label for="username">Username: </label><input type="text" id="username" name="username"><br>
    <label for="email">Email: </label><input id="email" type="text" name="email"><br>
    <label for="password">Password: </label> <input id="password" type="password" name="password"><br>
    <input type="submit">
</form>

</body>
</html>
