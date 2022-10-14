<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/14/2022
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <form action="/converter" method="get">
      <label>Rate</label><br/>
      <input type="number" name="rate" placeholder="RATE"><br/>
      <label>USD</label><br/>
      <input type="number" name="usd" placeholder="USD"/><br/>
      <input type="submit" value="Converter"/>
    </form>
  </body>
</html>
