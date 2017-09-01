<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Error</h1>
	<p>Failed to login.</p>
	<p>Please check your user name and password and try again.</p>
	<table>
		<form action="j_security_check" method="get">
			<tr>
				<td align="right">username</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td align="right">Password</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</form>
	</table>
</body>
</html>