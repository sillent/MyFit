<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 07.03.16
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клубная программа</title>
</head>
<body>
 <h1>Программа <% out.print(request.getParameter("name")); %> уже существует</h1>
<br/>
<a href="welcome.jsp">Назад</a>
</body>
</html>
