<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/24/19
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Home Page"/>
<%@include file="header.jsp"%>
<html>
<body>
  <h1>Meal Prep Home Page</h1>
  <br />
  <br />
  <h2 id="searchUser"><a href="searchUser.jsp"/>Go to Search User Page</h2>
  <h2 id="addUser"> <a href="addUser.jsp"/>Go to Add New User Page</h2>
  <h2 id="deleteUser"><a href="deleteUser.jsp"/>Go to Delete User Page</h2>

</body>
</html>