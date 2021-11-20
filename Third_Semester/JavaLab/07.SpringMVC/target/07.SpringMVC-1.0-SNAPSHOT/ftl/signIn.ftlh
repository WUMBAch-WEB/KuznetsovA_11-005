<#ftl encoding="UTF-8"/>
<html>
<head>
    <title>Sign In</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Чтобы войти в аккаунт заполните все поля:</h1>
<form method="post" action="/signIn">
    <label for="email">Почта: </label>
    <input id="email" type="email" name="email" placeholder="somemail@ya.ru " required>
    <br>
    <label for="password">Ваш пароль: </label>
    <input id="password" type="password" name="password" placeholder="qwerty123 " required>
    <br>
    <input type="submit" value="Войти">
</form>
<br>
<h1>Если у вас нет аккаунта, зарегестрируйтесь: </h1>
<form action="/signUp">
    <input type="submit" value="Регистрация">
</form>
</body>
</html>