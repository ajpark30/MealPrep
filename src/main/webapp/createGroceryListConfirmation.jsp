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
        <div class="well" id="results">
            <h2>Hey ${userName}, you have added a new grocery list named: ${groceryListName}</h2>
        </div>
    </div>
</body>
</html>
