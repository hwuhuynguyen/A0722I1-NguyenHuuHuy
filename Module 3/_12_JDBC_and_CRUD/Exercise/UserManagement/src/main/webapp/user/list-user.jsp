<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/21/2022
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List of users</title>
</head>
<body>
<h1>List of users</h1>
<p>
  <a href="/users?action=add">Add new user</a>
</p>
<p>
  <a href="/users?action=search">Search users by country</a>
</p>
<p>
  <a href="/users?action=sort">Sort users by name</a>
</p>
<table style="border: 1px solid black">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Country</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="user" items="${requestScope['userList']}">
    <tr>
      <td>${user.getId()}</td>
      <td>${user.getName()}</td>
      <td>${user.getEmail()}</td>
      <td>${user.getCountry()}</td>
      <td>
        <a href="/users?action=view&id=${user.getId()}">View</a>
        <a href="/users?action=update&id=${user.getId()}">Update</a>
        <a href="/users?action=delete&id=${user.getId()}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
