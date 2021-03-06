<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.html" %>
<%@ page import="rest.Questions"%>
<%@ page import="dao.Dao"%>
<%@ page import="rest.ShowQuestion"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vastaa kysymyksiin</title> 
 <link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
<div style=text-align:center;>
		
		<a href="/addquestion">
			<input class="button" type="submit" value="Lis?? kysymys" />
		</a>
<form method="post" action="showquestion">
<c:forEach var="question" items="${sessionScope.allquestions}">

<h2>${question.kysymys_id}: ${question.kysymys} </h2>

<input type="radio"  name="${question.kysymys}"
value="1"><label for="${question.kysymys}1"> 1. T?ysin eri mielt?</label><br> 

<input type="radio"  name="${question.kysymys}"
value="2"><label for="${question.kysymys}2"> 2. Jokseenkin eri mielt?</label><br> 

<input type="radio"  name="${question.kysymys}"
value="3"><label for="${question.kysymys}3"> 3. En osaa sanoa</label><br> 

<input type="radio"  name="${question.kysymys}"
value="4"><label for="${question.kysymys}4"> 4. Jokseenkin samaa miel?</label><br> 

<input type="radio"  name="${question.kysymys}"
value="5"><label for="${question.kysymys}5"> 5. T?ysin samaa miel?</label><br>

<a href="/editquestion?kysymys_id=${question.kysymys_id }">Muokkaa</a>
<a href="/deletequestion?kysymys_id=${question.kysymys_id }">Poista</a>
<br> <br>
</c:forEach> 
<br> <br>
</form>
</div>
<footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>