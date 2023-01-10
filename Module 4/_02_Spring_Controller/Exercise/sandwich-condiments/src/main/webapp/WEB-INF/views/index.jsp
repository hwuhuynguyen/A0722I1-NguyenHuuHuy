<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/13/2022
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich condiments</title>
</head>
<body>
<h2>Sandwich condiments</h2>
<form method="post" action="/save">
    <input type="checkbox" name="condiments" value="Lettuce">Lettuce
    <input type="checkbox" name="condiments" value="Tomato">Tomato
    <input type="checkbox" name="condiments" value="Mustard">Mustard
    <input type="checkbox" name="condiments" value="Sprouts">Sprouts
    <br/><hr/>
    <input type="submit" value="Save">
</form>

<label>Condiments: </label>
<span>${result}</span>
</body>
</html>

