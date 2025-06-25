<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form action="LoginServlet" method="post">
    Email: <input type="text" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
<p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>
</html>
