<nav>
	<div>
		<div class="left w250">${sessionScope.userCourant.pseudo},</br><span>Vous avez ${sessionScope.userCourant.points} Crédits</span></div>
		<div class="right w250"><jsp:include page="/WEB-INF/site/include/deconnexion.jsp"></jsp:include></div>
		<div class="right w250"><a href="<%=request.getContextPath()%>/private/jouer" role="button" class="btn btn-deep-jaune waves-effect waves-light" >Jouer une partie</a></div>
		<div class="right w200"><a href="<%=request.getContextPath()%>/private/collection" role="button" class="btn btn-deep-orange waves-effect waves-light" >Tes Cartes</a></div>
		<div class="clear"></div>
	</div>
</nav>


	
	