<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 25380
  Date: 2020/12/28
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>心灵奇旅ing</title>
    <link rel="icon" type="text/x-icon" href="../images/xiaolian.png">
    <link rel="stylesheet" href="../css/forum.css">
    <style>
        .beTop{
            float: right;
        }
        .beExcellent{
            float: right;
        }
        .clickOD{
            font-size: 0.6em;
        }
        .clickOD:hover{
            color: blue;
        }
    </style>
</head>
<body>
<%--导航栏 网页头部--%>
<div id="header">
    <div>
        <img align="left" src=${"../photo/"+=user.headSculpture} title=${"../photo/"+=user.headSculpture} width="45px" height="45px">
    </div>
    <div>
        <a href="addNews.jsp" style="color: white">快来分享新鲜事吧！</a>
        <a href="logout" style="color: red">注销</a>
    </div>
</div>

<%--帖子列表--%>
<div id="display_filed">
    <c:forEach items="${newsList}" var="news" varStatus="u">
        <c:forEach items="${userList}" var="users" varStatus="n">
            <c:if test="${news.userId==users.userId}">
                <%--                一个帖子--%>
                <div ${u.count==1?"style='margin-top: 90px'":""} class="aNews">
                        <%--                    用户信息div--%>
                    <div>
                        <img src=${"../photo/"+=users.headSculpture} align="left" width="45px" height="45px">
                        <div style="width: 50%;float: left">
                            <span>${users.userName}</span>
                            <br>
                            <span>${news.newsTime}</span>
                        </div>
                        <c:if test='${news.top==1}'>
                            <div class="beTop">
                                置顶帖&nbsp;
                            </div>
                        </c:if>
                        <c:if test='${news.excellent==1}'>
                            <div class="beExcellent">
                                精华帖&nbsp;
                            </div>
                        </c:if>
                    </div>
                    <div style="clear: both"></div>
                    <hr style="margin: 10px 0 20px 0">
                        <%--                    帖子主题div--%>
                    <div>
                        <span class="aNewsContent">${news.theme}
                            <span class="clickOD" id=${news.newsId}${"clickOpen"} onclick="document.getElementById('${news.newsId}${'contentAndPic'}').style.display='block';document.getElementById('${news.newsId}${'clickOpen'}').style.display='none';document.getElementById('${news.newsId}${'clickDown'}').style.display='inline';">
                                点击展开
                            </span>
                            <span class="clickOD" style="display: none" id=${news.newsId}${"clickDown"} onclick="document.getElementById('${news.newsId}${'contentAndPic'}').style.display='none';document.getElementById('${news.newsId}${'clickOpen'}').style.display='inline';document.getElementById('${news.newsId}${'clickDown'}').style.display='none';">
                            点击收起
                            </span>
                        </span>
                    </div>

                        <%--                    帖子图片和内容div--%>
<%--                    利用帖子id的唯一性，动态设置这个div 的id--%>
                    <div id=${news.newsId}${"contentAndPic"} style="display:none">
                        <hr style="margin: 0 0 0 0">
                        <p class="aNewsContent">${news.content}</p>
                        <img style="max-width: 520px;max-height: 400px" src=${"../photo/"+=news.photoUrl}>
                    </div>

                        <%--                    帖子被赞数量和评论div--%>
                    <div style="width: 100%">
                        <hr style="margin: 10px 0 0 0">
                        <span style="margin-right: 10%;text-align: center">
                            <img src=${news.priseNum>0?"../images/zan.svg":"../images/zan_1.svg"} width="32px" align="left">
                            <span>${news.priseNum}</span>
                        </span>
                        <span style="margin-right: 10%;text-align: center">
                            <img src="../images/comment.svg" width="32px">
                        </span>
                    </div>

                    <hr style="margin: 0px 0 10px 0">
                        <%--                    用户参与评论div--%>
                    <div>
                        <form action="addDiscussion.do" method="get">
                            评论：<input required name="content" type="text" maxlength="255" name="discussionContent">
                            <input name="userId" hidden value=${user.userId}>
                            <input name="nickname" hidden value=${user.nickname}>
                            <input name="newsId" hidden value=${news.newsId}>
                            <input name="beDisedUserNicename" hidden value="">
                            <input type="submit" value="评论">
                        </form>
                    </div>
                        <%--                    帖子的所有评论--%>
                    <c:forEach items="${discussionList}" var="dis" varStatus="d">
                        <c:if test="${news.newsId==dis.newsId}">
                            <div>
<%--                                显示用户的名字和被评论人的名字（如果有的话）和评论内容--%>
                                <span>${dis.beDisedUserNicename==""||dis.beDisedUserNicename==null?dis.nickname+="："+=dis.content:dis.nickname+=" 回复 "+=dis.beDisedUserNicename+="："+=dis.content}
                                    <c:if test='${dis.userId!=user.userId}'>
                                        &nbsp;&nbsp;&nbsp;
                                        <span id=${"replyKey"}${dis.discussionId} style="color:blue" onclick="document.getElementById('${"reply"}${dis.discussionId}').style.display='block';document.getElementById('${"retractKey"}${dis.discussionId}').style.display='inline';document.getElementById('${"replyKey"}${dis.discussionId}').style.display='none'">回复</span>
                                        <span id=${"retractKey"}${dis.discussionId} style="color:blue;display:none;" onclick="document.getElementById('${"reply"}${dis.discussionId}').style.display='none';document.getElementById('${"replyKey"}${dis.discussionId}').style.display='inline';document.getElementById('${"retractKey"}${dis.discussionId}').style.display='none'">收起</span>
                                    </c:if>
                                </span>
                            </div>
                            <%--                    用户回复评论div--%>
                            <c:if test='${dis.userId!=user.userId}'>
                                <div id=${"reply"}${dis.discussionId} style="display:none">
                                    <form action="addDiscussion.do" method="get">
                                        回复内容：<input required name="content" type="text" maxlength="255" name="discussionContent">
                                        <input name="userId" hidden value=${user.userId}>
                                        <input name="nickname" hidden value=${user.nickname}>
                                        <input name="newsId" hidden value=${news.newsId}>
                                        <input name="beDisedUserNicename" hidden value=${dis.nickname}>
                                        <input type="submit" value="回复">
                                    </form>
                                </div>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </div>

            </c:if>

        </c:forEach>
    </c:forEach>
</div>

</body>
</html>
