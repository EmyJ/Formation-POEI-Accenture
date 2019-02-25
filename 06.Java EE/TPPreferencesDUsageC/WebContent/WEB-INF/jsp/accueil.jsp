<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	String couleur="noir";
	//recherche en session
	//Si la valeur existe en session, écrasez la valeur couleur par défaut
	if(session.getAttribute("couleurPreferee")!=null)
	{
		couleur=(String)session.getAttribute("couleurPreferee");
	}
%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/<%=couleur%>.css">
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>Accueil</h1>
	
	<p>Choisissez votre couleur<p>
	<form action="<%=request.getContextPath()%>/ServletGestionPreference" method="post">
		<!-- Liste des couleurs disponibles -->
		<%
			List<String> couleurs = (List<String>)application.getAttribute("couleurs");
		%>
		<select name="couleurChoisie">
		
			<%
				for(String couleurDisponible:couleurs)
				{
			%>
					<option value="<%=couleurDisponible%>" <%=couleurDisponible.equalsIgnoreCase(couleur)?"selected":""%>><%=couleurDisponible%></option>
			<%
				}
			%>
		</select>
		<input type="submit" value="Valider"/>
	</form>
	
	<%
		Cookie cookieNbAcCookie = (Cookie)request.getAttribute("cookieNbAcces");
	%>
	<p>
		Depuis que vous utilisez l'application, vous êtes venu <%=cookieNbAcCookie.getValue()%> fois sur cette page.
	</p>
	<a href="<%=response.encodeURL(request.getContextPath()+"/uneJSP.jsp")%>">Une JSP</a>
</body>
</html>












