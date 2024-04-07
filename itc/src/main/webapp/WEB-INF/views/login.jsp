<%--
  Created by IntelliJ IDEA.
  User: jing
  Date: 2022/10/26
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="/static/css/csslogin.css">
</head>

<body>
<div class="logo_box"><img class="logo_img" src="/static/images/user.png"></div>
<div class="login_box">
    <h1 class="title">欢迎登录</h1>
    <form action="/login" method="POST">
        <input class="input_box" type="text" placeholder="用户名" name="username">
        <input class="input_box" type="password" placeholder="密码" name="password">
        <button class="button_box">登录</button>
    </form>
    <a href="/logup" class="button_box">没有账号？立即注册</a>
</div>
</body>
</html>
