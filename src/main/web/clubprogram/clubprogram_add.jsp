<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 06.03.16
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Создать клубную программу</title>
</head>
<body>
<form action="/clubprogram" method="get">
  <p><label>
  Название программы: <input type="text" name="name"/><br/>
  </label></p>
  <p><label>
  Описание: <input type="text" name="description"/><br/>
  </label></p>
  <p><label>
    Время работы программы: <input type="text" name="timeUsing"/><br/>
  </label></p>
  <p><label>
    Срок действия программы: <input type="number" name="daysActive"><br/>
  </label></p>
  <p><label>
    Цена: <input type="number" name="price"/><br/>
  </label></p>
  <input type="submit" value="Создать"/>
</form>
<br/>
<p><a href="/welcome.jsp">Назад</a></p>

</body>
</html>
