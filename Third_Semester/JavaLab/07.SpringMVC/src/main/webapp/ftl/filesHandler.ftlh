<#ftl encoding="UTF-8"/>
<html>
<head>
    <title>Files Handler</title>
</head>
<body>
<h1>Добро пожаловать в сервис Files Handler!</h1>
<h2>Для продолжения выберите: </h2>
<br>
<h3>Загрузка файла:</h3>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Загрузить файл">
</form>
<br>
<h3>Скачивание файла</h3>
<form action="/fileDownload">
    <label for="fileName">Имя файла: </label>
    <input id="fileName" type="text" name="fileName" placeholder="just.jpg " required>
    <br>
    <input type="submit" value="Скачать файл">
</form>
<br>
<h1>Чтобы вернуться на AccountPage нажмите на кнопку</h1>
<form action="http://localhost:8080/accountPage">
    <input type="submit" value="Вернуться">
</form>
</body>
</html>