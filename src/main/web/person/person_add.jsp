<%--
  Created by IntelliJ IDEA.
  User: santa
  Date: 01.03.16
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%--<%@ page import="ru.pork.util.ClientManager" %>--%>
<%--<%@ page import="ru.pork.model.Client" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="ru.pork.model.ClubProgram" %>
<%@ page import="ru.pork.util.ClubProgramManager" %>
<html>
<head>
    <title>Добавление клиента</title>

</head>
<body>
<jsp:useBean id="obj" class="ru.pork.util.PersonManager" scope="page"/>
<%
    ClubProgramManager manager=new ClubProgramManager();
    List<ClubProgram> list=manager.listClubProgram();
%>
<form action="client" method="get">
    <table>
    <p>
        Фамилия: <input type="text" name="lastName"/><br/>
        Имя: <input type="text" name="firstName"/><br/>
        Отчетство: <input type="text" name="secondName"/><br/>
    </p>
    <br/>
        <p>
            Телефон: <input type="number" name="phone"/><br/>
        </p>
        <br/>
        <p>
           Абонемент <select name="clubprogram">
            <% for (ClubProgram prog: list) {%>
            <% int id=prog.getId(); pageContext.setAttribute("id",id); %>
            <option value="${id}"><%out.print(prog.getName());%> </option>
            <%}%>
        </select>
        </p>
    <p>
        Дата рождения: <input type="date" name="birthDate"/><br/>
        Муж <input type="radio" name="gender" value="0"/> Жен <input type="radio" name="gender" value="1"/><br/>
        Email: <input type="text" name="email"/><br/>
        Замечания: <input type="text" name="description" size="30"/><br/>
    </p>
    <br/>

    <p>
        <input type="submit" name="person" value="Сохранить"/><br/>
    </p>
    </table>
</form>
<br/>
<a href="../welcome.jsp">Назад</a>

</body>
</html>
