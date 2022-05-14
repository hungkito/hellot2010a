<%@ page import="com.example.hello_t2010a_agen.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2022
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<html>
<head>
    <title>Customer Detail</title>
</head>
<body>
<h1>Customer detail</h1>
<a href="/admin/customers/list.jsp">Back to list</a>
<a href="/admin/customers/create">Create new customer</a>
<div>
    Rollnumber: <%= customer.getRollnumber()%>
</div>
<div>
    Name: <%= customer.getName()%>
</div>
</body>
</html>
