package test;

import java.util.Random;
import java.util.Scanner;

public class cours23 {
	public static final int STOP = -1;
	public static final int TAILLE = 10;
	public static final int VAL_MAX = 10;
	public static final int VAL_MIN = 10;
	public static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		int[] tablo = new int[TAILLE];
		// for (int indice : tablo) {
		// System.out.println(indice);
		// }
		for (int i = 0; i < tablo.length; i++) {
			// tablo[i] = 1 + rand.nextInt(20 - 1 + 1);

			tablo[i] = 0;
			System.out.println(tablo[i]);
		}
		System.out.println("saisissez des chiffre puis -1 pour quitter");
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		while (saisie != STOP) {
			if (saisie < VAL_MIN || saisie >= VAL_MAX) {
				System.out.println("la valeur n'est pas comprise entre 0 et 9");

			} else {
				tablo[saisie]++; // tablo[saisie] = tablo[saisie] +1;
			}
			saisie = scan.nextInt();
		}
		scan.close();
		for (int j=0; j<tablo.length; j++) {
			System.out.println("nbr de " + j+ "-" +tablo[j] + "fois");
		}
	}

}
