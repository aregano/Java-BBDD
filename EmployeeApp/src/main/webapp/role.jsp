<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Meter Rol</h1>
	<div class="error">${mensaje}</div>
	<form action="" method="POST" id="nuevorolform" novalidate>
	
		<div><input type="text" placeholder="Nombre Rol" name="name" value="${crearrol.name}" id="crearnombre"/></div>
		<div><textarea  type="text" placeholder="Descripcion" name="descripcion" value="${crearrol.descripcion}" id="creardescripcion" ></textarea></div>
	    <button id="enviarBtn">Enviar</button>
	    
	</form>
</body>
</html>