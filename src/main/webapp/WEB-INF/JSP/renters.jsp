<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mehmet Ali Ayaz
  Date: 2/20/2021
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Renter Name</td>
    </tr>
    </thead>
    <c:forEach items="${renters}" var="renter">
    <tr>
<td>${renter.id}</td>
        <td>${renter.renterName}</td>
</tr>
    </c:forEach>
</table>
</body>
</html>
