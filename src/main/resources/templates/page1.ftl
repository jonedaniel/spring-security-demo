<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example </title>
</head>
<body>
<h1>this is page1</h1>
<a href="/index">index</a>
<a href="/logout">logout</a>
<h2>${username} 您好</h2>
</body>
</html>