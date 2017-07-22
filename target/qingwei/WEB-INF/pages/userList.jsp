<%--
  Created by IntelliJ IDEA.
  User: kongwc
  Date: 2017/7/22
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户列表</h1>
<table>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.userId}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
