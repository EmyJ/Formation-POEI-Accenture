
public class Voiture extends Vehicule {

	//Attribut
	private int puissance;

	//Accesseurs
	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	
	//super() => Appel au constructeur parent(Vehicule)
	public Voiture() {
		super();
		
	}

	
	public Voiture(String marque, String nom, String carburant, int vitesse, int puissance) {
		super(marque, nom, carburant, vitesse);
		this.puissance = puissance;
	}
	
	
	

	//Méthodes abstraites de la classe mère
	@Override
	public void Tourner(String direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Freiner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Accelerer(int km_h) {
		// TODO Auto-generated method stub
		
	}

	//super.toString() sert à appeler la méthode toString de la classe mère
	@Override
	public String toString() {
		return "Voiture [puissance=" + puissance + ", getPuissance()=" + getPuissance() + super.toString() + "]";
	}

	
	//Surcharge de la méthode Demarrer de la classe mère
	@Override
	public void Demarrer() {
		System.out.println("On tourne la clé de contact");
		//Appel au corps de la méthode de la classe mère
		//super.Demarrer();
	}

	@Override
	protected void Avancer() {
		// TODO Auto-generated method stub
		super.Avancer();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
