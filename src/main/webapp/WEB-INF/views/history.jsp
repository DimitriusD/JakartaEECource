<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Історія валют - ${currencyCode}</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/history.css">
</head>
<body>

<h2>Історія курсу ${currencyCode}</h2>

<c:if test="${not empty historyRates}">
    <div id="chart-container">
        <canvas id="currencyChart"></canvas>
    </div>
</c:if>


<script>
    document.addEventListener("DOMContentLoaded", function () {
        const historyRates = [
            <c:forEach var="rate" items="${historyRates}" varStatus="loop">
            {date: "${rate.exchangeDate}", rate: ${rate.rate}}<c:if test="${!loop.last}">, </c:if>
            </c:forEach>
        ];

        if (historyRates.length === 0) {
            console.warn("Історичні курси не знайдені.");
            return;
        }

        const labels = historyRates.map(rate => rate.date);
        const data = historyRates.map(rate => rate.rate);

        const ctx = document.getElementById('currencyChart').getContext('2d');

        new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Курс ${currencyCode}',
                    borderColor: 'blue',
                    backgroundColor: 'rgba(0, 0, 255, 0.2)',
                    data: data,
                    fill: true
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    x: {
                        title: {
                            display: true,
                            text: 'Дата'
                        },
                        ticks: {
                            maxTicksLimit: 10
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: 'Курс (UAH)'
                        },
                        beginAtZero: false
                    }
                }
            }
        });
    });
</script>

</body>
</html>
