<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2022/5/00025
  Time: 上午 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.liubing2020211001001130.Lab2.Login" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="Login" class="com.example.liubing2020211001001130.Lab2.Login" scope="request"></jsp:useBean>
<%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="Login" property="username" value="<%=request.getParameter(\"username\")%>"></jsp:setProperty>
<jsp:setProperty name="Login" property="password" value="<%=request.getParameter(\"password\")%>"></jsp:setProperty>
<%
    //todo 3: use if check username is admin and password is admin
    if (Login.getUsername().equals("admin")&&Login.getPassword().equals("admin")) {
        HttpSession loginSession = request.getSession();
        loginSession.setAttribute("login", Login);
    }
%>
<%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"></jsp:forward>

else
{
    out.println("username or password error");
    <jsp:include page="login.jsp"></jsp:include>
}
</body>

</html>