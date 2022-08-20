<%--
  Created by IntelliJ IDEA.
  User: Huu Quyet
  Date: 8/20/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    .message{
        color: green;
    }
</style>
<head>
    <title>Create new product</title>
</head>

<body>
<h1>Create new product</h1>
<p>
    <c:if test="${requestScope.message!=null}">
        <span class="message">${requestScope.message}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>

<form action="/products?action=create" method="post">
    <fieldset>
        <legend>product infomation</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Cost:</td>
                <td><input type="number" name="cost" id="cost"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
