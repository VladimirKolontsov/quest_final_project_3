<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>${requestScope.title}</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <c:if test="${sessionScope.userId==null }">
            <button class="w3-btn w3-hover-purple w3-round-large" onclick="location.href='/addUser'">Регистрация
            </button>
        </c:if>
        <c:if test="${sessionScope.userId!=null }">
            <button class="w3-btn w3-hover-yellow w3-round-large" onclick="location.href='/quest'">Играть
            </button>
            <button class="w3-btn w3-hover-pale-red w3-round-large" onclick="location.href='/statistic'">Статистика
            </button>
        </c:if>
    </div>
</div>
</body>
</html>