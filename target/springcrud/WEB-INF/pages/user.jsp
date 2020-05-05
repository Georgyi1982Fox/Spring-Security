<%--
  Created by IntelliJ IDEA.
  User: georg
  Date: 24.03.2020
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>

<div align="center">
    <h1>Hello ${user.username}</h1>
    <h2>your login is ${user.username}</h2>
    <h2>your password is ${user.password}</h2>
 </div>
<a href="/registrationPage">Registration</a>
</body>
</html>
