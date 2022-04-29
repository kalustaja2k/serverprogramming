<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Muokkaa vastauksia</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jsp.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/candidateanswer.css">
    
</head>
<body>


<form action='../addanswers' method='post'>
<input type='text' name='vastaus' value=''>
<input type='text' name='kommentti' value=''>
<input type='submit' name='ok' value='OK'>
</form>


<c:forEach var="answers" items="${requestScope.answerslist }"> 
<b>${answers.kommentti}</b> 
<b> on ${answers.vastaus}</b>

<a href='../deleteanswers?id=${answers.kysymys_id}'>Poista</a> 
<a href='../readtoupdateanswers?id=${answer.kysymys_id}'>Muokkaa</a>  
<br> <br>  
</c:forEach>



<h3>Kysymykset:</h3> <br>
<c:forEach var="question" items="${sessionScope.allquestions}">
 <b>${question.kysymys_id }.</b> 
 <b> ${question.kysymys}</b> <br>
</c:forEach>


<h3>Vastaukset:</h3> <br>
<b>1. Täysin eri mieltä </b> <br>
<b>2. Jokseenkin eri mieltä <br>
<b>3. En osaa sanoa </b> <br>
<b>4. Jokseenkin samaa mieltä</b> <br>
<b>5. Täysin samaa mieltä</b> <br>


<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>