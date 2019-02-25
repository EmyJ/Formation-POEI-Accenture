/**
 * 
 */
package fr.eni.tpGestionListesCourses.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge de la liste des articles 
 * @author ejezeque2018
 * @version TPGestionListesCourses - V1.0
 * @date 4 févr. 2019 - 16:59:57
 */
public class Liste {

    private int identifiant;
    private String nom;
    List<Article> articles = new ArrayList<>();
    
    /**
     * Constructeur par default.
     */
    public Liste() {
	super();
    }

    /**
     * Constructeur avec nom et liste d'article.
     * @param nom
     * @param articles
     */
    public Liste(String nom, List<Article> articles) {
	super();
	this.nom = nom;
	this.articles = articles;
    }

    /**
     * Constructeur avec tout les parametres.
     * @param identifiant
     * @param nom
     * @param articles
     */
    public Liste(int identifiant, String nom, List<Article> articles) {
	super();
	this.identifiant = identifiant;
	this.nom = nom;
	this.articles = articles;
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
     * Getter pour articles.
     * @return the articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     * Setter pour articles.
     * @param articles the articles to set
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Liste [identifiant=" + identifiant + ", nom=" + nom + ", articles=" + articles + "]";
    }
     
}
