package fr.eni.javaee.gestionlistescourses.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.gestionlistescourses.BusinessException;
import fr.eni.javaee.gestionlistescourses.bll.ListeCourseManager;

/**
 * Exemple de servlet de traitement ( = qui n'envoie pas vers une vue) 
 *
 */
@WebServlet("/supprimer/liste")
public class ServletSupprimerListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ID_PARAM_NAME = "id";
	private static final int ID_PARAM_DEFAULT_VALUE = -1;

       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Integer> listeCodesErreur=new ArrayList<>();
		ListeCourseManager listeCourseManager = null ;
		
		// Récupération des paramètres
		int idListe = this.lireParametreSupprimer(request, listeCodesErreur);
		
		// Si erreur au cours des controles de parametres
		if(listeCodesErreur.size() > 0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			getServletContext().getRequestDispatcher("/supprimer/liste").forward(request, response);
		}
		// Sinon,
		else
		{  // Supprimer la liste de courses
			try {
				listeCourseManager = new ListeCourseManager();
				listeCourseManager.supprimerListeCourse(idListe);
			} catch (BusinessException be) {
				request.setAttribute("listeCodesErreur", be.getListeCodesErreur());
				be.printStackTrace();
			}
			
			// Afficher la liste des liste de courses
			response.sendRedirect(getServletContext().getContextPath()+"/listes");
		}
	
	}

	/**
	 * Controle la presence et le format (entier) du parametre <code>ID_PARAM_NAME</code>
	 * @param request
	 * @param listeCodesErreur
	 * @return la valeur de "id"
	 */
	protected int lireParametreSupprimer(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String sIdListeCourses = request.getParameter(ID_PARAM_NAME);
		int idListeCourses = ID_PARAM_DEFAULT_VALUE;
		
		try
		{
			// Controle de présence et de format
			if ( sIdListeCourses!=null && !sIdListeCourses.trim().isEmpty())
			{
				idListeCourses = Integer.parseInt(sIdListeCourses);
			}
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ID_LISTE_ERREUR);
		}
		
		return idListeCourses;
	}
}
