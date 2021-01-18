<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线用户</title>
    <%-- 设置当前的网页的url   --%>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/user/"}>
</head>
<body>
    <h2>当前在线用户：${fn:length(applicationScope.online)}</h2>

    <c:forEach items="${online}" var="users" varStatus="s">
        <p>
            ${users.userId}  ${users.userName}
        </p>
    </c:forEach>
    </body>
</html>
