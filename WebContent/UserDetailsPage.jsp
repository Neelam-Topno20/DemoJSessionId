<%@page import="java.io.PrintWriter"%>
<%@page import="main.com.tal.demo.beans.UserData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details Page</title>
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
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setHeader ("Expires", "0"); //prevents caching at the proxy server
%>
<%
UserData user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("indexPage.jsp");
}else
	{
	user = (UserData) session.getAttribute("user");
	PrintWriter output = response.getWriter();
	}
%>
	<div align="center">
	<h1>User details</h1>
		<table cellpadding=5 cellspacing=5>
				<tr>
					<td>First Name</td>
					<td>${sessionScope.user.firstName}</td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>${sessionScope.user.lastName}</td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td>${sessionScope.user.emailId}</td>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td>${sessionScope.user.mobile}</td>
				</tr>
				<tr>
					<td>City</td>
					<td>${sessionScope.user.city}</td>
				</tr>
				<tr>
					<td>State</td>
					<td>${sessionScope.user.state}</td>
				</tr>
				<tr>
					<td></td>
					<td>
					<a href="<%=response.encodeURL("UpdateUserDetails.jsp") %>" > Update Profile</a>
					</td>
				</tr>
			</table>
	</div>
			
</body>
</html>