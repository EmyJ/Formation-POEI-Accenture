<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Condition d'utilisation</title>
</head>
<body>
	<h1>Nouvelle condition d'utilisation</h1>
	<form  method="post" action="${pageContext.request.contextPath}/Filtre">
		<input type="checkbox" id="condition" name="condition" value="true">
  		<label for="condition">J'ai lu les conditions d'utilisation</label>
		<button type="submit" >J'ai lu les conditions d'utilisation</button>
	</form>
</body>
</html>