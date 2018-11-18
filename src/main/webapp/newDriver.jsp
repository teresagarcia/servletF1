<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo piloto</title>
</head>
<body>
	<h1>Inscripción de un nuevo piloto</h1>
	<form action="newDriver" method="post">
		<span>Nombre:</span> <input type="text" name="name"> <br /> <span>Apellido:</span>
		<input type="text" name="lastName"> <br /> <span>Equipo:</span>
		<select><option value=1>Ferrari</option>
			<option value=2>Mercedes</option>
			<option value=3>Red Bull</option>
		</select> <br /> <span>Fecha de nacimiento:</span><input type="date"
			name="birthDate"> <br /> <span>Nacionalidad: 
			<select><option value=1>Finlandesa</option>
				<option value=2>Británica</option>
				<option value=3>Neerlandesa</option>
		</select> <br /> <input type="submit">
	</form>
</body>
</body>
</html>