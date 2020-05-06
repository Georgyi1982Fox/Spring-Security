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
    <h1>Hello"${pageContext.request.remoteUser}" </h1>
    <h2>your login is "${pageContext.request.remoteUser}"</h2>
    <h2>your password is  "${pageContext.request.remoteUser}"</h2>

    <a href="/registrationPage">Registration</a>
    <a href="/logout" > Logout</a>

 </div>

</body>
</html>
