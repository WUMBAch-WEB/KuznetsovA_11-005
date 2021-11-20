<#ftl encoding="UTF-8"/>
<#import "spring.ftl" as spring/>
<html>
<head>
    <title><@spring.message 'personal_page.title'/></title>

    <style>
        .avatar {
            width: 100px;
            height: 100px;
            display: inline;
            border-radius: 50px;
            justify-content: center;
        }
        .name {
            display: inline;
        }
    </style>
</head>
<body>
<h2><a href="?lang=ru">РУ</a> </h2>
<h2><a href="?lang=en">EN</a> </h2>
<h1><@spring.message 'personal_page.account.data.title'/></h1>
<form action="/account/settings">
    <input type="submit" value="<@spring.message 'personal_page.settings.button'/>">
</form>
<#if account.avatarUUID??>
    <img class="avatar" alt="IMAGE" src="/fileDownload?fileName=${account.avatarUUID}" />
<#else>
    <img class="avatar" alt="IMAGE" src="resources/no-avatar.jpeg" />
</#if>
<h3><@spring.message 'personal_page.avatar.settings'/></h3>
<form action="/account/updateAvatar" method="post" enctype="multipart/form-data">
    <input type="file" name="file" accept="image/png, image/jpeg, image/bmp">
    <input type="hidden" name="id" value=${account.id}>
    <input type="submit" value="<@spring.message 'personal_page.update.button'/>">
</form>
<h2><@spring.message 'personal_page.account.data.name'/> ${account.firstName}</h2>
<br>
<h2><@spring.message 'personal_page.account.data.last_name'/> ${account.lastName}</h2>
<br>
<h1><@spring.message 'personal_page.services.title'/>  "FrequencyCounter"</h1> <br>
<form action="http://localhost:8080/counter">
    <input type="submit" value="<@spring.message 'personal_page.services.button'/> ">
</form>

<br>
<h1><@spring.message 'personal_page.services.title'/>  "FileHandler" - нажмите на кнопку</h1> <br>
<form action="http://localhost:8080/filesHandler">
    <input type="submit" value="<@spring.message 'personal_page.services.button'/> ">
</form>
</body>
</html>