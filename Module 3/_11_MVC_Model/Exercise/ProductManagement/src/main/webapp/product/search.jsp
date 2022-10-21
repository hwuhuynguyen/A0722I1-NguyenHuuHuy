<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/19/2022
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search product by name</title>
</head>
<body>
    <h1>Search product by name</h1>
    <p>
        <c:if test="${requestScope['message'] != null}">
            <span>${requestScope['message']}</span>
        </c:if>
    </p>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Search box</legend>
            <table>
                <tr>
                    <td>Product name: </td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search product by name"></td>
                </tr>
            </table>
        </fieldset>
    </form>

    <p>
        <c:if test="${requestScope['productList'] != null}">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Product name</th>
                    <th>Product price</th>
                    <th>Product description</th>
                    <th>Product manufacture</th>
                </tr>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.getId()}</td>
                        <td>${product.getProductName()}</td>
                        <td>${product.getProductPrice()}</td>
                        <td>${product.getProductDescription()}</td>
                        <td>${product.getProductManufacture()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </p>
</body>
</html>
