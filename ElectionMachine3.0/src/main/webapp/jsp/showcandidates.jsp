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
<title>Ehdokkaat</title>
 <link rel="stylesheet" type="text/css" href="../css/header.css">
 <link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>

<div class="showcandidates">
<c:forEach var="candidate" items="${sessionScope.allcandidates}">
<!-- comment -->

<h2 style="text-align:center;"><b>${candidate.ehdokas_id}:</b> ${candidate.etunimi} ${candidate.sukunimi} </h2>

<b style="text-align:center;">Puolue: </b><br>

${candidate.puolue} <br>

<b>Kotipaikkakunta:</b><br>

${candidate.kotikunta}<br>

<b>Ikä: </b><br>

${candidate.ika}<br>

<b>Miksi haluat eduskuntaan?</b><br>

${candidate.ehdolle}<br>

<b>Mitä asioita haluat edistää?</b><br>

${candidate.edistaa}<br>

<b>Ammatti:</b><br>

${candidate.ammatti}<br>

<br> <br>
</c:forEach>
<br> <br>
</div>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>