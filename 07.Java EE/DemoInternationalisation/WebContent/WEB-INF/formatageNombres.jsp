<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formatage des nombres</title>
</head>
<body>
	<h2>Résultat de la division de 125/35</h2>
	<p>
		Avec 2 chiffres exactement après la virgule :
		<fmt:formatNumber
			type="number"
			value="${125/35}"
			maxFractionDigits="4"
			minFractionDigits="3"
		>
		</fmt:formatNumber>
	</p>
	
</body>
</html>