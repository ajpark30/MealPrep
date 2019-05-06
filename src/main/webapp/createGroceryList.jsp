<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 5/5/19
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Create Grocery List "/>
<%@include file="header.jsp"%>

<html>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">Create New Grocery List</h1>
    </div>

    <div class="container col-md-8" id="login">
        <form class="form-horizontal" action="createGroceryList">
            <div class="form-group">
                <label class="control-label col-sm-5" for="groceryListName">Grocery List Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="groceryListName" name="groceryListName" placeholder="Enter Name" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-5" for="firstIngredient">First Ingredient Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="firstIngredient" name="firstIngredient" placeholder="First Ingredient" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-5" for="secondIngredient">Second Ingredient Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="secondIngredient" name="secondIngredient" placeholder="Second Ingredient" required>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-5" for="thirdIngredient">Third Ingredient Name</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="thirdIngredient" name="thirdIngredient" placeholder="Third Ingredient" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <button type="submit" name="submit" value="submit" class="btn btn-primary">Submit Grocery List</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
