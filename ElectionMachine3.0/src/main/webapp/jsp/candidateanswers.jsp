<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<table>
<tr> <p> 1. Täysin eri mieltä</tr>
<tr> <p> 2. Jokseenkin eri mieltä</tr>
<tr> <p> 3. En osaa sanoa</tr>
<tr> <p> 4. Jokseenkin samaa mieltä</tr>
<tr> <p> 5. Täysin samaa mieltä</tr>

</table>
</body>
</html>