<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/site/include/head.jsp"></jsp:include>
<title>Bienvenue sur DIGI-FIGHTERS</title>
</head>
<body>
	<div id="page">
		<jsp:include page="/WEB-INF/site/include/nav.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/site/include/header2.jsp"></jsp:include>

		<%@ include file="/WEB-INF/site/include/messagesErreurs.jspf"%>

		<main id="contenu">
		<h1>:: GESTION DU PROFIL ::</h1>

		<h2>VOTRE DECK</h2>
		<div>
			<ul class="centerblock">
				<c:forEach items="${sessionScope.listePaquet}" var="cartePaquet">
					<li class="inline padr">
						<div class="container2">
							<img
								src="<%=request.getContextPath()%>/img/carte${cartePaquet.cout}.jpg"
								class="image" width="100px"/>
							<div class="overlay2">
								<div class="text2">
									<span class="carte mb1">COUT ${cartePaquet.cout}</span> <span
										class="carte">FORCE ${cartePaquet.force}</span>
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<h2>MON COMPTE</h2>
		<form class="form" method="post"
			action="<%=request.getContextPath()%>/private/home">

			<div class="phome">
				<ul>
					<c:if test="${ !empty user}">
						<input type="hidden" value="${sessionScope.userCourant.id}"
							name="id" class="bl" />
					</c:if>
					<li><label>Mon Email :</label></br> <input type="email" id="email"
						name="email" value="${sessionScope.userCourant.email}" class="bl"></li>
					<li class="pt15"><label>Mon Password :</label></br> <input
						type="password" id="password" name="password"
						value="${sessionScope.userCourant.password}" class="bl"></li>
					<li class="center pt15"><input type="submit"
						value="MODIFIER ET SAUVEGARDER"
						class="btn btn-deep-orange waves-effect waves-light"></input></li>
				</ul>
			</div>
		</form>
		</main>
	</div>
	<jsp:include page="/WEB-INF/site/include/footer.jsp"></jsp:include>