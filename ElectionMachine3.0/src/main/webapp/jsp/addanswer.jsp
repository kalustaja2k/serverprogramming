<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lisaa vastaus</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jsp.css">

</head>
<body>
<h2>Lisaa vastaus</h2>
<form action='/rest/modifyanswersservice/addanswers' method='post'>
<h3>Ehdokkaan numero</h3><input type='text' name='ehdokasid' value=''>

<h3>Vastaus</h3><input type='text' name='vastaus' value=''>
<h3>Kommentti</h3><input type='text' name='kommentti' value=''>
<br>
<input type='submit' name='ok' value='Muokkaa'>
</form>

<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>
