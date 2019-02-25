package fr.eni.fighters.servlets;

import fr.eni.fighters.BusinessException;
import fr.eni.fighters.bll.CarteMger;
import fr.eni.fighters.bll.UserMger;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.User;

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

/**
 * Servlet pour s'authentifier
 */
@WebServlet("/authentification")
public class Authentification extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    UserMger userMger = UserMger.getUSerMger();
    CarteMger carteMger = CarteMger.getCarteMger();
    HttpSession session;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/site/authentification.jsp");
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	session = request.getSession();
	List<Integer> listeCodesErreur = new ArrayList<>();
	String login = null;
	String password = null;

	login = this.lireParametreLogin(request, listeCodesErreur);
	password = this.lireParametrePassword(request, listeCodesErreur);

	session.setAttribute("login", login);
	// On récupère les utilisateurs
	List<User> listeUsers = null;

	if (listeCodesErreur.size() > 0) {
	    request.setAttribute("listeCodesErreur", listeCodesErreur);
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/site/authentification.jsp");
	    rd.forward(request, response);
	} else {
	    try {
		listeUsers = userMger.selectionUsers();
		comboLoginPasswordValide(request, response, login, password, listeUsers);
	    } catch (BusinessException e) {
		e.printStackTrace();
		request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
	    }
	}

	

    }

    /**************************************************************************
     * Méthode Private
     **************************************************************************/

    /**
     * Méthode en charge de verifier si le login et le password sont valide
     * 
     * @param request
     * @param response
     * @param login
     * @param password
     * @param listeUsers
     * @throws ServletException
     * @throws IOException
     */
    private void comboLoginPasswordValide(HttpServletRequest request, HttpServletResponse response, String login,
	    String password, List<User> listeUsers) throws ServletException, IOException {
	List<Integer> listeCodesErreur = new ArrayList<>();
	// On regarde dans la liste des utilisateurs si on a bien un combo login
	// password valide
	User userCourant = null;
	Boolean identificationReussie = false;
	for (User user : listeUsers) {
	    if ((user.getPseudo().equals(login) && user.getPassword().equals(password))
		    || (user.getEmail().equals(login) && user.getPassword().equals(password))) {
		identificationReussie = true;
		userCourant = user;
		break;
	    } 
	}
	listeCodesErreur.add(CodesResultatServlets.AUTHENTIFICATION_ERREUR);
	// on redirige en fonction du resultat
	if (identificationReussie) {
	    session.setAttribute("userCourant", userCourant);
	    recuperationDesk(request, response);
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/site/home.jsp");
	    rd.forward(request, response);
	} else {
	    request.setAttribute("listeCodesErreur", listeCodesErreur);
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/site/authentification.jsp");
	    rd.forward(request, response);
	}
    }

    /**
     * 
     * Méthode en charge de lire le parametre login
     * @param request
     * @param listeCodesErreur
     * @return
     */
    private String lireParametreLogin(HttpServletRequest request, List<Integer> listeCodesErreur) {
	String login;
	login = request.getParameter("login");
	if (login == null || login.trim().equals("")) {
	    listeCodesErreur.add(CodesResultatServlets.LOGIN_OBLIGATOIRE);
	}
	return login;
    }

    /**
     * 
     * Méthode en charge de lire le parametre password
     * @param request
     * @param listeCodesErreur
     * @return
     */
    private String lireParametrePassword(HttpServletRequest request, List<Integer> listeCodesErreur) {
	String password;
	password = request.getParameter("password");
	if (password == null || password.trim().equals("")) {
	    listeCodesErreur.add(CodesResultatServlets.PWD_OBLIGATOIRE);
	}
	return password;
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
