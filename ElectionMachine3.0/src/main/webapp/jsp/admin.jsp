<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>   
<%@ page import="app.dao.Dao" %> 
<%@ page import="java.util.ArrayList" %>
<%@ page import="app.Candidates" %>
<%@ include file="../header.html" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yll�pito</title>
<link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>

<h2>Yll�pito</h2>	

<div class="link">
		<a href="showcandidatesadmin.jsp"> 
			<input class="button" type="submit" value="Muokkaa ehdokkaita" />
		</a>
	</div>

<div class="link">
		<a href="showquestionsadmin.jsp"> 
			<input class="button" type="submit" value="Muokkaa kysymyksi�" />
		</a>
	</div>

<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>