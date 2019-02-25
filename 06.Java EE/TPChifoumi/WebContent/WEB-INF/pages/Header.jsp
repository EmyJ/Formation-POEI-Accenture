<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
	<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
		<fmt:message key="msg_title"></fmt:message>
	</fmt:bundle>
</title>
<style type="text/css">
.flag {
	width: 32px;
	height: 32px;
	background:url(flags.png) no-repeat;
	display: inline-block;
}
 
.flag.flag-cz {background-position: -32px 0}
.flag.flag-en {background-position: -64px 0}

</style>
</head>
<body>
	<h1 name="titre">
		<fmt:bundle basename="fr.eni.TPChifoumi.langues.messages">
			<fmt:message key="msg_title"></fmt:message>
		</fmt:bundle>
	</h1>
	
	<img src="<%=request.getContextPath()%>/img/blank.gif" class="flag flag-cz" alt="Czech Republic" />
	<span class="flag flag-en"></span>
</body>
</html>