<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

<h2>Muokkaa ehdokkaiden vastauksia</h2>

<section class="vastaukset">
<c:forEach var="answers" items="${requestScope.answerslist }"> 
<b>${answers.kommentti}</b> 
<b> on ${answers.vastaus}</b>

<a href='http://localhost:8080/rest/modifyanswersservice/deleteanswers/${answers.kysymys_id}' onclick="return window.confirm('Haluatko varmasti poistaa vastauksen?');">Poista</a> 
<a href='http://localhost:8080/rest/modifyanswersservice/readtoupdateanswers/${answers.kysymys_id}'>Muokkaa</a>  
<br> <br>  
</c:forEach>
</section>


<section class="kysymykset">
<h3>Kysymykset:</h3> <br>
<c:forEach var="question" items="${sessionScope.allquestions}">
 <b>${question.kysymys_id}
  ${question.kysymys}</b> <br>
</c:forEach>

</section>

<section class="mielipide">
<h3>Vastaukset:</h3> <br>
<b>1. Täysin eri mieltä </b> <br>
<b>2. Jokseenkin eri mieltä </b><br>
<b>3. En osaa sanoa </b> <br>
<b>4. Jokseenkin samaa mieltä</b> <br>
<b>5. Täysin samaa mieltä</b> <br>
</section>


<br>
<br>
<br>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>