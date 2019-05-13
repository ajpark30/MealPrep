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

<html>
<body>

<div class="container">
      <div class="jumbotron">
          <h2 class="text-center">Deleted User Information</h2>
      </div>
    <c:if test="${!empty deletedUserName}">
      <div class="list-group">
          <table class="table" id="errorResults">
            <tr>
              <td>User Name: ${deletedUserName}</td>
            </tr>
          </table>
      </div>
    </c:if>
    <c:if test="${empty deleteUserName}">
        <div class="well" id="results">
            <h2>Could Not Find User With ID: ${errorId}</h2>
            <h2>No User was deleted</h2>
        </div>
        <div class="btn-group-vertical">
            <a id="deleteUser" type="button" class="btn btn-info btn-lg" href="deleteUser.jsp"/>Go back to Delete User Page</a>
        </div>
    </c:if>
</div>
</body>
</html>
