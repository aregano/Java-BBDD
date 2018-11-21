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

	<h1>Cuenta</h1>
	<div class="error">${mensaje_error}</div>

	<c:if test="${cuenta!=null}">
		<div>cid: ${cuenta.cid}</div>
		<div>Nombre: ${cuenta.nombre}</div>
		<div>Numero: ${cuenta.numero}</div>
		<div>Saldo: ${cuenta.saldo}</div>
	</c:if>
</body>
</html>