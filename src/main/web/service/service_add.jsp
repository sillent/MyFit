<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Добавление услуги</title>
</head>
<body>
<form action="/service" method="get" name="add">
  <label>Название:<br/>
  <input type="text" name="name">
  </label>
    <br/>
    <br/>
  <input type="submit" value="Создать"/>
</form>
<br/>
<a href="/welcome.jsp">Назад</a>

</body>
</html>
