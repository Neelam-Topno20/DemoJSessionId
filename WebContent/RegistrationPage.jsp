<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
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
	<div align="center">
		<h1>User Details Form</h1>
		<form name="userDetailsForm" action="UserDetails" method="post">
			<table cellpadding=5 cellspacing=5>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="email" name="emailId"></td>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td><input type="text" name="mobile"></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td>State</td>
					<td><input type="text" name="state"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"/>
						<input type="reset" value="Reset"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>