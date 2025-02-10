<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Курси валют</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/currencies.css">
</head>
<body>

<h2>Курси валют</h2>

<%-- Declare todayRates explicitly --%>
<c:set var="todayRates" value="${requestScope.todayRates}" />
<c:if test="${not empty todayRates}">
    <table class="currency-table">
        <tr>
            <th>Валюта</th>
            <th>Купівля</th>
        </tr>
        <c:forEach var="rate" items="${todayRates}">
            <tr>
                <td class="currency-info">
                    <img src="https://raw.githubusercontent.com/Lissy93/currency-flags/master/assets/flags_svg/${rate.currencyCode.toLowerCase()}.svg"
                         class="currency-flag"
                         alt="${rate.currencyCode}"/>
                    <div class="currency-text">
                        <a href="<c:url value='/history?currency=${rate.currencyCode}'/>">
                            <strong><c:out value="${rate.currencyCode}" /></strong>
                        </a>
                        <br/>
                        <span class="currency-name"><c:out value="${rate.currencyName}" /></span>
                    </div>
                </td>
                <td class="currency-rate"><c:out value="${rate.rate}" /></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
