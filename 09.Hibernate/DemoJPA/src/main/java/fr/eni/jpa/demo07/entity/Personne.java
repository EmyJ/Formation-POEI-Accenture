package fr.eni.jpa.demo07.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:12:07
 */
@Entity(name = "Personne0TM")
@Table(name = "Personne0TM")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "Personne_id")
    private List<Adresse> listeAdresses;

    public Personne() {
	setListeAdresses(null);
    }

    public Personne(String nom, String prenom, List<Adresse> listeAdresses) {
	setNom(nom);
	setPrenom(prenom);
	setListeAdresses(listeAdresses);

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

    public List<Adresse> getListeAdresses() {
	return listeAdresses;
    }

    public void setListeAdresses(List<Adresse> listeAdresses) {
	if (this.listeAdresses == null) {
	    this.listeAdresses = listeAdresses;
	} else {
	    this.listeAdresses.retainAll(listeAdresses);
	    this.listeAdresses.addAll(listeAdresses);
	}
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Personne " + id + ", nom : " + nom + ", prenom : " + prenom + ", adresse : " + listeAdresses;
    }

}
