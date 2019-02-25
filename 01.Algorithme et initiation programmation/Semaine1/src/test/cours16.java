// TP :: Procedure : affiche un message  nfois et affiche le plus grd des 2 chiffres donnés par utilisateur

package test;

import java.util.Scanner;

public class cours16 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		afficheNFois("bonjour", 6);
		System.out.println("saisissez 2 nbd reel");
		double v1 = scan.nextDouble();
		double v2 = scan.nextDouble();
		double max = maximum(v1, v2);
		scan.close();
		System.out.println("le maximum est " +max);
	}

public static void afficheNFois(String message, int n) {
	for (int i=1; i<=n ;i++) {
	System.out.println(message);
}
}
public static double maximum(double val1, double val2) {
	if (val1>val2)
	{
		return val1;
	}
	else {
		return val2;
	}
	}
}
