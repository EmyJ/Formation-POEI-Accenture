package fr.eni.fighters.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import fr.eni.fighters.bo.Bataille;
import fr.eni.fighters.bo.Carte;
import fr.eni.fighters.bo.Jeu;
import fr.eni.fighters.bo.Partie;
import fr.eni.fighters.bo.User;

/**
 * Servlet implementation class Combat
 */
@WebServlet("/private/combat")
public class Combat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/site/combat.jsp";
	ServletContext application;
	Random rand = new Random();
	CarteMger carteMger = CarteMger.getCarteMger();

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		application = config.getServletContext();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = request.getRequestDispatcher(VUE);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//taper le code de traitement du combat
		
		//répartition des points de la partie aléatoirement entre les deux arènes
		//pour le joueur qui joue en dernier (créateur partie), le traitement ne doit pas être refait !!!
		String idParamPartie=request.getParameter("id_partie");
		int idPartie = Integer.parseInt(idParamPartie);
		List<Partie> listePartieEnCours = (List<Partie>) application.getAttribute("listePartieEnCours");
		Partie partieEnCours = null;
		for (Partie partie : listePartieEnCours) {
			if (partie.getId() == idPartie) {
				partieEnCours=partie;
			}
		}
		
		//On vérifie que les données du jeu n'existent pas : 
		//si elles existent on conserve les points des arenes sinon on répartit les points dans les arènes
		List<Jeu> listeJeu = (List<Jeu>) application.getAttribute("listeJeu");
	    if (listeJeu==null) {
	    	listeJeu = new ArrayList<Jeu>();
	    	application.setAttribute("listeJeu", listeJeu);
		}
	    Jeu jeuCourant = null;
	    boolean jeuExisteDeja = false;
	    for (Jeu jeu : listeJeu) {
			if (jeu.getIdPartie()==partieEnCours.getId()) {
				jeuCourant = jeu;
				jeuExisteDeja= true;
				break;
			}
		}

	   
	    if (!jeuExisteDeja) {
	    	int coutPartie = partieEnCours.getNbPoint();
	 	    int intBorneInf = 0;
	 		int intBorneSup = coutPartie;
			int pointsAreneA, pointsAreneB;
			//on attribue les points aléatoirement dans chaque arene
			pointsAreneA= rand.nextInt(intBorneSup-intBorneInf+1)+intBorneInf;
			pointsAreneB=coutPartie-pointsAreneA;
			Jeu jeu = new Jeu(partieEnCours.getId(), pointsAreneA, pointsAreneB);
			jeuCourant=jeu;
			//listeJeu.add(jeu);
		}
	    
		//répartion aléatoire des cartes du paquet du joueur
		//il faut récupérer le id du joueur en cours (si il a cliqué sur rejoindre id_invité et si il a cliqué sur jouer ma partie c'est id_user
		HttpSession session = request.getSession();
		User userCourant = (User) session.getAttribute("userCourant");
		List<Carte> listePaquet = null;
		try {
			listePaquet=carteMger.selectPaquet(userCourant.getId());
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//on choisit 3 cartes aléatoires parmi le paquet 
		
		Carte[] paquetTroisCartes = new Carte[3];
		int numero;
		for (int i = 0; i < 3; i++) {
			numero = rand.nextInt(listePaquet.size());
			paquetTroisCartes[i] = listePaquet.get(numero);
			listePaquet.remove(numero);
		}
		
		//on stocke dans les batailleUser/invite pour les traiter plus tard
		Bataille batailleUser = new Bataille();
		Bataille batailleInvite = new Bataille();
		if (userCourant.getId() == partieEnCours.getId_user()) {
			batailleUser.setId_joueur(userCourant.getId());
			batailleUser.setCarte0(paquetTroisCartes[0]);
			batailleUser.setCarte1(paquetTroisCartes[1]);
			batailleUser.setCarte2(paquetTroisCartes[2]);
		} else {
			batailleInvite.setId_joueur(userCourant.getId());
			batailleInvite.setCarte0(paquetTroisCartes[0]);
			batailleInvite.setCarte1(paquetTroisCartes[1]);
			batailleInvite.setCarte2(paquetTroisCartes[2]);
		}
		if (userCourant.getId() == partieEnCours.getId_user()) {
			jeuCourant.setBatailleUser(batailleUser);
		} else {
			jeuCourant.setBatailleInvite(batailleInvite);;
		}
		listeJeu.add(jeuCourant);
	
		//on envoie les données sur le plateau de jeu
		//session?application??
		application.setAttribute("listeJeu", listeJeu);
		session.setAttribute("paquetTroisCartes", paquetTroisCartes);
		session.setAttribute("partieEnCours", partieEnCours.getId());
		doGet(request, response);
	}

}
