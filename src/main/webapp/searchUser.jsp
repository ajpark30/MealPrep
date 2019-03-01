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
                            <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Last Name"/>
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

        <div class="row">
            <div class="well" id="userWell">
                <h1>Create New User</h1>
                <form class="form-horizontal" action="createNewUser">
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="createFirstName">Enter a First Name</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="createFirstName" name="createFirstName" aria-describedby="createFirstNameHelp" placeholder="Enter a First Name"/>
                        </div>
                        <br />
                        <br />
                        <br />
                        <label class="control-label col-sm-5" for="createLastName">Enter a Last Name</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="createLastName" name="createLastName" aria-describedby="createLastNameHelp" placeholder="Enter a Last Name"/>
                        </div>
                        <br />
                        <br />
                        <br />
                        <label class="control-label col-sm-5" for="createUserName">Enter a User Name</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="createUserName" name="createUserName" aria-describedby="createUserNameHelp" placeholder="Enter a User Name"/>
                        </div>
                        <br />
                        <br />
                        <br />
                        <label class="control-label col-sm-5" for="createPassword">Enter a Password</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="createPassword" name="createPassword" aria-describedby="createPasswordHelp" placeholder="Enter a Password"/>
                        </div>
                        <br />
                        <br />
                        <br />
                        <div class="col-sm-offset-2 col-sm-6">
                            <button type="submit" name="submit" value="createUser" class="btn btn-primary">submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        </div>
    </div>
</head>
<body>

</body>
</html>
