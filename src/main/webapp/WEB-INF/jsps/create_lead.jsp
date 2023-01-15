<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>
<h2>Create New Lead....</h2>
<form action="saveLead"method="post">
<pre>
First Name:<input type="text" name="firstName" placeholder="firstName"/>
 Last Name:<input type="text" name="lastName" placeholder="lastName"/>
     Email:<input type="text" name="email" placeholder="email"/>
    Mobile:<input type="text" name="mobile" placeholder="mobile"/>
<input type="submit" value="save">
</pre>

</form>
${msg }
</body>
</html>