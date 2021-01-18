<%--
  Created by IntelliJ IDEA.
  User: 25380
  Date: 2021/1/9
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>心灵奇旅ing-系统管理</title>
    <link rel="icon" type="text/x-icon" href="../images/xiaolian.png">
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
</head>
<frameset cols="190,*">
    <frame src="managerFuc.jsp">
    <frameset rows="60,*">
        <frame name="right-top" src="managerInfo.jsp">
        <frame name="right" src="heart.html">
    </frameset>
</frameset>
</html>
