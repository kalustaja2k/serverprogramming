<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa vastauksia</title>
</head>
<body>
<form action='../updateanswers' method='post'>
<input type='text' name='id' value='${requestScope.answers.ehdokas_id }'>
<input type='text' name='breed' value='${requestScope.answers.kysymys_id }'>
<input type='text' name='weight' value='${requestScope.answers.vastaus }'>
<input type='submit' name='ok' value='OK'>
</form>
</body>
</html>