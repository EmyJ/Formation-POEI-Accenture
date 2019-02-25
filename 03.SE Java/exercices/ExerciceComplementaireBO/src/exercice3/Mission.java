package exercice3;

import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;


public class Mission {
	private String nom;
	private String description;
	private int nbHeuresPrevues;
	private Hashtable<GregorianCalendar, Integer> releveHoraire=new Hashtable<GregorianCalendar, Integer> ();;
	private Intervenant executant;
	public Mission(String leNom,String laDescription,int leNbreHeuresPrevues,Intervenant lexecutant) {
		// TODO Auto-generated constructor stub
		this.nom = leNom;
		this.description = laDescription;
		this.nbHeuresPrevues = leNbreHeuresPrevues;
		this.executant = lexecutant;
	//	this.releveHoraire= new Hashtable<GregorianCalendar, Integer> ();
	}
	


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Mission [nom=" + nom + ", description=" + description + ", nbHeuresPrevues=" + nbHeuresPrevues
				+ ", executant=" + executant + "]");
		sb.append("\n");
		sb.append("Le relev� horaire :\n");
		for(GregorianCalendar g: releveHoraire.keySet() )
		{
			sb.append("date :"+g.get(GregorianCalendar.DAY_OF_MONTH)+" "+g.getDisplayName(GregorianCalendar
					.MONTH, GregorianCalendar.LONG_FORMAT,
					Locale.FRANCE)+" "+g.get(GregorianCalendar.YEAR));
			sb.append("->"+releveHoraire.get(g)+" Heure(s)\n");
		}
		return sb.toString();
	}



	public Intervenant getExecutant() {
		return executant;
	}



	public void setExecutant(Intervenant executant) {
		this.executant = executant;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbHeuresPrevues() {
		return nbHeuresPrevues;
	}

	public void setNbHeuresPrevues(int nbHeuresPrevues) {
		this.nbHeuresPrevues = nbHeuresPrevues;
	}

	public Hashtable<GregorianCalendar, Integer> getReleveHoraire() {
		return releveHoraire;
	}

	public void setReleveHoraire(Hashtable<GregorianCalendar, Integer> releveHoraire) {
		this.releveHoraire = releveHoraire;
	}

	public void ajoutReleve(GregorianCalendar laDate, int nbreHeures) {
		// TODO Auto-generated method stub
		this.releveHoraire.put(laDate, nbreHeures);
		releveHoraire.get(new GregorianCalendar(2015,1,15));
	}
	public double nbHeuresEffectues() 
	{ 
		double nbHeuresF=0;
/* grâce au tableau releve horaire additionne les nombres d'heures effectuées et retourne le total */
	       for(int heuresM : this.releveHoraire.values()) {
	            nbHeuresF=nbHeuresF+heuresM;
	        }
	       //element similaire
//		for(GregorianCalendar g: releveHoraire.keySet() )
//		{
//			nbHeuresF=nbHeuresF+releveHoraire.get(g);
//		}
		return nbHeuresF;
	} 
	

}