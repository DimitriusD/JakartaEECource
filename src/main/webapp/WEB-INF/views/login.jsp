<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form action="<%= request.getContextPath() %>/login" method="post">
        <input type="hidden" name="action" value="loginUser" />
        <div class="input-group">
            <label>Username</label>
            <input type="text" name="username" required />
        </div>
        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password" required />
        </div>
        <button type="submit" class="btn">Login</button>
    </form>
    <hr/>
    <form action="<%= request.getContextPath() %>/login" method="post">
        <input type="hidden" name="action" value="guest" />
        <button type="submit" class="btn guest-btn">Guest</button>
    </form>
</div>
</body>
</html>
