<p>
	<fmt:message key="msg.langueactuelle"></fmt:message>:${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}
</p>
<p>
	<fmt:message key="msg.choisirlangue"></fmt:message>:
	<a href="${pageContext.request.contextPath}/choixlangue?langue=fr">Français</a>
	<a href="${pageContext.request.contextPath}/choixlangue?langue=en">English</a>
	<a href="${pageContext.request.contextPath}/choixlangue"><fmt:message key="msg.languenavigateur"/></a>
	
</p>