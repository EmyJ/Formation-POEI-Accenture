
public abstract class Vehicule {
	//Attributs
	private String marque;
	private String nom;
	private String carburant;
	private int vitesse;
	private Boolean neuf;
	
	//Constructeurs
	
	//Constructeur public
	public Vehicule() {
		super();
	}
	
	
	
	
	//this() => Appel au constructeur par défaut de la même classe
	public Vehicule(String marque, String nom, String carburant, int vitesse) {
		this();
		this.marque = marque;
		this.nom = nom;
		this.carburant = carburant;
		this.vitesse = vitesse;
	}





	//Accesseurs
	public String getMarque() {
		return marque;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCarburant() {
		return carburant;
	}
	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public Boolean getNeuf() {
		return neuf;
	}
	public void setNeuf(Boolean neuf) {
		this.neuf = neuf;
	}



	//Surcharge de toString
	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + ", nom=" + nom + ", carburant=" + carburant + ", vitesse=" + vitesse
				+ ", neuf=" + neuf + "]";
	}
	
	
	
	public void Demarrer() {
		System.out.println("Le véhicule démarre !");
	}
	
	private void Arreter() {
		System.out.println("Le véhicule s'arrête !");
	}
	
	protected void Avancer() {
		System.out.println("Le véhicule avance !");
	}
	
	
	
	//final => rend la méthode non substituable dans les classes filles
	public final void Detruire() {
		System.out.println("Le véhicule est détruit");
	}
	
	//Méthodes abstraites : Les classes filles sont dans l'obligation d'implémenter ces méthodes
	//On définit juste la signature de la méthode 
	public abstract void Tourner(String direction);
	
	public abstract void Freiner();
	
	public abstract void Accelerer(int km_h);
	
	
	
	
	
	
	
	
	

}
