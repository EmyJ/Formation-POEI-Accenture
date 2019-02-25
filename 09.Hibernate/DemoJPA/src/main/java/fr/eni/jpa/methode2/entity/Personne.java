package fr.eni.jpa.methode2.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 11:30:36
 */
@Entity(name="Personne2")
@Table(name="Personne_PK_2")
public class Personne {

    @EmbeddedId
    private PersonnePK personnePk;
    
    @Temporal(TemporalType.DATE)
    private Calendar dateNaissance;
    
    @Transient
    private int age;
    
    public Personne() {
	
    }
    
    /**
     * Constructeur.
     * @param string
     * @param string2
     * @param gregorianCalendar
     */
    public Personne(PersonnePK personnePK, GregorianCalendar dateNaissance) {
	this.personnePk = personnePK;
	this.dateNaissance = dateNaissance;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "" + personnePk ;
    }
    
}
