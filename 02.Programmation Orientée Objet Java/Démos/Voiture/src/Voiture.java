
public class Voiture {

	// Attributs

	private String marque;
	private String modele;
	private String couleur;
	private int immatriculation;

	// Constructeurs

	public Voiture(String marque, String modele, String couleur, int immatriculation) {
		super();
		setMarque(marque);
		setModele(modele);
		setCouleur(couleur);
		setImmatriculation(immatriculation);
	}

	public Voiture(String marque, String modele, String couleur) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
	}

	// Accesseurs

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		if (marque != "") {
			this.marque = marque;
		}
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(int immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	
	//Méthodes
	
	
	public void Demarrer () {
		System.out.println("Vroum !");
		DemarrerSuite();
	}
	
	private void DemarrerSuite() {
		System.out.println("Appel à fonction privée");
	}
	
	
	
	
	
	
	
	
	
	

}
