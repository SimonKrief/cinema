<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>films</title>
</head>
<body>


	<h2>Acheter:</h2>

	<c:forEach items="${films }" var="film">
		<a href="addFilmServlet?id=${film.id}">${film.titre }</a>
		<br>
	</c:forEach>

	<div>Total: ${caddy.selectionPrix }</div>

	<a href="index.jsp">Retour</a>
	<br>
	<a href="CaddyServlet">Afficher le caddy</a>


</body>
</html>