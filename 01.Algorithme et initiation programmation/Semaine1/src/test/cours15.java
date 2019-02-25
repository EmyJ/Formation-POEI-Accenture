// TP :: utilisateur choisi deuxx nombre et le programme affiche le  plus grd

package test;

import java.util.Scanner;

public class cours15 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		affichePlusGrd();
	}
	public static void affichePlusGrd() {
		int chiffre1 = saisiChiffre1();
		int chiffre2 = saisiChiffre2();
		afficheInfo(chiffre1,chiffre2);
	}
	public static int saisiChiffre1() {
		
		System.out.println("chiffre 1 ?");
		int chiffre1 = scan.nextInt();
		return chiffre1;
	}
	public static int saisiChiffre2() {
		
		System.out.println("chiffre 2 ?");
		int chiffre2 = scan.nextInt();
		return chiffre2;
	}
	public static void afficheInfo(int chiffre1, int chiffre2) {
		if (chiffre1 > chiffre2)
		System.out.println(chiffre1);
		else if (chiffre1 < chiffre2) 
			System.out.println(chiffre2);
		else if (chiffre1 == chiffre2)
			System.out.println(chiffre1);
	}
}
