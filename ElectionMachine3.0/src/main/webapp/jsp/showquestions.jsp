<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.html" %>
<%@ page import="app.Questions"%>
<%@ page import="app.dao.Dao"%>
<%@ page import="app.ShowQuestion"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vastaa kysymyksiin</title> 
</head>
<body>
<div style=margin-left:10px;>
<form method="post" action="showquestion">
<c:forEach var="question" items="${sessionScope.allquestions}">

<h2>${question.kysymys_id}: ${question.kysymys} </h2>

<input type="radio"  name="${question.kysymys}"
value="1"><label for="${question.kysymys}1"> 1. Täysin eri mieltä</label><br> 

<input type="radio"  name="${question.kysymys}"
value="2"><label for="${question.kysymys}2"> 2. Jokseenkin eri mieltä</label><br> 

<input type="radio"  name="${question.kysymys}"
value="3"><label for="${question.kysymys}3"> 3. En osaa sanoa</label><br> 

<input type="radio"  name="${question.kysymys}"
value="4"><label for="${question.kysymys}4"> 4. Jokseenkin samaa mielä</label><br> 

<input type="radio"  name="${question.kysymys}"
value="5"><label for="${question.kysymys}5"> 5. Täysin samaa mielä</label><br>


</c:forEach> 
<br>
<input type="submit" value="Vastaa">
<br> <br>
 <br> <br>
</form>
</div>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>