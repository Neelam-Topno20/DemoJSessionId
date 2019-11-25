<%@page import="com.tal.demo.beans.UserData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successfully Registered</title>
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
	UserData user=(UserData) request.getAttribute("user");
String firstName=user.getFirstName()
;
%>
<h1>Hello <%= firstName %> You have successfully registered!!</h1>
<br>
<a href="indexPage.jsp">Login</a>
</body>
</html>