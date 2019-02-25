<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="mon_attribut_requete" scope="request" class="fr.eni.skillsContextes.Valeur"></jsp:useBean>
<jsp:useBean id="mon_attribut_session" scope="session" class="fr.eni.skillsContextes.Valeur"></jsp:useBean>
<jsp:useBean id="mon_attribut_application" scope="application" class="fr.eni.skillsContextes.Valeur"></jsp:useBean>
<p>Dans le contexte de requete, mon_attribut = <jsp:getProperty property="valeur" name="mon_attribut_requete"/></p>
<p>Dans le contexte de session, mon_attribut = <jsp:getProperty property="valeur" name="mon_attribut_session"/></p>
<p>Dans le contexte application, mon_attribut = <jsp:getProperty property="valeur" name="mon_attribut_application"/></p>
	<form action="/skillsContextes/enregistrer" method="post">
	
		<label for="valeur">Valeur : </label><input type="text" name="valeur" id="valeur" /><br /><br />
		<button name="action" value="requete">Mettre dans la requete</button>
		<button name="action" value="session">Mettre dans la session</button>
		<button name="action" value="application">Mettre dans le contexte application</button>
	</form>

</body>
</html>