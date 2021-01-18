<%--
  Created by IntelliJ IDEA.
  User: 25380
  Date: 2020/11/16
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h1></h1>
    <table border="1" cellspacing="0" cellpadding="0">
        <caption><h1>这里是用户列表userList.jsp</h1></caption>
        <tr>
            <th class="id">userId</th>
            <th class="name">昵称nickname</th>
            <th class="name">账号userName</th>
            <th class="pwd">密码pwd</th>
            <th class="">注册时间reg_time</th>
            <th class="del">删除用户</th>
        </tr>
        <c:forEach items="${userList}" var="users" varStatus="s">
            <tr ${s.count%2==1?"style='background-color: gainsboro'":""}>
                <td class="id">${users.userId}</td>
                <td class="name">${users.nickname}</td>
                <td class="name">${users.userName}</td>
                <td class="pwd">${users.pwd}</td>
                <td class="">${users.reg_time}</td>
                <td class="del"><a href="del.do?id=${users.userId}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <hr>

    <c:choose>
        <c:when test="${page>1}">
            <span><a href="userListServlet?page=${page-1}">上一页</a></span>
        </c:when>
        <c:otherwise>
            <span>上一页</span>
        </c:otherwise>
    </c:choose>

    <c:forEach begin="1" end="${pageCount}" step="1" var="count">
        <span class="num" style="border: black 1px solid;width: 120%;margin: 10% 0;text-align: center;">
            <a href="userListServlet?page=${count}">${count}</a>
        </span>
    </c:forEach>

    <c:choose>
        <c:when test="${page<pageCount}">
            <span><a href="userListServlet?page=${page+1}">下一页</a></span>
        </c:when>
        <c:otherwise>
            <span>下一页</span>
        </c:otherwise>
    </c:choose>

    <span>总页数：${pageCount}</span>
    <span>总用户数：${userCount}</span>
</body>
</html>
