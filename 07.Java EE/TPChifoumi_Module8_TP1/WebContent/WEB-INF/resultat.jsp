<%@page import="fr.eni.javaee.chifoumi.bo.ActionsPossibles"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="/WEB-INF/pageErreurExecutionJSP.jsp"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}" />
<fmt:setBundle basename="fr.eni.javaee.chifoumi.messages.messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="msg.resultat"></fmt:message></title>
</head>
<body>

	<%@ include file="menuLangue.jsp" %>

	<%
		int choixJoueur = (int)request.getAttribute("choixJoueur");
		int choixServeur = (int)request.getAttribute("choixServeur");
		int resultat = (int)request.getAttribute("resultat");
	%>
	<h1><fmt:message key="msg.resultat"></fmt:message></h1>
	
	<h4><fmt:message key="msg.choix.joueur"></fmt:message></h4>
	<%=request.getAttribute("choixJoueur") %>
	<%
		if(choixJoueur==ActionsPossibles.CHI)
		{
	%>
			<img src="<%=request.getContextPath()%>/images/chi.png"/>
	<% 		
		}
		else if(choixJoueur==ActionsPossibles.FOU)
		{
	%>
			<img src="<%=request.getContextPath()%>/images/fou.png"/>
	<% 					
		}
		else if(choixJoueur==ActionsPossibles.MI)
		{
	%>
			<img src="<%=request.getContextPath()%>/images/mi.png"/>
	<% 					
			
		}
		else
		{
			%>
			<fmt:message key="msg.choix.inconnu"></fmt:message>
			<%
		}
	%>
	
	<h4><fmt:message key="msg.choix.serveur"></fmt:message></h4>
	<%=request.getAttribute("choixServeur") %>
	<%
		if(choixServeur==ActionsPossibles.CHI)
		{
	%>
			<img src="<%=request.getContextPath()%>/images/chi.png"/>
	<% 		
		}
		else if(choixServeur==ActionsPossibles.FOU)
		{
	%>
			<img src="<%=request.getContextPath()%>/images/fou.png"/>
	<% 					
		}
		else if(choixServeur==ActionsPossibles.MI)
		{
	%>
			<img src="<%=request.getContextPath()%>/images/mi.png"/>
	<% 					
			
		}
		else
		{
			%>
				<fmt:message key="msg.choix.inconnu"></fmt:message>
			<%
		}
	%>
	<h4><fmt:message key="msg.resultat"></fmt:message></h4>
	<%=request.getAttribute("resultat") %>
	<%
		if(resultat==0)
		{
			%>
			<fmt:message key="msg.egalite"></fmt:message>
			<%
		}
		else if(resultat==1)
		{
			%>
			<fmt:message key="msg.victoire"></fmt:message>
			<%
		}
		else
		{
			%>
			<fmt:message key="msg.defaite"></fmt:message>
			<%
		}
	%>
	<div>
		<a href="<%=request.getContextPath() %>/jouez">
			<fmt:message key="msg.rejouer"></fmt:message>
		</a>
	</div>
</body>
</html>



















