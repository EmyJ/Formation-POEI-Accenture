package fr.eni.jpa.demo15.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:12:07
 */
@Entity(name="Personne15")
@Table(name = "Personne15")
@NamedQueries({@NamedQuery (name="findTous", query="SELECT p FROM Personne15 p"),
    		@NamedQuery (name="findNomCommencePar", query="SELECT p FROM Personne15 p WHERE p.nom LIKE :var"),
    		@NamedQuery (name="findMessieurs", query="SELECT p FROM Personne15 p WHERE p.civilite.cle = 'M'"),
    		})
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @ManyToOne
    private Civilite civilite;

    public Personne() {
    }

    public Personne(String nom, String prenom) {
	setNom(nom);
	setPrenom(prenom);
    }

    public Personne(String nom, String prenom, Civilite civilite) {
	setNom(nom);
	setPrenom(prenom);
	setCivilite(civilite);
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

    public Civilite getCivilite() {
	return civilite;
    }

    public void setCivilite(Civilite civilite) {
	this.civilite = civilite;
    }

    @Override
    public String toString() {
	return "Personne " + id + ", " + civilite.getCle() + " " + nom + " " + prenom;
    }
}
