// FONCTION
/**
 * @author Administrateur
 * @version
 */
package test;

import java.util.Scanner;

public class cours13 {
	public static void main(String[] args) {
		salutation();

	}
/**
 * Salue un utilisateur par son prénom
 * salue l'utilisateur par son prénom apres le lui avoir demandé
 */
	public static void salutation() {
		String prenomDeLUtilisaeur = saisirPrenom();
		afficherSalutation(prenomDeLUtilisaeur);
	}

	// fonction qui ne prends pas de parametre et qui retourne une chaine de
	// caracteres
	/** 
	 * Demande à l'utilisateur son prénom
	 * @return le prénom de l'utilisateur
	 */
	public static String saisirPrenom() {
		Scanner scan = new Scanner(System.in);
		System.out.println("prenom ?");
		String prenom = scan.nextLine();
		scan.close();
		return prenom;
	}
/**
 * Affiche un message de sautation personnalisé
 * @param nomDeLaPersonne nom de la personne à saluer 
 * */
	public static void afficherSalutation(String nomDeLaPersonne) {
		System.out.println("Bonjour " + nomDeLaPersonne + "!");
	}
}