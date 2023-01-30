<%@ page import="ru.javarush.quest.kolontsov.util.Jsp" %>
<%@ page import="java.net.http.HttpRequest" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<html lang="ru">
<head>
    <title>${requestScope.title}</title>
</head>
<body>
<div class="w3-container w3-padding">
    <div>
        <c:if test="${requestScope.login!=null}">
            <%
                String login = (String) request.getAttribute("login");
                request.getSession().setAttribute("message", login + " добавлен!");
            %>
            <%@include file="parts/message.jsp" %>
        </c:if>
    </div>
    <c:set var="login" scope="request" value="${requestScope.login}"/>
    <c:if test="${login==null}">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Добавить пользователя</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Логин:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Пароль:
                <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Добавить</button>
        </form>
    </div>
</div>
</c:if>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='../..'">На главную</button>
</div>
</body>
</html>
