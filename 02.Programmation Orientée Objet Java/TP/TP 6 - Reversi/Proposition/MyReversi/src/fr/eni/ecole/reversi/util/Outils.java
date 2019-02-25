package fr.eni.ecole.reversi.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilitaire proposant des méthodes simplifiant la saisie de valeurs de
 * l'utilisateur sur la console et la génération de valeurs aléatoires
 * 
 * @date 4 juil. 2018
 * @version Outils - V1.0
 * @author hboisgontier
 *
 */
public class Outils {
	private static Scanner s = new Scanner(System.in);

	/**
	 * Fait saisir à l'utilisateur une valeur comprise entre les valeurs
	 * {@code min} et {@code max} passées en paramètre. En cas d'erreur,
	 * l'utilisateur devra ressaisir jusqu'à ce que la valeur soit correcte.
	 * 
	 * @param message
	 *            message à afficher à l'utilisateur pour l'inviter à saisir
	 * @param min
	 *            valeur minimale acceptable (incluse)
	 * @param max
	 *            valeur maximale acceptable (incluse)
	 * @return la valeur saisie par l'utilisateur
	 */
	public static int saisie(String message, int min, int max) {
		System.out.printf("%s ", message);
		int val = 0;
		boolean ok;
		do {
			try {
				val = Outils.s.nextInt();
				ok = val >= min && val <= max;
			} catch (InputMismatchException e) {
				ok = false;
			} finally {
				Outils.s.nextLine();
			}
			if (!ok)
				System.err.printf("La valeur doit être un entier compris entre %d et %d%nRessaisissez... ", min, max);
		} while (!ok);
		assert val >= min && val <= max;
		return val;
	}

	public static String saisie(String message) {
		System.out.println(message);
		return Outils.s.nextLine();
	}
}
