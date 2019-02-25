<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/site/include/head.jsp"></jsp:include>
<title>Votre Collection de Carte</title>
</head>
<body id="black">
<div id="page">
	<jsp:include page="/WEB-INF/site/include/nav2.jsp"></jsp:include>
<%-- 	<jsp:include page="/WEB-INF/site/include/header2.jsp"></jsp:include> --%>

	<%@ include file="/WEB-INF/site/include/messagesErreurs.jspf"%>

	<div id="collection">
		<h2 class="bl bold j">VOS CARTES DE COMBATS</h2>
		<h3 class="bl bold">COMPOSEZ VOTRE DECK AVEC 5 CARTES</h3>
		<ul class="pr90 centerblock">
			<c:forEach items="${sessionScope.listeCarte}" var="carteCourante">
				<li class="inline">
					<div>
						<form action="${pageContext.request.contextPath}/private/collection" id="form${carteCourante.id}" method="post">
							<label >
							<input type="hidden" name="id_user" value="${id_user}" />
							<input type="hidden" name="id_carte" value="${carteCourante.id}" />
							<input type="checkbox"  name="coche" onclick="document.forms['form${carteCourante.id}'].submit();" ${carteCourante.coche?"checked":""} />
							<div class="container">
								<img src="<%=request.getContextPath()%>/img/carte${carteCourante.cout}.jpg" class="image" />
									<div class="overlay">
										<div class="text">
											<span class="carte mb1">COUT ${carteCourante.cout}</span> 
											<span class="carte">FORCE ${carteCourante.force}</span>
										</div>
									</div>
								</div>
							</label>
						</form>
					</div>
				</li>
			</c:forEach>
		</ul>
		<div class="center mt30">
			<a class="btn btn-deep-orange waves-effect waves-light w400"
						href="${pageContext.request.contextPath}/private/collection?id_user=${id_user}&clear"
						title="clear" role="button">refresh</a>
		</div>
	</div>
</div>
	<jsp:include page="/WEB-INF/site/include/footer.jsp"></jsp:include>