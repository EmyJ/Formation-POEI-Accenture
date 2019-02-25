package fr.eni.jpa.demo13.entity.single;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 15:08:02
 */
@Entity(name="JoinedVoitureEntity")
@Table(name="JoinedVoiture")
@DiscriminatorColumn(name="DISCR")
@DiscriminatorValue(value="V")
@Inheritance(strategy=InheritanceType.JOINED)
public class Voiture {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String marque;
    
    public Voiture() {
    }
    
    public Voiture(String marque) {
	this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
	return "Voiture " + id + " " + marque;
    }
     
}
