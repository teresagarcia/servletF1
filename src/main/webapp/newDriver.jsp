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
	<form action="/welcome.jsp" method="post">
		<span>Nombre:</span> <input type="text" name="name"> <br /> 
		<span>Apellido:</span>
		<input type="text" name="lastName"> <br /> 
		<span>Equipo:</span><input
			disabled type="text" value="Futuro desplegable">
		<br /> 
		<span>Fecha de nacimiento:</span><input type="date"
			name="birthDate"> <br /> 
		<span>Nacionalidad:</span><input
			type="text" disabled value="Otro futuro desplegable"> 
		<br /> <input type="submit">
	</form>
</body>
</body>
</html>