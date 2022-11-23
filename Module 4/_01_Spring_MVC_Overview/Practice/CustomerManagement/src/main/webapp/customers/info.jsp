<%@ page import="customer_management.service.CustomerServiceFactory" %>
<%@ page import="customer_management.service.ICustomerService" %>
<%@ page import="customer_management.model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/26/2022
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%!
  private ICustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
  Long id = Long.valueOf(request.getParameter("id"));
  Customer customer = customerService.findOne(id);
%>
<form action="/customers" method="post">
  <fieldset>
    <legend>Customer Information</legend>
    <input type="hidden" name="id" value="<%= customer.getId() %>">
    <table>
      <tr>
        <td>Id</td>
        <td>
          <%= customer.getId() %>
        </td>
      </tr>
      <tr>
        <td>Name</td>
        <td>
          <input type="text" name="name" value="<%= customer.getName() %>">
        </td>
      </tr>
      <tr>
        <td>Email</td>
        <td>
          <input type="text" name="email" value="<%= customer.getEmail() %>">
        </td>
      </tr>
      <tr>
        <td>Address</td>
        <td>
          <input type="text" name="address" value="<%= customer.getAddress() %>">
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Update">
        </td>
      </tr>
    </table>
  </fieldset>
</form>
<a href="/customers/list.jsp">Back to list</a>.