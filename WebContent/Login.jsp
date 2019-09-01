<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form action="LoginServlet" method="post">
User ID:
<input type="text" name="user id" required><br>
Password:
<input type="password" name="password" required><br>
<input type="submit" value="Login">
<a href="Register.jsp">New User</a>
</form>
</body>
</html>