<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 3/2/19
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Deleted User Result"/>
<%@include file="header.jsp"%>

<html><body>

<div class="container">
    <h2 class="text-center">Congrats you Deleted a User</h2>
      <table class="table table-striped">
        <tr>
          <td>User Name: ${deletedUserName}</td>
        </tr>
      </table>
</div>
</body>
</html>
