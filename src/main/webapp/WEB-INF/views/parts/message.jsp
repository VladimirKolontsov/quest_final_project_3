<%--<%@ page import="jakarta.servlet.jsp" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    out.println(
            "<div class=\"w3-panel w3-pale-yellow w3-display-container w3-card-4 w3-round\">\n"+
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-pale-yellow w3-border w3-border-pale-yellow w3-hover-border-grey\">×</span>\n" +
                    "   <h5>" + request.getSession().getAttribute("message") + "</h5>\n" +
                    "</div>"
    );
%>
