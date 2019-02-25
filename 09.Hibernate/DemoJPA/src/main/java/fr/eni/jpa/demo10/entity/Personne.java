package fr.eni.jpa.demo10.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:12:07
 */
@Entity(name = "PersonneMTM")
@Table(name = "PersonneMTM")
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="PersonnePays", 
    		joinColumns= {@JoinColumn(name="personneId")},
	    	inverseJoinColumns= {@JoinColumn(name="paysId")}
	    	)
    private List<Pays> paysVisites = new ArrayList<>();

    public Personne() {
	setPaysVisites(null);
    }

    public Personne(String nom, String prenom) {
	setNom(nom);
	setPrenom(prenom);
	setPaysVisites(null);
    }

    public Personne(String nom, String prenom, List<Pays> paysVisites) {
	setNom(nom);
	setPrenom(prenom);
	setPaysVisites(paysVisites);
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

    public List<Pays> getPaysVisites() {
        return paysVisites;
    }

    public void setPaysVisites(List<Pays> paysVisites) {
	if (this.paysVisites == null) {
	    this.paysVisites = paysVisites;
	} else {
	    this.paysVisites.clear();
	}
    }
    
    public void addPaysVisites(Pays pays) {
	List<Pays> listeP = getPaysVisites();
	listeP.add(pays);
    }

    public void removePaysVisite(Pays pays) {
	List<Pays> listeP = getPaysVisites();
	listeP.remove(pays);
    }
    
    @Override
    public String toString() {
	return "Personne " + id + ", " + nom + " " + prenom + " à Visité : " + paysVisites;
    }

    
    

    

    
}
