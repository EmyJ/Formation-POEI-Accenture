package test;

import java.util.Random;
import java.util.Scanner;

public class cours30 {

	public static final int NB_LIGNES = 4;
	public static final int NB_COLONNES = 4;
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// créer le plateau de jeu
		Terrain[][] plateauDeJeu = new Terrain[NB_LIGNES][NB_COLONNES];
		// commence par initialiser toutes les cases avec de la mer
		for (int j = 0; j < plateauDeJeu.length; j++) {
			for (int i = 0; i < plateauDeJeu[j].length; i++) {
				plateauDeJeu[j][i] = Terrain.MER;
			}
		}
		// sauf pour une case choisie aléatoirement qui est initialisé avec le bateau
		int ligne = rand.nextInt(NB_LIGNES);
		int colonne = rand.nextInt(NB_COLONNES);
		plateauDeJeu[ligne][colonne] = Terrain.BATEAU;

		do {
			// affiche le plateau de jeu
			afficher(plateauDeJeu);
			// saisie des coordonnées de tir
			ligne = saisieEntierEntreBornes(1, NB_LIGNES, "ligne ?") - 1;
			colonne = saisieEntierEntreBornes(1, NB_COLONNES, "colonne ?") - 1;
			// analyse le tir
			switch (plateauDeJeu[ligne][colonne]) {
			case BATEAU:
				plateauDeJeu[ligne][colonne] = Terrain.COULE;
				System.out.println("Victoire !");
				break;
			case MER:
				plateauDeJeu[ligne][colonne] = Terrain.PLOUF;
				System.out.println("Plouf ! Raté !");
				break;
			case COULE:
				System.out.println("Il ne sert à rien de tirer sur une épave !");
				break;
			case PLOUF:
				System.out.println("Re-Plouf ! Encore raté !");
				break;
			}
		} while (plateauDeJeu[ligne][colonne] != Terrain.COULE);
		afficher(plateauDeJeu);
	}

	public static void afficher(Terrain[][] plateau) {
		// affiche le plateau de jeu
		System.out.print(' ');
		for (int i = 0; i < plateau[0].length; i++) {
			System.out.print(i+1);
		}
		System.out.println();
		for (int j = 0; j < plateau.length; j++) {
			System.out.print(j+1);
			for (int i = 0; i < plateau[j].length; i++) {
				switch (plateau[j][i]) {
				case MER:
				case BATEAU:
					System.out.print('?');
					break;
				case PLOUF:
					System.out.print('~');
					break;
				case COULE:
					System.out.print('#');
					break;
				}
			}
			System.out.println();
		}
	}

	/**
	 * Demande à l'utilisateur de saisir une valeur entière comprise entre
	 * {@code min} et {@code max}
	 * 
	 * @param min
	 *            minimum acceptable (valeur incluse)
	 * @param max
	 *            maximum acceptable (valeur incluse)
	 * @param message
	 *            message à afficher pour inviter l'utilisateur à saisir
	 * @return la valeur saisie par l'utilisateur forcément comprise entre
	 *         {@code min} et {@code max}
	 */
	public static int saisieEntierEntreBornes(int min, int max, String message) {
		System.out.println(message);
		int j = scan.nextInt();
		while (j < min || j > max) {
			System.out.println("Veuillez saisir un nombre compris entre " + min + " et " + max);
			j = scan.nextInt();
		}
		return j;
	}
}