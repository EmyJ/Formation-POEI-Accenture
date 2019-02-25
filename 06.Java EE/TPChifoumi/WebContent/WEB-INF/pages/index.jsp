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
</head>
<body align="center">
	<%@include file="/WEB-INF/pages/Header.jsp" %>
	
	<a href="<%=request.getContextPath() %>/TPChifoumiServlet?choix=1">
		<img src="<%=request.getContextPath() %>/img/chi.png" />
	</a>
	<a href="<%=request.getContextPath() %>/TPChifoumiServlet?choix=2">
		<img src="<%=request.getContextPath() %>/img/fou.png" />
	</a>
	<a href="<%=request.getContextPath() %>/TPChifoumiServlet?choix=3">
		<img src="<%=request.getContextPath() %>/img/mi.png" />
	</a>
	
	<%@include file="/WEB-INF/pages/Header.jsp" %>
	
	<form action="<%=request.getContextPath() %>/TPChifoumiServlet" method="post">
		<button class="button" type="submit" name="choix" value="1"><img alt="CHI" src="<%=request.getContextPath()%>/img/chi.png"></button>
		<button class="button" type="submit" name="choix" value="2"><img alt="FOU" src="<%=request.getContextPath()%>/img/fou.png"></button>
		<button class="button" type="submit" name="choix" value="3"><img alt="MI" src="<%=request.getContextPath()%>/img/mi.png"></button>
	</form>
</body>
</html>
