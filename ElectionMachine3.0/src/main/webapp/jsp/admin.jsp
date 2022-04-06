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
</head>
<body>

<table>
<tr>
	<th>Ehdokas Id</th>
	<th>Etunimi</th>
	<th>Sukunimi</th>
	<th>Puolue</th>
	<th>Kotikunta</th>
	<th>Ik�</th>
	<th>Miksi l�hdit ehdolle eduskuntaan?</th>
	<th>Mit� asioita haluat edist��?</th>
	<th>Ammatti</th>
</tr>

	
		<div class="showcandidates">
		
		<a href="/addcandidate"> <!-- redirect to add candidate here -->
			<input class="button" type="submit" value="Lis�� ehdokas" />
		</a>
<c:forEach var="candidate" items="${sessionScope.allcandidates}">


<h2><b>${candidate.ehdokas_id}:</b> ${candidate.etunimi} ${candidate.sukunimi} </h2>

<b>Puolue: </b><br>

${candidate.puolue} <br>

<b>Kotipaikkakunta:</b><br>

${candidate.kotikunta}<br>

<b>Ik�: </b><br>

${candidate.ika}<br>

<b>Miksi haluat eduskuntaan?</b><br>

${candidate.ehdolle}<br>

<b>Mit� asioita haluat edist��?</b><br>

${candidate.edistaa}<br>

<b>Ammatti:</b><br>

${candidate.ammatti}<br>

<a href="/editcandidates?ehdokas_id=${candidate.ehdokas_id }">Edit</a>
<a href="/deletecandidates?ehdokas_id=${candidate.ehdokas_id }">Delete</a>

<br> <br>




</c:forEach>
</div>
</table>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>