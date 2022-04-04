<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.dao.Dao" %> 
 <%@ include file="../header.html" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone</title>
<link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
    <div style="text-align: center">
        <h1>Yll�pito</h1>
        <form action="/login" method="post">
            <label for="email">K�ytt�j�tunnus:</label>
            <input name="email" size="30" />
            <br><br>
            <label for="password">Salasana:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br>       
            <button class="loginbutton" type="submit">Kirjaudu</button>
        </form>
    </div>
    
    <footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>