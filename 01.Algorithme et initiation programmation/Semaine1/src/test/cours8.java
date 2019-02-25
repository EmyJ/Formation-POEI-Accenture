// TP saisir un chiffre entre 2 et 10

package test;

import java.util.Scanner;

public class cours8 {
	public static void main(String[] args) {
		final int MIN =2;
		final int MAX = 10;
		System.out.println("saisissez un chiffre entre 2 et 10");
		Scanner scan = new Scanner(System.in);
		int reponse = scan.nextInt();
		while (reponse < MIN || reponse > MAX) {
			System.out.println("perdu");
			System.out.println("recommencer");
			reponse = scan.nextInt();
		}
		System.out.println("bravo");
		scan.close();
	}
}