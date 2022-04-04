<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.Candidates" %> 


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>

	<form action='./DeleteCandidates' method='post'>
		<input type="hidden" name="id" value="${sessionScope.game.id }">		
		<input type='submit' name='ok' value='Delete'>
	</form>

</body>
</html>