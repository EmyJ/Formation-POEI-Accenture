<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>

<%
	String couleur = "noir";
	if(session.getAttribute("couleurPreferee")!=null){
		couleur = (String)session.getAttribute("couleurPreferee");
	}
	%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/<%=couleur%>.css">
</head>
<body >
	<h1>Accueil</h1>
	<p>Choississez votre couleur</p>
	<form action="<%=request.getContextPath() %>/TraitementServlet" method="post">
		<%
			List<String> couleurs = (List<String>)application.getAttribute("couleurs");
		%>
		<select name="couleurChoisie">
		  <%
				for(String couleurDisponible:couleurs){
			%>
					<option value="<%=couleurDisponible%>" <%=couleurDisponible.equalsIgnoreCase(couleur)?"selected":""%>><%=couleurDisponible%></option>
			<%
				}
			%>
		</select>
		<input type="submit" value="Valider"/>
	</form>
        
        <%
        	Cookie[] cookies = request.getCookies();
        	String compteur = null;
        		if (cookies != null) {
         			for (int i=0;i<cookies.length;i++){
         				if(cookies[i].getName().equals("cookieMot")){
         					compteur = cookies[i].getValue();
         				}
         			}
         		}
        	if(compteur == null) {%>
        		 <p> Vous n'êtes jamais venu</p>
        	<%}else{%>
        		 <p>Vous êtes venu <%= compteur %> fois</p>
        	<%}
        %>
   <a href="<%=response.encodeURL(request.getContextPath()+"/autre.jsp")%>">Une JSP</a>
	</body>
</html>