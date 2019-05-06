<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 3/30/19
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Log In Page"/>
<%@include file="header.jsp"%>
<html>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">Meal Prep Log In</h1>
    </div>

    <div class="container col-md-8 col-sm-8" id="login">
        <form class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3" id="loginForm" ACTION="j_security_check" METHOD="POST">
            <div class="form-group">
                <label for="j_username">User Name</label>
                <input type="text" class="form-control" name="j_username" id="j_username">
            </div>
            <div class="form-group">
                <label for="j_password">Password</label>
                <input type="password" class="form-control" name="j_password" id="j_password">
            </div>
            <button type="submit" value="Log In" class="btn btn-success btn-lg" id="loginButton">Log In</button>
        </form>
    </div>
</div>
</body>
</html>
