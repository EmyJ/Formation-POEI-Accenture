// BOUCLES WHILE

package test;
import java.util.Scanner;
public class cours7 {
	public static void main(String[] args) {
		System.out.println("Calculez 5+4");
		Scanner scan = new Scanner(System.in);
		int reponse = scan.nextInt();
		while (reponse !=9) {
			System.out.println("perdu");
			System.out.println("Calculez 5+4");
			reponse = scan.nextInt();
		}
		System.out.println("Bravo");
		scan.close();
}
}