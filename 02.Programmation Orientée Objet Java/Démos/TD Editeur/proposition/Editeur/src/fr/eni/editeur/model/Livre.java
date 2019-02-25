package fr.eni.editeur.model;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Livre {
	
    private String titre;
	private String auteur;
    private int nbpages;
    private long isbn;
	
    
    /**
     * Constructeur unique de la classe Livre
     * @param pauteur
     * @param ptitre
     * @param pnbpages
     * @param pisbn
     * @throws Exception 
     */
    public Livre(String auteur, String titre, int nbpages, String isbn) throws Exception {
        //appel aux propriétés pour executer les règles de gestion
        setAuteur(auteur);
        setTitre(titre);
        setNbpages(nbpages);
        setIsbn(isbn);
    }
    
    
    /**
	 * @return the titre
	 */
	public final String getTitre() {
		return titre;
	}


	/**
	 * @param titre the titre to set
	 */
	public final void setTitre(String titre) {
		this.titre = titre;
	}


	/*
     * L'auteur du livre est :
     *	- obligatoire
     */
    /**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
	 * @throws Exception 
	 */
	public void setAuteur(String value) throws Exception {
        if (value != null && value.trim().length() > 0) {
            auteur = value;
        } else {
            throw new Exception("le champ auteur doit contenir au moins un caractère");
        }
	}
	
	
	/*
	 *	Le nombre de pages du Livre est :
     *		- strictement supérieur à zéro
	 */
	/**
	 * @return the nbpages
	 */
	public int getNbpages() {
		return nbpages;
	}
	/**
	 * @param nbpages the nbpages to set
	 * @throws Exception 
	 */
	public void setNbpages(int value) throws Exception {
        if (value > 0) {
            nbpages = value;
        } else {
            throw new Exception("nombre de pages positif !");
        }
	}
	
	/*
	 *	La référence isbn du Livre est :
     *		- reçue au format String (13 caractères minimum)
     *		- ne doit contenir que des caractères numériques pour pouvoir être stockée au format long
     *		- livrée au format String "###-#-####-####-#"
     *		- stockée au format long
	 */
	/**
	 * @return the isbn
	 * @throws ParseException 
	 */
	public String getIsbn() throws ParseException {
		MaskFormatter format = new MaskFormatter("###-#-####-####-#");
		format.setValueContainsLiteralCharacters(false);
		return format.valueToString(isbn);
        // 1234567891011 => 123-4-5678-9101-1
	}
	/**
	 * @param isbn the isbn to set
	 * @throws Exception 
	 */
	public void setIsbn(String value) throws Exception {
        if (value != null) {
            //étape 1, replace : 123-4-5678-9101-1 => "1234567891011" 
            String isbnWs = value.replace("-", "");

            //étape 2 : parse : "1234567891011" => 1234567891011
            if (isbnWs.length() != 13) {
                throw new Exception("Le code isbn n'est pas conforme !");
            } else {
            	try {
            		long id = Long.parseLong(isbnWs);
            		isbn = id;
            	}catch (NumberFormatException e){
            		throw new Exception("La composition du code isbn n'est pas correcte !");
            	}
                
            }
        } else {
            throw new Exception("Le code isbn est obligatoire !");
        }
	}
	
	/*
	 *	Le prix du Livre est :
     *		- calculé (pas d'attribut déclaré dans la classe)
	 */
	public double getPrix(){
		return ((getNbpages() * 0.05) + 10);
	}
    
	/**
	 * Retourne l'état d'un Livre sous la forme d'une chaine de caractères
	 * @return
	 * @throws Exception 
	 */
    public String GetLivreToString() throws Exception {
        return String.format("%s, écrit par : %s. \n\tPrix : %5.2f euros. \n\tNuméro ISBN=%s",
            getTitre(), getAuteur(), getPrix(), getIsbn());
    }
    
}
