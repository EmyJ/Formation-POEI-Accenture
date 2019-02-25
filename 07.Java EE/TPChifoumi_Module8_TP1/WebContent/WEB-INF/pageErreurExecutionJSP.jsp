<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}" />
<fmt:setBundle basename="fr.eni.javaee.chifoumi.messages.messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="err.titre"></fmt:message></title>
</head>
<body>
	<%@ include file="menuLangue.jsp" %>

	<h1><fmt:message key="err.general"></fmt:message></h1>
	<p>
		<%=exception.getMessage() %>
	</p>
</body>
</html>