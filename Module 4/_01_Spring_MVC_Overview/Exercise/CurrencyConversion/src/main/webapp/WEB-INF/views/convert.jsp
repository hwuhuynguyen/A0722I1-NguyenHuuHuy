<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/8/2022
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convertor" method="post">
    <table>
        <tr>
            <td>
                <label>USD: </label>
            </td>
            <td>
                <input type="text" name="USD" placeholder="USD" value="${USD}"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>Exchange rate: </label>
            </td>
            <td>
                <input type="text" name="rate" placeholder="rate" value="${rate}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Converter">
            </td>
        </tr>
    </table>

    <h1>${result}</h1>

</form>

</body>
</html>
