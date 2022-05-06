<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa vastauksia</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jsp.css">

</head>
<body>
<h2>Muokkaa vastausta</h2>
<form action='../updateanswers' method='post' accept= "application/json">
<h3>Ehdokkaan numero</h3><input type='text' name='ehdokasid' value='${requestScope.answers.ehdokas_id }'>
<h3>Kysymyksen numero</h3><input type='text' name='kysymysid' value='${requestScope.answers.kysymys_id }'>
<h3>Vastaus</h3><input type='text' name='vastaus' value='${requestScope.answers.vastaus }'>
<br>
<input type='submit' name='ok' value='Muokkaa'>
</form>

<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>
