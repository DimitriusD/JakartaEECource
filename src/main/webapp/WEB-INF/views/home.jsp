<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kpi.jakartaeecource.servlet.dto.ShortMemberInfoDto" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Our Brigade</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/home.css">
</head>
<body>

<div class="container">
    <h1>List of Brigade Members</h1>


    <%
        List<ShortMemberInfoDto> members = (List<ShortMemberInfoDto>) request.getAttribute("members");
        if (members != null && !members.isEmpty()) {
    %>
    <ul class="member-list">
        <%
            for (ShortMemberInfoDto member : members) {
        %>
        <li class="member-item">
            <div class="member-info">
                <span class="member-name"><%= member.getFirstName() %><br><%= member.getSecondName() %></span>
            </div>

            <a class="detail-button"
               href="<%= request.getContextPath() %>/member?id=<%= member.getId() %>">
                Read More
            </a>
        </li>
        <%
            }
        %>
    </ul>
    <%
    } else {
    %>
    <p>No members available.</p>
    <%
        }
    %>

    <div class="footer">
        <p>
            Learn more about Jakarta EE:
            <a href="https://jakarta.ee" target="_blank">jakarta.ee</a>
        </p>
        <p>
            <a href="<%= request.getContextPath() %>/static/about.html">About this project</a>
        </p>
    </div>
</div>

</body>
</html>
