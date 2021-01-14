<%--
  Created by IntelliJ IDEA.
  User: OneForAll
  Date: 2020/12/15
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<div align="center"><h3>${loginSuccess}</h3></div>
    <table align="center" border="1">
        <thead>
            <tr>
                <th colspan="3">
                    <a href="/OneForAll/UserServlet?action=queryAllUser">查询所有用户</a>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>用户名：${user.username}</td>
                    <td>密码：${user.password}</td>
                    <td>邮箱：${user.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
