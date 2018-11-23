<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Date de Alta</h1>
	<div class="error">${mensaje_error}</div>
	<form action="" method="POST" id="nuevoclienteform" novalidate>
		<input type="hidden" value="${editarcuenta.cid}"/>
		
		<div><input type="text" placeholder="Nombre Cuenta" name="nombre" value="${editarcuenta.nombre}" id="crearnombre"/></div>
		<div><input type="text" placeholder="Numero" name="numero" value="${editarcuenta.numero}" id="crearnumero"/></div>
		<div><input type="text" placeholder="Saldo" name="saldo" value="${editarcuenta.saldo}" id="crearsaldo"/></div>
	    <button id="editarBtn">Enviar</button>
	    
	</form>

</body>
</html>