<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.Candidates" %> 
<%@ include file="../header.html" %>  
 <%@ page import="app.dao.Dao" %> 
 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa ehdokkaita</title>
</head>
<body>
<h2>Muokkaa ehdokkaiden tietoja</h2>
  
<form action='./editcandidates' method='post'>
		Etunimi: <input type='text' name='etunimi' value='${sessionScope.candidate.etunimi }'><br>
		Sukunimi: <input type='text' name='sukunimi' value='${sessionScope.candidate.sukunimi }'><br>
		Puolue: <input type='text' name='puolue' value='${sessionScope.candidate.puolue }'><br>
		Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value='${sessionScope.candidate.kotikunta }'><br>
		Ikä: <input type='text' name='ika' value='${sessionScope.candidate.ika }'><br>
		Miksi ehdolle: <input type='text' name='miksi_eduskuntaan' value='${sessionScope.candidate.ehdolle}'><br>
		Mitä haluat edistää: <input type='text' name='mita_asioita_haluat_edistaa' value='${sessionScope.candidate.edistaa }'><br>
		Ammatti: <input type='text' name='ammatti' value='${sessionScope.candidate.ammatti }'><br>

		
		<input type="hidden" name="ehdokas_id" value="${sessionScope.candidate.ehdokas_id }">
				
		<input type='submit' name='ok' value='Muokkaa'>
	</form>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>