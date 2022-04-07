<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.Questions" %> 
<%@ include file="../header.html" %>  
 <%@ page import="app.dao.Dao" %> 
 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa kysymyksia</title>
 <link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
<h2>Muokkaa kysymyksia</h2>
  
<form action='/editquestion' method='post'>
		Kysymys: <input type='text' name='kysymys' value='${sessionScope.question.kysymys }'><br>

		
		<input type="hidden" name="id" value="${sessionScope.question.kysymys_id }">
				
		<input type='submit' name='ok' value='Muokkaa'>
	</form>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>