<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='../addanswers' method='post'>
<input type='text' name='vastaus' value=''>
<input type='text' name='kommentti' value=''>
<input type='submit' name='ok' value='OK'>
</form>
<ol>
<c:forEach var="answers" items="${requestScope.answerslist }">
	<li>${answers} <a href='../deleteanswers?id=${answers.kysymys_id}'>Delete</a> <a href='../readtoupdateanswers?id=${answer.kysymys_id}'>Update</a>
</c:forEach>
</ol>
</body>
</html>