package fr.eni.ecole.reversi.bo;

import fr.eni.ecole.reversi.util.Outils;

public enum Pion {
	LIBRE, BLANC, NOIR;

	private int nbPions;

	// joueur associé à cette couleur
	private Joueur joueur;

	private Pion() {
		nbPions = 2;
	}

	public char getSymbole() {
		char c;
		switch (this) {
		case BLANC:
			c = 'o';
			break;
		case NOIR:
			c = '●';
			break;

		default:
			c = '·';
			break;
		}
		return c;
	}

	public Pion autrePion() {
		Pion autre;
		switch (this) {
		case BLANC:
			autre = NOIR;
			break;
		case NOIR:
			autre = BLANC;
			break;
		default:
			autre = LIBRE;
			break;
		}
		return autre;
	}

	public void gagne(int nbPionsChangeCouleur) {
		// nbPionsChangeCouleur + celui qui a été posé
		nbPions += nbPionsChangeCouleur + 1;
		// adversaire perd ses pions
		autrePion().nbPions -= nbPionsChangeCouleur;
	}

	public int getNbPions() {
		return nbPions;
	}

	public void choixJoueur() {
		String m = String.format("Quel joueur pour les pions %s ?%n 1 - Humain%n 2 - Ordinateur", this.getSymbole());
		int c = Outils.saisie(m, 1, 2);
		if (c == 1)
			this.joueur = new JoueurHumain();
		else
			this.joueur = new IAalea();
	}

	public Joueur getJoueur() {
		return joueur;
	}
}
