<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo equipo | ServletF1</title>
</head>
<body>
	<h1>Inscripción de un nuevo equipo</h1>
	<form action="newTeam" method="post">
		<span>Nombre:</span> <input type="text" name="name"> 
		<br/>
		<span>Nacionalidad: </span>
			<select name="nationality"><option value=1>Finlandesa</option>
				<option value=2>Británica</option>
				<option value=3>Neerlandesa</option>
		</select> <br /> <input type="submit">
	</form>
</body>
</body>
</html>