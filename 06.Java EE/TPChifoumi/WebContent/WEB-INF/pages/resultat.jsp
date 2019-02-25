<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
		<fmt:message key="msg_resultat"></fmt:message>
	</fmt:bundle></title>
</head>
<body align="center">
	<c:if test="${!empty param.langue }">
		<!-- Définition de la locale à utiliser -->
		<fmt:setLocale value="${param.langue}" />
	</c:if>
	<%@include file="/WEB-INF/pages/Header.jsp"%>

	<%
	    int choixJoueur = (int) request.getAttribute("choixJoueur");
	    int choixServeur = (int) request.getAttribute("choixServeur");
	    int resultat = (int) request.getAttribute("resultat");
	%>
	<h1>
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_rtitle"></fmt:message>
		</fmt:bundle>
	</h1>

	<h4>
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_joueur"></fmt:message>
		</fmt:bundle>
	</h4>
	<%
	    if (choixJoueur == 1) {
	%>
	<img width="75" src="<%=request.getContextPath()%>/img/chi.png" />
	<%
	    } else if (choixJoueur == 2) {
	%>
	<img width="75" src="<%=request.getContextPath()%>/img/fou.png" />
	<%
	    } else if (choixJoueur == 3) {
	%>
	<img width="75" src="<%=request.getContextPath()%>/img/mi.png" />
	<%
	    } else {
	%>
	<p>
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_choix"></fmt:message>
		</fmt:bundle>
	</p>
	<%
	    }
	%>

	<h4>
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_serveur"></fmt:message>
		</fmt:bundle>
	</h4>
	<%
	    if (choixServeur == 1) {
	%>
	<img width="75" src="<%=request.getContextPath()%>/img/chi.png" />
	<%
	    } else if (choixServeur == 2) {
	%>
	<img width="75" src="<%=request.getContextPath()%>/img/fou.png" />
	<%
	    } else if (choixServeur == 3) {
	%>
	<img width="75" src="<%=request.getContextPath()%>/img/mi.png" />
	<%
	    } else {
	%>
	<p>
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_choix"></fmt:message>
		</fmt:bundle>
	</p>
	<%
	    }
	%>



	<h4>
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_rtitle"></fmt:message>
		</fmt:bundle>
	</h4>
	<%
	    if (resultat == 0) {
	%>
	<p>
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_egalité"></fmt:message>
		</fmt:bundle>
	</p>
	<%
	    } else if (resultat == 1) {
	%>

	<p style="color: green">
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_bravo"></fmt:message>
		</fmt:bundle>
	</p>
	<%
	    } else if (resultat == -1) {
	%>
	<p style="color: red">
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_perdu"></fmt:message>
		</fmt:bundle>
	</p>
	<%
	    }
	%>

	<div>
		<a href="<%=request.getContextPath()%>/TPChifoumiServlet">
			<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_rejouer"></fmt:message>
		</fmt:bundle>	
		</a>
	</div>
</body>
</html>