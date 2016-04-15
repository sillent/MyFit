
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клубная программа</title>
</head>
<body>
 <h1>Программа <% out.print(request.getParameter("name")); %> уже существует</h1>
<br/>
<a href="../welcome.jsp">Назад</a>
</body>
</html>
