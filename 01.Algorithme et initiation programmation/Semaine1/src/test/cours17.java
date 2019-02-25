// TP :: faire un menu avec divers fonction puis retour au menu
package test;

import java.util.Random;
import java.util.Scanner;

public class cours17 {
	final int MAX = 10;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int choix = menu();
		if (choix == 1) {
			afficherTable();
		} else if (choix == 2) {
			testerConnaissances();
		}

		else if (choix == 3) {
			System.out.println("Au revoir");
			scan.close();
		}
	}

	public static int menu() {
		System.out.println("1 Apprendre table de multiplication");
		System.out.println("2 Tester ses connaisances");
		System.out.println("3 Quitter");

		int choix = scan.nextInt();
		scan.nextLine();
		while (choix < 1 || choix > 3) {
			System.out.println("recommencer");
			choix = scan.nextInt();
		}
		return choix;
	}

	public static int afficherTable() {

		System.out.println("Quelle table de multiplication souhaitez vous afficher ?");
		int reponse = scan.nextInt();
		System.out.println("Table de " + reponse);
		for (int k = 0; k <= 10; k++) {
			System.out.println(k + "*" + reponse + "=" + k * reponse);
		}
		System.out.println(" retour menu : 1- oui ou 2- non");
		int retourMenu = scan.nextInt();
		while (retourMenu == 1) {

			return menu();
		}
		return afficherTable();
	}

	public static int testerConnaissances() {
		Random rand = new Random();
		int a = rand.nextInt(10);
		int b = 1 + rand.nextInt(10);
		System.out.println("faites ce calcul : " + a + "*" + b + "=");
		int reponse = scan.nextInt();
		System.out.println("=" + reponse);
		while (reponse != a * b) { // while (reponse!=RESULTAT){ si constante
			System.out.print("perdu ");
			System.out.println("faites ce calcul : " + a + "*" + b + "=");
			reponse = scan.nextInt();
		}
		System.out.println("bravo");
		System.out.println(" retour menu : 1- oui ou 2- non");
		int retourMenu = scan.nextInt();
		while (retourMenu == 1) {

			return menu();
		}
		return testerConnaissances();
	}


}
