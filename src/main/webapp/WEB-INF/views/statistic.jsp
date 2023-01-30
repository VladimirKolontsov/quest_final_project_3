<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="parts/header.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>${requestScope.title}</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Статистика</h2>
        </div>
        <%
            List<String> statistics = (List<String>) request.getAttribute("statistics");
            if (statistics != null && !statistics.isEmpty()) {
                out.println("<ul class=\"w3-ul\">");
                for (String s : statistics) {
                    out.println("<li class=\"w3-hover-sand\">" + s + "</li>");
                }
                out.println("</ul>");
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Статистика пока не собрана!</h5>\n" +
                    "</div>");
        %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='../..'">Вернуться на главный экран</button>
</div>
</body>
</html>