<%--
  Created by IntelliJ IDEA.
  User: OneForAll
  Date: 2021/3/6
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全体用户</title>
</head>
<body>
    <div style="border: 2px;align-content: center">
        <table>
            <thead>
                <tr>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>邮箱</th>
                    <th>生日</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                        <td>${user.birthday}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table><br>
        查询结果：
        用户名：${user.username},密码：${user.password},邮箱：${user.email},出生日期：${user.birthday}<br>
        ${error}
    </div>
</body>
</html>
