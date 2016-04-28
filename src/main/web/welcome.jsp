<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Welcome</title>
</head>
<body>
  <H1 align="center">Фитнес Центр "Солнышко"</H1>
<table class="center" cellpadding="10" cellspacing="5">
  <tr>
    <th width="150">Наши клиенты</th>
    <th width="150">Услуги</th>
    <th width="150">Клубные программы</th>
  </tr>
  <tr>
    <td><a href="person/person_add.jsp">Новый клиент</a></td>
    <td><a href="service/service_add.jsp">Добавить услугу</a></td>
    <td><a href="clubprogram/clubprogram_add.jsp">Добавить Клубную программу</a></td>
  </tr>
  <tr>
    <td><a href="person/person_list.jsp">Список клиентов</a></td>
    <td><a href="service/service_list.jsp">Список услуг</a></td>
    <td><a href="clubprogram/clubprogram_list.jsp">Список клубных программ</a></td>
  </tr>
</table>
</body>
</html>
