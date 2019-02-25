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
 * Servlet implementation class AjoutPanier
 */
@WebServlet("/AjoutPanier")
public class AjoutPanier extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutPanier() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Je lis les paramètres
		List<Integer> listeCodesErreur = new ArrayList<>();
		if (listeCodesErreur.size() > 0) {
		    request.setAttribute("listeCodesErreur", listeCodesErreur);
		} else {

		    try {
			// Recherche des liste
			ListeManager listeManager = new ListeManager();
			List<fr.eni.tpGestionListesCourses.bo.Liste> listeListe = null;
			int id = Integer.parseInt(request.getParameter("panier"));
			if (id != 0) {
			    listeListe = listeManager.selectId(id);
			}
			request.setAttribute("listeListe", listeListe);
		    } catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		    }

		}
		// Transfert de l'affichage à la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/panier.jsp");
		rd.forward(request, response);
    }

}
