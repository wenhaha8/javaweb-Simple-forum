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
    <h1>欢迎注册！</h1>
    <hr style="margin: 0px 10px 10px">
    <form action="register" method="post" enctype="multipart/form-data">
        头像：<input type="file" name="photoUrl"><br>
        账号：<input type="text" name="username"><br>
        昵称：<input type="text" name="nickname"><br>
        密码：<input type="password" name="password"><br>
        性别：<input type="radio" name="gender" value="男" checked>男
        <input type="radio" name="gender" value="女">女<br>
<%--        年龄：--%>
<%--        <select>--%>
<%--            <option name="age" value="00后">00后</option>--%>
<%--            <option name="age" value="90后">90后</option>--%>
<%--            <option name="age" value="80后">80后</option>--%>
<%--            <option name="age" value="70后">70后</option>--%>
<%--        </select>--%>
<%--        <br>--%>
<%--        爱好：<input type="checkbox" name="habit" value="Python">Python--%>
<%--        <input type="checkbox" name="habit" value="Java">Java--%>
<%--        <input type="checkbox" name="habit" value="C/C++">C/C++--%>
<%--        <input type="checkbox" name="habit" value="玩">玩<br>--%>
        <input class="loginBotton" type="submit" value="注册">
        <div style="float: right;margin: 0 0 0 10%">
            <a href='login.jsp'>返回登录</a><br>
        </div>
    </form>
</div>


</body>
</html>
