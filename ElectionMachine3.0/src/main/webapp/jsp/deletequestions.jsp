<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.Questions" %> 
<%@ include file="../header.html" %>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Question</title>
 <link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
<h2>Haluatko varmasti poistaa kysymyksen?</h2>

	<form action='./deletequestion' method='post'>
		<input type="hidden" name="kysymys_id" value="${sessionScope.question.kysymys_id }">		
		<input type='submit' name='ok' value='Poista'>
	</form>
	<a href='/showquestionsadmin' class="loginbutton">Takaisin</a>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>