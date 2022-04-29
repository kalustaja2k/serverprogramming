<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Muokkaa vastauksia</title>
</head>
<body>

<form action='../addanswers' method='post'>
<input type='text' name='vastaus' value=''>
<input type='text' name='kommentti' value=''>
<input type='submit' name='ok' value='OK'>
</form>

<ul>
<c:forEach var="answers" items="${requestScope.answerslist }">
<li> 
 <b>${answers.kommentti}</b>
 <b> on ${answers.vastaus}</b>
  <a href='../deleteanswers?id=${answers.kysymys_id}'>Poista</a> <a href='../readtoupdateanswers?id=${answer.kysymys_id}'>Muokkaa</a>
</li>
</c:forEach>
</ul>

<ol>
<c:forEach var="question" items="${sessionScope.allquestions}"><p>Kysymys<p>
<b>${question.kysymys}</b>
</c:forEach>
</ol>


<table>
<tr> <td> 1. Täysin eri mieltä </td></tr>
<tr> <td> 2. Jokseenkin eri mieltä </td></tr>
<tr> <td> 3. En osaa sanoa </td></tr>
<tr> <td> 4. Jokseenkin samaa mieltä </td></tr>
<tr> <td> 5. Täysin samaa mieltä </td></tr>
</table>

<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>