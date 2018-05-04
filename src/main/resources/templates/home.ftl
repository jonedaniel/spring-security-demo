<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example </title>
</head>
<body>
<h1>this is homePage</h1>
<a href="/index">index</a>
<a href="/logout">logout</a><br>
${username!""}你好，登陆失败
</body>
</html>