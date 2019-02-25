/**
 * 
 */
package fr.eni.rallye.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bmartin
 *
 */
public class Resultat {
	private Equipage equipage;
	private Speciale speciale;
	private Date temps;
	/**
	 * @param equipage
	 * @param speciale
	 * @param temps
	 */
	public Resultat(Equipage equipage, Speciale speciale, Date temps) {
		this.equipage = equipage;
		this.speciale = speciale;
		this.temps = temps;
		
		this.speciale.ajouterResultat(this);
		
	}

	public String infosResultat() {
		SimpleDateFormat formatter = new SimpleDateFormat("mm:ss sss");
		return String.format("Resultat [speciale=%s, equipage=%s, temps=%s]\n", speciale.infosSpeciale(), equipage.infosEquipage(),
				formatter.format(temps));
	}

	public Date getTemps(){
		return temps;
	}
	
	public Equipage getEquipage(){
		return equipage;
	}
	
	public Speciale getSpeciale(){
		return speciale;
	}
	
}
