<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/22/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sort users by name</title>
</head>
<body>
    <h1>Sort users by name</h1>
    <p>
        <a href="/users">Back to user list</a>
    </p>
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
