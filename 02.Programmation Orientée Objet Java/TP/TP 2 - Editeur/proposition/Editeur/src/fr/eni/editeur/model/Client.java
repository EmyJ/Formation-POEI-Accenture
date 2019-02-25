package fr.eni.editeur.model;

public class Client {

    private String nom;
    private String prenom;
    private String adresse;
    private int cp;
    private String ville;
	
    /**
     * Constructeur unique de la classe Client
     * @param nom
     * @param prenom
     * @param adresse
     * @param cp
     * @param ville
     * @throws Exception 
     */
    public Client(String nom, String prenom, String adresse, String cp, String ville) throws Exception {
        //appel aux accesseurs pour appliquer les règles aux données
        setNom(nom); 
        setPrenom(prenom);
        setAdresse(adresse);
        setCodePostal(cp);
        setVille(ville);
    }
    
    
    /*
     * Le nom du client est :
     * 	- obligatoire
     *	- en majuscules
     */
    /**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param value the nom to set
	 * @throws Exception 
	 */
	public void setNom(String value) throws Exception {
		if (value != null && value.trim().length() > 0) {
            this.nom = value.toUpperCase();
        } else {
            throw new Exception("Le nom ne doit pas être vide");
        }
	}
	
	
	/*
	 * Le prenom du client est :
     * 	- chaque première lettre est en majuscule
	 */
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param value the prenom to set
	 */
	public void setPrenom(String value) {
        if (value != null && value.trim().length() > 0) {
            prenom = Client.FirstInUpper(value.trim(), "[-' ]");
        }
	}
	
	
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param value the adresse to set
	 */
	public void setAdresse(String value) {
		this.adresse = value;
	}
	
	
	/*
	 * Le code postal du client est :
     *	- compris entre 1000 et 99999
     *	- toujours présenté sur 5 caractères
	 */
	/**
	 * @return the cp
	 */
	public String getCodePostal() {
		return String.format("%05d",cp);
	}
	/**
	 * @param value the cp to set
	 * @throws Exception 
	 */
	public void setCodePostal(String value) throws Exception {
		int cp = 0;
        try{
        	cp = Integer.parseInt(value);
        	if (cp > 99999 || cp < 1000)
        		throw new Exception("Le code postal est incorrect");
        	this.cp = cp;
        }catch(NumberFormatException e){
        	throw new Exception("le format du code postal est incorrect");
        }
	}
	
	
	/*
	 * La ville du client est :
     * 	- obligatoire
     *	- chaque première lettre est en majuscule
	 */
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 * @throws Exception 
	 */
	public void setVille(String value) throws Exception {
        if (value != null && value.trim().length() > 0) {
            ville = Client.FirstInUpper(value, "[-' ]");
        } else {
            throw new Exception("Le nom de la ville ne peut être vide");
        }
	}
    
	
    /**
     * Retourne l'état d'un Client sous la forme d'une chaine de caractères
     * @return
     */
    public String GetClientToString() {
        return String.format("->\t%s %s\n\t%s\n\t%s %s",getNom(),getPrenom(),getAdresse(),getCodePostal(),getVille());
    }
    
    
    /* 
     * static : la méthode n'est définie qu'une seule fois en mémoire (dans la classe)
     * possible car la méthode ne fait pas directement référence à un objet client.
     */

    /**
     * Chaque première lettre des mots de la chaine est transformé en majuscule.
     * Les séparateurs de mot doivent être précisés.
     * @param chaine
     * @param separateurs
     * @return
     */
    private static String FirstInUpper(String chaine, String separateurs) {
    	
    	char[] prenomOrigine = chaine.toCharArray();
    	char[] prenomFormate = new char[prenomOrigine.length];
    	int pos = 0;
    	Boolean enMaj = true;
    	Boolean sep = false;
    	for (char c : prenomOrigine) {
			//le char est-il un des séparateurs
    		if (separateurs.contains(String.valueOf(c))){
    			sep = true;
    		} else sep=false;
    		//inscrire le caractère dans le prenomFormate
    		if (sep){
    			//si c'est un séparateur, il est inscrit tel quel...
    			prenomFormate[pos]=c;
    			enMaj=true;
    		}else if (enMaj){
    			//si c'est un caractère qui suit un séparateur, inscrit en majuscules...
    			prenomFormate[pos]=Character.toUpperCase(c);
    			enMaj=false;
    		}else {
    			//sinon inscrit en minuscules...
    			prenomFormate[pos]=Character.toLowerCase(c);
    		}
    		pos++;
		}
    	return String.valueOf(prenomFormate);
    	
    }
}
