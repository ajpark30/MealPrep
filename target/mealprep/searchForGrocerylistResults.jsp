<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 4/25/19
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Recipe Results"/>
<%@include file="header.jsp"%>

<html>
<body>
<div class="container">
    <div class="jumbotron">
        <h2 class="text-center">Results for Grocery Lists</h2>
    </div>
    <div class="list-group">
        <c:forEach items="${grocerylistInfo}" var="grocerylist">
            <table class="table">
                <tr>
                    <th id="results">Recipe Name: ${grocerylist.grocerylistName}</th>
                </tr>
            </table>
        </c:forEach>
    </div>
</div>
</body>
</html>
