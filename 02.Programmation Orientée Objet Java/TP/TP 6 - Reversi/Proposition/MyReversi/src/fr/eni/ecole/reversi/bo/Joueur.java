package fr.eni.ecole.reversi.bo;

/**
 * Interface représentant un joueur pour le Reversi
 * 
 * @date 26 sept. 2018
 * @version POO - V1.0
 * @author hboisgontier
 *
 */
public interface Joueur {
	static final int LIGNE = 0;
	static final int COLONNE = 1;

	/**
	 * Méthode retourant les coordonnées où le joueur souhaite positionner son
	 * pion
	 * 
	 * @param p
	 *            le plateau de jeu (la seule méthode d'instance publique qu'il
	 *            est possible d'appeler est la méthode tester() indiquant la
	 *            possibilité de poser son pion et le gain associé).
	 * @param couleur
	 *            la couleur du pion du joueur
	 * @return un couple de coordonnées
	 */
	int[] jouer(PlateauDeReversi p, Pion couleur);

	/**
	 * Donne le nom du joueur
	 * @return le nom du joueur
	 */
	String getNom();
}
