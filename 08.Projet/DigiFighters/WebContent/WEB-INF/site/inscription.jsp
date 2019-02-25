<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/site/include/head.jsp"></jsp:include>
<title>Inscription</title>
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
							<form name="creerCompte"
								action="<%=request.getContextPath()%>/inscription" method="post"
								id="creerCompte">
								<h2 class="text-center font-up font-bold deep-orange-text py-4">Créer
									un compte</h2>
								<div class="md-form">
									<i class="fa fa-user prefix white-text"></i> <input type="text"
										name="pseudo" id="pseudo" size="30" maxlength="10"
										placeholder="Votre pseudo" class="form-control" />
								</div>
								<div class="md-form">
									<i class="fa fa-envelope prefix white-text"></i> <input
										type="email" name="email" id="email" size="30" maxlength="30"
										class="form-control" placeholder="Votre email" />
								</div>
								<div class="md-form">
									<i class="fa fa-lock prefix white-text"></i> <input
										type="password" name="password" id="password" size="30"
										maxlength="20" class="form-control"
										placeholder="Votre mot de passe" />
								</div>
								<div class="text-center">
									<button class="btn btn-deep-orange waves-effect waves-light"
										type="submit">Envoyer</button>

									<a class="btn btn-deep-orange waves-effect waves-light"
										role="button"
										href="<%=request.getContextPath()%>/authentification">Authentification</a>
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