<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/14/2022
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Dictionary</title>
  </head>
  <body>
  <h2>Simple Dictionary</h2>
    <form action="/translate" method="post">
      <input type="text" name="txtSearch" placeholder="Enter your word: "/>
      <input type = "submit" id = "submit" value = "Search"/>
    </form>
  </body>
</html>
