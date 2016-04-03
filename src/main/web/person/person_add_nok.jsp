<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 06.03.16
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клиент</title>
</head>
<body>
<H1>Клиент <% out.print(request.getParameter("firstName")+" "+request.getParameter("lastName")); %> не был создан</H1>
<br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
