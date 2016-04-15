<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="ru.pork.model.Contracts" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ru.pork.model.Service" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список привязанных услуг</title>
</head>
<body>
<table border="1">
  <th>ID услуги</th><th>Название услуги</th>
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
      out.print("<tr>");
      out.print("<td>"); out.print(service.getId()); out.print("</td>");
      out.print("<td>"); out.print(service.getName()); out.print("</td>");
      out.print("</tr>");
    }
  %>
  </tr>
</table>
<br/>
<a href="/clubprogram/clubprogram_service_add.jsp?program_id=${param.program_id}">Добавить</a>
<br/>
<a href="/welcome.jsp">Назад</a>
</body>
</html>
