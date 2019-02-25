package fr.eni.tpGestionListesCourses.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
 * Servlet implementation class AjoutList
 */
@WebServlet("/AjoutList")
public class AjoutList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutList() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/liste.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<Integer> listeCodesErreur = new ArrayList<>();

	// Réalisation du traitement
	if (listeCodesErreur.size() > 0) {
	    renvoieCodeErreur(request, response, listeCodesErreur);
	} else {
	    ajoutListe(request, response);

	}
    }

    /**
     * Méthode en charge
     * 
     * @param request
     * @param response
     * @param listeCodesErreur
     * @throws ServletException
     * @throws IOException
     */
    private void renvoieCodeErreur(HttpServletRequest request, HttpServletResponse response,
	    List<Integer> listeCodesErreur) throws ServletException, IOException {
	// Je renvoie les codes d'erreurs
	request.setAttribute("listeCodesErreur", listeCodesErreur);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/liste.jsp");
	rd.forward(request, response);
    }

    /**
     * Méthode en charge
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void ajoutListe(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String liste = request.getParameter("liste");
	String article = request.getParameter("article");
	// J'ajoute la liste
	ListeManager listeManager = new ListeManager();
	try {
	    listeManager.ajouterListe(liste, Arrays.asList(article.split(",")));
	    // Si tout se passe bien, je vais vers la page de Liste Predefinie:
	    RequestDispatcher rd = request.getRequestDispatcher("/Liste");
	    rd.forward(request, response);
	} catch (BusinessException e) {
	    // Sinon je retourne à la page d'ajout pour indiquer les problèmes:
	    e.printStackTrace();
	    request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/liste.jsp");
	    rd.forward(request, response);
	}
    }

}
