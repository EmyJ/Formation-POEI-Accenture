<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="/WEB-INF/site/include/head.jsp"></jsp:include>
<title>Jouer</title>
</head>
<body id="black">
	<div id="page">
		<jsp:include page="/WEB-INF/site/include/nav2.jsp"></jsp:include>
		<%-- 	<jsp:include page="/WEB-INF/site/include/header2.jsp"></jsp:include> --%>
		<%@ include file="/WEB-INF/site/include/messagesErreurs.jspf"%>
		<h1 class="bl ptb15 centerblock">:: GESTION DE PARTIES ::</h1>
		<div id="contenu" class="w250 autolr">
			<form name="creerPartie"
				action="<%=request.getContextPath()%>/private/CreerPartie"
				method="post" id="creerCompte">
				<h3 class="text-center bold j">CREEZ UNE PARTIE</h3>
				<div class="w250 autolr">
					<div class="bl center">
						COUT MAX :
						<c:out value="${sessionScope.coutMax}"></c:out>
					</div>
					<div class="left bls">
						<input type="text" name="coutPartie" id="coutPartie" size="30"
							maxlength="10" class="form-control bl"
							placeholder="Nombre de point" />
					</div>
					<div class="left">
						<input type="radio" id="humain" name="adversaire" value="humain"
							checked> <label for="humain">Humain</label>
					</div>
					<div class="right">
						<input type="radio" id="ia" name="adversaire" value="IA">
						<label for="ia">IA</label>
					</div>
					<div class="clear"></div>
				</div>
				<div>
					<input type="hidden" name="id_user" value="${id_user}" />
				</div>
				<div class="text-center">
					<c:choose>
						<c:when test="${indicePartieUnique<0}">
							<button class="btn btn-deep-orange waves-effect waves-light"
								type="submit">CREER UNE PARTIE</button>
						</c:when>
						<c:otherwise>
							<p>VOUS AVEZ DEJA CREER UNE PARTIE</p>
						</c:otherwise>
					</c:choose>
				</div>
			</form>
		</div>
		<div class="centerblock autolr ptb15">
			<form method="get"
				action="<%=request.getContextPath()%>/private/jouer">
				<button class="btn btn-deep-jaune waves-effect waves-light w1200"
					type="submit">Rafraichir toutes les parties</button>
			</form>
		</div>
		<div id="collection">
			<div class="centerblock">
				<div class="card2 inline bl p15 valigntop left">
					<h5 class="bold j">PARTIES EN ATTENTE</h5>
					<img src="<%=request.getContextPath()%>/img/fond3-300.png"
						class="jpic">
					<c:forEach var="l" items="${applicationScope.listePartie}">
						<%-- 		id Partie : <c:out value="${l.id}"></c:out>&nbsp;|&nbsp;  --%>
						MISE : <c:out value="${l.nbPoint}"></c:out>&nbsp;|&nbsp;
						VS : <c:out value="${l.type}"></c:out>&nbsp;|&nbsp;
						ETAT : <c:out value="${l.etat}"></c:out>&nbsp;|&nbsp;
						USER : <c:out value="${l.id_user}"></c:out>&nbsp;|&nbsp;
						INVITE : <c:out value="${l.id_invite}"></c:out>
						<c:if test="${sessionScope.userCourant.id != l.id_user }">
						<form method="post"
							action="<%=request.getContextPath()%>/private/lancerPartie">
							<input type="hidden" name="id_partie" value="${l.id}" /> <input
								type="hidden" name="id_invite"
								value="${sessionScope.userCourant.id}" />
							<button class="btn btn-deep-orange waves-effect waves-light"
								type="submit">rejoindre</button>
						</form>
						</c:if>
						<c:if test="${sessionScope.userCourant.id == l.id_user }">
						<br>
						</c:if>
						<span class="bl">_______________</span>
						<br>
					</c:forEach>
				</div>

				<div class="card2 inline bl p15 valigntop right">
					<h5 class="bold j">PARTIES EN COURS</h5>
					<img src="<%=request.getContextPath()%>/img/fond2-300.png"
						class="jpic">
					<c:forEach var="p" items="${applicationScope.listePartieEnCours}">
						<%-- 		id Partie: <c:out value="${p.id}"></c:out> --%>
						MISE : <c:out value="${p.nbPoint}"></c:out>&nbsp;|&nbsp;
						VS : <c:out value="${p.type}"></c:out>&nbsp;|&nbsp;
						ETAT : <c:out value="${p.etat}"></c:out>&nbsp;|&nbsp;
						USER : <c:out value="${p.id_user}"></c:out>&nbsp;|&nbsp;
						INVITE : <c:out value="${p.id_invite}"></c:out>
						<c:choose>
							<c:when test="${p.id_user==sessionScope.userCourant.id}">
								<form method="post"
									action="<%=request.getContextPath()%>/private/combat">
									<input type="hidden" name="id_partie" value="${p.id}" /> <input
										type="hidden" name="id_user"
										value="${sessionScope.userCourant.id}" />
									<button class="btn btn-deep-orange waves-effect waves-light"
										type="submit">Jouer à ma partie</button>
								</form>
								<span class="bl">_______________</span>
							</c:when>
						</c:choose>
						<br>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/site/include/footer.jsp"></jsp:include>