package fr.eni.jeu.mastermind.model;

public class Pion {

	
	private int couleur;
	// nombre maximal de couleurs disponibles	
	public final static int MAX_COULEURS = 6;
	// tableau des couleurs autorisées pour un pion
	private final static String[] TAB_NOMS_COULEURS;
	public final static String NOMS_COULEURS;
	
	//bloc d'initialisation des données statiques
	static {
		TAB_NOMS_COULEURS = new String[MAX_COULEURS];
		TAB_NOMS_COULEURS[0] = "rouge";
		TAB_NOMS_COULEURS[1] = "jaune";
		TAB_NOMS_COULEURS[2] = "vert";
		TAB_NOMS_COULEURS[3] = "bleu";
		TAB_NOMS_COULEURS[4] = "noir";
		TAB_NOMS_COULEURS[5] = "blanc";
		
		boolean first = true;
		StringBuffer buffer = new StringBuffer("[");
		for (String string : TAB_NOMS_COULEURS) {
			if (first){
				buffer.append(string);
				first=false;
			}else
				buffer.append(", ").append(string);
		}
		buffer.append("]");
		NOMS_COULEURS = buffer.toString();
	}
	
	public Pion(int numCouleur)
	{
		couleur=numCouleur;
	}


	public Pion(String nomCouleur) {
		for (int i = 0; i < MAX_COULEURS; i++){	
			if (TAB_NOMS_COULEURS[i].equalsIgnoreCase(nomCouleur)) {
				couleur = i;
				return;
			}
		}
	}

	public boolean equals(Pion p) {
		return this.couleur == p.couleur;
	}

	public String toString() {
		return TAB_NOMS_COULEURS[couleur];
	}
}