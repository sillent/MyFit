<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="ru.pork.model.Contracts" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ru.pork.model.Service" %>
<%--
  Created by IntelliJ IDEA.
  User: santa
  Date: 12.04.16
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список привязанных услуг</title>
</head>
<body>
<table border="1">
  <th>ID услуги</th><th>Название услуги</th>
  <tr>
  <%
    ClubProgramManager clubProgramManager=new ClubProgramManager();
    Integer i=0;
    Service service;
    try {
      i = Integer.parseInt(request.getParameter("program_id"));
    } catch (NumberFormatException n) {
      i=0;
    }
    ClubProgram program = clubProgramManager.findClubProgram(i);
    Iterator<Service> iterator =program.getServices().iterator();
    for (; iterator.hasNext();) {
      service=iterator.next();
      out.print("<td>"); out.print(service.getId()); out.print("</td>");
      out.print("<td>"); out.print(service.getName()); out.print("</td>");
    }
  %>
  </tr>
</table>
<br/>
<a href="/welcome.jsp">Назад</a>
</body>
</html>
