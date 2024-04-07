<%--
  Created by IntelliJ IDEA.
  User: 15949
  Date: 2022/12/12
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/fontawesome.min.css" integrity="sha512-xX2rYBFJSj86W54Fyv1de80DWBq7zYLn2z0I9bIhQG+rxIF6XVJUpdGnsNHWRa6AvP89vtFupEPDP8eZAtu9qA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <link rel="stylesheet" href="/static/css/style.css"/>
  <title>Login/Signup page</title>
</head>

<body>
<h2>登 录/注 册</h2>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="/dologup" method="post">
      <h1>注册账号</h1>
      <div class="social-container">
      </div>
      <input type="text" placeholder="用户名" name="username"/>
      <input type="password" placeholder="密码" name="password"/>
      <input type="email" placeholder="邮箱" name="email"/>
      <input type="text" placeholder="年龄" name="age"/>
      <input type="text" placeholder="性别" name="sex"/>
      <button>注册</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form action="/login" method="post">
      <h1>登录</h1>
      <div class="social-container">

      </div>
      <input type="text" placeholder="用户名" name="username" />
      <input type="password" placeholder="密码" name="password" />
      <button>登录</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>欢迎回来!</h1>
        <p>
          请使用您的个人信息登录
        </p>
        <button class="ghost" id="signIn">登录</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>你好!</h1>
        <p>输入您的个人详细信息并开始我们的旅程</p>
        <button class="ghost" id="signUp">注册</button>
      </div>
    </div>
  </div>
</div>
<footer>
</footer>

<script src="/static/js/script.js"></script>
</body>

</html>
