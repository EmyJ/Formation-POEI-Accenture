package exercice2;

import java.awt.Color;

public class TestVoiture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Voiture uneVoiture = new Voiture(123, "55AZ3344", "Renault", new Color(25,18,19), 2017);
		System.out.println("La voiture sort de l'usine, elle a les attibuts suivants :"+uneVoiture);
		Individu am = new Individu("Aurelien","Martineau");
		uneVoiture.setProprietaire(am);
		System.out.println("La voiture a ete achetee par un proprietaire,elle a maintenant les attibuts suivants :"+uneVoiture);
	}

}
