<#ftl encoding="UTF-8"/>
<html>
<head>
    <title>AccountsTable</title>
</head>
<body>
<h1>Здесь Вы можете увидеть всех пользователей сервиса:</h1>
<table>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    <#list usersList as user>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </#list>
</table>


<h1>Чтобы вернуться на AccountPage нажмите на кнопку</h1>
<form action="http://localhost:8080/accountPage">
    <input type="submit" value="Вернуться">
</form>
</body>
</html>