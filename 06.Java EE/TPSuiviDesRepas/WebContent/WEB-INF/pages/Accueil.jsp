<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil - Suivi des repas</title>
</head>
<body>

	<h1>ACCUEIL</h1>
	
	<div class="contenu">
		<a href="<%=request.getContextPath()%>/ajoutRepas"><input type="button" value="Ajouter un nouveau repas"/></a>
	</div>
	<div class="contenu">
		<a href="<%=request.getContextPath()%>/historiqueRepas"><input type="button" value="Visualiser les repas"/></a>
	</div>
	
</body>
</html>