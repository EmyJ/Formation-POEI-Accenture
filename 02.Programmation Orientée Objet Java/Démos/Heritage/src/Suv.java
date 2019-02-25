
public final class Suv extends Voiture {

	private int nbPortes;

	
	
	//Constructeurs
	public Suv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Suv(String marque, String nom, String carburant, int vitesse, int puissance, int nbPortes) {
		super(marque, nom, carburant, vitesse, puissance);
		this.nbPortes = nbPortes;
	}
	
	
	//Méthodes héritées
	@Override
	public int getPuissance() {
		// TODO Auto-generated method stub
		return super.getPuissance();
	}

	@Override
	public void setPuissance(int puissance) {
		// TODO Auto-generated method stub
		super.setPuissance(puissance);
	}

	@Override
	public void Tourner(String direction) {
		// TODO Auto-generated method stub
		super.Tourner(direction);
	}

	@Override
	public void Freiner() {
		// TODO Auto-generated method stub
		super.Freiner();
	}

	@Override
	public void Accelerer(int km_h) {
		// TODO Auto-generated method stub
		super.Accelerer(km_h);
	}

	@Override
	public void Demarrer() {
		// TODO Auto-generated method stub
		super.Demarrer();
	}

	@Override
	protected void Avancer() {
		// TODO Auto-generated method stub
		super.Avancer();
	}
	
	
	
	
	
	
}
