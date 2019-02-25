/**
 * 
 */
package fr.eni.tpGestionListesCourses.bo;

/**
 * Classe en charge des articles
 * @author ejezeque2018
 * @version TPGestionListesCourses - V1.0
 * @date 4 févr. 2019 - 16:57:52
 */
public class Article {
    
    private int identifiant;
    private String nom;
    
    /**
     * Constructeur par default.
     */
    public Article() {
	super();
    }

    /**
     * Constructeur avec 1 parametre.
     * @param nom
     */
    public Article(String nom) {
	super();
	this.nom = nom;
    }

    /**
     * Constructeur avec 2 parametre.
     * @param identifiant
     * @param nom
     */
    public Article(int identifiant, String nom) {
	super();
	this.identifiant = identifiant;
	this.nom = nom;
    }

    /**
     * Getter pour identifiant.
     * @return the identifiant
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Setter pour identifiant.
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * Getter pour nom.
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour nom.
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return nom ;
    }
      
}
