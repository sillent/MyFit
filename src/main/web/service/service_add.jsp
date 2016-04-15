<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление услуги</title>
</head>
<body>
<form action="/service" method="get" name="add">
  <label>Название:
  <input type="text" name="name">
  </label>
  <input type="submit" value="Создать"/>
</form>
<br/>
<a href="/welcome.jsp">Назад</a>

</body>
</html>
