<%@page import="fr.eni.javaee.chifoumi.bo.ActionsPossibles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}" />
<fmt:setBundle basename="fr.eni.javaee.chifoumi.messages.messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="msg.titre"></fmt:message></title>
</head>
<body>
	<%@ include file="menuLangue.jsp" %>
	
	<h1><fmt:message key="msg.jouez"></fmt:message></h1>
	<a href="<%=request.getContextPath()%>/jouez?choix=<%=ActionsPossibles.CHI%>">
		<img src="<%=request.getContextPath()%>/images/chi.png"/>
	</a>
	<a href="<%=request.getContextPath()%>/jouez?choix=<%=ActionsPossibles.FOU%>">
		<img src="<%=request.getContextPath()%>/images/fou.png"/>
	</a>
	<a href="<%=request.getContextPath()%>/jouez?choix=<%=ActionsPossibles.MI%>">
		<img src="<%=request.getContextPath()%>/images/mi.png"/>
	</a>
	
	<h1><fmt:message key="msg.jouez"></fmt:message></h1>
	<form action="<%=request.getContextPath()%>/jouez" method="post">
		<ul>
			<li>
				<label for="choix<%=ActionsPossibles.CHI%>"><img src="<%=request.getContextPath()%>/images/chi.png"/></label>
				<input type="radio" id="choix<%=ActionsPossibles.CHI%>" name="choix" value="<%=ActionsPossibles.CHI%>"/>
			</li>
			<li>
				<label for="choix<%=ActionsPossibles.FOU%>"><img src="<%=request.getContextPath()%>/images/fou.png"/></label>
				<input type="radio" id="choix<%=ActionsPossibles.FOU%>" name="choix" value="<%=ActionsPossibles.FOU%>"/>
			</li>
			<li>
				<label for="choix<%=ActionsPossibles.MI%>"><img src="<%=request.getContextPath()%>/images/mi.png"/></label>
				<input type="radio" id="choix<%=ActionsPossibles.MI%>" name="choix" value="<%=ActionsPossibles.MI%>"/>
			</li>
		</ul>
		<input type="submit" value="<fmt:message key="msg.valider"></fmt:message>">
	</form>
</body>
</html>








