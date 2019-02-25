package bonne_annee_2019;

import java.util.Scanner;

public class Exercice_6 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Création et remplissage du tableau
		float[] tablo = new float[5];
		for (int j = 0; j < tablo.length; j++) {
			System.out.println("saisir une note");
			float note = scan.nextFloat();

			tablo[j] = note;
		}
		
		//Calcul de la moyenne
		float moyenne = moyenne(tablo);
		System.out.println("La moyenne est de " + moyenne);

	}

	public static float moyenne(float[] tableau) {

		float somme = 0;
		float moyenne;

		for (int i = 0; i < tableau.length; i++) {
			somme += tableau[i];
		}

		moyenne = somme / tableau.length;

		return moyenne;
	}

}
