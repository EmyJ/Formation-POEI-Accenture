// ECRIRE UN PROGRAMME POUR PASSER COMMANDE DANS UN RESTO
package test;

import java.util.Scanner;

public class cours27 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// mes enumérations
		Formules[] choixFormule = Formules.values();
		Entrees[] choixEntree = Entrees.values();
		Plats[] choixPlat = Plats.values();
		Cuisson[] choixCuisson = Cuisson.values();
		Desserts[] choixDessert = Desserts.values();
		
		// initialisation de variable 
		Entrees e = null;
		Plats p = null;
		Cuisson c = null;
		Desserts d = null;
		// Choix de la formule
		System.out.println("Quelle formule voulez vous ?");
		for (Formules maFormule : Formules.values()) {
			System.out.println(maFormule.ordinal() + 1 + "-" + maFormule.name());
		}
		int maFormule = scan.nextInt() - 1;
		scan.nextLine();

		while (maFormule < 0 || maFormule > choixFormule.length) {
			System.out.println("Ce choix est invalide !");
			System.out.println("Quelle formule voulez vous ?");
			maFormule = scan.nextInt() - 1;
			scan.nextLine();
		}
		Formules f = choixFormule[maFormule];
		System.out.println("Vous avez choisi : " + f);

		// Selection des choix du client selon sa formule

		if (f == Formules.ENTREE_PLAT || f == Formules.ENTREE_PLAT_DESSERT) {
			// Choix de l'entrée
			System.out.println("Choisissez votre Entrée :");
			for (Entrees monEntree : Entrees.values()) {
				System.out.println(monEntree.ordinal() + 1 + "-" + monEntree.name());
			}
			int monEntree = scan.nextInt() - 1;
			scan.nextLine();
			while (monEntree <= 0 || monEntree >= choixEntree.length) {
				System.out.println("Ce choix est invalide !");
				System.out.println("Quelle entrée voulez vous ?");
				monEntree = scan.nextInt() - 1;
				scan.nextLine();
			}
			e = choixEntree[monEntree];
			System.out.println("Vous avez choisi l'Entrée : " + e);
		}
		if (f == Formules.ENTREE_PLAT || f == Formules.PLAT_DESSERT || f == Formules.ENTREE_PLAT_DESSERT) {
			// Choix du plat
			System.out.println("Choisissez votre Plat :");
			for (Plats monPlat : Plats.values()) {
				System.out.println(monPlat.ordinal() + 1 + "-" + monPlat.name());
			}
			int monPlat = scan.nextInt() - 1;
			scan.nextLine();
			while (monPlat <= 0 || monPlat >= choixPlat.length) {
				System.out.println("Ce choix est invalide !");
				System.out.println("Quelle plat voulez vous ?");
				monPlat = scan.nextInt() - 1;
				scan.nextLine();
			}
			p = choixPlat[monPlat];
			System.out.println("Vous avez choisi le plat : " + p);
			//choix de la cuisson si Steack
			if (p == Plats.STEACK) {
				System.out.println("Choisissez la cuisson de votre steack :");
				for (Cuisson maCuisson : Cuisson.values()) {
					System.out.println(maCuisson.ordinal() + 1 + "-" + maCuisson.name());
				}
				int maCuisson = scan.nextInt() - 1;
				scan.nextLine();
				while (maCuisson <= 0 || maCuisson >= choixCuisson.length) {
					System.out.println("Ce choix est invalide !");
					System.out.println("Quelle Cuisson voulez vous ?");
					monPlat = scan.nextInt() - 1;
					scan.nextLine();
				}
				c = choixCuisson[maCuisson];
				System.out.println("Vous avez choisi la cuisson : " + c);				
			}
		} 
		if (f == Formules.PLAT_DESSERT || f == Formules.ENTREE_PLAT_DESSERT) {
			// Choix du dessert
			System.out.println("Choisissez votre Dessert :");
			for (Desserts monDessert : Desserts.values()) {
				System.out.println(monDessert.ordinal() + 1 + "-" + monDessert.name());
			}
			int monDessert = scan.nextInt() - 1;
			scan.nextLine();
			while (monDessert <= 0 || monDessert >= choixDessert.length) {
				System.out.println("Ce choix est invalide !");
				System.out.println("Quel dessert voulez vous ?");
				monDessert = scan.nextInt() - 1;
				scan.nextLine();
			}
			d = choixDessert[monDessert];
			System.out.println("Vous avez choisi le dessert : " + d);
		}
		// a faire condition de recapitulatif
		if (f == Formules.ENTREE_PLAT)
		System.out.println("Votre Commande : vous avez choisis la formule " +f+ " Comprenant "+ e + " , " + p + "(" + c + ")" );
		if (f == Formules.ENTREE_PLAT_DESSERT)
			System.out.println("Votre Commande : vous avez choisis la formule " +f+ " Comprenant "+ e + " , " + p + "(" + c + ")" + " , " +d);
		if (f == Formules.PLAT_DESSERT)
			System.out.println("Votre Commande : vous avez choisis la formule " +f+ " Comprenant " + p + "(" + c + ")" + " , " +d);
			scan.close();
	}
}