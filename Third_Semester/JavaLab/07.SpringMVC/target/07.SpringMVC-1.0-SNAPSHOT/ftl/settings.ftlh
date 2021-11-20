<#ftl encoding="UTF-8"/>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h1>Настройки</h1>
<form method="post" action="/account/settings">
    <label for="confirmPassword">Подтвердите пароль: </label>
    <input id="confirmPassword" type="password" name="confirmPassword" placeholder="qwerty123" required>
    <br>
    <label for="firstName">Имя: </label>
    <input id="firstName" type="text" name="firstName" placeholder="Иван ">
    <br>
    <label for="lastName">Фамилия: </label>
    <input id="lastName" type="text" name="lastName" placeholder="Иванов ">
    <br>
    <label for="nickname">Никнейм: </label>
    <input id="nickname" type="text" name="nickname" placeholder="ivan228 ">
    <br>
    <label for="email">Почта: </label>
    <input id="email" type="email" name="email" placeholder="somemail@ya.ru ">
    <br>
    <label for="password">Новый пароль: </label>
    <input id="password" type="password" name="password" placeholder="qwerty123 ">
    <br>
    <label for="age">Возраст: </label>
    <input id="age" type="text" name="age" placeholder="exp. 45">
    <br>
    <label for="info">Доп инфо: </label>
    <input id="info" name="info" type="text" placeholder="Я люблю аниме">
    <br>
    <label for="avatarUUID">UUID аватарки</label>
    <input id="avatarUUID" type="text" name="avatarUUID">
    <br>
    <input type="submit" value="Обновить данные">
</form>
<br>
<h1>Вернуться на страницу пользователя: </h1>
<form action="/accountPage">
    <input type="submit" value="Назад">
</form>
</body>
</html>