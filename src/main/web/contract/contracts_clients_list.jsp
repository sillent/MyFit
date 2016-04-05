<%@ page import="ru.pork.util.PersonManager" %>
<%@ page import="ru.pork.model.Person" %>
<%@ page import="ru.pork.model.Contracts" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
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
<table border="1">
<th>ID контракта</th><th>Начало действия</th><th>Окончание действия</th><th>Статус</th><th>Программы</th>
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
  Iterator it=cl.getContracts().iterator();
  for (; it.hasNext();) {
    Contracts contracts=(Contracts)it.next();
    out.print("<tr>");
    out.print("<td>");
    out.print(contracts.getId());
    out.print("</td>");
    out.print("<td>");
    out.print(contracts.getContractBegin());
    out.print("</td>");
    out.print("<td>");
    out.print(contracts.getContractEnding());
    out.print("</td>");
    out.print("<td>");
    if (contracts.getStatus()==0) {
      out.print("Не активен");
    } else if (contracts.getStatus()==1) {
      if (contracts.getContractEnding().compareTo(new Date()) >= 0 ) {
        out.print("Активен");
      } else {
        out.print("Не активен");
      }
    }
    out.print("</td>");
    out.print("<td>");
    out.print("<a href='/contract/contracts_clubprogram_list.jsp?id="+contracts.getId()+"'>Список программ</a>");
    out.print("</td>");
    out.print("</tr>");
  }

  out.print("</table>");
  out.print("<br/>");
  out.print("<a href='"+"/contract/contracts_clients_add.jsp?id="+cl.getId()+"'>Создать контракт</a>");
  out.print("<br/>");
%>
  <br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
