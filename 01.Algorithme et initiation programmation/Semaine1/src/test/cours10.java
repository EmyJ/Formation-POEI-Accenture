// TP question de multiplication aleatoire

package test;
import java.util.Random;
import java.util.Scanner;
public class cours10 {
	public static void main(String[] args) {
		final int MAX_MULTIPLICATION = 10;
		final int MAX = 10;
		Random rand = new Random();
		int a = rand.nextInt(MAX+1); // VALEUR COMPRISE ENTRE  et MAX
		int b = 1+rand.nextInt(MAX_MULTIPLICATION); // valeur entre 1 et MAX_MULTIPLICATION+1
		// final int RESULTAT = a*b; si constante
		Scanner scan = new Scanner(System.in);
			System.out.println("faites ce calcul : "+a+"*"+b+"=");
			int reponse = scan.nextInt();
			System.out.println("="+reponse);

		while (reponse!=a*b) { //while (reponse!=RESULTAT){  si constante
			System.out.print("perdu ");
			System.out.println("faites ce calcul : "+a+"*"+b+"=");                                                                                                                                                                                                                                                                                                                 
			reponse = scan.nextInt();
			}
		System.out.println("bravo");
		scan.close();
		}
}

