<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/site/include/head.jsp"></jsp:include>
<title>Combat</title>
</head>
<body id="black">
	<div id="page">
		<jsp:include page="/WEB-INF/site/include/nav3.jsp"></jsp:include>
		<%-- 	<jsp:include page="/WEB-INF/site/include/header2.jsp"></jsp:include> --%>
		<%@ include file="/WEB-INF/site/include/messagesErreurs.jspf"%>
		<h1 class="bl ptb15 centerblock">:: COMBAT ::</h1>
		<div id="contenucombat">
			<form method="post" name="combat"
				action="<%=request.getContextPath()%>/private/traitementCombat"
				id="combat">
				<c:forEach var="l" items="${sessionScope.paquetTroisCartes}"
					varStatus="status">
					<div class="left pcombat">
					<div class="container3">
						<img src="<%=request.getContextPath()%>/img/carte${l.cout}.jpg"
							class="image" width="150px">
						<div class="overlay3">
							<div class="text3">
								<span class="carte mb1">COUT ${l.cout}</span> <span
									class="carte">FORCE ${l.force}</span>
							</div>
						</div>
					</div>
				</div>
					<%-- 				cout:<c:out value="${l.cout}"></c:out> --%>
					<%-- 				force:<c:out value="${l.force}"></c:out> --%>

					<div class="right pcombat">
						<div class="p100 demo">
						<div class="element">
							<input type="radio" id="arene" name="carte${status.index }"
								value="A"><label for="areneA">A</label>
						</div>
						<div class="element">
							<input type="radio" id="arene" name="carte${status.index }"
								value="B"><label for="areneB">B</label>
						</div></div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<input type="hidden" name="id_partie"
					value="${sessionScope.partieEnCours}" />
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/site/include/footer.jsp"></jsp:include>