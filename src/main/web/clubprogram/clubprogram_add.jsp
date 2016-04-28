<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Создать клубную программу</title>
</head>
<body>
<form action="/clubprogram" method="get">
  <p><label>
  Название программы:<br/> <input type="text" name="name"/><br/>
  </label></p>
  <p><label>
  Описание:<br/> <input type="text" name="description"/><br/>
  </label></p>
  <p><label>
    Время работы программы:<br/> <input type="text" name="timeUsing"/><br/>
  </label></p>
  <p><label>
    Срок действия программы:<br/> <input type="number" name="daysActive"><br/>
  </label></p>
  <p><label>
    Цена:<br/> <input type="number" name="price"/><br/>
  </label></p>
  <input type="submit" value="Создать"/>
</form>
<br/>
<p><a href="/welcome.jsp">Назад</a></p>

</body>
</html>
