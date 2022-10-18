<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/17/2022
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Simple calculator</title>
  </head>
  <body>
    <h1>Simple Calculator</h1>
    <form method="post" action="/calculator">
    <table>
      <tr>
        <td>First operand:</td>
        <td><input type="number" name="firstOperand"></td>
      </tr>
      <tr>
        <td>Operator:</td>
        <td>
          <select name="operator">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand:</td>
        <td><input type="number" name="secondOperand"></td>
      </tr>
      <tr>
        <td> </td>
        <td><input type="submit" name="submit" value="Calculator"></td>
      </tr>
    </table>
  </body>
</html>
