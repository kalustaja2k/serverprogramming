<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>   
<%@ page import="dao.Dao" %> 
<%@ page import="java.util.ArrayList" %>
<%@ page import="rest.Candidates" %>
<%@ include file="../header.html" %>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ylläpito</title>
<link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>

<h2>Ylläpito</h2>	

<div class="link">
		<a href="/showcandidatesadmin"> 
			<input class="button" type="submit" value="Muokkaa ehdokkaita" />
		</a>
	</div>

<div class="link">
		<a href="/showquestionsadmin"> 
			<input class="button" type="submit" value="Muokkaa kysymyksiä" />
		</a>
	</div>

<div class="link">
		<a href="http://localhost:8080/rest/modifyanswersservice/readanswers"> 
			<input class="button" type="submit" value="Muokkaa vastauksia" />
		</a>
	</div>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>