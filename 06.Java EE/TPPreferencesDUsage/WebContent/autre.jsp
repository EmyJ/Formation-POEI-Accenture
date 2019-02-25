<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String couleur="noir";
	if(session.getAttribute("couleurPreferee")!=null){
		couleur=(String)session.getAttribute("couleurPreferee");
	}
%>
</head>
<body>
<h1>Une JSP</h1>
<a href="<%=response.encodeURL(request.getContextPath()+"/TraitementServlet")%>">Retour</a>
</body>
</html>