<%--
  Created by IntelliJ IDEA.
  User: OneForAll
  Date: 2021/3/5
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    首页<br>
    <a href="${pageContext.request.contextPath}/users">查看数据库中所有用户</a><br>
    <form method="post" action="findUserByUsernameAndEmail">
        用户名：<input type="text" name="username" placeholder="请输入用户名"><br>
        邮箱：<input type="text" name="email" placeholder="请输入邮箱"><br>
        <input type="submit" value="查询">
    </form>
</body>
</html>
