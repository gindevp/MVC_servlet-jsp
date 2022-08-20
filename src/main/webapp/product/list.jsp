<%--
  Created by IntelliJ IDEA.
  User: Huu Quyet
  Date: 8/20/2022
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <title>List product</title>
</head>
<body class="container">
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">QuyetDZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
            </ul>
            <form class="d-flex" method="post" action="/products?action=search">
                <input class="form-control me-2" type="text" placeholder="Search" name="search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div style="text-align: center">
    <h1>Products</h1>
</div>
<p>
    <a class="btn btn-primary" href="/products?action=create">CREATE</a>
</p>
<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Cost</th>
        <th>Address</th>
        <th style="text-align: center" colspan="2">Action</th>
    </tr>
    <c:forEach  var="product" items="${requestScope.products}">
        <tr>
            <td><a href="products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getCost()}</td>
            <td>${product.address}</td>
            <td style="text-align: center"><a class="btn btn-success" href="products?action=update&id=${product.getId()}">Edit</a></td>
            <td style="text-align: center"><a class="btn btn-danger" href="products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
