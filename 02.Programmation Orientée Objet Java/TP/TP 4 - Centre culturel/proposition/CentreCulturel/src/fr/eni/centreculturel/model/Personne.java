/**
 * 
 */
package fr.eni.centreculturel.model;

/**
 * @author bmartin
 *
 */
public abstract class Personne {

	protected String siteWeb;

	/**
	 * @param siteWeb
	 */
	public Personne() {

	}
	
	/**
	 * @param siteWeb
	 */
	public Personne(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [");
		if (siteWeb != null) {
			builder.append("siteWeb=");
			builder.append(siteWeb);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
