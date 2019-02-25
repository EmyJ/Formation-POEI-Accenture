package fr.eni.fighters.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.bll.UserMger;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.CollectionCarte;
import fr.eni.fighters.bo.User;

/**
 * Servlet pour inscrire un utilisateur
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserMger userMger = UserMger.getUSerMger();
    private static final String VUE = "/WEB-INF/site/inscription.jsp";
    private static final String VUE1 = "/WEB-INF/site/authentification.jsp";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "password";
    private static final String CHAMP_PSEUDO = "pseudo";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher(VUE);
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<Integer> listeCodesErreur = new ArrayList<>();
	String email = null;
	String password = null;
	String pseudo = null;

	email = this.lireParametreEmail(request, listeCodesErreur);
	password = this.lireParametrePassword(request, listeCodesErreur);
	pseudo = this.lireParametrePseudo(request, listeCodesErreur);

	if (listeCodesErreur.size() > 0) {
	    request.setAttribute("listeCodesErreur", listeCodesErreur);
	    RequestDispatcher rd = request.getRequestDispatcher(VUE);
	    rd.forward(request, response);
	} else {

	    try {
		CollectionCarte collection = new CollectionCarte();
		for (int i = 1; i < 11; i++) {
		    collection.getCartes().add(new Carte(i, i));
		}
		userMger.ajouterUser(new User(email, pseudo, password, collection));
		RequestDispatcher rd = request.getRequestDispatcher(VUE1);
		rd.forward(request, response);
	    } catch (BusinessException e) {
		e.printStackTrace();
		request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
	    }
	}
    }

    /************************************************
     * Méthode Private
     **************************************************************************/

    @SuppressWarnings("null")
    private String lireParametrePseudo(HttpServletRequest request, List<Integer> listeCodesErreur) {
	String pseudo;
	pseudo = request.getParameter(CHAMP_PSEUDO);
	if (pseudo == null && pseudo.trim().length() == 0) {
	    listeCodesErreur.add(CodesResultatServlets.PSEUDO_OBLIGATOIRE);
	}
	return pseudo;
    }

    private String lireParametrePassword(HttpServletRequest request, List<Integer> listeCodesErreur) {
	String password = request.getParameter(CHAMP_PASS);
	if (password != null && password.trim().length() != 0) {
	    if (password.trim().length() < 8) {
		listeCodesErreur.add(CodesResultatServlets.PWD_TAILLE);
	    }
	} else {
	    listeCodesErreur.add(CodesResultatServlets.PWD_OBLIGATOIRE);
	}
	return password;
    }

    private String lireParametreEmail(HttpServletRequest request, List<Integer> listeCodesErreur) {
	String email = request.getParameter(CHAMP_EMAIL);
	if (email != null && email.trim().length() != 0) {
	    if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
		listeCodesErreur.add(CodesResultatServlets.EMAIL_VALIDE);
	    }
	} else {
	    listeCodesErreur.add(CodesResultatServlets.EMAIL_OBLIGATOIRE);
	}
	return email;
    }

}
