<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/18/2022
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
    <h1>Delete product</h1>
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
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Product name: </td>
                    <td><input type="text" name="name" id="name" value="${product.getProductName()}"></td>
                </tr>
                <tr>
                    <td>Product price: </td>
                    <td><input type="number" name="price" id="price" value="${product.getProductPrice()}"></td>
                </tr>
                <tr>
                    <td>Product description: </td>
                    <td><input type="text" name="description" id="description" value="${product.getProductDescription()}"></td>
                </tr>
                <tr>
                    <td>Product manufacture: </td>
                    <td><input type="text" name="manufacture" id="manufacture" value="${product.getProductManufacture()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Delete product"></td>
                </tr>
            </table>
        </fieldset>
    </form>

</body>
</html>
