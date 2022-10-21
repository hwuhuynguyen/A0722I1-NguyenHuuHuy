<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/18/2022
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of products</title>
</head>
<body>
    <h1>List of products</h1>
    <p>
        <a href="/products?action=add">Add new products</a>
    </p>
    <table>
        <tr>
            <th>ID</th>
            <th>Product name</th>
            <th>Product price</th>
            <th>Product description</th>
            <th>Product manufacture</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getProductPrice()}</td>
                <td>${product.getProductDescription()}</td>
                <td>${product.getProductManufacture()}</td>
                <td><a href="/products?action=view&id=${product.getId()}">View</a></td>
                <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/products?action=search">Search product by name</a>
    </p>
</body>
</html>
