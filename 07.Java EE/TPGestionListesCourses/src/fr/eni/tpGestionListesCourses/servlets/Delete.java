package fr.eni.tpGestionListesCourses.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bll.ListeManager;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Integer> listeCodesErreur=new ArrayList<>();
	    
	    if(listeCodesErreur.size()>0){
			//Je renvoie les codes d'erreurs
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}else{
		    int id = Integer.parseInt(request.getParameter("deleteListe"));
			//J'ajoute le repas
			ListeManager listeManager = new ListeManager();
			try {
				listeManager.delete(id);
				//Si tout se passe bien, je vais vers la page de consultation:
				RequestDispatcher rd = request.getRequestDispatcher("/Liste");
				rd.forward(request, response);
			} catch (BusinessException e) {
				//Sinon je retourne à la page d'ajout pour indiquer les problèmes:
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listePredefinies.jsp");
				rd.forward(request, response);
			}
		    
		}
	}

}
