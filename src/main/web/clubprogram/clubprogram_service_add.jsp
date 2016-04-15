<%@ page import="ru.pork.util.ServiceManager" %>
<%@ page import="ru.pork.model.Service" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление услуги к клубной программе</title>
</head>
<body>
<form action="/clubprogramservice">
  <select name="service_id">
    <option disabled>Выберите услугу</option>
    <%
      ServiceManager serviceManager=new ServiceManager();
      for (Service service: serviceManager.listService()) {
        out.print("<option value=");out.print(service.getId());out.print(">"+service.getName()+"</option>");
      }
    %>
  </select>
  <br/>
  <input type="hidden" name="program_id" value="${param.program_id}"/>
  <input type="submit" value="Создать">
</form>
<br/>
<a href="/welcome.jsp">Назад</a>

</body>
</html>
