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
public class Speciale {
	private String nom;
	private Date jour_heure;
	private double distance;
	private Type_Epreuve typeEpreuve;
	
	private Resultat[] resultats;
	private int resultatIndex=0;
	/**
	 * @param jour_heure
	 * @param distance
	 * @param nom
	 */
	public Speciale(String nom, Date jour_heure, double distance, Type_Epreuve typeEpreuve) {
		this.jour_heure = jour_heure;
		this.distance = distance;
		this.nom = nom;
		this.typeEpreuve = typeEpreuve;
		
		resultats = new Resultat[50];
	}
	

	/**
	 * @return the nom
	 */
	public final String getNom() {
		return nom;
	}



	public String infosSpeciale() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return String.format("Speciale [nom=%s, jour_heure=%s, distance=%5.2f, type epreuve=%s]\n",
				nom, formatter.format(jour_heure), distance, typeEpreuve);
	}
	
	void ajouterResultat(Resultat resultat) throws ArrayIndexOutOfBoundsException{
		//évitons les doublons de résultat (le resultat est-il déjà saisi pour cet equipage et cette spéciale)....
		Boolean find = false;
		for (Resultat resul : resultats) {
			if (resul == null) break;
			if (resul.getEquipage().equals(resultat.getEquipage()) && resul.getSpeciale().equals(resultat.getSpeciale())) {
				find = true;
				break;
			}
		}
		if (!find){
			resultats[resultatIndex]=resultat;
			resultatIndex++;
		}
	}
	
	public Resultat[] getClassement(){
		Resultat[] classement = ClassementUtil.classerParTemps(resultats);
		return classement;
	}
	
	
	
	
}
