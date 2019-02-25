package editeur;
public class Livre {
	
	private Individu auteur;
	private String titre;
	private float prix;
	private int nbPages;
	private long isbn;
	private int annee;
	
	public Livre() {
	}
	
	public Livre(Individu auteur, String titre, float prix, int nbPages, long isbn, int annee) {
		this.auteur = auteur;
		this.titre = titre;
		this.prix = prix;
		this.nbPages = nbPages;
		this.isbn = isbn;
		this.annee = annee;
	}
	
	public Livre(String titre, int nbPages, long isbn) {
		super();
		this.titre = titre;
		this.nbPages = nbPages;
		this.isbn = isbn;
	}
	
	public Livre(Livre unLivre) {
		this.titre = unLivre.getTitre();
		this.annee = unLivre.getAnnee();
		this.auteur = unLivre.getAuteur();
		this.prix = unLivre.getPrix();
		this.isbn = unLivre.getIsbn();
		this.nbPages = unLivre.getNbPages();
	}
	
	public Individu getAuteur() {
		return auteur;
	}
	public void setAuteur(Individu auteur) {
		this.auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	@Override
	public String toString() {
		return "Livre [auteur=" + auteur + ", titre=" + titre + ", prix=" + prix + ", nbPages=" + nbPages + ", isbn="
				+ isbn + ", annee=" + annee + "]";
	}
		
}
