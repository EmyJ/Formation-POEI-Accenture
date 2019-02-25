package fr.eni.fighters.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.fighters.bo.Partie;

/**
 * Servlet implementation class LancerPartie
 */
@WebServlet("/private/lancerPartie")
public class LancerPartie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SERVLET_COMBAT = "/private/combat";
	ServletContext application;
    
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
    	application = config.getServletContext();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(SERVLET_COMBAT);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParamPartie = request.getParameter("id_partie");
		String idParamInvite = request.getParameter("id_invite");
		String etat = "en cours";
		int idPartie = Integer.parseInt(idParamPartie);
		int idInvite = Integer.parseInt(idParamInvite);
		
		List<Partie> listePartie = (List<Partie>) application.getAttribute("listePartie");
		Partie partieEnCours = null;
		for (Partie partie : listePartie) {
			if (partie.getId() == idPartie) {
				partieEnCours=partie;
			}
		}
		partieEnCours.setId_invite(idInvite);
		partieEnCours.setEtat(etat);
		//on ajoute la partie à liste des parties en cours
		List<Partie> listePartieEnCours = (List<Partie>) application.getAttribute("listePartieEnCours");
	    if (listePartieEnCours==null) {
	    	listePartieEnCours = new ArrayList<Partie>();
	    	listePartieEnCours.add(partieEnCours);
	    	
	    	application.setAttribute("listePartieEnCours", listePartieEnCours);
		}
	    
	    for (int i = 0; i < listePartie.size(); i++) {
			if (listePartie.get(i).getId() == idPartie) {
				listePartie.set(i, partieEnCours);
				break;
			}
		}
	    application.setAttribute("listePartieEnCours", listePartieEnCours );
		application.setAttribute("listePartie", listePartie );
		doGet(request, response);
	}

}
