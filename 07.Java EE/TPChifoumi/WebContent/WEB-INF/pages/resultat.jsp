<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="fr.eni.TPChifoumi.langues.messages"/>
<fmt:setLocale value="${!empty sessionScope.lang?sessionScope.lang:pageContext.request.locale}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<fmt:message key="msg_resultat"></fmt:message>
</title>
</head>
<body align="center">
	<%@include file="/WEB-INF/pages/Header.jsp"%>

	<%
	    int choixJoueur = (int) request.getAttribute("choixJoueur");
	    int choixServeur = (int) request.getAttribute("choixServeur");
	    int resultat = (int) request.getAttribute("resultat");
	%>
	<h1>
		<fmt:message key="msg_rtitle"></fmt:message>
	</h1>

	<h4>
		<fmt:message key="msg_joueur"></fmt:message>
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
		<fmt:message key="msg_choix"></fmt:message>
	</p>
	<%
	    }
	%>

	<h4>
		<fmt:message key="msg_serveur"></fmt:message>
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
		<fmt:message key="msg_choix"></fmt:message>
	</p>
	<%
	    }
	%>



	<h4>
		<fmt:message key="msg_rtitle"></fmt:message>
	</h4>
	<%
	    if (resultat == 0) {
	%>
	<p>
		<fmt:message key="msg_egalité"></fmt:message>
	</p>
	<%
	    } else if (resultat == 1) {
	%>

	<p style="color: green">
		<fmt:message key="msg_bravo"></fmt:message>
	</p>
	<%
	    } else if (resultat == -1) {
	%>
	<p style="color: red">
		<fmt:message key="msg_perdu"></fmt:message>
	</p>
	<%
	    }
	%>

	<div>
		<a href="<%=request.getContextPath()%>/TPChifoumiServlet"> 
			<fmt:message key="msg_rejouer"></fmt:message>
		</a>
	</div>
</body>
</html>