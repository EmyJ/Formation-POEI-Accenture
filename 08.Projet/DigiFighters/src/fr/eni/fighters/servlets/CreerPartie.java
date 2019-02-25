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
import fr.eni.fighters.bll.UserMger;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.Partie;
import fr.eni.fighters.bo.User;

/**
 * Servlet implementation class Partie
 */
@WebServlet("/private/CreerPartie")
public class CreerPartie extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
    UserMger userMger = UserMger.getUSerMger();
    CarteMger carteMger = CarteMger.getCarteMger();
    ServletContext application;
    private static final String VUE = "/WEB-INF/site/jouer.jsp";

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
	application = config.getServletContext();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	List<Integer> listeCodesErreur = new ArrayList<>();
	/* Récupération des champs du formulaire. */
	HttpSession session = request.getSession();
	User userCourant = (User) session.getAttribute("userCourant");
	int coutMax = calculCoutMax(userCourant);
	// ajouter un attribut avec condition vérification pour ne pas boucler à
	// l'infini sur la meme servlet en doGet
	session.setAttribute("coutMax", coutMax);
	request.setAttribute("listeCodesErreur", listeCodesErreur);
	
	RequestDispatcher rd = request.getRequestDispatcher(VUE);
	rd.forward(request, response);
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	verificationDuCoutMax(request, response);
    }

    /*****************************************************************************************************
     * 				Méthode private
     *****************************************************************************************************/

    /**
     * Méthode en charge de vérifier le cout max par rapport au cout partie
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void verificationDuCoutMax(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<Integer> listeCodesErreur = new ArrayList<>();
	/* Récupération des champs du formulaire. */
	HttpSession session = request.getSession();
	User userCourant = (User) session.getAttribute("userCourant");
	String coutPartie = request.getParameter("coutPartie");
	String adversaire = request.getParameter("adversaire");
	int points = userCourant.getPoints();
	// calcul du cout MAX
	int coutMax = calculCoutMax(userCourant);
	// validation partie
	boolean partieUnique = false;
	int intCoutPartie = Integer.parseInt(coutPartie);
	if (intCoutPartie < coutMax) {
	    points -= intCoutPartie;
	    userCourant.setPoints(points);
	    try {
		// insertPartie(request, response);
		userMger.updateUser(userCourant);
	    } catch (BusinessException e) {
		e.printStackTrace();
	    }
	    partieUnique = true;
	    request.setAttribute("partieUnique", partieUnique);
	    
	    @SuppressWarnings("unchecked")
	    List<Partie> listePartie = (List<Partie>) application.getAttribute("listePartie");
	    if (listePartie==null) {
	    	listePartie = new ArrayList<Partie>();
	    	application.setAttribute("listePartie", listePartie);
		}
	    
	    Partie partiePerso = new Partie(intCoutPartie, adversaire, "en attente", userCourant.getId());
	    listePartie.add(partiePerso);
	    
		int indiceUnique= (int) session.getAttribute("indicePartieUnique");
	    if (listePartie!=null) {
	    	indiceUnique = listePartie.indexOf(partiePerso);
		}
	    
	    partiePerso.setId(indiceUnique);
	    session.setAttribute("indicePartieUnique", indiceUnique);
	    application.setAttribute("listePartie", listePartie);
	    
	} else {
	    listeCodesErreur.add(CodesResultatServlets.COUT_PARTIE_INVALIDE);
	    request.setAttribute("listeCodesErreur", listeCodesErreur);
	}

	// on envoie les informations sur la jsp jouer
	
	
	RequestDispatcher rd = request.getRequestDispatcher(VUE);
	rd.forward(request, response);
    }
    
    /**
     * permet de calculer le montant du cout maximum de la partie à partir du paquet
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
	    // TODO Auto-generated catch block
	    e.printStackTrace();
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
