// BATAILLE NAVALE moi

/*
package test;

import java.util.Random;
import java.util.Scanner;

public class cours31 {
	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();
	public static final int NB_LIGNES = 4;
	public static final int NB_COLONNES = 4;

	public static void main(String[] args) {
		int monOrd , monAb =0;
		// initialisation du plateau de jeu et des possibilités de tir
		Tir[][] plateau = new Tir[NB_LIGNES][NB_COLONNES];
		for (monOrd = 0; monOrd < plateau.length; monOrd++) {
			for (monAb = 0; monAb < plateau[monOrd].length; monAb++) {
				plateau[monOrd][monAb] = Tir.MER;
			}
			}
		
		int ligne = rand.nextInt(NB_LIGNES);
		int colonne = rand.nextInt(NB_COLONNES);
		plateau[ligne][colonne] = Tir.BATEAU;
		
		// début du jeu
		System.out.println("Jeu de la Bataille Navale");
		System.out.println("Voici le plateau de Jeu");
		System.out.println();
		for ( monOrd = 0; monOrd < plateau.length; monOrd++) {
			for ( monAb = 0; monAb < plateau[monOrd].length; monAb++) {
				plateau[monOrd][monAb] = Tir.MER;
				System.out.print(" " + plateau[monOrd][monAb]);
			}
			System.out.println();
		}
		System.out.println();
		
		plateau[monOrd][monAb] = actionJoueur(Tir.plateau);

		
	}

	public static Tir[][] actionJoueur(Tir[][]plateau) {
		int monOrd , monAb =0;
		System.out.println("Où voulez vous tirer ? Donnez un chiffre entre 1 et 4 en absysse");
		 monAb = scan.nextInt() - 1;
		scan.nextLine();
		while (monAb < 0 || monAb >= plateau.length) {
			System.out.println("Ce choix est invalide !");
			System.out.println("Où voulez vous tirer ?");
			monAb = scan.nextInt() - 1;
			scan.nextLine();
		}
		System.out.println("Vous avez choisi " + (monAb + 1) + " en Absysse");

		System.out.println("Où voulez vous tirer ? Donnez un chiffre entre 1 et 4 en ordonnée");
		 monOrd = scan.nextInt() - 1;
		scan.nextLine();
		while (monOrd < 0 || monOrd >= plateau[0].length) {
			System.out.println("Ce choix est invalide !");
			System.out.println("Où voulez vous tirer ?");
			monOrd = scan.nextInt() - 1;
			scan.nextLine();
		}
		System.out.println("Vous avez choisi " + (monOrd + 1) + " en Ordonnée");
		System.out.println("*******");
		System.out.println("Vous tiré en case " + (monAb + 1) + " ; " + (monOrd + 1) + " ... suspence...");
		
		
		
		if (Tir.COULE == Tir.BATEAU) {
			System.out.println("Bravo");
			}
		System.out.println("Plouf");
		
	}
	}
*/