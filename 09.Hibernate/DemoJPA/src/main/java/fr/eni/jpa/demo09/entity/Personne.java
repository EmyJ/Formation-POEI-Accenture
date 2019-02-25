package fr.eni.jpa.demo09.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:12:07
 */
@Entity(name = "PersonneMTO")
@Table(name = "PersonneMTO")
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Personne " + id + ", " + civilite.getCle() + " " + nom + " " + prenom;
    }
}
