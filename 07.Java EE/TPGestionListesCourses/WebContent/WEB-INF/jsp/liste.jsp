<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.tpGestionListesCourses.message.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation - Liste de course</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/Header.jsp"%>
	<hr>
	<h2 align="center">Nouvelle Liste</h2>
	<hr>
	<div align="center">


		<c:if test="${!empty listeCodesErreur }">
			<p style="color: red;">Erreur, la liste n'a pas pu être affiché :</p>
			<c:forEach var="codeErreur" items="${requestScope.listeCodesErreur}">
				<p>${codeErreur}</p>
			</c:forEach>
		</c:if>

		<form action="<c:url value="/AjoutList"></c:url>" method="post">
			<div class="saisie">
				<label for="liste">Nom : </label> <input type="text" name="liste"
					value='<c:out value="${nom }"></c:out>' />
			</div>
			<br>
			<div class="saisie">
				<label for="article">Article : </label> <input type="text"
					name="article" value='<c:out value="${article }"></c:out>' /> <input
					type="submit" value="Valider" />
			</div>
			<hr>
			<div>
				<a href='<c:url value="/Liste"></c:url>'><input type="button"
					value="Retour" /></a>
			</div>
		</form>
		<table align="center">
			<c:if test="${!empty listeArticle }">
				<c:if test="${listeArticle.size()>0}">
					<tbody>
						<c:forEach var="article" items="${requestScope.listeArticle}">
							<tr>
								<td><c:out value="${article.nom}"></c:out></td>
								<td>
									<form action="<c:url value="/Delete"></c:url>" method="post">
										<button name="deleteArticle" type="submit"
											value="${article.identifiant}"
											onclick="if(window.confirm('Voulez-vous vraiment supprimer ?')){return true;}else{return false;}">Supprimer
											l'article</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</c:if>
			</c:if>
		</table>
	</div>

</body>
</html>