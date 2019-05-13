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
      <div class="jumbotron">
          <h2 class="text-center">Results for all Users</h2>
      </div>
    <div class="list-group">
          <c:forEach items="${userInfo}" var="user">
              <table class="table" id="results">
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
        <c:if test="${empty userInfo}">
            <div class="well" id="errorResults">
                <h2>Could Not Find User With Last Name: ${errorName}</h2>
            </div>
            <div class="btn-group-vertical">
            <a id="searchUser" type="button" class="btn btn-primary btn-lg" href="searchForUser.jsp"/>Go Back Search User Page</a>
            </div>
        </c:if>
    </div>
  </div>


</body>
</html>