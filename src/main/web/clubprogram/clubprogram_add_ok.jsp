<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 06.03.16
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клубная программа</title>
</head>
<body>
<%
  String name=request.getParameter("name");
  String price=request.getParameter("price");
  %>
<H1>Клубная программа <%= name %> успешно создана</H1><br/>
<H1>Цена программы <%= price %></H1>
<br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
