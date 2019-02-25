package fr.eni.jpa.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "PERSONNES")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NOM", length=50, nullable=false)
    // nom de colonne = "NOM", NOT NULL, taille 50
    private String nom;

    @Column(name="PRENOM", length=50, nullable=false)
    // nom de colonne = "PRENOM", NOT NULL, taille 50
    private String prenom;

    @Column(name="DATE_NAISS", nullable=true)
    @Temporal(TemporalType.DATE)
    // nom de colonne = "DATE_NAISS"
    private Calendar dateNaissance;

    @Transient
    private int age;
    
    public Personne() {
	
    }

    public Personne(String nom, String prenom, GregorianCalendar dateNaissance) {
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
	return prenom + " " + nom;
    }
}
