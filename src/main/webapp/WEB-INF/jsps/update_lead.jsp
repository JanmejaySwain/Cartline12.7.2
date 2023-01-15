<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
      <h2>Update Lead</h2>
      <form action="updateLead" method="post">
      <pre>
      		<input type="hidden" name="id" value="${leads.id }"/>
      		First Name:<input type="text" name="firstName" value="${leads.firstName}" />
      		Last Name :<input type="text" name="lastName" value="${leads.lastName}" />
      		     Email:<input type="text" name="email" value="${leads.email }"/>
      		    Mobile:<input type="text" name="mobile" value="${leads.mobile}" />
      		    <input type="submit" value="update" />
      
      </pre>
      
      </form>
      
</body>
</html>