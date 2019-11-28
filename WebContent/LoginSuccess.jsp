<%@page import="main.com.tal.demo.beans.UserData"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
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
//allow access only if session exists
UserData user = (UserData)session.getAttribute("user");
String userName = null;
String sessionID = null;
if(user == null){
	response.sendRedirect("indexPage.jsp");
}else 
{
	userName=user.getFirstName();
	sessionID = session.getId();
}
%>
<h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>

<!-- need to encode all the URLs where we want session information to be passed -->
<a href="<%=response.encodeURL("UserDetailsPage.jsp") %>">User Details Page</a>
<form action="<%=response.encodeURL("LogoutServlet") %>" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>