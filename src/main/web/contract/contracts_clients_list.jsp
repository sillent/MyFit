<%@ page import="ru.pork.util.PersonManager" %>
<%@ page import="ru.pork.model.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 07.03.16
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Договора клиента</title>
</head>
<body>
<table>
<th>Название </th>
<%
  PersonManager clm=new PersonManager();
  int i=0;
  try {
    i=Integer.parseInt(request.getParameter("id"));
  } catch (NumberFormatException n) {
    n.printStackTrace();
    i=0;
  }
  Person cl=clm.findClient(i);
  out.print("<a href='/contract/contracts_clients_add.jsp?id="+cl.getId()+">Создать</a>");
%>
</table>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
