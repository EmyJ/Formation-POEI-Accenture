/**
 * 
 */
package fr.eni.centreculturel.model;

import java.util.Date;

/**
 * @author bmartin
 *
 */
public class Piste {
	private int numero;
	private String intitule;
	private Date duree;
	/**
	 * @param numero
	 * @param intitule
	 * @param duree
	 */
	public Piste(int numero, String intitule, Date duree) {
		this.numero = numero;
		this.intitule = intitule;
		this.duree = duree;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Piste [numero=%s, intitule=%s, duree=%s]\n",
				numero, intitule, duree);
	}
	
	
}
