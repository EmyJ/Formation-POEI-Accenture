package exercice3;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Projet {
	private String nom;
	private GregorianCalendar debut;
	private GregorianCalendar fin;
	private double prixFactureeMO;
	private ArrayList<Mission> missions;

	public Projet(String leNom, GregorianCalendar leDebut, GregorianCalendar laFin, double lePrixFactureMo,ArrayList<Mission> lesMissions)  {
		// TODO Auto-generated constructor stub
		this.nom = leNom;
		this.debut = leDebut;
		this.fin = laFin;
		this.prixFactureeMO = lePrixFactureMo;
		this.missions = lesMissions;
	}



	private double cumulCoutMo() 
	{ 
	// calcul le cumul du coût en fonction de chacune des mission et du taux horaire de 	//l'intervenant de la mission 
	//pour chaque mission = taux horaire intervenant * nbheuremission 
	//retourne le cumul du coût
		double cumulC=0;
		   for(Mission m : missions) {
	            cumulC=cumulC+(m.getExecutant().getTaux()*m.nbHeuresEffectues());
	        }
		return cumulC;
	} 
	public double margeBruteCourante() 
	{ 
	// retourne le prix facture du projet (variable) - le cumul du coût des missions (méthode) 
	// le prix facture est une variable de la classe alors que le coût des missions est une méthode 
	// de la classe
		double margeB=0;
		margeB=this.prixFactureeMO-this.cumulCoutMo();
		return margeB;
	}

	@Override
	public String toString() {
		return "Projet [nom=" + nom + ", debut=" + debut + ", fin=" + fin + ", prixFactureeMO=" + prixFactureeMO
				+"]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public GregorianCalendar getDebut() {
		return debut;
	}

	public void setDebut(GregorianCalendar debut) {
		this.debut = debut;
	}

	public GregorianCalendar getFin() {
		return fin;
	}

	public void setFin(GregorianCalendar fin) {
		this.fin = fin;
	}

	public double getPrixFactureeMO() {
		return prixFactureeMO;
	}

	public void setPrixFactureeMO(double prixFactureeMO) {
		this.prixFactureeMO = prixFactureeMO;
	}

	public ArrayList<Mission> getMissions() {
		return missions;
	}

	public void setMissions(ArrayList<Mission> missions) {
		this.missions = missions;
	} 

}