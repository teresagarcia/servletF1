<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*, es.salesianos.service.NationalityService"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo equipo | ServletF1</title>
</head>
<body>
	<form action="newTeam" method="post">
		<input type="submit" value="Ver listado">
	</form>
	<%
		NationalityService nationService = new NationalityService();
		List<Nationality> nations = (List<Nationality>) nationService.listAllNations();
		pageContext.setAttribute("nations", nations);
	%>
	<h1>Inscripción de un nuevo equipo</h1>
	<form action="newTeam" method="post">
		<span>Nombre:</span> <input type="text" name="name"> <br /> <span>Nacionalidad:
		</span> <select name="nationality">
			<c:forEach var="nation" items="${nations}">
				<option value="${nation.idNation}">${nation.name}</option>
			</c:forEach>
		</select> <br /> <input type="submit">
	</form>
</body>
</body>
</html>