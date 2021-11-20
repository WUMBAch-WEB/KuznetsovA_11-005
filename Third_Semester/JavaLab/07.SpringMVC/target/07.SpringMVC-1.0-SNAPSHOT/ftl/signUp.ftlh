<#ftl encoding="UTF-8"/>
<#import "spring.ftl" as spring/>
<html>
<head>
    <title>Sign Up</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2><a href="?lang=ru">РУ</a> </h2>
<h2><a href="?lang=en">EN</a> </h2>
<h1><@spring.message 'sign_up_page.title'/></h1>
<@spring.bind"signUpForm"/>
<#if namesErrorMessage ??>
    <p class="error">${namesErrorMessage}</p>
</#if>
<form method="post" action="/signUp">
    <label><@spring.message 'sign_up_page.firstname.label'/></label>
    <@spring.formInput "signUpForm.firstName"/>
    <@spring.showErrors "<br> " "error" />
    <br>
    <label><@spring.message 'sign_up_page.lastname.label'/></label>
    <@spring.formInput "signUpForm.lastName"/>
    <@spring.showErrors "<br> " "error" />
    <br>
    <label for="nickname"><@spring.message 'sign_up_page.nickname.label'/></label>
    <input id="nickname" type="text" name="nickname" placeholder="ivan228 " required>
    <br>
    <label>Email: </label>
    <@spring.formInput "signUpForm.email"/>
    <@spring.showErrors "<br> " "error" />
    <br>
    <label><@spring.message 'sign_up_page.password.label'/></label>
    <@spring.formPasswordInput "signUpForm.password"/>
    <@spring.showErrors "<br> " "error" />
    <br>
    <input type="submit" value="<@spring.message 'sign_up_page.sign_up.button'/>">
</form>
<br>
<h1><@spring.message 'sign_up_page.have.account.title'/></h1>
<form action="/signIn">
    <input type="submit" value="<@spring.message 'sign_up_page.auth.button'/>">
</form>
</body>
</html>