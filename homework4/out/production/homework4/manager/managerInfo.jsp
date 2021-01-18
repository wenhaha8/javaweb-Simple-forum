<%--
  Created by IntelliJ IDEA.
  User: 25380
  Date: 2021/1/9
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
</head>
<body>
    <span>上次登录时间：${manager.lastLoginTime}</span>
    <span>欢迎 ${manager.managerName} 登陆！</span>
</body>
</html>
