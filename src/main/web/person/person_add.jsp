<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>


<%@ page import="java.util.List" %>
<%@ page import="ru.pork.util.ClubProgramManager" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/codebase/dhtmlxcalendar.css"/>
    <script src="/codebase/dhtmlxcalendar.js"></script>
    <script>
        var myCalendar;
        function doOnLoad() {
            myCalendar = new dhtmlXCalendarObject(["calendar"]);
        }
    </script>
    <title>Добавление клиента</title>

</head>
<body onload="doOnLoad();">
<jsp:useBean id="obj" class="ru.pork.util.PersonManager" scope="page"/>
<%
//    ClubProgramManager manager=new ClubProgramManager();
%>
<form action="/person" method="get">
    <table>
    <p>
        <label>
            Фамилия:
            <input type="text" name="lastName"/>
        </label><br/>
        <label>
            Имя:
            <input type="text" name="firstName"/>
        </label><br/>
        <label>
            Отчетство:
            <input type="text" name="secondName"/>
        </label><br/>
    </p>
        <p>
            <label>
                Тип пользователя:
                <select name="state">
                        <option selected value="0">Клиент</option>
                        <option value="1">Администратор</option>
                </select>
            </label>
        </p>
    <br/>
     <p><label>
         Телефон:
         <input type="number" name="phone"/>
     </label><br/></p>
     <br/>
    <p>
        <label>
            Дата рождения:
            <input type="text" name="birthDate" id="calendar"/>
        </label><br/>
        <label>
            Муж
            <input type="radio" name="gender" value="0"/>
        </label>
        <label>
            Жен
        <input type="radio" name="gender" value="1"/>
    </label><br/>
        <label>
            Email:
            <input type="text" name="email"/>
        </label><br/>
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
