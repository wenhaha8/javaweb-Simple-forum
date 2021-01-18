<%--
  Created by IntelliJ IDEA.
  User: 25380
  Date: 2020/11/16
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<h2>这里是修改用户信息的界面</h2>
<form action="mod.do" method="post">
    <input type="hidden" name="id" value="${user.userId}"><br>
    用户名：<input type="text" name="name" value="${user.userName}"><br>
    密&nbsp;&nbsp;码：<input type="password" name="pwd" value="${user.pwd}">
    <input type="submit" value="确认修改">
</form>

</body>
</html>
