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

<div class="container-fluid">
    <h2>Congrats you Deleted a User</h2>
    <div class="container col-md-8 col-md-offset-2">
        <div class="row">
            <div class="well" id="userWell">
                <h2>${deletedUserName}</h2>
            </div>
        </div>
    </div>
</div>

</body>
</html>
