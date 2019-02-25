package bonnannee2019;

import java.util.Scanner;

public class exercice5 {

	public static final float PI=3.14f;
	
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		System.out.println("Veuillez entrer votre temps de parcours en heures");
		float saisieHeure = saisie.nextInt();
		System.out.println("Veuillez entrer votre temps de parcours en minutes");	
		float saisieMinute = saisie.nextInt();
		System.out.println("Veuillez entrer le nombre de Kms");	
		int saisieKm = saisie.nextInt();
		saisie.close();
		Calcul(saisieHeure,saisieMinute,saisieKm);

	}
	
	public static void Calcul(float saisieHeure, float saisieMinute,int km) {
		float temps = (saisieHeure * 60) + saisieMinute;
		float vitesseMoyenne = km/(temps/60);
		System.out.println(String.format("%4.2f",vitesseMoyenne) + " km/h");
		
	}
	
}
