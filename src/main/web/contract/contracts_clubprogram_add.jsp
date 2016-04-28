<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="java.util.Iterator" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Добавление клубной программы к договору</title>
</head>
<body>
    Название клубной программы:
  <form action="/conclub">
      <select name="program_id">
          <%
              ClubProgramManager clubProgramManager=new ClubProgramManager();
              ClubProgram clubProgram;
              Iterator<ClubProgram> iterator=clubProgramManager.listClubProgram().iterator();
              out.print("<option disabled>Выберите программу</option>");
              for (;iterator.hasNext();) {
                  clubProgram=iterator.next();
                  out.print("<option value="); out.print(clubProgram.getId()); out.print(">"+clubProgram.getName()+"</option>");
              }
          %>
      </select>
      <br/>
      <input type="hidden" name="contract_id" value="${param.contract_id}"/>
      <input type="submit" value="Создать">
  </form>
    <br/>
<a href="/welcome.jsp">Назад</a>

</body>
</html>
