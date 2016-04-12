<%@ page import="ru.pork.util.ServiceManager" %>
<%@ page import="ru.pork.model.Service" %>
<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 03.04.16
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список услуг</title>
</head>
<body>
<table border="1">
  <th>ID</th><th>Название</th>
  <%
    ServiceManager serviceManager=new ServiceManager();
    for (Service s : serviceManager.listService()) {
      out.print("<tr>");
      out.print("<td>");
      out.print(s.getId());
      out.print("</td>");
      out.print("<td>");
      out.print(s.getName());
      out.print("</td>");
      out.print("</tr>");
    }
  %>
</table>
<br/>
<a href="/welcome.jsp">Назад</a>

</body>
</html>
