/**
 * 
 */
package fr.eni.rallye.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author bmartin
 *
 */
public class Rallye {
	private String pays;
	private Date date;
	
	private Speciale[] speciales;
	private int specialeIndex=0;

	/**
	 * @param date
	 * @param pays
	 */
	public Rallye(String pays, Date date) {
		this.date = date;
		this.pays = pays;
		
		speciales = new Speciale[20];
	}
	
	public void ajouterSpeciale(Speciale speciale) throws IndexOutOfBoundsException{
		speciales[specialeIndex]=speciale;
		specialeIndex++;
	}
	
	public String infosRallye(Boolean inclureSpeciales) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder buffer = new StringBuilder();
		buffer.append(String.format("Rallye [date=%s, pays=%s]\n",formatter.format(date), pays));
		if (inclureSpeciales) {
			for (Speciale speciale : speciales) {
				if (speciale != null)
					buffer.append(String.format("\t%s" , speciale.infosSpeciale()));
			}
		}
		return buffer.toString();
	}

	public Classement[] getClassementGeneral(){
		Resultat[] resultats = null;
		int i = 0;
		//on recupère le détail de tous les résultats
		for (Speciale speciale : speciales) {
			if (speciale == null) break;
			for (Resultat resultat : speciale.getClassement()) {
				if (resultats == null) resultats = new Resultat[1000];
				if (resultat == null) break;
				resultats[i] = resultat;
				i++;
			}
		}
		
		Classement[] classementGeneral=null;
		if (resultats != null){
			//on les classe par Equipage
			resultats = ClassementUtil.classerParEquipape(resultats);
			classementGeneral = new Classement[1000];
			Resultat resultatTmp=null;
			i=0;
			//on effectue le cumul des temps par Equipage toutes spéciales confondues
			Date cumul = null;
			Equipage equipage = null;
			for (Resultat resultat : resultats) {
				if (resultat == null && classementGeneral.length > 0)
					//on traite le dernier classé avant de sortir
					classementGeneral[i] = new Classement(resultatTmp.getEquipage(),cumul);
				if (resultat == null) break;
				if (equipage == null) equipage = resultat.getEquipage();
				//sommes nous toujours sur le même équipage
				if (equipage.equals(resultat.getEquipage())){
					//oui, nous cumulons ses temps
					if (cumul == null) cumul = new GregorianCalendar(0,0,0,0,0,0).getTime();
					cumul = new Date(cumul.getTime() + resultat.getTemps().getTime());
				}else {
					//non,
					//on stocke le classement
					classementGeneral[i] = new Classement(resultatTmp.getEquipage(),cumul);
					//on passe à l'equipage suivant
					equipage = resultat.getEquipage();
					cumul = new GregorianCalendar(0,0,0,0,0,0).getTime();
					cumul = new Date(cumul.getTime() + resultat.getTemps().getTime());
					i++;
				}
				resultatTmp = resultat;
			}
			//on trie le classement final
			classementGeneral = ClassementUtil.classerParTemps(classementGeneral);
		}
		return classementGeneral;
	}

	public Speciale getSpeciale(String nom){
		Speciale find = null;
		for (Speciale speciale : speciales) {
			if (speciale != null && speciale.getNom().equals(nom)){
				find = speciale;
				break;
			}
		}
		return find;
	}

	
	
	
	
}
