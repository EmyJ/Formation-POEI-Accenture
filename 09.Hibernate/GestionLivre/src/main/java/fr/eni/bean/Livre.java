package fr.eni.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version GestionLivre - V1.0
 * @date 21 févr. 2019 - 14:13:40
 */
@Entity
@Table(name="LivreJPA")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="AUTEUR")
    private String auteur;
    @Column(name="TITRE")
    private String titre;
    @Column(name="NBPAGES")
    private int nbPages;
   
    public Livre() {}

    public Livre(String auteur, String titre, int nbPages) {
	this.auteur = auteur;
	this.titre = titre;
	this.nbPages = nbPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    @Override
    public String toString() {
	return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", nbPages=" + nbPages + "]";
    }

    
  
}
