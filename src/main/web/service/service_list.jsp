<%@ page import="ru.pork.util.ServiceManager" %>
<%@ page import="ru.pork.model.Service" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Список услуг</title>
</head>
<body>
<table class="center" cellpadding="10" cellspacing="5">
  <th>ID</th><th>Название</th><th>Действие</th>
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
      out.print("<td>");
      out.print("<a href='/service_del?service_id="+s.getId()+"'>Удалить</a>");
      out.print("</td>");
      out.print("</tr>");
    }
  %>
</table>
<br/>
<a href="/welcome.jsp">Назад</a>

</body>
</html>
