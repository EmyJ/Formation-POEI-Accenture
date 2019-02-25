<nav>
	<div>
		<div class="left w250 mr30"><img src="<%=request.getContextPath()%>/img/fond.png" alt="" width="250px"/></div>
		<div class="left w250">${sessionScope.userCourant.pseudo},</br><span>Vous avez ${sessionScope.userCourant.points} Crédits</span></div>
		<div class="right w250"><jsp:include page="/WEB-INF/site/include/deconnexion.jsp"></jsp:include></div>
		<div class="right w250"><button class="btn btn-deep-orange waves-effect waves-light" type="submit" form="combat">Terminer combat</button></div>
		<div class="clear"></div>
	</div>
</nav>