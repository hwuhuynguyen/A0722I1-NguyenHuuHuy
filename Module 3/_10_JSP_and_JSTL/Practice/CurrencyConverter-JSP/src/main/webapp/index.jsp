<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/14/2022
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency converter</title>
  </head>
  <body>
  <h2>Currency converter</h2>
  <form action="converter.jsp" method="get">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
  </form>

  </body>
</html>
