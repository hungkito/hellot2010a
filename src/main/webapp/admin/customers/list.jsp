<%@ page import="com.example.hello_t2010a_agen.entity.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2022
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> listCustomer = (List<Customer>)request.getAttribute("listCustomer");
%>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
<h1>List Customer</h1>
<a href="/admin/customers/create">Create new customer</a>
<ul>
    <%for (Customer ct : listCustomer){%>
    <li>
        <%= ct.getRollnumber()%> - <%=ct.getName()%>
        <a href="/admin/customers/detail.jsp?id=<%=ct.getRollnumber()%>">Detail</a>
        <a href="/admin/customers/edit?id=<%=ct.getRollnumber()%>">Edit</a>
        <a href="/admin/customers/delete?id=<%=ct.getRollnumber()%>" onclick="confirm('Are you sure?')">Delete</a>
    </li>
    <%}%>
</ul>
</body>
</html>
