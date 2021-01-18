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
    <title>登陆页面</title>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
<%--    <base href="http://localhost:8080/homework3_war_exploded/user/">--%>
</head>
<body>
<a href="../user/login.jsp"><button>切换至用户登陆</button></a>
<form action='login.do' method='post'>
    用户名：<input type='text' name='mangername' value='mangername'><br>
    密&nbsp码：<input type='password' name='pwd' value='pwd'  style=''><br>
    验证码：<input type='text' name='validCode'><img src='../user/validCode' style='margin:0px 10px;position:absolute;;width: 100px; height: 30px;'><br>
    保存密码：<input type='checkbox' name='savePwd'><br>
    <input type='submit' value='登陆'>&nbsp&nbsp&nbsp
    <input type='reset' value='重新输入'><br>
</form>

</body>
</html>
