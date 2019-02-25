package exercice3;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AppliSII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Intervenant	am= new Intervenant("Martineau",888.80); 
	Intervenant	gb= new Intervenant("Block",2.18); 

		Mission	mission=new Mission("Prog objet","C'est un truc de fou",35,am);

		mission.ajoutReleve(new GregorianCalendar(2015, 5, 12),3); 
	
		mission.ajoutReleve(new GregorianCalendar(2015, 6, 12),20); 
		mission.ajoutReleve(new GregorianCalendar(2015, 7, 12),18); 
	//	System.out.println(mission);

		Mission	mission2=new Mission("Javascript","C'est un truc de fou",35,gb); 
		mission2.ajoutReleve(new GregorianCalendar(2015, 15, 12),30); 
		mission2.ajoutReleve(new GregorianCalendar(2015, 16, 12),18); 
		mission2.ajoutReleve(new GregorianCalendar(2015, 17, 12),12); 
		ArrayList<Mission> tabMissions = new ArrayList<Mission>();
		tabMissions.add(mission);
		tabMissions.add(mission2);
		
		Projet formationDl=new Projet("Formation DL",new GregorianCalendar(2015, 5, 12),new GregorianCalendar(2015, 5, 12),38000,tabMissions); 
		System.out.println("La marge brute courante du projet est de :"+String.format("%.2f",formationDl.margeBruteCourante())+" euros"); 

	}

}