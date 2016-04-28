<%@ page import="ru.pork.util.PersonManager" %>
<%@ page import="ru.pork.model.Person" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>


<%@ include file="/header_import.jsp" %>
        <title>Список всех клиентов</title>
</head>
<body>

<table class="center" cellpadding="10" cellspacing="5">
  <th>ID</th><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Пол</th><th>Клиент/Администратор</th><th>Год рождения</th><th>Договора</th><th>Действие</th>
  <%
    PersonManager personManager =new PersonManager();
    for (Person cl: personManager.listClients()) {
      out.print("<tr>");
      out.print("<td>");
      out.print(cl.getId());
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getFirstName());
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getLastName());
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getSecondName());
      out.print("</td>");
      out.print("<td>");
      if (cl.getGender() == 0) {
        out.print("Муж.");
      } else
        out.print("Жен.");
      out.print("</td>");
      out.print("<td>");
      if (cl.getState() == 0) {
        out.print("Клиент");
      } else
        out.print("Администратор");
      out.print("</td>");
      out.print("<td>");
      out.print(cl.getBirthDate());
      out.print("</td>");
      out.print("<td>");
      out.print("<a href='/contract/contracts_clients_list.jsp?id=");
      out.print(cl.getId() + "'>Договора</a>");
      out.print("</td>");
      out.print("<td>");
      out.print("<a href='/person_del?id=");
      out.print(cl.getId() + "'>Удалить</a>");
      out.print("</td>");
      out.print("</tr>");
    }
  %>
  </table>
<br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
