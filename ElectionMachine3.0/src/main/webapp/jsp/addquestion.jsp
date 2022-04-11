<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.dao.Dao" %> 
 <%@ include file="../header.html" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lisaa kysymys</title>
<link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
<h2>Lisää uusi kysymys</h2>

<form action='/addquestion' method='post' accept-charset="utf-8">
Kysymys: <input type='text' name='kysymys' value=''><br>
<input type='submit' name='ok' value='Tallenna'>
</form>
<a href='./showquestionsadmin' class="loginbutton">Takaisin</a>

<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>