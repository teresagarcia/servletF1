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
	<h1>Actualizar información del piloto</h1>
	<form action="/goToUpdateDriver" method="post">
		<input type="hidden" name="id" value="<c:out value="${driver.id}"/>"/>
		<span>Nombre:</span> <input type="text" name="name" value="<c:out value="${driver.name}"/>"> <br /> 
		<span>Apellido:</span>
		<input type="text" name="lastName" value="<c:out value="${driver.lastName}"/>"> <br /> 
		<span>Equipo:</span>
			<select name="team">
			<c:forEach var="team1" items="${teams}">
				<option value="${team1.idTeam}" <c:if test="${team1.idTeam} == ${driver.team}"><% out.println("selected"); %></c:if> >${team1.name}</option>
			</c:forEach>
		</select> <br /> 
		<span>Fecha de nacimiento:</span><input type="date"
			 value="<c:out value="${driver.birthDate}"/>"name="birthDate"> <br /> 
			<span>Nacionalidad:
		</span>
			<select name="nationality">
			<c:forEach var="nation" items="${nations}">
				<option value="${nation.idNation}" <c:if test="${nation.idNation} == ${driver.nationality}"><% out.println("selected"); %></c:if>>${nation.name}</option>
			</c:forEach>
		</select> <br /> 
		<input type="submit">
	</form>
</body>
</body>
</html>