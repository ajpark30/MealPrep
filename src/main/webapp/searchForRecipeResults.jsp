<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 4/13/19
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Recipe Results"/>
<%@include file="header.jsp"%>

<html>
<body>
    <div class="container">
        <div class="jumbotron">
            <h2 class="text-center">Results for Recipes</h2>
        </div>
        <div class="list-group">
                <c:forEach items="${recipeInfo}" var="recipeList">
                    <table class="table table-striped">
                        <tr>
                            <th id="results">Recipe Name: ${recipeList.recipeTitle}</th>
                        </tr>

                        <c:forEach items="${ingredientsList}" var="ingredients">
                        <tr id="results">
                            <td>Ingredients: ${ingredients}</td>
                        </tr>
                        </c:forEach>
                    </table>
                </c:forEach>

                <c:forEach items="${newRecipeInfo}" var="newRecipeList">
                    <table class="table table-striped">
                        <tr>
                            <th id="results">Recipe Name: ${newRecipeList}</th>
                        </tr>
                    </table>
                </c:forEach>

        </div>
    </div>
</body>
</html>
