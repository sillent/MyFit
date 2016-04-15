
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клубная программа</title>
</head>
<body>
<H1><p style="color:red">ОШИБКА</p></H1>
<H1>Клубная программа <% out.print(request.getParameter("name")); %> не была создана</H1>
<br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
