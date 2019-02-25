// EXERCICE PERSO :: question de multiplication aleatoire

package test;

import java.util.Random;
import java.util.Scanner;

public class cours12 {

	public static void main(String[] args) {
		final int MAX = 10;
		final int MAX_M = 10;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int serie = 0;
		do {
			int a = rand.nextInt(MAX + 1);
			int b = 1 + rand.nextInt(MAX_M);
			int reponse = a * b;
			System.out.println("Calculez : " + a + "*" + b);
			reponse = scan.nextInt();
			System.out.println("=" + reponse);
			serie++;
			while (reponse != a * b) {
				System.out.println("perdu, recommencez");
				scan.nextInt();
			}
			System.out.println("super");
		} while (serie <= 4);
		System.out.println("Bravo vous avez gagnez");
		scan.close();
	}

}
