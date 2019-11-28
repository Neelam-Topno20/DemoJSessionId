<%@ page import="java.io.PrintWriter" %>
<%@ page import="main.com.tal.demo.beans.UserData" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<style type="text/css">
h1 {
	color: red;
}
body {
	background-color: skyblue;
}
</style>
</head>
<body>

<% 
 UserData user=null;
 user =(UserData) session.getAttribute("user");
   if(user != null){
	response.sendRedirect("LoginSuccess.jsp");
	}
	%>

	<div align="center">
		<h1>Welcome</h1>
		<form name="login" action="login" method="post">
			<table >
				<tr>
					<td>User Name</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr><td></td>
					<td><input type="submit" value="Submit"/>
						<input type="reset" value="Reset"/></td>
				</tr>
				<tr>
				<td></td>
				<td>New User?<a href="RegistrationPage.jsp">Register</a></td>
				</tr>
				
			</table>
		</form>
	</div>
	
</body>
</html>