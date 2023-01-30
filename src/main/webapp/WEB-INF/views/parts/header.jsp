<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta charset="UTF-8">
    <title>Квест</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <c:if test="${sessionScope.userId !=null }">
        <div class="w3-left-align">
            <h6>Игрок: ${sessionScope.login}</h6>
        </div>
    </c:if>
    <h1>Квест</h1>
</div>

<br>
</body>
</html>