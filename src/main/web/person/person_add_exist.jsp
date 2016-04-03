<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 03.04.16
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователь существует</title>
</head>
<body>
<H1><p style="color:red">ОШИБКА</p></H1>
<H1>Клиент c телефонным номером <%= request.getParameter("phone") %> или с почтовым ящиком <%= request.getParameter("email") %> уже существует</H1>
<br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
