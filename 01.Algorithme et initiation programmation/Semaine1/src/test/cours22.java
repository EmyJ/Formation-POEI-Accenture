// TP correction nr de saisie par user 
package test;

import java.util.Scanner;

public class cours22 {

	public static void main(String[] args) {
		final int VAL_MAX = 10; // 10 exclue
		int[] nbOcc = new int[VAL_MAX];
		for (int i = 0; i < nbOcc.length; i++) {
			nbOcc[i] = 0;
		}
		System.out.println("saisissez des chiffre puis -1 pour quitter");
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		while (saisie != -1) {
			if (saisie < 0 || saisie >= VAL_MAX) {
				System.out.println("la valeur saisie doit etre comprise entre 0 et " + (VAL_MAX - 1));
			} else {
				nbOcc[saisie]++;
			}
			saisie = scan.nextInt();
		}
		scan.close();
		for (int i = 0; i < nbOcc.length; i++) {
			System.out.println("nombre de " + i + ":" + nbOcc[i] + "fois");
		}
	}

}
