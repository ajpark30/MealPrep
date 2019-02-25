<%--
  Created by IntelliJ IDEA.
  User: andrewpark
  Date: 2/24/19
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value = "Search"/>
<%@include file="header.jsp"%>
<html>
<body>
  <h1>Meal Prep User Admin</h1>
  <div>
    <h1>User Search</h1>
    <form action="searchUser" class="form-inline">
      <div>
          <label for="searchTerm">Search User by Last Name</label>
          <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Last Name"/>
      </div>
        <button type="submit" name="submit" value="search" class="btn btn-primary">search</button>
        <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</button>
    </form>
  </div>
  <br />
  <div>
    <h1>Create New User</h1>
      <form action="createNewUser" class="form-inline">
        <div>
          <label for="createFirstName">Enter a First Name</label>
          <input type="text" class="form-control" id="createFirstName" name="createFirstName" aria-describedby="createFirstNameHelp" placeholder="Enter a First Name"/>
          <br />
          <label for="createLastName">Enter a Last Name</label>
          <input type="text" class="form-control" id="createLastName" name="createLastName" aria-describedby="createLastNameHelp" placeholder="Enter a Last Name"/>
          <br />
          <label for="createUserName">Enter a User Name</label>
          <input type="text" class="form-control" id="createUserName" name="createUserName" aria-describedby="createUserNameHelp" placeholder="Enter a User Name"/>
          <br />
          <label for="createPassword">Enter a Password</label>
          <input type="text" class="form-control" id="createPassword" name="createPassword" aria-describedby="createPasswordHelp" placeholder="Enter a Password"/>
          <br />
        </div>
        <button type="submit" name="submit" value="createUser" class="btn btn-primary">submit</button>
      </form>
  </div>
</body>
</html>