<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.javaee.gestionlistescourses.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<%@ include file="/WEB-INF/fragments/head.jspf" %>

<body class="container">

<%@ include file="./fragments/header.html" %>

	<div class="col-12">
	    <h2 class="my-5 text-center">Listes prédéfinies</h2>
	
	<%@ include file="/WEB-INF/fragments/messagesErreurs.jspf" %>
		
	    <div class="row">
	    	<c:choose>
	    		<c:when test="${listesCourse.size()>0}">
			        <ul class="list-group col-12">
			        	<c:forEach var="c" items="${listesCourse}">
				            <li class="list-group-item d-flex justify-content-between align-items-center">${c.nom}
				                <div>
				                	<a href="${pageContext.request.contextPath}/nouvelle?id=${c.id}" class="badge" title="Editer la liste"><i class="material-icons">create</i></a>
				                    <a href="${pageContext.request.contextPath}/panier?id=${c.id}" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
				                    <a href="#" class="badge text-danger" title="Supprimer" data-toggle="modal" data-target="#modaleSupprimerListe"><i class="material-icons">delete</i></a>
				                    
				                    <%-- Pas optimisé (la div est dupliquee) mais permet de realiser le comportement attendu avec JSP sans JavaScript --%>
									<jsp:include page="/WEB-INF/fragments/modaleSuppression.jsp">
										<jsp:param value="${c.id}" name="id"/>
									</jsp:include>
				                </div>
				            </li>
				      	</c:forEach>
			        </ul>
		        </c:when>
		        <c:otherwise>
		        	<p>Pas de liste actuellement.<p>
		        </c:otherwise>
	        </c:choose>
	    </div>
	</div>
    <!-- Footer -->
    <footer class="row bg-dark footer-demodule fixed-bottom py-1">
            <div class="col-lg-4 offset-lg-4 text-center">
                <a class="btn" href="${pageContext.request.contextPath}/nouvelle" title="Créer une nouvelle liste"><i class="material-icons">add</i></a>
            </div>
    </footer>

    <%@ include file="./fragments/footer.html" %>
    
</body>

</html>
