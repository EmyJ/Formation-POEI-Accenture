package fr.eni.papeterie.bo;

public class Stylo extends Article {
	private String couleur;

	public Stylo() {
	}

	public Stylo(Integer idArticle, String marque, String ref, String designation, float pu, int qte, String couleur, int version)  {
		super(  idArticle, marque, ref, designation, pu, qte, version);
		setCouleur(couleur);
	}
	
	public Stylo( String marque, String ref, String designation, float pu, int qte, String couleur, int version)  {
		super(  marque, ref, designation, pu, qte, version);
		setCouleur(couleur);
	}


	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		String s = String.format("%s Stylo [Couleur=%s]", super.toString(), getCouleur());

		return s;
	}
}
