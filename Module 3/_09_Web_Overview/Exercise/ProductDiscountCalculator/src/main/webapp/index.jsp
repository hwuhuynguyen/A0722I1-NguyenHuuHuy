<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/14/2022
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/calculator-discount" method="post">
    <h2>Product Discount Calculator</h2>
    <table>
      <tr>
        <td>
          <label>Product Description</label>
        </td>
        <td>
          <input type="text" name="productDescription">
        </td>
      </tr>
      <tr>
        <td>
          <label>Price($):</label>
        </td>
        <td>
          <input type="number" name="price">
        </td>
      </tr>
      <tr>
        <td>
          <label>Discount percent(%):</label>
        </td>
        <td>
          <input type="number" name="discount">
        </td>
      </tr>
    </table>
    <button>Calculator</button>
  </form>
  </body>
</html>
