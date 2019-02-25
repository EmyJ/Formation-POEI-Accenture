package fr.eni.jpa.demo05.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:12:07
 */
@Entity
@Table(name="Personne0T0")
public class Personne {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    private String prenom;
    
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Adresse adresse;
    
    public Personne() {
	
    }

    public Personne(String nom, String prenom, Adresse adresse) {
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Personne " + id + ", nom : " + nom + ", prenom : " + prenom + ", adresse : " + adresse;
    }
    
    
    
}
