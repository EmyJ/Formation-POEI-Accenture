// ENUMERATION lié avec jours
package test;

import java.util.Scanner;

public class cours26 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Quel jour sommes nous ?");
		Jours[] lesJoursDeLaSemaine = Jours.values();
		for (Jours jo : Jours.values()) {
			System.out.println(jo.ordinal() + 1 + "-" + jo.name());
		}

		int numeroJour = scan.nextInt()-1;
		scan.close();
		
		
		
		Jours j = lesJoursDeLaSemaine[numeroJour];
		System.out.println("le jour choisis est " +j.name());
		if (j.ordinal()< Jours.SAMEDI.ordinal())
			System.out.println("au boulot");
		else System.out.println("weekend");
				
	}

}
