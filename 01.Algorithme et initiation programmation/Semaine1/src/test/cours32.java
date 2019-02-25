// chaines de caracteres String
package test;

import java.util.Scanner;
import java.util.Random;

public class cours32 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String message = "Bonjour";

		// tirage d'une lettre aleatoire
		Random rand = new Random();
		System.out.println("Lettre aléatoire : " + (char) ('a' + rand.nextInt(26)));
		System.out.println("Lettre aléatoire : " + (char) ('A' + rand.nextInt(26)));
		// (char) ('A'+r.nextInt('Z'-'A'+1));

		// retour à la ligne
		String message0 = "Bonjour " + System.lineSeparator() + " Jipé";
		System.out.println(message0);
		
		// minuscule
		System.out.println(message.toLowerCase());
		// majuscule
		System.out.println(message.toUpperCase());

		// Replace
		String nouveauMessage = message.replace('j', 's').replace('o', 'f').toUpperCase(); // remplace un caratere de
																							// message par un autre ici
																							// j par s et o par f et
																							// tout en majuscule
		System.out.println(nouveauMessage);

		// Saisie String + Replace et transformation String en Float
		System.out.println("saisir un chiffre à virgule");
		String saisie = scan.nextLine();
		String saisieModifiee = saisie.replace(',', '.');
		float valeur = Float.parseFloat(saisieModifiee);
		valeur += 10;
		System.out.println("valeur saisie + 10 = " + valeur);

		// comparaison String avec .equals
		String message2 = "Bonjour ";
		String autreMessage = "Bon" + "jour ";
		if (autreMessage.equals(message2)) {
			System.out.println(autreMessage.equals(message2));
		} else {
			System.out.println(autreMessage.equals(message2));
		}
		// ne pas faire ==
		if (autreMessage == message2) {
			System.out.println(autreMessage.equals(message2));
		} else {
			System.out.println(autreMessage.equals(message2));
		}
		System.out.println("saisir  : Bonjour");
		String message3 = scan.nextLine();
		if (message3.equals(message2)) {
			System.out.println(message3.equals(message2));
		} else {
			System.out.println(message3.equals(message2));
		}
		if (message3 == message2) {
			System.out.println(message3 == message2);
		} else {
			System.out.println(message3 == message2);
		}
		scan.close();

		// LENGTH
		System.out.println("nbr de caractere : " + message + " - " + message.length());
		// CharAt()
		char c = message.charAt(0);
		System.out.println("le message commence par " + c);
		c = message.charAt(message.length() - 1);
		System.out.println("le message termine par " + c);

		// recup un char issu de string
		String s;
		do {
			System.out.println("Répondez par o pour oui ou n pour non");
			s = scan.nextLine().toLowerCase();
		} while (s.length() != 1);
		char d = s.charAt(0);
		if (d == 'o') {
			System.out.println("Il a répondu OUI");
		} else if (d == 'n') {
			System.out.println("Il a répondu NON");
		} else {
			System.out.println("Il a répondu n'importe quoi !");
		}
		// ou
		System.out.println("Répondez par o pour oui ou n pour non");
		scan.nextLine().toLowerCase().charAt(0); // on recup le char 0 du string et on le passe en lower case au cas ou
													// il a ecrit en capital

		// substring
		String fin = message.substring(3);
		System.out.println("fin de la chaine : " + fin);

		String partie = message.substring(3, 5); // substring (caractere de debut (caractere de fin)
		System.out.println("fin de la chaine : " + partie);

		// trim enleve les espace superflux avant et apres la chaine de caracteres
		String avecEspacesSuperFlux = "     Hello !   1  2    ";
		System.out.println("*" + avecEspacesSuperFlux + "*");
		System.out.println("*" + avecEspacesSuperFlux.trim() + "*");
	}

}
