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
    <title>帖子列表</title>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
    <link rel="stylesheet" href="../css/style.css">
    <style>
        .id{
            width: 65px;
        }
        .content{
            width: 30%;
        }
    </style>
</head>
<body>
<h1></h1>
<table border="1" cellspacing="0" cellpadding="0">
    <caption><h1>这里是帖子列表</h1></caption>
    <tr>
        <th class="id">newsId</th>
        <th class="id">userId</th>
        <th class="">主题theme</th>
        <th class="content">内容content</th>
        <th class="">图片名photoUrl</th>
        <th class="">发帖时间</th>
        <th class="">被赞数</th>
        <th class="">精华帖</th>
        <th class="">置顶帖</th>
        <th class="">删帖</th>
    </tr>
    <c:forEach items="${newsList}" var="news" varStatus="s">
        <tr ${s.count%2==1?"style='background-color: gainsboro'":""}>
            <td class="">${news.newsId}</td>
            <td class="">${news.userId}</td>
            <td class="">${news.theme}</td>
            <td class="">${news.content}</td>
            <td class="">${news.photoUrl}</td>
            <td class="">${news.newsTime}</td>
            <td class="">${news.priseNum}</td>
            <td class="">
                <a ${news.excellent==0?"style='display:none'":"style='display:inline'"} href="excellent.do?newsId=${news.newsId}">设置为精华帖</a>
                <a ${news.excellent==1?"style='display:none'":"style='display:inline'"} href="excellent.do?newsId=${news.newsId}">取消精华设置</a>
            </td>
            <td class="">
                <a ${news.top==0?"style='display:none'":"style='display:inline'"} href="?newsId=${news.newsId}">设置为置顶帖</a>
                <a ${news.top==1?"style='display:none'":"style='display:inline'"} href="?newsId=${news.newsId}">取消置顶设置</a>
            </td>
            <td class="">
                <a href="deleteNews.do?newsId=${news.newsId}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
<hr>

<c:choose>
    <c:when test="${page>1}">
        <span><a href="newsListManager.get?page=${page-1}">上一页</a></span>
    </c:when>
    <c:otherwise>
        <span>上一页</span>
    </c:otherwise>
</c:choose>

<c:forEach begin="1" end="${pageCount}" step="1" var="count">
        <span class="num" style="border: black 1px solid;width: 120%;margin: 10% 0;text-align: center;">
            <a href="newsListManager.get?page=${count}">${count}</a>
        </span>
</c:forEach>

<c:choose>
    <c:when test="${page<pageCount}">
        <span><a href="newsListManager.get?page=${page+1}">下一页</a></span>
    </c:when>
    <c:otherwise>
        <span>下一页</span>
    </c:otherwise>
</c:choose>

<span>总页数：${pageCount}</span>
<span>总帖子数：${newsCount}</span>

</body>
</html>
