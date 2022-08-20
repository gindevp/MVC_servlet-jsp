<%--
  Created by IntelliJ IDEA.
  User: Huu Quyet
  Date: 8/19/2022
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <title>List customer</title>
</head>
<body class="container">
<div style="text-align: center">
    <h1>Customer</h1>

</div>
<p>
    <a class="btn btn-primary" href="/customers?action=create">Create</a>
</p>
<table class="table table-striped">
    <tr >
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td style="text-align: center" colspan="2">Action</td>
    </tr>
    <c:forEach var="customer" items='${requestScope["customers"]}'>
        <tr>
            <td><a class="btn btn-light" href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td style="text-align: center"><a class="btn btn-success" href="/customers?action=edit&id=${customer.getId()} ">edit</a></td>
            <td style="text-align: center"><a class="btn btn-danger"href="/customers?action=delete&id=${customer.getId() }">delete</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
