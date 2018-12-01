<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.io.*,java.util.*,es.salesianos.model.*,es.salesianos.service.* "%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar piloto</title>
</head>
<body>
	<%
		NationalityService nationService = new NationalityService();
		List<Nationality> nations = (List<Nationality>) nationService.listAllNations();
		pageContext.setAttribute("nations", nations);
		TeamService teamService = new TeamService();
		List<Team> teams = (List<Team>) teamService.listAllTeams();
		pageContext.setAttribute("nations", nations);
		request.getAttribute("driver");
	%>
	<h1>Actualizar información del piloto</h1>
	<form action="/updateDriver" method="post">
		<span>Nombre:</span> <input type="text" name="name" value="<c:out value="${driver.name}"/>"> <br /> 
		<span>Apellido:</span>
		<input type="text" name="lastName" value="<c:out value="${driver.lastName}"/>"> <br /> 
		<span>Equipo:</span>
			<select name="team">
			<c:forEach var="team1" items="${teams}">
				<option value="${team1.idTeam}" <c:out ${(team1.idTeam == driver.driverId) ? "selected" : ""}/>>${team1.name}</option>
			</c:forEach>
		</select> <br /> 
		<span>Fecha de nacimiento:</span><input type="date"
			 value="<c:out value="${driver.birthDate}"/>"name="birthDate"> <br /> 
			<span>Nacionalidad:
		</span>
			<select name="nationality">
			<c:forEach var="nation" items="${nations}">
				<option value="${nation.idNation}">${nation.name}</option>
			</c:forEach>
		</select> <br /> 
		<input type="submit">
	</form>
</body>
</body>
</html>