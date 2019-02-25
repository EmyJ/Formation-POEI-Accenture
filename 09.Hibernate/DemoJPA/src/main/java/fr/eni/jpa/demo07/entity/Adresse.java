package fr.eni.jpa.demo07.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 19 févr. 2019 - 12:09:48
 */
@Entity(name="Adresse0TM")
@Table(name="Adresse0TM")
public class Adresse {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String codePostal;
    private String ville;
    
    public Adresse() {
    }
    public Adresse(String codePostal, String ville) {
	setCodePostal(codePostal);
	setVille(ville);
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

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Adresse " + id + ", code Postal : " + codePostal + ", ville : " + ville;
    }
    
    
}
