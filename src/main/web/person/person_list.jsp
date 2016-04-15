<%@ page import="ru.pork.util.PersonManager" %>
<%@ page import="ru.pork.model.Person" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="ru.pork.util.ClubProgramManager" %>
<%@ page import="java.util.List" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список всех клиентов</title>
</head>
<body>

<table border="1">
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
