<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="parts/header.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Поражение</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-cyan">
            <br>
            <h2>${requestScope.question.loosMessage}</h2>
        </div>
        <div class="w3-container w3-center w3-blue-grey">
            <br>
            <h1>Поражение</h1>
        </div>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='../..'">Вернуться на главный экран</button>
        </div>
    </div>
</div>
</body>
</html>