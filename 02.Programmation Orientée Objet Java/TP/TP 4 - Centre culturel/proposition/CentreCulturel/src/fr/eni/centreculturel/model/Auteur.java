/**
 * 
 */
package fr.eni.centreculturel.model;

/**
 * @author bmartin
 *
 */
public class Auteur extends Personne{
	private String nom;
	private String prenom;
	private String twitter;
	/**
	 * @param nom
	 * @param prenom
	 */
	public Auteur(String nom, String prenom) throws RuntimeException{
		if (nom == null || nom.isEmpty() || prenom == null || prenom.isEmpty())
			throw new RuntimeException("Le nom et prenom de l'auteur sont obligatoires");
		this.nom = nom;
		this.prenom = prenom;
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param mail
	 */
	public Auteur(String nom, String prenom, String twitter) throws RuntimeException {
		this(nom, prenom);
		this.twitter = twitter;
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param siteWeb
	 */
	public Auteur(String nom, String prenom, String twitter, String siteWeb) throws RuntimeException {
		this(nom,prenom,twitter);
		this.siteWeb = siteWeb;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auteur [");
		
		builder.append("nom=");
		builder.append(nom);
		builder.append(", ");
	
		builder.append("prenom=");
		builder.append(prenom);
		builder.append(", ");
		
		if (twitter != null) {
			builder.append("twitter=");
			builder.append(twitter);
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
