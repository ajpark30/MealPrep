<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 3/1/19
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Added User Result"/>
<%@include file="header.jsp"%>

<html>
<body>

<div class="container">
    <div class="jumbotron">
        <h2 class="text-center">Congrats you Added a User</h2>
    </div>
    <div class="list-group">
        <table class="table" id="results">
            <tr>
                <td>User Name: ${addedUserName.getUserName()} </td>
            </tr>
            <tr>
                <td>User Id: ${addedUserName.getUserId()}</td>
            </tr>
            <tr>
                <td>Name: ${addedUserName.getFirstName()} ${addedUserName.getLastName()}</td>
            </tr>
        </table>
    </div>
</div>


</body>
</html>
