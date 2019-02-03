<%@page import="es.salesianos.service.TeamService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.io.*,java.util.*,es.salesianos.model.*,es.salesianos.service.NationalityService "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo piloto</title>
</head>
<body>
	<h1>Inscripción de un nuevo piloto</h1>
	<form action="/addDriver" method="post">
		<span>Nombre:</span> <input type="text" name="name"> <br /> 
		<span>Apellido:</span>
		<input type="text" name="lastName"> <br /> 
		<span>Equipo:</span>
		<select name="team"><c:forEach var="team" items="${teams}">
				<option value="${team.idTeam}">${team.name}</option>
			</c:forEach>
		</select> <br /> 
		<span>Fecha de nacimiento:</span><input type="date"
			name="birthDate"> <br /> <span>Nacionalidad: </span> 
			<select
			name="nationality">
			<c:forEach var="nation" items="${nations}">
				<option value="${nation.idNation}">${nation.name}</option>
			</c:forEach>
		</select> <br /> <input type="submit">
	</form>
</body>
</body>
</html>