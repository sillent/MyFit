<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Заключение договора с человеком</title>
</head>
<body onload="doOnLoad();">
<h2>Заключение договора</h2>
  <form action="/contract" method="get">
    <table>
    <label>
      Дата начала действия договора:<br/>
      <input type="text" name="contractBegin" id="calendar"/>
    </label>
    <br/>
    <label>
      Дата окончания действия договора:<br/>
      <input type="text" name="contractEnding" id="calendar2"/>
    </label>
    <br/>
    Cтатус:<br/>
    <label>
      Активен
      <input type="radio" name="status" value="1"/>
    </label>
    <label>
      Не активен
      <input type="radio" name="status" value="0"/>
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
