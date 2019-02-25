package fr.eni.TPSuiviDesRepas.bo;

public class Aliment {

	private String nom;
	private int idAliment;
	
	public Aliment() {
	}

	public Aliment(String nom) {
		this.nom = nom;
	}

	public Aliment(String nom, int idAliment) {
		this.nom = nom;
		this.idAliment = idAliment;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdAliment() {
		return idAliment;
	}

	public void setIdAliment(int idAliment) {
		this.idAliment = idAliment;
	}

	@Override
	public String toString() {
		return "Aliment [nom=" + nom + ", idAliment=" + idAliment + "]";
	}
	
	
}
