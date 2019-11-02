<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Caddy</title>
</head>
<body>



	<h2>Selection</h2>

	<div class="row">
		<div class="col-sm-6">Article</div>
		<div class="col-sm-2">Prix</div>
		<div class="col-sm-2">Quantité</div>
		<div class="col-sm-2"></div>
	</div>
	<c:forEach items="${requestScope.FilmQuantite }" var="var">
		<div class="row">
			<div class="col-sm-6">${var.key.titre}</div>
			<div class="col-sm-2">${var.key.prixHT}</div>
			<div class="col-sm-2">${var.value }</div>
			<div class="col-sm-2">
				<form action="removeFilmServlet?id=${var.key.id}">
				<input style="visibility: hidden" id="id" value="${var.key.id}">
					<input type="submit" value="Supprimer">
				</form>


				<a href="removeFilmServlet?id=${var.key.id}">Supprimer</a>
			</div>
		</div>
	</c:forEach>

	<div>Total : ${sessionScope.selectionPrix }</div>
	<div>Total: ${requestScope.selectionPrix }</div>
	<div>Total: ${caddy.selectionPrix }</div>
	<div>Total: ${sessionScope.caddy.selectionPrix }</div>
	<div>Total: ${requestScope.caddy.selectionPrix }</div>
	<div>
		<a href="FilmServlet">Afficher les films</a>
	</div>

</body>
</html>