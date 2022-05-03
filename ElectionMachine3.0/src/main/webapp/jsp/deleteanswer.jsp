<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Poista vastaus</title>
</head>
<body>
<p>Haluatko varmasti poistaa vastauksen?</p>

<form action='../deleteanswers' method='post'>
<input type='text' name='id' value='${requestScope.answers.ehdokas_id }'>
<input type='text' name='breed' value='${requestScope.answers.kysymys_id }'>
<input type='text' name='weight' value='${requestScope.answers.vastaus }'>
<input type='submit' name='ok' value='Poista'>
</form>


</body>
</html>