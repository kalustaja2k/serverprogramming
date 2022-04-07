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
<title>Lisaa ehdokas</title>
</head>
<body>
<h2>Lisaa uusi ehdokas</h2>


<form action='./addcandidate' method='post'>
Etunimi: <input type='text' name='etunimi' value=''><br>
Sukunimi: <input type='text' name='sukunimi' value=''><br>
Puolue: <input type='text' name='puolue' value=''><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value=''><br>
Ika: <input type='text' name='ika' value=''><br>
Miksi haluat ehdolle?: <input type='text' name='miksi_eduskuntaan' value=''><br>
Mita haluat edistaa?: <input type='text' name='mita_asioita_haluat_edistaa' value=''><br>
Ammatti: <input type='text' name='ammatti' value=''><br>
<input type='submit' name='ok' value='Tallenna'>
</form>


<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>