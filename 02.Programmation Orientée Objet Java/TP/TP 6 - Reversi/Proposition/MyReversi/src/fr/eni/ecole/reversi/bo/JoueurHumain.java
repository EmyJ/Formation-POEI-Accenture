package fr.eni.ecole.reversi.bo;

import fr.eni.ecole.reversi.util.Outils;

/**
 * Classe en charge de
 * 
 * @date 26 sept. 2018
 * @version POO - V1.0
 * @author hboisgontier
 *
 */
public class JoueurHumain implements Joueur {

	private String nom;

	/**
	 * Constructeur
	 */
	public JoueurHumain() {
		this.nom = Outils.saisie("Nom du joueur ?");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni.ecole.reversi.Joueur#jouer(fr.eni.ecole.reversi.PlateauDeReversi)
	 */
	@Override
	public int[] jouer(PlateauDeReversi p, Pion couleur) {
		int[] coordonnees = new int[2];
		coordonnees[LIGNE] = Outils.saisie("ligne", 1, PlateauDeReversi.TAILLE) - 1;
		coordonnees[COLONNE] = Outils.saisie("colonne", 1, PlateauDeReversi.TAILLE) - 1;
		return coordonnees;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni.ecole.reversi.Joueur#getNom()
	 */
	@Override
	public String getNom() {
		return this.nom;
	}
}
