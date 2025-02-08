<%@ page import="com.kpi.jakartaeecource.servlet.dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Member Information</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/member.css">
</head>
<body>

<div class="container">
    <%
        MemberDto member = (MemberDto) request.getAttribute("member");
        if (member == null) {
    %>
    <h2 class="error-message">Member not found</h2>
    <%
    } else {
    %>
    <div class="card">
        <h1><%= member.getFirstName() %> <%= member.getLastName() %></h1>
        <p><strong>Age:</strong> <%= member.getAge() %></p>
        <p><strong>Job Title:</strong> <%= member.getJobTitle() %></p>
        <p><strong>Description:</strong> <%= member.getDescription() %></p>
    </div>
    <%
        }
    %>

    <p>
        <a class="back-button" href="<%= request.getContextPath() %>/home">← Back to Member List</a>
    </p>
</div>

</body>
</html>
