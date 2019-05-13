<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 5/5/19
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Logged Out"/>
<%@include file="header.jsp"%>

<html>
<head>
    <title>Logged Out Successfully</title>
</head>
<body>
<c:set var="userName" value="${userName}"/>
    <div class="well" id="results">
        <h1>Successfully Logged Out ${userName} $userName</h1>
    </div>
</body>
</html>

