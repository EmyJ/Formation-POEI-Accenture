<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier - Liste de course</title>
</head>
<body>
	<c:if test="${!empty listeCodesErreur }">
		<p style="color: red;">Erreur, les article n'a pas pu être affiché
			:</p>
		<c:forEach var="codeErreur" items="${requestScope.listeCodesErreur}">
			<p>${codeErreur}</p>
		</c:forEach>
	</c:if>
	<%@include file="/WEB-INF/jsp/Header.jsp" %>
	<hr>
	<h2 align="center">Votre Panier</h2>
	<hr>
	
	<form action="<c:url value="/AjoutPanier"></c:url>" >
	<div align="center">
		<c:if test="${!empty listeListe }">
			<c:if test="${ listeListe.size()>0 }">
					<c:forEach var="liste" items="${requestScope.listeListe}">
							<input type="checkbox" name="value" value="<c:out value="${liste.articles}"></c:out>"><c:out value="${liste.articles}"></c:out>
							<br/>
					</c:forEach>
			</c:if>
		</c:if>
		<c:if test="${empty listeListe }">
			<p>
				Il n'y a aucun article à afficher<P>
				
		</c:if>
		</div>
		<hr>
		<div align="left">
			<a href='<c:url value="/Liste"></c:url>'><input type="button"
				value="Retour" /></a>
		</div>
		<div align="right">
		<input type="reset" value="Réinitialiser le panier">
		</div>
	</form>
	
	</body>
</html>