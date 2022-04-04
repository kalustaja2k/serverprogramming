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
  <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>

<table class="candidatestable">
<tr>
	<th>Ehdokas Id</th>
	<th>Etunimi</th>
	<th>Sukunimi</th>
	<th>Puolue</th>
	<th>Kotikunta</th>
	<th>Ikä</th>
	<th>Miksi lähdit ehdolle eduskuntaan?</th>
	<th>Mitä asioita haluat edistää?</th>
	<th>Ammatti</th>
</tr>

<c:forEach var="candidate" items="${sessionScope.allcandidates}">


<h2><b>${candidate.ehdokas_id}:</b> ${candidate.etunimi} ${candidate.sukunimi} </h2>

<b>Puolue: </b><br>

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
</table>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>