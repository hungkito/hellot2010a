<%@page import="com.example.hello_t2010a_agen.entity.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2022
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
    int action = (int) request.getAttribute("action");
    String url = "/admin/customer/create";
    if (action == 2){
        url = "/admin/customer/edit";
    }
%>
<html>
<head>
    <title>Create new Customer</title>
</head>
<body>
    <h1>Create customer</h1>
    <a href="/admin/customers/list.jsp">Back to list</a>
    <form action="<%=url%>" method="post">
        <div>Name <input type="text" name="name" value="<%=customer.getName()%>"></div>
        <div>Phone <input type="text" name="phone" value="<%=customer.getPhone()%>"></div>
        <div>Image <input type="text" name="image" value="<%=customer.getImage()%>"></div>
        <div>Birthday <input type="text" name="birthday" value="<%=customer.getDobString()%>"></div>
        <div>
            <input type="submit" value="Save">
            <input type="reset" value="Reset">
        </div>
    </form>
</body>
</html>
