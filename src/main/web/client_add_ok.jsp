<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 06.03.16
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клиент</title>
</head>
<body>
<H1>Клиент <% out.print(request.getParameter("firstName")); out.print(" "); out.print(request.getParameter("lastName")); %> созадн</H1>
<a href="welcome.jsp">Назад</a>
</body>
</html>
