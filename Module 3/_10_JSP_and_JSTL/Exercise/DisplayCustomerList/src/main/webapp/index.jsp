<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/16/2022
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Display customers list</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<h1 style="text-align: center">List of customers</h1>
<table>
  <tr>
    <th>Full name</th>
    <th>Date of birth</th>
    <th>Address</th>
    <th>Avatar</th>
  </tr>

  <c:forEach var="customer" items="${customerList}">
    <tr>
      <td><c:out value="${customer.getNameCustomer()}"></c:out></td>
      <td><c:out value="${customer.getDateOfBirth()}"></c:out></td>
      <td><c:out value="${customer.getAddress()}"></c:out></td>
      <td><img src="<c:out value="${customer.getAvatar()}"></c:out>"></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
