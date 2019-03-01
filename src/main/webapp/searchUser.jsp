<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/28/19
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Home Page"/>
<%@include file="header.jsp"%>
<html>
<head>
    <div class="container col-md-8 col-md-offset-2">
        <div class="row">
            <div class="well" id="userWell">
                <h1>User Search</h1>
                <form class="form-horizontal" action="searchUser">
                    <div class="form-group">
                      <label class="control-label col-sm-5" for="searchTerm">Search User by Last Name</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Last Name" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-6">
                            <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
                            <button type="submit" name="submit" value="viewAll" class="btn btn-default">View All Users</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</head>
<body>

</body>
</html>
