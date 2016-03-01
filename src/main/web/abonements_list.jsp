<%--
  Created by IntelliJ IDEA.
  User: santa
  Date: 01.03.16
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="ru.pork.util.AbonCardManager" %>
<%@ page import="ru.pork.model.AbonCard" %>
<html>
<head>
    <title>Список абонементов</title>
</head>
<body>
  <%--<center>--%>
    <table border="1">
      <th>Идентификатор</th><th>Название</th><th>Цена</th>
      <%
  AbonCardManager manager=new AbonCardManager();
  for (AbonCard card: manager.listAllAbonCards()) {
    out.print("<tr>");
    out.print("<td>");
    out.print(card.getId());
    out.print("</td>");
    out.print("<td>");
    out.print(card.getDescription());
    out.print("</td>");
    out.print("<td>");
    out.print(card.getPrice());
    out.print("</td>");
    out.print("</tr>");

  }
  %>

    </table>
    <a href="welcome.jsp">Назад</a>
  <%--</center>--%>
</body>
</html>
