<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nicholas
  Date: 10/18/17
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="All Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />
<ul>
    <c:forEach var="ad" items="${ads}">
        <li>
            <p>ID: ${ad.id}</p>
            <p>User ID: ${ad.userId}</p>
            <p>Title: ${ad.title}</p>
            <p>Description: ${ad.description}</p>
        </li>
    </c:forEach>
</ul>



</body>
</html>
