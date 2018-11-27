<!doctype html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	<h1>Empleado</h1>
	<div class="error">${mensaje_error}</div>
	<c:if test="${empleado!=null}">
		<div>Id: ${empleado.id}</div>
		<div>Nombre: ${empleado.nombre}</div>
		<div>Apellido: ${empleado.apellido}</div>
	</c:if>
</body>
</html>