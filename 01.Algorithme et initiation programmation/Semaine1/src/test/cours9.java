// TP saisissez un chiffre entre 1 et 10 (Table de multiplication)

package test;
import java.util.Scanner;
public class cours9 {
	public static void main(String[] args) {
		final int MAX_MULTIPLICATION = 10;
		System.out.println("saisissez un chiffre entre 1 et 10");
		Scanner scan = new Scanner(System.in);
		int reponse = scan.nextInt();
		System.out.println("Table de "+reponse);
		for (int k = 0; k <= MAX_MULTIPLICATION ; k++) {
			System.out.println(k +"*"+ reponse+"="+k*reponse);
		}
		scan.close();
}
}