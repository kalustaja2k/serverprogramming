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

<form>
<form action='/addcandidate' method='post'>
Etunimi: <input type='text' name='etunimi' value=''><br>
Sukunimi: <input type='text' name='sukunimi' value=''><br>
Puolue: <input type='text' name='puolue' value=''><br>
Kotikunta: <input type='text' name='kotikunta' value=''><br>
Ika: <input type='text' name='ika' value=''><br>
Miksi haluat ehdolle?: <input type='text' name='ehdolle' value=''><br>
Mita haluat edistaa?: <input type='text' name='edistaa' value=''><br>
Ammatti: <input type='text' name='ammatti' value=''><br>
<input type='submit' name='ok' value='Tallenna'>
</form>
<!-- <label for="etunimi">Etunimi</label> <br>
<input type="text" id="etunimi" name="etunimi"> <br><br>
<label for="sukunimi">Sukunimi</label> <br>
<input type="text" id="sukunimi" name="sukunimi"> <br><br>
<label for="puolue">Puolue</label> <br>
<input type="text" id="puolue" name="puolue"> <br><br>
<label for="kotipaikkakunta">Kotikunta</label> <br>
<input type="text" id="kotipaikkakunta" name="kotipaikkakunta"> <br><br>
<label for="Ika">Ikä</label> <br>
<input type="text" id="ika" name="ika"> <br><br>
<label for="ammatti">Ammatti</label> <br>
<input type="text" id="ammatti" name="ammatti"> <br><br>
<label for="miksi_eduskuntaan">Miksi haluat ehdolle?</label> <br>
<textarea id="ehdolle" name="ehdolle" rows="3" cols="40">
</textarea> <br><br>
<label for="edistaa">Mitä asioita haluat edistää?</label> <br>
<textarea id="edistaa" name="edistaa" rows="3" cols="40">
</textarea> <br><br>
<input type='submit' name='Tallenna' value='Send'>
</form>-->

<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>