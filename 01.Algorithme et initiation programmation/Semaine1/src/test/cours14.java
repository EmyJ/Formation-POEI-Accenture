// TP :: Procedure : affiche un message et un chiffre donné par utilisateur 

package test;
import java.util.Scanner;
public class cours14 {
static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		afficheNFois();
	}
public static void afficheNFois() {
	String message = saisiMessage();
	int chiffre = saisiChiffre();
	afficheInfo(message,chiffre);
}
public static String saisiMessage() {

	System.out.println("message ?");
	String message = scan.nextLine();
	return message;
}
public static int saisiChiffre() {
	
	System.out.println("chiffre ?");
	int chiffre = scan.nextInt();
	return chiffre;
}
public static void afficheInfo(String message, int chiffre) {
	System.out.println("Votre message : " + message + " et votre chiffre "+ chiffre);
}
}
