<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>登录注册 </title>
  <link rel="stylesheet" href="css/dmaku.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
<div class="dowebok" id="dowebok">
  <div class="form-container sign-up-container">
    <form action="/OneForAll/UserServlet?action=register" method="post">
      <h1>注册</h1>
      <input type="text" name="username" id="username"  placeholder="用户名">
      <span id="usernameVerify"></span>
      <input type="password" name="password"  placeholder="密码">
      <input type="text" name="email"  placeholder="email">
      <button>注册</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form action="/OneForAll/UserServlet?action=login" method="post">
      <h1>登录</h1>
      <h3>${loginError}</h3>
      <h3>${unLogin}</h3>
      <h3>${registerResult}</h3>
      <input type="text" name="username"  placeholder="用户名">
      <input type="password" name="password"   placeholder="密码">
      <input type="text" name="code"  placeholder="验证码">
      <img src="/OneForAll/image" title="看不清点击刷新" id="checkCode"/>
      <button>登录</button>
      <%--<div class="alert alert-warning alert-dismissible">
        <strong>登录失败!</strong>
      </div>--%>
    </form>


  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>已有帐号？</h1>
        <p>请使用您的帐号进行登录</p>
        <button class="ghost" id="signIn">登录</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>没有帐号？</h1>
        <p>立即注册加入我们，和我们一起开始旅程吧</p>
        <button class="ghost" id="signUp">注册</button>
      </div>
    </div>
  </div>
</div>
<script src="js/dmaku.js"></script>
<script src="js/ajax.js"></script>
<script src="js/index.js"></script>
</body>
</html>