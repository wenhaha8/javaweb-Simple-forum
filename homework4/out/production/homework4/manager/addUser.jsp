<%--
  Created by IntelliJ IDEA.
  User: 25380
  Date: 2020/11/16
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
</head>
<body>
    <div style="">
        <h2>这里是添加用户的界面</h2>
        <form action="add.do" method="post" style="">
            用户名：<input type="text" name="name"><br>
            密&nbsp;&nbsp;码：<input type="password" name="pwd"><br>
            性别：<input type="radio" name="gender" value="男">男
            <input type="radio" name="gender" value="女">女<br>
            爱好：<input type="checkbox" name="hobby" value="Python">Python
            <input type="checkbox" name="hobby" value="Java">Java
            <input type="checkbox" name="hobby" value="C/C++">C/C++
            <input type="checkbox" name="hobby" value="玩">玩<br>
            <input type="submit" value="确认添加">

        </form>
    </div>
</body>
</html>
