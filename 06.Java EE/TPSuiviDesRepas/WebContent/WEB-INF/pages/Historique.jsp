<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.TPSuiviDesRepas.bo.Repas" %>
<%@ page import="fr.eni.TPSuiviDesRepas.bo.Aliment" %>  
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historique - suivi des repas</title>
</head>
<body>

<%!
	private java.text.SimpleDateFormat sdfDate = new java.text.SimpleDateFormat("dd/MM/yyyy");
	private java.text.SimpleDateFormat sdfHeure = new java.text.SimpleDateFormat("HH:mm aa");

	%>
	<h1>HISTORIQUE</h1>
	<div class="contenu">
	
		<table align="center" border="1">
			<thead>
				<tr>
					<th>Date</th>
					<th>Heure</th>
					<th>Action</th>
				</tr>
			</thead>
				<%
					List<Repas> listeRepas = (List<Repas>) request.getAttribute("listeRepas");
					if(listeRepas!=null && listeRepas.size()>0)
					{
				%>
						<tbody>
							<%
							for(Repas repas : listeRepas)
							{
							%>
								<tr>
									<td><%=sdfDate.format(repas.getDate()) %></td>
									<td><%=sdfHeure.format(repas.getDate()) %></td>
									
									<td colspan="3">
											<ul>
												<%
												for(Aliment aliment:repas.getAliments())
												{
												%>
													<li><%=aliment.getNom()%></li>
												<%
												}
												%>
											</ul>
										</td>
								</tr>
							
							<%	
							}
							%>
						</tbody>
				<%
					}
					else
					{
				%>
					<p>Il n'y a aucun repas à afficher<P>
				<%
					}
				%>
	
			
			
		</table>
	
		<a href="<%=request.getContextPath()%>/ajoutRepas"><input type="button" value="Ajouter un nouveau repas"/></a>
		<a href="<%=request.getContextPath()%>"><input type="button" value="Retour à l'accueil"/></a>
		
	</div>

</form>
</body>
</html>