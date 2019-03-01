<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/28/19
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Home Page"/>
<%@include file="header.jsp"%><html>
<head>
  <h1>Add New User Page</h1>
    <br />
    <form class="form-horizontal" action="addUser">
        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First Name:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="firstName" placeholder="Enter First Name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lastName">Last Name:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="lastName" placeholder="Enter Last Name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="userName">User Name:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="userName" placeholder="Enter a User Name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Last Name:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="password" placeholder="Enter a Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</head>
<body>

</body>
</html>
