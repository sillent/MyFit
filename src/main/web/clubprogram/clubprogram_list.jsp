<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="ru.pork.model.ClubProgram" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Клубные программы</title>
</head>
<body>
<table class="center" cellpadding="10" cellspacing="5">
  <th>ID</th><th>Название</th><th>Цена</th><th>Время работы</th><th>Срок действия</th><th>Услуги</th>
<%
  ClubProgramManager manager=new ClubProgramManager();
  for (ClubProgram program : manager.listClubProgram()) {
    out.print("<tr>");
    out.print("<td>");out.print(program.getId());out.print("</td>");
    out.print("<td>");out.print(program.getName());out.print("</td>");
    out.print("<td>");out.print(program.getPrice());out.print("</td>");
    out.print("<td>");out.print(program.getTimeUsing());out.print("</td>");
    out.print("<td>");out.print(program.getDaysActive());out.print("</td>");
//    out.print("<td>");out.print("<a href='clubprogram_edit.jsp?program_id=");out.print(program.getId());out.print("'>Править</a>");out.print("</td>");
    out.print("<td>");out.print("<a href='/clubprogram/clubprogram_service_list.jsp?program_id=");out.print(program.getId());out.print("'>Список привязанных услуг</a>");out.print("</td>");
    out.print("</tr>");
  }
%>
</table>
<br/>
<a href="../welcome.jsp">Назад</a>

</body>
</html>
