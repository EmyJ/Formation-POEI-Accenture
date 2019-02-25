<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un nouveau repas - suivi des repas</title>
</head>
<body>
	<h1>Ajout</h1>
	<form method="post" action="<%=request.getContextPath() %>/ajoutRepas">
        <input type="date" id="date" name="date">
        <input type="time" id="time" name="time">
        <input type="text" name="aliment" id="aliment">
        <button type="submit" name="add" id="add">Valider</button>
        <button type="submit" name="add" id="stop" value="stop">Annuler</button>
    </form>
</body>
</html>