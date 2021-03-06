<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 4/13/19
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Search Recipes"/>
<%@include file="header.jsp"%>
<html>
<head></head>
<body>
<div class="container col-md-8 col-md-offset-2">
    <div class="row">
        <div class="well" id="userWell">
          <h1 class="text-center">Search For Your Recipes</h1>
            <form class="form-horizontal" action="searchRecipes">
                <div class="form-group">
                    <label class="control-label col-sm-5" for="searchTerm">Search for Recipe by Last Name</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Last Name" required/>
                        </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-6">
                        <button type="submit" name="submit" value="searchUserRecipes" class="btn btn-primary">Search</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="well" id="userWell">
            <h1 class="text-center">Search For New Recipes </h1>
            <form class="form-horizontal" action="searchRecipes">
                <div class="form-group">
                    <label class="control-label col-sm-5" for="searchTerm">Enter a Recipe Name</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="newRecipeSearch" name="newRecipeSearch" aria-describedby="searchTermHelp" placeholder="New Recipe Search" required/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-6">
                        <button type="submit" name="submit" value="newRecipeSearch" class="btn btn-primary">Search</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

        <div class="row">
            <div class="well" id="userWell">
                <h1 class="text-center">Search for all My Recipes</h1>
                <form class="form-horizontal" action="searchRecipes">
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-6">
                            <button type="submit" name="submit" value="viewAll" class="btn btn-success">View All Users</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

</div>
</body>
</html>

