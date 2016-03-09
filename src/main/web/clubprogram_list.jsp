<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 06.03.16
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клубные программы</title>
</head>
<body>
<table>
  <th>ID</th><th>Название</th><th>Цена</th><th>Действие</th>
<%
  ClubProgramManager manager=new ClubProgramManager();
  for (ClubProgram program : manager.listClubProgram()) {
    out.print("<tr>");
    out.print("<td>");out.print(program.getId());out.print("</td>");
    out.print("<td>");out.print(program.getName());out.print("</td>");
    out.print("<td>");out.print(program.getPrice());out.print("</td>");
    out.print("<td>");out.print("<a href='clubprogram_edit.jsp?program_id=");out.print(program.getId());out.print("'>Править</a>");out.print("</td>");
    out.print("</tr>");
  }
%>
</table>
<br/>
<a href="welcome.jsp">Назад</a>

</body>
</html>
