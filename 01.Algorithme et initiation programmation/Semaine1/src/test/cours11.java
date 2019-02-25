// TP question de multiplication aleatoire

package test;

import java.util.Random;
import java.util.Scanner;

public class cours11 {
	public static void main(String[] args) {
		final int MAX_MULTIPLICATION = 10;
		final int MAX = 10;
		final int NBSERIE = 10;
		Random rand = new Random();
		int serie = 0;
		Scanner scan = new Scanner(System.in);
		// final int RESULTAT = a*b; si constante
		do {
			int a = rand.nextInt(MAX + 1); // VALEUR COMPRISE ENTRE et MAX
			int b = 1 + rand.nextInt(MAX_MULTIPLICATION); // valeur entre 1 et MAX_MULTIPLICATION+1
			
			System.out.println("faites ce calcul : " + a + "*" + b + "=");
			int reponse = scan.nextInt();
			System.out.println("=" + reponse);

			while (reponse != a * b) { // while (reponse!=RESULTAT){ si constante
				serie = 0;
				System.out.print("perdu ");
				System.out.println("faites ce calcul : " + a + "*" + b + "=");
				reponse = scan.nextInt();
			}
			serie++;
			System.out.println(serie + "/" + NBSERIE);
			System.out.println("bravo");
		} while (serie < NBSERIE);
		scan.close();
	}
}
