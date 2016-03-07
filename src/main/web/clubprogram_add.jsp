<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 06.03.16
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Создать клубную программу</title>
</head>
<body>
<form action="/clubprogram" method="get">
  <p>
  Название программы: <input type="text" name="name"/><br/>
    </p>
  <p>
  Цена: <input type="number" name="price"/><br/>
    </p>
  <input type="submit" value="Создать"/>
</form>
<br/>
<p><a href="welcome.jsp">Назад</a></p>

</body>
</html>
