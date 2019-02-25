/**
 * 
 */
package fr.eni.rallye.model;

/**
 * @author bmartin
 *
 */
public class Equipage {
	private int dossard;
	private Concurrent pilote;
	private Concurrent copilote;
	/**
	 * @param dossard
	 * @param pilote
	 * @param copilote
	 */
	public Equipage(int dossard, String nomPilote, String prenomPilote, String nationalitePilote, 
								String nomCopilote, String prenomCopilote, String nationaliteCopilote) {
		this.dossard = dossard;
		this.pilote = new Concurrent(nomPilote,prenomPilote,nationalitePilote);
		this.copilote = new Concurrent(nomCopilote,prenomCopilote,nationaliteCopilote);
	}
	
	
	/**
	 * @return the dossard
	 */
	public final int getDossard() {
		return dossard;
	}


	public String infosEquipage() {
		
		return String.format("Equipage [dossard=%s]\n\t\t%s\t\t%s", dossard, pilote.infosConcurrent(), copilote.infosConcurrent());
	}
	
	
	
}
