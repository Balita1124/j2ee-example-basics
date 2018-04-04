<%-- 
    Document   : index
    Created on : 4 avr. 2018, 13:36:44
    Author     : rico.fauchard
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>

    </head>
    <body>
        <h1>Liste des Livres</h1>
        <hr>
        <table border="2px solid black" cellspacing="5">
            <tr style="color:black">
                <td>Titre</td>
            </tr>
            <c:forEach items="${books}" var="book" >
                <tr style="color:gray">
                    <td><c:out value="${book.bookTitle}" /></td>
                </tr>
            </c:forEach>
        </table>
        <hr>
    </body>
</html>
