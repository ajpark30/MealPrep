<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 5/5/19
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Created Grocery List"/>
<%@include file="header.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <c:if test="${!empty groceryListName}">
            <div class="well" id="results">
                <h2>Hey ${userName}, you have added a new grocery list named: ${groceryListName}</h2>
            </div>
        </c:if>
        <c:if test="${empty groceryListName}">
            <div class="well" id="errorResults">
                <h2>Could Not Find ${ingredient}, Try Another Ingredient.</h2>
            </div>
            <div class="well" id="errorResults">
                <h2>Could Not Find ${ingredient1}, Try Another Ingredient.</h2>
            </div>
            <div class="well" id="errorResults">
                <h2>Could Not Find ${ingredient2}, Try Another Ingredient.</h2>
            </div>
            <div class="btn-group-vertical">
                <a id="createMenu" type="button" class="btn btn-warning btn-lg" href="createMenu.jsp"/>Go back to Create Menu Page</a>
            </div>
        </c:if>
    </div>
</body>
</html>
