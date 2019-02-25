// SWITCH - CASE

package test;

import java.util.Scanner;

public class cours4 {

	public static void main(String[] args) {
		System.out.println("Choisissez un chiffre entre 1et 10");
		Scanner scan = new Scanner(System.in);
		int nombre = scan.nextInt();
		scan.nextLine();
		switch (nombre) {
		case 4:
		case 6:
			System.out.print("ce chiffre est un carré parfait et ");
		case 2:
		case 8:
		case 10:
			System.out.println("le chiffre est pair");
			break;
		case 9:
			System.out.print("ce chiffre est un carré parfait et ");
		case 1:
		case 3:
		case 5:
		case 7:
			System.out.println("le chiffre est impair");
			break;
		}

		scan.close();
	}

}
