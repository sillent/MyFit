<%@ page import="ru.pork.util.ClientManager" %>
<%@ page import="ru.pork.model.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 07.03.16
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Договора клиента</title>
</head>
<body>
<table>
<th>Название </th>
<%
  ClientManager clm=new ClientManager();
  int i=0;
  try {
    i=Integer.parseInt(request.getParameter("id"));
  } catch (NumberFormatException n) {
    n.printStackTrace();
    i=0;
  }
  Client cl=clm.findClient(i);
%>
</table>
<a href="contracts_clients_add.jsp?client_id=">Создать</a><br/>
<a href="welcome.jsp">Назад</a>
</body>
</html>
