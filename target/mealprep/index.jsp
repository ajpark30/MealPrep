<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/24/19
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Home Page"/>
<%@include file="header.jsp"%>
<html>
  <div class="container">
    <div class="jumbotron">
      <h1 class="text-center">Meal Prep Home Page</h1>
    </div>
    <br />
    <br />
    <div class="btn-group-vertical">
      <a id="searchUser" type="button" class="btn btn-primary btn-lg" href="searchForUser.jsp"/>Go to Search User Page</a>
      <a id="addUser" type="button" class="btn btn-success btn-lg" href="addUser.jsp"/>Go to Add New User Page</a>
      <a id="deleteUser" type="button" class="btn btn-info btn-lg" href="deleteUser.jsp"/>Go to Delete User Page</a>
      <a id="searchRecipes" type="button" class="btn btn-warning btn-lg" href="searchForRecipe.jsp"/>Go to Recipe Search Page</a>
      <a id="createRecipe" type="button" class="btn btn-danger btn-lg" href="createRecipe.jsp"/>Go to Create Recipe Page</a>
      <a id="searchGrocerylist" type="button" class="btn btn-primary btn-lg" href="searchForGrocerylist.jsp"/>Go to Grocery List Search Page</a>
      <a id="createGroceryList" type="button" class="btn btn-success btn-lg" href="createGrocerylist.jsp"/>Go to Create Grocery List Page</a>
      <a id="searchMenu" type="button" class="btn btn-info btn-lg" href="searchForMenu.jsp"/>Go to Menu Search Page</a>
      <a id="createMenu" type="button" class="btn btn-warning btn-lg" href="createMenu.jsp"/>Go to Create Menu Page</a>
      <form action="logout">
        <button type="submit" name="submit" value="submit" class="btn btn-danger">Log Out</button>
      </form>
    </div>
  </div>
</body>
</html>