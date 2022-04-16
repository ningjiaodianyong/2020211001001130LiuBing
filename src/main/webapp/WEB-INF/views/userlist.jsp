<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2022/4/00017
  Time: 上午 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.HuangXingyue.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User List</h1>
<%
    User user=(User)request.getAttribute("user");
%>
<table border="1">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>email</td>
        <td>gender</td>
        <td>birthDate</td>
    </tr>

    <tr>
        <td><%=user.getID()%></td>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getGender()%></td>
        <td><%=user.getBirthdate()%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>