package fr.eni.evaluations.bo;


public abstract class Evaluation {
	
	private int noEvaluation;
	private String nom;
	private int duree;
	private Stagiaire stagiaire;
	
	public Evaluation() {
		super();
	}
	
	public Evaluation(int noEvaluation, String nom, int duree) {
		super();
		this.noEvaluation = noEvaluation;
		this.nom = nom;
		this.duree = duree;
	}
	
	public int getNoEvaluation() {
		return noEvaluation;
	}
	public void setNoEvaluation(int noEvaluation) {
		this.noEvaluation = noEvaluation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Evaluation [noEvaluation = " + noEvaluation + ", nom = " + nom + ", duree = " + duree + "]";
	}

}
