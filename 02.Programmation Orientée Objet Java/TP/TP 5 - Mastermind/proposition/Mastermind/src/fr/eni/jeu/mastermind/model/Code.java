package fr.eni.jeu.mastermind.model;

public abstract class Code 
{
	public static final int NBPIONS = 4;
	
	Pion[] pions;


	public Pion getPion(int indice) {
		return pions[indice];
	}
	
	
	public String toString() {
		String lstColor = "";
		for (int i = 0; i < NBPIONS; i++)
			lstColor += pions[i].toString() + " , ";
		return lstColor;
	}


	/**
	 * Vérifier si la couleur est déjà traitée
	 */

	/*private boolean estDansListe(int valeur, int[] tableau) 
	{
		for (int i = 0; i < tableau.length; i++) 
		{
			if (tableau[i] == valeur)
				return true;
		}
		return false;
	}
	*/
	
	/**
	* Méthode qui compare 2 codes et retourne un tableau d'entiers
	* Le 1er élément du tableau correspond au nombre de Pions bien placés, le 2ème
	* au nombre de pions existants mais mals placés.
	* @param unCode Le Code à comparer.
	* @exception ExceptionJeu Si les deux Codes n'ont pas la m�me longueur.
	*/
	public int[] comparer(Code unCode) {
	
	    int[] tabResultat={0,0};
	    int i;
	
	    boolean[] PionsDejaTraite1 = new boolean[NBPIONS];
	    boolean[] PionsDejaTraite2 = new boolean[NBPIONS];
	    for(i = 0;i < NBPIONS; i++)
	    {
	    	PionsDejaTraite1[i] = false;
			PionsDejaTraite2[i] = false;
	    }
	    Pion pionSecret;
	    Pion pionEssai;
	
	    //Recherche des Pions bien placés
	    for(i = 0; i < NBPIONS; i++)
	    {
	      pionEssai = this.getPion(i);
	      pionSecret = unCode.getPion(i);
			  if (pionEssai.equals(pionSecret))
			  {
				tabResultat[0]++;
			    PionsDejaTraite1[i] = true;
			    PionsDejaTraite2[i] = true;
	      	  }
	    }
	
	    for(i = 0; i < NBPIONS; i++)
	    {
	   		if(!PionsDejaTraite1[i])
	   		{
	      		pionEssai = this.getPion(i);
	      		for (int j = 0; j < NBPIONS; j++)
	      		{
		      		if(!PionsDejaTraite2[j])
		      		{
			      		pionSecret = unCode.getPion(j);
		      	  		if (pionEssai.equals(pionSecret))
		      	  		{
				      		tabResultat[1]++;
			          		PionsDejaTraite2[j] = true;
			          		PionsDejaTraite1[i] = true;
		          		}
		      		}
	      		}
	    	}
	    }
	    return tabResultat;
	  }
	
}

