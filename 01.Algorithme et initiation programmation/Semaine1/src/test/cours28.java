// TP Correction menu resto

package test;

import java.util.Scanner;

public class cours28 {
public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Quelle formule souhaitez-vous ?");
		Formules[] formulesPossibles = Formules.values();
		for(int i=0; i<formulesPossibles.length; i++) {
			System.out.println((i+1)+" - "+formulesPossibles[i].name());
		}
		int numFormule = scan.nextInt() - 1;
		while(numFormule<0 || numFormule>=formulesPossibles.length) {
			System.out.println("Saisie erronnée. Saisissez une valeur comprise entre 1 et "+formulesPossibles.length);
			numFormule = scan.nextInt() - 1;
		}
		Formules formuleChoisie = formulesPossibles[numFormule];
		
		
		Entrees entreeChoisie = null;
		Plats platChoisi = null;
		Desserts dessertChoisi = null;
		Cuisson cuissonChoisie = null;
		switch (formuleChoisie) {
		case ENTREE_PLAT_DESSERT:
			entreeChoisie = choixEntree();
		case PLAT_DESSERT:
			platChoisi = choixPlat();
			dessertChoisi = choixDessert();		
			break;
		case ENTREE_PLAT:
			entreeChoisie = choixEntree();
			platChoisi = choixPlat();
			break;
		}
		if(platChoisi == Plats.STEACK) {
			cuissonChoisie = choixCuisson();
		}
		
		System.out.println("Voici ce qui a été commandé :");
		System.out.println("Vous avez choisi la formule "+formuleChoisie.name());
		if(formuleChoisie == Formules.ENTREE_PLAT ||
				formuleChoisie == Formules.ENTREE_PLAT_DESSERT) {
			System.out.println("Entrée : "+entreeChoisie.name());
		}
		System.out.print("Plat : "+platChoisi.name());
		if(platChoisi == Plats.STEACK) {
			System.out.println(" (cuisson : "+cuissonChoisie.name()+")");
		} else {
			System.out.println();
		}
		if(formuleChoisie == Formules.PLAT_DESSERT ||
				formuleChoisie == Formules.ENTREE_PLAT_DESSERT) {
			System.out.println("Dessert : "+dessertChoisi.name());
		}
	}

	public static Cuisson choixCuisson() {
		System.out.println("Quelle cuisson souhaitez-vous ?");
		Cuisson[] cuissonsPossibles = Cuisson.values();
		for(int i=0; i<cuissonsPossibles.length; i++) {
			System.out.println((i+1)+" - "+cuissonsPossibles[i].name());
		}
		int numCuisson = scan.nextInt() - 1;
		while(numCuisson<0 || numCuisson>=cuissonsPossibles.length) {
			System.out.println("Saisie erronnée. Saisissez une valeur comprise entre 1 et "+cuissonsPossibles.length);
			numCuisson = scan.nextInt() - 1;
		}
		return cuissonsPossibles[numCuisson];
	}

	public static Desserts choixDessert() {
		System.out.println("Quel dessert souhaitez-vous ?");
		Desserts[] dessertsPossibles = Desserts.values();
		for(int i=0; i<dessertsPossibles.length; i++) {
			System.out.println((i+1)+" - "+dessertsPossibles[i].name());
		}
		int numDessert = scan.nextInt() - 1;
		while(numDessert<0 || numDessert>=dessertsPossibles.length) {
			System.out.println("Saisie erronnée. Saisissez une valeur comprise entre 1 et "+dessertsPossibles.length);
			numDessert = scan.nextInt() - 1;
		}
		return dessertsPossibles[numDessert];
	}

	public static Plats choixPlat() {
		System.out.println("Quel plat souhaitez-vous ?");
		Plats[] platsPossibles = Plats.values();
		for(int i=0; i<platsPossibles.length; i++) {
			System.out.println((i+1)+" - "+platsPossibles[i].name());
		}
		int numPlat = scan.nextInt() - 1;
		while(numPlat<0 || numPlat>=platsPossibles.length) {
			System.out.println("Saisie erronnée. Saisissez une valeur comprise entre 1 et "+platsPossibles.length);
			numPlat = scan.nextInt() - 1;
		}
		return platsPossibles[numPlat];
	}

	public static Entrees choixEntree() {
		System.out.println("Quelle entrée souhaitez-vous ?");
		Entrees[] entreesPossibles = Entrees.values();
		for(int i=0; i<entreesPossibles.length; i++) {
			System.out.println((i+1)+" - "+entreesPossibles[i].name());
		}
		int numEntree = scan.nextInt() - 1;
		while(numEntree<0 || numEntree>=entreesPossibles.length) {
			System.out.println("Saisie erronnée. Saisissez une valeur comprise entre 1 et "+entreesPossibles.length);
			numEntree = scan.nextInt() - 1;
		}
		return entreesPossibles[numEntree];
	}

}
