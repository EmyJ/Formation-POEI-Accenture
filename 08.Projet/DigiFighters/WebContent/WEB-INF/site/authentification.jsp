<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/site/include/head.jsp"></jsp:include>
<title>Authentification</title>
</head>
<body id="black">
	<div id="bg">
		<jsp:include page="/WEB-INF/site/include/header.jsp"></jsp:include>
		<main>
		<div class="container mt-4">
			<%@ include file="/WEB-INF/site/include/messagesErreurs.jspf"%>
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">
							<form name="dejaInscrit"
								action="<%=request.getContextPath()%>/authentification"
								method="post" id="dejaInscrit">
								<h2 class="text-center font-up font-bold deep-orange-text py-4">Identification</h2>
								<div class="md-form">
									<i class="fa fa-envelope prefix white-text"></i> <input
										type="text" name="login" id="login" size="30" maxlength="30"
										class="form-control" placeholder="Votre email ou votre pseudo" />
								</div>
								<div class="md-form">
									<i class="fa fa-lock prefix white-text"></i> <input
										type="password" name="password" id="password"
										class="form-control" size="30" maxlength="20"
										placeholder="Votre Mot de passe" />
								</div>
								<div class="text-center">
									<button class="btn btn-deep-orange waves-effect waves-light"
										type="submit">Envoyer</button>
									<button class="btn btn-deep-orange waves-effect waves-light"
										type="reset">Reset</button>

									<a class="btn btn-deep-orange waves-effect waves-light bou"
										href="<%=request.getContextPath()%>/inscription">Inscription</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</main>
	</div>
	<jsp:include page="/WEB-INF/site/include/footer.jsp"></jsp:include>