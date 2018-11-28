<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Crear Rol</title>
</head>
<body>

	<h1>Crear un rol</h1>
	<div>${mensaje}</div>
	<div class="error">${error}</div>
	<form action="" method="POST">
		<input type="hidden" name="id" value="${newRol.id}" />
		<div>
			<label for="nombre">Nombre: </label> 
			<input type="text" name="nombre"
				id="desc" value="${newRol.nombre}" />
		</div>
		<div>
			<label for="desc">Descripcion: </label>
			<textarea name="desc" id="desc">${newRol.descripcion}</textarea>
		</div>
		<div>
			<button>Guardar</button>
		</div>
	</form>

</body>
</html>