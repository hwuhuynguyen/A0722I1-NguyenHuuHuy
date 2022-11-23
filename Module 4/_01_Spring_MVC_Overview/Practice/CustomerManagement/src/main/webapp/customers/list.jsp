<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/26/2022
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="customer_management.service.ICustomerService" %>
<%@ page import="customer_management.service.CustomerServiceFactory" %>
<%@ page import="customer_management.model.Customer" %>
<%!
    private ICustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    long count = customerService.count();
    List<Customer> customers = customerService.findAll();
%>
<style>
    table {
        border: 1px solid #000;
    }
    th, td {
        border: 1px dotted #555;
    }
</style>
There are <%= count %> customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <% for (Customer c : customers) { %>
    <tr>
        <td>
            <%= c.getId() %>
        </td>
        <td>
            <a href="info.jsp?id=<%= c.getId() %>"><%= c.getName() %></a>
        </td>
        <td>
            <%= c.getEmail() %>
        </td>
        <td>
            <%= c.getAddress() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
