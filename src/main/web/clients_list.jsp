<%@ page import="ru.pork.util.ClientManager" %>
<%@ page import="ru.pork.model.Client" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: santa
  Date: 01.03.16
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список всех клиентов</title>
</head>
<body>

<table border="1">
  <th>Идентификатор</th><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Пол</th><th>Год рождения</th><th>Клубная прорамма</th>
  <%
    ClubProgramManager clubProgramManager=new ClubProgramManager();

    ClientManager clientManager=new ClientManager();
    for (Client cl: clientManager.listClients()) {
      out.print("<tr>");
      out.print("<td>");
      out.print(cl.getId());
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getFirstName());
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getLastName());
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getSecondName());
      out.print("</td>");
      out.print("<td>");
      if (cl.getGender()==0) {
        out.print("Муж.");
      } else
        out.print("Жен.");
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getBirthDate());
      out.print("</td>");
      out.print("<td>");
      out.print(clubProgramManager.findClubProgram(cl.getProgram().getId()).getName());
      out.print("</td>");
      out.print("</tr>");
    }
  %>
  </table>
<a href="welcome.jsp">Назад</a>

</body>
</html>
