package exercice3;

public class Intervenant {
	private String nom;
	private double taux;

	public Intervenant(String nom, double taux) {
		this.nom = nom;
		this.taux = taux;
	}
	public String toString() {
		return "Intervenant [nom=" + nom + ", taux=" + taux + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
