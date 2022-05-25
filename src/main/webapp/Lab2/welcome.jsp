<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2022/5/00025
  Time: 上午 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome,
    <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>

    <jsp:useBean id="Login" class="com.example.liubing2020211001001130.Lab2.Login" scope="request"></jsp:useBean>
    <%--todo 10 : use jsp:getProperty to display username --%>

    <jsp:getProperty name="Login" property="username"/>
</h2>
</body>
</html>