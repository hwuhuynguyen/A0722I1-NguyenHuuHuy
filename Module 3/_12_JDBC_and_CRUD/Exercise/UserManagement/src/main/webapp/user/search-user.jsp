<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/21/2022
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search users by country</title>
</head>
<body>
<h1>Search users by country</h1>
<p>
    <c:if test="${requestScope['message'] != null}">
        <span>${requestScope['message']}</span>
    </c:if>
</p>
<p>
    <a href="/users">Back to user list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Search box</legend>
        <table>
            <tr>
                <td>User's country: </td>
                <td><input type="text" name="search-input" id="search-input"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Search by country"></td>
            </tr>
        </table>
    </fieldset>
</form>
<p>
    <c:if test="${requestScope['userList'] != null}">
        <table style="border: 1px solid black">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getCountry()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</p>

</body>
</html>
