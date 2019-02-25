/**
 * 
 */
package fr.eni.rallye.model;

/**
 * @author bmartin
 *
 */
public class Concurrent {
	private String nom;
	private String prenom;
	private String nationalite;
	/**
	 * @param nom
	 * @param prenom
	 * @param nationalite
	 */
	public Concurrent(String nom, String prenom, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}
	
	public String infosConcurrent() {
		return String.format("Concurrent [nom=%s, prenom=%s, nationalite=%s]\n",
				nom, prenom, nationalite);
	}
	
	
}
