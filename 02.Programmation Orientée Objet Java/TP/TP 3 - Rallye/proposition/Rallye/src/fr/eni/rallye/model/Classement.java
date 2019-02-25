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
public class Classement {

	private Equipage equipage;
	private Date cumulTemps;
	
	/**
	 * @param rang
	 * @param equipage
	 * @param cumulTemps
	 */
	public Classement(Equipage equipage, Date cumulTemps) {
		this.equipage = equipage;
		this.cumulTemps = cumulTemps;
	}

	/**
	 * @return the cumulTemps
	 */
	public final Date getCumulTemps() {
		return cumulTemps;
	}

	public String infosClassement() {
		SimpleDateFormat formatter = new SimpleDateFormat("mm:ss sss");
		return String.format("Classement [equipage=%s, temps cumulés=%s]\n", 
				equipage.infosEquipage(),formatter.format(cumulTemps));
	}
	
	
}
