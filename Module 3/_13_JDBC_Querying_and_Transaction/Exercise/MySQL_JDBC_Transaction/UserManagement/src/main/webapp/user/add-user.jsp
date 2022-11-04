<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/19/2022
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
    <h1>Add new user</h1>
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
            <legend>User information</legend>
            <table>
                <tr>
                    <td>User's name: </td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>User's email: </td>
                    <td><input type="email" name="email" id="email"></td>
                </tr>
                <tr>
                    <td>User's country: </td>
                    <td><input type="text" name="country" id="country"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add new user"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
