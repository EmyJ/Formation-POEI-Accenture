package fr.eni.fighters.servlets;

import java.io.IOException;
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

import fr.eni.fighters.bo.Bataille;
import fr.eni.fighters.bo.Jeu;
import fr.eni.fighters.bo.Partie;
import fr.eni.fighters.bo.User;

/**
 * Servlet implementation class TraitementCombat
 */
@WebServlet("/private/traitementCombat")
public class TraitementCombat extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VUE = "/WEB-INF/site/jouer.jsp";
    ServletContext application;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraitementCombat() {
	super();
	// TODO Auto-generated constructor stub
    }

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
	// TODO Auto-generated method stub
	RequestDispatcher rd = request.getRequestDispatcher(VUE);
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings({ "unchecked", "unlikely-arg-type" })
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User userCourant = (User) session.getAttribute("userCourant");

	String idParamPartie = request.getParameter("id_partie");
	int idPartie = Integer.parseInt(idParamPartie);
	List<Partie> listePartieEnCours = (List<Partie>) application.getAttribute("listePartieEnCours");
	Partie partieEnCours = null;
	for (Partie partie : listePartieEnCours) {
	    if (partie.getId() == idPartie) {
		partieEnCours = partie;
	    }
	}
	// request.getparameterValues car on a besoin du cout des cartes ET de l'arène A
	// ou B
	// ATTENTION A NE PAS CONFONDRE CARTE ET CASE
	String case0 = request.getParameter("carte0");
	String case1 = request.getParameter("carte1");
	String case2 = request.getParameter("carte2");

	List<Jeu> listeJeu = (List<Jeu>) application.getAttribute("listeJeu");
	Jeu jeuCourant = null;
	for (Jeu jeu : listeJeu) {
	    if (jeu.getIdPartie() == idPartie) {
		jeuCourant = jeu;
	    }
	}
	System.out.println(jeuCourant);
	Bataille batailleUser;
	Bataille batailleInvite;
	if (userCourant.getId() == partieEnCours.getId_user()) {
	    batailleUser = jeuCourant.getBatailleUser();
	    batailleUser.setCase0(case0);
	    batailleUser.setCase1(case1);
	    batailleUser.setCase2(case2);
	    jeuCourant.setBatailleUser(batailleUser);
	} else {
	    batailleInvite = jeuCourant.getBatailleInvite();
	    batailleInvite.setCase0(case0);
	    batailleInvite.setCase1(case1);
	    batailleInvite.setCase2(case2);
	    jeuCourant.setBatailleInvite(batailleInvite);
	}
	// on vérifie si jeuCourant est complet et si oui
	// les cartes s'affrontent
	if (jeuCourant.getBatailleInvite() != null && jeuCourant.getBatailleUser() != null) {
	    batailleUser = jeuCourant.getBatailleInvite();
	    batailleInvite = jeuCourant.getBatailleUser();
	    int compteurAUser = 0;
	    int compteurBUser = 0;
	    int compteurAInvite = 0;
	    int compteurBInvite = 0;

	    // on compte les points pour le User
	    if (batailleUser.getCarte0().equals("A")) {
		compteurAUser += batailleUser.getCarte0().getForce();
	    } else {
		compteurBUser += batailleUser.getCarte0().getForce();
	    }
	    if (batailleUser.getCarte1().equals("A")) {
		compteurAUser += batailleUser.getCarte1().getForce();
	    } else {
		compteurBUser += batailleUser.getCarte1().getForce();
	    }
	    if (batailleUser.getCarte2().equals("A")) {
		compteurAUser += batailleUser.getCarte2().getForce();
	    } else {
		compteurBUser += batailleUser.getCarte2().getForce();
	    }
	    // on compte les points pour l'Invite
	    if (batailleInvite.getCarte0().equals("A")) {
		compteurAInvite += batailleUser.getCarte0().getForce();
	    } else {
		compteurBInvite += batailleUser.getCarte0().getForce();
	    }
	    if (batailleUser.getCarte1().equals("A")) {
		compteurAInvite += batailleUser.getCarte1().getForce();
	    } else {
		compteurBInvite += batailleUser.getCarte1().getForce();
	    }
	    if (batailleUser.getCarte2().equals("A")) {
		compteurAInvite += batailleUser.getCarte2().getForce();
	    } else {
		compteurBInvite += batailleUser.getCarte2().getForce();
	    }

	    // on détermine qui gagne sur chaque arène et on gagne les points de l'arène le
	    // cas échéant
	    // Arene A
	    if (compteurAUser > compteurAInvite) {
		batailleUser.setVainqueurA(true);
		batailleUser.setPointsArene(jeuCourant.getPointsAreneA());
	    } else if (compteurAUser == compteurAInvite) {
		batailleUser.setVainqueurA(true);
		batailleInvite.setVainqueurA(true);
	    } else {
		batailleInvite.setVainqueurA(true);
		batailleInvite.setPointsArene(jeuCourant.getPointsAreneA());
	    }
	    // Arene B
	    if (compteurBUser > compteurBInvite) {
		batailleUser.setVainqueurB(true);
		batailleUser.setPointsArene(batailleUser.getPointsArene() + jeuCourant.getPointsAreneB());
	    } else if (compteurBUser == compteurBInvite) {
		batailleUser.setVainqueurB(true);
		batailleInvite.setVainqueurB(true);
	    } else {
		batailleInvite.setVainqueurB(true);
		batailleInvite.setPointsArene(batailleInvite.getPointsArene() + jeuCourant.getPointsAreneB());
	    }

	    // on détermine qui gagne la partie, les deux joueurs peuvent gagner
	    if (batailleUser.getPointsArene() > batailleInvite.getPointsArene()) {
		jeuCourant.setId_vainqueur(partieEnCours.getId_user());
	    } else if (batailleUser.getPointsArene() < batailleInvite.getPointsArene()) {
		jeuCourant.setId_vainqueur(partieEnCours.getId_invite());
	    } else {
		jeuCourant.setToutLeMondeGagne(true);
	    }

	    // être sûr d'avoir toutes les infos qu'on vient juste de traiter
	    jeuCourant.setBatailleUser(batailleUser);
	    jeuCourant.setBatailleInvite(batailleInvite);
	}

	listeJeu.add(jeuCourant);
	application.setAttribute("listeJeu", listeJeu);
	System.out.println("xftxrgfxcfgxfgy"+jeuCourant);

	doGet(request, response);
    }

}
