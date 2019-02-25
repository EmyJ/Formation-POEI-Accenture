package fr.eni.jpa.demo15.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 11:03:00
 */
@Entity
@Table(name = "Civilite15")
public class Civilite{

    @Id
    private String cle;
    private String libelle;
    
    public Civilite() {
    }

    public Civilite(String cle, String libelle) {
	super();
	this.cle = cle;
	this.libelle = libelle;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Civilite " + cle + ", libelle = " + libelle;
    }
    
    
}
