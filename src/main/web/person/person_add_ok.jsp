<%@ page import="ru.pork.model.Person" %>
<%@ page import="ru.pork.util.PersonManager" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Клиент</title>
</head>
<body>
<H1>Клиент <b><% out.print(request.getParameter("firstName")); out.print(" "); out.print(request.getParameter("lastName")); %></b> создан</H1>
<%
  PersonManager personManager=new PersonManager();
  Long phone;
  try {
    phone = Long.parseLong(request.getParameter("phone"));
  } catch (NumberFormatException n) {
    n.printStackTrace();
    phone=0L;
  }

  Person p=personManager.findClient(phone);
  out.print("<a href='/contract/contracts_clients_add.jsp?id="+p.getId()+"'>Заключить</a> договор");
%>
<br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
