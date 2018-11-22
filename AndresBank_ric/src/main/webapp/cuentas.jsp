<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Login</title>
<link rel="stylesheet" href="./css/styles.css" />
</head>
<body>
	<h1>Tus cuentas</h1>
	
	<ul>
	<c:forEach var="unaCuenta" items="${lista_cuentas}">
		<li>${unaCuenta.cid} |${unaCuenta.nombre}| ${unaCuenta.numero} | ${unaCuenta.saldo} </li>
	</c:forEach>
	</ul>
	
</body>

	<div><a href="./crearcuenta">Crear Cuenta</a></div>

</html>