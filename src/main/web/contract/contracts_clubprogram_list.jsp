<%@ page import="ru.pork.util.ContractsManager" %>
<%@ page import="ru.pork.model.Contracts" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="java.util.Iterator" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Список программ закрепленных за договором ${param.id}</title>
</head>
<body>
<table class="center" cellpadding="10" cellspacing="5">
  <th>ID</th><th>Название программы</th><th>Описание</th><th>Время</th><th>Срок действия</th><th>Цена</th><th>Услуги</th>
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
        out.print("<td>"); out.print("<a href=/clubprogram/clubprogram_service_list.jsp?program_id="+program.getId()+">Список</a>"); out.print("</td>");
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
