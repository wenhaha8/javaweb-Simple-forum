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
    <style>
        body{
            background-image: url("../images/fengmian1.jpg");
            background-size: cover;
            font-family: 微软雅黑,宋体,Gabriola;
            font-size: 1.3em;
        }
        #loginBox{
            position: fixed;
            top: 25%;
            left: 35%;
            background-color: rgba(247, 247, 247, 0.5);
            width: 30%;
            padding: 0 10px 10px 10px;
        }
        .loginBotton{
            width: 80%;
            background-color: rgba(0, 0, 0, 0.1);
            font-size: 0.9em;
            margin: 0 10%;
        }
        .loginBotton:hover{
            background-color: rgba(0, 0, 0, 0.2);
        }
        input[type="text"],input[type="password"]{
            box-sizing: border-box;
            font-size:1.2em;
            height:1.5em;
            border-radius:4px;
            border:1px solid #c8cccf;
            color:#6a6f77;
            -web-kit-appearance:none;
            -moz-appearance: none;
            outline:0;
            padding:0 0.2em;
            text-decoration:none;
        }
        textarea{
            box-sizing: border-box;
            font-size:1.2em;
            border-radius:4px;
            border:1px solid #c8cccf;
            color:#6a6f77;
            outline:0;
            padding:0 0.2em;
            text-decoration:none;
            background-color: transparent;
        }
        input[type="text"]:focus,textarea:focus{
            border:2px solid #55c8ff;
        }

        a{
            text-decoration: none;
            font-size: 1rem;
        }
        a:link,a:visited{
            color: black;
        }
        a:hover,a:active{
            color: white;
        }

    </style>
</head>
<body>
<div id="loginBox">
    <h3 style="text-align: center">分享你此刻的心情吧！</h3>
    <hr style="margin: 0px 10px 10px">
    <form action='addNews.do' method='post' enctype="multipart/form-data">
        主题：<input type="text" name="theme">
        <hr style="margin:5px 20% 5px 20%">
        <div style="float: left">内容：</div>
        <div style="float: left">
            <textarea name="content" maxlength="4000" cols="40" rows="5"></textarea>
        </div>
        <div style="clear: both"></div>
        <hr style="margin:5px 20% 5px 20%">

        内容配图：<input type="file" name="photoUrl">
        <input hidden type="text" name="userId" value=${user.userId}>
        <input hidden type="time">

        <br>
        <input class="loginBotton" type='submit' value='确认发布'>
        <div style="float: right;margin: 0 0 0 10%">
            <a href='newsList'>返回首页</a><br>
        </div>
    </form>
</div>


</body>
</html>