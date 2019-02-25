package fr.eni.skillsContextes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enregistrer")
public class EnregistrerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/affichageAttributs.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String valeur = request.getParameter("valeur");
		
		Valeur valeurObj =  new Valeur(""+valeur); 
	
		switch(action) {
		case "requete" : 
			request.setAttribute("mon_attribut_requete", valeurObj);
			break;
		case "session" : 
			request.getSession().setAttribute("mon_attribut_session", valeurObj);
			break;
		case "application" : 
			request.getServletContext().setAttribute("mon_attribut_application", valeurObj);
			break;
		}
		request.getRequestDispatcher("/WEB-INF/affichageAttributs.jsp").forward(request, response);
		
	
	}
	
}
