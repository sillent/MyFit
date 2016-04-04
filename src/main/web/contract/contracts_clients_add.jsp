<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 03.04.16
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/codebase/dhtmlxcalendar.css"/>
    <script src="/codebase/dhtmlxcalendar.js"></script>
    <script>
        var myCalendar;
        function doOnLoad() {
            myCalendar = new dhtmlXCalendarObject(["calendar","calendar2"]);
        }
    </script>
    <title>Заключение контракта с человеком</title>
</head>
<body onload="doOnLoad();">
<h2>Заключение контракта</h2>
  <form action="/contract" method="get">
    <table>
    <label>
      Дата начала действия контракта:
      <input type="text" name="contractBegin" id="calendar"/>
    </label>
    <br/>
    <label>
      Дата окончания действия контракта:
      <input type="date" name="contractEnding" id="calendar2"/>
    </label>
    <br/>
    Cтатус:
    <label>
      Активен
      <input type="radio" name="status" value="1"/>
    </label>
    <label>
      Не активен
      <input type="radio" name="status" value="1"/>
    </label>
    <label>
        <input type="hidden" name="person_id" value="<%=request.getParameter("id")%>">
    </label>
    <br/>
    <input type="submit"/>
    </table>
  </form>
<br/>
<a href="/welcome.jsp">Назад</a>
</body>
</html>
