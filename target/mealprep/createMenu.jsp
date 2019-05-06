<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 5/5/19
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Create Menu"/>
<%@include file="header.jsp"%>

<html>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">Create New Grocery List</h1>
    </div>

    <div class="container col-md-8" id="login">
        <form class="form-horizontal" action="createMenu">
            <div class="form-group">
                <label class="control-label col-sm-5" for="menuName">Menu Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="menuName" name="menuName" placeholder="Enter Name" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-5" for="firstRecipe">First Recipe Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="firstRecipe" name="firstRecipe" placeholder="First Recipe" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-5" for="secondRecipe">Second Recipe Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="secondRecipe" name="secondRecipe" placeholder="Second Recipe" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-5" for="thirdRecipe">Third Recipe Name</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="thirdRecipe" name="thirdRecipe" placeholder="Third Recipe" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <button type="submit" name="submit" value="submit" class="btn btn-primary">Submit Menu</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
