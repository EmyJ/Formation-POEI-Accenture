// TD CORRECTION
package test;

import java.util.Random;
import java.util.Scanner;

public class cours21 {
	public static final int MIN = 1;
	public static final int MAX = 49;
	public static final int NB_BOULES_TIREES = 6;
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int[] grilleDeLotoDuJoueur = new int[NB_BOULES_TIREES];
		System.out.println("Quels sont les 6 nombre choisis pour la grille ?");
		for (int i = 0; i < NB_BOULES_TIREES; i++) {
			boolean tirageNeConvientPas;
			do {
				// tire aleatoire une valeur entre MIN et MAX
				grilleDeLotoDuJoueur[i] = scan.nextInt();
				tirageNeConvientPas = grilleDeLotoDuJoueur[i] < MIN || grilleDeLotoDuJoueur[i] > MAX;
				int j = 0;
				while (j < i && tirageNeConvientPas == false) {
					if (grilleDeLotoDuJoueur[j] == grilleDeLotoDuJoueur[i]) {
						tirageNeConvientPas = true;
						System.out.println("vous avez deja choisi ce numero");
					}
					j++;
				}

			} while (tirageNeConvientPas);
		}
		scan.nextLine();
		System.out.println("Le joueur à choisi : ");
		for (int numerohoisi : grilleDeLotoDuJoueur) {
			System.out.println(numerohoisi);
		}
		System.out.println("Tirage...");
		int[] tirage = new int[NB_BOULES_TIREES];
		for (int indice = 0; indice < tirage.length; indice++) {
			boolean tirageNeConvientPas;
			do {
				// tire aleatoire une valeur entre MIN et MAX
				tirage[indice] = MIN + rand.nextInt(MAX - MIN + 1);
				System.out.println("tirage : " + tirage[indice]);
				tirageNeConvientPas = false;
				int j = 0;
				while (j < indice && tirageNeConvientPas == false) {
					if (tirage[j] == tirage[indice]) {
						tirageNeConvientPas = true;
						System.out.println(
								"nous avions tiré " + tirage[indice] + " mais cette valeur etait deja presente");
					}
					j++;
				}

			} while (tirageNeConvientPas);
		}
		for (int elem : tirage) {
			System.out.println(elem);
		}
		int cptBunNumeros = 0;
		for (int numeroChoisi : grilleDeLotoDuJoueur) {
			int j = 0;

			while (j < tirage.length && numeroChoisi != tirage[j]) {
				j++;
			}
			if (j < tirage.length) {
				cptBunNumeros++;
			}
		}
		System.out.println("vous avez " + cptBunNumeros + " bon(s) numéro(s)");
		/*
		 * int maximum = MIN; for (int valeur : tirage) { if (valeur > maximum) {
		 * maximum = valeur; System.out.println("nouveau champion" + valeur); } }
		 * System.out.println("le maximum est " + maximum);
		 */
	}
}
