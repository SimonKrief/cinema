<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>Total: ${caddy.selectionPrix }</div>
	<%-- 	<div>Total: ${caddy.selectionFilm }</div> --%>

	<c:forEach items="${films }" var="film">
		<a href="addFilmServlet?id=${film.id}">${film.titre }</a>
		<br>
	</c:forEach>

	<c:forEach items="${FilmQuantite }" var="FilmQuantite">
		<a href="addFilmServlet?id=${FilmQuantite.key}"> ${FilmQuantite.key} quantite : ${FilmQuantite.value }</a>
		<br>
	</c:forEach>


</body>
</html>