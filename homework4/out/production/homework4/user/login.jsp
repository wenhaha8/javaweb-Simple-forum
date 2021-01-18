<%--
  Created by IntelliJ IDEA.
  User: 25380
  Date: 2020/11/13
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>心灵奇旅ing</title>
    <link rel="icon" type="text/x-icon" href="../images/xiaolian.png">
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/user/"}>
    <link rel="stylesheet" type="text/css" href="../css/user.css">
</head>
<body>
    <div id="loginBox">
        <h3 style="text-align: center">心灵奇旅ing</h3>
        <hr style="margin: 0px 10px 10px">
        <form action='login.do' method='post'>
            选择登陆模式：
            <input type="radio" name="mode" value="user" checked>用户
            <input type="radio" name="mode" value="manager">管理员
            <br>
            <lable class="inputF">账&nbsp;&nbsp;&nbsp;号：</lable><input class="inputK" required type='text' name='username' value='username'><br>
            <label class="inputF">密&nbsp;&nbsp;&nbsp;码：</label><input class="inputK" required type='password' name='password' value='password'><br>
            <label class="inputF">验证码：</label><input class="inputK" required type='text' name='validCode' autofocus="autofocus"><img src='validCode' style='margin:0px 10px;position:absolute;;width: 100px; height: 30px;'><br>
            保存密码：<input type='checkbox' name='savePwd' style="font-size: 16px"><br>
            <input class="loginBotton" type='submit' value='登陆'>
            <div style="float: right;margin: 0 0 0 10%">
                <a href='register.jsp'>注册新用户</a><br>
            </div>
        </form>
    </div>


</body>
</html>
