<%@ page import="ru.pork.model.AbonCard" %>
<%--
  Created by IntelliJ IDEA.
  User: santa
  Date: 01.03.16
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="ru.pork.util.ClientManager" %>
<%@ page import="ru.pork.model.Client" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Добавление клиента</title>

</head>
<body>
<jsp:useBean id="obj" class="ru.pork.util.ClientManager" scope="page"/>
<%

%>
<form action="/client" method="get">
    <p>
        Фамилия: <input type="text" name="firstName"/><br/>
        Имя: <input type="text" name="lastName"/><br/>
        Отчетство: <input type="text" name="secondName"/><br/>
    </p>
    <br/>
    <p>
        Дата рождения: <input type="date" name="birthDate"/><br/>
        Муж <input type="radio" name="gender" value="0"/> Жен <input type="radio" name="gender" value="1"/><br/>
        Email: <input type="text" name="email"/><br/>
        Замечания: <input type="text" name="description" size="30"/><br/>
    </p>
    <br/>
    <p>
        Абонемент: <select name="aboncard">
        <%for (AbonCard card: list) {%>
        <% int id=card.getId(); pageContext.setAttribute("id",id); %>
            <option value="${id}"><% out.print(card.getDescription()); %></option>
        <%}%>

    </select>
    </p>
    <p>
        Дата начала действия абоненмента: <input type="date" name="begin_date"/><br/>
        Дата окончания действия абоненмента: <input type="date" name="expire_date"/><br/>
    </p>
    <p>
        <input type="submit" name="person" value="Сохранить"/><br/>
    </p>
</form>
<a href="welcome.jsp">Назад</a>

</body>
</html>
