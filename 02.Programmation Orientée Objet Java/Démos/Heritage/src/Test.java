
public class Test {

	public static void main(String[] args) {
		
		//Impossible d'instancier Véhicule car classe abstraite
		//Vehicule v = new Vehicule();
		
		Voiture v1 = new Voiture("Renault", "Megane", "Essence", 0, 5);
		
		System.out.println(v1.toString());
		
		v1.Demarrer();
		
		v1.Detruire();
		
		v1.Avancer();


	}

}
