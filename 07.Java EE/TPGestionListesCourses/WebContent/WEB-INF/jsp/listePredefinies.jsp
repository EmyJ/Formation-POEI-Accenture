<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste - Liste des course</title>
</head>
<body>

	<c:if test="${!empty listeCodesErreur }">
		<p style="color: red;">Erreur, la liste n'a pas pu être ajouté :</p>
		<c:forEach var="codeErreur" items="${requestScope.listeCodesErreur}">
			<p>${codeErreur}</p>
		</c:forEach>
	</c:if>
	<%@include file="/WEB-INF/jsp/Header.jsp"%>
	<hr>
	<h2 align="center">Liste prédéfinie</h2>
	<hr>
	<table align="center">
		<c:if test="${!empty listeListe }">
			<c:if test="${listeListe.size()>0}">
				<tbody>
					<c:forEach var="liste" items="${requestScope.listeListe}">
						<tr>
							<td><c:out value="${liste.nom}"></c:out></td>
							<td>
								<form action="<c:url value="/AjoutPanier"></c:url>"
									method="post">
									<button name="panier" type="submit"
										value="${liste.identifiant}">Ajouter au panier</button>
								</form>
							</td>
							<td>
								<form action="<c:url value="/Delete"></c:url>" method="post">
									<button name="deleteListe" type="submit"
										value="${liste.identifiant}"
										onclick="if(window.confirm('Voulez-vous vraiment supprimer ?')){return true;}else{return false;}">Supprimer
										la liste</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
		</c:if>
		<c:if test="${empty listeListe}">
			<p>Il n'y a aucune liste à afficher
			<P>
		</c:if>
	</table>
	<hr>
	<div align="center">
		<a href='<c:url value="AjoutList"></c:url>'><input type="button"
			value="Ajouter une liste" /></a>
	</div>
</body>
</html>