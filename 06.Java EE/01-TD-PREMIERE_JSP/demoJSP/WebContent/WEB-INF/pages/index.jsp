<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang='fr'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>HELLO WORLD</h1>
	
	<% String maVariable= (String)request.getAttribute("truc"); %>
	
	<p><%= maVariable %></p>
</body>
</html>