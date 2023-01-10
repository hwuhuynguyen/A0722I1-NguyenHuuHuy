<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/13/2022
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple calculator</title>
  </head>
  <body>
    <h1>Simple calculator</h1>
    <form method="post" action="/calculate">
      <input type="text" name="firstOperand" placeholder="First operand" size="20">
      <input type="text" name="secondOperand" placeholder="Second operand" size="20">
      <br/>
      <button type="submit" name="operator" value="+">Addition (+)</button>
      <button type="submit" name="operator" value="-">Subtraction (-)</button>
      <button type="submit" name="operator" value="*">Multiplication (*)</button>
      <button type="submit" name="operator" value="/">Division (/)</button>
    </form>

    <h2>Result: <span>${result}</span></h2>
  </body>
</html>