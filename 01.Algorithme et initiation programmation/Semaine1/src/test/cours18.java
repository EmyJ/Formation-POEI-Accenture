// TP CORRECTION Cours17
package test;

import java.util.Random;
import java.util.Scanner;

public class cours18 {
	public static Random rand = new Random ();
	public static final int APPRENDRE = 1;
	public static final int TESTER = 2;
	public static final int QUITTER = 3;
	public static final int MIN = 0;
	public static final int MAX = 10;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int choix;
		do {
			choix = menu();
			switch (choix) {
			case APPRENDRE:
				afficherTables();
				break;
			case TESTER:
				testerConnaissances();
				break;
			}
		} while (choix != QUITTER);
		System.out.println("Au revoir");
		scan.close();
	}

	public static void testerConnaissances() {
		int nbBonnesReponsesDeSuite = 0;
		System.out.println("Quel objectif vous fixer-vous comme nombre de bonnes réponses de suite ?");
		int objectif = scan.nextInt();
		scan.nextLine();
		System.out.println("Quel est la plus grande table de multipication que vous connaissez ?");
		int tableMax = scan.nextInt();
		scan.nextLine();
		int val1, val2;
		do {
			val1 = rand.nextInt (MAX-MIN+1)+ MIN; // tirage d'une valeuraleatoire entre MIN et MAX (incluses)
			val2 =  rand.nextInt (tableMax)+1; // tirage d'une valeur comprise entre 1 et tableMax (incluses)
			System.out.print(val1 + "x" + val2 + "=");
			int reponse=scan.nextInt();
			scan.nextLine();
			while (reponse != val1*val2) {
				System.out.println("Faux !");
				nbBonnesReponsesDeSuite = 0;
				System.out.print(val1 + "x" + val2 + "=");
				reponse=scan.nextInt();
				scan.nextLine();
			}
			nbBonnesReponsesDeSuite++;
		System.out.println("Bien ! ( "+ nbBonnesReponsesDeSuite +"/" + objectif + ")" );
		}while (nbBonnesReponsesDeSuite < objectif);
		
	}

	public static void afficherTables() {
		System.out.println("Quelle table de multiplication souhaitez vous afficher ?");
		int table = scan.nextInt();
		scan.nextLine();
		afficherTable(table);
	}

	public static void afficherTable(int table) {
		System.out.println(" *** Table de " + table + "***");
		for (int i = MIN; i <= MAX; i++) {
			System.out.println(i + "x" + table + "=" + i * table);
		}

	}
/**
 * Affiche le menu du programme et retourne le numero de l'element du menu choisi
 * l'utilisateur devra saisir jusqu'à ce que la valeur soit correcte
 * @return le numéro de l'element de menu choisi
 * */
	public static int menu() {
		;
		System.out.println(APPRENDRE + " - Afficher les tables de multiplication");
		System.out.println(TESTER + " - Tester vos connaissance");
		System.out.println(QUITTER + " - Quitter");
		int saisie = scan.nextInt();
		scan.nextLine();
		while (saisie != APPRENDRE && saisie != TESTER && saisie != QUITTER) {
			System.out.println("La saisie est incorrecte, Veuillez saisir " + APPRENDRE + "," + TESTER + "," + QUITTER);
			saisie = scan.nextInt();
			scan.nextLine();
		}
		return saisie;
	}
}
