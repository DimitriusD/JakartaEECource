<%@ page contentType="text/html;charset=UTF-8" %>
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

<c:choose>
    <c:when test="${not empty todayRates}">
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
    </c:when>

    <c:otherwise>
        <div class="no-rates-container">
            <img src="https://cdn-icons-png.flaticon.com/512/2748/2748558.png"
                 alt="No data available" class="no-data-icon" />
            <p class="no-data-message">На жаль, немає доступних курсів валют на сьогодні.</p>
            <a href="<c:url value='/currencies'/>" class="update-button">Оновити курси</a>
        </div>
    </c:otherwise>
</c:choose>


</body>
</html>
