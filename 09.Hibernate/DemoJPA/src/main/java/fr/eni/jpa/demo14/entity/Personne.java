package fr.eni.jpa.demo14.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 16:42:39
 */
@Entity(name="PersonneC")
@Table(name="PersonneCollection")
public class Personne implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    private String prenom;
    
    @ElementCollection
    @CollectionTable( name = "Sports",
	    		joinColumns = 
	    		@JoinColumn(name="id_spo", referencedColumnName="id"))
    @Column(name = "sport")
    List<String> sports;

    public Personne() {
	super();
    }

    public Personne(String nom, String prenom) {
	super();
	this.nom = nom;
	this.prenom = prenom;
    }

    public Personne(String nom, String prenom, List<String> sports) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.sports = sports;
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

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
	return "Personne " + id + " " + nom + " " + prenom + ", sports : " + sports;
    }
    
    
    
}
