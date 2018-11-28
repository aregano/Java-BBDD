<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Equipos</title>
</head>
<body>
	<h1>Equipos</h1>

	<ul>
		<c:forEach var="unEquipo" items="${equipos}">
			<li>
				<h3>${unEquipo.nombre}</h3>
				 
			</li>
		</c:forEach>
	</ul>

</body>
</html>