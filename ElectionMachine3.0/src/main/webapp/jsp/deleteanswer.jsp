<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="../header.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Poista vastaus</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jsp.css">
</head>
<body>
<p>Haluatko varmasti poistaa vastauksen?</p>

<form action='../deleteanswers' method='post'>
<input type='text' name='id' value='${requestScope.answers.ehdokas_id }'>
<input type='text' name='breed' value='${requestScope.answers.kysymys_id }'>
<input type='text' name='weight' value='${requestScope.answers.vastaus }'>
<input type='submit' name='ok' value='Poista'>
</form>

<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>