package fr.eni.jpa.methode1.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Classe en charge
 * 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 10:21:24
 */
@Entity(name="Personne1")
@IdClass(PersonnePK.class)
@Table(name = "PERSONNE_PK_1")
public class Personne {

    @Id
    private String nom;

    @Id
    private String prenom;

    
    @Temporal(TemporalType.DATE)
    private Calendar dateNaissance;

    @Transient 
    private int age;

    public Personne() {
	setDateNaissance(null);
    }
    public Personne(String nom, String prenom, GregorianCalendar dateNaissance) {
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaissance = dateNaissance;
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
    
    public Calendar getDateNaissance() {
        return dateNaissance;
    }
    
    public void setDateNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
	return prenom + " " + nom;
    }
}
