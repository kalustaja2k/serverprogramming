<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.dao.Dao" %> 
 <%@ include file="../header.html" %> 

<!DOCTYPE html>
<html> <!-- Login is not finished yet -->
<head>
<meta charset="utf-8">
<title>Vaalikone</title>
<link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<body>
    <div style="text-align: center">
        <h1>Ylläpito</h1>
        <form action="/login" method="post">
            <label for="email">Käyttäjätunnus:</label>
            <input type="email" name="email" size="30" class="email"/>
            <br><br>
            <label for="password">Salasana:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br>       
            <button class="loginbutton" type="submit">Kirjaudu</button>
        </form>
        <img src="../images/admin.jpg" alt=admin width=250 height=250>
    </div>
   
    
    <footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
</body>
</html>