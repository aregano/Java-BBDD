<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Date de Alta</h1>
	<div class="error">${mensaje_error}</div>
	<form action="" method="POST" id="nuevoclienteform" novalidate>
	
		<div><input type="text" placeholder="Nombre Cuenta" name="name" value="${crearcuenta.name}" id="crearnombre"/></div>
		<div><input type="text" placeholder="Numero" name="numero" value="${crearcuenta.numero}" id="crearnumero"/></div>
		<div><input type="text" placeholder="Saldo" name="saldo" value="${crearcuenta.saldo}" id="crearsaldo"/></div>
	    <button id="enviarBtn">Enviar</button>
	    
	</form>

</body>
</html>