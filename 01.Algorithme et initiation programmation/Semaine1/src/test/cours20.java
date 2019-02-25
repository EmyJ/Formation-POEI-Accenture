//TP
package test;

import java.util.Random;
import java.util.Scanner;

public class cours20 {
	static final int MIN = 1;
	static final int MAX = 49;
	public static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int valMax = MIN;
		int[] tableau = new int[6];
		for (int indice = 0; indice < tableau.length; indice++) {
			tableau[indice] = MIN + rand.nextInt(MAX - MIN + 1);
			System.out.println(tableau[indice]);
		}
		for (int val : tableau) {
			if (valMax < val) {
				valMax = val;
			}
			System.out.println(valMax);
		}

		int[] tableauUser = new int[6];
		for (int i = 0; i < tableauUser.length; i++) {
			System.out.println("donner vos numero");
			int saisie = scan.nextInt();
			scan.nextLine();
			tableauUser[i] = saisie;
		}

	}
	
}
