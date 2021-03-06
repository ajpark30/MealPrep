<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/28/19
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Delete User Page"/>
<%@include file="header.jsp"%>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">Delete User Page</h1>
    </div>
    <br />
    <div class="container col-md-8 col-md-offset-2">
        <div class="row">
            <div class="well" id="userWell">
                <form class="form-horizontal" action="deleteUser">
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="userId">Enter User ID to Delete User</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="userId" name="userId" placeholder="Enter a User ID" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-6">
                            <button type="submit" name="submitDelete" value="submitDelete" class="btn btn-warning">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
