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
    <title>评论列表</title>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
    <link rel="stylesheet" href="../css/style.css">

    <style>
        .id{
            width: 65px;
        }
        .content{
            width: 40%;
        }
    </style>
</head>
<body>
<h1></h1>
<table border="1" cellspacing="0" cellpadding="0">
    <caption><h1>这里是帖子列表</h1></caption>
    <tr>
        <th class="id">discussionId</th>
        <th class="id">newsId</th>
        <th class="id">userId</th>
        <th class="">评论人</th>
        <th class="">被评论人</th>
        <th class="content">内容content</th>
        <th class="">评论时间</th>
        <th class=""></th>
    </tr>
    <c:forEach items="${disList}" var="dis" varStatus="s">
        <tr ${s.count%2==1?"style='background-color: gainsboro'":""}>
            <td class="">${dis.discussionId}</td>
            <td class="">${dis.newsId}</td>
            <td class="">${dis.userId}</td>
            <td class="">${dis.nickname}</td>
            <td class="">${dis.beDisedUserNicename}</td>
            <td class="">${dis.content}</td>
            <td class="">${dis.discussionTime}</td>
            <td class="">
                <a href="deleteDis.do?disId=${dis.discussionId}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
<hr>

<c:choose>
    <c:when test="${page>1}">
        <span><a href="disListManager.get?page=${page-1}">上一页</a></span>
    </c:when>
    <c:otherwise>
        <span>上一页</span>
    </c:otherwise>
</c:choose>

<c:forEach begin="1" end="${pageCount}" step="1" var="count">
        <span class="num" style="border: black 1px solid;width: 120%;margin: 10% 0;text-align: center;">
            <a href="disListManager.get?page=${count}">${count}</a>
        </span>
</c:forEach>

<c:choose>
    <c:when test="${page<pageCount}">
        <span><a href="disListManager.get?page=${page+1}">下一页</a></span>
    </c:when>
    <c:otherwise>
        <span>下一页</span>
    </c:otherwise>
</c:choose>

<span>总页数：${pageCount}</span>
<span>总帖子数：${disCount}</span>

</body>
</html>
