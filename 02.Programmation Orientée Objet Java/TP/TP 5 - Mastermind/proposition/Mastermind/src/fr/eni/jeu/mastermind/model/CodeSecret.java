package fr.eni.jeu.mastermind.model;

import java.util.Random;

/**
 * Représente le code couleur tiré au sort par l'ordinateur
 * @author bmartin
 *
 */
public class CodeSecret extends Code {

	public CodeSecret()
	{
		Random codSec = new Random();
		int i = 0;
		pions = new Pion[Code.NBPIONS];
		while (i < Code.NBPIONS) {
			pions[i++] = new Pion(codSec.nextInt(Pion.MAX_COULEURS));
		}
	}
}