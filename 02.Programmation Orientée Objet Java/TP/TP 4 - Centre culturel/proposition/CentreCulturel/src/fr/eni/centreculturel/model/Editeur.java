/**
 * 
 */
package fr.eni.centreculturel.model;

/**
 * @author bmartin
 *
 */
public class Editeur extends Personne {
	private String nomGroupe;
	private String adresse;
	/**
	 * @param nomGroupe
	 * @param adresse
	 */
	public Editeur(String nomGroupe, String adresse) throws RuntimeException{
		if (nomGroupe==null || nomGroupe.isEmpty() || adresse==null || adresse.isEmpty())
			throw new RuntimeException("Le nom du groupe et l'adresse de l'editeur sont obligatoires");
		this.nomGroupe = nomGroupe;
		this.adresse = adresse;
	}
	/**
	 * @param nomGroupe
	 * @param adresse
	 * @param siteWeb
	 */
	public Editeur(String nomGroupe, String adresse, String siteWeb) throws RuntimeException{
		this(nomGroupe,adresse);
		super.siteWeb = siteWeb;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Editeur [");

		builder.append("nomGroupe=");
		builder.append(nomGroupe);
		builder.append(", ");

		builder.append("adresse=");
		builder.append(adresse);
		
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
