<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de equipos</title>
</head>
<body>
	<form action="teamsList" method="post">
		<input type="submit" value="Ver listado">
	</form>

	<%
		List<Team> teams = (List<Team>) request.getAttribute("listAllTeams");
		out.println(teams);
		pageContext.setAttribute("teams", teams);
	%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Nacionalidad</td>
				<td>Pilotos</td>
				<td>Opciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td><c:out value="${team.name}" /></td>
					<td><c:out value="${team.nationality}" /></td>
					<td><c:out value="Piloto 1, piloto 2, paquete" /></td>
					<td><a href="/edit?id=${team.idTeam}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>