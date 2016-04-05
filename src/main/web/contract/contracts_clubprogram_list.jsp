<%@ page import="ru.pork.util.ContractsManager" %>
<%@ page import="ru.pork.model.Contracts" %>
<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: santa
  Date: 05.04.16
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список программ закрепленных за контрактом ${param.id}</title>
</head>
<body>
<table border="1">
  <th>ID</th><th>Название программы</th><th>Описание</th><th>Время</th><th>Срок действия</th><th>Цена</th>
  <tr>
    <%
      ContractsManager contractsManager=new ContractsManager();
      Integer i=0;
      ClubProgram program;
      try {
        i = Integer.parseInt(request.getParameter("id"));
      } catch (NumberFormatException n) {
        i=0;
      }
      Contracts contracts = contractsManager.findContractById(i);
      Iterator<ClubProgram> iterator =contracts.getClubPrograms().iterator();
      for (; iterator.hasNext();) {
        program=iterator.next();
        out.print("<td>"); out.print(program.getId()); out.print("</td>");
        out.print("<td>"); out.print(program.getName()); out.print("</td>");
        out.print("<td>"); out.print(program.getDescription()); out.print("</td>");
        out.print("<td>"); out.print(program.getTimeUsing()); out.print("</td>");
        out.print("<td>"); out.print(program.getDaysActive()); out.print("</td>");
        out.print("<td>"); out.print(program.getPrice()); out.print("</td>");
      }
    %>
  </tr>
</table>
<br/>
<a href="/contract/contracts_clubprogram_add.jsp?contract_id=${param.id}">Добавить программу</a>
<br/>
<a href="/welcome.jsp">Назад</a>
</body>
</html>
