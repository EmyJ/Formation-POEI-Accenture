package fr.eni.fighters;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 * Cette classe permet de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement
 * quel que soit la couche à l'origine.
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private List<Integer> listeCodesErreur = new ArrayList<>();
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(int code) {
		super();
		ajouterErreur(code);
	}
	
    public BusinessException(int code, Throwable cause) {
        super(cause);
        ajouterErreur(code);
    }
    
	/**
	 * Ajoute une erreur aux erreurs déjà présentes
	 * @param code 	Code de l'erreur. 
	 * 				<br />Un même code ne peut être stocké qu'une seule fois.
	 * 				<br />Doit avoir un message associé dans un fichier properties.
	 */
	public void ajouterErreur(int code)
	{
		if(!this.listeCodesErreur.contains(code))
		{
			this.listeCodesErreur.add(code);
		}
	}
	
	public boolean hasErreurs()
	{
		return this.listeCodesErreur.size()>0;
	}
	
	public List<Integer> getListeCodesErreur()
	{
		return this.listeCodesErreur;
	}
	
	@Override
	public String getMessage() {
		return "Code(s) erreur : " + getListeCodesErreur().toString();
	}

}