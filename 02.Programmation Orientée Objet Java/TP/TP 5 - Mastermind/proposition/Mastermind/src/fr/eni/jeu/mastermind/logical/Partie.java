package fr.eni.jeu.mastermind.logical;

import fr.eni.jeu.mastermind.gui.InterfaceGui;
import fr.eni.jeu.mastermind.model.Code;
import fr.eni.jeu.mastermind.model.CodeEssai;
import fr.eni.jeu.mastermind.model.CodeSecret;


public class Partie 
{
    private int nbEssaiMax;
    
	private InterfaceGui ihm;
	
	private CodeSecret codeSecret=null;
	private int numEssai=1;
    private int tabResultat[];
    
    
    public Partie(int nbEssaiMax, InterfaceGui ihm)
	{
		this.ihm=ihm;
		this.nbEssaiMax = nbEssaiMax;
		tabResultat = new int[nbEssaiMax];
	}
    
    public void jouer(){
    	tirerCodeSecret();
    	afficherCodeSecret(); //a supprimer après test
    	
    	CodeEssai codeEssai=null;
    	/* On joue jusqu'à ce que le joueur saisisse "fin",
		 * ou trouve la combinaison, ou atteint le maximum d'essais
		 */
    	boolean fin=false;  
		while (!fin & (numEssai<=nbEssaiMax)) {
			codeEssai=saisirCodeEssai();
			if(codeEssai==null) {
			    numEssai = numEssai-1;
			    continue;
			}
			
			if(codeEssai.cancel) {
			    fin=true;
			    continue;
			}
			    
			fin=comparerCodes(codeEssai);
		} 
		afficherCodeSecret();
    }
    
    
    private void tirerCodeSecret() {
	    //Génération d'une couleur aléatoire pour chaque Pion
	    codeSecret=new CodeSecret();
    }
    
    private CodeEssai saisirCodeEssai() {
    	CodeEssai essai;
    	essai=ihm.saisirCodeEssai(numEssai, Code.NBPIONS);
    
        numEssai++;
        
        return essai;
      
    }
    
    
    private boolean comparerCodes(CodeEssai essai){
    	
    	tabResultat=codeSecret.comparer(essai);
    	
    	ihm.afficherCodeEssai(essai);
    	ihm.afficherResultatEssai(tabResultat[0],tabResultat[1]);

        if (tabResultat[0]==4)
        	return true;
        else
        	return false;
       
    }
    
    
    private void afficherCodeSecret() {
      	ihm.afficherCodeSecret(codeSecret);	
    }

}    


