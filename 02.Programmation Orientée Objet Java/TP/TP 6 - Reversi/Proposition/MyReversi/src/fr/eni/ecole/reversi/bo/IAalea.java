package fr.eni.ecole.reversi.bo;

import java.util.Random;

/**
 * Classe en charge de 
 * @date 26 sept. 2018
 * @version POO - V1.0
 * @author hboisgontier
 *
 */
public class IAalea implements Joueur {
	
	private static Random r = new Random();

	/** 
	 * {@inheritDoc}
	 * @see fr.eni.ecole.reversi.Joueur#jouer(fr.eni.ecole.reversi.PlateauDeReversi)
	 */
	@Override
	public int[] jouer(PlateauDeReversi p, Pion couleur) {
		int[] coord = new int[2];
		do {
			coord[LIGNE] = r.nextInt(PlateauDeReversi.TAILLE);
			coord[COLONNE] = r.nextInt(PlateauDeReversi.TAILLE);
		} while(p.tester(couleur, coord[LIGNE], coord[COLONNE])==0);
		return coord;
	}

	/** 
	 * {@inheritDoc}
	 * @see fr.eni.ecole.reversi.Joueur#getNom()
	 */
	@Override
	public String getNom() {
		return "IA Aléatoire";
	}

}
