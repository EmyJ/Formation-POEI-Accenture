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
import javax.servlet.http.HttpSession;

import fr.eni.fighters.bll.CarteMger;
import fr.eni.fighters.bll.UserMger;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.User;
import fr.eni.fighters.BusinessException;

/**
 * Servlet qui dirige vers la page centrale
 */
@WebServlet("/private/home")
public class Home extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UserMger userMger = UserMger.getUSerMger();
    CarteMger carteMger = CarteMger.getCarteMger();
    
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "password";
    private static final String VUE = "/WEB-INF/site/home.jsp";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	recuperationDesk(request, response);
	RequestDispatcher rd = request.getRequestDispatcher(VUE);
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	modifiecationLoginPassword(request, response);
    }

    /*********************************************************************************
     * 				Méthode private
     *********************************************************************************/

    /**
     * Méthode en charge de verifier le login et le password
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void modifiecationLoginPassword(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<Integer> listeCodesErreur = new ArrayList<>();
	/* Récupération des champs du formulaire. */
	HttpSession session = request.getSession();
	User userCourant = (User) session.getAttribute("userCourant");
	String email = request.getParameter(CHAMP_EMAIL);
	String password = request.getParameter(CHAMP_PASS);

	/* Validation de l'email */
	if (email != null && email.trim().length() != 0) {
	    if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
		listeCodesErreur.add(CodesResultatServlets.EMAIL_VALIDE);
	    }
	    userCourant.setEmail(email);
	} else {
	    listeCodesErreur.add(CodesResultatServlets.EMAIL_OBLIGATOIRE);
	}

	/* Validation du password */
	if (password != null && password.trim().length() != 0) {
	    if (password.trim().length() < 8) {
		listeCodesErreur.add(CodesResultatServlets.PWD_TAILLE);
	    }
	    userCourant.setPassword(password);

	} else {
	    listeCodesErreur.add(CodesResultatServlets.PWD_OBLIGATOIRE);
	}

	if (listeCodesErreur.size() > 0) {
	    request.setAttribute("listeCodesErreur", listeCodesErreur);
	    RequestDispatcher rd = request.getRequestDispatcher(VUE);
	    rd.forward(request, response);
	} else {
	    try {
		userMger.updateUser(userCourant);
		RequestDispatcher rd = request.getRequestDispatcher(VUE);
		rd.forward(request, response);
	    } catch (BusinessException e) {
		e.printStackTrace();
		request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
	    }
	}
    }
    private void recuperationDesk(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	User userCourant = (User) session.getAttribute("userCourant");
	List<Carte> listePaquet = null;
	try {
		listePaquet = carteMger.selectPaquet(userCourant.getId());
		session.setAttribute("listePaquet", listePaquet);
	} catch (BusinessException e) {
		e.printStackTrace();
		e.getMessage();
	}
    }
    
}