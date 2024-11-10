<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2024
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table border="1">
    <form action="/user/add" method="post">
        Id:<input type="text"  name="id">
        <br>
        Name: <input type="text" name="name">
        <br>
        Age: <input type="number" name="age">
        <br>
        Address: <input type="text" name="address">
        <br>
        Status: <input type="radio" name="status" value="dang hoc"> đang hoc <input type="radio" name="status" value="dung hoc"> dung hoc
        <br>
        <button type="submit" onclick="return confirm('Ban co muon add hay khong?')">Add</button>
    </form>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>address</th>
        <th>status</th>
        <th>action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${listUser}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.age}</td>
                <td>${u.address}</td>
                <td>${u.status}</td>
                <td>
                    <button><a href="/user/remove?id=${u.id}">Remove</a></button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
