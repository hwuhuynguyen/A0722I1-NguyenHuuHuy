<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/9/2022
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple Dictionary</title>
</head>
<body>
    <form method="post" action="dictionary">
        <table>
            <tr>
                <td>English word: </td>
                <td><input type="text" name="engWord" placeholder="Enter english word"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Translate"></td>
            </tr>
        </table>
        <h3>Result: <span>${result}</span></h3>
    </form>
</body>
</html>
