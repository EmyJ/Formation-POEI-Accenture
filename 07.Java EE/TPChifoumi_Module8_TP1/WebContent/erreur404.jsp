<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}" />
<fmt:setBundle basename="fr.eni.javaee.chifoumi.messages.messages"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="err.titre"></fmt:message></title>
</head>
<body>
	<h1><fmt:message key="err.404"></fmt:message></h1>
</body>
</html>