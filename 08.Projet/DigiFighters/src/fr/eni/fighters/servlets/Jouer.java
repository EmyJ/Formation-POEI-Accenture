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
import javax.servlet.http.HttpSession;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.bll.CarteMger;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.User;

/**
 * Servlet pour aller sur la page pour jouer
 */
@WebServlet("/private/jouer")
public class Jouer extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public static final String VUE = "/WEB-INF/site/jouer.jsp";
    public static final String VUE1 = "/WEB-INF/site/home.jsp";
    CarteMger carteMger = CarteMger.getCarteMger();
    ServletContext application;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
	application = config.getServletContext();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	verificationDuPaquetComplet(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

    /****************************************************************************************
     * 					Méthodes Privates
     ***************************************************************************************/

    /**
     * Méthode en charge verifier qu'il y a bien 5 cartes dans le paquet pour jouer
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void verificationDuPaquetComplet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User userCourant = (User) session.getAttribute("userCourant");
	int idUser = userCourant.getId();
	int coutMax = calculCoutMax(userCourant);
	session.setAttribute("coutMax", coutMax);
	List<Integer> listeCodesErreur = new ArrayList<>();
	try {
	    int nbCocher = carteMger.countCocherCarte(idUser);
	    if (nbCocher == 5) {

		Integer indice = (Integer) session.getAttribute("indicePartieUnique");
		if (indice == null) {
		    indice = -1;
		    indice = (int) indice;
		    session.setAttribute("indicePartieUnique", indice);
		}
		session.setAttribute("indicePartieUnique", indice);
		RequestDispatcher rd = request.getRequestDispatcher(VUE);
		rd.forward(request, response);
	    } else {
		listeCodesErreur.add(CodesResultatServlets.PAQUET_5_OBLIGATOIRE);
		request.setAttribute("listeCodesErreur", listeCodesErreur);
		RequestDispatcher rd = request.getRequestDispatcher(VUE1);
		rd.forward(request, response);
	    }
	} catch (BusinessException e) {
	    e.printStackTrace();
	    e.getMessage();
	}
    }

    /**
     * Méthode en charge de calculer le cout max 
     * 
     * @param userCourant
     * @return
     */
    private int calculCoutMax(User userCourant) {
	float sommeC = 0;
	List<Carte> paquet = null;
	try {
	    paquet = carteMger.selectPaquet(userCourant.getId());
	} catch (BusinessException e) {
	    e.printStackTrace();
	    e.getMessage();
	}
	for (Carte carte : paquet) {
	    sommeC += carte.getCout();
	}
	float moyenne = sommeC / paquet.size();
	int valeurEntiere = (int) moyenne;
	int moyenneArrondie;
	if (moyenne > valeurEntiere) {
	    moyenneArrondie = valeurEntiere + 1;
	} else {
	    moyenneArrondie = valeurEntiere;
	}
	int coutMax = moyenneArrondie * 3;
	return coutMax;
    }

}
