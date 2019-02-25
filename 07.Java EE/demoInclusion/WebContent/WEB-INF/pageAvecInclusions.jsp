<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cette page est composée d'éléments inclus</title>
</head>
<body>
	<!-- 
		La valeur de l'attribut file est un nom de fichier dans le système de fichier. 
		Ce n'est pas une URL.
		Il est à destination du Moteur Jasper 2 pour qu'il puisse le recopier dans le fichier pageAvecInclusion.jsp 
	-->
	<%@include file="entete.html" %>
	
	<%
		int variableUtiliseeDansFragment = 123;
	%>
	<%@include file="fragmentIncluAvecDirectiveInclude.jspf" %>
	
	<!-- 
		La valeur de l'attribut page est une URL.
	-->
	<%
		request.setAttribute("attribut", variableUtiliseeDansFragment);
	%>
	<jsp:include page="/WEB-INF/fragmentIncluAvecBaliseInclude.jsp">
		<jsp:param value="<%=variableUtiliseeDansFragment%>" name="parametre"/>
	</jsp:include>
	
	<div>
		<a href="demonstrations/demonstration1.html">Retour</a>
	</div>
	
	<%@include file="piedDePage.html" %>
</body>
</html>
			