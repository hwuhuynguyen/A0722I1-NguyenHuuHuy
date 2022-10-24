<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/21/2022
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View user information</title>
</head>
<body>
<h1>View user information</h1>
<p>
    <a href="/users">Back to user list</a>
</p>
<form method="post">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>User's name: </td>
                <td><input type="text" name="name" id="name" value="${user.getName()}"></td>
            </tr>
            <tr>
                <td>User's email: </td>
                <td><input type="email" name="email" id="email" value="${requestScope['user'].getEmail()}"></td>
            </tr>
            <tr>
                <td>User's country: </td>
                <td><input type="text" name="country" id="country" value="${user.getCountry()}" ></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
