<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 4/14/19
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Search Grocery List"/>
<%@include file="header.jsp"%>
<html>
<head></head>
<body>
    <div class="container col-md-8 col-md-offset-2">
        <div class="row">
            <div class="well" id="userWell">
                <h1 class="text-center">Search For Grocery Lists</h1>
                <form class="form-horizontal" action="searchGrocerylist">
                    <div class="form-group">
                      <label class="control-label col-sm-5" for="searchLastName">Search for Grocery Lists by User Last Name</label>
                        <div class="col-sm-5">
                          <input type="text" class="form-control" id="searchLastName" name="searchLastName" aria-describedby="searchTermHelp" placeholder="Last Name" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-6">
                          <button type="submit" name="submit" value="viewByLastName" class="btn btn-primary">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container col-md-8 col-md-offset-2">
        <div class="row">
            <div class="well" id="userWell">
                <form class="form-horizontal" action="searchGrocerylist">
                  <div class="form-group">
                    <label class="control-label col-sm-5" for="searchGroceryListName">Search for Grocery Lists by Grocery List Name</label>
                      <div class="col-sm-5">
                        <input type="text" class="form-control" id="searchGroceryListName" name="searchGroceryListName" aria-describedby="searchTermHelp" placeholder="Grocery List Name" required/>
                      </div>
                  </div>
                  <div class="form-group">
                      <div class="col-sm-offset-5 col-sm-6">
                        <button type="submit" name="submit" value="viewByGroceryListName" class="btn btn-success">Search</button>
                      </div>
                  </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container col-md-8 col-md-offset-2">
        <div class="row">
            <div class="well" id="userWell">
                <h1 class="text-center">Search for Logged in Users Grocery Lists</h1>
                <form class="form-horizontal" action="searchGrocerylist">
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-6">
                            <button type="submit" name="submit" value="viewAll" class="btn btn-success">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

