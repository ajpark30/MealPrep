<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/24/19
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html><body>

<div class="container-fluid">

    <h2>Results for all Users</h2>
    <c:forEach items="${users}" var="user">
    <table border = "1" width = "100%">
        <tr>
            <th>User ID: ${user.userId}</th>
        </tr>
        <tr>
            <td>User Name: ${user.userName}<br />
                First Name: ${user.firstName} <br />
                Last Name: ${user.lastName}<br />
            </td>
            <br />
        </tr>
    </table>
    </c:forEach>

</body>
</html>