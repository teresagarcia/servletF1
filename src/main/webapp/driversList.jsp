<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de pilotos</title>
</head>
<body>
<!-- 	<form action="driversList" method="post">
		<input type="submit" value="Ver listado">
	</form> -->

	<%
		List<Driver> drivers = (List<Driver>) request.getAttribute("listAllDrivers");
		out.println(drivers);
		pageContext.setAttribute("drivers", drivers);
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
				<td>Apellido</td>
				<td>Fecha de nacimiento</td>
				<td>Equipo</td>
				<td>Nacionalidad</td>
				<td>Opciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="driver" items="${drivers}">
				<tr>
					<td><c:out value="${driver.name}" /></td>
					<td><c:out value="${driver.lastName}" /></td>
					<td><c:out value="${driver.birthDate}" /></td>
					<td><c:out value="${driver.team}" /></td>
					<td><c:out value="${driver.nationality}" /></td>
					<td><a href="/edit?id=${driver.name}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>