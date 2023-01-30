<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>${requestScope.question.title}</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-light-blue">
            <p></p>
            <h1>${requestScope.question.fabula}</h1>
        </div>
        <p></p>
        <div class="w3-container w3-left-align">
            <form method="post">
                <div>
                    <h2>${requestScope.question.text}</h2>
                </div>
                <ul>
                    <c:forEach var="answer" items="${requestScope.question.answers}">
                        <c:if test="${answer.id=='0'}">
                            <div>
                                <input class="w3-radio" type="radio" name="answer" value="${answer.id}"
                                       id="answer${answer.id}" checked>
                                <label for="answer${answer.id}">${answer.text}</label>
                            </div>
                        </c:if>
                        <p></p>
                        <c:if test="${answer.id!='0'}">
                            <div>
                                <input class="w3-radio" type="radio" name="answer" value="${answer.id}"
                                       id="answer${answer.id}">
                                <label for="answer${answer.id}">${answer.text}</label>
                            </div>
                        </c:if>
                    </c:forEach>
                </ul>
                <div>    <!-- buttons holder -->
                    <p><input class="w3-btn w3-hover-sand w3-round-large" type="submit" value="Ответить"></p>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>