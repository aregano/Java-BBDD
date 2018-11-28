<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Equipos</h1>
 
 	<div class="error">${mensaje_error}</div>
 <ul>
 	<c:forEach var="unEquipo" items="${equipos}" >  
   			<li>
   				<a href="./usuario?id=${unEquipo.tid}">
   					<div>( ${unEquipo.id} )</div>
   					<div>${unEquipo.nombre}</div>
   				</a>
   			</li> 
		</c:forEach> 
 </ul>

</body>
</html>