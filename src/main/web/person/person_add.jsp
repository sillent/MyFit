
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header_import.jsp"%>
    <title>Добавление клиента</title>

</head>
<body onload="doOnLoad();">
<jsp:useBean id="obj" class="ru.pork.util.PersonManager" scope="page"/>

<form action="/person" method="get">
    <table>
    <p>
        <label>
            Фамилия:<br/>
            <input type="text" name="lastName"/>
        </label><br/>
        <label>
            Имя:<br/>
            <input type="text" name="firstName"/>
        </label><br/>
        <label>
            Отчетство:<br/>
            <input type="text" name="secondName"/>
        </label><br/>
    </p>
        <p>
            <label>
                Тип пользователя:<br/>
                <select name="state">
                        <option selected value="0">Клиент</option>
                        <option value="1">Администратор</option>
                </select>
            </label>
        </p>
     <p><label>
         Телефон:<br/>
         <input type="number" name="phone"/>
     </label></p>
    <p>
        <label>
            Дата рождения:<br/>
            <input type="text" name="birthDate" id="calendar"/>
        </label>
    </p><p>
        <label>
            Пол:</br>
            Муж
            <input type="radio" name="gender" value="0"/>
        </label>

        <label>
            Жен
        <input type="radio" name="gender" value="1"/>
    </label></p>
        <p>
        <label>
            Email:<br/>
            <input type="text" name="email"/>
        </label><br/>
    </p>
    <p>
        <input type="submit" name="person" value="Сохранить"/><br/>
    </p>
    </table>
</form>

<a href="../welcome.jsp">Назад</a>

</body>
</html>
