<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 10/11/24
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/update" method="post">
    Id:<input type="text"  name="id" value="${u.id}">
    <br>
    Name: <input type="text" name="name" value="${u.name}">
    <br>
    Age: <input type="number" name="age" value="${u.age}">
    <br>
    Address: <input type="text" name="address" value="${u.address}">
    <br>
    Status:
    <input type="radio" name="status" value="dang hoc"> đang hoc
    <input type="radio" name="status" value="dung hoc"> dung hoc
    <br>
    <button type="submit">update</button>
</form>
</body>
</html>
