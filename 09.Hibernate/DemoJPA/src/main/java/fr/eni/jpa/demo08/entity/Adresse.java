package fr.eni.jpa.demo08.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:09:48
 */
@Entity(name="Adresse0TMBi")
@Table(name="Adresse0TMBi")
public class Adresse implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String codePostal;
    private String ville;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Personne personne;
    
    public Adresse() {
    }
    
    public Adresse(String codePostal, String ville) {
	super();
	this.codePostal = codePostal;
	this.ville = ville;
    }



    public Adresse(String codePostal, String ville, Personne personne) {
	setCodePostal(codePostal);
	setVille(ville);
	setPersonne(personne);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Adresse " + id + ", code Postal : " + codePostal + ", ville : " + ville;
    }
    
    
}
