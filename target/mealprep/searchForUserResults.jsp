<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/24/19
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="User Results"/>
<%@include file="header.jsp"%>

<html>
<body>

  <div class="container">
    <div class="list-group">
      <h2 class="text-center">Results for all Users</h2>
          <c:forEach items="${userInfo}" var="user">
              <table class="table table-striped">
                  <tr>
                      <th>Employee ID: ${user.userId}</th>
                  </tr>
                  <tr>
                      <td>Name: ${user.firstName} ${user.lastName}<br />
                          User Name: ${user.userName}<br />
                      </td>
                      <br />
                  </tr>
              </table>
          </c:forEach>
    </div>
  </div>


</body>
</html>